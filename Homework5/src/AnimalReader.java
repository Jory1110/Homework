/**
 * Class: AnimalReader
 * 
 * @author Robert Jory Alexander
 * @version 1.0 
 * Course : ITEC 3150, Spring, 2016 
 * Written: April 18, 2016
 * 
 * 
 * This class: Contains the information to read in a binary file add them to a hash map and provide a gui that allows for single selection from
 * list with a shape that changes color based on the selection. also allows for the addition of new animal objects into the hash map
 * 
 * Purpose: to complete to above task.
 *         
 *
 */

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javafx.application.Application;
import javafx.collections.FXCollections;
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

public class AnimalReader extends Application {
	
	static ArrayList<Animal> animals = new ArrayList<Animal>();
    static Color[] color = {Color.BLUE,
	Color.RED,Color.GREEN,Color.YELLOW,Color.PURPLE,Color.BLACK,Color.BROWN,Color.MAGENTA,Color.CYAN};
	static HashMap<Animal,Color> animalHash = new HashMap<Animal,Color>();
	static ArrayList<Animal> animalArray = new ArrayList<Animal>();
	ObservableList<Animal> bob;
	
	/**
	 * Method Start()
	 * 
	 * instructions to make the gui
	 * 
	 * @param primaryStage
	 */
	public void start(Stage primaryStage)
    {
		bob = (FXCollections.observableArrayList(animalArray));
       
       
        
        
        ListView<Animal> lv = new ListView<>(bob);
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
        	    	  Animal name = bob.get(lv.getSelectionModel().getSelectedIndex());
        	    	  r1.setFill(animalHash.get(name));
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
        bob.add(n);
    }
    /**
	 * Method main()
	 * 
	 * executable code
	 * 
	 * @param args
	 */

	public static void main(String[] args) {
		
		
		
		
		try {
			//ObjectInputStream object used to read in objects from a binary file
			
			ObjectInputStream input = new ObjectInputStream(new FileInputStream("animal.dat"));
			
			try {
				//while loop that runs as long as there is a subsequent animal object in the binary file to be read
				while(true)
				{
					//creates the animal object and then adds it to animalList
					Animal a1 = (Animal) input.readObject();
					animals.add(a1);
				}
				
				
			} catch (ClassNotFoundException e) {
				//prints out File Read Error if Class Not Found Exception occurs
				e.printStackTrace();
				System.out.println("File Read Error");
			}
			catch(EOFException e)
			{
				
				//breaks out at end of file and closes the ObjectInputStream object input
				input.close();
			}
		} catch (FileNotFoundException e) {
			//prints out a warning when the request file is not found
			System.out.println("File not found");
			e.printStackTrace();
		} catch (IOException e) {
			//prints out a warning when the request file is incorrect
			e.printStackTrace();
			System.out.println("File not found");
		}		
		
		
		for(int i = 0; i < animals.size(); i++)
		{
			int code = Math.abs(animals.get(i).hashCode()) % 10;
			animalHash.put(animals.get(i), color[code]);
		}
		Set<Animal> thing = animalHash.keySet();
		
		for(Animal x: thing)
		{
			animalArray.add(x);
		}
		
		launch(args);

	}

}
