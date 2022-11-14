package com.example.etaxcollect.domain;

import cn.hutool.core.date.LocalDateTimeUtil;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.Duration;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author chensong
 * @date 2022/11/11 9:29
 */
@Data
@Accessors(chain = true)
public class InvoiceCollectTask {
    private String cookie;
    private ETaxArea area;
    private LocalDate start;
    private LocalDate end;


    public List<YearMonth> months() {
        long m = LocalDateTimeUtil.between(start.atStartOfDay(), end.atStartOfDay(), ChronoUnit.MONTHS);
        return Stream.iterate(0, i -> i + 1).limit(m + 1).map(p -> YearMonth.from(start.plusMonths(p))).collect(Collectors.toList());
    }


}
