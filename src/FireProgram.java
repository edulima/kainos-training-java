
import java.util.Scanner;

public class FireProgram {
	
	private static String username;
	private static String password;
	private static String registration = "";
	private static boolean isValidRegistrationAnswer = false;
	private static boolean isValidPassword = false;
	private static boolean invalidUsername = true;
	private static Scanner sc;
	private static Language msg;
	private static Login openConnection;


	public static void main(String[] args) {
			
		openConnection = new Login(); 
		msg = new Language("english");
		sc = new Scanner(System.in);

		System.out.println(msg.getLanguage().get(0));
				
		while(!isValidRegistrationAnswer)  {
			
			System.out.println(msg.getLanguage().get(1));
			registration = sc.next().toLowerCase();	
			
			if (registration.equals("yes") || registration.equals("no")) {
				isValidRegistrationAnswer = true;				
			}
		}   
			
		if(registration.equals("yes")) {
				
			System.out.println(msg.getLanguage().get(2));
			username = sc.next();
				
			if(openConnection.addUser(username)) {			
				while (invalidUsername) {
					System.out.println(msg.getLanguage().get(4));
					username = sc.next();
					invalidUsername = openConnection.addUser(username);
				}
			} 
			
			while(!isValidPassword) {
				System.out.println(msg.getLanguage().get(3));
				password = sc.next();
				
				System.out.println(msg.getLanguage().get(7));
				String tempPass = sc.next();
				
				if(openConnection.matchPassword(password, tempPass)) {
					if(openConnection.insertUser(username, password)){
						System.out.println(msg.getLanguage().get(5));
					}
					isValidPassword = true;
				} else {
					System.out.println(msg.getLanguage().get(8));
				}	
			}
			
		} else if (registration.equals("no")) {
			displayLoginMsgs();
			openConnection.validateUser(username, password);			
		}	    
	    sc.close();
	}
	
	public static void displayLoginMsgs() {
		
		System.out.println(msg.getLanguage().get(2));
		username = sc.next();
		
		System.out.println(msg.getLanguage().get(3));
		password = sc.next();
		
	}
}
