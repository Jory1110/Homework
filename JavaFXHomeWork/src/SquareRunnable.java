/**
 * Class: SquareRunnable
 * 
 * @author Jory Alexander
 * @version 1.0 
 * Course : ITEC 3150, Spring, 2016 
 * Written: March 28, 2016
 * 
 * 
 * This class : Contains instructions to move a square object vertically
 * 
 * Purpose: to move a square object vertically
 *
 */
import javafx.application.Platform;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Box;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class SquareRunnable implements Runnable {

	//creates a rectangle Pane and String that is accessible to the entire class
	Rectangle x;
	Pane y;
	String way = "down";
	
	/**
	 * method SquareRunnable()
	 * 
	 * Constructor that takes in a Rectangle and pane object to create a Square Runnable Object
	 * 
     * @param Rectanlge x
     * @param Pane y
     */
	public SquareRunnable(Rectangle x, Pane y)
	{
		this.x = x;
		this.y = y;
	}
	@Override
	/**
	 * method run()
	 * 
	 * contains the logic required to move a square object up and down
     */
	public void run() 
	{
		try{
			while(true)
			{
				//if statement that checks to see if the square is at an edge and sets the string way in the appropriate direction
				if(x.getLayoutY() <= 0)
				{
					way = "down";
					down();
					Thread.sleep(24);
				}
				else if(x.getLayoutY() >= y.getHeight() - x.getHeight())
				{
					way = "up";
					up();
					Thread.sleep(24);
				}
				else if(way.equals("up"))
				{
					up();
					Thread.sleep(24);
				}
				else if(way.equals("down"))
				{
					down();
					Thread.sleep(24);
				}
				else
				{
					System.out.println("Something Broke in boxes");
				}
			}
		}
		catch (InterruptedException e) 
		{
		   		
		}
		
		
	}
	/**
	 * method down()
	 * 
	 * contains logic that moves the square downward
	 * 
     */
	private void down() {
		//creates a second runnable that is run at the UI's earliest convince
		Platform.runLater(new Runnable() {
			/**
			 * method run()
			 * 
			 * sends the information to the ui thread that gets run 
			 * 
		     */

			@Override
			public void run() {
				
				x.relocate(x.getLayoutX() , x.getLayoutY()+1);
				
			}
			
		});
		 
		
	}
	/**
	 * method up()
	 * 
	 * contains logic that moves the square upward 
	 * 
     */
	private void up() {
		//creates a second runnable that is run at the UI's earliest convince 
		Platform.runLater(new Runnable() {

			/**
			 * method run()
			 * 
			 * sends the information to the ui thread that gets run 
			 * 
		     */
			@Override
			public void run() {
				
				x.relocate(x.getLayoutX() , x.getLayoutY()-1);
				
			}
			
		});
		
		
	}
}

  