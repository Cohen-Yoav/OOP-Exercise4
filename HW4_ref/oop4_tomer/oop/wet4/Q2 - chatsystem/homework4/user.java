package homework4;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;

	
/**
 * A user is a student in the chat system which has a opend chat box.
 * <p>
 * users are immutable. New users can be constructed by adding a new user 
 * with a new number.
 * <p>
 * each user in the system is built from a 
 * JPanel. the user JPanel contains two Jlabels.
 * first Jlabel conaitns a  JTextField which is used for the user input.
 * the second Jlabel contanis a JTextPane which is where the chatbox is shown for
 * this user.  
 * <b>The following fields are used in the specification:</b>
 * <pre>
 *  int user_num;    //the student number in the chatsystem
    JLabel actionLabel; //the label which represents the chatbox it changes each time the user types and presses enter.
    JLabel userLabel;   // the label in which the user types
    JTextField usertextField; // the textfield where the user types.
    JPanel userPane;         // the user main panel
     JTextPane chatArea;     // the chatArea box.
     handler _hd;			// The subject - this hd is responsible no notify all the users when a new text is enterd
      						// and add that text to all chatboxes for all users in the chat system.
 * </pre>
 **/
public class user implements ActionListener{

	protected int user_num;
    protected JLabel actionLabel;
    protected JLabel userLabel;
    protected JTextField usertextField;
    protected JPanel userPane;
    protected  JTextPane chatArea;
    protected handler _hd;
    
  //abstraction function:
  	// A user is a Jpanel containing two Jlables.
    //userLabel conatins the usertextField which is where the users write text
    // to chat. actionLabel contains the chatArea where the masseges from all
    // users apear.
    // user also has _hd The subject - this hd is responsible no notify all the users when a new text
    //is entered
    // and add that text to all chatboxes for all users in the chat system.
  	
  	
  	//representation invariant:
  	// for user us: 
  	//user_num > 0 && actionLabel != null && userLabel != null
    // && usertextField!= null && chatArea != null
    
    /**
  	 * Checks to see if the representation invariant is being violated.
  	 * @throws AssertionError if representation invariant is violated.
  	 */
  	 private void checkRep(){
		assert actionLabel != null:
			"actionLabel is null";
		assert userLabel != null:
			"userLabel is null";
		assert usertextField != null:
			"usertextField is null";
		assert userPane != null:
			"userPane is null";
		assert chatArea != null:
			"chatArea is null";
		assert user_num > 0:
			"user_num not greater the zero";
  	}
  	 
  	/**
   	 * Constructs a new user.
      * @requires num > 0
      * @effects Constructs a new user, us, such that
      *	        us.user_num = num
      *	and buildes a jpanel for the user. 
      **/ 
    public user(int num) {
    	user_num = num;
        //Create a regular text field.
    	usertextField = new JTextField(10);
    	usertextField.setActionCommand("student " + user_num + ": " );
    	usertextField.addActionListener(this);
        
        //Create user label
    	userLabel = new JLabel("student " + user_num + ": ");
    	userLabel.setLabelFor(usertextField);
    	
        //Create a label to put messages during an action event.
        actionLabel = new JLabel("Chat: ");
        actionLabel.setBorder(BorderFactory.createEmptyBorder(10,0,0,0));
         chatArea = new JTextPane();
        
        chatArea.setEditable(false);
		JScrollPane scrlchatArea = new JScrollPane(chatArea);
		scrlchatArea.setPreferredSize(new Dimension(400, 70));
		
		actionLabel.setLabelFor(chatArea);
		
        //Lay out the text controls and the labels.
        userPane = new JPanel();
        GridBagLayout gridbag = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();
 
        userPane.setLayout(gridbag);
 
        
        GridBagConstraints d = new GridBagConstraints();
        d.anchor = GridBagConstraints.EAST;
            d.gridwidth = GridBagConstraints.RELATIVE; //next-to-last
            d.fill = GridBagConstraints.NONE;      //reset to default
            d.weightx = 0.0;                       //reset to default
            userPane.add(userLabel, d);
 
            d.gridwidth = GridBagConstraints.REMAINDER;     //end row
            d.fill = GridBagConstraints.HORIZONTAL;
            d.weightx = 1.0;
            userPane.add(usertextField, d);
        
        
        c.gridwidth = GridBagConstraints.REMAINDER; //last
        c.anchor = GridBagConstraints.WEST;
        c.weightx = 1.0;
        userPane.add(actionLabel, c);
        userPane.add(chatArea,d);
        userPane.setBorder(
                BorderFactory.createCompoundBorder(
                                BorderFactory.createTitledBorder("Text Fields"),
                                BorderFactory.createEmptyBorder(5,5,5,5)));
       checkRep();
    }
    /**
     * @Effects: calls the subject hd to notify all the users that a 
     * massege has been sent.
     * 
     **/
    public void actionPerformed(ActionEvent e){
    	checkRep();
    	String prefix = "student " + user_num + ": ";
        if(prefix.equals(e.getActionCommand())) {
            JTextField source = (JTextField)e.getSource();
            _hd.PrintMasssege(prefix + source.getText(), user_num);
        }  
        checkRep();
    }
    /**
     * @Effects: set a subject handler to the user.
     * 
     **/
    public void SetHandler(handler hd){
    	checkRep();
    	_hd = hd;
    	checkRep();
    }
}