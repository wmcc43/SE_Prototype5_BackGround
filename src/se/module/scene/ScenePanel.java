package se.module.scene;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ScenePanel extends JPanel{
	
	private SceneData scenedata;
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
	}

	public SceneData getSceneData(){
		return scenedata;
	}
}
