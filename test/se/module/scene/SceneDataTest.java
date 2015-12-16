package se.module.scene;

import static org.junit.Assert.*;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class SceneDataTest {
	/*defensive programing of read in map*/
	static JFrame frm;
	SceneData scenedata;
	
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

	@Test
	public final void testSceneDataJFrame() {
		SceneData scene = new SceneData(frm);
		assertNotNull(scene.getJFrame());
	}

	@Test
	public final void testSceneDataIntJFrame() {
		int mapType = 2;
		SceneData scene = new SceneData(mapType, frm);
		assert(mapType>=0 && mapType<5);
		assertNotNull(scene.getJFrame());
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
		int mapType = 2;
		assert mapType>=0 && mapType<5;
		scenedata.setMapType(mapType);
		int mapbit[][]=
		{
				{2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2},
				{2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4},
				{2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2},
				{2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4},
				{2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2},
				{2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4},
				{2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2},
				{2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4},
				{2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2},
				{2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4},
				{2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2},
				{2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4},
				{2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2},
				{2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4},
				{2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2},
				{2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4},
				{2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2},
				{2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4},
				{2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2},
				{2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4}
		};
		for(int i=0;i<20;i++)
			for(int j=0;j<50;j++) {
				assertEquals(mapbit[i][j], scenedata.getBackimg(j, i));
			}
	}

	@Test
	public final void testSetTopBound() {
		int topBound = 100;
		scenedata.setTopBound(topBound);
		assertEquals(topBound, scenedata.getTopBound());
	}

	@Test
	public final void testGetTopBound() {
		int topBound = 100;
		scenedata.setTopBound(topBound);
		assertEquals(topBound, scenedata.getTopBound());
	}

	@Test
	public final void testSetBottomBound() {
		int btmBound = 100;
		scenedata.setBottomBound(btmBound);
		assertEquals(btmBound, scenedata.getBottomBound());
	}

	@Test
	public final void testGetBottomBound() {
		int btmBound = 100;
		scenedata.setBottomBound(btmBound);
		assertEquals(btmBound, scenedata.getBottomBound());
	}

	@Test
	public final void testSetLeftBound() {
		int leftBound = 100;
		scenedata.setLeftBound(leftBound);
		assertEquals(leftBound, scenedata.getLeftBound());
	}

	@Test
	public final void testGetLeftBound() {
		int leftBound = 100;
		scenedata.setLeftBound(leftBound);
		assertEquals(leftBound, scenedata.getLeftBound());
	}

	@Test
	public final void testSetRightBound() {
		int rightBound = 100;
		scenedata.setRightBound(rightBound);
		assertEquals(rightBound, scenedata.getRightBound());
	}

	@Test
	public final void testGetRightBound() {
		int rightBound = 100;
		scenedata.setRightBound(rightBound);
		assertEquals(rightBound, scenedata.getRightBound());
	}

	@Test
	public final void testGetBackImg() {
		for(int i=0;i<5;i++)
			assertNotNull(scenedata.getBackImg(i));
	}

	@Test
	public final void testGetMapWidth() {
		assertEquals(5000, scenedata.getMapWidth());
	}

	@Test
	public final void testGetMapHeight() {
		assertEquals(2000, scenedata.getMapHeight());
	}

	@Test
	public final void testGetCharacter() {
		assertNotNull(scenedata.getCharacter());
	}

	@Test
	public final void testGetBackimg() {
		for(int i=0;i<5;i++){
			assertNotNull(scenedata.getBackImg(i));
		}
		for(int i=0;i<50;i++)
			for(int j=0;j<20;j++){
				assert scenedata.getBackimg(i, j)>=0 && scenedata.getBackimg(i, j)<5;
			}
	}

	@Test
	public final void testSetPositionX() {
		int Xoffset = 1000;
		scenedata.setPositionX(Xoffset);
		assertEquals(Xoffset, scenedata.getPositionX());
	}

	@Test
	public final void testGetPositionX() {
		int Xoffset = 1000;
		scenedata.setPositionX(Xoffset);
		assertEquals(Xoffset, scenedata.getPositionX());
	}

	@Test
	public final void testSetPositionY() {
		int Yoffset = 1000;
		scenedata.setPositionY(Yoffset);
		assertEquals(Yoffset, scenedata.getPositionY());
	}

	@Test
	public final void testGetPositionY() {
		int Yoffset = 1000;
		scenedata.setPositionY(Yoffset);
		assertEquals(Yoffset, scenedata.getPositionY());
	}

	@Test
	public final void testGetFrameWidth() {
		assertEquals(scenedata.getFrameWidth(), frm.getWidth());
	}

	@Test
	public final void testGetJFrame() {
		assertEquals(scenedata.getJFrame(), frm);
	}

	@Test
	public final void testGetFrameHeight() {
		assertEquals(scenedata.getFrameHeight(), frm.getHeight());
	}

}
