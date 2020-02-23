public class PokeCard {
    int val;
    String color;

    public PokeCard(int val,String color){
        this.val = val;
        this.color = color;
    }

    @Override
    public String toString(){
        return String.format("[%d, %s]", val, color);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null){
            return false;
        }

        // 返回 obj 对象能否被 PokeCard 类型的引用指向
        // obj 对象的类型是不是 PokeCard 类型的小类型
        if(!(obj instanceof PokeCard)){
            return false;
        }

        PokeCard other = (PokeCard)obj;

        return this.val == other.val && this.color.equals(other.color);
    }
}
