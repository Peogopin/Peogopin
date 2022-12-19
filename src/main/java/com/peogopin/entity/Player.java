package com.peogopin.entity;

import com.peogopin.GamePanel;
import com.peogopin.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player extends Entity{

	GamePanel gamePanel;
	KeyHandler keyHandler;


	public Player(GamePanel gamePanel, KeyHandler keyHandler){
		this.gamePanel = gamePanel;
		this.keyHandler = keyHandler;

		setDefaultValues();
		getPlayerImage();
	}

	public void setDefaultValues(){
		x = 100;
		y = 100;
		speed = 4;
		direction = "down";
	}

	public void getPlayerImage(){
		try {
			up_walking_image_1 = ImageIO.read(getClass().getResourceAsStream("/player/boy_up_1.png"));
			down_walking_image_1 = ImageIO.read(getClass().getResourceAsStream("/player/boy_down_1.png"));
			left_walking_image_1 = ImageIO.read(getClass().getResourceAsStream("/player/boy_left_1.png"));
			right_walking_image_1 = ImageIO.read(getClass().getResourceAsStream("/player/boy_right_1.png"));
			up_walking_image_2 = ImageIO.read(getClass().getResourceAsStream("/player/boy_up_2.png"));
			down_walking_image_2 = ImageIO.read(getClass().getResourceAsStream("/player/boy_down_2.png"));
			left_walking_image_2 = ImageIO.read(getClass().getResourceAsStream("/player/boy_left_2.png"));
			right_walking_image_2 = ImageIO.read(getClass().getResourceAsStream("/player/boy_right_2.png"));
		} catch (IOException e){
			e.printStackTrace();
		}
	}

	public void update(){
		if (keyHandler.wPressed && !(keyHandler.aPressed || keyHandler.sPressed || keyHandler.dPressed)
						|| keyHandler.aPressed && !(keyHandler.sPressed || keyHandler.dPressed || keyHandler.wPressed)
						|| keyHandler.sPressed && !(keyHandler.dPressed || keyHandler.wPressed || keyHandler.aPressed)
						|| keyHandler.dPressed && !(keyHandler.wPressed || keyHandler.aPressed || keyHandler.sPressed)
		) {
			if (keyHandler.wPressed) {
				direction = "up";
				y -= speed;
			} else if (keyHandler.sPressed) {
				direction = "down";
				y += speed;
			} else if (keyHandler.aPressed) {
				direction = "left";
				x -= speed;
			} else {
				direction = "right";
				x += speed;
			}

			spriteCounter++;
			if (spriteCounter > 12) {
				spriteImageSwitcher = !spriteImageSwitcher;
				spriteCounter = 0;
			}
		}
	}
	public void draw(Graphics2D graphics2D){
		BufferedImage bufferedImage = switch (direction) {
			case "up" -> (spriteImageSwitcher) ? up_walking_image_1 : up_walking_image_2;
			case "down" -> (spriteImageSwitcher) ? down_walking_image_1 : down_walking_image_2;
			case "left" -> (spriteImageSwitcher) ? left_walking_image_1 : left_walking_image_2;
			case "right" -> (spriteImageSwitcher) ? right_walking_image_1 : right_walking_image_2;
			default -> null;
		};
		graphics2D.drawImage(bufferedImage, x, y, gamePanel.tileSize, gamePanel.tileSize, null);
	}
}
