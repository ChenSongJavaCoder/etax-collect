package com.example.etaxcollect;

import com.example.etaxcollect.domain.ETaxArea;
import com.example.etaxcollect.domain.InvoiceCollectTask;
import com.example.etaxcollect.domain.InvoiceCollectTaskExecutor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

/**
 * @author chensong
 * @date 2022/11/11 13:34
 */
@SpringBootTest
public class InvoiceCollectTest {
    @Autowired
    private InvoiceCollectTaskExecutor executor;


    @Test
    public void testInvoiceCollect() {
        InvoiceCollectTask task = new InvoiceCollectTask();
        task.setStart(LocalDate.of(2020, 1, 1))
                .setEnd(LocalDate.now())
                .setArea(ETaxArea.F_J)
                .setCookie("route=ace7d7b1955bba8b0cf298b4539f6028; JSESSIONID=6E778E42548CA883051FFA69E2333890; yfx_c_g_u_id_10000433=_ck22111014195519630347816693878; yfx_f_l_v_t_10000433=f_t_1668061195965__r_t_1668061195965__v_t_1668061195965__r_c_0; yfx_mr_10000433=%3A%3Amarket_type_free_search%3A%3A%3A%3Abaidu%3A%3A%3A%3A%3A%3A%3A%3Awww.baidu.com%3A%3A%3A%3Apmf_from_free_search; yfx_mr_f_10000433=%3A%3Amarket_type_free_search%3A%3A%3A%3Abaidu%3A%3A%3A%3A%3A%3A%3A%3Awww.baidu.com%3A%3A%3A%3Apmf_from_free_search; yfx_key_10000433=; SYS_CHANNEL_ID=A01; redissessionid=d825a26a73634346819af7131afc35ab; DZSWJ_TGC=85bc17fb74994ea59affaead304c519b; TGC=TGT-105341-AV0GpZ69tnRXUfAXMlSqo0eM4KpxicOC4whmPa6GS9fyaWdGKL-gddzswj");

        executor.execute(task);
    }
}
