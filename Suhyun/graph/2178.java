import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;



class Pair{
	int x;
	int y;
	Pair(int x, int y){
		this.x=x;
		this.y=y;
	}
}

public class Main {


	static boolean safeCheck(int x,int y, int M,int N){
		return (0<=x &&x<M)&&(0<=y&&y<N);
	}


	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int N = sc.nextInt();


		int[][] map = new int[M][N];
		int[][] dist = new int[M][N];
		Queue <Pair> q = new <Pair>LinkedList();
		for(int i=0; i<M;i++){
			for(int j=0; j<N;j++){		
				map[i][j]=sc.nextInt();
				dist[i][j]=-1;				
			}			
		} 
		q.offer(new Pair(0,0));
		dist[0][0]=0;
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
		boolean flag = false;
		while(!q.isEmpty()){
			Pair temp= q.remove();
			//System.out.println(temp.x+" "+temp.y);
			if(safeCheck(temp.x-1,temp.y,M,N)&& map[temp.x-1][temp.y]==1&&dist[temp.x-1][temp.y]==-1)
				{q.offer(new Pair(temp.x-1,temp.y));dist[temp.x-1][temp.y]=dist[temp.x][temp.y]+1;
				if(temp.x-1==M&&temp.y==N) {flag=true; break;}}
			if(safeCheck(temp.x+1,temp.y, M,N)&& map[temp.x+1][temp.y]==1&&dist[temp.x+1][temp.y]==-1)
				{q.offer(new Pair(temp.x+1,temp.y));dist[temp.x+1][temp.y]=dist[temp.x][temp.y]+1;
				if(temp.x+1==M&&temp.y==N) {flag=true; break;}}
			if(safeCheck(temp.x,temp.y+1, M,N)&& map[temp.x][temp.y+1]==1&&dist[temp.x][temp.y+1]==-1)
				{q.offer(new Pair(temp.x,temp.y+1));dist[temp.x][temp.y+1]=dist[temp.x][temp.y]+1;
				if(temp.x==M&&temp.y+1==N) {flag=true; break;}}		
			if(safeCheck(temp.x,temp.y-1, M,N)&& map[temp.x][temp.y-1]==1&&dist[temp.x][temp.y-1]==-1)
				{q.offer(new Pair(temp.x,temp.y-1));dist[temp.x][temp.y-1]=dist[temp.x][temp.y]+1;
				if(temp.x==M&&temp.y-1==N) {flag=true; break;}}	
			if(flag){q.clear(); break;}
		}

	
		/*
		for(int i=0; i<M;i++){
			for(int j=0; j<N;j++){		
				System.out.print(dist[i][j]);				
			}
			System.out.println();
		}*/
		System.out.println(dist[M-1][N-1]+1);

	}
}