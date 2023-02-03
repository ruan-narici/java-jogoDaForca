package br.com.github.ruannarici.model;

public class WordKey {
	
	public String[] words = {"pato","bode","zebra", "alce", "boi", "cobra", "gato", "hamster", "tigre", "urso", "sapo"};
	
	private String wordTheme() {
		return "Is one Animal!";
	}
	
	public void showTheme() {
		System.out.println("## " +wordTheme());
	}
	
	
}
