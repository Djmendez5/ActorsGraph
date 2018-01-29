import java.io.IOException;
import java.util.Scanner;

public class Driver {
	
	
	public static void main(String[] args) throws IOException {
		//String file =args[0];
		//bd.readInFile(file);
		
		//System.out.println(file);
		
		
		readdatabase bd = new readdatabase();
		bd.readInFile("tmdb_5000_credits.csv");
		
		Hashtable hs = new Hashtable(500000);
		Hashtable hs2 = new Hashtable(500000);
		//String file =args[1];
		hs = bd.gethashtable1();
		 hs2 = bd.gethashtable2();
		 
		 graph g = bd.getgraph();
		 String actor1;
		 String actor2;
		 System.out.println("type the name of Actor 1");
		 Scanner scan = new Scanner(System.in);
		 actor1 = scan.nextLine();
		 if(hs.get(actor1)==null) {
			System.out.println("No such actor");
		 }
		 else {
			System.out.println("type name of Actor 2 ");
			 actor2 = scan.nextLine();
			if(hs.get(actor2)==null) {
				System.out.println("No such actor");
			}
			else {
				int start = (int) hs.get(actor1);
				int finish = (int) hs.get(actor2);
				g.shortestPathBFS(start, finish);
				
			}
			 
		 }
		
	}
	



}
