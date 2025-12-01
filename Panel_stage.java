import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Panel_stage extends JPanel implements ActionListener,MouseListener, MouseMotionListener{
    int level,ob1_number,ob3_number,ob4_number,ob5_number,debugtimer_counter,panel_flg,screen_width,screen_height,stage_width,ob_all_number,judge_flg,goal_flg;
    final int MAX_OB_NUM=125;
    double random;
    Obstacle[] ob1,ob3,ob4,ob5;
    Obstacle ob1_temp,ob3_temp,ob4_temp,ob5_temp,ob_goal;
    Timer timer,timer_debug;
    Bou bou;
    Humen humen1;
    Judge judge;
    Image stage,num1,num2,num3,score,num0,life,heart;
    MainFrame mf;  //<-- mainメソッドのある、「フレーム」のクラス
                   //    この「フレーム」に、”画面１(このPanel_1のこと)” や ”画面２” などの「パネル」が貼られている

    public Panel_stage(MainFrame frame, int level_argument){
	mf = frame;   // MainFrameクラスで,  p1 = new Panel_1(this); として引数にthis(<--MainFrame)を渡している．　それを変数に入れて保持．
	level=level_argument;

	bou=new Bou();
	screen_width=1000;
	screen_height=700;
	if(level==1)stage_width=5000;
	if(level==2)stage_width=10000;
	if(level==3)stage_width=20000;
	ob1_number=level*50-25;
	ob3_number=level*50-25;
	ob4_number=level*50-25;
	ob5_number=level*50-25;

	humen1=new Humen(level,0);	
	ob1=new Obstacle[MAX_OB_NUM];
	ob3=new Obstacle[MAX_OB_NUM];
	ob4=new Obstacle[MAX_OB_NUM];
	ob5=new Obstacle[MAX_OB_NUM];
	ob_goal=new Obstacle(6,stage_width,screen_width,screen_height,level);

	for(int i=0;i<MAX_OB_NUM;i++){
	    ob1_temp=new Obstacle(1,stage_width,screen_width,screen_height,level);
	    ob1[i]=ob1_temp;
	}
	for(int i=0;i<MAX_OB_NUM;i++){
	    ob3_temp=new Obstacle(3,stage_width,screen_width,screen_height,level);
	    ob3[i]=ob3_temp;
	}
	for(int i=0;i<MAX_OB_NUM;i++){
	    ob4_temp=new Obstacle(4,stage_width,screen_width,screen_height,level);
	    ob4[i]=ob4_temp;
	}
	for(int i=0;i<MAX_OB_NUM;i++){
	    ob5_temp=new Obstacle(5,stage_width,screen_width,screen_height,level);
	    ob5[i]=ob5_temp;
	}

	ImageIcon icon1=new ImageIcon("stage.png");
	stage=icon1.getImage();
	ImageIcon icon2=new ImageIcon("1.png");
	num1=icon2.getImage();
	ImageIcon icon3=new ImageIcon("2.png");
	num2=icon3.getImage();
	ImageIcon icon4=new ImageIcon("3.png");
	num3=icon4.getImage();
	ImageIcon icon5=new ImageIcon("score.png");
	score=icon5.getImage();
	ImageIcon icon6=new ImageIcon("00000.png");
	num0=icon6.getImage();
	ImageIcon icon7=new ImageIcon("life.png");
	life=icon7.getImage();
	ImageIcon icon8=new ImageIcon("heart.jpeg");
	heart=icon8.getImage();
	
	setBackground(Color.black);
	
	timer=new Timer(100,this);
	timer.start();
	timer_debug=new Timer(3000,this);
	timer_debug.start();
	timer_debug.stop();

	addMouseListener(this);
	addMouseMotionListener(this);
    }
    
    public void actionPerformed(ActionEvent e) {
	if(e.getSource()==timer&&(panel_flg==1||panel_flg==2||panel_flg==3)){
	    for(int i=0;i<ob1_number;i++){
		ob1[i].Move(bou.x,bou.y,screen_width,screen_height,level);
		ob1[i].Animation(1);
		judge=new Judge(1,ob1[i].x,bou.x,ob1[i].y,bou.y,ob1[i].width,ob1[i].height,bou.w,bou.h);	
		judge.Flg();
		judge_flg+=judge.j_flg;
	    }
	    for(int i=0;i<ob3_number;i++){
		ob3[i].Animation(3);
		if(ob3[i].active_flg==1&&ob3[i].timercounter>=1){
		    judge=new Judge(3,ob3[i].x,bou.x,ob3[i].y,bou.y,ob3[i].width,ob3[i].height,bou.w,bou.h);
		    judge.Flg();
		    judge_flg+=judge.j_flg;
		}
	    }
	    for(int i=0;i<ob4_number;i++){
		ob4[i].Move(bou.x,bou.y,screen_width,screen_height,level);
		judge=new Judge(1,ob4[i].x,bou.x,ob4[i].y,bou.y,ob4[i].width,ob4[i].height,bou.w,bou.h);
		judge.Flg();
		judge_flg+=judge.j_flg;
	    }
	    for(int i=0;i<ob5_number;i++){
		ob5[i].Move(bou.x,bou.y,screen_width,screen_height,level);
		judge=new Judge(1,ob5[i].x,bou.x,ob5[i].y,bou.y,ob5[i].width,ob5[i].height,bou.w,bou.h);
		judge.Flg();
		judge_flg+=judge.j_flg;
	    }
	    ob_goal.Move(stage_width,level);
	    judge=new Judge(3,ob_goal.x,bou.x,ob_goal.y,bou.y,ob_goal.width,ob_goal.height,bou.w,bou.h);
	    judge.Flg();
	    goal_flg+=judge.j_flg;
	    humen1.Move();
	}
	if(e.getSource()==timer_debug){
	    for(int i=0;i<ob1_number/10;i++){
		System.out.println("Object Number:"+(i+1));
		ob1[i].DebugLog();
		System.out.println("judge_flg"+judge_flg);
		System.out.println();
	    }
	}

	if (goal_flg==1) {
	    // Clear画面へ遷移
	    mf.panelChange("Clear画面");
	    goal_flg=0;
	    for(int i=0;i<MAX_OB_NUM;i++){
		ob1[i].Reset(stage_width,screen_width,screen_height);
	    }
	    for(int i=0;i<MAX_OB_NUM;i++){
		ob3[i].Reset(stage_width,screen_width,screen_height);
	    }
	    for(int i=0;i<MAX_OB_NUM;i++){
		ob4[i].Reset(stage_width,screen_width,screen_height);
	    }
	    for(int i=0;i<MAX_OB_NUM;i++){
		ob5[i].Reset(stage_width,screen_width,screen_height);
	    }
	    ob_goal.Reset(stage_width,screen_width,screen_height);
	}
	if(judge_flg>=3){
	    // Gameover画面へ遷移
	    mf.panelChange("Gameover画面");
	    judge_flg=0;
	    for(int i=0;i<MAX_OB_NUM;i++){
		ob1[i].Reset(stage_width,screen_width,screen_height);
	    }
	    for(int i=0;i<MAX_OB_NUM;i++){
		ob3[i].Reset(stage_width,screen_width,screen_height);
	    }
	    for(int i=0;i<MAX_OB_NUM;i++){
		ob4[i].Reset(stage_width,screen_width,screen_height);
	    }
	    for(int i=0;i<MAX_OB_NUM;i++){
		ob5[i].Reset(stage_width,screen_width,screen_height);
	    }
	    ob_goal.Reset(stage_width,screen_width,screen_height);
	}

	repaint();
    }
    
    // 画面へ描画するプログラムはこのメソッドの中に書く
    public void paintComponent(Graphics g) {
	Dimension d=getSize();
	super.paintComponent(g);

	g.drawImage(stage,30,15,this);
	switch(level){
	case 1:
	    g.drawImage(num1,180,15,this);
	    break;
	case 2:
	    g.drawImage(num2,180,15,this);
	    break;
	case 3:
	    g.drawImage(num3,180,15,this);
	}
	g.drawImage(score,300,15,this);
	g.drawImage(num0,480,15,this);
	g.drawImage(life,650,15,this);
	switch(judge_flg){
	case 0:
	    g.drawImage(heart,800,15,this);
	case 1:
	    g.drawImage(heart,850,15,this);
	case 2:
	    g.drawImage(heart,900,15,this);
	}

	
	bou.PaintBaikin(g);
	g.drawLine(0,600,1000,600);
	humen1.PaintHumen(g);
	for(int i=0;i<ob1_number;i++){
	    ob1[i].PaintObstacle(g);
	}
	for(int i=0;i<ob3_number;i++){
	    ob3[i].PaintObstacle(g);
	}
	for(int i=0;i<ob4_number;i++){
	    ob4[i].PaintObstacle(g);
	}
	for(int i=0;i<ob5_number;i++){
	    ob5[i].PaintObstacle(g);
	}
	ob_goal.PaintObstacle(g);
    }
    
    public void mouseClicked(MouseEvent e) { 
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
	bou.x=e.getX();
	bou.y=e.getY();
	repaint();
    }
    public void mouseDragged(MouseEvent e) {   
    }
}
