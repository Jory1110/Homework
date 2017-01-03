/**
 * Class: SquareRunnable
 * 
 * @author Jory Alexander
 * @version 1.0 
 * Course : ITEC 3150, Spring, 2016 
 * Written: March 28, 2016
 * 
 * 
 * This class : Contains the instructions to create a window that will display a circle and square and make them move
 * 
 * Purpose: to move a square object vertically and a circle object horizontally
 *
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Box;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class RunMe extends Application{

	
	/**
	 * method Start()
	 * 
	 * contains the instructions to build a stage and fill it with required nodes and panes
	 * 
     * @param Stage stage1
     */
	public void start(Stage stage1){
		//create objects required for the aforementioned task
		Circle cir = new Circle(50,50,50);
		Rectangle b = new Rectangle(50,50);
		b.setFill(Color.GREEN);
		BorderPane p1 = new BorderPane();
		p1.getChildren().add(cir);
		p1.getChildren().add(b);
		//creates threads to be run
		Thread t1 = new Thread(new MovementRunable(cir,p1));
		Thread t2 = new Thread(new SquareRunnable(b,p1));
		//start threads
		t1.start();
		t2.start();
		
		//tells what happens when the window is closed
		stage1.setOnCloseRequest(e -> {
	           
            t1.interrupt();
            t2.interrupt();
            stage1.close();
            System.exit(0);
        });
		//set up the scene 
		Scene scene = new Scene(p1, 400,400);
        stage1.setTitle("Homework");
        stage1.setScene(scene);
        stage1.show();
	}
	
	/**
	 * method main()
	 * 
	 * runs the program 
	 * 
     * @param args
     */
	public static void main(String[] args)
	{
		//launches the gui
		launch();
	}

}
