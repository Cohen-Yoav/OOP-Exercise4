package homework4;

import java.awt.Font;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JTextPane;

//this interface is used for implementing the Strategy design pattern for changing 
// font fot the chat box..

interface FontType {
	public void ChangeTextBoxesFont(ArrayList<user> users);
}

class BoldFont implements FontType {
	@Override
	public void ChangeTextBoxesFont(ArrayList<user> users){
		Iterator<user> iter = users.iterator();
		while(iter.hasNext()){
			JTextPane chatArea = iter.next().chatArea;
			chatArea.setFont(new Font("default", Font.BOLD, 16));
		}
	}
}

class ItalicFont implements FontType {
	@Override
	public void ChangeTextBoxesFont(ArrayList<user> users){
		Iterator<user> iter = users.iterator();
		while(iter.hasNext()){
			JTextPane chatArea = iter.next().chatArea;
			chatArea.setFont(new Font("default", Font.ITALIC, 16));
		}
	}
}

class RegularFont implements FontType {
	@Override
	public void ChangeTextBoxesFont(ArrayList<user> users){
		Iterator<user> iter = users.iterator();
		while(iter.hasNext()){
			JTextPane chatArea = iter.next().chatArea;
			chatArea.setFont(new Font("default", Font.PLAIN, 16));
		}
	}
}