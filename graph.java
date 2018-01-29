
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

import org.w3c.dom.Node;

//constructr for the graph
public class graph {
	        int Vertices; //number of elemets in the adjencyList
	        LinkedList<Integer> adjListArray[]; 
	        Hashtable hs;
	        Hashtable hs2;
	        
	        graph(int vertices)
	        {
	            this.Vertices = vertices;
	            adjListArray = new LinkedList[vertices];
	            for(int i = 0; i < vertices ; i++){
	                adjListArray[i] = new LinkedList<>();
	            }
	        }
	        //gets the hashtables from the "readdatabase" class
	    public void getHastables(Hashtable hs, Hashtable hs2) {
	    	 this.hs = hs;
	    	 this.hs2 = hs2;
	    }
	     
	  public void addEdge( int v1, int v2)
	    {
	        adjListArray[v1].addFirst(v2);
	       // adjListArray[v2].addFirst(v1);
	    }
	  
	    public void shortestPathBFS(int start, int finish){
	    	//map that gets the path the graph traveled
	    	Map<Integer, Integer> prev = new HashMap<Integer, Integer>();
	    	int s = start;
	        boolean visited[] = new boolean[Vertices];
	        //keeps track of the vertices that has been visited
	        LinkedList<Integer> queue = new LinkedList<Integer>();
	        visited[start]=true;
	        queue.add(start);
	        //while queue isnt empty 
	        while (queue.size() != 0)
	        {
	        		start = queue.poll();
	        		if(start == finish) {	
	        			//if found break
	        			break;
	            }
	            else {
	            	//gets iterator that iteraters over the linked list per actor that is 
	            	//currently been checked
	            Iterator<Integer> i = adjListArray[start].listIterator();
	            while (i.hasNext())
	            {
	                int n = i.next();
	                if (!visited[n])
	                {
	                    visited[n] = true;
	                    queue.add(n);
	                     prev.put(n,start);
	                }
	            }
	            }
	            
	        }
	    if(start != finish) {
	    System.out.println("there is no path between" + hs2.get(s) + " and " + hs2.get(finish));
	    }
	    else {
	    System.out.println("Path between " + hs2.get(s) + " and "+ hs2.get(finish));
	    int current = finish;
	    Stack<Integer> stack = new Stack<>();
	    stack.push(current); 
	    while (prev.containsKey(current)) {
	      current = prev.get(current);
	      stack.push(current);
	    }
	 for(int i =stack.size()-1; i >= 0;i--) {
		 System.out.print(" ---> " + hs2.get(stack.get(i)));
	
	 }
	    }

	    }
}
