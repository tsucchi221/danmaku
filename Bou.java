import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Bou extends JPanel{
    int x,y,w,h;
    Image ima_devil;
    
    public Bou(){
	 ImageIcon icon=new ImageIcon("devil.gif");
	 ima_devil=icon.getImage();
	 x=-100;
	 y=-100;
	 w=ima_devil.getWidth(this);
	 h=ima_devil.getHeight(this);
    }
    public void PaintBaikin(Graphics g){
	g.drawImage(ima_devil, x, y, this);
    }
}


