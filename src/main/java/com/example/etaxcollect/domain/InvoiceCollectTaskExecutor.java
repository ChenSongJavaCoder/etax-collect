package com.example.etaxcollect.domain;

import cn.hutool.json.JSONUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author chensong
 * @date 2022/11/11 11:39
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class InvoiceCollectTaskExecutor {
    private final InvoiceCollectContextFactory factory;

    public void execute(InvoiceCollectTask task) {
        ETaxArea area = task.getArea();
        String cookie = task.getCookie();

        List<StandardInvoiceBean> wholeInvoice = task.months().
                stream().map(month -> {
                    InvoiceCollect context = factory.build(area, cookie, month);
                    return context.collect();
                }).flatMap(p -> p.stream()).collect(Collectors.toList());


        log.info("共计{}张发票", wholeInvoice.size());
    }
}
