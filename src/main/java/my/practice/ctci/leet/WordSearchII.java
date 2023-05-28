package my.practice.ctci.leet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Vishal Joshi
 */
public class WordSearchII {

    public static void main(String[] args) {
        char[][] board = new char [][]{{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};
        String[] words = new String[] {"oath","pea","eat","rain"};

        System.out.println(new WordSearchII().findWords(board, words));
    }

    List<String> result;
    public List<String> findWords(char[][] board, String[] words) {
        result = new ArrayList<>();
        Trie trie = buildTrie(words);
        for(int row=0; row<board.length; row++){
            for(int col=0; col<board[0].length; col++){
                backtrack(row, col, board, trie.root);
            }
        }
        return result;
    }

    private void backtrack(int row, int col, char[][] board, TrieNode root){
        char c = board[row][col];
        if(c=='#' || root.links[c-'a']==null){
            return;
        }
        root = root.links[c-'a'];
        if(root.isWord!=null){
            result.add(root.isWord);
            root.isWord=null;
        }

        board[row][col]='#';

        if(row<board.length-1){
            backtrack(row+1, col, board, root);
        }
        if(col<board[0].length-1){
            backtrack(row, col+1, board, root);
        }
        if(row>0){
            backtrack(row-1, col, board, root);
        }
        if(col>0){
            backtrack(row, col-1, board, root);
        }

        board[row][col]=c;
    }

    private Trie buildTrie(String[] words){
        Trie trie = new Trie();
        for(String word: words){
            trie.add(word);
        }
        return trie;
    }

    class TrieNode {
        TrieNode[] links = new TrieNode[26];
        String isWord;
    }

    class Trie {
        TrieNode root = new TrieNode();

        void add(String word){
            TrieNode current = root;
            for(char currentChar: word.toCharArray()){
                if(current.links[currentChar-'a'] == null){
                    current.links[currentChar-'a']=new TrieNode();
                }
                current=current.links[currentChar-'a'];
            }
            current.isWord=word;
        }

    }
}
