import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;

import javax.imageio.IIOException;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class AnimalGUI extends Application {
	static ArrayList<Animal> animalList = new ArrayList<>();
	static HashMap<Animal, Color> hashMap = new HashMap<>();
	static Color[] colorList = {Color.BLUE,Color.RED,Color.GREEN,Color.YELLOW,Color.PURPLE,Color.BLACK,Color.BROWN,Color.MAGENTA,Color.BEIGE,Color.CYAN};
	static ArrayList<Animal> nameList = new ArrayList<>();
	static ObservableList<Animal> obNameList;
	
	public static void main(String[] args) {
		 try
	        {
	            ObjectInputStream input = new ObjectInputStream(new FileInputStream("animal.dat"));
	            
	            
	            // write each Animal in turn
	            while(true)
	            {
	                Animal myAnimal =  (Animal) input.readObject();
	                animalList.add(myAnimal);
	            }
	            
	        }
	        catch (IOException e)
	        {
	            
	        } catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 for(int i = 0; i < animalList.size(); i++) {
			 int code = Math.abs(animalList.get(i).hashCode()) % 10;
			 hashMap.put(animalList.get(i), colorList[code]);
		 }
		 Set<Animal> set = hashMap.keySet();
		 for(Animal x: set) {
			 nameList.add(x);
		 }
		 launch();
		 
		 
		 
	        
	    }

	@Override
	
		// TODO Auto-generated method stub
		 // convert array to arrayList
       
		public void start(Stage primaryStage)
	    {
			obNameList = (FXCollections.observableArrayList(nameList));
	       
	       
	        
	        
	        ListView<Animal> lv = new ListView<>(obNameList);
	        lv.setPrefSize(400, 400);
	        lv.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
	        ScrollPane scrollP= new ScrollPane(lv);
	        // create a ListView to display the values in nameList. Make it single
	        // selection and add
	        // into scrollP
	       
	      
	        // Create a pane to hold image views
	        FlowPane imagePane = new FlowPane(10, 10);
	        BorderPane pane = new BorderPane();
	        pane.setLeft(scrollP);
	        pane.setCenter(imagePane);

	        // Create a shape of your choosing and add to imagePane
	        Circle r1 = new Circle(50,50,50);
	        imagePane.getChildren().add(r1);
	     

	        lv.getSelectionModel().selectedItemProperty().addListener(
	        	      ov -> { 
	        	    	  Animal name = obNameList.get(lv.getSelectionModel().getSelectedIndex());
	        	    	  r1.setFill(hashMap.get(name));
	        	        });
	        

	      

	        // add button
	        Button addButton = new Button("Add a Name");

	        pane.setBottom(addButton);

	        addButton.setOnAction(e -> launchNewStage());
	        
	      

	        Scene scene = new Scene(pane, 600, 170);
	        primaryStage.setTitle("Name color demo"); // Set the stage title
	        primaryStage.setScene(scene); // Place the scene in the stage
	        primaryStage.show(); // Display the stage
	    }

		/**
		 * Method launchNewStage()
		 * 
		 * Launches new stage 
		 * 
		 */
	    private void launchNewStage()
	    {
	        new NameStage(this);
	    }

	    /**
		 * Method addName()
		 * 
		 * adds a name to the observable array
		 * 
		 * @param n
		 */
	    void addAName(Animal n)
	    {
	        obNameList.add(n);
	    }
	
	
	
	

	}


