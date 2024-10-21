package com;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.JPanel;

public class Board extends JPanel{
	
	private final int OFFSET = 10;
	private final int SPACE = 25;
	private final int LEFT_COLLISION = 1;
	private final int RIGHT_COLLISION = 2;
	private final int TOP_COLLISION = 3;
	private final int BOTTOM_COLLISION = 4;

	private static enum STATE{ MENU, GAME };
	private static STATE currState = STATE.GAME;
	private int level = 1;
	private String label =Map.get(level);
	private int[] completeLevel = new int[11];
	
	private ArrayList<Wall> walls;
	private ArrayList<Baggage> baggages;
	private ArrayList<Area> areas;
	
	private Player soko;
	private int w = 0;
	private int h = 0;
	private int count = 0;
	
	
	private boolean isCompleted = false;
	
	public Board() {
		initBoard();
	}
	
	private void initBoard() {
		Adapter adapter=new Adapter();
		addKeyListener(adapter);
		addMouseListener(mouseListener);
		addMouseMotionListener(mouseMotionListener);
		setFocusable(true);
		initWorld();
	}
	
	
	/** 
	 * @return int
	 */
	public int getBoardWidth() {
		return this.w;
	}
	
	
	/** 
	 * @return int
	 */
	public int getBoardHeight() {
		return this.h;
	}
	
	private void initWorld() {
		walls = new ArrayList<>();
		baggages = new ArrayList<>();
		areas = new ArrayList<>();
		
		int x = OFFSET;
		int y = OFFSET;
		
		Wall wall;
		Baggage b;
		Area a;
//------------------------------------map design--------------------------------------------------
		for(int i = 0; i < label.length(); i++) {
			char item = label.charAt(i);
			switch (item) {
				case '\n':
					y += SPACE;
					if(this.w < x) {
						this.w = x;
					}
					x = OFFSET;
					break;
				case 'X':
					wall = new Wall(x, y);
					walls.add(wall);
					x += SPACE;
					break;
				case '*':
					b = new Baggage(x, y);
					baggages.add(b);
					x += SPACE;
					break;
				case '.':
					a = new Area(x, y);
					areas.add(a);
					x += SPACE;
					break;
				case '@':
					soko = new Player(x, y);
					x += SPACE;
					break;
				case ' ':
					x += SPACE;
					break;
				default:
					break;
			}
			h = y;
		}
	}
	
	
	/** 
	 * @param g
	 */
	private void buildWorld(Graphics g) {
		g.setColor(new Color(210,249,146));
		g.fillRect(0, 0, 600,650);
		
		ArrayList<Actor> world = new ArrayList<>();
		
		world.addAll(walls);
		world.addAll(areas);
		world.addAll(baggages);
		world.add(soko);
		
		for(int i = 0; i < world.size(); i++) {
			Actor item = world.get(i);
			
			if(item instanceof Player || item instanceof Baggage) {
				g.drawImage(item.getImage(), item.x() + 2, item.y() + 2, this);
			}else {
				g.drawImage(item.getImage(), item.x(), item.y(), this);
			}
			
			if(isCompleted) {
				levelUp();
			}
		}
		
		g.setColor(Color.WHITE);
		g.fillRect(570, 0,600, 650);
		
		g.setFont(new Font("Arial", Font.BOLD, 20));
		g.setColor(Color.BLACK);
		g.drawString("Level: " + this.level, 700, 100);
		

	}
	
