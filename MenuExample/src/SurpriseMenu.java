
public class SurpriseMenu extends AbstractMenu {

	public SurpriseMenu(AbstractMenu callingMenu) {
		super(callingMenu);
	}

	@Override
	void mainPrompt() {
		System.out.println("SURPRISE THIS ISNT REALLY A MENU HAHAHAHAHA");
		System.out.println();
		new MainMenu(this);
	}

	@Override
	void onDestroy() {
		// TODO Auto-generated method stub
		System.out.println("\t\t\t\t\t\t\t\tThe surprise menu is now destroyed");
	}

}
