import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

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
		BackGroundCanvas bg = new BackGroundCanvas(this);
		cp.add(bg, BorderLayout.CENTER);
		this.setVisible(true);
		bg.createBufferStrategy(2);
	}

}
