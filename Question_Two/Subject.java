package Question_Two;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class Subject {

    // Abstraction Function:
    //  Subject sb is responsible to notify all the observers that an update was made to the chat.
    //   
    // Representation Invariant:
    //  observers != null
    private List<ChatUser> observers;

	/**
     * Constructs a new Subject
     **/
    public Subject (List<ChatUser> user){
        observers = new ArrayList<ChatUser>(user);
        checkRep();
    }

	/**
     * Notify all observers (Chat users) that a new text was entered
     * @Effects: notify all observers with the new msg 
     **/
    public void PrintChatMSG(String msg, int user_id) 
    throws BadLocationException {
        checkRep();
        for (ChatUser cu: observers) {
            JTextPane chat = cu.getTextArea();
            StyledDocument docStyle = chat.getStyledDocument();
            Style textStyle = chat.addStyle("msg", null);
            Color textColor = (cu.getUser_id() == user_id ? Color.GREEN : Color.BLACK);
            StyleConstants.setForeground(textStyle, textColor);

            docStyle.insertString(docStyle.getLength(), msg + "\n", textStyle);
        }
        checkRep();
    }

    private void checkRep() {
        assert (observers != null) :
        "Error in Subject!";
    }
}
