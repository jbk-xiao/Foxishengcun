package com.trace.trace.service;

import com.trace.trace.grpc.ChartsRequestByString;
import com.trace.trace.grpc.QueryResponse;
import com.trace.trace.grpc.SearchChartsServiceGrpc;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import org.lognet.springboot.grpc.GRpcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author Zenglr
 * @program: FoXiShengCun
 * @packagename: com.trace.trace.service
 * @Description
 * @create 2021-02-07-8:58 下午
 */
@GRpcService
@Slf4j
@Service
public class SearchChartsServiceImpl extends SearchChartsServiceGrpc.SearchChartsServiceImplBase {

    final SearchCharts searchCharts;

    @Autowired
    public SearchChartsServiceImpl(SearchCharts searchCharts) {
        this.searchCharts = searchCharts;
    }

    /**
     * 取出前端需求的预测曲线的json内容。
     *
     * @param request          包含公司名称的grpc请求。
     * @param responseObserver StreamObserver<QueryResponse>
     */
    @Override
    public void getPredict(ChartsRequestByString request, StreamObserver<QueryResponse> responseObserver) {
        String companyName = request.getChartsStrRequest();
        log.info("getPredict: {}", companyName);
        String predictData = searchCharts.getPredictData(companyName);
        log.info("getPredict response: {}", predictData);
        QueryResponse response = QueryResponse.newBuilder().setResponse(predictData).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    /**
     * 取出企业的新闻标题和链接的url并返回。
     *
     * @param request          包含公司名称的grpc请求。
     * @param responseObserver StreamObserver<QueryResponse>
     */
    @Override
    public void getNews(ChartsRequestByString request, StreamObserver<QueryResponse> responseObserver) {
        String companyName = request.getChartsStrRequest();
        log.info("getNews: {}", companyName);
        String newsData = searchCharts.getNewsData(companyName);
        log.info("getNews response: {}", newsData);
        QueryResponse response = QueryResponse.newBuilder().setResponse(newsData).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    /**
     * 取出年龄和性别分布指数
     *
     * @param request          关键词
     * @param responseObserver StreamObserver<QueryResponse>
     */
    @Override
    public void getAgeDistribution(ChartsRequestByString request, StreamObserver<QueryResponse> responseObserver) {
        String keyword = request.getChartsStrRequest();
        log.info("getAgeDistribution: {}", keyword);
        String ageDistributionData = searchCharts.getAgeDistribution(keyword);
        log.info("getAgeDistribution: {}", ageDistributionData);
        QueryResponse response = QueryResponse.newBuilder().setResponse(ageDistributionData).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    /**
     * 取出省份分布指数
     *
     * @param request          关键词
     * @param responseObserver StreamObserver
     */
    @Override
    public void getProvinceIndex(ChartsRequestByString request, StreamObserver<QueryResponse> responseObserver) {
        String keyword = request.getChartsStrRequest();
        log.info("getProvinceIndex: {}", keyword);
        String provinceIndex = searchCharts.getProvinceIndex(keyword);
        log.info("getProvinceIndex: {}", provinceIndex);
        QueryResponse response = QueryResponse.newBuilder().setResponse(provinceIndex).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    /**
     * 获取相关关键词关联检索气泡图所需数据
     * @param request           带有关键词的ChartsRequestByString
     * @param responseObserver  StreamObserver
     */
    @Override
    public void getRelateSearch(ChartsRequestByString request, StreamObserver<QueryResponse> responseObserver) {
        String keyword = request.getChartsStrRequest();
        log.info("getRelateSearch: {}", keyword);
        String provinceIndex = searchCharts.getRelateSearch(keyword);
        log.info("getRelateSearch: {}", provinceIndex);
        QueryResponse response = QueryResponse.newBuilder().setResponse(provinceIndex).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    /**
     * 获取关键词的百度指数预测结果。
     *
     * @param request          关键词
     * @param responseObserver StreamObserver
     */
    @Override
    public void getIndexPredict(ChartsRequestByString request, StreamObserver<QueryResponse> responseObserver) {
        String keyword = request.getChartsStrRequest();
        log.info("getIndexPredict: {}", keyword);
        String indexPredict = searchCharts.getIndexPredict(keyword);
        log.info("getIndexPredict: {}", indexPredict);
        QueryResponse response = QueryResponse.newBuilder().setResponse(indexPredict).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}