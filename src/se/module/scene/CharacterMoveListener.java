package se.module.scene;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class CharacterMoveListener extends KeyAdapter {
	private SceneData scenedata;
	public boolean right=false, left=false, up=false, down=false, space=false;
	
	public CharacterMoveListener(SceneData scenedata){
		super();
		this.scenedata = scenedata;
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		super.keyPressed(e);
		switch(e.getKeyCode()){
		case(KeyEvent.VK_RIGHT):
			right = true;
			break;
		case(KeyEvent.VK_LEFT):
			left = true;
			break;
		case(KeyEvent.VK_UP):
			up = true;
			break;
		case(KeyEvent.VK_DOWN):
			down = true;
			break;
		case(KeyEvent.VK_SPACE):
			space = true;
			break;
		case(49):
		case(50):
		case(51):
		case(52):
			scenedata.setMapType(e.getKeyCode()-49);
			break;
		case(KeyEvent.VK_Q):
			JFrame frm = (JFrame)SwingUtilities.getAncestorOfClass(JFrame.class, scenedata.getScenePanel());
			frm.dispatchEvent(new WindowEvent(frm, WindowEvent.WINDOW_CLOSING));
			break;
		default:
			break;
		}
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		super.keyReleased(e);
		switch(e.getKeyCode()){
		case(KeyEvent.VK_RIGHT):
			right = false;
			break;
		case(KeyEvent.VK_LEFT):
			left = false;
			break;
		case(KeyEvent.VK_UP):
			up = false;
			break;
		case(KeyEvent.VK_DOWN):
			down = false;
			break;
		case(KeyEvent.VK_SPACE):
			space = false;
			break;
		default:
			break;
		}
	}
}
