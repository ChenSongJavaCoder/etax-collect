package com.example.etaxcollect.domain.fujian;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author chensong
 * @date 2022/11/10 16:26
 */
@NoArgsConstructor
@Data
public class FujianLR {

    @JsonProperty("zbxx")
    private List<ZbxxDTO> zbxx;
    @JsonProperty("msg")
    private MsgDTO msg;
    @JsonProperty("zje")
    private BigDecimal zje;
    @JsonProperty("count")
    private Integer count;
    @JsonProperty("zse")
    private BigDecimal zse;

    @NoArgsConstructor
    @Data
    public static class MsgDTO {
        @JsonProperty("msg")
        private String msg;
        @JsonProperty("code")
        private String code;
    }

    @NoArgsConstructor
    @Data
    public static class ZbxxDTO {
        @JsonProperty("xfsbh")
        private String xfsbh;
        @JsonProperty("kpyf")
        private Integer kpyf;
        @JsonProperty("gfSjswjgDm")
        private Object gfSjswjgDm;
        @JsonProperty("gfmc")
        private String gfmc;
        @JsonProperty("ydfpbz")
        private String ydfpbz;
        @JsonProperty("gfQxswjgDm")
        private Object gfQxswjgDm;
        @JsonProperty("bzsje")
        private Integer bzsje;
        @JsonProperty("xhqdBz")
        private String xhqdBz;
        @JsonProperty("fpztBz")
        private String fpztBz;
        @JsonProperty("xfDsswjgDm")
        private String xfDsswjgDm;
        @JsonProperty("yfphm")
        private Object yfphm;
        @JsonProperty("yfpdm")
        private Object yfpdm;
        @JsonProperty("kjlx")
        private String kjlx;
        @JsonProperty("fpztWhsj")
        private Long fpztWhsj;
        @JsonProperty("xfQxswjgDm")
        private String xfQxswjgDm;
        @JsonProperty("kpr")
        private Object kpr;
        @JsonProperty("dkbdbs")
        private String dkbdbs;
        @JsonProperty("sjqfrq")
        private Long sjqfrq;
        @JsonProperty("xfSjswjgDm")
        private String xfSjswjgDm;
        @JsonProperty("fplxdm")
        private String fplxdm;
        @JsonProperty("fpztYwsj")
        private Long fpztYwsj;
        @JsonProperty("jshj")
        private Integer jshj;
        @JsonProperty("je")
        private BigDecimal je;
        @JsonProperty("xfmc")
        private String xfmc;
        @JsonProperty("slv")
        private BigDecimal slv;
        @JsonProperty("gfsh")
        private String gfsh;
        @JsonProperty("tspzDm")
        private String tspzDm;
        @JsonProperty("dkXsfmc")
        private Object dkXsfmc;
        @JsonProperty("syslbs")
        private String syslbs;
        @JsonProperty("gfDsswjgDm")
        private Object gfDsswjgDm;
        @JsonProperty("jssj")
        private Long jssj;
        @JsonProperty("se")
        private BigDecimal se;
        @JsonProperty("zfrq")
        private Object zfrq;
        @JsonProperty("dataCategory")
        private String dataCategory;
        @JsonProperty("sjswjgDm")
        private Object sjswjgDm;
        @JsonProperty("kprq")
        private Long kprq;
        @JsonProperty("bz")
        private Object bz;
        @JsonProperty("bmbBbh")
        private String bmbBbh;
        @JsonProperty("mxts")
        private Integer mxts;
        @JsonProperty("fpztDm")
        private String fpztDm;
        @JsonProperty("rowno")
        private Integer rowno;
        @JsonProperty("gfsbh")
        private String gfsbh;
        @JsonProperty("fpzlmc")
        private String fpzlmc;
        @JsonProperty("fpdm")
        private String fpdm;
        @JsonProperty("rksj")
        private Long rksj;
        @JsonProperty("dkXsfsbh")
        private Object dkXsfsbh;
        @JsonProperty("yddk")
        private String yddk;
        @JsonProperty("bsfs")
        private String bsfs;
        @JsonProperty("fpzldm")
        private String fpzldm;
        @JsonProperty("tslsh")
        private String tslsh;
        @JsonProperty("zjqfrq")
        private Object zjqfrq;
        @JsonProperty("hsslbz")
        private String hsslbz;
        @JsonProperty("fphm")
        private String fphm;
        @JsonProperty("jym")
        private String jym;
    }
}
