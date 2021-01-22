package Question_Two;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ChatUser implements ActionListener{
    // Abstraction Function:
    //  ChatUser Cu is an object represnting a user in the chat system.
    //  UC has GUI to support the chat box for each user and
    //  UC will be able to update it's content upon new events in the system
    // Representation Invariant:
    //  ChatLabel != null && chatUserLabel != null && userField != null &&
    //  userPanel != null && textArea != null && sb != null

    private final static int SIZE = 10;

    private int user_id;
    private JLabel ChatLabel;
    private JLabel chatUserLabel;
    private JTextField userField;
    private JPanel userPanel;
    private JTextPane textArea;
    private Subject sb;

  	/**
   	 * Constructs a new Chat user.
      * @effects Constructs a new Chat user with user_id = User_id
      *          and set up the Jpanel for this user
      **/ 
    public ChatUser(int User_id) {
        user_id = User_id;
        userField = new JTextField(SIZE);
        userField.setActionCommand("student " + user_id + ": ");
        userField.addActionListener(this);

        chatUserLabel = new JLabel("student " + user_id + ": ");
        chatUserLabel.setLabelFor(userField);

        ChatLabel = new JLabel("Chat: ");
        ChatLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));

        textArea = new JTextPane();

        textArea.setEditable(false);
        JScrollPane chatScroll = new JScrollPane(textArea);
        chatScroll.setPreferredSize(new Dimension(400, 50));

        ChatLabel.setLabelFor(textArea);

        userPanel = new JPanel();
        GridBagLayout gridbag = new GridBagLayout();
        GridBagConstraints c1 = new GridBagConstraints();
        GridBagConstraints c2 = new GridBagConstraints();
        userPanel.setLayout(gridbag);
        
        c2.anchor = GridBagConstraints.EAST;
        c2.gridwidth = GridBagConstraints.RELATIVE;
        c2.fill = GridBagConstraints.NONE;
        c2.weightx = 0.0;
        userPanel.add(chatUserLabel, c2);

        c2.gridwidth = GridBagConstraints.REMAINDER;
        c2.fill = GridBagConstraints.HORIZONTAL;
        c2.weightx = 1.0;
        userPanel.add(userField, c2);

        c1.gridwidth = GridBagConstraints.REMAINDER;
        c1.anchor = GridBagConstraints.WEST;
        c1.weightx = 1.0;
        userPanel.add(ChatLabel, c1);
        userPanel.add(textArea, c2);
        userPanel.setBorder(BorderFactory.createCompoundBorder
            (BorderFactory.createTitledBorder("Text Fields"), BorderFactory.createEmptyBorder(5, 5, 5, 5)));

        checkRep();
    }

    /**
     * @Effects: update the observer that an event has occured in the system
     **/
    public void actionPerformed (ActionEvent event) {
        checkRep();
        String pre = "student " + user_id + ": ";
        if (pre.equals(event.getActionCommand())) {
            JTextField source = (JTextField)event.getSource();
            try {
                sb.PrintChatMSG(pre + source.getText(), user_id);
            }

            catch (Exception e) {
                checkRep();
                e.printStackTrace();
            }
        }
        checkRep();
    }

    public void SetSubject(Subject sub) {
        checkRep();
        sb = sub;
        checkRep();
    }

    public int getUser_id() {
        checkRep();
        return user_id;
    }

    public void setUser_id(int user_id) {
        checkRep();
        this.user_id = user_id;
        checkRep();
    }

    public JLabel getChatLabel() {
        checkRep();
        return ChatLabel;
    }

    public void setChatLabel(JLabel ChatLabel) {
        checkRep();
        this.ChatLabel = ChatLabel;
        checkRep();
    }

    public JLabel getchatUserLabel() {
        checkRep();
        return chatUserLabel;
    }

    public void setchatUserLabel(JLabel chatUserLabel) {
        checkRep();
        this.chatUserLabel = chatUserLabel;
        checkRep();
    }

    public JTextField getuserField() {
        checkRep();
        return userField;
    }

    public void setuserField(JTextField userField) {
        checkRep();
        this.userField = userField;
        checkRep();
    }

    public JPanel getUserPanel() {
        checkRep();
        return userPanel;
    }

    public void setUserPanel(JPanel userPanel) {
        checkRep();
        this.userPanel = userPanel;
        checkRep();
    }

    public JTextPane getTextArea() {
        checkRep();
        return textArea;
    }

    public void setTextArea(JTextPane textArea) {
        checkRep();
        this.textArea = textArea;
        checkRep();
    }

    private void checkRep() {
        assert (ChatLabel != null) :"Error ChatLabel";
        assert (chatUserLabel != null) :"Error chatUserLabel";
        assert (userField != null) :"Error userField";
        assert (userPanel != null) :"Error userPanel";
        assert (textArea != null) :"Error textArea";
        assert (sb != null) :"Error sb";
    }
}
