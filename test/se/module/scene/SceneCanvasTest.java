package se.module.scene;

import static org.junit.Assert.*;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SceneCanvasTest {
	ScenePanel scenecanvas;
	SceneDataStub scenedata;
	
	/*scenedata stub, viewport testing*/
	
	@Before
	public void setUp() throws Exception {
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
		scenecanvas = new ScenePanel();
		scenecanvas.setBounds(0, 0, 800, 600);
		frm.getContentPane().add(scenecanvas);
		frm.getContentPane().setLayout(null);
		scenedata = new SceneDataStub(scenecanvas);
		scenecanvas.setSceneData(scenedata);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testMyRepaint() {
		Player player = new Player();
		scenedata.setPlayer(player);
		
		scenedata.setVirtualCharacterPosition(new Point(2500, 1000));
		assertEquals(2100, scenedata.getPositionX());
		assertEquals(2900, scenedata.getPositionX()+scenedata.getPanelWidth());
		assertEquals(700, scenedata.getPositionY());
		assertEquals(1300, scenedata.getPositionY()+scenedata.getPanelHeight());
		
		scenedata.setVirtualCharacterPosition(new Point(4900, 1900));
		assertEquals(4200, scenedata.getPositionX());
		assertEquals(5000, scenedata.getPositionX()+scenedata.getPanelWidth());
		assertEquals(1400, scenedata.getPositionY());
		assertEquals(2000, scenedata.getPositionY()+scenedata.getPanelHeight());
		
		scenedata.setVirtualCharacterPosition(new Point(4900, 0));
		assertEquals(4200, scenedata.getPositionX());
		assertEquals(5000, scenedata.getPositionX()+scenedata.getPanelWidth());
		assertEquals(0, scenedata.getPositionY());
		assertEquals(600, scenedata.getPositionY()+scenedata.getPanelHeight());
		
		scenedata.setVirtualCharacterPosition(new Point(0, 1900));
		assertEquals(0, scenedata.getPositionX());
		assertEquals(800, scenedata.getPositionX()+scenedata.getPanelWidth());
		assertEquals(1400, scenedata.getPositionY());
		assertEquals(2000, scenedata.getPositionY()+scenedata.getPanelHeight());
		
		scenedata.setVirtualCharacterPosition(new Point(0, 0));
		assertEquals(0, scenedata.getPositionX());
		assertEquals(800, scenedata.getPositionX()+scenedata.getPanelWidth());
		assertEquals(0, scenedata.getPositionY());
		assertEquals(600, scenedata.getPositionY()+scenedata.getPanelHeight());
	}
}
