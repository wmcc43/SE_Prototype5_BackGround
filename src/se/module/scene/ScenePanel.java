package se.module.scene;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class ScenePanel extends JPanel{
	
	private SceneData scenedata;
	private Player player;
	private CharacterMoveListener KeyListener;
	public ScenePanel() {
		super();
	}
	
	@Override
	public synchronized void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.BLACK);
		g.setClip(0, 0, scenedata.getFrameWidth(), scenedata.getFrameHeight());
		for(int i=0-scenedata.getPositionX(), k=0; i<scenedata.getMapWidth()-scenedata.getPositionX(); i+=100, k++){
			for(int j=0-scenedata.getPositionY(), l=0; j<scenedata.getMapHeight()-scenedata.getPositionY(); j+=100, l++){
				g.drawImage(scenedata.getBackImg(scenedata.getBackimg(k, l)), i, j, null);
			}
		}
		Point playerPosition = scenedata.getVirtualCharacterPosition();
		int x, y;
		x = playerPosition.getX();
		y = playerPosition.getY();
		g.drawImage(scenedata.getCharacter(), x-scenedata.getPositionX(), y-scenedata.getPositionY(), null);
	}
	
	public void setSceneData(SceneData scenedata){
		this.scenedata = scenedata;
		player = scenedata.getPlayer();
		KeyListener = new CharacterMoveListener(scenedata);
		JFrame frm = (JFrame)SwingUtilities.getAncestorOfClass(JFrame.class, this);
		frm.addKeyListener(KeyListener);
	}

	public SceneData getSceneData(){
		return scenedata;
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
