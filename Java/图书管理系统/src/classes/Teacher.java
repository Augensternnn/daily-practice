package classes;

import action.Action;

import java.util.List;
import java.util.Scanner;

public class Teacher extends User {
    public Teacher(String id, String name) {
        super(id, name);
    }

    @Override
    public void menu() {
        System.out.println("** 老师，请选择 **");
        System.out.println("** 0. 退出 **");
        System.out.println("** 1. 上架 **");
        System.out.println("** 2. 查阅图书 **");
        System.out.println("** 3. 查阅记录 **");
    }

    @Override
    public boolean input() {                // 负责界面处理，调用Teacher.putBook()
        Scanner scanner = new Scanner(System.in);
        int selected = scanner.nextInt();
        switch (selected) {
            case 0: return true;
            case 1:
                putBook();
                break;
            case 2:
                queryBooks();
                break;
            case 3:
                System.out.println("请查询记录"); break;
        }
        return false;
    }

    public void queryBooks(){
        List<Book> bookList = Action.queryBooks();
        for(Book book : bookList){
            System.out.println("《%s》by %s 价格：%f 存量：%d 借阅次数：%d%n");
        }
        System.out.println("共查询到 " + bookList.size() + " 本书");
    }

    private void putBook() {                    // 调用 Action.putBook()，负责上架流程
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入 ISBN: ");
        String ISBN = scanner.nextLine();
        System.out.println("请输入书名: ");
        String title = scanner.nextLine();
        System.out.println("请输入作者: ");
        String author = scanner.nextLine();
        System.out.println("请输入价格: ");
        double price = scanner.nextDouble();
        System.out.println("请输入数量: ");
        int count = scanner.nextInt();

        Book book = Action.putBook(ISBN, title, author, price, count);
        System.out.printf("《%s》 上架成功！%n", book.getTitle());
    }
}
