import java.util.*;
import java.io.*;

public class Main {
	static boolean safeCheck(int a, int b, int inputN,int inputH){
		return (0<=a && a<inputN)&&(0<=b&&b<inputH);
	}
	static void dfs(int a, int b, int c, int inputN,int inputH, int[][] A){
		A[a][b]=c;
		if(safeCheck(a+1,b,inputN,inputH)&&A[a+1][b]==1)
			dfs(a+1,b,c,inputN,inputH,A);		
		if(safeCheck(a-1,b,inputN,inputH)&&A[a-1][b]==1)
			dfs(a-1,b,c,inputN,inputH,A);
		if(safeCheck(a,b+1,inputN,inputH)&&A[a][b+1]==1)
			dfs(a,b+1,c,inputN,inputH,A);
		if(safeCheck(a,b-1,inputN,inputH)&&A[a][b-1]==1)
			dfs(a,b-1,c,inputN,inputH,A);
		if(safeCheck(a+1,b+1,inputN,inputH)&&A[a+1][b+1]==1)
			dfs(a+1,b+1,c,inputN,inputH,A);		
		if(safeCheck(a-1,b-1,inputN,inputH)&&A[a-1][b-1]==1)
			dfs(a-1,b-1,c,inputN,inputH,A);
		if(safeCheck(a-1,b+1,inputN,inputH)&&A[a-1][b+1]==1)
			dfs(a-1,b+1,c,inputN,inputH,A);
		if(safeCheck(a+1,b-1,inputN,inputH)&&A[a+1][b-1]==1)
			dfs(a+1,b-1,c,inputN,inputH,A);
	}
	public static void main(String[] args){
		Scanner scin = new Scanner(System.in);
		while(true){
		List<Integer> list= new ArrayList<Integer>();
		int inputH= scin.nextInt();
		int inputW= scin.nextInt();	
		if(inputH==0&&inputW==0)break;
		
		int[][] A= new int[inputW][inputH];
		int[] A1= new int[inputW*inputH];
		
		
		for(int i=0; i<inputW;i++){
			for(int j=0; j<inputH;j++){		
				A[i][j]=scin.nextInt();
			}			
		}
	
		int cnt=1;
		
		for(int i=0; i<inputW; i++){
			for(int j=0; j<inputH; j++){
				if(A[i][j]==1){	
					dfs(i,j,++cnt,inputW,inputH,A);					
				}
			}
		}
		
		
		for(int i=0; i<inputW;i++){
			for(int j=0; j<inputH;j++){
				if(A[i][j]>0)
					A1[A[i][j]-2]=A1[A[i][j]-2]+1;
			}			
		}
		int count=0;
		for(int j=0; j<inputW*inputH;j++){
		
			if(A1[j]>0){
			list.add(A1[j]);
			count++;}
		}
		
		System.out.println(count);
		
		}
	}
}
