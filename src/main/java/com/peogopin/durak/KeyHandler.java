package com.peogopin.durak;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

	public boolean wPressed, sPressed, aPressed, dPressed;

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		switch (code) {
			case KeyEvent.VK_W -> {
				System.out.println("W pressed");
				wPressed = true;
			}
			case KeyEvent.VK_A -> {
				System.out.println("A pressed");
				aPressed = true;
			}
			case KeyEvent.VK_S -> {
				System.out.println("S pressed");
				sPressed = true;
			}
			case KeyEvent.VK_D -> {
				System.out.println("D pressed");
				dPressed = true;
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int code  = e.getKeyCode();
		switch (code) {
			case KeyEvent.VK_W -> {
				System.out.println("W released");
				wPressed = false;
			}
			case KeyEvent.VK_A -> {
				System.out.println("A released");
				aPressed = false;
			}
			case KeyEvent.VK_S -> {
				System.out.println("S released");
				sPressed = false;
			}
			case KeyEvent.VK_D -> {
				System.out.println("D released");
				dPressed = false;
			}
		}
	}
}
