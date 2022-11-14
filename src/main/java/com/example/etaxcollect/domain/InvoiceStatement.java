package com.example.etaxcollect.domain;

import org.springframework.core.convert.converter.Converter;
import org.springframework.http.HttpHeaders;
import org.springframework.util.MultiValueMap;

/**
 * @author chensong
 * @date 2022/11/10 15:31
 */
public interface InvoiceStatement {

    HttpHeaders initHeaders();

    /**
     * 所属地区
     *
     * @return
     */
    ETaxArea area();

    /**
     * 采集的发票种类
     *
     * @return
     */
    ETaxInvoiceType invoiceType();

    /**
     * 进销项
     *
     * @return
     */
    ETaxDirection direction();

    /**
     * 采集发票状态
     *
     * @return
     */
    String invoiceState();

    /**
     * 列表接口
     *
     * @return
     */
    String listInterface();

    /**
     * 列表接口参数
     *
     * @return
     */
    MultiValueMap<String, String> listInterfaceParams();

    /**
     * 详情接口
     *
     * @return
     */
    String detailInterface();

    /**
     * 详情接口参数
     *
     * @return
     */
    String detailInterfaceParams(InvoiceKey invoiceKey);


    Converter<String, StandardInvoiceBean> converter();


}
