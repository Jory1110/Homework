

public class StoryMenu extends AbstractMenu {

	public StoryMenu(AbstractMenu callingMenu) {
		super(callingMenu);
	}

	@Override
	void mainPrompt() {
		// TODO Auto-generated method stub
		System.out.println("Welcome to the story menu. What would you like to do?");
		System.out.println("1. Listen to a story.");
		System.out.println("2. Return to the main menu.");
		System.out.println();
		
		int input = Game.getIntInput();
		if(input == 1) {
			try {
			System.out.println("Once upon a time there was a....");
			Thread.sleep(1000);
			System.out.print(".");
			Thread.sleep(500);
			System.out.print(" .");
			Thread.sleep(500);
			System.out.println(" .");
			System.out.println("Sorry, I fell asleep!");
			this.mainPrompt();
			}catch(InterruptedException ie) {
				System.out.println("Whoops, nevermind.");
			}
			System.out.println();
		}
		if(input == 2) {
			new MainMenu(this);
		}
		
	}

	@Override
	void onDestroy() {
		// TODO Auto-generated method stub
		System.out.println("\t\t\t\t\t\t\t\tThe story menu is now destoryed.");
	}

}
