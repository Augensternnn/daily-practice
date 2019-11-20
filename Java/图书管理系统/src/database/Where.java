package database;

import classes.Book;

public interface Where<E> {
    boolean test(E e);
}
