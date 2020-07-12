package kr.ac.ajou.group_Seven.Question;

import java.util.ArrayList;

import kr.ac.ajou.group_Seven.play.Player;


public class Block {

	private int blockOwner;
	private int visitNumber;
	
	private Question ques;
	
	//set the level of the block
	public String getQuestion(int level){
		if(level==1){
			ques = new L1Question();
			return ques.getQuestion();
		}
		else if(level==2){
			ques = new L2Question();
			return ques.getQuestion();
		}else if(level==3){
			ques = new L3Question();
			return ques.getQuestion();
		}else if (level==4){
			ques = new L4Question();
			return ques.getQuestion();
		}else if(level==5){
			ques = new L5Question();
			return ques.getQuestion();
		}else{
			ques = new L6Question();
			return ques.getQuestion();
		}
		
	}
	
	//return the correct answer of the question
	public int getAnswer(int level){
		if(level==1){
			return ques.getAnswer();
		}
		else if(level==2){
			return ques.getAnswer();
		}else if(level==3){
			return ques.getAnswer();
		}else if (level==4){
			return ques.getAnswer();
		}else if(level==5){
			return ques.getAnswer();
		}else{
			return ques.getAnswer();
		}
	}
	
	
	public int getBlockOwner() {
		return blockOwner;
	}
	public void setBlockOwner(int blockOwner) {
		this.blockOwner = blockOwner;
	}
	public int getVisitNumber() {
		return visitNumber;
	}
	public void setVisitNumber(int visitNumber) {
		this.visitNumber = visitNumber;
	}
	
	//the block level is maximum 6
	public void plusVisitNumber(){
		visitNumber+=1;
		if(visitNumber > 6)
			visitNumber=6;
	}
	
	
	public Block(){
		
	}
	
	//constructor of the block
	public Block(int blockOwner, int visitNumber){
		this.blockOwner=blockOwner;
		this.visitNumber=visitNumber;
	}
	
	//set the master of the block
	public void buyBlock(Player player, int newmaster, Player premaster, Block block){	
		premaster.minusBlockNumber();
		player.minusCoin();
		player.plusBlockNumber();
		block.setBlockOwner(newmaster);
	}
	
	//initialize the master and number of visit
	public void buyEmptyBlock(Player player, int newmaster, Block block){
		player.minusCoin();
		player.plusBlockNumber();
		block.setBlockOwner(newmaster);
	}
	
	
	public ArrayList<Block> setBlock(){
		// (block_owner , visit num)

		ArrayList<Block> block=new ArrayList<Block>();
		
		for(int i=0; i<12; i++){
			block.add(new Block(-1,0));
		}
	
		return block;
		
	}
	
	
	
	
	
	
	
	
	
}
