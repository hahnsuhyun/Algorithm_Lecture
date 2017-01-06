import java.util.*;
import java.io.*;

public class Main {
	static boolean safeCheck(int a, int b, int inputN){
		return (0<=a && a<inputN)&&(0<=b&&b<inputN);
	}
	static void dfs(int a, int b, int c, int inputN, int[][] A){
		A[a][b]=c;
		if(safeCheck(a+1,b,inputN)&&A[a+1][b]==1)
			dfs(a+1,b,c,inputN,A);		
		if(safeCheck(a-1,b,inputN)&&A[a-1][b]==1)
			dfs(a-1,b,c,inputN,A);
		if(safeCheck(a,b+1,inputN)&&A[a][b+1]==1)
			dfs(a,b+1,c,inputN,A);
		if(safeCheck(a,b-1,inputN)&&A[a][b-1]==1)
			dfs(a,b-1,c,inputN,A);		
	}
	public static void main(String[] args){
		Scanner scin = new Scanner(System.in);

		List<Integer> list= new ArrayList<Integer>();

		int inputN = Integer.parseInt(scin.nextLine());		
		int[][] A= new int[inputN][inputN];
		int[] A1= new int[inputN*inputN];

		for(int i=0; i<inputN;i++){
			String temp=scin.nextLine();
			for(int j=0; j<inputN;j++){		
				A[i][j]=(temp.charAt(j)-'0');
			}			
		}

		int cnt=1;

		for(int i=0; i<inputN; i++){
			for(int j=0; j<inputN; j++){
				if(A[i][j]==1){	
					dfs(i,j,++cnt,inputN,A);					
				}
			}
		}

		for(int i=0; i<inputN;i++){
			for(int j=0; j<inputN;j++){
				if(A[i][j]>0)
					A1[A[i][j]-2]=A1[A[i][j]-2]+1;
			}			
		}
		
		int count=0;
		for(int j=0; j<inputN*inputN;j++){

			if(A1[j]>0){
				list.add(A1[j]);
				count++;}
		}
		Collections.sort(list);
		System.out.println(count);
		Iterator<Integer> itr=list.iterator();
		while(itr.hasNext()){
			int q=itr.next();
			if(q!=0) System.out.println(q);
		}

	}
}