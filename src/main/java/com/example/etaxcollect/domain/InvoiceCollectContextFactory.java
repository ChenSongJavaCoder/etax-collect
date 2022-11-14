package com.example.etaxcollect.domain;

import com.example.etaxcollect.domain.fujian.FujianInvoiceCollectContext;
import org.springframework.stereotype.Component;

import java.time.YearMonth;

/**
 * @author chensong
 * @date 2022/11/11 10:52
 */
@Component
public class InvoiceCollectContextFactory {

    public InvoiceCollect build(ETaxArea area, String cookie, YearMonth yearMonth) {
        switch (area) {
            case F_J:
                return new FujianInvoiceCollectContext(cookie, yearMonth);

            default:
                throw new IllegalArgumentException("unknown area! []" + area);
        }
    }
}
