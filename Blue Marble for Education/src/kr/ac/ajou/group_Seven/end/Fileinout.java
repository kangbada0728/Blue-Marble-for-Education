package kr.ac.ajou.group_Seven.end;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class Fileinout {

		// write date and winner in history file
		public void save_and_goout(int result_is){
			Date today = new Date();
			
			try{
				FileWriter writer = new FileWriter("history.txt", true);
				writer.write(String.format("%tc", today) + " : player " + result_is + ".\n");
				writer.close();
			}catch(IOException e1){
				e1.printStackTrace();
			}
			
			System.exit(0);
			
		}
	
}
