class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        Disjoint ds = new Disjoint(n);
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < accounts.get(i).size(); j++) {
                String rem = accounts.get(i).get(j);
                if (map.containsKey(rem)) {
                    ds.unionBySize(i, map.get(rem));
                } else {
                    map.put(rem, i);
                }
            }
        }
        ArrayList<String>[] mergedMail = new ArrayList[n];
        for (int i = 0; i < n; i++)
            mergedMail[i] = new ArrayList<String>();
        for (Map.Entry<String, Integer> it : map.entrySet()) {
            String mail = it.getKey();
            int node = ds.FindPar(it.getValue());
            mergedMail[node].add(mail);
        }
        List<List<String>> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (mergedMail[i].size() == 0)
                continue;
            Collections.sort(mergedMail[i]);
            List<String> temp = new ArrayList<>();
            temp.add(accounts.get(i).get(0));
            for (String it : mergedMail[i]) {
                temp.add(it);
            }
            ans.add(temp);
        }
        return ans;
    }
}

class Disjoint {
    ArrayList<Integer> parents = new ArrayList<>();
    ArrayList<Integer> size = new ArrayList<>();

    public Disjoint(int n) {
        for (int i = 0; i < n; i++) {
            parents.add(i);
            size.add(1);
        }
    }

    public int FindPar(int node) {
        if (parents.get(node) == node) {
            return node;
        }
        int u = FindPar(parents.get(node));
        parents.set(node, u);
        return parents.get(node);
    }

    public void unionBySize(int u, int v) {
        int ulp_u = FindPar(u);
        int ulp_v = FindPar(v);
        if (ulp_u == ulp_v)
            return;
        if (size.get(ulp_u) > size.get(ulp_v)) {
            parents.set(ulp_v, ulp_u);
            size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
        } else {
            parents.set(ulp_u, ulp_v);
            size.set(ulp_v, size.get(ulp_u) + size.get(ulp_v));
        }
    }
}
