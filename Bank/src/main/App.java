package main;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import gui.GUI;

public class App {

	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket client = new Socket("127.0.0.1", 8888);
		
		GUI gui = new GUI(client);
		GUI.showMain2();
		//gui.exit();
	}
}
