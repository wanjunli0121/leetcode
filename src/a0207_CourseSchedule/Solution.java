/*
There are a total of n courses you have to take, labeled from 0 to n - 1.
Some courses may have prerequisites,
for example to take course 0 you have to first take course 1,
which is expressed as a pair: [0,1]
Given the total number of courses and a list of prerequisite pairs,
is it possible for you to finish all courses?
For example:
2, [[1,0]]
There are a total of 2 courses to take.
To take course 1 you should have finished course 0.
So it is possible.
2, [[1,0],[0,1]]
There are a total of 2 courses to take.
To take course 1 you should have finished course 0,
and to take course 0 you should also have finished course 1.
So it is impossible.
Note:
The input prerequisites is a graph represented by a list of edges,
not adjacency matrices.
Read more about how a graph is represented.
Hints:
This problem is equivalent to finding if a cycle exists in a directed graph.
If a cycle exists, no topological ordering exists
and therefore it will be impossible to take all courses.
Topological Sort via DFS - A great video tutorial (21 minutes) on Coursera
explaining the basic concepts of Topological Sort.
Topological sort could also be done via BFS.
*/

package a0207_CourseSchedule;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] graph = new ArrayList[numCourses];
        int[] indegree = new int[numCourses];
        Queue<Integer> queue = new LinkedList<Integer>();
        int count = 0;
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < prerequisites.length; i++) {
            indegree[prerequisites[i][0]]++;
            graph[prerequisites[i][1]].add(prerequisites[i][0]);
        }
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            int course = queue.poll();
            count++;
            for (int i = 0; i < graph[course].size(); i++) {
                int t = graph[course].get(i);
                indegree[t]--;
                if (indegree[t] == 0) {
                    queue.offer(t);
                }
            }
        }
        return count == numCourses;
    }

}
