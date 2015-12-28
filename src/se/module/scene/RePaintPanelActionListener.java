package se.module.scene;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RePaintPanelActionListener implements ActionListener {
	ScenePanel bg;
	public RePaintPanelActionListener(ScenePanel bg) {
		this.bg = bg;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		bg.repaint();
		bg.moveCharacter();
	}
}
