package Question_Two;

import java.awt.Font;
import java.util.List; // TODO check Array

import javax.swing.JTextPane;

public class SansSerifFont implements Fontable {
    @Override
    public void ChangeFont(List<ChatUser> ChatUsers) {
        for (ChatUser U : ChatUsers) {
            JTextPane pani = U.getTextArea();
            pani.setFont(new Font(Font.SERIF, Font.PLAIN, 14));
        }
    } 
}
