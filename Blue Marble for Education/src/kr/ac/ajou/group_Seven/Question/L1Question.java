package kr.ac.ajou.group_Seven.Question;


public class L1Question extends Question {
	
	//make the question
	@Override
	public String getQuestion() {
		num1 = (int)(Math.random()*10)+1;
		num2 = (int)(Math.random()*10)+1;
		
		if(num1<num2){	//make answer always a positive number
			tmp = num1;
			num1 = num2;
			num2 = tmp;
		}
		
		operation1 = (int)(Math.random()*2)+1;
		
		if(operation1 == 1){
			question = new String(num1 + " + " + num2 + " = ?\n");
			return question;
		} else {
			question = new String(num1 + " - " + num2 + " = ?\n");
			return question;
		}			

	}
	
	//return the correct answer of the question
	@Override
	public int getAnswer(){
		if(operation1 == 1)
			return num1+num2;
		else
			return num1-num2;
		
	}

}
