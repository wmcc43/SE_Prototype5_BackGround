package se.module.scene;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class ScenePanel extends JPanel{
	
	private SceneData scenedata;
	private CharacterMoveListener KeyListener;
	private KeyActionPerformer performer;	
	
	public ScenePanel() {
		super();
	}
	
	@Override
	public synchronized void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.BLACK);
		g.setClip(0, 0, this.getWidth(), this.getHeight());
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
		KeyListener = new CharacterMoveListener(scenedata);
		JFrame frm = (JFrame)SwingUtilities.getAncestorOfClass(JFrame.class, this);
		frm.addKeyListener(KeyListener);
		performer = new KeyActionPerformer(scenedata, KeyListener);
	}

	public SceneData getSceneData(){
		return scenedata;
	}
	
	public void moveCharacter() {
		performer.moveCharacter();
	}
	
	public void placeBomb(){
		performer.placeBomb();
	}
}
