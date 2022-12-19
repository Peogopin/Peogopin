package com.peogopin.tile;

import com.peogopin.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TileManager {
	GamePanel gamePanel;
	Graphics2D graphics2D;
	Tile[] tile;
	int mapTileNum[][];

	public TileManager(GamePanel gamePanel){
		this.gamePanel = gamePanel;

		tile = new Tile[100];
		mapTileNum = new int[16][16];

		getTileImage();
		loadMap("chunk-x1y1");
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
		this.graphics2D = graphics2D;
		// World design
		/*
		* The world is build in "chunks". The size of one chunk is "16x16 Tile Images"
		*
		* */
		int col = 0, row = 0, x = 0, y = 0;

		while (col < 16 && row < 16) {
			int tileNum = mapTileNum[col][row];
			graphics2D.drawImage(tile[tileNum].image, x, y, gamePanel.tileSize, gamePanel.tileSize, null);
			col++;
			x += gamePanel.tileSize;

			if(col == 16){
				col = 0;
				x = 0;
				row++;
				y += gamePanel.tileSize;
			}
		}


	}

	public void loadMap(String mapName){
		try {
			InputStream inputStream = getClass().getResourceAsStream("/maps/overworld/"+mapName+".txt");
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

			int col = 0;
			int row = 0;

			while (col < 16 && row < 16){
				String line = bufferedReader.readLine();
				System.out.println(line);
				while(col < 16){
					String numbers[] = line.split(" ");
					int num = Integer.parseInt(numbers[col]);
					this.mapTileNum[col][row] = num;
					col++;
				}
				if(col == 16){
					col = 0;
					row++;
				}
			}
			bufferedReader.close();
		} catch (Exception ignored){

		}
	}

	private void placeTile(int tileNumber, int[] chunkCords, int x, int y){
		int xCoordination = chunkCords[0]*16+x;
		int yCoordination = chunkCords[1]*16+y;
		this.graphics2D.drawImage(tile[tileNumber].image, xCoordination*gamePanel.tileSize, yCoordination*gamePanel.tileSize, gamePanel.tileSize, gamePanel.tileSize, null);
	}
}

