import java.util.ArrayList;


public class Language {
	
	public ArrayList<String> msg;
	
	public Language(String lang) {
		setLanguage(lang);
	}
		
	public ArrayList<String> setLanguage(String lan) {
		
		msg = new ArrayList<String>();
		
		switch (lan) {
		case "english":
			
			msg.add("Welcome");
			msg.add("Would you like to register? (yes/no)");
			msg.add("Please enter your username: ");
			msg.add("Please enter your password: ");
			msg.add("Username already exist, try again: ");
			msg.add("User created...");
			msg.add("User not found...");
			
			break;

		default:
			break;
		}
		return msg;
	}
	
	public ArrayList<String> getLanguage() {
		return msg;
	}

}
