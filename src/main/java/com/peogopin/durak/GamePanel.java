package com.peogopin.durak;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable{

	// Screen Settings
	final int originalTileSize = 16; // 16x16 tile
	final int scale = 3;
	final int tileSize = originalTileSize * scale; // 48x48 tile
	final int maxScreenCol = 16;
	final int maxScreenRow = 12;
	final int screenWidth = tileSize * maxScreenCol; // 48*16 = 768px
	final int screenHeight = tileSize * maxScreenRow; // 48*12 = 576px
	KeyHandler keyHandler = new KeyHandler();
	Thread gameThread;

	// Set default position
	int playerX = 100;
	int playerY = 100;
	int speed = 4;

	GamePanel(){
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		this.setBackground(new Color(3, 201, 176));
		this.setDoubleBuffered(true);
		this.addKeyListener(keyHandler);
		this.setFocusable(true);
	}

	public void startGameThread(){
		gameThread = new Thread(this);
		gameThread.start();
	}

	@Override
	public void run() {
		while (gameThread != null){
			update();
			repaint();
		}
	}

	public void update(){
		if(keyHandler.wPressed){
			playerY -= speed;
		}
	}

	public void paintComponent(Graphics graphics){
		super.paintComponent(graphics);

		Graphics2D graphics2D = (Graphics2D) graphics;
		graphics2D.setColor(Color.white);
		graphics2D.fillRect(playerX, playerY, tileSize, tileSize);
		graphics2D.dispose();
	}
}
