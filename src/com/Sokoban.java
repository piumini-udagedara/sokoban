package com;

import javax.swing.JFrame;

public class Sokoban {

	public static JFrame frame;

	public Sokoban() {
		initUI();
	}

	private void initUI() {
		frame = new JFrame();

		SokobanGame sokobanGame = new SokobanGame();
		frame.add(sokobanGame);
		frame.setTitle("Sokoban");

		frame.setSize(900,650);
		frame.setResizable(false);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);


	}
	
	/** 
	 * @param args
	 */
	public static void main(String[] args) {
        Sokoban sokobangame = new Sokoban();
    }
}
