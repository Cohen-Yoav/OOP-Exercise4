package Question_Two;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class Subject {
    private List<ChatUser> observers;

    public Subject (List<ChatUser> user){
        observers = new ArrayList<ChatUser>(user);
    }

    public void PrintChatMSG(String msg, int user_id) 
    throws BadLocationException {
        Iterator<ChatUser> it = observers.iterator(); // TODO change from while + iterator to for each
        while (it.hasNext()) {
            ChatUser tmp = it.next();
            JTextPane chat = tmp.getTextArea();
            StyledDocument docStyle = chat.getStyledDocument();
            Style textStyle = chat.addStyle("msg", null);
            Color textColor = (tmp.getUser_id() == user_id ? Color.GREEN : Color.BLACK);
            StyleConstants.setForeground(textStyle, textColor);

            docStyle.insertString(docStyle.getLength(), msg + "\n", textStyle);
        }
    }

}
