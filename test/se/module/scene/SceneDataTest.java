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

public class SceneDataTest {
	
	static JFrame frm;
	static SceneData scenedata;
	
	@BeforeClass
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
		scenedata = new SceneData(0, frm);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testSceneDataJFrame() {
		
	}

	@Test
	public final void testSceneDataIntJFrame() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testGetVirtualCharacterPosition() {
		Player player = scenedata.getPlayer();
		assertNotNull(player);
		Point playerPoint = player.getPostion();
		assertNotNull(playerPoint);
		assertEquals(0,playerPoint.getX());
		assertEquals(0,playerPoint.getY());
	}

	@Test
	public final void testSetPlayer() {
		Player player = new Player();
		player.setPosition(0, 0);
		scenedata.setPlayer(player);
		assertNotNull(scenedata.getPlayer());
	}

	@Test
	public final void testGetPlayer() {
		Player player = scenedata.getPlayer();
		assertNotNull(player);
	}

	@Test
	public final void testSetMapType() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testSetTopBound() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testGetTopBound() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testSetBottomBound() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testGetBottomBound() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testSetLeftBound() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testGetLeftBound() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testSetRightBound() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testGetRightBound() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testGetBackImg() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testGetMapWidth() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testGetMapHeight() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testGetCharacter() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testGetBackimg() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testSetPositionX() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testGetPositionX() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testSetPositionY() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testGetPositionY() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testGetFrameWidth() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testGetJFrame() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testGetFrameHeight() {
		fail("Not yet implemented"); // TODO
	}

}
