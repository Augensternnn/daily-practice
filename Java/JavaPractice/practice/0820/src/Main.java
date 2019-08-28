import java.util.ArrayList;
import java.util.Random;

public class Main {
    private static void swap(ArrayList<PokeCard> list, int i, int j) {
        PokeCard tmpI = list.get(i);
        PokeCard tmpJ = list.get(j);
        list.set(i, tmpJ);
        list.set(j, tmpI);
    }

    public static void main(String[] args) {
        ArrayList<PokeCard> cards = new ArrayList<>(52);
        String[] colors = {"♥", "♦", "♠", "♣"};

        for (int i = 0; i < 4; i++) {
            for (int j = 1; j <= 13; j++) {
                PokeCard card = new PokeCard(j, colors[i]);
                cards.add(card);
            }
        }

        // 洗牌
        Random random = new Random(20190820);
        // 理论符合均匀分布，但不会证明
        for (int i = 51; i > 0; i--) {
            int j = random.nextInt(i);
            swap(cards, i, j);
        }
        System.out.println(cards);
        /*
        //有三个人，每人抓5张牌
        ArrayList(PokeCard) A = new ArrayList<>();
        ArrayList(PokeCard) B = new ArrayList<>();
        ArrayList(PokeCard) C = new ArrayList<>();

        System.out.println(cards.subList(52 - 15,52));
        for(int i = 0;i < 15;i++){
            PokeCard card = cards.remove(cards.size() - 1);
            switch(i % 3){
                case 0:
                    A.add(card);break;
                case 1:
                    B.add(card);break;
                case 2:
                    C.add(card);break;;
            }
        }
        System.out.println(cards.size());
    }

    PokeCard c = ["红心A"];
    for(int i = 0;i < A.size();i++){
        PokeCard o = A.get(i);
        if(o.equals(heartA)){
            A.remove(o);
        }
    }*/
    }
}
