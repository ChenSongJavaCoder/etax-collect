package com.example.etaxcollect.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chensong
 * @date 2022/11/10 15:43
 */
@Getter
@AllArgsConstructor
public enum ETaxInvoiceType {

    F_J(ETaxArea.F_J) {
        @Override
        public Map<String, String> invoiceTypes() {
            return new HashMap<String, String>() {{
                put("1130", "增值税专用发票");
                put("16", "增值税电子专用发票");
                put("07", "增值税普通发票");
                put("11", "增值税电子普通发票");
            }};
        }
    };


    private ETaxArea area;


    public abstract Map<String, String> invoiceTypes();

    public static void main(String[] args) {
        ETaxInvoiceType.F_J.invoiceTypes();
    }
}
