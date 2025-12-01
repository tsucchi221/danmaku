import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
    
public class MainFrame extends JFrame implements ActionListener{
    Panel_start p0;
    Panel_level p01;
    Panel_stage p1,p2,p3;
    Panel_clear p4;
    Panel_gameover p5;
    Panel_countdown p6;
    CardLayout card;
    JPanel p;
    int panel_flg_main;
    BGM bgm1,bgm2,bgm3,bgm_gameover,bgm_clear;
    int level;

    public MainFrame(){
	setSize(1000,700);
	setTitle("Java Programing");
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	
	p = new JPanel();
	p0 = new Panel_start(this);
	p01 = new Panel_level(this);
	p1 = new Panel_stage(this,1);
	p2=new Panel_stage(this,2);
	p3=new Panel_stage(this,3);
	p4 = new Panel_clear(this);
	p5 = new Panel_gameover(this);
	p6 = new Panel_countdown(this);
	
	card = new CardLayout();
	p.setLayout(card);
	p.add(p0, "panel0");
	p.add(p01, "panel01");
	p.add(p1, "panel1");
	p.add(p2, "panel2");
        p.add(p3, "panel3");
	p.add(p4, "panel4");
	p.add(p5, "panel5");
	p.add(p6, "panel6");
	Container c = getContentPane();
	c.add(p);

	bgm1=new BGM("BGM1.wav");
	bgm2=new BGM("BGM2.wav");
	bgm3=new BGM("BGM3.wav");
	bgm_gameover=new BGM("BGM_gameover.wav");
	bgm_clear=new BGM("BGM_clear.wav");
	setVisible(true);
	setBackground(Color.black);
    }
    
    public void actionPerformed(ActionEvent e){}
    
    public void panelChange(String str) {
	if (str=="Start画面"){
	    card.show(p, "panel0");
	    panel_flg_main=0;
	}
	if (str=="Stage選択画面"){
	    card.show(p, "panel01");
	    panel_flg_main=0;
	}
	if (str=="Stage1"){
	    card.show(p, "panel6");
	    panel_flg_main=10;
	    bgm1.start();
	    bgm2.stop();
	    bgm3.stop();
	    bgm_gameover.stop();
	    bgm_clear.stop();
	}
	if (str=="Stage2"){
	    card.show(p, "panel6");
	    panel_flg_main=20;
	    bgm1.stop();
	    bgm2.start();
	    bgm3.stop();
	    bgm_gameover.stop();
	    bgm_clear.stop();
	}
	if (str=="Stage3"){
	    card.show(p, "panel6");
	    panel_flg_main=30;
	    bgm1.stop();
	    bgm2.stop();
	    bgm3.start();	    
	    bgm_gameover.stop();
	    bgm_clear.stop();
	}
	if (str=="Clear画面"){
	    card.show(p, "panel4");
	    panel_flg_main=4;
	    bgm1.stop();
	    bgm2.stop();
	    bgm3.stop();
	    bgm_gameover.stop();
	    bgm_clear.start();
	    	    
	}
	if (str=="Gameover画面"){
	    card.show(p, "panel5");
	    panel_flg_main=0;
	    bgm1.stop();
	    bgm2.stop();
	    bgm3.stop();
	    bgm_gameover.start();
	    bgm_clear.stop();
	}

	if(str=="Countdown"){
	    card.show(p, "panel1");
	    if(panel_flg_main==10){
		p1.level=1;
		panel_flg_main=1;
	    }
	    if(panel_flg_main==20){
		p1.level=2;
		panel_flg_main=2;
	    }
	    if(panel_flg_main==30){
		p1.level=3;
		panel_flg_main=3;
	    }
	}
	p1.panel_flg=panel_flg_main;
	p2.panel_flg=panel_flg_main;
	p3.panel_flg=panel_flg_main;
	p4.panel_flg=panel_flg_main;
	p6.panel_flg=panel_flg_main;
    }

    public static void main(String[] args) {
	new MainFrame();
    }
}
