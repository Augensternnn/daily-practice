package com.bit;

public class Test {
    public static void main(String[] args) {
        System.out.println(Test.class.getClassLoader().getResource("login.html"));      // 推荐使用
//        System.out.println(Test.class.getResource("../../login.html")); // 因为此时Test文件在包com.bit路径下，故以Test所在路径为相对路径

    }
}
