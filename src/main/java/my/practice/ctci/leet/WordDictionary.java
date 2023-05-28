package my.practice.ctci.leet;

/**
 * @author Vishal Joshi
 */
public class WordDictionary {

    public static void main(String[] args) {
        WordDictionary dictionary = new WordDictionary();
        dictionary.addWord("bad");
        dictionary.addWord("dad");
        dictionary.addWord("mad");
        dictionary.search(".ad");
    }
        class TrieNode {
            char ch;
            boolean isEnd;
            TrieNode[] links = new TrieNode[26];

            public TrieNode(char ch){
                this.ch=ch;
            }

            public boolean containsKey(char ch){
                return links[ch-'a']!=null;
            }

            public TrieNode get(char ch){
                return links[ch-'a'];
            }

            public void put(char ch, TrieNode nodeToInsert){
                links[ch-'a']= nodeToInsert;
            }

            public void setEnd(boolean isEnd){
                this.isEnd=isEnd;
            }

            public boolean isEnd(){
                return this.isEnd;
            }

            public TrieNode[] getLinks(){
                return this.links;
            }
        }

        /** Initialize your data structure here. */
        TrieNode root;
        public WordDictionary() {
            root = new TrieNode('x');
        }

        public void addWord(String word) {
            TrieNode current = root;
            for(int i=0; i<word.length(); i++){
                char ch=word.charAt(i);
                if(!current.containsKey(ch)){
                    current.put(ch, new TrieNode(ch));
                }
                current=current.get(ch);
            }
            current.setEnd(true);
        }

        public boolean search(String word) {
            TrieNode current = root;
            return search(word, current);
        }

        private boolean search(String word, TrieNode current){
            for(int i=0; i<word.length(); i++){
                char ch=word.charAt(i);
                System.out.println("index "+i);
                if(ch=='.'){
                    return searchFromChar(i, current, word);
                } else if(!current.containsKey(ch)){
                    return false;
                }
                current=current.get(ch);
            }
            return current.isEnd();
        }

        private boolean searchFromChar(int start, TrieNode node, String word){

            for(TrieNode link: node.getLinks()){
                if(link!=null && backtrack(start, link, word)){
                    return true;
                }
            }
            return false;
        }

        private boolean backtrack(int start, TrieNode current, String word){
            if(start>=word.length()){
                return false;
            }

            if(word.charAt(start)!= '.'){
                if(this.search(word.substring(start), current)){
                    return true;
                }

                if(!current.containsKey(word.charAt(start)) || (start==word.length()-1 && !current.isEnd())){
                    return false;
                }
            }
            System.out.println(word.charAt(start)+"    "+current.isEnd()+"    "+start);
            if(word.charAt(start)== '.' && start==word.length()-1){
                return current.isEnd();
            }

            for(TrieNode link: current.getLinks()){
                if(link!=null && backtrack(start+1, link, word)){
                    return true;
                }
            }
            return false;
        }
    }

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
