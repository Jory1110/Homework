

import java.util.Scanner;

public class TextIOExample {

	public static void main(String[] args) throws InterruptedException {
		
		System.out.println("This is an example of regular text output");
		System.out.println("Everything prints at once");
		System.out.println("Its cluttered and hard to digest");
		System.out.println("It makes it feel less engaging");
		System.out.println("Also, it just feels like you get thrown a big");
		System.out.println("Huge block of text and that's intimidating to read");
		System.out.println("It makes the end user want to just skim through it");
		System.out.println("\n");
		System.out.println("Type ok and press enter for a better way!");
		
		Scanner scan = new Scanner(System.in);
		scan.next();
		
		System.out.println("This is a better way.");
		Thread.sleep(1500);
		System.out.println("It makes the text easy to digest.");
		Thread.sleep(1500);
		System.out.println("It also allows (and forces) the user to read");
		Thread.sleep(1500);
		System.out.println("Before jumping to the next thing.");
		Thread.sleep(1500);
		System.out.println("It's pretty easy to accomplish");
		Thread.sleep(1500);
		System.out.println("And I think it makes things way more engaging.");
		Thread.sleep(1500);
		System.out.println("The downside is that it's boring to sit through");
		Thread.sleep(1500);
		System.out.println("if you've already seen it before. What do you think?");
		
	}
	
}
