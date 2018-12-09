package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class GUI {
	private static String[] showLogin(){                                       
		   JTextField username = new JTextField();
		   JPasswordField password = new JPasswordField();
		   final JComponent[] inputs = new JComponent[] {
		           new JLabel("First"),
		           username,
		           new JLabel("Password"),
		           password
		   };
		   int result = JOptionPane.showConfirmDialog(null, inputs, "My custom dialog", JOptionPane.PLAIN_MESSAGE);
		   String[] inp = new String[2];
		   if (result == JOptionPane.OK_OPTION) {
		       inp[0] = username.getText();
		       inp[1] = password.getText();
		   }
		   return inp;   
		}
	public static String starting() {
		Object[] options1 = { "Register", "Login","Delete Account" };
		JPanel panel = new JPanel();
		panel.add(new JLabel("Enter number between 0 and 1000"));
		JTextField textField = new JTextField(10);
		panel.add(textField);

		int result = JOptionPane.showOptionDialog(null, panel, "Enter a Number",
				JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE,
				null, options1, null);
		if (result == JOptionPane.YES_OPTION){
			return "1";
		}
		else if (result == JOptionPane.NO_OPTION){
			return "2";
		}
		else if (result == JOptionPane.CANCEL_OPTION){
			return "3";
		}
		return "";
	}
}
//	public static void main(String[] args) {
//		Login login = new Login();
//		String[] a = login.showLogin();
//		System.out.println(a[0]);
//		System.out.println(a[1]);
//	}
		  

