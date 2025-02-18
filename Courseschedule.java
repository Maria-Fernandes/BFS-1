// Time Complexity : O(v+e)
// Space Complexity : O(v+e)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
create indegree of courses
the dependancy graph and perform topological sort
 */

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses==0)
            return true;

        int indegree[]=new int[numCourses];
        HashMap<Integer,List<Integer>> graph=new HashMap<>();

        for(int[] pre: prerequisites){
            int start=pre[1];
            int end=pre[0];
            if(graph.get(start)==null){
                graph.put(start,new ArrayList<>());
            }
            graph.get(start).add(end);
            indegree[end]++;
        }

        Queue<Integer> queue=new LinkedList<>();
        int count=0;
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0) {
                queue.add(i);
                count++;
            }
        }

        if(count==numCourses)
            return true;

        while(!queue.isEmpty()){
            int node=queue.poll();
            for(int n: graph.getOrDefault(node,new ArrayList<>())){
                indegree[n]--;
                if(indegree[n]==0){
                    queue.add(n);
                    count++;
                    if(count==numCourses)
                        return true;
                }
            }
        }

        return false;

    }
}

