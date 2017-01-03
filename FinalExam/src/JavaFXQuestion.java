// Jory Alexander

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class JavaFXQuestion extends Application{
	Circle c1 = new Circle(50,50,50);

	public static void main(String[] args) {
		launch();

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		GridPane fred = new GridPane();
		Button red = new Button("Red");
		Button blue = new Button("Blue");
		Button orange = new Button("Orange");
		Button green = new Button("Green");
		
		
		fred.add(red, 0, 0);
		fred.add(blue, 3, 0);
		fred.add(green, 3, 3);
		fred.add(orange, 0, 3);
		fred.add(c1, 1, 1);
		
		red.setOnAction(e -> c1.setFill(Color.RED));
		blue.setOnAction(e -> c1.setFill(Color.BLUE));
		green.setOnAction(e-> c1.setFill(Color.GREEN));
		orange.setOnAction(e -> c1.setFill(Color.ORANGE));
		
		 	Scene scene = new Scene(fred, 250,200);
	        primaryStage.setTitle("Exam Problem"); // Set the stage title
	        primaryStage.setScene(scene); // Place the scene in the stage
	        primaryStage.show(); // Display the stage
		
	}


}
