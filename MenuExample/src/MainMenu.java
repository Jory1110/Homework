


public class MainMenu extends AbstractMenu
{

	// this does not need to be modified in most cases.
	public MainMenu(AbstractMenu callingMenu) {
		super(callingMenu);
	}

	// on load gets called as soon as the menu gets created. see AbstractMenu for details.
	// therfore, on load will do any initialization and print out any welcoming messages or other details
	@Override
	void mainPrompt() {
		
		System.out.println("Welcome to Aaron's Demo! What would you like to do?");
		System.out.println("1. Tell me a joke!");
		System.out.println("2. Tell me a story!");
		System.out.println("3. Surprise me!");
		System.out.println("4. Exit");
		System.out.println();
		
		// all input is gotten through the game
		int userChoice = Game.getIntInput();
		System.out.println();
		
		// switching menus is as easy as creating a new object of that menu. it will then take over.
		// the first thing that the new menu will do is destroy this one by calling the exitMenu function
		// for THIS menu, as defined in the AbstractMenu. This method will call the onDestroy() 
		// function, which should do any last minute things that might need to be handled like closing
		// resources, saving states or modifying attributes. 
		
		if(userChoice == 1) {
			new JokeMenu(this);
		}
		
		if(userChoice == 2) {
			new StoryMenu(this);
		}
		
		if(userChoice == 3) {
			new SurpriseMenu(this);
		}
		
		if(userChoice == 4) {
			System.out.println("Kbye.");
			System.exit(0);
		}
	}

	@Override
	void onDestroy() {
		// TODO Auto-generated method stub
		System.out.println("\t\t\t\t\t\t\t\tThe main menu is now destroyed.");
		
	}

}
