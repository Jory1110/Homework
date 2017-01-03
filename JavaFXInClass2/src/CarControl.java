import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.application.Application;

public class CarControl extends Application{

	Button up = new Button("  Up  ");
	Button down = new Button("Down");
	Button left = new Button("Left ");
	Button right = new Button("Right");
	Integer x = 0;
	Label moves = new Label(x.toString());
	Stage stage2 = new Stage();
	
	Image car = new Image("mole.png");
	ImageView thing = new ImageView(car);
	@Override
	public void start(Stage primaryStage){
		
		moves.setFont(Font.font("Times New Roman", 
			      FontWeight.BOLD, FontPosture.ITALIC, 40));
		
		GridPane pane = new GridPane();
		GridPane pane2 = new GridPane();
		GridPane pane3 = new GridPane();
		GridPane pane4 = new GridPane();
		BorderPane pane5 = new BorderPane();
		
		 pane.setAlignment(Pos.CENTER_RIGHT);
		 pane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
		 pane.setHgap(5.5);
		 pane.setVgap(5.5);
		 pane.add(up,1,0);
		 pane.add(down,1,3);
		 pane.add(left,0,2);
		 pane.add(right,2,2);
		 
		 
		 pane3.add(pane, 0, 0);
		 pane3.setMinHeight(100);
		 pane3.setMinWidth(100);
		 
		 
		 
		 Scene scene = new Scene(pane3);
		 primaryStage.setTitle("Controller"); // Set the stage title
		 primaryStage.setScene(scene); // Place the scene in the stage
		 primaryStage.show(); // Display the stage
		 
		
		 
		 
		 down.setOnAction(e -> down());
		 up.setOnAction(e -> up());
		 left.setOnAction(e -> left());
		 right.setOnAction(e -> right());
		 
		 
		 pane5.getChildren().add(thing);
		 
		 pane2.setAlignment(Pos.TOP_LEFT);
		 pane2.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
		 pane2.setHgap(5.5);
		 pane2.setVgap(5.5);
		 pane5.setMinHeight(400);
		 pane5.setMaxHeight(400);
		 pane5.setMinWidth(400);
		 pane5.setMaxHeight(400);
		 
		 pane4.add(moves, 0,0);
		 pane4.setAlignment(Pos.TOP_LEFT);
		 pane2.add(pane4, 0, 0);
		 
		 
		 
		 pane5.getChildren().add(pane2);
		 Scene scene2 = new Scene(pane5);
		 stage2.setTitle("RaceTrack");
		 stage2.setScene(scene2);
		 stage2.show();
		 
		 
		 
		 primaryStage.setX((Screen.getPrimary().getVisualBounds().getWidth() - primaryStage.getWidth())/4);
		    
		 
		
	}
	

	
	  private Integer right() {
	    x = x + 1;
	    moves.setText(x.toString());
	    thing.setX(thing.getX()+ 10);
	    
	    
		return x;
	}




	private Integer left() {
		x = x + 1;
		moves.setText(x.toString());
		thing.setX(thing.getX() - 10);
		return x;
	}



	private Integer up() {
		x = x + 1;
		moves.setText(x.toString());
		thing.setY(thing.getY() - 10);
		return x;
	}



	private Integer down() {
		x = x + 1;
		moves.setText(x.toString());
		thing.setY(thing.getY() + 10);
		return null;
	}



	public static void main(String[] args) {
		    launch(args);
		  }

}
