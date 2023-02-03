package br.com.github.ruannarici.model;

public class HumanBody {
	
	private String body = "|";
	private String leftArm = "     --";
	private String rightArm = "--";
	private String leftLeg = "      /";
	private String rightLeg = " \\";
	private String head1 = "   ---------";
	private String head2 = "   | ' _ ' |";
	private String head3 = "   ---------";
	
	private void drawHead() {
		System.out.println(head1);
		System.out.println(head2);
		System.out.println(head3);
	}
	
	public void removeHead() {
		head1 = "            ";
		head2 = "            ";
		head3 = "            ";
	}
	
	private void drawBody() {
		System.out.println(drawLeftArm() + body + drawRightArm());
		
	}
	
	public void removeBody() {
		this.body = " ";
	}
	
	private String drawLeftArm() {
		return leftArm;
	}
	
	public void removeLeftArm() {
		this.leftArm = "       ";
	}
	
	private String drawRightArm() {
		return rightArm;
	}
	
	public void removeRightArm() {
		this.rightArm = "  ";
	}
	
	private String drawLeftLeg() {
		return leftLeg + drawRightLeg();
	}
	
	public void removeLeftLeg() {
		this.leftLeg = "       ";
	}
	
	private String drawRightLeg() {
		return rightLeg;
	}
	
	public void removeRightLeg() {
		this.rightLeg = "  ";
	}
	
	public void fullBody() {
		drawHead();
		drawBody();
		System.out.println(drawLeftLeg());
	}

}
