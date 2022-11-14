package com.example.etaxcollect.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author chensong
 * @date 2022/11/10 15:41
 */
@Data
@AllArgsConstructor
public class InvoiceKey {
    private String fpdm;
    private String fphm;
    private String fplxdm;
    private Integer kpyf;
}
