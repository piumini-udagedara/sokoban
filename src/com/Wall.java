package com;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Wall extends Actor{
	
	
	public Wall(int x, int y) {
		super(x, y);
		init();
	}

	
	@Override
	public void init() {
		ImageIcon icon = new ImageIcon("src/image/wall.png");
		Image image = icon.getImage();
		setImage(image);
		
	}

}
