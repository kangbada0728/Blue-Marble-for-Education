package kr.ac.ajou.group_Seven.Question;


abstract public class Question {
	
	int num1;
	int num2;
	int num3;
	int tmp;
	int operation1;
	int answer;
	String question;
	
	//set getQuestion and getAnswer as an abstract class 
	abstract public String getQuestion();
	abstract public int getAnswer(); 
}
