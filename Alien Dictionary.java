class Solution {
    public String findOrder(String[] dict, int k) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < k; i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0; i < dict.length-1; i++){
            String s1 = dict[i];
            String s2 = dict[i+1];
            int len = Math.min(s1.length(),s2.length());
            for(int j = 0; j < len; j++){
                if(s1.charAt(j) != s2.charAt(j)){
                    adj.get(s1.charAt(j)-'a').add(s2.charAt(j)-'a');
                    break;
                }
            }
        }
        int[] vis = new int[k];
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < k; i++){
            if(vis[i] == 0){
                topo(i,vis,adj,st);
            }
        }

        
        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            sb.append((char) (st.pop() + 'a'));
        }
        return sb.toString();
    }
    public void topo(int node,int[] vis,ArrayList<ArrayList<Integer>> adj,Stack<Integer> st){
        vis[node] = 1;
        for(int it : adj.get(node)){
            if(vis[it] == 0){
                topo(it,vis,adj,st);
            }
        }
        st.push(node);
    }
}
