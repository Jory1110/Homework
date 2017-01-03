/**
 * Class: MovementRunnable
 * 
 * @author Jory Alexander
 * @version 1.0 
 * Course : ITEC 3150, Spring, 2016 
 * Written: March 28, 2016
 * 
 * 
 * This class : Contains instructions to move a circle object horizontally
 * 
 * Purpose: to move a circle object horizontally
 *
 */
import javafx.application.Platform;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;

public class MovementRunable implements Runnable {

	//creates a way Pane and String that is accessible to the entire class
	private Circle x;
	private Pane y;
	private boolean way = true;
	
	/**
	 * method MovementRunnable()
	 * 
	 * Constructor that takes in a Circle and pane object to create a Movement Runnable Object
	 * 
     * @param Circle x
     * @param Pane y
     */
	public MovementRunable(Circle x, Pane y)
	{
		this.x = x;
		this.y = y;
	}
	
	/**
	 * method run()
	 * 
	 * contains the logic required to move a circle object left and right
     */
	@Override
	public void run() 
	{
		
			while(true)
			{
				//if statement that checks to see if the circle is at an edge and sets the string way in the appropriate direction
				if(x.getLayoutX() <= 0)
				{
					way = false;
					right();
					
					
				}
				else if(x.getLayoutX() >= y.getWidth() - (2 * x.getRadius()))
				{
					way = true;
					left();
					
				}
				else if(way == true)
				{
					left();
					
				}
				else if(way == false)
				{
					right();
					
				}
				else
				{
					System.out.println("Something Broke");
				}
			}
			
		
		
		
	}
	/**
	 * method right()
	 * 
	 * contains logic that moves the circle to the right
	 * 
     */
	private void right() {
		
		//creates a second runnable that is run at the UI's earliest convince
		Platform.runLater(new Runnable() {
			@Override
			/**
			 * method run()
			 * 
			 * sends the information to the ui thread that gets run 
			 * 
		     */
			public void run() {
				
				x.relocate(x.getLayoutX() + 1 , x.getLayoutY());
				
			}
			
		});
		try {
			Thread.sleep(24);
		} catch (InterruptedException e) {
			// just stop
			
		}
		
		
	}
	/**
	 * method left()
	 * 
	 * contains logic that moves the circle to the left 
	 * 
     */
	private void left() {
		
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
				x.relocate(x.getLayoutX() - 1 , x.getLayoutY());
			}
			
		});
		try {
			Thread.sleep(24);
		} catch (InterruptedException e) {
			// just stop
			
		}
		
	}

}
