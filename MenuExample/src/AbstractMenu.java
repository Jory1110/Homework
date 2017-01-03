

public abstract class AbstractMenu {
	
	public AbstractMenu(AbstractMenu callingMenu) {
		
		if(callingMenu != null) {
			callingMenu.exitMenu();
		}
		
		this.mainPrompt();
		
	}
	
	abstract void mainPrompt();
	
	abstract void onDestroy();
	
	public final void exitMenu() {
		
		this.onDestroy();
		
	}
	
}
