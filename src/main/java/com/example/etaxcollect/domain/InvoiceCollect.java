package com.example.etaxcollect.domain;

import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author chensong
 * @date 2022/11/10 15:31
 */
public interface InvoiceCollect {

    RestTemplate REST_TEMPLATE = new RestTemplate();

    List<InvoiceKey> split();

    void loop(String invoiceType, String direction, List<InvoiceKey> invoiceKeys);

    List<StandardInvoiceBean> collect();
}
