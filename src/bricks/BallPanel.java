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
import javax.swing.Timer;

class BallPanel extends JPanel implements ActionListener
{
   private int delay = 10;
   protected Timer timer;

   private int x = 500;		// x position
   private int y = 530;		// y position
   private int radius = 20;	// ball radius

   private int dx = 5;		// increment amount (x coord)
   private int dy = 5;		// increment amount (y coord)

   public BallPanel()
   {
      timer = new Timer(delay, this);
	timer.start();		// start the timer
   }

   public void actionPerformed(ActionEvent e)
   // will run when the timer fires
   {
	repaint();
   }

   // draw rectangles and arcs
   public void paintComponent( Graphics g )
   {
      super.paintComponent( g ); // call superclass's paintComponent 
	g.setColor(Color.red);

	// check for boundaries
	if (x < radius)			dx = Math.abs(dx);
	if (x > getWidth() - radius)	dx = -Math.abs(dx);
	if (y < radius)			dy = Math.abs(dy);
	if (y > getHeight() - radius)	dy = -Math.abs(dy);

	// adjust ball position
	x += dx;
	y += dy;
	g.fillOval(x - radius, y - radius, radius*2, radius*2);
        
        
   }

}