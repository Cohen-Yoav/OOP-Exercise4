package homework4;

import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JTextPane;
import javax.swing.text.Style;
import javax.swing.text.StyledDocument;
import javax.swing.text.BadLocationException;
import javax.swing.text.StyleConstants;
import java.awt.Color;




public class handler {
	
	private ArrayList<user> _users;
	
	//abstraction function:
  	// A handler is a subject containing list of users (observers).
    //this hd is responsible no notify all the users when a new text
    //is entered
    // and add that text to all chatboxes for all users in the chat system.
  	
  	
  	//representation invariant:
  	// for handler hd: 
  	//ArrayList<user> != null
	
	private void checkRep(){
		assert _users != null:
			"users is null";
	}
	/**
     * Constructs a new hd with users list
     * 
     **/
	public handler(ArrayList<user> users){
		 _users = new ArrayList<user>(users);
		 checkRep();
	}
	
	
	/**
     * @Effects: updates all the users chatbox with the new msg the was send
     * 
     **/
	public void PrintMasssege(String msg,  int user_num){
		checkRep();
		Iterator<user> iter = _users.iterator();
		while(iter.hasNext()){
			user us = iter.next();
			JTextPane  chatArea = us.chatArea;
			if(us.user_num == user_num){
				StyledDocument doc = chatArea.getStyledDocument();
		        Style style = chatArea.addStyle("I'm a Style", null);
		        StyleConstants.setForeground(style,Color.blue);
		        try {doc.insertString(doc.getLength(), msg + "\n",style);} 
		        catch (BadLocationException e) {
					e.printStackTrace();
				}
		     
			}
			else{
				StyledDocument doc = chatArea.getStyledDocument();
		        Style style = chatArea.addStyle("I'm a Style", null);
		        StyleConstants.setForeground(style,Color.black);
		        try {doc.insertString(doc.getLength(), msg + "\n",style);} 
		        catch (BadLocationException e) {
					e.printStackTrace();
				}
			}
		}
		checkRep();
	}
}