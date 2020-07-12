package kr.ac.ajou.group_Seven.end;
import java.util.ArrayList;

import kr.ac.ajou.group_Seven.play.Player;

public class ResultPrint {
	
	ArrayList<Player> final_test = new ArrayList<Player>();
	int tmp;
	String tmp_name;
	
	//for saving to final_test Araaylist who alived player.
	public ResultPrint(ArrayList<Player> players){
		for(int i=0; i<4; i++){
			if(players.get(i).isAlive())
				final_test.add(players.get(i));
		}
	}
	
	// this return value will be used for showing winner who has return value as index.
	public int res_print(){
		if(final_test.size()==1){
			if(final_test.get(0).getName().equals("p1")){
				return 1;
			}else if(final_test.get(0).getName().equals("p2")){
				return 2;
			}else if(final_test.get(0).getName().equals("p3")){
				return 3;
			}else{
				return 4;
			}
			
		}
		else{
			for(int i=0; i<final_test.size(); i++){	
				if(tmp < final_test.get(i).getBlockNumber()){
					tmp=final_test.get(i).getBlockNumber();
					tmp_name=final_test.get(i).getName();
				}
			}
			if(tmp_name.equals("p1"))
				return 1;
			else if(tmp_name.equals("p2"))
				return 2;
			else if(tmp_name.equals("p3"))
				return 3;
			else
				return 4;	
		}
	}
}