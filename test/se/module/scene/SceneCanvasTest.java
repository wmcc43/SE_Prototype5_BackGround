package se.module.scene;

import static org.junit.Assert.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class SceneCanvasTest {
	static JFrame frm;
	SceneCanvas scenecanvas;
	SceneData scenedata;
	Thread t;
	@BeforeClass
	/*scenedata mock, viewport testing*/
	public static void setUpBeforeClass() throws Exception {
		frm = new JFrame();
		frm.setUndecorated(true);
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		frm.setBounds(100, 100, 1000, 600);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		frm.dispose();
	}

	@Before
	public void setUp() throws Exception {
		scenecanvas = new SceneCanvas();
		scenedata = new SceneData(1, frm);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testMyRepaint() {
		scenecanvas.setSceneData(scenedata);
		scenecanvas.addKeyListener(new CharacterMoveListener(scenedata));
		assertNotNull(scenecanvas.getSceneData());
		assertNotNull(scenecanvas.getKeyListeners());
	}

	@Test
	public void testSetSceneData() {
		scenecanvas.setSceneData(scenedata);
		assertNotNull(scenecanvas.getSceneData());
	}

	@Test
	public void testGetSceneData() {
		scenecanvas.setSceneData(scenedata);
		assertNotNull(scenecanvas.getSceneData());
	}

}
