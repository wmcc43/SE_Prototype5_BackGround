import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import se.module.scene.SceneCanvas;

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
		frm.setBounds(100, 100, 500, 300);
		Container cp = frm.getContentPane();
		frm.setVisible(true);
		sceneCanvas = new SceneCanvas(frm);
		cp.add(sceneCanvas, BorderLayout.CENTER);
		Thread t = new Thread(sceneCanvas);
		SwingUtilities.invokeLater(t);
	}

}