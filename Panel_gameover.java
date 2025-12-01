import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Panel_gameover extends JPanel implements ActionListener,MouseListener,MouseMotionListener {
    MainFrame mf;
    private int x,y,screen_w,screen_h;
    private boolean range1,range3;
    Image top,exit;
    Timer timer;

    
    public Panel_gameover(MainFrame frame){
	mf = frame;

	ImageIcon icon1=new ImageIcon("top.png");
	top=icon1.getImage();	
	ImageIcon icon3=new ImageIcon("exit.png");
	exit=icon3.getImage();

	timer = new Timer(100,this);
	timer.start();
	
	addMouseListener(this);
	addMouseMotionListener(this);
	setBackground(Color.black);
    }

    public void actionPerformed(ActionEvent e) {
	if (range1) {
	    // Start画面へ遷移
	    mf.panelChange("Start画面");
	    range1=false;
	}
	if(range3){
	    System.exit(0);
	}
    }
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
	Dimension d = getSize();

	screen_w=d.width;
	screen_h=d.height;
	
	g.drawImage(exit,screen_w/2-40,screen_h/2+220,this);
	g.drawImage(top,screen_w/2-50,screen_h/2+100,this);
        g.setColor(Color.red);
	//"G"
	g.fillRect(d.width/2-330,d.height/2-90,10,10);
	g.fillRect(d.width/2-340,d.height/2-100,10,10);
	g.fillRect(d.width/2-350,d.height/2-110,10,10);
	g.fillRect(d.width/2-360,d.height/2-120,10,10);
	g.fillRect(d.width/2-370,d.height/2-120,10,10);
	g.fillRect(d.width/2-380,d.height/2-120,10,10);
	g.fillRect(d.width/2-390,d.height/2-110,10,10);
	g.fillRect(d.width/2-400,d.height/2-100,10,10);
	g.fillRect(d.width/2-410,d.height/2-90,10,10);
	g.fillRect(d.width/2-410,d.height/2-80,10,10);
	g.fillRect(d.width/2-410,d.height/2-70,10,10);
	g.fillRect(d.width/2-410,d.height/2-60,10,10);
	g.fillRect(d.width/2-410,d.height/2-50,10,10);
	g.fillRect(d.width/2-400,d.height/2-40,10,10);
	g.fillRect(d.width/2-390,d.height/2-30,10,10);
	g.fillRect(d.width/2-380,d.height/2-20,10,10);
	g.fillRect(d.width/2-370,d.height/2-20,10,10);
	g.fillRect(d.width/2-360,d.height/2-20,10,10);
	g.fillRect(d.width/2-350,d.height/2-20,10,10);
	g.fillRect(d.width/2-340,d.height/2-20,10,10);
	g.fillRect(d.width/2-330,d.height/2-20,10,10);
	g.fillRect(d.width/2-330,d.height/2-30,10,10);
	g.fillRect(d.width/2-330,d.height/2-40,10,10);
	g.fillRect(d.width/2-330,d.height/2-50,10,10);
	g.fillRect(d.width/2-330,d.height/2-60,10,10);
	g.fillRect(d.width/2-340,d.height/2-60,10,10);
	g.fillRect(d.width/2-350,d.height/2-60,10,10);

	//"A"
	g.fillRect(d.width/2-310,d.height/2-20,10,10);
	g.fillRect(d.width/2-310,d.height/2-30,10,10);
	g.fillRect(d.width/2-300,d.height/2-40,10,10);
	g.fillRect(d.width/2-300,d.height/2-50,10,10);
	g.fillRect(d.width/2-290,d.height/2-60,10,10);
	g.fillRect(d.width/2-290,d.height/2-70,10,10);
	g.fillRect(d.width/2-280,d.height/2-80,10,10);
	g.fillRect(d.width/2-280,d.height/2-90,10,10);
	g.fillRect(d.width/2-270,d.height/2-100,10,10);
	g.fillRect(d.width/2-270,d.height/2-110,10,10);
	g.fillRect(d.width/2-260,d.height/2-120,10,10);
	g.fillRect(d.width/2-250,d.height/2-110,10,10);
	g.fillRect(d.width/2-250,d.height/2-100,10,10);
	g.fillRect(d.width/2-240,d.height/2-90,10,10);
	g.fillRect(d.width/2-240,d.height/2-80,10,10);
	g.fillRect(d.width/2-230,d.height/2-70,10,10);
	g.fillRect(d.width/2-230,d.height/2-60,10,10);
	g.fillRect(d.width/2-220,d.height/2-50,10,10);
	g.fillRect(d.width/2-220,d.height/2-40,10,10);
	g.fillRect(d.width/2-210,d.height/2-30,10,10);
	g.fillRect(d.width/2-210,d.height/2-20,10,10);
	g.fillRect(d.width/2-280,d.height/2-60,10,10);
	g.fillRect(d.width/2-270,d.height/2-60,10,10);
	g.fillRect(d.width/2-260,d.height/2-60,10,10);
	g.fillRect(d.width/2-250,d.height/2-60,10,10);
	g.fillRect(d.width/2-240,d.height/2-60,10,10);

	//"M"
	g.fillRect(d.width/2-190,d.height/2-120,10,110);
	
	g.fillRect(d.width/2-180,d.height/2-110,10,10);
	g.fillRect(d.width/2-180,d.height/2-100,10,10);
	g.fillRect(d.width/2-170,d.height/2-90,10,10);
	g.fillRect(d.width/2-170,d.height/2-80,10,10);
	g.fillRect(d.width/2-160,d.height/2-70,10,10);
	g.fillRect(d.width/2-160,d.height/2-60,10,10);
	g.fillRect(d.width/2-150,d.height/2-50,10,10);
	g.fillRect(d.width/2-150,d.height/2-40,10,10);
	g.fillRect(d.width/2-140,d.height/2-30,10,10);
	g.fillRect(d.width/2-140,d.height/2-20,10,10);
	g.fillRect(d.width/2-130,d.height/2-40,10,10);
	g.fillRect(d.width/2-130,d.height/2-50,10,10);
	g.fillRect(d.width/2-120,d.height/2-60,10,10);
	g.fillRect(d.width/2-120,d.height/2-70,10,10);
	g.fillRect(d.width/2-110,d.height/2-80,10,10);
	g.fillRect(d.width/2-110,d.height/2-90,10,10);
	g.fillRect(d.width/2-100,d.height/2-100,10,10);
	g.fillRect(d.width/2-100,d.height/2-110,10,10);
	g.fillRect(d.width/2-90,d.height/2-120,10,10);
      
	g.fillRect(d.width/2-90,d.height/2-120,10,110);

	//"E"
	g.fillRect(d.width/2-70,d.height/2-120,10,110);
	g.fillRect(d.width/2-60,d.height/2-120,60,10);
	g.fillRect(d.width/2-60,d.height/2-70,60,10);
	g.fillRect(d.width/2-60,d.height/2-20,60,10);

	//"O"
	g.fillRect(d.width/2+10,d.height/2-80,10,10);
	g.fillRect(d.width/2+10,d.height/2-70,10,10);
	g.fillRect(d.width/2+10,d.height/2-60,10,10);
	g.fillRect(d.width/2+20,d.height/2-50,10,10);
	g.fillRect(d.width/2+20,d.height/2-40,10,10);
	g.fillRect(d.width/2+30,d.height/2-30,10,10);
	g.fillRect(d.width/2+40,d.height/2-20,10,10);
	g.fillRect(d.width/2+50,d.height/2-20,10,10);
	g.fillRect(d.width/2+60,d.height/2-20,10,10);
	g.fillRect(d.width/2+70,d.height/2-30,10,10);
	g.fillRect(d.width/2+80,d.height/2-40,10,10);
	g.fillRect(d.width/2+80,d.height/2-50,10,10);
	g.fillRect(d.width/2+90,d.height/2-60,10,10);
	g.fillRect(d.width/2+90,d.height/2-70,10,10);
	g.fillRect(d.width/2+90,d.height/2-80,10,10);
	g.fillRect(d.width/2+80,d.height/2-90,10,10);
	g.fillRect(d.width/2+80,d.height/2-100,10,10);
	g.fillRect(d.width/2+70,d.height/2-110,10,10);
	g.fillRect(d.width/2+60,d.height/2-120,10,10);
	g.fillRect(d.width/2+50,d.height/2-120,10,10);
	g.fillRect(d.width/2+40,d.height/2-120,10,10);
	g.fillRect(d.width/2+30,d.height/2-110,10,10);
	g.fillRect(d.width/2+20,d.height/2-100,10,10);
	g.fillRect(d.width/2+20,d.height/2-90,10,10);

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

	//"E"
	g.fillRect(d.width/2+220,d.height/2-120,10,110);
	g.fillRect(d.width/2+230,d.height/2-120,60,10);
	g.fillRect(d.width/2+230,d.height/2-70,60,10);
	g.fillRect(d.width/2+230,d.height/2-20,60,10);

	//"R"
	g.fillRect(d.width/2+300,d.height/2-120,10,110);
	g.fillRect(d.width/2+310,d.height/2-120,60,10);
	g.fillRect(d.width/2+370,d.height/2-110,10,10);
	g.fillRect(d.width/2+380,d.height/2-100,10,20);
	g.fillRect(d.width/2+370,d.height/2-80,10,10);
	g.fillRect(d.width/2+310,d.height/2-70,60,10);
	g.fillRect(d.width/2+340,d.height/2-60,10,10);
	g.fillRect(d.width/2+340,d.height/2-50,20,10);
	g.fillRect(d.width/2+350,d.height/2-40,20,10);
	g.fillRect(d.width/2+360,d.height/2-30,20,10);
	g.fillRect(d.width/2+370,d.height/2-20,20,10);
    }
    public void mouseClicked(MouseEvent e) {
	x=e.getX();
	y=e.getY();
	range1=x>screen_w/2-90&&x<screen_w+90&&y>screen_h/2+75&&y<screen_h+145;
	range3=x>screen_w/2-90&&x<screen_w+90&&y>screen_h/2+185&&y<screen_h+265;
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
    
}
