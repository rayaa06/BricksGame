package bricks;

import java.awt.Rectangle;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Brick extends JLabel {
    Rectangle r;
    boolean broken;
    public Brick(int x, int y) {
        this.r= new Rectangle (x, y, 89, 49);
        this.broken= false;
    }

    void reset() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
