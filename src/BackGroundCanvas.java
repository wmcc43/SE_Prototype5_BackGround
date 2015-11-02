import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.image.BufferStrategy;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class BackGroundCanvas extends Canvas{
	int mapType = 3;
	int mapWidth = 5000;
	int mapHeight = 2000;
	int positionx = 0;
	int positiony = 0;
	int mapbit[][] = new int[50][20];
	Image backimg[] = new Image[5];
	Image character;
	KeyListener keylistener;
	BackGroundCanvas self;
	Graphics g;
	JFrame frm;
	//boolean repaintInProgress = false;
	
	public BackGroundCanvas(JFrame frm){
		super();
		this.frm = frm;
		this.setIgnoreRepaint(true);
		self = this;
		LoadImg();
		initMap(mapType);
		initKeyListener();
		this.addKeyListener(keylistener);
		RepaintActionListener repaint = new RepaintActionListener(this);
		new Timer(16, repaint).start();
	}
	
	private void LoadImg(){
		try{
			backimg[0] = ImageIO.read(new File("./imgs/mapbackgrounds/ice.png"));
			backimg[1] = ImageIO.read(new File("./imgs/mapbackgrounds/cake.png"));
			backimg[2] = ImageIO.read(new File("./imgs/mapbackgrounds/desert.png"));
			backimg[3] = ImageIO.read(new File("./imgs/mapbackgrounds/lego.png"));
			backimg[4] = ImageIO.read(new File("./imgs/mapbackgrounds/rock.png"));
			character = ImageIO.read(new File("./imgs/character/053.png"));
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	private void initKeyListener(){
		keylistener = new KeyAdapter(){
			@Override
			public void keyPressed(KeyEvent e) {
				move(e);
			}
		};
	}
	
	private void initMap(int mapType){
		for(int i=0; i<50; i++){
			for(int j=0; j<20; j++){
				if(i%2==1){
					if(j%2==1){
						mapbit[i][j] = 4;
					}
					else{
						mapbit[i][j] = mapType;
					}
				}
				else{
					mapbit[i][j] = mapType;
				}
			}
		}
	}
	
	private void move(KeyEvent e){
		switch(e.getKeyCode()){
		case(37):
			if(positionx<2500)
				positionx = positionx+25;
			break;
		case(39):
			if(positionx>-2000)
				positionx = positionx-25;
			break;
		case(38):
			if(positiony<1000)
				positiony = positiony+25;
			break;
		case(40):
			if(positiony>-700)
				positiony = positiony-25;
			break;
		case(49):
		case(50):
		case(51):
		case(52):
			mapType = e.getKeyCode()-49;
			break;
		case(81):
			frm.dispatchEvent(new WindowEvent(frm, WindowEvent.WINDOW_CLOSING));
			break;
		default:
			break;
		}
		//System.out.println(e.getKeyCode());
		initMap(mapType);
		repaint();
	}
	
	public void myRepaint(){
		/*if(repaintInProgress)
			return;
		repaintInProgress = true;*/
		BufferStrategy strategy = this.getBufferStrategy();
		Graphics g = strategy.getDrawGraphics();
		g.setColor(Color.BLACK);
		g.setClip(0, 0, 500, 300);
		for(int i=-2500+positionx, k=0; i<2500+positionx; i+=100, k++){
			for(int j=-1000+positiony, l=0; j<1000+positiony; j+=100, l++){
				g.drawImage(backimg[mapbit[k][l]], i, j, null);
			}
		}
		g.drawImage(character, 200, 100, null);
		strategy.show();
		Toolkit.getDefaultToolkit().sync();
		//repaintInProgress = false;
	}
	
	private class RepaintActionListener implements ActionListener {
		BackGroundCanvas bg;
		public RepaintActionListener(BackGroundCanvas bg) {
			this.bg = bg;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			bg.myRepaint();
		}
	}
}
