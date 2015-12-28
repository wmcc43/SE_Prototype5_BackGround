import java.awt.Container;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.Timer;

import se.module.scene.CharacterMoveListener;
import se.module.scene.RePaintPanelActionListener;
import se.module.scene.SceneData;
import se.module.scene.ScenePanel;

public class BackGround{
	
	public static void main(String[] args){
		JFrame frm = new JFrame();
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
		SceneData scenedata = new SceneData(frm);
		ScenePanel scenepanel = new ScenePanel();
		scenepanel.setSceneData(scenedata);
		frm.addKeyListener(new CharacterMoveListener(scenedata));
		scenepanel.setBounds(0, 0, frm.getWidth(), frm.getHeight());
		cp.setLayout(null);
		cp.add(scenepanel);
		RePaintPanelActionListener repaint = new RePaintPanelActionListener(scenepanel);
		Timer timer = new Timer(25, repaint);
		timer.start();
		
	}
}