

public class MainMethod {
	
	public static void main(String[] args) {
		
		// this wouldn't normally be done here, but for demo purposes...
		Game.initializeGame();
		
		// to start the process, all you have to do is start a menu
		// first menu gets null, since it is the starting point. This will
		// make a new MainMenu and from then on flow of control will be
		// determined by the main menu, bouncing to different menus and back as fit.
		new MainMenu(null);
		
	}

}
