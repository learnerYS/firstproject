package com.yesong.learn;

import org.apache.commons.lang.StringUtils;

public class Test {
    @org.junit.Test
    public void main() {
        String[] strings = {"1", "2", "3"};
        String join = StringUtils.join(strings, ":");
        System.out.println(join);

    }
}
