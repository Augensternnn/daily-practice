package classes;

import action.Action;
import exception.BorrowedOutException;
import exception.NoSuchBookException;
import exception.YetBorrowedException;

import java.util.Scanner;

public class Student extends User {
    public Student(String id, String name) {
        super(id, name);
    }

    @Override
    public void menu() {
        System.out.println("****** 同学你好，请选择 *****");
        System.out.println("******  0.退出  ****");
        System.out.println("******  1.查阅图书  ****");
        System.out.println("******  2.借阅图书  ****");
        System.out.println("******  3.归还图书  ****");
        System.out.println("******  4.查询借阅记录  ****");
    }

    @Override
    public boolean input() {
        Scanner scanner = new Scanner(System.in);
        int selected = scanner.nextInt();
        scanner.nextLine();
        switch (selected){
            case 0:
                return true;
            case 1:
                queryBooks();
                break;
            case 2:
                borrowBook();
                break;
            case 3:
                System.out.println("请查询记录：");
                break;
        }
        return false;
    }

    private void borrowBook() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要借阅的书籍的ISBN：");
        String ISBN = scanner.nextLine();
        User user = User.getCurrentUser();
        try{
            Book book = Action.borrowBook(user, ISBN);
            System.out.printf("《%s》借阅成功！%n", book.getTitle());
        }catch (NoSuchBookException e){
            System.out.println("没有这本书！");
        }catch (BorrowedOutException e){
            System.out.println("这本书已经被借完了！");
        }catch (YetBorrowedException e){
            System.out.println("你已经借过这本书了！");
        }
    }
}
