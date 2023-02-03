package br.com.github.ruannarici.model;

import java.util.Scanner;
import java.util.Random;

public class LogicPlay{

	private int life = 6;
	private char letter = ' ';
	private int selectWord = 0;
	private int point = 0;
	private StringBuilder slot = new StringBuilder("");
	private Scanner answer = new Scanner(System.in);
	private WordKey word = new WordKey();
	private HumanBody body = new HumanBody();
	private Forca forca = new Forca();
	private Random randomWord = new Random();
	
	private void showLayout() {
		forca.drawForca();
		body.fullBody();
		forca.showTitleGame();
		word.showTheme();
	}
	
	private void generateRandomWord() {
		this.selectWord = randomWord.nextInt(11);
	}
	
	private void clearConsole() {
		for (int i = 0; i < 100; ++i)  {
		       System.out.println();
		}
	}
	
	private void slotsChar() {
		for (int count = 0; count < word.words[selectWord].length(); count++) {
			slot.insert(count, "_") ;
		}
		System.out.println(slot);
	}
	
	private void askForPlayer() {
		System.out.println("The word have " + word.words[selectWord].length() + " letters.");
		System.out.println("What letter is in the word?");
	}
	
	public void gamePlay() {
		generateRandomWord();
		showLayout();
		slotsChar();
		while (point < word.words[selectWord].length() 
				&& life > 0) {
			verifyWinner();
			askForPlayer();
			String ans = answer.next();
			clearConsole();
			while (ans.length() > 1) {
				System.out.println("Invalid! Try again!");
				System.out.println("You need to enter a maximum of one letter.");
				showLayout();
				System.out.println(slot);
				askForPlayer();
				ans = answer.next();
				clearConsole();
			}
			if (word.words[selectWord].contains(ans)) {
				System.out.println(":::Correct:::");
				int position = word.words[selectWord].indexOf(ans);
				char convertChar = ans.charAt(0);
				showLetter(position, convertChar);
				point ++;
				showLayout();
				if (!verifyWinner()) {
				System.out.println(slot);
				}
			} else {
				life --;
				incorrectAnswer();
				System.out.println(":::Incorrect:::");
				System.out.println("You have " + life + " lifes.");
				showLayout();
				if (!verifyWinner()) {
				System.out.println(slot);
				}
			}
		}
	}
	
	private void showLetter(int replace, char let) {
		int replaced = replace;
		slot.setCharAt(replaced, let);
	}
	
	private void incorrectAnswer() {
		switch(life) {
			case 5: {
				body.removeRightLeg();
				break;
			}
			case 4: {
				body.removeLeftLeg();
				break;
			}
			case 3: {
				body.removeRightArm();
				break;
			}
			case 2: {
				body.removeLeftArm();
				break;
			}
			case 1: {
				body.removeBody();
				break;
			}
			case 0: {
				body.removeHead();
			}
		}
	}
	
	private boolean verifyWinner() {
		if (this.point ==  word.words[selectWord].length()) {
			System.out.println("YEAH! You winner!");
			System.out.println("The word is: " + word.words[selectWord]);
			System.out.println("This game was developed by @RuanNarici");
			return true;
		} else if (this.life == 0) {
			System.out.println("Oh no.. You loss!");
			System.out.println("The word is: " + word.words[selectWord]);
			System.out.println("This game was developed by @RuanNarici");
			return true;
		}
		return false;
	}
	
}
