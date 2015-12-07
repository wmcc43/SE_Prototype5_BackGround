package se.module.scene;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.image.BufferStrategy;
import javax.swing.JFrame;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class SceneCanvas extends Canvas implements Runnable{
	private int positionx = 0;
	private int positiony = 0;
	private KeyListener keylistener;
	private JFrame frm;
	private SceneData scenedata;
	private RepaintActionListener repaint;
	private Timer timer;
	private Player player;
	
	public SceneCanvas(JFrame frm){
		super();
		this.frm = frm;
		scenedata = new SceneData(0);
		player = scenedata.getPlayer();
		setRoundBound();
		this.setIgnoreRepaint(true);
		initKeyListener();
		this.addKeyListener(keylistener);
		repaint = new RepaintActionListener(this);
		timer = new Timer(25, repaint);
		timer.start();
	}
	
	@Override
	public void run() {
		frm.setVisible(true);
		this.createBufferStrategy(2);
	}
	
	private void setRoundBound(){
		scenedata.setTopBound(100);
		scenedata.setBottomBound(frm.getHeight()-100);
		scenedata.setLeftBound(100);
		scenedata.setRightBound(frm.getWidth()-100);
	}
	
	private void initKeyListener(){
		keylistener = new KeyAdapter(){
			@Override
			public void keyPressed(KeyEvent e) {
				moveCharacter(e);
				moveMap(e);
			}
		};
	}
	
	private void moveCharacter(KeyEvent e) {
		switch(e.getKeyCode()){
		case(37):
			if(player.getPositionX()>0)
				player.setPositionX(player.getPositionX()-25);
			break;
		case(39):
			if(player.getPositionX()<scenedata.getMapWidth()-100)
				player.setPositionX(player.getPositionX()+25);
			break;
		case(38):
			if(player.getPositionY()>0)
				player.setPositionY(player.getPositionY()-25);
			break;
		case(40):
			if(player.getPositionY()<scenedata.getMapHeight()-100)
				player.setPositionY(player.getPositionY()+25);
			break;
		default:
			break;
		}
	}
	
	private void moveMap(KeyEvent e){
		switch(e.getKeyCode()){
		case(37):
			if(positionx>0){
				if(scenedata.getLeftBound()>player.getPositionX()){
					positionx = positionx-25;
					if(scenedata.getLeftBound()>100){
						scenedata.setLeftBound(scenedata.getLeftBound()-25);
						scenedata.setRightBound(scenedata.getRightBound()-25);
					}
				}
			}
			break;
		case(39):
			if(positionx<scenedata.getMapWidth()-frm.getWidth()){
				if(scenedata.getRightBound()<(player.getPositionX()+100)){
					positionx = positionx+25;
					if(scenedata.getRightBound()<scenedata.getMapWidth()-100){
						scenedata.setRightBound(scenedata.getRightBound()+25);
						scenedata.setLeftBound(scenedata.getLeftBound()+25);;
					}
				}
			}
			break;
		case(38):
			if(positiony>0){
				if(scenedata.getTopBound()>player.getPositionY()){
					positiony = positiony-25;
					if(scenedata.getTopBound()>100){
						scenedata.setTopBound(scenedata.getTopBound()-25);
						scenedata.setBottomBound(scenedata.getBottomBound()-25);
					}
				}
			}
			break;
		case(40):
			if(positiony<scenedata.getMapHeight()-frm.getHeight()){
				if(scenedata.getBottomBound()<(player.getPositionY()+100)){
					positiony = positiony+25;
					if(scenedata.getBottomBound()<scenedata.getMapHeight()-100){
						scenedata.setBottomBound(scenedata.getBottomBound()+25);
						scenedata.setTopBound(scenedata.getTopBound()+25);;
					}
				}
			}
			break;
		case(49):
		case(50):
		case(51):
		case(52):
			scenedata.setMapType(e.getKeyCode()-49);
			break;
		case(81):
			frm.dispatchEvent(new WindowEvent(frm, WindowEvent.WINDOW_CLOSING));
			break;
		default:
			break;
		}
		System.out.println(e.getKeyCode()+"X:"+positionx+"Y:"+positiony);
		repaint();
	}
	
	public void myRepaint(){
		BufferStrategy strategy = this.getBufferStrategy();
		Graphics g = strategy.getDrawGraphics();
		g.setColor(Color.BLACK);
		g.setClip(0, 0, frm.getWidth(), frm.getHeight());
		for(int i=0-positionx, k=0; i<scenedata.getMapWidth()-positionx; i+=100, k++){
			for(int j=0-positiony, l=0; j<scenedata.getMapHeight()-positiony; j+=100, l++){
				g.drawImage(scenedata.getBackImg(scenedata.getBackimg(k, l)), i, j, null);
			}
		}
		Point playerPosition = scenedata.getVirtualCharacterPosition();
		int x, y;
		x = playerPosition.getX();
		y = playerPosition.getY();
		g.drawImage(scenedata.getCharacter(), x-positionx, y-positiony, null);
		strategy.show();
		Toolkit.getDefaultToolkit().sync();
	}
	
	public SceneData getSceneData(){
		return scenedata;
	}
	
	private class RepaintActionListener implements ActionListener {
		SceneCanvas bg;
		public RepaintActionListener(SceneCanvas bg) {
			this.bg = bg;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			bg.myRepaint();
		}
	}
}