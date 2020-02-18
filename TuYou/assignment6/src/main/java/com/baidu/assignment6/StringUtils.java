package com.baidu.assignment6;

import java.util.List;

public class StringUtils {

    public static String join(String delimiter, List<String> elements) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < elements.size(); i++) {
            sb.append(elements.get(i));
            if (i < elements.size() - 1) {
                sb.append(delimiter);
            }
        }
        return sb.toString();
    }
}
