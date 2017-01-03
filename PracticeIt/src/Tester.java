import java.util.ArrayList;

public class Tester {

	public static void mystery1(ArrayList<Integer> list) { 
	    for (int i = list.size() - 1; i > 0; i--) { 
	        if (list.get(i) < list.get(i - 1)) { 
	            int element = list.get(i); 
	            list.remove(i); 
	            list.add(0, element); 
	        } 
	    } 
	    System.out.println(list); 
	} 
	public static void main(String[] args) {
		
		ArrayList<Integer> p = new ArrayList<Integer>();
		
		p.add(30);
		p.add(20);
		p.add(10);
		p.add(60);
		p.add(50);
		p.add(40);
		//p.add(36);
		//p.add(4);
		//p.add(49);
		
		mystery1(p);
		
		
		
	}

}
