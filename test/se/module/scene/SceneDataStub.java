package se.module.scene;


public class SceneDataStub extends SceneData {
	
	private int mapWidth = 5000;
	private int mapHeight = 2000;
	private Player player;
	private int positionx = 0;//offsetX
	private int positiony = 0;//offsetY
	private ScenePanel panel;
	public SceneDataStub(ScenePanel panel) {
		super(panel);
		this.panel = panel;
	}
	
	public void setVirtualCharacterPosition(Point point){
		assert point.getX()<=mapWidth-100 && point.getY()<=mapHeight-100;
		player.setPosition(point);
		
		if(player.getPositionX()>getPanelWidth()/2 && player.getPositionX()<mapWidth-getPanelWidth()/2)
			this.setPositionX(player.getPositionX()-getPanelWidth()/2);
		else if(player.getPositionX()<=getPanelWidth()/2)
			this.setPositionX(0);
		else
			this.setPositionX(mapWidth-getPanelWidth());
		
		if(player.getPositionY()>getPanelHeight()/2 && player.getPositionY()<mapHeight-getPanelHeight()/2)
			this.setPositionY(player.getPositionY()-getPanelHeight()/2);
		else if(player.getPositionY()<=getPanelHeight()/2)
			this.setPositionY(0);
		else
			this.setPositionY(mapHeight-getPanelHeight());
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
	public int getPanelWidth(){
		return panel.getWidth();
	}
	
	@Override
	public int getPanelHeight(){
		return panel.getHeight();
	}
}
