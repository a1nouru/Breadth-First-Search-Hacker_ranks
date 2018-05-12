
import java.io.*;
import java.util.*;

public class Solution {
    public static class Position{
        int inde;
        
        int stepsMoved;
        public Position(int i, int s)
{
            inde =i;
            
            stepsMoved =s;
    }
            }
    public static int[] getShorestPathFunc(Graph G, int startIndex)
{
        int [] retGraph = new int[G.V()];
        Arrays.fill(retGraph, Integer.MAX_VALUE);
        
        Queue<Position> que = new LinkedList<Position>();
        Position startPos = new Position(startIndex, 0);
        retGraph[startIndex] =0;
        que.offer(startPos);
        
        while(!que.isEmpty())
{
            Position prev = que.poll();
            
            for(int nextIndex : G.getAdust(prev.inde))
{
                if(retGraph[nextIndex]!=Integer.MAX_VALUE) continue;
                retGraph[nextIndex] = prev.stepsMoved+1;
                Position nextPos = new Position(nextIndex, prev.stepsMoved+1);
                que.offer(nextPos);
        }
        }
        for(int i=0;i<retGraph.length;i++)
{
            if(retGraph[i]==Integer.MAX_VALUE)
                retGraph[i]=-1;
            else {retGraph[i]*=6;}
}
    return retGraph;
    }
    
    public static class Graph{
        int V;
        List<Integer>[] adjust;
        
        public Graph(int V)
{
            this.V = V;
            adjust = (List<Integer>[])new List[V];
            
            for(int i=0;i<V; i++){ adjust[i] = new ArrayList<>(); }
        }
        
        public int V(){ return this.V; }
        
        public void addNewEdge(int k, int p)
{
            adjust[k].add(p);
            adjust[p].add(k); }
        
        public List<Integer> getAdust(int k){ return adjust[k]; }

}
    public static void main(String[] args) {
        
        
        Scanner scan = new Scanner(System.in);
        int queryNum = scan.nextInt();
        
        for(int i=0;i<queryNum; i++)
{
            
            int vertexNum  = scan.nextInt();
            int Numedges = scan.nextInt();
      
