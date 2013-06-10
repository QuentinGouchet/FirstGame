import java.applet.*;
import java.awt.*;
import java.util.ArrayList;

public class Game extends gameLoop {
		
		public void createRectangles () {
			for(int i=0;i<((int)(Math.random()*1000))%30+10;i++) {
				rects.add(new Rectangle(((int)(Math.random()*1000))%750+50,((int)(Math.random()*1000))%550+50,((int)(Math.random()*1000))%20+10,((int)(Math.random()*1000))%30+10));
			}
		}
		
		public void init () {
			createRectangles();
			setSize(800,600);
			Thread th = new Thread(this);
			th.start();
			offscreen = createImage(800,600);
			d = offscreen.getGraphics();
			addKeyListener(this);
		}

		public void paint (Graphics g) {
			d.setColor(Color.BLACK);
			d.clearRect(0,0,800,600);
			d.fillRect(0, 0, 800, 600);
			d.setColor(Color.RED);
			Font NewRoman1 = new Font ("NewRoman1", Font.BOLD, 30);
			d.setFont(NewRoman1);
			d.drawString("There are " + rects.size() + " enemies left", 10, 50);
			
			 String S = (time/12000) + ":" + (time/2000)%6 + (time/200)%10 +":" + (time/20)%10 ;
			 d.drawString(S, 1, 590);
			
				ball = d.create();
				ball.setColor(Color.WHITE);
				ball.drawRect(x, y, SIZE, SIZE);
				ball.fillRect(x, y, SIZE, SIZE);
				
				face = d.create();
				face.setColor(Color.BLACK);
				face.fillRect(x+SIZE/3,y+SIZE/3,SIZE/10,SIZE/10);
				face.fillRect(x+2*SIZE/3,y+SIZE/3,SIZE/10,SIZE/10);
				face.fillRect(x+SIZE/3,y+4*SIZE/5,SIZE/5*2,SIZE/15);
				face.fillRect(x+SIZE/3,y+4*SIZE/5-5,SIZE/15,5);
				face.fillRect(x+SIZE/3+SIZE/5*2-SIZE/15,y+4*SIZE/5-5,SIZE/15,5);
				
				rec = d.create();
				rec.setColor(Color.RED);
				for (Rectangle r : rects) {
					rec.drawRect(r.getX(), r.getY(), r.getL1(), r.getL2());
					rec.fillRect(r.getX(), r.getY(), r.getL1(), r.getL2());
				}
				
				if(rects.isEmpty()==true) {
					Font NewRoman = new Font ("NewRoman", Font.BOLD, 48);
					rec.setFont(NewRoman);
					rec.drawString("YOU WON !!!",400,300);
				}
				
			g.drawImage(offscreen,0,0,this);		
		}
		
		public void update (Graphics g) {
			paint(g);
		}
}
