public class StartsWith {
    static class Node{
        Node children[] = new Node[26];
        boolean eow = false;

        Node() {
            for(int i=0; i<26; i++){
                children[i] = null;
            }
        }
    }

    public static Node root = new Node();

    //Insert
    public static void insert(String word){
        Node curr = root;
        for(int level = 0; level<word.length(); level++){
            int idx = word.charAt(level)- 'a';
            if(curr.children[idx] == null){
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
        }

        curr.eow = true;
    }

    //Search
    public static  boolean search(String key){
        Node curr = root;
        for(int level = 0; level<key.length(); level++){
            int idx = key.charAt(level)- 'a';
            if(curr.children[idx] == null){
                curr.children[idx] = new Node();
                return false;
            }
            curr = curr.children[idx];
        }

        return curr.eow = true;
    }

    public static boolean startsWith(String prefix){
        Node curr = root;
        for(int level = 0; level<prefix.length(); level++){
            int idx = prefix.charAt(level)- 'a';
            if(curr.children[idx] == null){
                curr.children[idx] = new Node();
                return false;
            }
            curr = curr.children[idx];
        }

        return curr.eow = true;
    }
    public static void main(String[] args) {
        String words[] = {"apple", "app", "mango", "man", "woman"};
        String prefix1 = "app";
        String prefix2 = "moon";

        for(int i=0; i<words.length; i++){
            insert(words[i]);
        }
        System.out.println(startsWith(prefix1));
        System.out.println(startsWith(prefix2));
    }
}
