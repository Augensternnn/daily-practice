import java.util.ArrayList;
import java.util.List;
/*
功能：根据姓名查找、备注、电话（电话可以有多个）、更新、删除、查找、按照姓名顺序给出所有人的姓名
 */
public class TelephoneList {
    private List<User> telephoneList = new ArrayList<>();
    private static TelephoneList instance = new TelephoneList();

    // 添加
    public void add(String name, List<String> phoneNumber){
        User user = new User(name, phoneNumber);
        telephoneList.add(user);
    }

    // 根据姓名查找查找
    public boolean queryPhoneByName(String name){
        for(User user : telephoneList){
            if(user.is(name)){
                System.out.printf("姓名：%s，电话：%s", user.getName(), user.getPhoneNumber());
                return true;
            }
        }
        return false;
    }


    // 删除：手机号删除、姓名删除
    public void remove()
}
