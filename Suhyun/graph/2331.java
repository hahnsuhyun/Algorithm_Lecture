import java.util.*;

class Test{
	String first=" ";
	int powNum;
	StringBuilder sb = new StringBuilder();

	Test(String input,int P){
		first = input;
		powNum = P;
		sb.append(first+" ");
	}	

	boolean flag2=true;

	int cal(){

		while(flag2){
			String testring=sb.toString();
			//System.out.println(testring);

			int len= first.length();		
			int sum=0;

			for(int i=0;i<len;i++){			
				sum+=Math.pow(first.charAt(i)-'0', powNum);			
			}
			first=String.valueOf(sum);
			sb.append(first+" ");

			boolean flag1=true;

			while(flag1){
				int count=0;					
				boolean flag = true;
				String temp=testring;
				String temp2;
				while(flag){					
					//System.out.println(temp);
					if (temp.indexOf(" ")==temp.length()-1){
						flag=false;
						flag1=false;
					}						
					//System.out.println(temp.indexOf(" "));
					//System.out.println(temp.length());
					temp2 = temp.substring(0,temp.indexOf(" "));
					count++;
					temp=temp.substring(temp.indexOf(" ")+1);
					//System.out.print(temp+ "     ");
					//System.out.println(temp2);
					String temp0=temp;
					while((temp0.indexOf(" ")!=(temp0.length()-1))){
						//System.out.println(temp0);
						//System.out.println("hi"+temp0.indexOf(" "));
						//System.out.println(temp0.length());
						if(temp0.substring(0,temp0.indexOf(" ")).equals(temp2)){
							//System.out.println("i'm in");												
							flag=false;
							flag1=false;							
							return(count-1);
						}
						temp0=temp0.substring(temp0.indexOf(" ")+1);						
					}
				}
			}							
		}		
		return 0;
	}
}

public class Main {
	public static void main(String[] args){

		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int P = sc.nextInt();

		Test t=new Test(String.valueOf(A),P);
		int count= t.cal();
		System.out.println(count);

	}
}