package kr.ac.ajou.group_Seven.Question;

public class L6Question extends Question{
	
	//make the question
	@Override
	public String getQuestion() {
		num1 = (int) (Math.random() * 20) + 10;
		num2 = (int) (Math.random() * 20) + 10;
		num3 = (int) (Math.random() * 20) + 10;
		
		question = new String(num1 + " * " + num2 + " * " + num3 + " = ?\n");
		return question;
	}
	
	//return the correct answer of the question
	@Override
	public int getAnswer(){
		return num1*num2*num3;
	}
}
