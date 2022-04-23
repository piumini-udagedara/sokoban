package com;

import java.awt.Image;

public class Actor {
	
	private final int SPACE = 25;
	
	private int x;
	private int y;
	private Image image;
	
	public Actor(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	
	/** 
	 * @return Image
	 */
	public Image getImage() {
		return image;
	}
	
	
	/** 
	 * @param img
	 */
	public void setImage(Image img) {
		image = img;
	}
	
	
	/** 
	 * @return int
	 */
	public int x() {
		return x;
	}
	
	
	/** 
	 * @return int
	 */
	public int y() {
		return y;
	}
	
	
	/** 
	 * @param x
	 */
	public void setX(int x) {
		this.x = x;
	}
	
	
	/** 
	 * @param y
	 */
	public void setY(int y) {
		this.y = y;
	}
	
	
	/** 
	 * @param actor
	 * @return boolean
	 */
	public boolean isLeftCollision(Actor actor) {
		return x() - SPACE == actor.x && y() == actor.y();
	}
	
	
	/** 
	 * @param actor
	 * @return boolean
	 */
	public boolean isRightCollision(Actor actor) {
		return x() + SPACE == actor.x && y() == actor.y();
	}
	
	
	/** 
	 * @param actor
	 * @return boolean
	 */
	public boolean isTopCollision(Actor actor) {
		return x() == actor.x && y() - SPACE == actor.y();
	}
	
	
	/** 
	 * @param actor
	 * @return boolean
	 */
	public boolean isBottomCollision(Actor actor) {
		return x() == actor.x && y() + SPACE == actor.y();
	}
	
	public void init() {
		setImage(null);
	}

}
