public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> res = new ArrayDeque<>();
        for (int i = 0; i < word.length(); i++) {
            res.addLast(word.charAt(i));
        }
        return res;
    }

    public boolean isPalindrome(String word) {
        Deque<Character> tmp = wordToDeque(word);
        while (tmp.size() >= 2) {
            if (tmp.removeFirst() != tmp.removeLast()) {
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome(String word, CharacterComparator cc){
        Deque<Character> tmp = wordToDeque(word);
        while (tmp.size() >= 2) {
            if (!cc.equalChars(tmp.removeFirst(), tmp.removeLast())) {
                return false;
            }
        }
        return true;
    }
}
