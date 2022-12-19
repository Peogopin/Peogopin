package com.peogopin.tile;

import com.peogopin.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.util.List;

public class TileManager {
	GamePanel gamePanel;
	Tile[] tile;

	public TileManager(GamePanel gamePanel){
		this.gamePanel = gamePanel;

		tile = new Tile[100];
		getTileImage();
	}

	public void getTileImage(){
		try {
				int num = 0;
				for(String spriteName : new String[]{
								"earth", 		// 00
								"floor01",	//  1
								"grass00",	//  2
								"grass01",	//  3
								"hut",			//  4
								"road00",		//  5
								"road01",		//  6
								"road02",		//  7
								"road03",		//  8
								"road04",		//  9
								"road05",		// 10
								"road06",		// 11
								"road07",		// 12
								"road08",		// 13
								"road09",		// 14
								"road10",		// 15
								"road11",		// 16
								"road12",		// 17
								"table01",	// 18
								"tree",			// 19
								"wall",			// 20
								"water00",	// 21
								"water01",	// 22
								"water02",	// 23
								"water03",	// 24
								"water04",	// 25
								"water05",	// 26
								"water06",	// 27
								"water07",	// 28
								"water08",	// 29
								"water09",	// 30
								"water10",	// 31
								"water11",	// 32
								"water12",	// 33
								"water13"		// 34
				}) {
					System.out.println(spriteName);
					tile[num] = new Tile();
					tile[num].image = ImageIO.read(getClass().getResourceAsStream("/tiles/"+spriteName+".png"));
					num++;
				}
		} catch (IOException e){
			e.printStackTrace();
		}
	}

	public void draw(Graphics2D graphics2D){
		// World design
		// COLUMN 0
		for(int i=0; i<=30; i++){
			graphics2D.drawImage(tile[20].image, i*gamePanel.tileSize, 0, gamePanel.tileSize, gamePanel.tileSize, null);
		}

		// COLUMN 1
		graphics2D.drawImage(tile[20].image, 0*gamePanel.tileSize, 1*gamePanel.tileSize, gamePanel.tileSize, gamePanel.tileSize, null);
		for(int i=1; i<=29; i++) {
			graphics2D.drawImage(tile[3].image, i * gamePanel.tileSize, 1 * gamePanel.tileSize, gamePanel.tileSize, gamePanel.tileSize, null);
		}
		graphics2D.drawImage(tile[20].image, 30*gamePanel.tileSize, 1* gamePanel.tileSize, gamePanel.tileSize, gamePanel.tileSize, null);

		// COLUMN 2
		graphics2D.drawImage(tile[20].image, 0*gamePanel.tileSize, 2*gamePanel.tileSize, gamePanel.tileSize, gamePanel.tileSize, null);
		for(int i=1; i<=29; i++) {
			graphics2D.drawImage(tile[3].image, i * gamePanel.tileSize, 2 * gamePanel.tileSize, gamePanel.tileSize, gamePanel.tileSize, null);
		}
		graphics2D.drawImage(tile[20].image, 30*gamePanel.tileSize, 2*gamePanel.tileSize, gamePanel.tileSize, gamePanel.tileSize, null);

		// COLUMN 3
		graphics2D.drawImage(tile[20].image, 0*gamePanel.tileSize, 3*gamePanel.tileSize, gamePanel.tileSize, gamePanel.tileSize, null);
		for(int i=1; i<=3; i++){
			graphics2D.drawImage(tile[3].image, i*gamePanel.tileSize, 3*gamePanel.tileSize, gamePanel.tileSize, gamePanel.tileSize, null);
		}
		graphics2D.drawImage(tile[14].image, 4*gamePanel.tileSize, 3*gamePanel.tileSize, gamePanel.tileSize, gamePanel.tileSize, null);
		for(int i=5; i<=25; i++){
			graphics2D.drawImage(tile[12].image, i*gamePanel.tileSize, 3*gamePanel.tileSize, gamePanel.tileSize, gamePanel.tileSize, null);
		}
		graphics2D.drawImage(tile[15].image, 26*gamePanel.tileSize, 3*gamePanel.tileSize, gamePanel.tileSize, gamePanel.tileSize, null);
		for(int i=27; i<=29; i++){
			graphics2D.drawImage(tile[3].image, i*gamePanel.tileSize, 3*gamePanel.tileSize, gamePanel.tileSize, gamePanel.tileSize, null);
		}
		graphics2D.drawImage(tile[20].image, 30*gamePanel.tileSize, 3*gamePanel.tileSize, gamePanel.tileSize, gamePanel.tileSize, null);

		// COLUMN 4

		// COLUMN 5

		// COLUMN 6

		// COLUMN 7

		// COLUMN 7
	}
}

