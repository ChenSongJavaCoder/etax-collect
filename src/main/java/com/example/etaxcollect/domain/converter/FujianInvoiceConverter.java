package com.example.etaxcollect.domain.converter;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.example.etaxcollect.domain.StandardInvoiceBean;
import com.example.etaxcollect.domain.fujian.FujianDR;
import org.springframework.core.convert.converter.Converter;

/**
 * @author chensong
 * @date 2022/11/11 13:11
 */
public class FujianInvoiceConverter implements Converter<String, StandardInvoiceBean> {

    @Override
    public StandardInvoiceBean convert(String source) {
        if (StrUtil.isEmpty(source)) {
            return null;
        }
        FujianDR dr = JSONUtil.toBean(source, FujianDR.class);
        return new StandardInvoiceBean().setData(dr);
    }
}
