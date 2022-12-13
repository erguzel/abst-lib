package com.sicsrobotics.util.search;

import java.util.*;

public class Bfs {


/*
    public static void main(String[] args) {


        TreeMap<String,String> tm = new TreeMap<>();


        String bword = "hit";

        List<String> wordlist = Arrays.asList("hot","dot","dog","lot","log","cog","com", "tom");

        String eword = "tom";

        int ress =  LadderWrod(bword,eword,wordlist);

        System.out.println(ress);


    }
*/


    /**
     * Finds shortest sequence breadth first search
     *
     * @param beginword
     * @param endWord
     * @param wordList
     * @return
     */
    public static int LadderWrod(String beginword, String endWord, List<String> wordList) {

        HashSet<String> set = new HashSet<>();
        wordList.forEach(a -> set.add(a));
        if (!set.contains(endWord)) return 0;
        //create cache queue and populate with the first begin word
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginword);
        int level = 1;
        // searching loop
        // pop the vtex element
        // search if one word change will end up in the word list
        // if yes, look another search and increment the level
        while (!queue.isEmpty()) {
            //    int size = queue.size();
            //for(int i = 0; i < size; i++){
            String currentWord = queue.poll();
            char[] word_chars = currentWord.toCharArray();
            for (int j = 0; j < word_chars.length; j++) {
                char original_char = word_chars[j];
                for (char c = 'a'; c < 'z'; c++) {
                    if(original_char==c) continue;
                    word_chars[j] = c;
                    String newWord = String.valueOf(word_chars);
                    if(newWord.equals(endWord)) return level;
                    if (set.contains(newWord)) {
                        queue.offer(newWord);
                        set.remove(newWord);
                    }
                }
                word_chars[j] = original_char;
                // }
            }
            level++;
        }

        // if search unsuccessfuk

        return 0;


    }
}
