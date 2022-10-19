package com;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Area extends Actor{
	
	public Area(int x, int y) {
		super(x, y);
		init();
	}

	@Override
	public void init() {
		ImageIcon icon = new ImageIcon("src/image/area.png");
		Image image = icon.getImage();
		setImage(image);
	}
}
