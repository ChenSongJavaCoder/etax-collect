package com.example.etaxcollect.domain;

import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.time.YearMonth;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

/**
 * @author chensong
 * @date 2022/11/10 16:06
 */
public abstract class AbstractInvoiceCollectContext implements InvoiceCollect, InvoiceStatement {
    /**
     * COOKIE
     */
    protected String cookie;
    /**
     * 数据月份
     */
    protected YearMonth yearMonth;


    public AbstractInvoiceCollectContext(String cookie, YearMonth yearMonth) {
        this.cookie = cookie;
        this.yearMonth = yearMonth;
    }

    public HttpHeaders initHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Cookie", cookie);
        return headers;
    }

    public List<InvoiceKey> split() {
        List<InvoiceKey> invoiceKeys = new CopyOnWriteArrayList<>();
        invoiceType().invoiceTypes().keySet().forEach(type -> {
            direction().direction().keySet().forEach(d -> {
                loop(type, d, invoiceKeys);
            });
        });
        return invoiceKeys;
    }


    public List<StandardInvoiceBean> collect() {
        HttpHeaders headers = initHeaders();
        HttpEntity entity = new HttpEntity(headers);
        return split().stream().map(p -> {
                    ResponseEntity<String> dr = REST_TEMPLATE.exchange(detailInterface(), HttpMethod.GET, entity, String.class, detailInterfaceParams(p));
                    String body = dr.getBody();
                    return converter().convert(body);
                }
        ).collect(Collectors.toList());
    }
}
