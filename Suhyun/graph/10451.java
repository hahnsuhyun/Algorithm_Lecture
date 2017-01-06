import java.util.*;


public class Main {
	public static void dfs(int i, boolean[] visit, int M, int[][] ver){
		visit[i] = true;
		for(int j =1; j<=M;j++){
			if(ver[i][j]==1 &&visit[j]==false){
				dfs(j,visit,M,ver);
			}
		}
	}
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int cas = sc.nextInt();
		for (int q= 0;q<cas;q++){
			int N = sc.nextInt();        
			int cnt = 0;
			int[][] ver = new int[N+1][N+1];
			boolean[] visit=new boolean[N+1];
			int temp =N;
			while(N>0){
				int verN =temp -N+1;
				int vertoN = sc.nextInt();
				//System.out.println(verN+" "+vertoN);
				ver[verN][vertoN]=1;
				ver[vertoN][verN]=1;
				--N;
			}
			for(int i=1;i<=temp;i++){
				/*for(int j=1;j<=N;j++){*/
				if(/*(ver[i][j]==1)&&*/visit[i] == false){cnt++;dfs(i,visit,temp,ver);}        
				//}     
			}
			System.out.println(cnt);
		}
	}
}