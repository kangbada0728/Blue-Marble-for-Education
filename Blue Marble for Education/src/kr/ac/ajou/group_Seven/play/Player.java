package kr.ac.ajou.group_Seven.play;
import java.util.ArrayList;

import javax.swing.JTextArea;

import kr.ac.ajou.group_Seven.Question.Block;

public class Player {
	private int location; // player's current location
	private int coin; // player's current cloin
	private int blockNumber; // player's current own block number
	private boolean alive; // player's current state
	private String name; // player's name
	private int turn; // player's have turn.
	
	private Dice value;
	
	//player object will have name, location, coin, block number, turn, and survive.
	public Player(String name, int location, int coin, int blockNumber, int turn, boolean alive) {
		this.name = name;
		this.location = location;
		this.coin = coin;
		this.blockNumber = blockNumber;
		this.turn = turn;
		this.alive = alive;
	}
	
	public int getTurn() {
		return turn;
	}

	public void setTurn(int turn) {
		this.turn = turn;
	}

	public void minusTurn() {
		this.turn -= 1;
	}
	
	public void plusTurn() {
		this.turn += 1;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLocation() {
		return location;
	}

	public void setLocation(int location) {
		this.location = location;
	}

	public int getCoin() {
		return coin;
	}

	public void setCoin(int coin) {
		this.coin = coin;
	}

	public void minusCoin() {
		coin -= 1;
	}
	
	public void plusCoin(){
		coin += 1;
	}
	
	public int getBlockNumber() {
		return blockNumber;
	}

	public void setBlockNumber(int blockNumber) {
		this.blockNumber = blockNumber;
	}

	public void plusBlockNumber() {
		blockNumber += 1;
	}

	public void minusBlockNumber() {
		blockNumber -= 1;
	}

	public boolean isAlive() {
		return alive;
	}

	public void setAlive(boolean alive) {
		this.alive = alive;
	}
	
	//x is dice number, and stateFlow_text will show message when you reach first block. finally return player's location.
	public int move(int x, JTextArea stateFlow_text) {

		location += x;
		if (location >= 12) {
			location = location % 12;
			plusCoin();
			stateFlow_text.append("You pass Block number 1! Your stone plus 1.\n");
		}
		return location;
	}
	
	//value is Dice object. call rolldice method of Dice class. It will be the input of move method's x argument.
	public int getDice(){
		value = new Dice();
		return value.rolldice();
	}
	
	//If player push give up button, player is dead and all player's Blocks are initiallized.
	public void giveup(ArrayList<Block> mapBlock, int deadmaster){
		this.setAlive(false);
	      
      for(int i=0; i< mapBlock.size(); i++){
    	  if(mapBlock.get(i).getBlockOwner() == deadmaster)
    		  mapBlock.get(i).setBlockOwner(-1);
      }

	}
	
}
