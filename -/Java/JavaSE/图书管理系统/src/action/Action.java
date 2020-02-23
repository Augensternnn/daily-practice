package action;

import classes.Book;
import classes.Record;
import classes.User;
import databases.BookShelf;
import databases.RecordShelf;
import databases.Where;
import exception.BorrowedOutException;
import exception.NoSuchBookException;
import exception.YetBorrowedException;

import java.util.List;

public class Action {
    public static List<Book> queryBooks() {
        BookShelf bookShelf = BookShelf.getInstance();
        return bookShelf.queryBooks(null);
    }

    public static Book putBook(String ISBN, String title, String author, double price, int count) {
        BookShelf bookShelf = BookShelf.getInstance();
        try{
            Book book = bookShelf.search(ISBN);
            book.increaseCount(count);
            return book;
        }catch (NoSuchBookException exc){
            Book book = new Book(ISBN, title, author, price, count);
            bookShelf.putBook(book);
            return book;
        }
    }

    public static Book borrowBook(User user, String ISBN) throws NoSuchBookException, BorrowedOutException, YetBorrowedException {
        BookShelf bookShelf = BookShelf.getInstance();
        RecordShelf recordShelf = RecordShelf.getInstance();
        Book book = bookShelf.search(ISBN);
        if(book.getCurrentCount() <= 0){
            throw new BorrowedOutException();
        }
        if(recordShelf.contains(user,ISBN)){
            throw new YetBorrowedException();
        }
        book.borrowBook();
        recordShelf.putRecord(user, ISBN);
        return book;
    }

    public static List<Book> queryBooksByWhere(Where<Book> where) {
        BookShelf bookShelf = BookShelf.getInstance();
        return bookShelf.queryBooks(where);
    }

    public static List<Record> queryRecords() {
        RecordShelf recordShelf = RecordShelf.getInstance();
        return recordShelf.queryRecords(null);
    }
}
