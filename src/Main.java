import javax.swing.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        MovingBall mainWindow = new MovingBall();
        mainWindow.setTitle("Moving ball");
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWindow.setSize(400, 400);
//        mainWindow.pack();
        mainWindow.setVisible(true);
        mainWindow.getBallPanel().move();
    }
}