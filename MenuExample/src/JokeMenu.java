

public class JokeMenu extends AbstractMenu {

	public JokeMenu(AbstractMenu callingMenu) {
		super(callingMenu);
	}

	@Override
	void mainPrompt() {
		// TODO Auto-generated method stub
		System.out.println("Welcome to the joke menu. What would you like to do?");
		System.out.println("1. Tell me a joke!");
		System.out.println("2. Go back to the main menu.");
		System.out.println();
		
		int input = Game.getIntInput();
		
		if(input == 1) {
			System.out.println("Q: How many programmers does it take to screw in a lightbulb?");
			System.out.println("A: None, that's a hardware problem!");
			System.out.println();
			// repeat questions
			this.mainPrompt();
		}
		
		if(input == 2) {
			new MainMenu(this);
		}
		
	}

	@Override
	void onDestroy() {
		
		System.out.println("\t\t\t\t\t\t\t\tJokeMenu is now destroyed.");
		
	}
	
}