	private MouseMotionListener mouseMotionListener = new MouseMotionListener() {
		public void mouseMoved(MouseEvent e) {
			int X = e.getX();
			int Y = e.getY();
			repaint();
		}
		public void mouseDragged(MouseEvent e) {}
	};
	
	
	/** 
	 * @param g
	 */
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		if(currState == STATE.MENU) {
			g.setColor(Color.RED);
			g.fillRect(0, 0, this.getWidth(), this.getHeight());
		} else if(currState == STATE.GAME) {
			buildWorld(g);
		}
	}
	
	private MouseListener mouseListener = new MouseListener() {
		public void mouseReleased(MouseEvent arg0) {}
		public void mousePressed(MouseEvent arg0) {}
		public void mouseExited(MouseEvent arg0) {}
		public void mouseEntered(MouseEvent arg0) {}
		public void mouseClicked(MouseEvent arg0) {}
	};
	//----------------------------------------------keyPressed-------------------------------------------------------
	 class Adapter extends KeyAdapter{
		
		@Override
		public void keyPressed(KeyEvent e) {
			
			if(isCompleted) {
				return;
			}
			
			int key = e.getKeyCode();
			
			switch (key) {
				case KeyEvent.VK_LEFT:
					if(checkWallCollision(soko, LEFT_COLLISION)) {
						return;
					}
					if(checkBagCollision(LEFT_COLLISION)) {
						return;
					}
					soko.init("left");
					soko.move(-SPACE, 0);
					break;
				case KeyEvent.VK_RIGHT:
					if(checkWallCollision(soko, RIGHT_COLLISION)) {
						return;
					}
					if(checkBagCollision(RIGHT_COLLISION)) {
						return;
					}
					soko.init("right");
					soko.move(SPACE, 0);
					break;
				case KeyEvent.VK_UP:
					if(checkWallCollision(soko, TOP_COLLISION)) {
						return;
					}
					if(checkBagCollision(TOP_COLLISION)) {
						return;
					}
					soko.init("top");
					soko.move(0, -SPACE);
					break;
				case KeyEvent.VK_DOWN:
					if(checkWallCollision(soko, BOTTOM_COLLISION)) {
						return;
					}
					if(checkBagCollision(BOTTOM_COLLISION)) {
						return;
					}
					soko.init("down");
					soko.move(0, SPACE);
					break;
				case KeyEvent.VK_R:
					restartLevel();
					break;
				case KeyEvent.VK_L:
					levelUp();
					break;
				default:
					break;
			}
			repaint();
		}
	}
	
	
	/** 
	 * @param actor
	 * @param type
	 * @return boolean
	 */
	private boolean checkWallCollision(Actor actor, int type) {
		switch (type) {
		case LEFT_COLLISION:
			for (int i = 0; i < walls.size(); i++) {
				Wall wall = walls.get(i);
				if(actor.isLeftCollision(wall)) {
					return true;
				}
			}
			return false;
		case RIGHT_COLLISION:
			for (int i = 0; i < walls.size(); i++) {
				Wall wall = walls.get(i);
				if(actor.isRightCollision(wall)) {
					return true;
				}
			}
			return false;
		case TOP_COLLISION:
			for (int i = 0; i < walls.size(); i++) {
				Wall wall = walls.get(i);
				if(actor.isTopCollision(wall)) {
					return true;
				}
			}
			return false;
		case BOTTOM_COLLISION:
			for (int i = 0; i < walls.size(); i++) {
				Wall wall = walls.get(i);
				if(actor.isBottomCollision(wall)) {
					return true;
				}
			}
			return false;
		
		default:
			break;
		}
		return false;
	}
	
	
	/** 
	 * @param type
	 * @return boolean
	 */
	private boolean checkBagCollision(int type) {
		switch (type) {
		case LEFT_COLLISION:
			for(int i = 0; i < baggages.size(); i++) {
				Baggage bag = baggages.get(i);
				if(soko.isLeftCollision(bag)) {
					for(int j = 0; j < baggages.size(); j++) {
						Baggage item = baggages.get(j);
						if(!bag.equals(item)) {
							if(bag.isLeftCollision(item)) {
								return true;
							}
						}
						if(checkWallCollision(bag, LEFT_COLLISION)) {
							return true;
						}
					}
					bag.move(-SPACE, 0);
					isCompleted();
				}
			}
			return false;
		case RIGHT_COLLISION:
			for(int i = 0; i < baggages.size(); i++) {
				Baggage bag = baggages.get(i);
				if(soko.isRightCollision(bag)) {
					for(int j = 0; j < baggages.size(); j++) {
						Baggage item = baggages.get(j);
						if(!bag.equals(item)) {
							if(bag.isRightCollision(item)) {
								return true;
							}
						}
						if(checkWallCollision(bag, RIGHT_COLLISION)) {
							return true;
						}
					}
					bag.move(SPACE, 0);
					isCompleted();
				}
			}
			return false;
		case TOP_COLLISION:
			for(int i = 0; i < baggages.size(); i++) {
				Baggage bag = baggages.get(i);
				if(soko.isTopCollision(bag)) {
					for(int j = 0; j < baggages.size(); j++) {
						Baggage item = baggages.get(j);
						if(!bag.equals(item)) {
							if(bag.isTopCollision(item)) {
								return true;
							}
						}
						if(checkWallCollision(bag, TOP_COLLISION)) {
							return true;
						}
					}
					bag.move(0, -SPACE);
					isCompleted();
				}
			}
			return false;
		case BOTTOM_COLLISION:
			for(int i = 0; i < baggages.size(); i++) {
				Baggage bag = baggages.get(i);
				if(soko.isBottomCollision(bag)) {
					for(int j = 0; j < baggages.size(); j++) {
						Baggage item = baggages.get(j);
						if(!bag.equals(item)) {
							if(bag.isBottomCollision(item)) {
								return true;
							}
						}
						if(checkWallCollision(bag, BOTTOM_COLLISION)) {
							return true;
						}
					}
					bag.move(0, SPACE);
					isCompleted();
				}
			}
			return false;

		default:
			break;
		}
		return false;
	}
	
	public void isCompleted() {
		int nOfBags = baggages.size();
		int finishedBags = 0;
		
		for(int i = 0; i < nOfBags; i++) {
			Baggage bag = baggages.get(i);
			for(int j = 0; j < nOfBags; j++) {
				Area area = areas.get(j);
				if(bag.x() == area.x() && bag.y() == area.y()) {
					finishedBags += 1;
				}
			}
		}
		
		if(finishedBags == nOfBags) {
			isCompleted = true;
			repaint();
		}
	}
	
	public void restartLevel() {
		areas.clear();
		baggages.clear();
		walls.clear();
		
		initWorld();
		
		if(isCompleted) {
			isCompleted = false;
		}
	}
	
	public void levelUp() {
		areas.clear();
		baggages.clear();
		walls.clear();
		
		int tempLevel = level;
		
		count++;
		completeLevel[--tempLevel] = 1;
		
		if(count != 10) {
			if(completeLevel[++tempLevel] == 0) {
				if(level > 9) {
					level = 1;
					label = Map.get(level);
				} else {
					label = Map.get(++level);
				}
			} else {
				level += 2;
				label = Map.get(level);
			}
			initWorld();
		} else {
			System.exit(0);
		}
		
		if(isCompleted) {
			isCompleted = false;
		}
	}
}
