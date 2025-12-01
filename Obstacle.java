import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Image;
import java.awt.geom.AffineTransform;

public class Obstacle extends JPanel{
    int ob_flg,level,x,y,width,height,velocity_x,velocity_y,velocity_w,velocity_h,theta,omega,ob_ani,ob_ani_flg,ob_ani_time,active_flg,moai_x,moai_y,moai_width,moai_height,timercounter;
    double x_double,y_double,width_double,height_double,velocity_double,random;
    Image img_moai_front,img_moai_back,img_moai_right,img_moai_left;
    
    public Obstacle(int flg,int stage_width,int screen_width,int screen_height,int difficulty){
	//基本設定
	ob_flg=flg;
	x_double=(stage_width-screen_width)*Math.random()+screen_width;
	x=(int)x_double;
	y_double=(screen_height-45)*Math.random()+45;
	y=(int)y_double;
	velocity_double=5*Math.random();
	velocity_x=(int)velocity_double;
	velocity_y=0;
	level=difficulty;
	
	ImageIcon icon1=new ImageIcon("Obstacle_Moai_front.png");
	img_moai_front=icon1.getImage();
	ImageIcon icon2=new ImageIcon("Obstacle_Moai_back.png");
	img_moai_back=icon2.getImage();
	ImageIcon icon3=new ImageIcon("Obstacle_Moai_right.png");
	img_moai_right=icon3.getImage();
	ImageIcon icon4=new ImageIcon("Obstacle_Moai_left.png");
	img_moai_left=icon4.getImage();

	
	switch(ob_flg){
	case 1:
	    //円形の障害物
	    width_double=60*Math.random()+40;
	    width=(int)width_double;
	    height=width;
	    break;
	case 2:
	    //四角形が回る障害物
	    width_double=40*Math.random();
	    width=(int)width_double;
	    height=width;
	    break;
	case 3:
	    //ビーム
	    random=Math.random();
	    if(random<0.25){
		x_double=screen_width*Math.random();
		x=(int)x_double;
		y=0;
		velocity_y=0;
		velocity_x=0;
		velocity_w=0;
		velocity_h=80;
		width=30;
		height=0;
		moai_width=0;
		moai_height=80;
		moai_x=x;
		moai_y=y;
		
	    }
	    if(random>=0.25&&random<0.5){
		x_double=screen_width*Math.random();
		x=(int)x_double;
		y=screen_height-80;
		velocity_y=-80;
		velocity_x=0;
		velocity_w=0;
		velocity_h=80;
		width=30;
		height=0;
		moai_width=0;
		moai_height=-80;
		moai_x=x;
		moai_y=y+moai_height;
	    }
	    if(random>=0.5&&random<0.75){
		x=0;
		y_double=screen_height*Math.random();
		y=(int)y_double;
		velocity_y=0;
		velocity_x=0;
		velocity_w=80;
		velocity_h=0;
		width=0;
		height=30;
		moai_width=32;
		moai_height=0;
		moai_x=x;
		moai_y=y;
	    }	
	    if(random>=0.75){
		x=screen_width-32;
		y_double=screen_height*Math.random();
		y=(int)y_double;
		velocity_y=0;
		velocity_x=-80;
		velocity_w=80;
		velocity_h=0;
		width=0;
		height=30;
		moai_width=-32;
		moai_height=0;
		moai_x=x+moai_width;
		moai_y=y;
	    }
	    break;
	case 4:
	    width_double=40*Math.random()+20;
	    width=(int)width_double;
	    height=width;
	    theta=(int)(6*Math.random())*60;
	    y=(int)((Math.sin(theta * Math.PI/180))*(screen_height-45-height)/2+(screen_height+45-height)/2);
	    break;
	case 5:
	    width_double=30*Math.random()+20;
	    width=(int)width_double;
	    height=width;
	    x=(int)((stage_width-screen_width)*Math.random()+screen_width);
	    y=(int)((screen_height-45)*Math.random()+45);
	    theta=0;
	    velocity_y=0;
	    break;
	case 6:
	    //ゴール
	    x=stage_width;
	    y=0;
	    width=30;
	    height=1000;
	    break;
	}
    }

