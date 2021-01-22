package Question_Two;

import java.util.List;
import java.awt.BorderLayout;
import java.util.ArrayList;
import javax.swing.*;

public class ChatSystem {
    // Abstraction Function:
    //  ChatSystem CS is an interactive chat platform which conatins
    //  users of the chat and buttons for modifing the chat text
    // Representation Invariant:
    //  chatUsers != null
    List<ChatUser> chatUsers;

	/**
   	 * Constructs a new ChatSystem.
      * @effects Constructs a new ChatSystem.
      **/ 
    public ChatSystem () {
        chatUsers = new ArrayList<ChatUser>();
        checkRep();
    }

	/**
   	 * Constructs a new ChatSystem and assign users to this Chatuser list.
      * @effects Constructs a new ChatSystem.
      **/ 
    public ChatSystem (List<ChatUser> users) {
        chatUsers = new ArrayList<ChatUser>(users);
        checkRep();
    }

    public static void main(String[] args) {

        ChatUser Yoav = new ChatUser(1);
        ChatUser Ben = new ChatUser(2);
        ChatUser Chen = new ChatUser(3);

        List<ChatUser> Residents = new ArrayList<>();
        Residents.add(Yoav);
        Residents.add(Ben);
        Residents.add(Chen);
        
        ChatSystem BigBrotherChat = new ChatSystem(Residents);
        Subject BigBrother = new Subject(Residents);

        for (ChatUser user: Residents) {
            user.SetSubject(BigBrother);
        }

        JFrame chatFrame = new JFrame("Big Brother Chat");

        chatFrame.add(Yoav.getUserPanel(), BorderLayout.EAST);
        chatFrame.add(Ben.getUserPanel(), BorderLayout.CENTER);
        chatFrame.add(Chen.getUserPanel(), BorderLayout.WEST);

        FontChooser FC = new FontChooser(Residents);
        chatFrame.add(FC.getBtnPanel(), BorderLayout.PAGE_END);

        chatFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        chatFrame.pack();
        chatFrame.revalidate();
        chatFrame.repaint();
        chatFrame.setVisible(true);
    }

    private void checkRep() {
        assert (chatUsers != null): "ERROR chatUsers";
    }
}