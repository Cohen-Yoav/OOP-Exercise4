package Question_Two;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.List;
import java.awt.Dimension;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;


public class FontChooser implements ActionListener{

    // Abstraction Function:
    //  FontChooser FC will implement the interface ActionListener,
    //  once an event was triggred this class will change the Font according to the type of the event
    // Representation Invariant:
    //  Fonts_btn != null && font != null && ChatUsers != null && btnPanel != null

    private ButtonGroup Fonts_btn;
    private Fontable font;
    private List<ChatUser> ChatUsers;
    private JPanel btnPanel;

	/**
     * Constructs a new FontChooser
     **/
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

        checkRep();
    }


	/**
     * this method is invoked when an event occured
     * @Modifies: this.dont to the corruspanding Font style that was chosen 
     **/
    @Override
    public void actionPerformed(ActionEvent e) {
        checkRep();
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
        checkRep();
    }

    public JPanel getBtnPanel() {
        checkRep();
        return btnPanel;
    }

    private void checkRep() {
        assert (Fonts_btn != null): 
        "Error Fonts_btn";
        assert (font != null): 
        "Error font";
        assert (ChatUsers != null): 
        "Error ChatUsers";
        assert (btnPanel != null): 
        "Error btnPanel";
    }
}
