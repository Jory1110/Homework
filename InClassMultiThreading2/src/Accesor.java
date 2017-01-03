import java.util.Set;

import javafx.scene.paint.Color;

public class Accesor implements Runnable {

	
	MyHashMap<String, Color> hash;

	public Accesor(MyHashMap<String, Color> x)
	{
		hash = x;
	}
	public void run() {
		
		try{
			Set<String> fred;
			for(int i = 1; i < 11;i++){
			fred = hash.keySet();
			
			System.out.println();
			System.out.println("The Contents of the Hash Map are: ");
			for(String x: fred)
			{
				
				System.out.println(" Key: " + x + " Value: " + hash.get(x).toString());
				
				
			}
			Thread.sleep(1000);}
		}catch (InterruptedException exception) {}	
		
		
	}

}
