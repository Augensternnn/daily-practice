package xml.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

/**
 * Document/Element对象功能
 */
public class JsoupDemo3 {
    /**
     * 获取Element对象
     *  getElementById​(String id)：根据id属性值获取唯一的element对象
     * 	getElementsByTag​(String tagName)：根据标签名称获取元素对象集合
     * 	getElementsByAttribute​(String key)：根据属性名称获取元素对象集合
     * 	getElementsByAttributeValue​(String key, String value)：根据对应的属性名和属性值获取元素对象集合
     */
    public static void main(String[] args) throws IOException {
        //1.获取student.xml的path
        String path = JsoupDemo3.class.getClassLoader().getResource("student.xml").getPath();
        //2.获取Document对象
        Document document = Jsoup.parse(new File(path), "utf-8");
        //3.获取元素对象
            //3.1获取所有student对象
        Elements elements = document.getElementsByTag("student");
        System.out.println(elements);

        System.out.println("----------------");

        //3.2获取属性名为id的元素对象们
        Elements elements1 = document.getElementsByAttribute("id");
        System.out.println(elements1);

        System.out.println("----------------");

        //3.2.1获取number属性值为haha_0001的元素对象
        Elements elements2 = document.getElementsByAttributeValue("number", "haha_0001");
        System.out.println(elements2);

        System.out.println("----------------");

        //3.3获取id属性值的元素对象
        Element element = document.getElementById("1234");
        System.out.println(element);

    }
}
