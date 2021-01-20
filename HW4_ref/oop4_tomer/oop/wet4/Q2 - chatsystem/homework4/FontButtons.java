package homework4;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

import com.sun.glass.events.KeyEvent;

public class FontButtons implements ActionListener {
	private ButtonGroup _bg;
	protected FontType _fontstyle;
	protected ArrayList<user> _users;
	protected JPanel radioPanel;
	
	
	public FontButtons(ArrayList<user> users){
		_users = users;
		_bg = new ButtonGroup();
		_fontstyle = new RegularFont(); //initial with regular.
		//Create the radio buttons.
		JRadioButton regularFontButton = new JRadioButton("Regular Font");
		regularFontButton.setMnemonic(KeyEvent.VK_B);
		regularFontButton.setActionCommand("Regular Font");
		regularFontButton.setSelected(true);
		//
        JRadioButton BoldFontButton = new JRadioButton("Bold Font");
        BoldFontButton.setMnemonic(KeyEvent.VK_C);
        BoldFontButton.setActionCommand("Bold Font");
 
        JRadioButton ItalicFontButton = new JRadioButton("Italic Font");
        ItalicFontButton.setMnemonic(KeyEvent.VK_D);
        ItalicFontButton.setActionCommand("Italic Font");
        //Group the radio buttons.
        _bg.add(regularFontButton);
        _bg.add(BoldFontButton);
        _bg.add(ItalicFontButton);
       
 
        //Register a listener for the radio buttons.
        regularFontButton.addActionListener(this);
        BoldFontButton.addActionListener(this);
        ItalicFontButton.addActionListener(this);
        
        //Put the radio buttons in a column in a panel.
        radioPanel = new JPanel(new GridLayout(0, 1));
        radioPanel.add(regularFontButton);
        radioPanel.add(BoldFontButton);
        radioPanel.add(ItalicFontButton);
    }
 
    /** Listens to the radio buttons. */
    public void actionPerformed(ActionEvent e) {
            switch(e.getActionCommand()){
            case "Regular Font":
            	_fontstyle = new RegularFont();
            	break;
            case "Bold Font":
            	_fontstyle = new BoldFont();
            	break;
            case "Italic Font":
            	_fontstyle = new ItalicFont();
            	break;
            }                              
            _fontstyle.ChangeTextBoxesFont(_users);
    }
}