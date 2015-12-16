package se.module.scene;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class SceneCanvas extends Canvas implements Runnable{
	private SceneData scenedata;
	
	public SceneCanvas(){
		super();
		this.setIgnoreRepaint(true);
	}
	
	public synchronized void myRepaint(){
		BufferStrategy strategy = this.getBufferStrategy();
		Graphics g = strategy.getDrawGraphics();
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
		strategy.show();
		Toolkit.getDefaultToolkit().sync();
	}
	
	public SceneData getSceneData(){
		return scenedata;
	}
	
	@Override
	public void run() {
		JFrame frm = (JFrame)SwingUtilities.getAncestorOfClass(JFrame.class, this);
		frm.setVisible(true);
		this.createBufferStrategy(2);
	}
	
	public void setSceneData(SceneData scenedata){
		this.scenedata = scenedata;
	}
}