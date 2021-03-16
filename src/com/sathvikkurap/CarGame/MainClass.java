package com.sathvikkurap.CarGame;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.util.Random;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class MainClass extends JFrame implements KeyListener, ActionListener{
int timesgameover = 0;
static int restart = 0;
String gameovergif = (".//images//cooltext374299761997594.gif");
Icon icon = new ImageIcon(gameovergif);
JLabel label = new JLabel(icon);
static boolean isgameover1 = false;
static int roadmove = 0;
static Random rand = new Random();
private ImageIcon usercar;
private ImageIcon usercar1;
private ImageIcon usercar2;
private ImageIcon start;
private ImageIcon usercar3;
private ImageIcon tree;
private ImageIcon gun;
private ImageIcon bullet;
KeyEvent e;
Component c;
JFrame f = new JFrame();
static int xpos = 250;
int seconds = 0;
static int ypos = 500;
static int carxpos[] = {100, 250, 400, 550};
static int carypos[] = {100, 250, 400, 550};
static int x = rand.nextInt(3);
static int cxpos1 = 0;
static int cxpos2 = 2;
static int cxpos3 = 4;
static int cypos1 = rand.nextInt(3);
static int cypos2 = rand.nextInt(3);
static int cypos3 = rand.nextInt(3);
static int y1pos = carypos[cypos1];
static int y2pos = carypos[cypos2];
static int y3pos = carypos[cypos3];
int delay = 500;
Graphics g;



	public MainClass() {
		
		super("Racing Game");
		setBounds(300, 10, 700, 700);
		
		setVisible(true);
		setResizable(false);
		addKeyListener(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		int cypos1 = rand.nextInt(3), cypos2 = rand.nextInt(3), cypos3 = rand.nextInt(3);
		wavsound.gamemusic();
					
	}
		
	private void ResetObjects()
	{
		
		xpos = 250;
		ypos = 500;
		x = rand.nextInt(3);
		cypos1 = rand.nextInt(3);
		cypos2 = rand.nextInt(3);
		cypos3 = rand.nextInt(3);
		y1pos = 0;
		y2pos = 0;
		y3pos = 0;
		delay = 500;
		f.dispose();
		repaint();
	}
	
	public void paint(Graphics g) {
		delay+=5;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		g.setColor(Color.GREEN);
		g.fillRect(0, 0, 700, 700);
		g.setColor(Color.GRAY);
		g.fillRect(90, 0, 10, 700);
		g.fillRect(600, 0, 10, 700);
		g.setColor(Color.BLACK);
		g.fillRect(100, 0, 500, 700);
		// Paint the outside of the track
		g.setColor(Color.RED);
		g.fillRect(50, 0, 40, 700);
		g.fillRect(610, 0, 40, 700);
		
		
		//Paint the white lines on the track
		
		
		
		
		// Paint the white bars
		for(int i = 0; i < 700; i+=100) {
			g.setColor(Color.WHITE);
			g.fillRect(350, i, 10, 70);
		}
	
		if(IsGameOver())
		{
			
			timesgameover++;
			// Paint game over screen
			if(timesgameover == 1) {
		        JLabel label = new JLabel(icon);
		        f.getContentPane().add(label);
		        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		        f.pack();
		        f.setVisible(true);
			wavsound.PlaySound(gameover);
			repaint();				
			}
			}
		else
			{		
			//paint the car
			if(roadmove==0)
			{
				for(int i=0; i<=700; i+=100)
				{
					g.setColor(Color.WHITE);
					g.fillRect(350, i,10, 70);
					g.fillRect(200, i, 5, 35);
					g.fillRect(500, i, 5, 35);
					
				}for(int i=0; i<=700; i += 40)
				{
					
					g.setColor(Color.WHITE);
					int[] xPoints = new int[4];
					xPoints[0] = 50;
					xPoints[1] = 50;
					xPoints[2] = 90;
					xPoints[3] = 90;
					int[] yPoints = new int[4];
					yPoints[0] = i;
					yPoints[1] = i + 20;
					yPoints[2] = i;
					yPoints[3] = i - 20;
					int nPoints = 4;
					g.fillPolygon(xPoints, yPoints, nPoints);
					g.setColor(Color.WHITE);
					int[] xPoints2 = new int[4];
					xPoints2[0] = 610;
					xPoints2[1] = 610;
					xPoints2[2] = 650;
					xPoints2[3] = 650;
					int[] yPoints2 = new int[4];
					yPoints2[0] = i;
					yPoints2[1] = i - 20;
					yPoints2[2] = i;
					yPoints2[3] = i + 20;
					g.fillPolygon(xPoints2, yPoints2, nPoints);
						
				}
				roadmove=1;
				
				
				
			}
			else if(roadmove==1)
			{
				for(int i=0; i<=700; i+=100)
				{
					g.setColor(Color.BLACK);
					g.fillRect(350, i,10, 70);
					g.fillRect(200, i, 5, 35);
					g.fillRect(500, i, 5, 35);
				}
				for(int i=50; i<=700; i+=100)
				{
					g.setColor(Color.WHITE);
					g.fillRect(350, i,10, 70);
					g.fillRect(200, i, 5, 35);
					g.fillRect(500, i, 5, 35);
				}
				for(int i=20; i<=700; i += 40)
				{
					
					g.setColor(Color.WHITE);
					int[] xPoints = new int[4];
					xPoints[0] = 50;
					xPoints[1] = 50;
					xPoints[2] = 90;
					xPoints[3] = 90;
					int[] yPoints = new int[4];
					yPoints[0] = i;
					yPoints[1] = i + 20;
					yPoints[2] = i;
					yPoints[3] = i - 20;
					int nPoints = 4;
					g.fillPolygon(xPoints, yPoints, nPoints);
					g.setColor(Color.WHITE);
					int[] xPoints2 = new int[4];
					xPoints2[0] = 610;
					xPoints2[1] = 610;
					xPoints2[2] = 650;
					xPoints2[3] = 650;
					int[] yPoints2 = new int[4];
					yPoints2[0] = i;
					yPoints2[1] = i - 20;
					yPoints2[2] = i;
					yPoints2[3] = i + 20;
					g.fillPolygon(xPoints2, yPoints2, nPoints);
						
				}
				roadmove=0;
			}

			bulletx = xpos + 49/2;                  
			usercar = new ImageIcon(".\\images\\car_self.png");
			usercar.paintIcon(this, g, xpos, ypos);
			bullet = new ImageIcon("download.png");
			gun = new ImageIcon("cannon.png");
			usercar1 = new ImageIcon(".\\images\\car_left_2.png");
			usercar2 = new ImageIcon(".\\images\\car_left_3.png");
			usercar3 = new ImageIcon(".\\images\\car_right_1.png");
			usercar1.paintIcon(this, g, carxpos[cxpos1], y1pos);
			usercar2.paintIcon(this, g, carxpos[cxpos2], y2pos);
			usercar3.paintIcon(this, g, carxpos[cxpos3-1], y3pos);
			tree = new ImageIcon(".\\images\\tree.png");
			tree.paintIcon(this, g, 50, 100);
			tree.paintIcon(this, g, 50, 600);
			tree.paintIcon(this, g, 50, 350);
			tree.paintIcon(this, g, 650, 100);
			tree.paintIcon(this, g, 650, 600);
			tree.paintIcon(this, g, 650, 350);
			
			y1pos += 100;
			y2pos += 100;
			y3pos += 100;		
			
			if (y1pos >= 710) {
					y1pos = 0;
					int y = rand.nextInt(3);
					carxpos[cxpos1] = 150*y + 100;
					repaint();
				}
			if (y2pos >= 710) {
				y2pos = 0;
				int z = rand.nextInt(3);
				carxpos[cxpos2] = 150*z + 100;
				repaint();
			}
			if (y3pos >= 710) {
				y3pos = 0;
				int a = rand.nextInt(3);
				carxpos[cxpos3-1] = 150*a + 100;
				repaint();
			}
			else {
				repaint();
			}
		}
		
		try {
			Thread.sleep(delay);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	protected static boolean IsGameOver()
	{
		/*(carxpos[cxpos1] == xpos && y1pos >= ypos && y1pos <= ypos + 50) ||
		(carxpos[cxpos1] == xpos && y1pos <= ypos && y1pos >= ypos - 50) ||
		(carxpos[cxpos1] == xpos && y1pos == ypos) ||
		(carxpos[cxpos2] == xpos && y1pos >= ypos && y1pos <= ypos + 25) ||
		(carxpos[cxpos2] == xpos && y1pos <= ypos && y1pos >= ypos - 25) ||
		(carxpos[cxpos2] == xpos && y2pos == ypos) ||
		(carxpos[cxpos3-1] == xpos && y1pos >= ypos && y1pos <= ypos + 25) ||
		(carxpos[cxpos3-1] == xpos && y3pos == ypos) ||
		(carxpos[cxpos3-1] == xpos && y1pos <= ypos && y1pos >= ypos - 25)*/
		if(carxpos[cxpos1] == xpos && y1pos == ypos || carxpos[cxpos1] == xpos && y1pos == ypos + 25 || carxpos[cxpos1] == xpos && y1pos == ypos -25 || carxpos[cxpos2] == xpos && y2pos == ypos || carxpos[cxpos2] == xpos && y2pos == ypos + 25 || carxpos[cxpos2] == xpos && y2pos == ypos - 25 || carxpos[cxpos3-1] == xpos && y3pos == ypos || carxpos[cxpos3-1] == xpos && y3pos == ypos - 25|| carxpos[cxpos3-1] == xpos && y3pos == ypos + 25)
		{
			isgameover1 = true;
			return true;
		}
		
		return false;
	}
	
	

	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_LEFT && isgameover1 != true) 
		{
			xpos = xpos - 150;
			if (xpos < 100) {
				xpos = 100;
			}
		}
		if(e.getKeyCode()==KeyEvent.VK_RIGHT && isgameover1 != true) 
		{
			xpos = xpos + 150;
			if (xpos > 550) {
				xpos = 550;
			}
		}
		if(e.getKeyCode()==KeyEvent.VK_SPACE) 
		{/*for(int i = bullety; i < 700; i = i + 100) {
			bullety = i;



			bullet.paintIcon(c, g, bulletx - 25/2, bullety -30);
		}*/
			seconds+=10;
			delay -= 7;
}
		
		
		if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			isgameover1 = false;
			ResetObjects();
		}			
	}

	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	public static void main(String[] args) {
		MainClass c = new MainClass();
	}
}
