package com.project.server;

import java.io.*;
import java.net.Socket;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ServerWorker extends Thread {

    private final Socket clientSocket;
    private final Server server;
//    private OutputStream outputStream;
    private Query query;
    private BufferedWriter os = null;
	private BufferedReader is = null;


    public ServerWorker(Server server, Socket clientSocket) throws IOException {
        query = new Query();
        this.server = server;
        this.clientSocket = clientSocket;
        os = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
		is = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        try {
            handleSocketClient();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


//    private void handleSocketClient() throws IOException, SQLException {
//        // TODO Auto-generated method stub
//        boolean done = false;
//        while (!done) {
//            OutputStream out = clientSocket.getOutputStream();
//            PrintWriter pwInput = new PrintWriter(out, true);
//            clearScreen(pwInput);
//            String menu =
//                    "------------Choose action you want to perform----------\n"
//                            + "1. Register\n"
//                            + "2. Login\n"
//                            + "3. Delete account\n"
//                            + "Enter the number you want to choose: ";
//            pwInput.println(menu);
//            InputStream in = clientSocket.getInputStream();
//            BufferedReader reader1 = new BufferedReader(new InputStreamReader(in));
//            switch (reader1.readLine()) {
//                case "1":
//                    clearScreen(pwInput);
//                    String msg = "Enter username and password respectively: ";
//                    this.outputStream = clientSocket.getOutputStream();
//                    PrintWriter pw = new PrintWriter(outputStream, true);
//                    pw.println(msg);
//
//                    InputStream inputStream = clientSocket.getInputStream();
//                    BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
//                    String line;
//                    List<String> tokens = new ArrayList<String>();
//                    while ((line = reader.readLine()) != null) {
//                        System.out.println("token receive: " + line);
//                        tokens.add(line);
//                        System.out.println("tokens size: " + tokens.size());
//                        if (tokens.size() == 2) {
//                            break;
//                        }
//                    }
//
//                    done = handleRegister(pw, tokens, reader);
//                    pw.println("\n---Press anything to login---");
//                    reader.read();
//                    if (done) {
//                        String acc_num = query.isInDB(tokens.get(0), tokens.get(1));
//                        pw.println("\n\n Your account number is: " + acc_num);
//                        pw.println("\n\n---Press anything to login---");
//                        reader.read();
//                        clearScreen(pw);
//                        handleLogin(pw, tokens, reader);
//                        done = false;
//                    }
//                    break;
//                case "2":
//                    clearScreen(pwInput);
//                    String msg2 = "Enter username and password respectively: ";
//                    this.outputStream = clientSocket.getOutputStream();
//                    PrintWriter pw2 = new PrintWriter(outputStream, true);
//                    pw2.println(msg2);
//                    InputStream inputStream2 = clientSocket.getInputStream();
//                    BufferedReader reader2 = new BufferedReader(new InputStreamReader(inputStream2));
//                    String line2;
//                    List<String> tokens2 = new ArrayList<String>();
//                    while ((line2 = reader2.readLine()) != null) {
//                        System.out.println("token receive: " + line2);
//                        tokens2.add(line2);
//                        System.out.println("tokens size: " + tokens2.size());
//                        if (tokens2.size() == 2) {
//                            break;
//                        }
//                    }
//                    handleLogin(pw2, tokens2, reader2);
//                    break;
//                case "3":
//                    clearScreen(pwInput);
//                    String msg3 = "Enter username and password respectively: ";
//                    this.outputStream = clientSocket.getOutputStream();
//                    PrintWriter pw3 = new PrintWriter(outputStream, true);
//                    pw3.println(msg3);
//                    InputStream inputStream3 = clientSocket.getInputStream();
//                    BufferedReader reader3 = new BufferedReader(new InputStreamReader(inputStream3));
//                    String line3;
//                    List<String> tokens3 = new ArrayList<String>();
//                    while ((line3 = reader3.readLine()) != null) {
//                        System.out.println("token receive: " + line3);
//                        tokens3.add(line3);
//                        System.out.println("tokens size: " + tokens3.size());
//                        if (tokens3.size() == 2) {
//                            break;
//                        }
//                    }
//                    String acc_num = query.isInDB(tokens3.get(0), tokens3.get(1));
//                    if (acc_num != null) {
//                        pw3.println("Your account is about to be deleted. Are you sure? (Press y to accept)");
//                        InputStream inputStream4 = clientSocket.getInputStream();
//                        BufferedReader reader4 = new BufferedReader(new InputStreamReader(inputStream4));
//                        String line0 = reader4.readLine();
//                        if (line0.equals("y") || line0.equals("Y")) {
//                            handleDeleteAccount(pw3, tokens3, reader3);
//                            pw3.println("\n\n---Press anything to continue---");
//                            reader3.readLine();
//                        } else {
//                            pw3.println("Delete Failed! Bring you back to menu");
//                            pw3.println("\n\n---Press anything to continue---");
//                            reader3.readLine();
//                        }
//                    } else {
//                        pw3.println("Delete Failed! Not valid username or password!");
//                        pw3.println("\n\n---Press anything to continue---");
//                        reader3.readLine();
//                    }
//                    break;
//                default:
//                	reader1.readLine();
//                    break;
//            }
//        }
//    }

    private void handleSocketClient() throws IOException, SQLException {
        // TODO Auto-generated method stub
        boolean done = false;
        while (!done) {
//            OutputStream out = clientSocket.getOutputStream();
//            PrintWriter pwInput = new PrintWriter(out, true);
//            clearScreen(pwInput);
//            String menu =
//                    "------------Choose action you want to perform----------\n"
//                            + "1. Register\n"
//                            + "2. Login\n"
//                            + "3. Delete account\n"
//                            + "Enter the number you want to choose: ";
//            pwInput.println(menu);
//            InputStream in = clientSocket.getInputStream();
//            BufferedReader reader1 = new BufferedReader(new InputStreamReader(in));
        	System.out.println("coming");
        	String a = is.readLine();
            switch (a) {
                case "1":
//                	os.write("1");
//              	    os.newLine();
//              	    os.flush();
//                    clearScreen(pwInput);
//                    String msg = "Enter username and password respectively: ";
//                    this.outputStream = clientSocket.getOutputStream();
//                    PrintWriter pw = new PrintWriter(outputStream, true);
//                    pw.println(msg);

//                    InputStream inputStream = clientSocket.getInputStream();
//                    BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                    String line;
                    List<String> tokens = new ArrayList<String>();
                    while ((line = is.readLine()) != null) {
                        System.out.println("token receive: " + line);
                        tokens.add(line);
                        System.out.println("tokens size: " + tokens.size());
                        if (tokens.size() == 2) {
                            break;
                        }
                    }

                    handleRegister(tokens);
//                    pw.println("\n---Press anything to login---");
//                    reader.read();
//                    if (done) {
//                        String acc_num = query.isInDB(tokens.get(0), tokens.get(1));
//                        pw.println("\n\n Your account number is: " + acc_num);
//                        pw.println("\n\n---Press anything to login---");
//                        reader.read();
//                        clearScreen(pw);
//                        handleLogin(pw, tokens, reader);
//                        done = false;
//                    }
                    break;
                case "2":
//                	  os.write("2");
//                	  os.newLine();
//                	  os.flush();
//                    clearScreen(pwInput);
//                    String msg2 = "Enter username and password respectively: ";
//                    this.outputStream = clientSocket.getOutputStream();
//                    PrintWriter pw2 = new PrintWriter(outputStream, true);
//                    pw2.println(msg2);
//                    InputStream inputStream2 = clientSocket.getInputStream();
//                    BufferedReader reader2 = new BufferedReader(new InputStreamReader(inputStream2));
                    String line2;
                    List<String> tokens2 = new ArrayList<String>();
                    while ((line2 = is.readLine()) != null) {
                        System.out.println("token receive: " + line2);
                        tokens2.add(line2);
                        System.out.println("tokens size: " + tokens2.size());
                        if (tokens2.size() == 2) {
                            break;
                        }
                    }
                    handleLogin(tokens2);
                    break;
                case "3":
//                	os.write("3");
//              	  os.newLine();
//              	  os.flush();
//                    clearScreen(pwInput);
//                    String msg3 = "Enter username and password respectively: ";
//                    this.outputStream = clientSocket.getOutputStream();
//                    PrintWriter pw3 = new PrintWriter(outputStream, true);
//                    pw3.println(msg3);
//                    InputStream inputStream3 = clientSocket.getInputStream();
//                    BufferedReader reader3 = new BufferedReader(new InputStreamReader(inputStream3));
                    String line3;
                    List<String> tokens3 = new ArrayList<String>();
                    while ((line3 = is.readLine()) != null) {
                        System.out.println("token receive: " + line3);
                        tokens3.add(line3);
                        System.out.println("tokens size: " + tokens3.size());
                        if (tokens3.size() == 2) {
                            break;
                        }
                    }
                    String acc_num = query.isInDB(tokens3.get(0), tokens3.get(1));
                    if (acc_num != null) {
//                        pw3.println("Your account is about to be deleted. Are you sure? (Press y to accept)");
//                        InputStream inputStream4 = clientSocket.getInputStream();
//                        BufferedReader reader4 = new BufferedReader(new InputStreamReader(inputStream4));
                        os.write("1");
                        os.newLine();
                        os.flush();
                    	String line0 = is.readLine();
                        if (line0.equals("yes")) {
                           boolean t = handleDeleteAccount(tokens3);
                          if(t) {
                           os.write("Acount deleted!!!");
                      	  os.newLine();
                      	  os.flush();}
                          else {
                        	  os.write("Delete Failed! Data Error");
                          	  os.newLine();
                          	  os.flush();
                          }
//                            pw3.println("\n\n---Press anything to continue---");
//                            reader3.readLine();
                        } else {
                        	os.write("Delete Failed! You canceled it");
                      	  os.newLine();
                      	  os.flush();
//                            pw3.println("Delete Failed! Bring you back to menu");
//                            pw3.println("\n\n---Press anything to continue---");
//                            reader3.readLine();
                        }
                    } else {
                    	os.write("0");
                        os.newLine();
                        os.flush();
                    	os.write("Delete Failed! Not valid username or password!");
                  	  os.newLine();
                  	  os.flush();
//                        pw3.println("Delete Failed! Not valid username or password!");
//                        pw3.println("\n\n---Press anything to continue---");
//                        reader3.readLine();
                    }
                    break;
                default:
                    break;
            }
        }
    }
    private boolean handleLogin( List<String> tokens) throws SQLException, IOException {
    	boolean out = false;
        if (tokens.size() == 2) {
            String user = tokens.get(0);
            String password = tokens.get(1);
//            pw.println("Loging in please wait....");
            String acc_num = query.isInDB(user, password);
            if (acc_num != null) {
                Identification identification = new Identification(user, "port::" + clientSocket.getPort());
                System.out.println(identification.toString());
                String msg = "Login successfully!";
//                pw.println(msg);
//                pw.println("\n\n---Press anything to continue---");
//                reader.readLine();
                os.write(msg);
                os.newLine();
                os.flush();
                Bank bank = new Bank(query);

                while (!out) {
//                    clearScreen(pw);
//                    String menu =
//                            "------------Choose action you want to perform----------\n"
//                                    + "1. Deposit\n"
//                                    + "2. Withdraw\n"
//                                    + "3. Inquiry\n"
//                                    + "4. Transfer\n"
//                                    + "5. Log off\n"
//                                    + "Enter the number you want to choose: ";
//
//                    pw.println(menu);
                	String in;
                    List<String> strings = new ArrayList();
                    String a = is.readLine();
                    switch (a) {
                        case "1":
//                        	os.write("1");
//                        	os.newLine();
//                        	os.flush();
                            MessageQueue.addMQueue(identification);
                            if (!identification.isReadOnly()) {
//                                pw.println("case 1");
                            	while ((in = is.readLine()) != null) {
                                    System.out.println("token receive: " + in);
                                    strings.add(in);
                                    System.out.println("tokens size: " + in);
                                    if (strings.size() == 1) {
                                        break;
                                    }
                                }
                            	if(!isNumeric(strings.get(0)) || Integer.parseInt(strings.get(0)) < 0) {
                                	os.write("Invalid input!!! You can only input a possitive number!!!");
                                    os.newLine();
                                    os.flush();
                                    MessageQueue.removeQueue(identification);
                                    identification.setReadOnly(false);
                                    break;
                                }
                                int depositResult = bank.deposit(acc_num, Integer.parseInt(strings.get(0)));
                                if (depositResult != -1) {
                                    String mString = "Success!! Your balance now is: " + depositResult;
                                    os.write(mString);
                                    os.newLine();
                                    os.flush();
                                    MessageQueue.removeQueue(identification);
                                    identification.setReadOnly(false);
//                                    pw.println(mString);
//                                    pw.println("\n\n---Press anything to continue---");
//                                    reader.readLine();
                                    
//                            outputStream.write(mString.getBytes());
                                }
                            } else {
                            	while ((in = is.readLine()) != null) {
                                    System.out.println("token receive: " + in);
                                    strings.add(in);
                                    System.out.println("tokens size: " + in);
                                    if (strings.size() == 1) {
                                        break;
                                    }
                                }
                            	os.write("Someone is using this account for transaction, please wait");
                                os.newLine();
                                os.flush();
                                MessageQueue.removeQueue(identification);
                                identification.setReadOnly(false);
//                                pw.println("da co nguoi dang nhap truoc ban, vui long cho");
//                                reader.readLine();
                                
                            }
                            break;
                        case "2":
//                        	os.write("2");
//                        	os.newLine();
//                        	os.flush();
                            MessageQueue.addMQueue(identification);
                            if (!identification.isReadOnly()) {
                            	while ((in = is.readLine()) != null) {
                                    System.out.println("token receive: " + in);
                                    strings.add(in);
                                    System.out.println("tokens size: " + in);
                                    if (strings.size() == 1) {
                                        break;
                                    }
                                }
                            	if(!isNumeric(strings.get(0)) || Integer.parseInt(strings.get(0)) < 0) {
                                	os.write("Invalid input!!! You can only input a possitive number!!!");
                                    os.newLine();
                                    os.flush();
                                    MessageQueue.removeQueue(identification);
                                    identification.setReadOnly(false);
                                    break;
                                }
                                int withdrawResult = query.selectByAccNum(acc_num).getBalance();
                                if (query.selectByAccNum(acc_num).getBalance() < Integer.parseInt(strings.get(0))) {
                                	os.write("You do not have enough money do complete this transaction.");
                                    os.newLine();
                                    os.flush();
                                    MessageQueue.removeQueue(identification);
                                    identification.setReadOnly(false);
                                    break;
                                }
                                else {
                                	withdrawResult = bank.withdraw(acc_num, Integer.parseInt(strings.get(0)));
                                }
                                String mString1 = "Success!! Your balance now is: " + withdrawResult;
                                MessageQueue.removeQueue(identification);
                                identification.setReadOnly(false);
                                os.write(mString1);
                                os.newLine();
                                os.flush();
//                                pw.println(mString1);
//                                pw.println("\n\n---Press anything to continue---");
//                                reader.readLine();
                            } else {
                            	while ((in = is.readLine()) != null) {
                                    System.out.println("token receive: " + in);
                                    strings.add(in);
                                    System.out.println("tokens size: " + in);
                                    if (strings.size() == 1) {
                                        break;
                                    }
                                }
                            	os.write("Someone is using this account for transaction, please wait");
                                os.newLine();
                                os.flush();
                                MessageQueue.removeQueue(identification);
                                identification.setReadOnly(false);
//                                pw.println("da co nguoi dang nhap truoc ban, vui long cho");
//                                reader.readLine();
                             
                            }
                            break;
                        case "3":
//                        	os.write("3");
//                        	os.newLine();
//                        	os.flush();
                        	int balance;
                        	if (!identification.isReadOnly()) {
                        		System.out.println("alo");
                        		balance = bank.inquiry2(acc_num);
                            }
                        	else {
                        		balance = bank.inquiry1(acc_num);
                        	}
                            String mString2 = "Your current balance is: " + balance;
                            os.write(mString2);
                            os.newLine();
                            os.flush();
//                            pw.println(mString2);
//                            pw.println("\n\n---Press anything to continue---");
//                            reader.readLine();
                            break;
                        case "4":
                            MessageQueue.addMQueue(identification);
                            if (!identification.isReadOnly() ) {
                            	while ((in = is.readLine()) != null) {
                                    System.out.println("token receive: " + in);
                                    strings.add(in);
                                    System.out.println("tokens size: " + in);
                                    if (strings.size() == 2) {
                                        break;
                                    }
                                }
                                int withdrawResult = query.selectByAccNum(acc_num).getBalance();
                                if(!isNumeric(strings.get(1)) || Integer.parseInt(strings.get(1)) < 0) {
                                	os.write("Invalid input!!! You can only input a possitive number!!!");
                                    os.newLine();
                                    os.flush();
                                    MessageQueue.removeQueue(identification);
                                    identification.setReadOnly(false);
                                    break;
                                }
                                if (query.selectByAccNum(acc_num).getBalance() < Integer.parseInt(strings.get(1))) {
//                                    pw.println("You do not have enough money to compelete the transaction!");
                                	os.write("You do not have enough money to compelete the transaction!");
                                    os.newLine();
                                    os.flush();
                                    MessageQueue.removeQueue(identification);
                                    identification.setReadOnly(false);
                                    break;
                                }
                                else {
                                	withdrawResult = bank.transfer(acc_num, strings.get(0), Integer.parseInt(strings.get(1)));
                                }
                                if(withdrawResult < 0) {
                                	
                                	os.write("Account Number is invalid!!");
                                    os.newLine();
                                    os.flush();
                                    MessageQueue.removeQueue(identification);
                                    identification.setReadOnly(false);
                                    break;
                                }
                                String mString1 = "Success!! Your balance now is: " + withdrawResult;
                                MessageQueue.removeQueue(identification);
                                identification.setReadOnly(false);
                                os.write(mString1);
                                os.newLine();
                                os.flush();
//                                pw.println(mString1);
//                                pw.println("\n\n---Press anything to continue---");
//                                reader.readLine();
                            } else {
                            	while ((in = is.readLine()) != null) {
                                    System.out.println("token receive: " + in);
                                    strings.add(in);
                                    System.out.println("tokens size: " + in);
                                    if (strings.size() == 1) {
                                        break;
                                    }
                                }
                            	os.write("Someone is using this account for transaction, please wait");
                                os.newLine();
                                os.flush();
                                MessageQueue.removeQueue(identification);
                                identification.setReadOnly(false);
//                                pw.println("da co nguoi dang nhap truoc ban, vui long cho");
//                                reader.readLine();
                         
                            }
                            break;
                        case "5":
//                        	os.write("5");
//                            os.newLine();
//                            os.flush();
                   
                            handleLogoff(identification);
                            out = true;
//                            clearScreen(pw);
                            break;
//                        case "1507":
//                            System.out.println("permission:" + identification.isReadOnly());
//                            pw.println("permission:" + identification.isReadOnly());
//                            reader.readLine();
                            //break;
                        default:
                        	os.write("111");
                            os.newLine();
                            os.flush();
//                            reader.readLine();
                            break;
                    }
                }
            } else {
                String msg = "Login failed! Not valid username or password!";
                
                os.write(msg);
                os.newLine();
                os.flush();
//                pw.println(msg);
//                pw.println("\n\n---Press anything to continue---");
//                reader.read();
                return out;
            }
        }
        return out;
    }

    private boolean handleRegister(List<String> tokens) throws SQLException, IOException {
        boolean done = false;
        boolean done2 = false;
        if (tokens.size() == 2) {
            String username = tokens.get(0);
            String password = tokens.get(1);
//            pw.println("Dang dang ki xin doi....");
            try {
                done = new Query(1).register(username, password);
                done2 = new Query(2).register(username, password);
                if (done && done2) {
                	  String acc_num = query.isInDB(tokens.get(0), tokens.get(1));
                	  String a = "Success!! Your account number is: " + acc_num;
                	  os.write(a);
                	  os.newLine();
                	  os.flush();
//                    pw.println("Register successful!");
                    return true;
                }
            } catch (SQLException e) {
//                pw.println("Register Failed! Your username is being used");
            	os.write("Register Failed! Your username is being used");
            	os.newLine();
          	  	os.flush();
                return false;
            }
        }
        return false;
    }

    private List<String> enterArgs(OutputStream outputStream) throws IOException {
        String msg = "Enter account number and amount respectively: ";
        PrintWriter pw = new PrintWriter(outputStream, true);
        pw.println(msg);
        InputStream inputStream = clientSocket.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String line;
        List<String> strings = new ArrayList<String>();
        while ((line = reader.readLine()) != null) {
            System.out.println("token receive: " + line);
            strings.add(line);
            if (strings.size() == 2) {
                break;
            }
        }
        return strings;
    }

    private List<String> enterAmount(OutputStream outputStream) throws IOException {
        String msg = "Enter amount : ";
        PrintWriter pw = new PrintWriter(outputStream, true);
        pw.println(msg);
        InputStream inputStream = clientSocket.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String line;
        List<String> strings = new ArrayList<String>();
        while ((line = reader.readLine()) != null) {
            System.out.println("token receive: " + line);
            strings.add(line);
            if (strings.size() == 1) {
                break;
            }
        }
        return strings;
    }

//    private static void clearScreen(PrintWriter pw) {
//        pw.print("\033[H\033[2J");
//        pw.flush();
//    }
    
    public static boolean isNumeric(String strNum) {
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException | NullPointerException nfe) {
            return false;
        }
        return true;
    }

    private boolean handleDeleteAccount(List<String> tokens) throws SQLException, IOException {
        boolean done = false;
        boolean done2 = false;
        if (tokens.size() == 2) {
            String username = tokens.get(0);
            String password = tokens.get(1);
            String acc_num = query.isInDB(username, password);
            if (acc_num != null) {
                try {
                    done = new Query(1).delete(username);
                    done2 = new Query(2).delete(username);
                    if (done && done2) {
                
                        return true;
                    }
                } catch (SQLException e) {
                    System.out.println(e);
                    throw e;
                }
            } else {
            
                return false;
            }
        }
        return false;
    }

    private boolean handleLogoff(Identification identification) throws IOException {
        return true;
    }
}
