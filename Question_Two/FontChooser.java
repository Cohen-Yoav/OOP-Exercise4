package Question_Two;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;


public class FontChooser implements ActionListener{
    private ButtonGroup Fonts_btn;
    private Fontable font;
    private List<ChatUser> ChatUsers;
    private JPanel btnPanel;

    public FontChooser(List<ChatUser> users) {
        ChatUsers = users;
        Fonts_btn = new ButtonGroup();
        font = new PlainFont();

        JButton Plain_btn = new JButton("Plain");
        Plain_btn.setMnemonic(KeyEvent.VK_0);
        Plain_btn.setActionCommand("PLAIN");
        Plain_btn.setSelected(true);
        Plain_btn.addActionListener(this);
        
        JButton Bold_btn = new JButton("Bold");
        Bold_btn.setMnemonic(KeyEvent.VK_1);
        Bold_btn.setActionCommand("BOLD");
        Bold_btn.addActionListener(this);
        
        JButton Sans_btn = new JButton("Serif");
        Sans_btn.setMnemonic(KeyEvent.VK_2);
        Sans_btn.setActionCommand("SERIF");
        Sans_btn.addActionListener(this);

        Fonts_btn.add(Plain_btn);
        Fonts_btn.add(Bold_btn);
        Fonts_btn.add(Sans_btn);
        
        btnPanel = new JPanel(new GridLayout(0,1));
        btnPanel.add(Plain_btn);
        btnPanel.add(Bold_btn);
        btnPanel.add(Sans_btn);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String Command = e.getActionCommand();
        if (Command.equals("PLAIN")) {
            font = new PlainFont();
        }

        else if (Command.equals("BOLD")) {
            font = new BoldFont();
        }

        else {
            font = new SansSerifFont();
        }

        font.ChangeFont(ChatUsers);
    }

    public ButtonGroup getFonts_btn() {
        return Fonts_btn;
    }

    public void setFonts_btn(ButtonGroup fonts_btn) {
        Fonts_btn = fonts_btn;
    }

    public JPanel getBtnPanel() {
        return btnPanel;
    }

    public void setBtnPanel(JPanel btnPanel) {
        this.btnPanel = btnPanel;
    }
}
