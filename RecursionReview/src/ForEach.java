import java.util.ArrayList;

public class ForEach {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> fred = new ArrayList<>();
		
		fred.add("george");
		fred.add("allen");
		fred.add("apple");
		fred.add("onion");
		fred.add("steven");
		fred.add("connor");
		fred.add("david");
		
		for(String ted: fred)
		{
			System.out.println(ted);
		}

	}

}
