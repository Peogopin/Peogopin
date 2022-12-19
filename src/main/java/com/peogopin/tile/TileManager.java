package com.peogopin.tile;

import com.peogopin.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

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
								"water13",	// 34
				}) {
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
		/*
		* The world is build in "chunks". The size of one chunk is "16x16 Tile Images" ->
		* */


		// COLUMN 0
		int column = 0;
		for(int i=0; i<=30; i++){
			graphics2D.drawImage(tile[20].image, i*gamePanel.tileSize, column*gamePanel.tileSize, gamePanel.tileSize, gamePanel.tileSize, null);
		}

		// COLUMN 1
		column=1;
		graphics2D.drawImage(tile[20].image, 0*gamePanel.tileSize, column*gamePanel.tileSize, gamePanel.tileSize, gamePanel.tileSize, null);
		for(int i=1; i<=29; i++) {
			graphics2D.drawImage(tile[3].image, i * gamePanel.tileSize, column* gamePanel.tileSize, gamePanel.tileSize, gamePanel.tileSize, null);
		}
		graphics2D.drawImage(tile[20].image, 30*gamePanel.tileSize, column* gamePanel.tileSize, gamePanel.tileSize, gamePanel.tileSize, null);

		// COLUMN 2
		column=2;
		graphics2D.drawImage(tile[20].image, 0*gamePanel.tileSize, column*gamePanel.tileSize, gamePanel.tileSize, gamePanel.tileSize, null);
		for(int i=1; i<=29; i++) {
			graphics2D.drawImage(tile[3].image, i * gamePanel.tileSize, column* gamePanel.tileSize, gamePanel.tileSize, gamePanel.tileSize, null);
		}
		graphics2D.drawImage(tile[20].image, 30*gamePanel.tileSize, column*gamePanel.tileSize, gamePanel.tileSize, gamePanel.tileSize, null);

		// COLUMN 3
		column=3;
		graphics2D.drawImage(tile[20].image, 0*gamePanel.tileSize, column*gamePanel.tileSize, gamePanel.tileSize, gamePanel.tileSize, null);
		for(int i=1; i<=3; i++)
			graphics2D.drawImage(tile[3].image, i*gamePanel.tileSize, column*gamePanel.tileSize, gamePanel.tileSize, gamePanel.tileSize, null);

		graphics2D.drawImage(tile[14].image, 4*gamePanel.tileSize, column*gamePanel.tileSize, gamePanel.tileSize, gamePanel.tileSize, null);
		for(int i=5; i<=25; i++)
			graphics2D.drawImage(tile[12].image, i*gamePanel.tileSize, column*gamePanel.tileSize, gamePanel.tileSize, gamePanel.tileSize, null);

		graphics2D.drawImage(tile[15].image, 26*gamePanel.tileSize, column*gamePanel.tileSize, gamePanel.tileSize, gamePanel.tileSize, null);
		for(int i=27; i<=29; i++)
			graphics2D.drawImage(tile[3].image, i*gamePanel.tileSize, column*gamePanel.tileSize, gamePanel.tileSize, gamePanel.tileSize, null);

		graphics2D.drawImage(tile[20].image, 30*gamePanel.tileSize, column*gamePanel.tileSize, gamePanel.tileSize, gamePanel.tileSize, null);

		// COLUMN 4
		column=4;
		graphics2D.drawImage(tile[20].image, 0*gamePanel.tileSize, column*gamePanel.tileSize, gamePanel.tileSize, gamePanel.tileSize, null);
		for(int i=1; i<=3; i++)
			graphics2D.drawImage(tile[3].image, i*gamePanel.tileSize, column*gamePanel.tileSize, gamePanel.tileSize, gamePanel.tileSize, null);
		graphics2D.drawImage(tile[10].image, 4*gamePanel.tileSize, column*gamePanel.tileSize, gamePanel.tileSize, gamePanel.tileSize, null);
		for(int i=5; i<=29; i++)
			graphics2D.drawImage(tile[5].image, i*gamePanel.tileSize, column*gamePanel.tileSize, gamePanel.tileSize, gamePanel.tileSize, null);


		// COLUMN 5
		column=5;
		graphics2D.drawImage(tile[20].image, 0*gamePanel.tileSize, column*gamePanel.tileSize, gamePanel.tileSize, gamePanel.tileSize, null);
		for(int i=1; i<=3; i++)
			graphics2D.drawImage(tile[3].image, i*gamePanel.tileSize, column*gamePanel.tileSize, gamePanel.tileSize, gamePanel.tileSize, null);
		graphics2D.drawImage(tile[10].image, 4*gamePanel.tileSize, column*gamePanel.tileSize, gamePanel.tileSize, gamePanel.tileSize, null);
		graphics2D.drawImage(tile[5].image, 5*gamePanel.tileSize, column*gamePanel.tileSize, gamePanel.tileSize, gamePanel.tileSize, null);
		graphics2D.drawImage(tile[6].image, 6*gamePanel.tileSize, column*gamePanel.tileSize, gamePanel.tileSize, gamePanel.tileSize, null);
		for(int i=7; i<=29; i++)
			graphics2D.drawImage(tile[7].image, i*gamePanel.tileSize, column*gamePanel.tileSize, gamePanel.tileSize, gamePanel.tileSize, null);


		// COLUMN 6
		column=6;
		graphics2D.drawImage(tile[20].image, 0*gamePanel.tileSize, column*gamePanel.tileSize, gamePanel.tileSize, gamePanel.tileSize, null);
		for(int i=1; i<=3; i++)
			graphics2D.drawImage(tile[3].image, i*gamePanel.tileSize, column*gamePanel.tileSize, gamePanel.tileSize, gamePanel.tileSize, null);
		graphics2D.drawImage(tile[10].image, 4*gamePanel.tileSize, column*gamePanel.tileSize, gamePanel.tileSize, gamePanel.tileSize, null);
		graphics2D.drawImage(tile[5].image, 5*gamePanel.tileSize, column*gamePanel.tileSize, gamePanel.tileSize, gamePanel.tileSize, null);
		graphics2D.drawImage(tile[9].image, 6*gamePanel.tileSize, column*gamePanel.tileSize, gamePanel.tileSize, gamePanel.tileSize, null);

		// COLUMN 7
		column=7;
		graphics2D.drawImage(tile[20].image, 0*gamePanel.tileSize, column*gamePanel.tileSize, gamePanel.tileSize, gamePanel.tileSize, null);

		// COLUMN 8
		column=8;
		graphics2D.drawImage(tile[20].image, 0*gamePanel.tileSize, column*gamePanel.tileSize, gamePanel.tileSize, gamePanel.tileSize, null);

	}
}

