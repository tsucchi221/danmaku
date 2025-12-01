import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Panel_countdown extends JPanel implements ActionListener {
    MainFrame mf;
    int panel_flg;
    int t = 4;
    Timer timer;
    
    public Panel_countdown(MainFrame frame){
	mf = frame;

	setBackground(Color.black);
	timer = new Timer(1000,this);	    
	timer.start();
    }

    public void actionPerformed(ActionEvent e) {
	if(e.getSource()==timer&&(panel_flg==10||panel_flg==20||panel_flg==30)){
	    t -= 1;
	    repaint();
	}

	if(t == -1&&panel_flg==10){
	    //Stage1へ遷移
	    mf.panelChange("Countdown");
	}

	if(t == -1&&panel_flg==20){
	    //Stage2へ遷移
	    mf.panelChange("Countdown");
	}

	if(t == -1&&panel_flg==30){
	    //Stage3へ遷移
	    mf.panelChange("Countdown");
	}	
    }

    public void paintComponent(Graphics g){
	Dimension d = getSize();
	super.paintComponent(g);

	g.setColor(Color.white);
	
	//"S"
	g.fillRect(d.width/2-250,d.height/2-200,10,10);
	g.fillRect(d.width/2-270,d.height/2-210,20,10);
	g.fillRect(d.width/2-290,d.height/2-220,20,10);
	g.fillRect(d.width/2-310,d.height/2-210,20,10);
	g.fillRect(d.width/2-320,d.height/2-200,10,10);
	g.fillRect(d.width/2-330,d.height/2-190,10,20);
	g.fillRect(d.width/2-320,d.height/2-170,10,10);
	g.fillRect(d.width/2-310,d.height/2-160,20,10);
	g.fillRect(d.width/2-290,d.height/2-150,20,10);
	g.fillRect(d.width/2-270,d.height/2-140,10,10);
	g.fillRect(d.width/2-260,d.height/2-130,10,10);
	g.fillRect(d.width/2-250,d.height/2-120,10,30);
	g.fillRect(d.width/2-270,d.height/2-90,20,10);
	g.fillRect(d.width/2-290,d.height/2-80,20,10);
	g.fillRect(d.width/2-310,d.height/2-90,20,10);
	g.fillRect(d.width/2-320,d.height/2-100,10,10);
	g.fillRect(d.width/2-330,d.height/2-110,10,10);
	    
	//"T"
	g.fillRect(d.width/2-230,d.height/2-210,110,10);
	g.fillRect(d.width/2-180,d.height/2-200,10,130);
	    
	//"A"
	g.fillRect(d.width/2-130,d.height/2-100,10,30);
	g.fillRect(d.width/2-120,d.height/2-110,10,10);
	g.fillRect(d.width/2-120,d.height/2-120,10,10);
	g.fillRect(d.width/2-110,d.height/2-130,10,10);
	g.fillRect(d.width/2-110,d.height/2-140,10,10);
	g.fillRect(d.width/2-100,d.height/2-150,10,10);
	g.fillRect(d.width/2-100,d.height/2-160,10,10);
	g.fillRect(d.width/2-90,d.height/2-170,10,10);
	g.fillRect(d.width/2-90,d.height/2-180,10,10);
	g.fillRect(d.width/2-80,d.height/2-190,10,10);
	g.fillRect(d.width/2-80,d.height/2-200,10,10);
	g.fillRect(d.width/2-70,d.height/2-210,10,10);
	g.fillRect(d.width/2-60,d.height/2-200,10,10);
	g.fillRect(d.width/2-60,d.height/2-190,10,10);
	g.fillRect(d.width/2-50,d.height/2-180,10,10);
	g.fillRect(d.width/2-50,d.height/2-170,10,10);
	g.fillRect(d.width/2-40,d.height/2-160,10,10);
	g.fillRect(d.width/2-40,d.height/2-150,10,10);
	g.fillRect(d.width/2-30,d.height/2-140,10,10);
	g.fillRect(d.width/2-30,d.height/2-130,10,10);
	g.fillRect(d.width/2-20,d.height/2-120,10,10);
	g.fillRect(d.width/2-20,d.height/2-110,10,10);
	g.fillRect(d.width/2-10,d.height/2-100,10,30);
	g.fillRect(d.width/2-100,d.height/2-140,70,10);
	
	//"G"
	g.fillRect(d.width/2+110,d.height/2-170,10,20);
	g.fillRect(d.width/2+100,d.height/2-180,10,10);
	g.fillRect(d.width/2+90,d.height/2-190,10,10);
	g.fillRect(d.width/2+70,d.height/2-200,20,10);
	g.fillRect(d.width/2+50,d.height/2-210,20,10);
	g.fillRect(d.width/2+30,d.height/2-200,20,10);
	g.fillRect(d.width/2+20,d.height/2-190,10,10);
	g.fillRect(d.width/2+10,d.height/2-180,10,20);
	g.fillRect(d.width/2,d.height/2-160,10,40);
	g.fillRect(d.width/2+10,d.height/2-120,10,20);
	g.fillRect(d.width/2+20,d.height/2-100,10,10);
	g.fillRect(d.width/2+30,d.height/2-90,20,10);
	g.fillRect(d.width/2+50,d.height/2-80,30,10);
	g.fillRect(d.width/2+80,d.height/2-90,20,10);
	g.fillRect(d.width/2+100,d.height/2-100,10,10);
	g.fillRect(d.width/2+110,d.height/2-130,10,30);
	g.fillRect(d.width/2+70,d.height/2-130,40,10);

	//"E"
	g.fillRect(d.width/2+140,d.height/2-210,10,140);
	g.fillRect(d.width/2+150,d.height/2-210,90,10);
	g.fillRect(d.width/2+150,d.height/2-145,90,10);
	g.fillRect(d.width/2+150,d.height/2-80,90,10);

	g.setColor(Color.green);
	if(panel_flg==10){
	//"1"
	g.fillRect(d.width/2+300,d.height/2-170,10,10);
	g.fillRect(d.width/2+310,d.height/2-180,10,10);
	g.fillRect(d.width/2+320,d.height/2-200,10,20);
	g.fillRect(d.width/2+330,d.height/2-210,10,10);
	g.fillRect(d.width/2+340,d.height/2-210,10,150);
	}
	
	g.setColor(Color.yellow);
	if(panel_flg==20){
	//"2"
	g.fillRect(d.width/2+270,d.height/2-190,10,10);
	g.fillRect(d.width/2+280,d.height/2-200,10,10);
	g.fillRect(d.width/2+290,d.height/2-210,20,10);
	g.fillRect(d.width/2+310,d.height/2-220,20,10);
	g.fillRect(d.width/2+330,d.height/2-210,20,10);
	g.fillRect(d.width/2+350,d.height/2-200,10,10);
	g.fillRect(d.width/2+360,d.height/2-190,10,30);
	g.fillRect(d.width/2+350,d.height/2-160,10,10);
	g.fillRect(d.width/2+340,d.height/2-150,10,10);
	g.fillRect(d.width/2+320,d.height/2-140,20,10);
	g.fillRect(d.width/2+300,d.height/2-130,20,10);
	g.fillRect(d.width/2+290,d.height/2-120,10,10);
	g.fillRect(d.width/2+280,d.height/2-110,10,20);
	g.fillRect(d.width/2+270,d.height/2-90,10,10);
	g.fillRect(d.width/2+270,d.height/2-80,100,10);	
	}

	g.setColor(Color.red);
	if(panel_flg==30){
	//"3"
	g.fillRect(d.width/2+270,d.height/2-190,10,10);
	g.fillRect(d.width/2+280,d.height/2-200,10,10);
	g.fillRect(d.width/2+290,d.height/2-210,20,10);
	g.fillRect(d.width/2+310,d.height/2-220,20,10);
	g.fillRect(d.width/2+330,d.height/2-210,20,10);
	g.fillRect(d.width/2+350,d.height/2-200,10,10);	
	g.fillRect(d.width/2+360,d.height/2-190,10,20);	
	g.fillRect(d.width/2+350,d.height/2-170,10,10);
	g.fillRect(d.width/2+330,d.height/2-160,20,10);
	g.fillRect(d.width/2+310,d.height/2-150,20,10);
	g.fillRect(d.width/2+280,d.height/2-140,30,10);
	g.fillRect(d.width/2+310,d.height/2-130,20,10);
	g.fillRect(d.width/2+330,d.height/2-120,20,10);
	g.fillRect(d.width/2+350,d.height/2-110,10,10);
	g.fillRect(d.width/2+360,d.height/2-100,10,20);
	g.fillRect(d.width/2+350,d.height/2-80,10,10);
	g.fillRect(d.width/2+330,d.height/2-70,20,10);
	g.fillRect(d.width/2+310,d.height/2-60,20,10);
	g.fillRect(d.width/2+290,d.height/2-70,20,10);
	g.fillRect(d.width/2+280,d.height/2-80,10,10);
	g.fillRect(d.width/2+270,d.height/2-90,10,10);
	}
	g.setColor(Color.white);
	    
	if(t == 1&&(panel_flg==10||panel_flg==20||panel_flg==30)){
        //Countdown"1"
	g.fillRect(d.width/2-20,d.height/2+70,10,10);
	g.fillRect(d.width/2-10,d.height/2+60,10,10);
	g.fillRect(d.width/2,d.height/2+40,10,20);
	g.fillRect(d.width/2+10,d.height/2+30,10,10);
	g.fillRect(d.width/2+20,d.height/2+30,10,150);
	}
	if(t == 2&&(panel_flg==10||panel_flg==20||panel_flg==30)){
	//Countdown"2"
	g.fillRect(d.width/2-50,d.height/2+60,10,10);
	g.fillRect(d.width/2-40,d.height/2+50,10,10);
	g.fillRect(d.width/2-30,d.height/2+40,20,10);
	g.fillRect(d.width/2-10,d.height/2+30,20,10);
	g.fillRect(d.width/2+10,d.height/2+40,20,10);
	g.fillRect(d.width/2+30,d.height/2+50,10,10);
	g.fillRect(d.width/2+40,d.height/2+60,10,30);
	g.fillRect(d.width/2+30,d.height/2+90,10,10);
	g.fillRect(d.width/2+20,d.height/2+100,10,10);
	g.fillRect(d.width/2,d.height/2+110,20,10);
	g.fillRect(d.width/2-20,d.height/2+120,20,10);
	g.fillRect(d.width/2-30,d.height/2+130,10,10);
	g.fillRect(d.width/2-40,d.height/2+140,10,20);
	g.fillRect(d.width/2-50,d.height/2+160,10,10);
	g.fillRect(d.width/2-50,d.height/2+170,100,10);
	}
	if (t == 3&&(panel_flg==10||panel_flg==20||panel_flg==30)){
        //Countdown"3"
	g.fillRect(d.width/2-50,d.height/2+50,10,10);
	g.fillRect(d.width/2-40,d.height/2+40,10,10);
	g.fillRect(d.width/2-30,d.height/2+30,20,10);
	g.fillRect(d.width/2-10,d.height/2+20,20,10);
	g.fillRect(d.width/2+10,d.height/2+30,20,10);
	g.fillRect(d.width/2+30,d.height/2+40,10,10);	
	g.fillRect(d.width/2+40,d.height/2+50,10,20);	
	g.fillRect(d.width/2+30,d.height/2+70,10,10);
	g.fillRect(d.width/2+10,d.height/2+80,20,10);
	g.fillRect(d.width/2-10,d.height/2+90,20,10);
	g.fillRect(d.width/2-40,d.height/2+100,30,10);
	g.fillRect(d.width/2-10,d.height/2+110,20,10);
	g.fillRect(d.width/2+10,d.height/2+120,20,10);
	g.fillRect(d.width/2+30,d.height/2+130,10,10);
	g.fillRect(d.width/2+40,d.height/2+140,10,20);
	g.fillRect(d.width/2+30,d.height/2+160,10,10);
	g.fillRect(d.width/2+10,d.height/2+170,20,10);
	g.fillRect(d.width/2-10,d.height/2+180,20,10);
	g.fillRect(d.width/2-30,d.height/2+170,20,10);
	g.fillRect(d.width/2-40,d.height/2+160,10,10);
	g.fillRect(d.width/2-50,d.height/2+150,10,10);
	}

	g.setColor(Color.yellow);
	if(t == 0&&(panel_flg==10||panel_flg==20||panel_flg==30)){
	//Countdown"GO"
	g.fillRect(d.width/2,d.height/2+60,10,20);
	g.fillRect(d.width/2-10,d.height/2+50,10,10);
	g.fillRect(d.width/2-20,d.height/2+40,10,10);
	g.fillRect(d.width/2-40,d.height/2+30,20,10);
	g.fillRect(d.width/2-60,d.height/2+20,20,10);
	g.fillRect(d.width/2-80,d.height/2+30,20,10);
	g.fillRect(d.width/2-90,d.height/2+40,10,10);
	g.fillRect(d.width/2-100,d.height/2+50,10,20);
	g.fillRect(d.width/2-110,d.height/2+70,10,40);
	g.fillRect(d.width/2-100,d.height/2+110,10,20);
	g.fillRect(d.width/2-90,d.height/2+130,10,10);
	g.fillRect(d.width/2-80,d.height/2+140,20,10);
	g.fillRect(d.width/2-60,d.height/2+150,30,10);
	g.fillRect(d.width/2-30,d.height/2+140,20,10);
	g.fillRect(d.width/2-10,d.height/2+130,10,10);
	g.fillRect(d.width/2,d.height/2+100,10,30);
	g.fillRect(d.width/2-40,d.height/2+100,40,10);

	g.fillRect(d.width/2+30,d.height/2+80,10,30);
	g.fillRect(d.width/2+40,d.height/2+60,10,20);
	g.fillRect(d.width/2+50,d.height/2+50,10,10);
	g.fillRect(d.width/2+60,d.height/2+40,20,10);
	g.fillRect(d.width/2+80,d.height/2+30,20,10);
	g.fillRect(d.width/2+100,d.height/2+40,20,10);
	g.fillRect(d.width/2+120,d.height/2+50,10,10);
	g.fillRect(d.width/2+130,d.height/2+60,10,20);
	g.fillRect(d.width/2+140,d.height/2+80,10,30);
	g.fillRect(d.width/2+130,d.height/2+110,10,20);
	g.fillRect(d.width/2+120,d.height/2+130,10,10);
	g.fillRect(d.width/2+100,d.height/2+140,20,10);
	g.fillRect(d.width/2+80,d.height/2+150,20,10);
	g.fillRect(d.width/2+60,d.height/2+140,20,10);
	g.fillRect(d.width/2+50,d.height/2+130,10,10);
	g.fillRect(d.width/2+40,d.height/2+110,10,20);
	}
	if (t==-1){
	    t = 4;
	}
    }
}
