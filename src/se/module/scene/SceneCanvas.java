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
	
	public SceneCanvas(JFrame frm){
		super();
		this.frm = frm;
		scenedata = new SceneData(6);
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
	
	private void initKeyListener(){
		keylistener = new KeyAdapter(){
			@Override
			public void keyPressed(KeyEvent e) {
				move(e);
			}
		};
	}
	
	private void move(KeyEvent e){
		switch(e.getKeyCode()){
		case(37):
			if(positionx<2500)
				positionx = positionx+25;
			break;
		case(39):
			if(positionx>-2500+frm.getWidth())
				positionx = positionx-25;
			break;
		case(38):
			if(positiony<1000)
				positiony = positiony+25;
			break;
		case(40):
			if(positiony>-1000+frm.getHeight())
				positiony = positiony-25;
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
		//System.out.println(e.getKeyCode());
		repaint();
	}
	
	public void myRepaint(){
		BufferStrategy strategy = this.getBufferStrategy();
		Graphics g = strategy.getDrawGraphics();
		g.setColor(Color.BLACK);
		g.setClip(0, 0, frm.getWidth(), frm.getHeight());
		for(int i=-2500+positionx, k=0; i<2500+positionx; i+=100, k++){
			for(int j=-1000+positiony, l=0; j<1000+positiony; j+=100, l++){
				g.drawImage(scenedata.getBackImg(scenedata.getBackimg(k, l)), i, j, null);
			}
		}
		g.drawImage(scenedata.getCharacter(), 200, 100, null);
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