package com.peogopin.entity;

import java.awt.image.BufferedImage;

public class Entity {
	public int x, y, speed;

	public BufferedImage up_walking_image_1, down_walking_image_1, left_walking_image_1, right_walking_image_1;
	public BufferedImage up_walking_image_2, down_walking_image_2, left_walking_image_2, right_walking_image_2;
	public String direction;

	public int spriteCounter = 0;
	public boolean spriteImageSwitcher = true; // This is used to switch between the first and second walking image
}
