package classes;

public class Book {
    private String ISBN;
    private String title;
    private String author;
    private double price;
    // 总数量
    private int totalCount;
    // 当前数量
    private int currentCount;
    // 借出数量
    private int borrowedCount;

    public Book(String ISBN, String title, String author, double price, int count){
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
        this.price = price;
        this.totalCount = count;
        this.borrowedCount = 0;
        this.currentCount = count;
    }

    public boolean is(String ISBN) {
        return this.ISBN.equals(ISBN);
    }

    public void increaseCount(int count) {
        currentCount += count;
        totalCount += count;
    }

    public String  getTitle() {
        return title;
    }

    public String getAuthor(){
        return author;
    }

    public double getPrice(){
        return price;
    }

    public int getCurrentCount(){
        return currentCount;
    }

    public int getBorrowedCount(){
        return borrowedCount;
    }

    public void borrowBook() {
        currentCount--;
        borrowedCount++;
    }
}
