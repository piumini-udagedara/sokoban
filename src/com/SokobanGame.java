package com;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class SokobanGame extends JPanel {
	
	ImageIcon bg = new ImageIcon("src/image/scree.jpg");
	
	public SokobanGame() {
		setLayout(null);
		addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {
				
				
			}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
				Sokoban.frame.remove(SokobanGame.this);
				Board board = new Board();
				Sokoban.frame.add(board);
				board.requestFocus();
				Sokoban.frame.validate();
				
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	
	
	
	
	/** 
	 * @param g
	 */
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(bg.getImage(),0,0, this);
	}
}
