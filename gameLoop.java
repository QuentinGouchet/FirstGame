import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class gameLoop extends Applet implements Runnable, KeyListener {
	
	public ArrayList<Rectangle> rects = new ArrayList<>();	
	
	public static int SIZE = 30;
	public static int time = 0;

	public int x,y;
	public static int speed = 5;
	public Image offscreen;
	public Graphics d, ball, rec, face;
	public boolean up, down, left, right;
	
	public void run() {		
		x = 1;
		y = 290;
		
		while(!rects.isEmpty()) {
			time++;
			for(Rectangle r : rects) {
				if(r.isIntersect(x, y)) {
					rects.remove(r);
					d.setColor(Color.RED);
					d.drawString("MIAM !!!",x-10,y-10);
					SIZE += 5;
					break;
				}
			}
			if(x>=800-SIZE){
				if(left==true) {
					x--;
				}
				if(up==true && y<=578) {
					y++;
				}
				if(down==true && y>=0) {
					y--;
				}
			}
			else if(x<=0){
				if(right==true) {
					x++;
				}
				if(up==true && y<=578) {
					y++;
				}
				if(down==true && y>=0) {
					y--;
				}				
			}
			else if(y<=0){
				if(right==true) {
					x++;
				}
				if(left==true) {
					x--;
				}
				if(up==true) {
					y++;
				}				
			}
			else if(y>=600-SIZE){
				if(right==true) {
					x++;
				}
				if(left==true) {
					x--;
				}
				if(down==true) {
					y--;
				}				
			}
			else {
				if(right==true) {
					x++;
				}
				if(left==true) {
					x--;
				}
				if(down==true) {
					y--;
				}
				if(up == true) {
					y++;
				}				
			}
			
			repaint();
			
			try {
				Thread.sleep(speed);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}		
	}
	
	public void keyPressed(KeyEvent e) {
		//System.out.println(e.getKeyCode());
		if(e.getKeyCode() == 37) {
			left = true;
		}
		if(e.getKeyCode() == 39) {
			right = true;
		}
		if(e.getKeyCode() == 38) {
			down = true;
		}
		if(e.getKeyCode() == 40) {
			up = true;
		}
		if(e.getKeyCode() == 521) {
			SIZE += 5;
		}
		if(e.getKeyCode() == 83) {
			if(speed>1)
				speed--;
		}
	}

	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == 37) {
			left = false;
		}
		if(e.getKeyCode() == 39) {
			right = false;
		}
		if(e.getKeyCode() == 38) {
			down = false;
		}
		if(e.getKeyCode() == 40) {
			up = false;
		}
	}
	
	public void keyTyped(KeyEvent e) {		
	}
}
