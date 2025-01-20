class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> st = new HashSet<>();
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(beginWord,1));
        for( String i : wordList){
            st.add(i);
        }
        st.remove(beginWord);
        while (!q.isEmpty()){
            Pair cur = q.poll();
            String curWord = cur.i;
            int step = cur.j;
            if (endWord.equals(curWord)){
                return step;
            }
            for(int i = 0; i < curWord.length(); i++){
                for ( char ch = 'a'; ch <= 'z'; ch++){
                    char replacedWord[] = curWord.toCharArray();
                    replacedWord[i] = ch;
                    String newReplacedWord = new String(replacedWord);
                    if ( st.contains(newReplacedWord)){
                        st.remove(newReplacedWord);
                        q.add(new Pair(newReplacedWord,step+1));
                    }
                }
            }
        }
        return 0;
    }
}

class Pair{
    String i;
    int j;
    Pair(String i , int j){
        this.i = i;
        this.j = j;
    }
}
