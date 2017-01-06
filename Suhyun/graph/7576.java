import java.util.*;
class Pair{
	int x;
	int y;
	Pair(int x, int y){
		this.x=x;
		this.y=y;
	}
}

public class Main {


	static boolean safeCheck(int x,int y, int N,int M){
		return (0<=x &&x<N)&&(0<=y&&y<M);
	}

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();


		int[][] map = new int[M][N];
		int[][] dist = new int[M][N];
		Queue <Pair> q = new <Pair> LinkedList();
		for(int i=0; i<M;i++){
			for(int j=0; j<N;j++){		
				map[i][j]=sc.nextInt();
				dist[i][j]=-1;
				if(map[i][j]==1){
					q.offer(new Pair(i,j));
					dist[i][j]=0;
					//System.out.println(i+" "+j);
				}
			}			
		} 
		/*
		for(int i=0; i<M;i++){
			for(int j=0; j<N;j++){		
				System.out.print(map[i][j]);				
			}
			System.out.println();
		} 
		for(int i=0; i<M;i++){
			for(int j=0; j<N;j++){		
				System.out.print(dist[i][j]);				
			}
			System.out.println();
		}*/
		
		while(!q.isEmpty()){
			Pair temp= q.remove();
			//System.out.println(temp.x+" "+temp.y);
			if(safeCheck(temp.x-1,temp.y,M,N)&& map[temp.x-1][temp.y]==0&&dist[temp.x-1][temp.y]==-1)
				{q.offer(new Pair(temp.x-1,temp.y));dist[temp.x-1][temp.y]=dist[temp.x][temp.y]+1;}
			if(safeCheck(temp.x+1,temp.y, M,N)&& map[temp.x+1][temp.y]==0&&dist[temp.x+1][temp.y]==-1)
				{q.offer(new Pair(temp.x+1,temp.y));dist[temp.x+1][temp.y]=dist[temp.x][temp.y]+1;}
			if(safeCheck(temp.x,temp.y+1, M,N)&& map[temp.x][temp.y+1]==0&&dist[temp.x][temp.y+1]==-1)
				{q.offer(new Pair(temp.x,temp.y+1));dist[temp.x][temp.y+1]=dist[temp.x][temp.y]+1;}
			if(safeCheck(temp.x,temp.y-1, M,N)&& map[temp.x][temp.y-1]==0&&dist[temp.x][temp.y-1]==-1)
				{q.offer(new Pair(temp.x,temp.y-1));dist[temp.x][temp.y-1]=dist[temp.x][temp.y]+1;}	
		}

		int ans = 0; 
		for (int i=0; i<M; i++) { 
			for (int j=0; j<N; j++) { 
				if (ans < dist[i][j]) { 
					ans = dist[i][j]; 
				} 
			} 
		}
		
		for (int i=0; i<M; i++) { 
			for (int j=0; j<N; j++) { 
				if (map[i][j] == 0 && dist[i][j] == -1) { 
					ans = -1; 
				} 
			} 
		} 
		/*
		for(int i=0; i<M;i++){
			for(int j=0; j<N;j++){		
				System.out.print(dist[i][j]);				
			}
			System.out.println();
		}*/
		System.out.println(ans);

	}
}