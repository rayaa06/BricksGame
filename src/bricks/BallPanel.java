/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bricks;

import java.awt.event.ActionListener;
import javax.swing.JPanel;
import java.awt.event.*;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Rectangle;
import javax.swing.Timer;

class BallPanel extends JPanel implements ActionListener
{
   public int delay = 10;
   protected Timer timer;

   public int x = 500;		
   public int y = 530;		
   public int radius = 20;	

   public int dx = 5;		
   public int dy = 5;		

   private Game game;
   public BallPanel(Game g)
   {
       this.game= g;
      timer = new Timer(delay, this);
	timer.start();		// start the timer
   }

   public void actionPerformed(ActionEvent e)

   {
	repaint();
   }

   public void paintComponent( Graphics g )
   {
      super.paintComponent( g ); 
	g.setColor(Color.red);

	// check for boundaries
	if (x < radius)			dx = Math.abs(dx);
	if (x > getWidth() - radius)	dx = -Math.abs(dx);
	if (y < radius)			dy = Math.abs(dy);
        Rectangle ballRect = new Rectangle(x-radius, y-radius, 2*radius, 2*radius);
        if (ballRect.intersects(new Rectangle(this.game.platform.getX(), 550, 200,40))) {
                dy = -dy;
            }
        else {
            if(y>getHeight()-radius){
                System.out.println("Game over");
            }
            for (int i=0; i< this.game.bricks.size(); i++) {
                if (this.game.bricks.get(i).broken==false && ballRect.intersects(this.game.bricks.get(i).r)) {
                    dy=-dy;
                    this.game.bricks.get(i).broken= true;
                    this.game.Draw();
                    
                }
            }
        }

	x += dx;
	y += dy;
	g.fillOval(x - radius, y - radius, radius*2, radius*2);
   }
   

}