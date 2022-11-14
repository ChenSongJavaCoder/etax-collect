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
public enum ETaxDirection {

    F_J(ETaxArea.F_J) {
        @Override
        public Map<String, String> direction () {
            return new HashMap<String, String>() {{
                put("0", "销项");
                put("1", "进项");
            }};
        }
    };


    private ETaxArea area;

    public abstract Map<String, String> direction();
}
