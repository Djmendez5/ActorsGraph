
public class Hashtable {
	Hashnode[]arr; //array					
	int elements; //size of the array
	//constructor for the Hashtable
	public Hashtable(int counter) {
	  arr = new Hashnode[counter];
	  elements=0;
	}
	//adds a key and value
	public void put(Object key, Object val) {
	Hashnode node = new Hashnode(key, val);
	int pos =  Math.abs(key.hashCode() % arr.length);
	Hashnode temp =  arr[pos];
	
	while(temp != null) {
		if(temp.key.equals(key)) {
			temp.value = val;
			return;
		}
	temp= temp.next;
	}
	elements++;
	temp = arr[pos];
	node.next =temp;
	arr[pos] = node;
	
	}
//returns the value of a certain key
	public Object get(Object key) {
		int pos =Math.abs(key.hashCode()% arr.length);
		
		Hashnode temp = arr[pos];
		while(temp!=null) {
			if(temp.key.equals(key)) {
				return temp.value;
			}
			temp =temp.next;
		}
		return null;
	}
//removes value and key by the value (not used in this project
	public Object remove(Object key) throws Exception {
		int pos= Math.abs(key.hashCode() %arr.length);
		Hashnode temp = arr[pos];
		Hashnode prev = null;
		if(temp!=null) {
		while(temp!= null) {
			if(temp.key.equals(key)) {
				break;
			}
			prev = temp;
            temp = temp.next;
		}
		}
		else if(temp==null) {
			throw new Exception("not found");
		}
		elements--;
		if(prev!=null) {
			prev.next = temp.next;
		}
		else {
			arr[pos]= temp.next;
		}
		return temp.value;
	}
//checks if certain key is found
	public boolean containsKey(Object key) {
		int pos= Math.abs(key.hashCode() %arr.length);
		Hashnode temp = arr[pos];
		if(temp!=null) {
		while(temp!= null) {
			if(temp.key.equals(key)) {
				return true;	
			}
            temp = temp.next;
		}
		}
		return false;
	}


}
