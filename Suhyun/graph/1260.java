import java.util.*;


public class Main {
	public static void dfs(int i, boolean[] visit, int M, int[][] ver){
		visit[i] = true;
		System.out.print((i)+" ");
		for(int j =1; j<=M;j++){
			if(ver[i][j]==1 &&visit[j]==false){
				dfs(j,visit,M,ver);
			}
		}
	}
	public static void bfs(int i, boolean[] visitb,int M, int[][]ver ){
		Queue <Integer> q = new <Integer> LinkedList();
		q.offer(i);
		visitb[i]=true;
		while(!q.isEmpty()){
			int temp=q.poll();
			System.out.print((temp)+" ");
			for(int j=1;j<=M;j++){
				if(ver[temp][j]==1 && visitb[j]==false){
					q.offer(j);
					visitb[j]=true;
				}
			}
		}
	}
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int V = sc.nextInt();
        
        int[][] ver = new int[N+1][N+1];
        boolean[] visit=new boolean[N+1];
       
        while(sc.hasNext()){
        	int verN = sc.nextInt();
        	int vertoN = sc.nextInt();
        	ver[verN][vertoN]=1;
        	ver[vertoN][verN]=1;        	       	
        }  
        dfs(V,visit,N,ver);
        System.out.println();
        boolean[] visitb=new boolean[N+1];
        bfs(V,visitb,N,ver);        
	}
}