class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int n = numCourses;
        ArrayList<Integer> ans = new ArrayList<>();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0; i < prerequisites.length; i++){
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        Queue<Integer> q = new LinkedList<>();
        int[] indegree = new int[n];
        for(int i = 0; i < n; i++){
            for( int it : adj.get(i)){
                indegree[it]++;
            }
        }
        for(int i = 0; i < n; i++){
            if( indegree[i] == 0){
                q.add(i);
            }
        }
        while (!q.isEmpty()){
            int node = q.poll();
            ans.add(node);
            for(int it : adj.get(node)){
                indegree[it]--;
                if(indegree[it] == 0){
                    q.add(it);
                }
            }
        }
        if( ans.size() == n){
            return true;
        }
        return false;
    }
}



// 210. Course Schedule II.java
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int n = numCourses;
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0; i < prerequisites.length; i++){
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        Queue<Integer> q = new LinkedList<>();
        int[] indegree = new int[n];
        for(int i = 0; i < n; i++){
            for( int it : adj.get(i)){
                indegree[it]++;
            }
        }
        for(int i = 0; i < n; i++){
            if( indegree[i] == 0){
                q.add(i);
            }
        }
        while (!q.isEmpty()){
            int node = q.poll();
            list.add(node);
            for(int it : adj.get(node)){
                indegree[it]--;
                if(indegree[it] == 0){
                    q.add(it);
                }
            }
        }
        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        if( ans.length == n){
            return ans;
        }
        return new int[0];
    }
}
