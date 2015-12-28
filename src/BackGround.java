import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Time;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

import se.module.scene.CharacterMoveListener;
import se.module.scene.RePaintPanelActionListener;
import se.module.scene.SceneData;
import se.module.scene.ScenePanel;

public class BackGround{
	
	public static void main(String[] args){
		JFrame frm = new JFrame();
		//SceneCanvas sceneCanvas;
		frm.setUndecorated(true);
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		frm.setBounds(100, 100, 1000, 600);
		Container cp = frm.getContentPane();
		frm.setVisible(true);
		//sceneCanvas = new SceneCanvas();
		SceneData scenedata = new SceneData(frm);
		ScenePanel scenepanel = new ScenePanel();
		scenepanel.setSceneData(scenedata);
		frm.addKeyListener(new CharacterMoveListener(scenedata));
		scenepanel.setBounds(0, 0, frm.getWidth(), frm.getHeight());
		//sceneCanvas.setSceneData(scenedata);
		//sceneCanvas.addKeyListener(new CharacterMoveListener(scenedata));
		//JPanel panel = new JPanel();
		//panel.setBounds(0, 0, frm.getWidth()-200, frm.getHeight());
		//panel.setLayout(new BorderLayout());
		//sceneCanvas.setBounds(0, 0, frm.getWidth()-200, frm.getHeight());
		cp.setLayout(null);
		//panel.add(sceneCanvas, BorderLayout.CENTER);
		cp.add(scenepanel);
		
		//Thread t = new Thread(scenepanel);
		//t.start();
		//RePaintActionListener repaint = new RePaintActionListener(sceneCanvas);
		//Timer timer = new Timer(25, repaint);
		//timer.start();
		
		RePaintPanelActionListener repaint = new RePaintPanelActionListener(scenepanel);
		Timer timer = new Timer(25, repaint);
		timer.start();
		
		/*
		testCanvas testcanvas = new testCanvas(frm, scenedata);
		cp.add(testcanvas);
		*/
	}
	/*
	@SuppressWarnings("serial")
	private static class testCanvas extends Canvas{
		private JFrame frm;
		private SceneData data;
		public testCanvas(JFrame frm, SceneData data){
			super();
			this.frm = frm; 
			this.data = data;
			setBackground(new Color(0xff, 0xff, 0xff, 0));
		}
		
		@Override
		public void paint(Graphics g) {
			g.setClip(0, 0, frm.getWidth(), frm.getHeight());
			g.drawImage(data.getBackImg(1), 0, 0, null);
		}
	}
	*/
}