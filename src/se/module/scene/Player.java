package se.module.scene;

public class Player {
	Point position;
	
	public Player(){
		
	}
	
	public void setPosition(Point p){
		position = p;
	}
	
	public void setPosition(int x, int y){
		position = new Point(x, y);
	}
	
	public void setPositionX(int x){
		position.setX(x);
	}
	
	public void setPositionY(int y){
		position.setY(y);
	}
	
	public Point getPostion(){
		return position;
	}
	
	public int getPositionX(){
		return position.getX();
	}
	
	public int getPositionY(){
		return position.getY();
	}
}
