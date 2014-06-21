package tt.fares.sockets.test;

public class MyProtocol {

	public MyProtocol(){
		
	}
	
	String firstContact(){
		return("Hey There! Wanna play?");
	}
	
	String processMessage(String input){
		String positiveAnswer, negativeAnswer, errMsg;
		
		positiveAnswer = "nice! let's strat";
		negativeAnswer = "What a pity! see you next time then!";
		errMsg = "I don't understand your answer! do you speak English?";
		
		if(input != null){
			if(input.equals("y")){
				return(positiveAnswer);
			}else if(input.equals("n")){
				return(negativeAnswer);
			}else{
				return(errMsg);
			}
		}else{
			return(errMsg);
		}
			
	}
}
