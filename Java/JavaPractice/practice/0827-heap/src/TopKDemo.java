import java.util.Random;

public class TopKDemo {
    public static void main(String[] args) {
        Random random = new Random(114158);
        int[] wulin = new int[100];
        for(int i = 0; i < wulin.length; i++){
            wulin[i] = random.nextInt(1000);
        }
        int[] topK = findTopK(wulin,5);
    }
    private static int[] findTopK(int[] wulin, int k){
        int[] heap = new int[5];
        for(int i = 0; i < k; i++){
            heap[i] = wulin[i];
        }
        Heaps.createHeapMin(heap, heap.length);
        for(int i = k; i < wulin.length; i++){
            if(wulin[i] >
            )
        }
    }
}
