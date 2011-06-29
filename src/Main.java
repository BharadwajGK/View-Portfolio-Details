import java.awt.*;
import javax.swing.*;

public class Main extends JFrame
{
public Main()
{
setSize(500,500);
JPanel panel = new JPanel();
panel.setBackground(Color.CYAN);
ImageIcon icon = new ImageIcon("C:\\Documents and Settings\\All Users\\Documents\\My Pictures\\Sample Pictures\\Sunset.jpg");
JLabel label = new JLabel();
label.setIcon(icon);
//panel.add(label);
this.getContentPane().add(label);


setVisible(true);
}
public static void main (String[] args) // no args expected
{
new Main();
} // end main
} // end class ImageDisplay
