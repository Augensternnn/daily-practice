import java.util.*;

public class problem05 {
    /*
    前 K 个高频单词
     */
    Map<String,Integer> count(String[] words){
        Map<String,Integer> wordToCount = new HashMap<>();
        for(String word : words){
            int c = wordToCount.getOrDefault(word,0);
            wordToCount.put(word, c + 1);
        }
        return wordToCount;
    }

    // 每个次数 => 哪些单词
    Map<Integer, List<String>> remap(Map<String,Integer> wordToCount){
        Map<Integer, List<String>> countToWorldList = new HashMap<>();
        for(Map.Entry<String,Integer> e : wordToCount.entrySet()){
            String word = e.getKey();
            int count = e.getValue();
            List<String> worldList = countToWorldList.get(count);
            if(worldList == null){
                worldList = new ArrayList<>();
                countToWorldList.put(count,worldList);
            }
            worldList.add(word);
        }
        return countToWorldList;
    }
    // 排序
    void orderedCount(int[] counts){
        Arrays.sort(counts);
    }
    public List<String> topKFrequent(String[] words,int k){
        Map<String,Integer> wordToCount = count(words);
        Map<Integer,List<String>> countToWordList = remap(wordToCount);
        Set<Integer> keys = countToWordList.keySet();
        int[] counts = new int[keys.size()];
        int i = 0;
        for(int key : keys){
            counts[i++] = key;
        }
        Arrays.sort(counts);
        List<String> result = new ArrayList<>();
        int j = 0;
        int index = counts.length - 1;
        while(j < k){
            int c = counts[index--];
            List<String> wordList = countToWordList.get(c);
            if(wordList.size() <= k - 1) {
                result.addAll(wordList);
                j += wordList.size();
            }else{
                result.addAll(wordList)
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String[] words = {"i","love","leetcode","i","love","coding"};

    }
}
