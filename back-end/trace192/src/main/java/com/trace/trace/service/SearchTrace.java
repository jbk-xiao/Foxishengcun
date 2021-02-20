package com.trace.trace.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.protobuf.ByteString;
import com.trace.trace.dao.CompetMongoDao;
import com.trace.trace.dao.FabricDao;
import com.trace.trace.dao.ProcessEventDao;
import com.trace.trace.dao.ProductRedisDao;
import com.trace.trace.entity.CompanyInfo;
import com.trace.trace.grpc.QueryRequest;
import com.trace.trace.grpc.TraceResponse;
import com.trace.trace.mapper.CompetMapper;
import com.trace.trace.util.media.FileUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;

/**
 * @author Zenglr
 * @program: FoXiShengCun
 * @packagename: com.trace.trace.service
 * @Description 溯源模块
 * @create 2021-02-07-7:57 下午
 */
@Component
@Slf4j
public class SearchTrace {

    private final Gson gson = new GsonBuilder().disableHtmlEscaping().create();  //防止出现字符转换

    private final ProcessEventDao processEventDao;

    private final FabricDao fabricDao;

    private final FileUtil fileUtil;

    private final ProductRedisDao productRedisDao;

    private final CompetMapper competMapper;

    @Autowired
    public SearchTrace(ProcessEventDao processEventDao, FabricDao fabricDao, FileUtil fileUtil, ProductRedisDao productRedisDao, CompetMapper competMapper) {
        this.processEventDao = processEventDao;
        this.fabricDao = fabricDao;
        this.fileUtil = fileUtil;
        this.productRedisDao = productRedisDao;
        this.competMapper = competMapper;
    }

    public TraceResponse searchTrace(QueryRequest request) {

        //获取请求类型和请求内容
        String queryType = request.getQueryType();
        String query = request.getQuery();
        log.info("Receive queryType = " + queryType + ", query = " + query);

        //返回结果为字符串jsonInfo或ByteString mediaData
        String jsonInfo = "";
        ByteString mediaData = ByteString.EMPTY;
        boolean isString = true;

        switch (queryType) {
            case "video":
                //视频访问
                isString = false;
                log.info("Encoding video '" + query + "'...");
                mediaData = ByteString.copyFrom(fileUtil.getBytesFromVideo(query));
                break;
            case "picture":
                //图片访问
                isString = false;
                log.info("Encoding picture '" + query + "'...");
                mediaData = ByteString.copyFrom(fileUtil.getBytesFromPicture(query));
                break;
            case "event":
                //生产线“最近动态”列表
                int page = Integer.parseInt(request.getPage());
                List<Long> timeList = processEventDao.getEventTitleListOnPage(query, page);
                jsonInfo = gson.toJson(timeList);
                break;
            case "origin":
                //依据溯源id查询流水线信息
                log.info("Searching '" + query + "' in fabric.");
                jsonInfo = fabricDao.getInfoByOriginId(query);
                log.info("Fabric return: " + jsonInfo);
                break;
            case "addFirstProcess":
                jsonInfo = addFirstProcess(query);
                break;
            case "addProcess":
                //添加一道流程信息
                long start = System.currentTimeMillis();
                jsonInfo = addProcess(query);
                log.info("192 add process takes {} ms", System.currentTimeMillis() - start);
                break;
            case "addProcedure":
                //添加工厂内一道工序信息
                start = System.currentTimeMillis();
                jsonInfo = addProcedure(query);
                log.info("192 add procedure takes {} ms", System.currentTimeMillis() - start);
                break;
            default:
                log.error("Receive the wrong message!");
                break;
        }
        return (isString
            ? TraceResponse.newBuilder().setResponse(jsonInfo)
            : TraceResponse.newBuilder().setResponseMedia(mediaData)
        ).build();
    }

    private String addFirstProcess(String params) {
        HashMap<String, String> map = gson.fromJson(params, new TypeToken<HashMap<String, String>>() {}.getType());
        return fabricDao.addFirstProcess(map.get("foodType"), map.get("com"), Integer.parseInt(map.get("processCount")),
                map.get("name"), map.get("master"), map.get("location"));
    }

    private String addProcess(String params) {
        HashMap<String, String> map = gson.fromJson(params, new TypeToken<HashMap<String, String>>() {}.getType());
        return fabricDao.addProcess(map.get("id"), map.get("name"), map.get("master"), map.get("location"));
    }

    private String addProcedure(String params) {
        HashMap<String, String> map = gson.fromJson(params, new TypeToken<HashMap<String, String>>() {}.getType());
        return fabricDao.addProcedure(map.get("id"), map.get("name"), map.get("master"));
    }

    /**
     * 获取到第一次流程输入时所需的公司基本信息以及商品列表
     * @param regis_id
     * @return
     */
    public String getFirstProcessInfo(String regis_id){
        List<String> productNameList = productRedisDao.getAllProductName(regis_id);
        CompanyInfo companyInfo = competMapper.selectCompanyBasicInfo(regis_id);
        StringBuilder sb = new StringBuilder();
        sb.append(gson.toJson(companyInfo));
        sb.deleteCharAt(sb.length() - 1);
        sb.append("\"productNameList\":");
        sb.append(",");
        sb.append(productNameList.toString());
        sb.append("}");
        return sb.toString();
    }
}
