
public class Rectangle extends gameLoop{
	
	private int a;
	private int b;
	private int l1;
	private int l2;	

	public Rectangle(int a, int b, int l1, int l2) {
		this.a = a;
		this.b = b;
		this.l1 = l1;
		this.l2 = l2;
	}
	
	public int getX() {
		return a;		
	}
	
	public int getY() {
		return b;		
	}
	
	public int getL1() {
		return l1;		
	}
	
	public int getL2() {
		return l2;		
	}
	
	public boolean check (int x,int y) {
		if(a>=x && a<=x+SIZE && b>=y && b<=y+SIZE
		|| a+l1>=x && a+l1<=x+SIZE && b>=y && b<=y+SIZE
		|| a>=x && a<=x+SIZE && b+l2>=y && b+l2<=y+SIZE
		|| a+l1>=x && a+l1<=x+SIZE && b+l2>=y && b+l2<=y+SIZE) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean isIntersect(int x, int y) {
		if(check(x,y)==true){
			return true;
		}
		else {
			return false;
		}
	}
}
