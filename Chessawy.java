package experiments;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import javax.print.attribute.standard.PrinterName;

public class Chessawy {
    
	static char[][] board=new char[3][3];
	static int RoundNo=0;
	
	public static void main(String[] args) throws IOException {
		System.out.println("~~~~~~~~~");
		System.out.println("| FIGHT |");
		System.out.println("~~~~~~~~~");
		BufferedReader br=new BufferedReader(new InputStreamReader (System.in));
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				board[i][j]='-';
			}
		}
		int x=(int)(Math.random()*10);
		boolean flag=x%2==0;
		printBoard();
		if(flag)
			System.out.println("~~~ YOU WILL BEGIN ~~~");
		else
			System.out.println("~~~ CHESSAWY WILL BEGIN ~~~");
		System.out.println();
		while(RoundNo<10) {
			if(flag) {
				String t=br.readLine();
				String [] ta=t.split(" ");
				board[Integer.parseInt(ta[0])][Integer.parseInt(ta[1])]='O';
				flag=false;
//				String s=Chessawy();
//				String []sa=s.split(" ");
//				board[Integer.parseInt(sa[0])][Integer.parseInt(sa[1])]='O';
//				flag=false;
			}
			else {
				String s=Chessawy();
				String []sa=s.split(" ");
				board[Integer.parseInt(sa[0])][Integer.parseInt(sa[1])]='X';
				flag=true;
			}
			printBoard();
			if(DidWin()!=-1)
				break;
		}
		if(DidWin()==0)
			System.out.println("~~~~ YOU WON ~~~~");
		else if(DidWin()==1)
			System.out.println("~~~~ CHESSAWY WON ~~~~");
		else
			System.out.println("IT's A DRAW :(");
	}
	
	public static void printBoard() {
		System.out.println("Round:"+RoundNo++);
		System.out.println();
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				System.out.print(board[i][j]);
				if(j<2)
					System.out.print(" | ");
			}
			System.out.println();
			if(i<2)
				System.out.println("---------");
		}
		System.out.println();
		System.out.println("=============");
		System.out.println();
	}
	
	public static int DidWin() {
		int ans=-1;
		if(board[0][0]=='X' & board[2][2]=='X' & board[1][1]=='X' | board[0][2]=='X' & board[2][0]=='X' & board[1][1]=='X'  | board[1][2]=='X' & board[1][0]=='X' & board[1][1]=='X' | board[0][1]=='X' & board[2][1]=='X' & board[1][1]=='X' | board[0][0]=='X' & board[1][0]=='X' & board[2][0]=='X' | board[0][0]=='X' & board[0][1]=='X' & board[0][2]=='X' | board[0][2]=='X' & board[1][2]=='X' & board[2][2]=='X' | board[2][0]=='X' & board[2][1]=='X' & board[2][2]=='X') {
			ans=1;//Chessawy won
		}
		if(board[0][0]=='O' & board[2][2]=='O' & board[1][1]=='O' | board[0][2]=='O' & board[2][0]=='O' & board[1][1]=='O'  | board[1][2]=='O' & board[1][0]=='O' & board[1][1]=='O' | board[0][1]=='O' & board[2][1]=='O' & board[1][1]=='O' | board[0][0]=='O' & board[1][0]=='O' & board[2][0]=='O' | board[0][0]=='O' & board[0][1]=='O' & board[0][2]=='O' | board[0][2]=='O' & board[1][2]=='O' & board[2][2]=='O' | board[2][0]=='O' & board[2][1]=='O' & board[2][2]=='O') {
			ans=0;//person won
		}
		return ans;
	}

	public static String Chessawy() {
		if(RoundNo==1) {
			return (int)(Math.random()*3)+" "+(int)(Math.random()*3);
		}
		else {
			return firstPr();
		}
	}
	
	public static String firstPr() {
		int[][] pr=new int[3][3];
		ArrayList<String> a=new ArrayList<String>();
		int max=0;
		if(board[0][0]=='-') {
			int n=0;
			int z=0;
			if(board[0][1]=='O' & board[0][2]=='O' | board[1][0]=='O' & board[2][0]=='O' | board[1][1]=='O' & board[2][2]=='O')
				n=8;
			if(board[0][1]=='X' & board[0][2]=='X' | board[1][0]=='X' & board[2][0]=='X' | board[1][1]=='X' & board[2][2]=='X')
				n=10;
			if(board[0][1]=='O')
				z++;
			if(board[0][2]=='O')
				z++;
			if(board[1][0]=='O')
				z++;
			if(board[2][0]=='O')
				z++;
			if(board[1][1]=='O')
				z++;
			if(board[2][2]=='O')
				z++;
			pr[0][0]=Math.max(z, n);
		}
		if(board[0][2]=='-') {
			int n=0;
			int z=0;
			if(board[0][1]=='O' & board[0][0]=='O' | board[1][1]=='O' & board[2][0]=='O' | board[1][2]=='O' & board[2][2]=='O')
				n=8;
			if(board[0][1]=='X' & board[0][0]=='X' | board[1][1]=='X' & board[2][0]=='X' | board[1][2]=='X' & board[2][2]=='X')
				n=10;
			if(board[0][1]=='O')
				z++;
			if(board[0][0]=='O')
				z++;
			if(board[1][1]=='O')
				z++;
			if(board[2][0]=='O')
				z++;
			if(board[1][2]=='O')
				z++;
			if(board[2][2]=='O')
				z++;
			pr[0][2]=Math.max(z, n);
		}
		if(board[2][0]=='-') {
			int n=0;
			int z=0;
			if(board[1][1]=='O' & board[0][2]=='O' | board[1][0]=='O' & board[0][0]=='O' | board[2][1]=='O' & board[2][2]=='O')
				n=8;
			if(board[1][1]=='X' & board[0][2]=='X' | board[1][0]=='X' & board[0][0]=='X' | board[2][1]=='X' & board[2][2]=='X')
				n=10;
			if(board[1][1]=='O')
				z++;
			if(board[0][2]=='O')
				z++;
			if(board[1][0]=='O')
				z++;
			if(board[0][0]=='O')
				z++;
			if(board[2][1]=='O')
				z++;
			if(board[2][2]=='O')
				z++;
			pr[2][0]=Math.max(z, n);
		}
		if(board[2][2]=='-') {
			int n=0;
			int z=0;
			if(board[0][0]=='O' & board[1][1]=='O' | board[2][1]=='O' & board[2][0]=='O' | board[1][2]=='O' & board[0][2]=='O')
				n=8;
			if(board[0][0]=='X' & board[1][1]=='X' | board[2][1]=='X' & board[2][0]=='X' | board[1][2]=='X' & board[0][2]=='X')
				n=10;
			if(board[0][0]=='O')
				z++;
			if(board[1][1]=='O')
				z++;
			if(board[2][1]=='O')
				z++;
			if(board[2][0]=='O')
				z++;
			if(board[1][2]=='O')
				z++;
			if(board[0][2]=='O')
				z++;
			pr[2][2]=Math.max(z, n);
		}
		if(board[1][1]=='-') {
			int n=0;
			int z=0;
			if(board[0][0]=='O' & board[2][2]=='O' | board[0][2]=='O' & board[2][0]=='O' | board[1][2]=='O' & board[1][0]=='O' | board[0][1]=='O' & board[2][1]=='O')
				n=8;
			if(board[0][0]=='X' & board[2][2]=='X' | board[0][2]=='X' & board[2][0]=='X' | board[1][2]=='X' & board[1][0]=='X' | board[0][1]=='X' & board[2][1]=='X')
				n=10;
			if(board[0][0]=='O')
				z++;
			if(board[0][1]=='O')
				z++;
			if(board[0][2]=='O')
				z++;
			if(board[1][0]=='O')
				z++;
			if(board[1][2]=='O')
				z++;
			if(board[2][0]=='O')
				z++;
			if(board[2][1]=='O')
				z++;
			if(board[2][2]=='O')
				z++;
			pr[1][1]=Math.max(z, n);
		}
		if(board[0][1]=='-') {
			int n=0;
			int z=0;
			if(board[0][0]=='O' & board[0][2]=='O' | board[2][1]=='O' & board[1][1]=='O')
				n=8;
			if(board[0][0]=='X' & board[0][2]=='X' | board[2][1]=='X' & board[1][1]=='X')
				n=10;
			if(board[0][0]=='O')
				z++;
			if(board[0][2]=='O')
				z++;
			if(board[2][1]=='O')
				z++;
			if(board[1][1]=='O')
				z++;
			pr[0][1]=Math.max(z, n);
		}
		if(board[1][0]=='-') {
			int n=0;
			int z=0;
			if(board[0][0]=='O' & board[2][0]=='O' | board[1][1]=='O' & board[1][2]=='O')
				n=8;
			if(board[0][0]=='X' & board[2][0]=='X' | board[1][1]=='X' & board[1][2]=='X')
				n=10;
			if(board[0][0]=='O')
				z++;
			if(board[2][0]=='O')
				z++;
			if(board[1][2]=='O')
				z++;
			if(board[1][1]=='O')
				z++;
			pr[1][0]=Math.max(z, n);
		}
		if(board[2][1]=='-') {
			int n=0;
			int z=0;
			if(board[0][1]=='O' & board[1][1]=='O' | board[2][0]=='O' & board[2][2]=='O')
				n=8;
			if(board[0][1]=='X' & board[1][1]=='X' | board[2][0]=='X' & board[2][2]=='X')
				n=10;
			if(board[0][1]=='O')
				z++;
			if(board[1][1]=='O')
				z++;
			if(board[2][0]=='O')
				z++;
			if(board[2][2]=='O')
				z++;
			pr[2][1]=Math.max(z, n);
		}
		if(board[1][2]=='-') {
			int n=0;
			int z=0;
			if(board[1][0]=='O' & board[1][1]=='O' | board[2][2]=='O' & board[0][2]=='O')
				n=8;
			if(board[1][0]=='X' & board[1][1]=='X' | board[2][2]=='X' & board[0][2]=='X')
				n=10;
			if(board[1][0]=='O')
				z++;
			if(board[1][1]=='O')
				z++;
			if(board[2][2]=='O')
				z++;
			if(board[0][2]=='O')
				z++;
			pr[1][2]=Math.max(z, n);
		}
		for(int i=0;i<3;i++) {
//			System.out.println(Arrays.toString(pr[i]));
			for(int j=0;j<3;j++) {
				max=Math.max(max, pr[i][j]);
			}
		}
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				if(pr[i][j]==max) {
					a.add(i+" "+j);
				}
			}
		}
//		System.out.println(a);
		int z=(int)(Math.random()*a.size());
//		System.out.println(z);
		return a.get(z);
	}
}
