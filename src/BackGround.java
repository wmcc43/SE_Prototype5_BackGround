import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import se.module.scene.SceneCanvas;

public class BackGround extends JFrame implements Runnable{
	
	public static void main(String[] args){
		Thread t = new Thread(new BackGround());
		SwingUtilities.invokeLater(t);
	}


	@Override
	public void run() {
		this.setUndecorated(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		this.setBounds(100, 100, 500, 300);
		Container cp = this.getContentPane();
		SceneCanvas sceneCanvas = new SceneCanvas(this);
		cp.add(sceneCanvas, BorderLayout.CENTER);
		this.setVisible(true);
		sceneCanvas.createBufferStrategy(2);
	}

}
