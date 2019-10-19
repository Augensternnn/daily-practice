package classes;

import action.Action;
import databases.Where;

import java.util.List;
import java.util.Scanner;

public abstract class User {
    private String id;
    private String name;

    public User(String id, String name){
        this.id = id;
        this.name = name;
    }

    private static User currentUser = null;
    public static User login() throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入用户id：");
        String id = scanner.nextLine();
        System.out.println("请输入用户姓名：");
        String name = scanner.nextLine();
        System.out.println("请输入用户角色(老师or学生)：");
        String role = scanner.nextLine();
        if(role.equals("老师")){
            currentUser = new Teacher(id, name);
        }else if(role.equals("学生")){
            currentUser = new Student(id, name);
        }else {
            throw new Exception("角色错误");
        }
        return currentUser;
    }

    protected static User getCurrentUser() {
        return currentUser;
    }

    public abstract void menu();

    public abstract boolean input();

    private static class Current implements Where<Book> {

        @Override
        public boolean test(Book book) {
            return book.getCurrentCount() > 0;
        }
    }

    private static class BookTitle implements Where<Book> {
        private String title;
        BookTitle(String title){
            this.title = title;
        }

        @Override
        public boolean test(Book book) {
            return book.getTitle().equals(title);
        }
    }

    protected void queryBooks(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("请选择全查询还是条件查询:");
        System.out.println("1. 全查询");
        System.out.println("2. 查询存量 > 0 的");
        System.out.println("其他. 根据书名查询");
        int selected = scanner.nextInt();
        scanner.nextLine();
        List<Book> bookList;
        switch (selected){
            case 1:
                bookList = Action.queryBooks();
                break;
            case 2:
                bookList = Action.queryBooksByWhere(new Current());
                break;
                default:
                    System.out.println("请输入书名：");
                    String title = scanner.nextLine();
                    bookList = Action.queryBooksByWhere(new BookTitle(title));
                    break;
        }
        for(Book book : bookList){
            System.out.printf("《%s》by %s 价格: %.2f 存量: %d 借阅次数: %d%n",
                    book.getTitle(), book.getAuthor(), book.getPrice(),
                    book.getCurrentCount(), book.getBorrowedCount());
        }
        System.out.println("共查询到 " + bookList.size() + " 本书");
    }

    public String getId(){
        return id;
    }

    public String getName(){
        return name;
    }
}
