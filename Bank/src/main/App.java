package main;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import gui.GUI;

public class App {
	
	
	
	@SuppressWarnings("unused")
	public static void main(String[] args) throws UnknownHostException, IOException {
		//Object[] buttons = {"Connect!"};
		//String ip = JOptionPane.showInputDialog(null, "Enter host IP address", "MyInternetBanking", JOptionPane.PLAIN_MESSAGE);
		String ip = JOptionPane.showInputDialog(null, "Enter host IP address", "MyInternetBanking", JOptionPane.PLAIN_MESSAGE);
		if(ip!=null) {
			try {
			Socket client = new Socket(ip, 8888);
		GUI gui = new GUI(client);
		GUI.showMain2();
		//gui.exit();
		} catch(SocketException e) {
			JOptionPane.showMessageDialog(null, "Cannot connect to that IP!!!", "Connection Error", JOptionPane.ERROR_MESSAGE);
		}
		
	}
		
	}
	
}
