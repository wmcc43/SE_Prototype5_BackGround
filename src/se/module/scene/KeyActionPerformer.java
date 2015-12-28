package se.module.scene;

public class KeyActionPerformer {
	
	private SceneData scenedata;
	private Player player;
	private CharacterMoveListener KeyListener;
	
	public KeyActionPerformer(SceneData scenedata, CharacterMoveListener KeyListener) {
		this.scenedata = scenedata;
		this.player = scenedata.getPlayer();
		this.KeyListener = KeyListener;
	}
	
	public void moveCharacter() {
		if(KeyListener.left){
			if(player.getPositionX()>0)
				player.setPositionX(player.getPositionX()-25);
			if(scenedata.getPositionX()>0){
				if(scenedata.getLeftBound()>player.getPositionX()){
					scenedata.setPositionX(scenedata.getPositionX()-25);
					if(scenedata.getLeftBound()>100){
						scenedata.setLeftBound(scenedata.getLeftBound()-25);
						scenedata.setRightBound(scenedata.getRightBound()-25);
					}
				}
			}
		}
		else if(KeyListener.right){
			if(player.getPositionX()<scenedata.getMapWidth()-100)
				player.setPositionX(player.getPositionX()+25);
			if(scenedata.getPositionX()<scenedata.getMapWidth()-scenedata.getFrameWidth()){
				if(scenedata.getRightBound()<(player.getPositionX()+100)){
					scenedata.setPositionX(scenedata.getPositionX()+25);
					if(scenedata.getRightBound()<scenedata.getMapWidth()-100){
						scenedata.setRightBound(scenedata.getRightBound()+25);
						scenedata.setLeftBound(scenedata.getLeftBound()+25);;
					}
				}
			}
		}
		else if(KeyListener.up){
			if(player.getPositionY()>0)
				player.setPositionY(player.getPositionY()-25);
			if(scenedata.getPositionY()>0){
				if(scenedata.getTopBound()>player.getPositionY()){
					scenedata.setPositionY(scenedata.getPositionY()-25);
					if(scenedata.getTopBound()>100){
						scenedata.setTopBound(scenedata.getTopBound()-25);
						scenedata.setBottomBound(scenedata.getBottomBound()-25);
					}
				}
			}
		}
		else if(KeyListener.down){
			if(player.getPositionY()<scenedata.getMapHeight()-100)
				player.setPositionY(player.getPositionY()+25);
			if(scenedata.getPositionY()<scenedata.getMapHeight()-scenedata.getFrameHeight()){
				if(scenedata.getBottomBound()<(player.getPositionY()+100)){
					scenedata.setPositionY(scenedata.getPositionY()+25);
					if(scenedata.getBottomBound()<scenedata.getMapHeight()-100){
						scenedata.setBottomBound(scenedata.getBottomBound()+25);
						scenedata.setTopBound(scenedata.getTopBound()+25);;
					}
				}
			}
		}
	}
	
	public void placeBomb(){
		if(KeyListener.space){
			
		}
	}
}
