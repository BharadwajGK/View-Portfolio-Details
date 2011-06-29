package Sample;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TransparentBackgroundImage
{
public static void main(String[] args) {
JFrame frame = new JFrame();
frame.addWindowListener( new WindowAdapter() {
public void windowClosing(WindowEvent e) {
Window win = e.getWindow();
win.setVisible(false);
win.dispose();
System.exit(0);
}
} );
JPanel panel=new JPanel(new GridLayout(2,2)){
ImageIcon image = new ImageIcon( "D:/rose.jpg" );
public void paint( Graphics g ) {
Dimension d = getSize();
for( int x = 0; x < d.width; x += image.getIconWidth() )
for( int y = 0; y < d.height; y += image.getIconHeight() )
g.drawImage( image.getImage(), x, y, null, null );
super.paint(g);
}
};
JLabel l1=new JLabel("Name");
JLabel l2=new JLabel("Address");
JTextField text=new JTextField(20);
JTextField text1=new JTextField(20);
panel.setOpaque(false);
text.setOpaque(false);
text1.setOpaque(false);
panel.add(l1);
panel.add(text);
panel.add(l2);
panel.add(text1);
frame.add( panel );

frame.pack();
frame.show();
}
}
