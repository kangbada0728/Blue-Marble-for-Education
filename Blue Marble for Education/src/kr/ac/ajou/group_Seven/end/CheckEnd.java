package kr.ac.ajou.group_Seven.end;
import java.util.ArrayList;

import kr.ac.ajou.group_Seven.play.Player;

public class CheckEnd {
	
	//for check how many users alived. If player number is smaller or equal than 1, return true and game over.
	public boolean howAlive(ArrayList<Player> players) {
		int playernumer=0;
		
		for (int i = 0; i < 4; i++) {
			if (players.get(i).isAlive() == true)
				playernumer++;
		}
		if (playernumer <= 1)
			return true;
		else{
			playernumer=0;
			return false;
		}
	}
	
	//Following game rule, if one player has 12 blocks, game over.
	public boolean howManyblock(ArrayList<Player> players) {
		int blocknumber=0;
		
		for(int i=0; i<4; i++){
			blocknumber += players.get(i).getBlockNumber();
		}
		if (blocknumber == 12)
			return true;
		else{
			blocknumber=0;
			return false;
		}
	}
	
	//If all of alived player's turn are 0, game over.
	public boolean turnOver(ArrayList<Player> players) {
		
		int remain_turn=0;
		
		for(int i=0; i<4; i++){
			remain_turn += players.get(i).getTurn();
		}
		
		if (remain_turn == 0)
			return true;
		else{
			remain_turn=0;
			return false;
		}
	}
}
