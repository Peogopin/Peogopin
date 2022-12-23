package com.peogopin;

import com.peogopin.entity.Player;
import com.peogopin.tile.TileManager;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable{

	// Screen Settings
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	final int originalTileSize = 16; // 16x16 [px] tile
	final int scale = 3;
	public final int tileSize = originalTileSize * scale; // 48x48 [px] tile
	public final int screenWidth = tileSize * 24; // in TileSizes
	public final int screenHeight = tileSize * 16; // in TileSizes

	//FPS
	final int fps = 60;

	TileManager tileManager = new TileManager(this);
	KeyHandler keyHandler = new KeyHandler();
	Thread gameThread;
	public Player player = new Player(this, keyHandler);

	GamePanel(){
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		this.setBackground(new Color(0, 0, 0));
		this.setDoubleBuffered(true);
		this.addKeyListener(keyHandler);
		this.setFocusable(true);
	}

	public int getScreenHeight(){
		return (int) screenSize.getHeight();
	}
	public int getScreenWidth(){
		return (int) screenSize.getWidth();
	}

	public void startGameThread(){
		gameThread = new Thread(this);
		gameThread.start();
	}

	@Override
	public void run() {
		double drawInterval = 1_000_000_000 / fps;
		double delta = 0;
		long lastTime = System.nanoTime();
		long currentTime;
		long timer = 0;
		int drawCount =  0;

		while (gameThread != null){
			currentTime = System.nanoTime();

			delta += (currentTime - lastTime) / drawInterval;
			timer += (currentTime - lastTime);
			lastTime = currentTime;

			if (delta >= 1) {
				update();
				repaint();
				delta--;
				drawCount++;
			}

			if (timer >= 1_000_000_000){
				drawCount = 0;
				timer = 0;
			}
		}
	}

	public void update(){
		player.update();
	}

	public void paintComponent(Graphics graphics){
		super.paintComponent(graphics);

		Graphics2D graphics2D = (Graphics2D) graphics;
		tileManager.draw(graphics2D);
		player.draw(graphics2D);
		graphics2D.dispose();
	}
}
