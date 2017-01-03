import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.stage.Stage;

public class QuizGUI extends Application {

	@Override
	public void start(Stage stage1) throws Exception {
		
		Button save = new Button("Save");
		Button cancel = new Button("Cancel");
		Ellipse ellipse = new Ellipse(50, 50, 50, 25);
		ellipse.setStroke(Color.BLACK);
		ellipse.setFill(Color.WHITE);
		StackPane stackPane = new StackPane();
		Label l1 = new Label("Rectangle");
		stackPane.getChildren().addAll(ellipse, l1);
		
		Label red = new Label("Red when Saved");
	    GridPane g1 = new GridPane();
	    
	    
	    g1.getChildren().add(red);
	    g1.add(stackPane, 1, 2);
	    GridPane.setHalignment(stackPane, HPos.LEFT);
	    g1.add(save, 0, 6);
	    GridPane.setHalignment(save, HPos.RIGHT);
	    g1.add(cancel, 1, 6);
	    GridPane.setHalignment(cancel, HPos.LEFT);
	    
	    save.setOnAction(e -> red.setTextFill(Color.RED));
	    cancel.setOnAction(e -> System.exit(0));


		Scene scene = new Scene(g1, 300, 350);
        stage1.setTitle("Quiz GUI"); // Set the stage title
        stage1.setScene(scene); // Place the scene in the stage
        stage1.show();
		
	}
	
	public static void main(String[]args)
	{
		launch();
	}

}
