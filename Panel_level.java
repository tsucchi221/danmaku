import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Panel_level extends JPanel implements ActionListener,MouseListener,MouseMotionListener {
    JButton bt1, bt2, bt3;
    MainFrame mf;
    private int x,y,cx,cy;
    BGM beep;
    boolean range1,range2,range3,range_c1,range_c2,range_c3,range_c4;
    Timer timer;
    Image select,level,num1,num2,num3,score,best_s,back;

    public Panel_level(MainFrame frame){
	mf = frame;	
	beep=new BGM("beep.wav");

	ImageIcon icon1=new ImageIcon("level.png");
	level=icon1.getImage();
	ImageIcon icon2=new ImageIcon("Stage Select.png");
	select=icon2.getImage();
	ImageIcon icon3=new ImageIcon("1.png");
	num1=icon3.getImage();
	ImageIcon icon4=new ImageIcon("2.png");
	num2=icon4.getImage();
	ImageIcon icon5=new ImageIcon("3.png");
	num3=icon5.getImage();
	ImageIcon icon6=new ImageIcon("best score.png");
	best_s=icon6.getImage();
	ImageIcon icon7=new ImageIcon("00000.png");
	score=icon7.getImage();
	ImageIcon icon8=new ImageIcon("back.png");
	back=icon8.getImage();

	
	
	timer=new Timer(100,this);
	timer.start();
	setBackground(Color.black);
	addMouseListener(this);
	addMouseMotionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
	if (range_c1) {
	    // Stage1へ遷移
	    mf.panelChange("Stage1");
	    range_c1=false;
	}
	if (range_c2) {
	    // Stage2へ遷移
	    mf.panelChange("Stage2");
	    range_c2=false;
	}
	if (range_c3) {
	    // Stage3へ遷移
	    mf.panelChange("Stage3");
	    range_c3=false;
	}
	if(range_c4){
	    mf.panelChange("Start画面");
	    range_c4=false;
	}
    }
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.white);
	g.drawImage(select,350,20,this);

	for(int i=0;i<3;i++){
	    g.drawImage(level,300,80+(210*i),this);
	    g.drawImage(best_s,300,150+(210*i),this);
	    g.drawImage(score,550,150+(210*i),this);
	}
	g.drawImage(num1,430,80,this);
	g.drawImage(num2,430,290,this);
	g.drawImage(num3,430,500,this);
	g.drawImage(back,50,560,this);
	g.fillRect(50,600,50,10);
	g.fillRect(90,600,10,50);
	g.fillRect(60,640,40,10);
	g.fillRect(50,644,2,2);
	g.fillRect(52,642,2,6);
	g.fillRect(54,640,2,10);
	g.fillRect(56,638,2,14);
	g.fillRect(58,636,2,18);
	
	if(range1){g.setColor(Color.yellow);
	}else{ g.setColor(Color.white);}
	g.fillRect(200,50,600,3);
	g.fillRect(200,50,3,190);
	g.fillRect(200,240,600,3);
	g.fillRect(800,50,3,193);

	if(range2){g.setColor(Color.yellow);
	}else{ g.setColor(Color.white);}
	g.fillRect(200,260,600,3);
	g.fillRect(200,260,3,190);
	g.fillRect(200,450,600,3);
	g.fillRect(800,260,3,193);

	if(range3){g.setColor(Color.yellow);
	}else{ g.setColor(Color.white);}
	g.fillRect(200,470,600,3);
	g.fillRect(200,470,3,190);
	g.fillRect(200,660,600,3);
	g.fillRect(800,470,3,193);
	
    }
    	public void mouseClicked(MouseEvent e) {
	    cx=e.getX();
	    cy=e.getY();
	    range_c1=cx>200&&cx<800&&cy>50&&cy<250;
	    range_c2=cx>200&&cx<800&&cy>260&&cy<450;
	    range_c3=cx>200&&cx<800&&cy>470&&cy<670;
	    range_c4=cx>0&&cx<200&&cy>550&&cy<700;
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
	    x=e.getX();
	    y=e.getY();
	    range1=x>200&&x<800&&y>50&&y<250;
	    range2=x>200&&x<800&&y>260&&y<450;
	    range3=x>200&&x<800&&y>470&&y<660;
	    repaint();
	}
	public void mouseDragged(MouseEvent e) {   
	}
}
