package se.module.scene;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SceneData {
	private int mapBit[][];
	private int mapType=3;
	private int mapWidth = 5000;
	private int mapHeight = 2000;
	private Image backimg[];
	private Image character;
	private Player player;
	
	public SceneData(){
		mapBit = new int[50][20];
		backimg = new Image[5];
		player = new Player();
		player.setPosition(new Point(4900,1900));
		initMap(mapType);
		LoadImg();
	}
	
	public SceneData(int mapType){
		assert (mapType>=0 && mapType<=4) : "mapType >= 0, <=4";
		mapBit = new int[50][20];
		backimg = new Image[5];
		player = new Player();
		player.setPosition(new Point(0,0));
		this.mapType = mapType;
		initMap(mapType);
		LoadImg();
	}
	
	public void setPlayer(Player player){
		this.player = player;
	}
	
	public Player getPlayer(){
		return player;
	}
	
	private void initMap(int mapType){
		for(int i=0; i<50; i++){
			for(int j=0; j<20; j++){
				if(i%2==1){
					if(j%2==1){
						mapBit[i][j] = 4;
					}
					else{
						mapBit[i][j] = mapType;
					}
				}
				else{
					mapBit[i][j] = mapType;
				}
			}
		}
	}
	
	public Point getVirtualCharacterPosition(){
		return player.getPostion();
	}
	
	private void LoadImg(){
		try{
			backimg[0] = ImageIO.read(new File("./imgs/mapbackgrounds/ice.png"));
			backimg[1] = ImageIO.read(new File("./imgs/mapbackgrounds/cake.png"));
			backimg[2] = ImageIO.read(new File("./imgs/mapbackgrounds/desert.png"));
			backimg[3] = ImageIO.read(new File("./imgs/mapbackgrounds/lego.png"));
			backimg[4] = ImageIO.read(new File("./imgs/mapbackgrounds/rock.png"));
			character = ImageIO.read(new File("./imgs/character/053.png"));
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	
	
	public void setMapType(int type){
		mapType = type;
		initMap(mapType);
	}
	
	public Image getBackImg(int img){
		assert img>=0 && img<=5 : "img isn't exist";
		return backimg[img];
	}
	
	public int getMapWidth(){
		return mapWidth;
	}
	
	public int getMapHeight(){
		return mapHeight;
	}
	
	public Image getCharacter(){
		return character;
	}
	
	public int getBackimg(int x, int y){
		return mapBit[x][y];
	}
}
