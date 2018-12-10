package gui;


import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

import javax.swing.*;
import javax.swing.border.EmptyBorder;


public class GUI {
	private static Socket client = null;
	private static BufferedWriter os = null;
	private static BufferedReader is = null;
	private static JFrame mainFrame;
	private static JLabel headerLabel;
	private static JPanel controlPanel;
	private static JPanel controlPanel2;
	private static String usrname;
	//private JOptionPane menu;
	
	private static void prepareGUI(){
		  mainFrame = new JFrame("Bank");
	      mainFrame.setSize(350,500);
	      mainFrame.setLayout(new GridLayout(0, 1));
	      mainFrame.addWindowListener(new WindowAdapter() { 
	         public void windowClosing(WindowEvent windowEvent){
	        	 try {
					GUI.exit();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        	 System.exit(0);
	         }        
	      });    
	      headerLabel = new JLabel("", JLabel.CENTER);           
	      //headerLabel.setPreferredSize(new Dimension(100, 25));
	      
	      controlPanel = new JPanel();
	      controlPanel.setLayout(new GridLayout(0, 1));
	      controlPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
	      controlPanel2 = new JPanel();
	      controlPanel2.setLayout(new GridLayout(0, 1));
	      controlPanel2.setBorder(new EmptyBorder(10, 10, 10, 10));
	      mainFrame.setBackground(Color.BLACK);
	      //mainFrame.add(headerLabel);
	      mainFrame.add(controlPanel2);
	      mainFrame.add(controlPanel);
	      mainFrame.setLocationRelativeTo(null);
	      mainFrame.setVisible(true);  
	   }
	
	public GUI(Socket client) throws IOException {
		this.client = client;
		os = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
		is = new BufferedReader(new InputStreamReader(client.getInputStream()));
		
		prepareGUI();
	}
	
	public GUI() {
	}


		
	private static void showTransfer() throws IOException {
		   JTextField num = new JTextField();
		   JTextField amount = new JTextField();
		   final JComponent[] inputs = new JComponent[] {
		           new JLabel("Reciever's account number"),
		           num,
		           new JLabel("Amount"),
		           amount
		   };
		   int result = JOptionPane.showConfirmDialog(null, inputs, "Transfer", JOptionPane.PLAIN_MESSAGE);
		   String[] inp = new String[2];
		   if (result == JOptionPane.OK_OPTION) {
			   os.write("4");
			   os.newLine();
			   os.flush();
		       inp[0] = num.getText();
		       inp[1] = amount.getText();
		       os.write(inp[0]);
		       os.newLine();
		       os.flush();
		       os.write(inp[1]);
		       os.newLine();
		       os.flush();
		       String res = is.readLine();
		       if(res.contains("Success!!")) {
		    	   JOptionPane.showMessageDialog(null, res, "Success", JOptionPane.INFORMATION_MESSAGE);
		    	   showMenu2();
		       }
		       else {
		    	   JOptionPane.showMessageDialog(null, res, "Error", JOptionPane.ERROR_MESSAGE);
		       }
		   }	
	}


	private static void showInquiry() throws IOException {
		os.write("3");
		os.newLine();
		os.flush();
		String res = is.readLine();
		JOptionPane.showMessageDialog(null, res, "Inquiry", JOptionPane.INFORMATION_MESSAGE);
	    showMenu2();
	}

	private static void showWithdraw() throws IOException {
			   JTextField amount = new JTextField();
			   final JComponent[] inputs = new JComponent[] {
			           new JLabel("Enter amount"),
			           amount
			   };
			   int result = JOptionPane.showConfirmDialog(null, inputs, "Withdraw", JOptionPane.PLAIN_MESSAGE);
			 
			   if (result == JOptionPane.OK_OPTION) {
				   os.write("2");
					os.newLine();
					os.flush();
			       String inp = amount.getText();;
			       os.write(inp);
			       os.newLine();
			       os.flush();
			 
			       String res = is.readLine();
			       if(res.contains("Success!!")) {
			    	   JOptionPane.showMessageDialog(null, res, "Success", JOptionPane.INFORMATION_MESSAGE);
			    	   showMenu2();
			       }
			       else {
			    	   JOptionPane.showMessageDialog(null, res, "Error", JOptionPane.ERROR_MESSAGE);
			       }
			   } 
		
	}

	private static void showDeposit() throws IOException {

			   JTextField amount = new JTextField();
			   final JComponent[] inputs = new JComponent[] {
			           new JLabel("Enter amonut"),
			           amount
			   };
			   int result = JOptionPane.showConfirmDialog(null, inputs, "Deposit", JOptionPane.PLAIN_MESSAGE);
			 
			   if (result == JOptionPane.OK_OPTION) {
					os.write("1");
					os.newLine();
					os.flush();
			       String inp = amount.getText();;
			       os.write(inp);
			       os.newLine();
			       os.flush();
			 
			       String res = is.readLine();
			       if(res.contains("Success!!")) {
			    	   JOptionPane.showMessageDialog(null, res, "Success", JOptionPane.INFORMATION_MESSAGE);
			    	   showMenu2();
			       }
			       else {
			    	   JOptionPane.showMessageDialog(null, res, "Error", JOptionPane.ERROR_MESSAGE);
			       }
			   } 
		
	}
	private static String[] showLogin() throws IOException{ 
		
		   JTextField username = new JTextField();
		   JPasswordField password = new JPasswordField();
		   final JComponent[] inputs = new JComponent[] {
		           new JLabel("Username"),
		           username,
		           new JLabel("Password"),
		           password
		   };
		   int result = JOptionPane.showConfirmDialog(null, inputs, "Login", JOptionPane.PLAIN_MESSAGE);
		   String[] inp = new String[2];
		   if (result == JOptionPane.OK_OPTION) {
			   os.write("2");
				os.newLine();
				os.flush();
		       inp[0] = username.getText();
		       inp[1] = password.getText();
		       os.write(inp[0]);
		       os.newLine();
		       os.flush();
		       os.write(inp[1]);
		       os.newLine();
		       os.flush();
		       String res = is.readLine();
		       if(res.equals("Login successfully!")) {
		    	   JOptionPane.showMessageDialog(null, res, "Success", JOptionPane.INFORMATION_MESSAGE);
		    	   usrname = inp[0];
		    	   showMenu2();
		       }
		       else {
		    	   JOptionPane.showMessageDialog(null, res, "Error", JOptionPane.ERROR_MESSAGE);
		       }
		   }
		   return inp;   
		}
	private static void showDelete() throws IOException {

		   JTextField username = new JTextField();
		   JPasswordField password = new JPasswordField();
		   final JComponent[] inputs = new JComponent[] {
		           new JLabel("First"),
		           username,
		           new JLabel("Password"),
		           password
		   };
		   int result = JOptionPane.showConfirmDialog(null, inputs, "Delete", JOptionPane.PLAIN_MESSAGE);
		   String[] inp = new String[2];
		   if (result == JOptionPane.OK_OPTION) {
			   os.write("3");
			   os.newLine();
			   os.flush();
		       inp[0] = username.getText();
		       inp[1] = password.getText();
		       os.write(inp[0]);
		       os.newLine();
		       os.flush();
		       os.write(inp[1]);
		       os.newLine();
		       os.flush();
		       String res = is.readLine();
		       if(res.equals("1")) {
		    	   int dialogButton = JOptionPane.YES_NO_OPTION;
		    	   int dialogResult = JOptionPane.showConfirmDialog(null, "Are you sure to delete " + inp[0], "Delete", dialogButton);
		    	   if(dialogResult == JOptionPane.YES_OPTION) {
		    		   os.write("yes");
				       os.newLine();
				       os.flush();
				       res = is.readLine();
		    	   if(res.equals("Acount deleted!!!")) {
		    		   JOptionPane.showMessageDialog(null, res, "Success", JOptionPane.INFORMATION_MESSAGE);
		    	   showMain2();
		    	   }
		    	   else {
		    		   JOptionPane.showMessageDialog(null, res, "Error", JOptionPane.ERROR_MESSAGE);
		    	   }
		    	   }
		    	   else {
		    		   os.write("n");
				       os.newLine();
				       os.flush();
				       res = is.readLine();
			    	   JOptionPane.showMessageDialog(null, res, "Error", JOptionPane.ERROR_MESSAGE);
		    	   }}
		       else {
		    	   res = is.readLine();
		    	   JOptionPane.showMessageDialog(null, res, "Error", JOptionPane.ERROR_MESSAGE);	   
		       }
		   } 
	}
	private static void showRegister() throws IOException {
		   JTextField username = new JTextField();
		   JPasswordField password = new JPasswordField();
		   final JComponent[] inputs = new JComponent[] {
		           new JLabel("Username"),
		           username,
		           new JLabel("Password"),
		           password
		   };
		   int result = JOptionPane.showConfirmDialog(null, inputs, "Register", JOptionPane.PLAIN_MESSAGE);
		   String[] inp = new String[2];
		   if (result == JOptionPane.OK_OPTION) {
			   os.write("1");
			   os.newLine();
			   os.flush();
		       inp[0] = username.getText();
		       inp[1] = password.getText();
		       os.write(inp[0]);
		       os.newLine();
		       os.flush();
		       os.write(inp[1]);
		       os.newLine();
		       os.flush();
		       String res = is.readLine();
		       if(res.contains("Success!!")) {
		    	   JOptionPane.showMessageDialog(null, res, "Success", JOptionPane.INFORMATION_MESSAGE);
		    	   showMain2();
		       }
		       else {
		    	   JOptionPane.showMessageDialog(null, res, "Error", JOptionPane.ERROR_MESSAGE);
		       }
		   }
	}

	public static void exit() throws IOException {
		os.close();
		is.close();
		client.close();
	}

	
	public static void showMain2() {
		controlPanel.removeAll();
		controlPanel2.removeAll();
		JLabel log = new JLabel("Press Login to continue",JLabel.CENTER);
		JLabel reg = new JLabel("If you do not have an acount press Register",JLabel.CENTER);
		JLabel del = new JLabel("If you want to delete an acount press Delete Account",JLabel.CENTER);
		headerLabel.setText("Welcome");
		controlPanel2.add(headerLabel);
		controlPanel2.add(log);
		controlPanel2.add(reg);
		controlPanel2.add(del);
		JButton register = new JButton("Register");        
	    JButton login = new JButton("Login");
	    JButton delete = new JButton("Delete Account");
	    register.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	            try {
					GUI.showRegister();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	        	
	         }          
	      });
	    login.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	            try {
					GUI.showLogin();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	         }          
	      });
	    delete.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	            try {
					GUI.showDelete();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	         }          
	      });
	    controlPanel.add(register);
	    controlPanel.add(login);
	    controlPanel.add(delete);   
	    mainFrame.setVisible(true); 
	}
	
	private static void showMenu2(){                                       
	      
		  controlPanel.removeAll();
		  controlPanel2.removeAll();
	      headerLabel.setText("Internet Banking Services"); 
	      JLabel hi = new JLabel("Hello " +usrname, JLabel.CENTER);
	      JLabel ask = new JLabel("What do you want to do?", JLabel.CENTER);
	      controlPanel2.add(headerLabel);
	      controlPanel2.add(hi);
	      controlPanel2.add(ask);
	      JButton deposit = new JButton("Deposit");        
	      JButton withdraw = new JButton("Withdraw");
	      JButton inquiry = new JButton("Inquiry");
	      JButton transfer = new JButton("Transfer");
	      JButton logout = new JButton("Log out");

	      deposit.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	            try {
					GUI.showDeposit();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	         }          
	      });

	      withdraw.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	           try {
				GUI.showWithdraw();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				
				e1.printStackTrace();
			}
	         }
	      });

	      inquiry.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {                
	            try {
					GUI.showInquiry();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	         }
	      });
	      transfer.addActionListener(new ActionListener() {
		         public void actionPerformed(ActionEvent e) {                
		            try {
						GUI.showTransfer();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
		         }
		      });
	      logout.addActionListener(new ActionListener() {
		         public void actionPerformed(ActionEvent e) {                
		        	 try {
		        		 os.write("5");
						os.newLine();
						os.flush();
						GUI.showMain2();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					   
					
		         }
		      });

	      controlPanel.add(deposit);
	      controlPanel.add(withdraw);
	      controlPanel.add(inquiry); 
	      controlPanel.add(transfer); 
	      controlPanel.add(logout); 
	      mainFrame.setVisible(true);  
	   }
	
}		  

