package com.example.etaxcollect.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author chensong
 * @date 2022/11/10 15:34
 */
@Getter
@AllArgsConstructor
public enum ETaxArea {
    F_J("fujian", "福建电子税务局", "https://etax.fujian.chinatax.gov.cn/"),

    ;


    private String code;
    private String desc;
    private String url;
}
