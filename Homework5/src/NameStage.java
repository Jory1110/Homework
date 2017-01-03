/**
 * Class: AnimalReader
 * 
 * @author Dr. Johnson modified by Robert Jory Alexander
 * @version 1.0 
 * Course : ITEC 3150, Spring, 2016 
 * Written: April 18, 2016
 * 
 * 
 * This class: creates a stage that pops up when someone wants to add a name to the oblist
 * 
 * Purpose: to complete to above task.
 *         
 *
 */
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class NameStage extends Stage
{
    
   
    /**
     * Constructor
     * 
     * @param parent - reference to calling class so data can be returned
     */
    public NameStage(AnimalReader parent)
    {
        // Create a pane and set its properties
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        pane.setHgap(5.5);
        pane.setVgap(5.5);

        TextField name = new TextField();
        TextField breed = new TextField();
        TextField age = new TextField();
        TextField numInZoo = new TextField();
        // Place nodes in the pane
        pane.add(new Label("Name:"), 0, 0);
        pane.add(new Label("Breed:"), 0, 1);
        pane.add(new Label("Age:"), 0, 2);
        pane.add(new Label("Zoo Number:"), 0, 3);
        pane.add(name, 1, 0);
        pane.add(breed, 1, 1);
        pane.add(age, 1, 2);
        pane.add(numInZoo, 1, 3);
        
      
        Button btAdd = new Button("Add Name");
        pane.add(btAdd, 1, 4);
        GridPane.setHalignment(btAdd, HPos.RIGHT);
        
        btAdd.setOnAction(e-> 
        {
           Animal newAnimal =  new Animal(name.getText(),breed.getText(),Double.parseDouble(age.getText()),Integer.parseInt(numInZoo.getText()));
           int y = Math.abs(newAnimal.hashCode()) % 9;
           Color x = AnimalReader.color[y];
           AnimalReader.animalHash.put(newAnimal, x);
           parent.addAName(newAnimal);
           this.close();
        });

        // Create a scene and place it in the stage
        Scene scene = new Scene(pane);
       this.setTitle("Add a Name"); // Set the stage title
        this.setScene(scene); // Place the scene in the stage
        this.show(); // Display the stage
    }

   
}