    public void Move(int stage_width ,int difficulty){
	x-=5+7*difficulty;
	if(x>stage_width)x=stage_width;
	y+=velocity_y;
    }
    
    public void Move(int bou_x,int bou_y,int screen_width,int screen_height,int difficulty){
	if(ob_flg==1||ob_flg==4){
	    x-=5+velocity_x+7*difficulty;//速度調整
	}else{
	    x-=velocity_x;
	}
	y+=velocity_y;
	if(ob_flg==4){
	    theta+=5;
	    y=(int)((Math.sin(theta * Math.PI/180))*(screen_height-45-height)/2+(screen_height+45-height)/2);
	}else if(ob_flg==5){
	    if(screen_width-200<x&&x<screen_width){
		theta=(int)(Math.atan2(bou_y-y, bou_x-x)*180/Math.PI);
		if(theta<0)theta+=360;
		velocity_y=(int)(Math.sin(theta * Math.PI/180)*(20+10*difficulty));
	        velocity_x=-(int)(Math.cos(theta * Math.PI/180)*(20+10*difficulty));
	    }else if(x>screen_width){
	        velocity_x=6+7*difficulty;
	    }
	}
	if(theta>=360)theta=0;
    }

    public void Animation(int ob_flg){
	switch(ob_flg){
	case 1:
	    ob_ani=5;
	    if(ob_ani_flg==0){
		width-=ob_ani;
		height-=ob_ani;
		ob_ani_time+=1;
	    }
	    if(ob_ani_flg==1){
		width+=ob_ani;
		height+=ob_ani;
		ob_ani_time+=1;
	    }
	    if(ob_ani_time<10)ob_ani_flg=0;
	    else if(ob_ani_time<18)ob_ani_flg=1;
	    else ob_ani_time=0;
	    break;
	case 2:	    
	case 3:
	    if(active_flg==1){
		x+=velocity_x;
		y+=velocity_y;
		width+=velocity_w;
		height+=velocity_h;
	    }
	    double random_ob=Math.random();
	    if(random_ob<0.002*level&&active_flg==0&&timercounter==0){
		timercounter=1;
		active_flg=2;
	    }
	    if(timercounter>=1){
		timercounter+=1;
		if(timercounter>=10){
		    active_flg=1;
		    timercounter=11;
		}
	    }
	    if(random<0.25){
		if(height>1000)active_flg=3;
	    }
	    if(random>=0.25&&random<0.5){
		if(y<-500)active_flg=3;
	    }
	    if(random>=0.5&&random<0.75){
		if(width>1000)active_flg=3;
	    }	
	    if(random>=0.75){
		if(x<-500)active_flg=3;
	    }	

	    if(timercounter==11&&active_flg==3){
		active_flg=0;
		timercounter=0;
	    }
	    break;
	case 4:
	    break;
	case 5:
	    break;
	case 6:
	    break;
	}
    }
    
    //障害物の描画  
    public void PaintObstacle(Graphics g){

	switch(ob_flg){
	case 1:
	    g.setColor(Color.white);
	    g.fillOval(x,y,width,height);
	    break;
	case 2:
	    g.setColor(Color.white);
	    g.fillRect(x,y,width,height);
	    break;
	case 3:
	    if(active_flg==1){
		g.setColor(Color.white);
		g.fillRect(x+moai_width,y+moai_height,width,height);
	    }
	    if(active_flg==2&&(timercounter==1||timercounter==4)){}
	    if(active_flg==2&&(timercounter==1||timercounter==2||timercounter==5||timercounter==6||timercounter==9||timercounter==10)){
		g.setColor(Color.red);
		if(random<0.25){
		    g.drawLine(x+moai_width+width/2,y+moai_height,x+moai_width+width/2,1000);
		}
		if(random>=0.25&&random<0.5){
		    g.drawLine(x+moai_width+width/2,y+moai_height,x+moai_width+width/2,-100);
		}
		if(random>=0.5&&random<0.75){
		    g.drawLine(x+moai_width,y+moai_height+height/2,1000,y+moai_height+height/2);
		}	
		if(random>=0.75){
		    g.drawLine(x+moai_width,y+moai_height+height/2,-100,y+moai_height+height/2);
		}	
	    }
	    if(active_flg==1||active_flg==2){
		if(random<0.25){
		    g.drawImage(img_moai_front,moai_x,moai_y,this);
		}
		if(random>=0.25&&random<0.5){
		    g.drawImage(img_moai_back,moai_x,moai_y,this);
		}
		if(random>=0.5&&random<0.75){
		    g.drawImage(img_moai_right,moai_x,moai_y,this);
		}	
		if(random>=0.75){
		    g.drawImage(img_moai_left,moai_x,moai_y,this);
		}	
	    }
	    break;
	case 4:
	    g.setColor(Color.blue);
	    g.fillOval(x,y,width,height);
	    break;
	case 5:
	    g.setColor(Color.red);
	    g.fillOval(x,y,width,height);
	    break;
	case 6:
	    g.setColor(Color.green);
	    g.fillRect(x,0,width,height);
	    break;

	}
    }

