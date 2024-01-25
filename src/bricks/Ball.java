/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bricks;

import javax.swing.JFrame;


public class Ball
{
   // execute application
   public static void main( String args[] )
   {
      JFrame frame = new JFrame( "Bouncing Ball" );
      frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

      BallPanel bp = new BallPanel(); 
      frame.add( bp );
      frame.setSize( 300, 300 ); // set frame size
      frame.setVisible( true ); // display frame
   } // end main
}
