package Question_Two;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ChatUser implements ActionListener{

    private final static int SIZE = 10;

    private int user_id;
    private JLabel actionLabel;
    private JLabel userLabel;
    private JTextField userfield;
    private JPanel userPanel;
    private JTextPane textArea;
    private Subject sb;

    public ChatUser(int User_id) {
        this.user_id = User_id;
        userfield = new JTextField(SIZE);
        userfield.setActionCommand("student " + user_id + ": ");
        userfield.addActionListener(this);

        userLabel = new JLabel("student " + user_id + ": ");
        userLabel.setLabelFor(userfield);

        actionLabel = new JLabel("Chat: ");
        actionLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));

        textArea = new JTextPane();

        textArea.setEditable(false);
        JScrollPane chatScroll = new JScrollPane(textArea);
        chatScroll.setPreferredSize(new Dimension(400, 50));

        actionLabel.setLabelFor(textArea);

        userPanel = new JPanel();
        GridBagLayout gridbag = new GridBagLayout();
        GridBagConstraints c1 = new GridBagConstraints();
        GridBagConstraints c2 = new GridBagConstraints();
        userPanel.setLayout(gridbag);
        
        c2.anchor = GridBagConstraints.EAST;
        c2.gridwidth = GridBagConstraints.RELATIVE;
        c2.fill = GridBagConstraints.NONE;
        c2.weightx = 0.0;
        userPanel.add(userLabel, c2);

        c2.gridwidth = GridBagConstraints.REMAINDER;
        c2.fill = GridBagConstraints.HORIZONTAL;
        c2.weightx = 1.0;
        userPanel.add(userfield, c2);

        c1.gridwidth = GridBagConstraints.REMAINDER;
        c1.anchor = GridBagConstraints.WEST;
        c1.weightx = 1.0;
        userPanel.add(actionLabel, c1);
        userPanel.add(textArea, c2);
        userPanel.setBorder(BorderFactory.createCompoundBorder
            (BorderFactory.createTitledBorder("Text Fields"), BorderFactory.createEmptyBorder(5, 5, 5, 5)));

        //checkrep FIXME
    }

    public void actionPerformed (ActionEvent event) {
        String pre = "student " + user_id + ": ";
        if (pre.equals(event.getActionCommand())) {
            JTextField source = (JTextField)event.getSource();
            try {
                sb.PrintChatMSG(pre + source.getText(), user_id);
            }

            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void SetSubject(Subject sub) {
        sb = sub;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public JLabel getActionLabel() {
        return actionLabel;
    }

    public void setActionLabel(JLabel actionLabel) {
        this.actionLabel = actionLabel;
    }

    public JLabel getUserLabel() {
        return userLabel;
    }

    public void setUserLabel(JLabel userLabel) {
        this.userLabel = userLabel;
    }

    public JTextField getUserfield() {
        return userfield;
    }

    public void setUserfield(JTextField userfield) {
        this.userfield = userfield;
    }

    public JPanel getUserPanel() {
        return userPanel;
    }

    public void setUserPanel(JPanel userPanel) {
        this.userPanel = userPanel;
    }

    public JTextPane getTextArea() {
        return textArea;
    }

    public void setTextArea(JTextPane textArea) {
        this.textArea = textArea;
    }

}
