class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> hm = new HashMap<>();
    	int[] visited = new int[numCourses];
    	int[] dfs_visited = new int[numCourses];
    	
    	for(int i=0; i<prerequisites.length; i++) {
    		int course = prerequisites[i][0];
    		int prereq = prerequisites[i][1];
    		
    		if(!hm.containsKey(prereq))
    			hm.put(prereq, new ArrayList<>());
    		hm.get(prereq).add(course);
    	}
    	
    	for(int i=0; i<numCourses; i++) {
    		if(dfs(i, hm, visited, dfs_visited))
    			return false;
    	}
    	
    	return true;
    }
    
    public boolean dfs(int course, HashMap<Integer, List<Integer>> hm, int[] visited, int[] dfs_visited) {
    	
    	visited[course] = 1;
    	dfs_visited[course] = 1;
        
    	if(hm.containsKey(course)) {
    		for(int i=0; i<hm.get(course).size(); i++) {
    			if(visited[hm.get(course).get(i)] == 0) {
    				if(dfs(hm.get(course).get(i), hm, visited, dfs_visited))
    					return true;
    			}
    			else if(dfs_visited[hm.get(course).get(i)] == 1)
                    return true;	
    		}
    	}
    	
    	dfs_visited[course] = 0;
    	return false;
    }
}