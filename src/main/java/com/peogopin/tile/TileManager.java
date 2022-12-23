package com.peogopin.tile;

import com.peogopin.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.concurrent.ExecutionException;

public class TileManager {
	GamePanel gamePanel;
	Graphics2D graphics2D;
	Tile[] tile;
	int[][] ChunkTileNum;


	// define the position of corners of the screen


	public TileManager(GamePanel gamePanel){
		this.gamePanel = gamePanel;

		tile = new Tile[100];
		ChunkTileNum = new int[16][16];

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
		this.graphics2D = graphics2D;
		// World design
		/*
		* The world is build in "Chunks". The size of one chunk is "16x16 Tile Images"
		*
		* */
		for(int chunkX=0; chunkX<=2; chunkX++) {
			for(int chunkY=0; chunkY<=1; chunkY++) {
					int[] chunk = defineChunk(chunkX, chunkY);
					loadChunk("chunk-x" + chunk[0] + "y" + chunk[1]);
					for (int row = 0; row <= 15; row++) {
						for (int col = 0; col <= 15; col++) {
							if (checkIfTileIsInsideScreen(chunk, row, col))
								placeTile(ChunkTileNum[row][col], chunk, row, col);
						}
					}
			}
		}
	}

	public boolean checkIfTileIsInsideScreen(int[] chunk, int row, int col){
		int[] tileWorldPosition = {(chunk[0]*16+row), (chunk[1]*16+col)};
		int[] playerWorldPosition = {gamePanel.player.worldX+(12), gamePanel.player.worldY+(8)};
		return tileWorldPosition[0] >= (playerWorldPosition[0] - 12) &&
						tileWorldPosition[1] >= (playerWorldPosition[1] - 8) &&
						tileWorldPosition[0] <= (playerWorldPosition[0] + 12) &&
						tileWorldPosition[1] <= (playerWorldPosition[1] + 8);
	}

	public int[] defineChunk(int x, int y){
		return new int[]{x,y};
	}
	public void loadChunk(String mapName){
		try {
			InputStream inputStream = getClass().getResourceAsStream("/maps/overworld/"+mapName+".txt");
			if(inputStream == null){
				inputStream = getClass().getResourceAsStream("/maps/overworld/empty.txt");
			}
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

			int col = 0;
			int row = 0;

			while (col < 16 && row < 16){
				String line = bufferedReader.readLine();
				while(col < 16){
					String numbers[] = line.split(" ");
					int num = Integer.parseInt(numbers[col]);
					this.ChunkTileNum[col][row] = num;
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
		int xCoordination = chunkCords[0]*16+x - gamePanel.player.worldX;
		int yCoordination = chunkCords[1]*16+y - gamePanel.player.worldY;
		this.graphics2D.drawImage(tile[tileNumber].image, xCoordination*gamePanel.tileSize, yCoordination*gamePanel.tileSize, gamePanel.tileSize, gamePanel.tileSize, null);
	}
}