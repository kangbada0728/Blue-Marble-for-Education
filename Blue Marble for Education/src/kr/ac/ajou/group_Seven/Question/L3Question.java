package kr.ac.ajou.group_Seven.Question;

public class L3Question extends Question {
	
	//make the question
	@Override
	public String getQuestion() {
		num1 = (int) (Math.random() * 10) + 1;
		num2 = (int) (Math.random() * 10) + 1;
		num3 = (int) (Math.random() * 10) + 1;
		
		operation1 = (int) (Math.random() * 2) + 1;
		
		if (operation1 == 1) {
			question = new String(num1 + " * " + num2 + " - " + num3 + " = ?\n");
			return question;
		} else
			question = new String(num1 + " * " + num2 + " + " + num3 + " = ?\n");
			return question;
	}
	
	//return the correct answer of the question
	@Override
	public int getAnswer(){
		if(operation1 == 1)
			return num1*num2-num3;
		else
			return num1*num2+num3;
	}
}