    public void Reset(int stage_width,int screen_width,int screen_height){
	x_double=(stage_width-screen_width)*Math.random()+screen_width;
	x=(int)x_double;
	y_double=(screen_height-45)*Math.random()+45;
	y=(int)y_double;
	velocity_double=5*Math.random();
	velocity_x=(int)velocity_double;
	velocity_y=0;
	
	switch(ob_flg){
	case 1:
	    //円形の障害物
	    width_double=60*Math.random()+40;
	    width=(int)width_double;
	    height=width;
	    break;
	case 2:
	    //四角形が回る障害物
	    width_double=40*Math.random();
	    width=(int)width_double;
	    height=width;
	    break;
	case 3:
	    //ビーム
	    random=Math.random();
	    if(random<0.25){
		x_double=screen_width*Math.random();
		x=(int)x_double;
		y=0;
		velocity_y=0;
		velocity_x=0;
		velocity_w=0;
		velocity_h=80;
		width=30;
		height=0;
		moai_width=0;
		moai_height=80;
		moai_x=x;
		moai_y=y;
		
	    }
	    if(random>=0.25&&random<0.5){
		x_double=screen_width*Math.random();
		x=(int)x_double;
		y=screen_height;
		velocity_y=-80;
		velocity_x=0;
		velocity_w=0;
		velocity_h=80;
		width=30;
		height=0;
		moai_width=0;
		moai_height=-80;
		moai_x=x;
		moai_y=y+moai_height;
	    }
	    if(random>=0.5&&random<0.75){
		x=0;
		y_double=screen_height*Math.random();
		y=(int)y_double;
		velocity_y=0;
		velocity_x=0;
		velocity_w=80;
		velocity_h=0;
		width=0;
		height=30;
		moai_width=32;
		moai_height=0;
		moai_x=x;
		moai_y=y;
	    }	
	    if(random>=0.75){
		x=screen_width;
		y_double=screen_height*Math.random();
		y=(int)y_double;
		velocity_y=0;
		velocity_x=-80;
		velocity_w=80;
		velocity_h=0;
		width=0;
		height=30;
		moai_width=-32;
		moai_height=0;
		moai_x=x+moai_width;
		moai_y=y;
	    }
	    break;
	case 4:
	    width_double=40*Math.random()+20;
	    width=(int)width_double;
	    height=width;
	    theta=(int)(6*Math.random())*60;
	    y=(int)((Math.sin(theta * Math.PI/180))*(screen_height-45-height)/2+(screen_height+45-height)/2);
	    break;
	case 5:
	    width_double=30*Math.random()+20;
	    width=(int)width_double;
	    height=width;
	    x=(int)((stage_width-screen_width)*Math.random()+screen_width);
	    y=(int)((screen_height-40)*Math.random()+40);
	    theta=0;
	    velocity_y=0;
	    break;

	case 6:
	    //ゴール
	    x=20000;
	    y=0;
	    width=30;
	    height=1000;
	}
    }

    public void DebugLog(){
	System.out.println("object flag:"+ob_flg);
	System.out.println("x:"+x);
	System.out.println("y:"+y);
	System.out.println("velocity x:"+velocity_x);
	System.out.println("velocity y:"+velocity_y);
	System.out.println("width:"+width);
	System.out.println("height:"+height);
    }
}
