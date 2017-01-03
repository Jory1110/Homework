

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Scanner;

public final class Game 
{

	private static Game game;
	private static Scanner inputScanner;

	private Game()
	{
		inputScanner = new Scanner(System.in);
	}
	
	public static void initializeGame() {
		if(game == null) {
			game = new Game();
		}
	}
	
	public static String getTextInput() 
	{
		return inputScanner.nextLine();
	}
	
	public static int getIntInput() 
	{
		return inputScanner.nextInt();
	}
	
	public static double getDoubleInput() 
	{
		return inputScanner.nextDouble();
	}

}
