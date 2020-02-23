public interface Iterator {
    // 判断迭代器是否走到了线性表最后
    boolean hasNext();

    // 1. 让迭代器往后走一步；2. 返回当前值
    int next();

    // 删除当前迭代器代表的值
    int remove();
}
