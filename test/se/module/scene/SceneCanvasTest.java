package se.module.scene;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SceneCanvasTest {
	SceneCanvas scenecanvas;
	SceneDataStub scenedata;
	
	/*scenedata stub, viewport testing*/
	
	@Before
	public void setUp() throws Exception {
		scenedata = new SceneDataStub();
		scenecanvas = new SceneCanvas();
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
		assertEquals(2000, scenedata.getPositionX());
		assertEquals(3000, scenedata.getPositionX()+scenedata.getFrameWidth());
		assertEquals(700, scenedata.getPositionY());
		assertEquals(1300, scenedata.getPositionY()+scenedata.getFrameHeight());
		
		scenedata.setVirtualCharacterPosition(new Point(4900, 1900));
		assertEquals(4000, scenedata.getPositionX());
		assertEquals(5000, scenedata.getPositionX()+scenedata.getFrameWidth());
		assertEquals(1400, scenedata.getPositionY());
		assertEquals(2000, scenedata.getPositionY()+scenedata.getFrameHeight());
		
		scenedata.setVirtualCharacterPosition(new Point(4900, 0));
		assertEquals(4000, scenedata.getPositionX());
		assertEquals(5000, scenedata.getPositionX()+scenedata.getFrameWidth());
		assertEquals(0, scenedata.getPositionY());
		assertEquals(600, scenedata.getPositionY()+scenedata.getFrameHeight());
		
		scenedata.setVirtualCharacterPosition(new Point(0, 1900));
		assertEquals(0, scenedata.getPositionX());
		assertEquals(1000, scenedata.getPositionX()+scenedata.getFrameWidth());
		assertEquals(1400, scenedata.getPositionY());
		assertEquals(2000, scenedata.getPositionY()+scenedata.getFrameHeight());
		
		scenedata.setVirtualCharacterPosition(new Point(0, 0));
		assertEquals(0, scenedata.getPositionX());
		assertEquals(1000, scenedata.getPositionX()+scenedata.getFrameWidth());
		assertEquals(0, scenedata.getPositionY());
		assertEquals(600, scenedata.getPositionY()+scenedata.getFrameHeight());
	}
}
