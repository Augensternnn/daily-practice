package annotation;

public @interface MyAnno {
    int value();
    Person per();
    MyAnno2 anno2();
    String[] strs();
    //String name() default "haha";
    /*Person per();   //枚举
    MyAnno2 anno2();    //注解
    String[] strs();*/
}
