

import java.math.*;

public class ld207 {

  public boolean canFinish(int numCourses, int[][] prerequisites) {
    if (prerequisites == null || prerequisites.length <= 0)
      return true;
    boolean flag[] = new boolean[numCourses];
    boolean visited[] = new boolean[numCourses];
    int[][] graph = new int[numCourses][numCourses];
    for (int i = 0; i < numCourses; ++i) {
      flag[i] = false;
      visited[i] = false;
      for (int j = 0; j < numCourses; ++j)
        graph[i][j] = 0;
    }

    for (int i = 0; i < prerequisites.length; ++i)
      graph[prerequisites[i][0]][prerequisites[i][1]] = 1;

    boolean res = false;
    for (int i = 0; i < numCourses; ++i) {
      if (!visited[i]) {
        visited[i] = true;
        for (int j = 0; j < numCourses; ++j)
          flag[j] = false;
        flag[i] = true;
        res = dfs(graph, flag, i, visited);
        if (res)
          return false;
      }
    }
    return true;
  }

  //dfs+backtrace
  public boolean dfs(int[][] graph, boolean[] flag, int index, boolean[] visited) {

    for (int i = 0; i < graph.length; ++i) {
      if (graph[index][i] == 1) {
        if (flag[i])
          return true;
        visited[i] = true;
        flag[i] = true;
        boolean res = dfs(graph, flag, i, visited);
        if(res) return true;
        flag[i] = false;// is important to backtrace
      }
    }
    return false;
  }

  
  public boolean canFinishTo(int numCourses, int[][] prerequisites) {
    if (prerequisites == null || prerequisites.length <= 0)
      return true;
    int[][] graph = new int[numCourses][numCourses];
    int inCnt[] = new int[numCourses];
    for (int i = 0; i < numCourses; ++i) {
      inCnt[i] = 0;
      for (int j = 0; j < numCourses; ++j)
        graph[i][j] = 0;
    }    
    
    for (int i = 0; i < prerequisites.length; ++i){
      if(0 == graph[prerequisites[i][0]][prerequisites[i][1]])
        inCnt[prerequisites[i][1]]++;
      graph[prerequisites[i][0]][prerequisites[i][1]] = 1; 
    }
    
    for (int i = 0; i < numCourses; ++i) {
      boolean isFind = false;
      for (int j = 0; j < numCourses; ++j){
        if(inCnt[j] == 0){
          isFind = true;
          for(int m = 0; m < numCourses; ++m)
            if(graph[j][m] == 1)
              inCnt[m]--;
          inCnt[j] = -1;
          break;
        }
      }
      if(!isFind) return false;
    }
    return true;
  }
  
  
  public int[] findOrder(int numCourses, int[][] prerequisites) {
    if (prerequisites == null || prerequisites.length <= 0)
      return new int[0];
    int[][] graph = new int[numCourses][numCourses];
    int inCnt[] = new int[numCourses];
    for (int i = 0; i < numCourses; ++i) {
      inCnt[i] = 0;
      for (int j = 0; j < numCourses; ++j)
        graph[i][j] = 0;
    }    
    
    for (int i = 0; i < prerequisites.length; ++i){
      if(0 == graph[prerequisites[i][0]][prerequisites[i][1]])
        inCnt[prerequisites[i][1]]++;
      graph[prerequisites[i][0]][prerequisites[i][1]] = 1; 
    }
    
    int[] res = new int[numCourses];
    
    for (int i = 0; i < numCourses; ++i) {
      boolean isFind = false;
      for (int j = 0; j < numCourses; ++j){
        if(inCnt[j] == 0){
          isFind = true;
          res[numCourses - i - 1] = j;
          for(int m = 0; m < numCourses; ++m)
            if(graph[j][m] == 1)
              inCnt[m]--;
          inCnt[j] = -1;
          break;
        }
      }
      if(!isFind) return new int[0];
    }
    return res;
  }
  
  public static void main(String[] args) {
    ld207 ld = new ld207();
    int[][] a = { {1,0}};
    
    System.out.println(ld.canFinishTo(2, a));
    int[] res = ld.findOrder(2, a);
    for(int i=0;i < res.length; ++i)
      System.out.print(res[i]+ " ");
    
    int[][] b = {{0,1},{0,2},{1,2}};
    System.out.println(ld.canFinishTo(3, b));
    res = ld.findOrder(3, b);
    for(int i=0;i < res.length; ++i)
      System.out.print(res[i]+ " ");
    
    int[][] c = {{5,8},{3,5},{1,9},{4,5},{0,2},{1,9},{7,8},{4,9}};
    System.out.println(ld.canFinishTo(10, c));
    res = ld.findOrder(10, c);
    for(int i=0;i < res.length; ++i)
      System.out.print(res[i]+ " ");
  }
}
