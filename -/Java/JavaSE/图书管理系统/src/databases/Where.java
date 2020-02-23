package databases;

public interface Where<E> {
    boolean test(E e);
}
