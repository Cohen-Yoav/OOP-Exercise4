package homework4;
import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JFrame;


/**
 * InteractiveSystem isthe main chat system which contains all the usrs and the
 * radio buttons to change font.
 * <p>
 * InteractiveSystem are mmutable. New users can be constructed by adding a new user 
 * with a new number.
 * <p>
 * the InteractiveSystem contains a JFrame which holds inside it all the users as
 * JPanels, and a JradioPanel that reprenest all the radion buttons for changing font.
 * </pre>
 **/

public class InteractiveSystem {
	ArrayList<user> _users;
	
	//abstraction function:
  	// InteractiveSystem is the main chat system which contains all the usrs and the
	// radio buttons to change font.
	//the InteractiveSystem contains a JFrame which holds inside it all the users as
	// JPanels, and a JradioPanel that reprenest all the radion buttons for changing font.
  	
  	
  	//representation invariant:
  	// for InteractiveSystem  IS: 
  	//_users != null 
	
	/**
  	 * Checks to see if the representation invariant is being violated.
  	 * @throws AssertionError if representation invariant is violated.
  	 */
  	 private void checkRep(){
		assert _users != null:
			"_users is null";
  	 }
  	 
	  /**
	   * Constructs a new InteractiveSystem.
	   * @effects Constructs a new InteractiveSystem,IS, such that
	   *	        IS._user is initialized to a new empty list. 
	   **/ 
	public InteractiveSystem(){
		_users = new ArrayList<user>(); 
		checkRep();
	}
	
	public static void main(String[] args) {
		
		//create three users.
		user user1 = new user(1);
		user user2 = new user(2);
		user user3 = new user(3);
		
		//put users in list
		InteractiveSystem IS = new InteractiveSystem();
		IS._users.add(user1);
		IS._users.add(user2);
		IS._users.add(user3);
		
		//create massage handler and set it for all three users.
		handler hd = new handler(IS._users);
		user1.SetHandler(hd);
		user2.SetHandler(hd);
		user3.SetHandler(hd);
		
		
		JFrame frame = new JFrame("Chat System");
		
		//add users to frame.
		frame.add(user1.userPane,BorderLayout.EAST);
		frame.add(user2.userPane,BorderLayout.CENTER);
		frame.add(user3.userPane,BorderLayout.WEST);
		
		//addRadioButtons for font Changing:
		FontButtons fb = new FontButtons(IS._users);
		frame.add(fb.radioPanel, BorderLayout.PAGE_END);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.revalidate();
		frame.repaint();
		frame.setVisible(true);
		
	}
}