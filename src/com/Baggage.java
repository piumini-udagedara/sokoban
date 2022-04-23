package com;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Baggage extends Actor{
	
	public Baggage(int x, int y) {
		super(x, y);
		init();
	}
	
	
	/** 
	 * @param x
	 * @param y
	 */
	public void move(int x, int y) {
		int dx = x() + x;
		int dy = y() + y;
		
		setX(dx);
		setY(dy);
	}
	
	@Override
	public void init() {
		ImageIcon iicon = new ImageIcon("src/image/baggage.png");
		Image image = iicon.getImage();
		setImage(image);
	}

}
