/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bricks;

import java.awt.Image;
import java.util.List;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.SwingUtilities;



/** *
 * 
 */
public class Game extends javax.swing.JFrame implements KeyListener {
       
    private BallPanel ballPanel;
    List<JLabel> bricks;
    JLabel jLabelPlatfrom;
    
    public Game() {
        initComponents();
        this.setSize(1026,630);
        Path resourceDirectory = Paths.get("src","resources");
        String absolutePath = resourceDirectory.toFile().getAbsolutePath();
        Image bgimg = new ImageIcon(absolutePath+"/bgImage.PNG").getImage();
        JPanelWithBackground bgPanel = new JPanelWithBackground(bgimg);
        bgPanel.setBounds(0,0,1010,600);
        bricks = new  ArrayList<>();
        bgPanel.setLayout(null);
        for(int i = 0; i<25;i++) {
            JLabel b = new JLabel(new ImageIcon(absolutePath+"/br"+(i%3)+".PNG"));
//            b.setPoints((i%3)*200+10);
//            b.setIcon();
            b.setBounds(10+(i%10)*100,(i/10)*60,89,49);
            bgPanel.add(b);
           // SwingUtilities.invokeLater(() -> new PlatformMovement());
        } 
        
        
        jLabelPlatfrom = new JLabel(new ImageIcon(getClass().getResource("/resources/platform.PNG")));
        jLabelPlatfrom.setBounds(400, 550, 200,40);
        bgPanel.add(jLabelPlatfrom);
        
       ballPanel = new BallPanel();
        bgPanel.add(ballPanel);
        
        getContentPane().add(bgPanel);
        
//       BallPanel bpanel = new BallPanel();
    //   mainWindow.setSize(200, 00);
        //mainWindow.pack();
    //  mainWindow.setVisible(true);
    
      // mainWindow.getBallPanel().move();
      
       addKeyListener(this);
       
    }
    
    public BallPanel getBallPanel() {
        return ballPanel;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1009, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 602, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Game().setVisible(true);
            }
        });
    }

    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key=e.getKeyCode();
              //  platformMove(evt.); 
        if (key == KeyEvent.VK_LEFT){
            movePlatformLeft();
        } else if (key== KeyEvent.VK_RIGHT){
             movePlatformRight();
        }
    }

    private void movePlatformLeft(){
     
        jLabelPlatfrom.setLocation(jLabelPlatfrom.getX()-15,jLabelPlatfrom.getY());
        
    }
    
     private void movePlatformRight(){
        jLabelPlatfrom.setLocation(jLabelPlatfrom.getX()+15,jLabelPlatfrom.getY());
    }
     
    @Override
    public void keyReleased(KeyEvent e) {
        
        int key=e.getKeyCode();
              //  platformMove(evt.); 
        if (key== KeyEvent.VK_LEFT){
            movePlatformLeft();
        } else if (key== KeyEvent.VK_RIGHT){
             movePlatformRight();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
