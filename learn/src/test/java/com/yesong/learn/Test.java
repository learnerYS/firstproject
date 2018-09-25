package com.yesong.learn;

public class Test {
    @org.junit.Test
    public void test(){
        String s = "si-adslkjgkl-kgajlh";
        String s1 = s.replaceAll("si-", "");
        System.out.println(s1);
    }
}
