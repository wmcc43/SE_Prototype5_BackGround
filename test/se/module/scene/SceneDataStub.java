package se.module.scene;

import javax.swing.JFrame;

public class SceneDataStub extends SceneData {
	
	private int mapWidth = 5000;
	private int mapHeight = 2000;
	private Player player;
	private int positionx = 0;//offsetX
	private int positiony = 0;//offsetY
	private int frameWidth = 1000;
	private int frameHeight = 600;
	
	public SceneDataStub() {
		super(new JFrame());
	}
	
	public void setVirtualCharacterPosition(Point point){
		assert point.getX()<=mapWidth-100 && point.getY()<=mapHeight-100;
		player.setPosition(point);
		
		if(player.getPositionX()>500 && player.getPositionX()<4500)
			this.setPositionX(player.getPositionX()-500);
		else if(player.getPositionX()<=500)
			this.setPositionX(0);
		else
			this.setPositionX(4000);
		
		if(player.getPositionY()>300 && player.getPositionY()<1700)
			this.setPositionY(player.getPositionY()-300);
		else if(player.getPositionY()<=300)
			this.setPositionY(0);
		else
			this.setPositionY(1400);
	}
	
	@Override
	public void setPlayer(Player player){
		this.player = player;
	}
	
	@Override
	public void setPositionX(int x){
		this.positionx = x;
	}
	
	@Override
	public int getPositionX(){
		return positionx;
	}
	
	@Override
	public void setPositionY(int y){
		this.positiony = y;
	}
	
	@Override
	public int getPositionY(){
		return positiony;
	}
	
	@Override
	public int getFrameWidth(){
		return frameWidth;
	}
	
	@Override
	public int getFrameHeight(){
		return frameHeight;
	}
}
