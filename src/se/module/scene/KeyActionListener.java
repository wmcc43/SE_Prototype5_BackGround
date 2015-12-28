package se.module.scene;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class KeyActionListener implements ActionListener{
	
	private KeyActionPerformer performer;
	
	public KeyActionListener(KeyActionPerformer performer) {
		this.performer = performer;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		performer.moveCharacter();
		performer.placeBomb();
	}

}
