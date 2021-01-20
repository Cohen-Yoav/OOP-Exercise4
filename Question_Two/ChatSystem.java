package Question_Two;

import java.util.List;
import java.awt.BorderLayout;
import java.util.ArrayList;
import javax.swing.*;

public class ChatSystem {
    List<ChatUser> chatUsers;

    public ChatSystem () {
        chatUsers = new ArrayList<ChatUser>();
    }

    public ChatSystem (List<ChatUser> users) {
        chatUsers = new ArrayList<ChatUser>(users);
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
}