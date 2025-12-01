import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Panel_start extends JPanel implements ActionListener,MouseListener,MouseMotionListener {
    MainFrame mf;
    private int x,y,screen_w,screen_h;
    private boolean range1,range2,range3;
    Image start,setting,exit;
    Timer timer;
    
    public Panel_start(MainFrame frame){
	mf = frame;
	ImageIcon icon1=new ImageIcon("start.png");
	start=icon1.getImage();
	ImageIcon icon2=new ImageIcon("setting.png");
	setting=icon2.getImage();
	ImageIcon icon3=new ImageIcon("exit.png");
	exit=icon3.getImage();

	timer=new Timer(100,this);
	timer.start();
	setBackground(Color.black);
	addMouseListener(this);
	addMouseMotionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
	if (range1) {
	    // Stage選択画面へ遷移
	    mf.panelChange("Stage選択画面");
	    range1=false;
	}
	if(range3){
	    System.exit(0);
	}

    }

    public void mouseClicked(MouseEvent e) {
	x=e.getX();
	y=e.getY();
	range1=x>screen_w/2-90&&x<screen_w+90&&y>screen_h/2+45&&y<screen_h+105;
	range2=x>screen_w/2-105&&x<screen_w+105&&y>screen_h/2+105&&y<screen_h+165;
	range3=x>screen_w/2-90&&x<screen_w+90&&y>screen_h/2+165&&y<screen_h+225;
	repaint();
	
    }
    public void mousePressed(MouseEvent e) { 
    }
    public void mouseReleased(MouseEvent e) {   
    }
    public void mouseEntered(MouseEvent e) {   
    }
    public void mouseExited(MouseEvent e) {   
    }
    public void mouseMoved(MouseEvent e){
    }
    public void mouseDragged(MouseEvent e) {   
    }
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
	Dimension d = getSize();
	g.setColor(Color.red);
	screen_w=d.width;
	screen_h=d.height;
	
	g.drawImage(start,screen_w/2-75,screen_h/2+60,this);
	g.drawImage(setting,screen_w/2-90,screen_h/2+120,this);
	g.drawImage(exit,screen_w/2-60,screen_h/2+180,this);
	//"イ"
	g.fillRect(d.width/2-300,50,10,20);
	g.fillRect(d.width/2-310,70,10,20);
	g.fillRect(d.width/2-320,90,10,10);
	g.fillRect(d.width/2-340,100,20,10);
	g.fillRect(d.width/2-370,110,30,10);
	g.fillRect(d.width/2-330,110,10,60);

	//"ラ"
	g.fillRect(d.width/2-260,60,60,10);
	g.fillRect(d.width/2-270,90,80,10);
	g.fillRect(d.width/2-200,100,10,20);
	g.fillRect(d.width/2-210,120,10,20);
	g.fillRect(d.width/2-220,140,10,10);
	g.fillRect(d.width/2-230,150,10,10);
	g.fillRect(d.width/2-250,160,20,10);

	//"イ"
	g.fillRect(d.width/2-100,50,10,20);
	g.fillRect(d.width/2-110,70,10,20);
	g.fillRect(d.width/2-120,90,10,10);
	g.fillRect(d.width/2-140,100,20,10);
	g.fillRect(d.width/2-170,110,30,10);
	g.fillRect(d.width/2-130,110,10,60);

	//"ラ"
	g.fillRect(d.width/2-60,60,60,10);
	g.fillRect(d.width/2-70,90,80,10);
	g.fillRect(d.width/2,100,10,20);
	g.fillRect(d.width/2-10,120,10,20);
	g.fillRect(d.width/2-20,140,10,10);
	g.fillRect(d.width/2-30,150,10,10);
	g.fillRect(d.width/2-50,160,20,10);

	g.setColor(Color.magenta);

	//"D"
	g.fillRect(d.width/2-100,d.height/2-120,10,110);
	g.fillRect(d.width/2-90,d.height/2-120,30,10);
	g.fillRect(d.width/2-60,d.height/2-110,20,10);
	g.fillRect(d.width/2-40,d.height/2-100,10,10);
	g.fillRect(d.width/2-30,d.height/2-90,10,50);
	g.fillRect(d.width/2-40,d.height/2-40,10,10);
	g.fillRect(d.width/2-60,d.height/2-30,20,10);
	g.fillRect(d.width/2-90,d.height/2-20,30,10);
	
	
	//"E"
	g.fillRect(d.width/2,d.height/2-120,10,110);
	g.fillRect(d.width/2+10,d.height/2-120,60,10);
	g.fillRect(d.width/2+10,d.height/2-70,60,10);
	g.fillRect(d.width/2+10,d.height/2-20,60,10);
	
	//"V"
	g.fillRect(d.width/2+100,d.height/2-120,10,10);
	g.fillRect(d.width/2+100,d.height/2-110,10,10);
	g.fillRect(d.width/2+110,d.height/2-100,10,10);
	g.fillRect(d.width/2+110,d.height/2-90,10,10);
	g.fillRect(d.width/2+120,d.height/2-80,10,10);
	g.fillRect(d.width/2+120,d.height/2-70,10,10);
	g.fillRect(d.width/2+130,d.height/2-60,10,10);
	g.fillRect(d.width/2+130,d.height/2-50,10,10);
	g.fillRect(d.width/2+140,d.height/2-40,10,10);
	g.fillRect(d.width/2+140,d.height/2-30,10,10);
	g.fillRect(d.width/2+150,d.height/2-20,10,10);
	g.fillRect(d.width/2+160,d.height/2-30,10,10);
	g.fillRect(d.width/2+160,d.height/2-40,10,10);
	g.fillRect(d.width/2+170,d.height/2-50,10,10);
	g.fillRect(d.width/2+170,d.height/2-60,10,10);
	g.fillRect(d.width/2+180,d.height/2-70,10,10);
	g.fillRect(d.width/2+180,d.height/2-80,10,10);
	g.fillRect(d.width/2+190,d.height/2-90,10,10);
	g.fillRect(d.width/2+190,d.height/2-100,10,10);
	g.fillRect(d.width/2+200,d.height/2-110,10,10);
	g.fillRect(d.width/2+200,d.height/2-120,10,10);

	//"I"
	g.fillRect(d.width/2+230,d.height/2-120,50,10);
	g.fillRect(d.width/2+250,d.height/2-120,10,110);
	g.fillRect(d.width/2+230,d.height/2-20,50,10);
	
	//"L"
	g.fillRect(d.width/2+310,d.height/2-120,10,110);
	g.fillRect(d.width/2+320,d.height/2-20,60,10);



    }
}
