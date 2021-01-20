package Question_Two;

import java.awt.Font;
import java.util.List;

import javax.swing.JTextPane;

public class SansSerifFont implements Fontable {
    @Override
    public void ChangeFont(List<ChatUser> ChatUsers) {
        for (ChatUser U : ChatUsers) {
            JTextPane pani = U.getTextArea();
            pani.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 14));
        }
    }
}
