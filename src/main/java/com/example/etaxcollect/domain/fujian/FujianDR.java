package com.example.etaxcollect.domain.fujian;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.util.List;

/**
 * @author chensong
 * @date 2022/11/10 16:21
 */
@Data
public class FujianDR {


    @JsonProperty("taxML")
    private TaxMLDTO taxML;


    @Data
    public static class TaxMLDTO {
        @JsonProperty("body")
        private BodyDTO body;


        @Data
        public static class BodyDTO {
            @JsonProperty("zbxx")
            private List<ZbxxDTO> zbxx;
            @JsonProperty("msg")
            private MsgDTO msg;
            @JsonProperty("zje")
            private Double zje;
            @JsonProperty("mxxx")
            private List<MxxxDTO> mxxx;
            @JsonProperty("count")
            private Integer count;
            @JsonProperty("zse")
            private Double zse;


            @Data
            public static class MsgDTO {
                @JsonProperty("msg")
                private String msg;
                @JsonProperty("code")
                private String code;
            }


            @Data
            public static class ZbxxDTO {
                @JsonProperty("xfsbh")
                private String xfsbh;
                @JsonProperty("kpyf")
                private Integer kpyf;
                @JsonProperty("gfSjswjgDm")
                private String gfSjswjgDm;
                @JsonProperty("gfmc")
                private String gfmc;
                @JsonProperty("ydfpbz")
                private String ydfpbz;
                @JsonProperty("gfQxswjgDm")
                private String gfQxswjgDm;
                @JsonProperty("bzsje")
                private Integer bzsje;
                @JsonProperty("xhqdBz")
                private String xhqdBz;
                @JsonProperty("fpztBz")
                private String fpztBz;
                @JsonProperty("xfDsswjgDm")
                private String xfDsswjgDm;
                @JsonProperty("yfphm")
                private String yfphm;
                @JsonProperty("yfpdm")
                private String yfpdm;
                @JsonProperty("kjlx")
                private String kjlx;
                @JsonProperty("fpztWhsj")
                private Long fpztWhsj;
                @JsonProperty("xfQxswjgDm")
                private String xfQxswjgDm;
                @JsonProperty("kpr")
                private String kpr;
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
                private Double je;
                @JsonProperty("xfmc")
                private String xfmc;
                @JsonProperty("slv")
                private Double slv;
                @JsonProperty("gfsh")
                private String gfsh;
                @JsonProperty("tspzDm")
                private String tspzDm;
                @JsonProperty("dkXsfmc")
                private String dkXsfmc;
                @JsonProperty("syslbs")
                private String syslbs;
                @JsonProperty("gfDsswjgDm")
                private String gfDsswjgDm;
                @JsonProperty("jssj")
                private Long jssj;
                @JsonProperty("se")
                private Double se;
                @JsonProperty("zfrq")
                private Object zfrq;
                @JsonProperty("dataCategory")
                private String dataCategory;
                @JsonProperty("sjswjgDm")
                private String sjswjgDm;
                @JsonProperty("kprq")
                private Long kprq;
                @JsonProperty("bz")
                private String bz;
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
                private String dkXsfsbh;
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


            @Data
            public static class MxxxDTO {
                @JsonProperty("kpyf")
                private Integer kpyf;
                @JsonProperty("gfSjswjgDm")
                private String gfSjswjgDm;
                @JsonProperty("gfsh")
                private String gfsh;
                @JsonProperty("gfmc")
                private String gfmc;
                @JsonProperty("gfyhzh")
                private String gfyhzh;
                @JsonProperty("dj")
                private String dj;
                @JsonProperty("ydfpbz")
                private String ydfpbz;
                @JsonProperty("spmc")
                private String spmc;
                @JsonProperty("wfqfbzXf")
                private String wfqfbzXf;
                @JsonProperty("hjje")
                private Double hjje;
                @JsonProperty("jssj")
                private Long jssj;
                @JsonProperty("se")
                private Double se;
                @JsonProperty("hwmc")
                private String hwmc;
                @JsonProperty("sjswjgDm")
                private String sjswjgDm;
                @JsonProperty("kprq")
                private Long kprq;
                @JsonProperty("mc")
                private String mc;
                @JsonProperty("dataCategory")
                private String dataCategory;
                @JsonProperty("bz")
                private String bz;
                @JsonProperty("hwsl")
                private String hwsl;
                @JsonProperty("sl")
                private Double sl;
                @JsonProperty("xfdzdh")
                private String xfdzdh;
                @JsonProperty("skr")
                private String skr;
                @JsonProperty("fpztDm")
                private String fpztDm;
                @JsonProperty("spbm")
                private String spbm;
                @JsonProperty("qdbz")
                private String qdbz;
                @JsonProperty("ggxh")
                private String ggxh;
                @JsonProperty("fpzlmc")
                private String fpzlmc;
                @JsonProperty("fpdm")
                private String fpdm;
                @JsonProperty("hjse")
                private Double hjse;
                @JsonProperty("jldw")
                private String jldw;
                @JsonProperty("yhzcbs")
                private String yhzcbs;
                @JsonProperty("zzstsgl")
                private String zzstsgl;
                @JsonProperty("mxxh")
                private Integer mxxh;
                @JsonProperty("kpr")
                private String kpr;
                @JsonProperty("xfSjswjgDm")
                private String xfSjswjgDm;
                @JsonProperty("xfyhzh")
                private String xfyhzh;
                @JsonProperty("zxbm")
                private String zxbm;
                @JsonProperty("fhr")
                private String fhr;
                @JsonProperty("lslbs")
                private Object lslbs;
                @JsonProperty("gfdzdh")
                private String gfdzdh;
                @JsonProperty("tslsh")
                private String tslsh;
                @JsonProperty("xfsh")
                private String xfsh;
                @JsonProperty("je")
                private Double je;
                @JsonProperty("xfmc")
                private String xfmc;
                @JsonProperty("fphm")
                private String fphm;
            }
        }
    }
}
