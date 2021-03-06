package com.trace.trace.util;

import com.trace.trace.dao.TraceRedisDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
@Slf4j
public class CreateTraceCode {

    @Autowired
    TraceRedisDao traceRedisDao;

    /**
     * 输入第一次流程信息时生成溯源码
     *
     * @param pname
     * @param company_name
     * @return
     */
    public String getTraceCode(String pname, String company_name) {
        StringBuilder traceCode = new StringBuilder();
        String productCode = traceRedisDao.getProductCode(pname, company_name);
        traceCode.append(productCode);
        String now = new SimpleDateFormat("yyMMddHHmmss").format(new Date());
        traceCode.append(now);
        log.info("traceCode:" + traceCode);
        return traceCode.toString();
    }
}
