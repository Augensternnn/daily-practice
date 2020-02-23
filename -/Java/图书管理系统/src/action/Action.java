package action;

import classes.Book;
import classes.Record;
import classes.User;
import database.BookShelf;
import database.RecordShelf;
import database.Where;
import exceptions.BorrowedOutException;
import exceptions.NoSuchBookException;
import exceptions.NotBorrowedException;
import exceptions.YetBorrowedException;

import java.util.List;

public class Action {
    /**
     * 图书上架
     * 1. 如果已经有了，增加数目(存量/总量)
     * 2. 如果没有，新书上架
     * @param ISBN
     * @param title
     * @param author
     * @param price
     * @param count
     * @return
     */
    public static Book putBook(String ISBN, String title, String author, double price, int count) {
        // 系统内部只能有一个书架对象
        // 单例模式
        BookShelf bookShelf = BookShelf.getInstance();
        try {
            Book book = bookShelf.search(ISBN);
            book.increaseCount(count);
            return book;
        } catch (NoSuchBookException exc) {
            Book book = new Book(ISBN, title, author, price, count);
            bookShelf.putBook(book);
            return book;
        }
    }

    public static List<Book> queryBooks() {
        BookShelf bookShelf = BookShelf.getInstance();
        return bookShelf.queryBooks(null);
    }

    public static List<Book> queryBooksByWhere(Where<Book> where) {
        BookShelf bookShelf = BookShelf.getInstance();
        return bookShelf.queryBooks(where);
    }

    public static List<Record> queryRecords() {
        RecordShelf recordShelf = RecordShelf.getInstance();
        return recordShelf.queryRecords(null);
    }

    // 1. ISBN 对应的书存在
    // 2. 当前存量 > 0
    // 3. 当前用户没有借过这本书
    public static Book borrowBook(User user, String ISBN) throws NoSuchBookException, BorrowedOutException, YetBorrowedException {
        BookShelf bookShelf = BookShelf.getInstance();
        RecordShelf recordShelf = RecordShelf.getInstance();
        Book book = bookShelf.search(ISBN);
        if (book.getCurrentCount() <= 0) {
            throw new BorrowedOutException();
        }
        if (recordShelf.contains(user, ISBN)) {
            throw new YetBorrowedException();
        }
        book.borrowBook();
        recordShelf.putRecord(user, ISBN);
        return book;
    }

    public static Book returnBook(User user, String ISBN) throws NoSuchBookException, NotBorrowedException {
        BookShelf bookShelf = BookShelf.getInstance();
        Book book = bookShelf.search(ISBN);
        RecordShelf recordShelf = RecordShelf.getInstance();
        recordShelf.remove(user, ISBN);
        book.returnBook();
        return book;
    }
}
