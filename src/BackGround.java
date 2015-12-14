import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

import se.module.scene.CharacterMoveListener;
import se.module.scene.RePaintActionListener;
import se.module.scene.SceneCanvas;
import se.module.scene.SceneData;

public class BackGround{
	
	public static void main(String[] args){
		JFrame frm = new JFrame();
		SceneCanvas sceneCanvas;
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
		sceneCanvas = new SceneCanvas();
		SceneData scenedata = new SceneData(frm);
		sceneCanvas.setSceneData(scenedata);
		sceneCanvas.addKeyListener(new CharacterMoveListener(scenedata));
		cp.add(sceneCanvas, BorderLayout.CENTER);
		Thread t = new Thread(sceneCanvas);
		SwingUtilities.invokeLater(t);
		RePaintActionListener repaint = new RePaintActionListener(sceneCanvas);
		Timer timer = new Timer(25, repaint);
		timer.start();
	}

}