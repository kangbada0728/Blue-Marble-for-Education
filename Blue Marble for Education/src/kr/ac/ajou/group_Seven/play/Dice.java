package kr.ac.ajou.group_Seven.play;

public class Dice {
	
	private int value;
	
	//return random number from 1 to 6
	public int rolldice(){
		value = (int)(Math.random()*6)+1;
		return value;
	}
}
