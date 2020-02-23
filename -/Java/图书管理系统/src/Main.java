import classes.User;

public class Main {
    public static void main(String[] args) throws Exception {
        // 输出提示
        // 用 scanner 读用户输入
        // id / name / 角色
        // 生成用户对象
        while (true) {
            User currentUser = User.login();
            boolean isQuit;
            do {
                currentUser.menu();
                isQuit = currentUser.input();
            } while (!isQuit);
        }
        //System.out.println("欢迎下次光临");
    }
}

