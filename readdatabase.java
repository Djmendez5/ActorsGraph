import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class readdatabase {
String[] split;


Hashtable hs = new Hashtable(500000);
Hashtable hs2 = new Hashtable(500000);
graph g= new graph(500000);	
//make two hastables and a graph
	public void readInFile(String filename) throws IOException{

		FileReader files = new FileReader(filename); 	
		BufferedReader br = new BufferedReader(files);
		String line;
		int s=0;
		line = br.readLine();
		int count1=0;
		String titlesOnly="";
		//read the file
		while ((line = br.readLine()) != null){
			split= line.split(",");
			ArrayList arr = new ArrayList();	
			//resets arr after every movie (line)
			for(int i=0; i<split.length; i++) {
					if(split[i].contains("name")) {
						
						String replace1 = split[i].replace("}", "");
						String replace2 = replace1.replace("]", "");
						String replace3 = replace2.replace("\"\"", "");
						String replace4 = replace3.replace("\"", "");
						String titlesOnlypre = replace4.replace("name: ","");
						titlesOnly =titlesOnlypre.trim();
		//getting rid of the trash in the file
						if(hs.get(titlesOnly)==null) {
							count1++;
		//count is the specific number for each differnet actor which is put in the hastables
		// then in the graph 
							hs.put(titlesOnly, count1);
							hs2.put(count1, titlesOnly);
						}
						//arr contains an array of all the movies for each movie
						arr.add(titlesOnly);
					}
					
				}
			for(int po = 0; po < arr.size(); po++) {
				for(int po2 = 0; po2 < arr.size(); po2++) {
					if(hs.get(arr.get(po)) != hs.get(arr.get(po2))) {
					g.addEdge((int)hs.get(arr.get(po)), (int)hs.get(arr.get(po2)));
				}
				// make edges between every actor froma  movie
				}
			}	
			s++;
			
		}
		
	g.getHastables(hs, hs2);
	}
	//two getter to send the two hashtables created here
 public Hashtable gethashtable1() {
	 return hs;
 }
public Hashtable gethashtable2() {
	return hs2;
}
public graph getgraph() {
	return g;
}
}
