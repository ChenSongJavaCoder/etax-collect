package com.example.etaxcollect.domain.fujian;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.json.JSONUtil;
import com.example.etaxcollect.domain.*;
import com.example.etaxcollect.domain.converter.FujianInvoiceConverter;
import org.springframework.core.convert.converter.Converter;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.time.YearMonth;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * @author chensong
 * @date 2022/11/10 16:28
 */
public class FujianInvoiceCollectContext extends AbstractInvoiceCollectContext {
    private static String DETAIL_PARAM_TEMPLATE = "{\"taxML\":{\"head\":{\"gid\":\"\",\"sid\":\"00.FP.FPXX.DZSWJCX.DJFPCX\",\"tid\":\" \",\"version\":\"\"},\"body\":{\"fpdm\":\"%s\",\"fphm\":\"%S\",\"kpyf\":\"%s\",\"fplxdm\":\"%s\",\"zfbz\":\"\",\"cxlb\":\"2\"}}}";


    public FujianInvoiceCollectContext(String cookie, YearMonth yearMonth) {
        super(cookie, yearMonth);
    }


    @Override
    public void loop(String fplxdm, String dir, List<InvoiceKey> invoiceKeys) {
        HttpHeaders headers = initHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        AtomicInteger pages = new AtomicInteger(1);
        while (true) {
            MultiValueMap<String, String> param = listInterfaceParams();
            param.set("page", String.valueOf(pages.getAndIncrement()));
            param.set("fplxdm", fplxdm);
            param.set("nsrlx", dir);
            HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(param, headers);
            String lrString = REST_TEMPLATE.postForObject(listInterface(), entity, String.class);
            FujianLR lr = JSONUtil.toBean(lrString, FujianLR.class);
            if (Objects.isNull(lr) || CollectionUtil.isEmpty(lr.getZbxx())) {
                return;
            }
            List<InvoiceKey> keys = lr.getZbxx().stream().map(p -> new InvoiceKey(p.getFpdm(), p.getFphm(), p.getFplxdm(), p.getKpyf())).collect(Collectors.toList());
            invoiceKeys.addAll(keys);
        }
    }

    @Override
    public ETaxArea area() {
        return ETaxArea.F_J;
    }

    @Override
    public ETaxInvoiceType invoiceType() {
        return ETaxInvoiceType.F_J;
    }

    @Override
    public ETaxDirection direction() {
        return ETaxDirection.F_J;
    }

    @Override
    public String invoiceState() {
        return "0;1;2;3;4;7;8";
    }

    @Override
    public String listInterface() {
        return "https://etax.fujian.chinatax.gov.cn/tycx-cjpt-web/fpxx/query.do";
    }

    @Override
    public MultiValueMap<String, String> listInterfaceParams() {
        MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
        body.add("page", "1");
        body.add("limit", "90");
        body.add("sid", "00.FP.FPXX.DZSWJCX.DJFPCX");
        body.add("fplxdm", "1130");
        body.add("fpztDm", invoiceState());
        body.add("kprqq", yearMonth.atDay(1).toString());
        body.add("kprqz", yearMonth.atEndOfMonth().toString());
        body.add("fpqshm", "");
        body.add("fpzzhm", "");
        body.add("fpdm", "");
        body.add("type", "sfjr");
        body.add("kpyf", yearMonth.toString());
        body.add("nsrlx", "0");
        body.add("cxlb", "0");
        return body;
    }

    @Override
    public String detailInterface() {
        return "https://etax.fujian.chinatax.gov.cn/tycx-cjpt-web/fpxx/query.do?bw={bw}&gdslxDm=1";
    }

    @Override
    public String detailInterfaceParams(InvoiceKey invoiceKey) {
        return String.format(DETAIL_PARAM_TEMPLATE, invoiceKey.getFpdm(), invoiceKey.getFphm(), invoiceKey.getKpyf(), invoiceKey.getFplxdm());
    }

    @Override
    public Converter<String, StandardInvoiceBean> converter() {
        return new FujianInvoiceConverter();
    }

    public static void main(String[] args) {
        FujianInvoiceCollectContext context = new FujianInvoiceCollectContext(
                "route=8f24625f861cd4c8291ae24b7ff0906f; JSESSIONID=FAAC6A91646C38F3930D7897E8A02FAF; yfx_c_g_u_id_10000433=_ck22111014195519630347816693878; yfx_f_l_v_t_10000433=f_t_1668061195965__r_t_1668061195965__v_t_1668061195965__r_c_0; yfx_mr_10000433=%3A%3Amarket_type_free_search%3A%3A%3A%3Abaidu%3A%3A%3A%3A%3A%3A%3A%3Awww.baidu.com%3A%3A%3A%3Apmf_from_free_search; yfx_mr_f_10000433=%3A%3Amarket_type_free_search%3A%3A%3A%3Abaidu%3A%3A%3A%3A%3A%3A%3A%3Awww.baidu.com%3A%3A%3A%3Apmf_from_free_search; yfx_key_10000433=; SYS_CHANNEL_ID=A01; redissessionid=d825a26a73634346819af7131afc35ab; DZSWJ_TGC=0990dba030e741b692e5b3d96720503d; TGC=TGT-96867-JlrSaSfWw51dmLdH6xnRweItNZ7VkQPK36hHcAtHOJHK1BeETv-gddzswj"
                , YearMonth.of(2022, 9));
        List<StandardInvoiceBean> beans = context.collect();
        System.out.println(JSONUtil.toJsonStr(beans));

    }
}
