public class Judge{
    int jx1,jx2,jy1,jy2,j_flg,job_flg,jw,jh,R,w_bou,h_bou,jx3,jy3,jx4,jy4,r;
    double dist;
    
    public  Judge(int ob_flg,int x1,int x2,int y1,int y2,int w,int h,int w_bou,int h_bou){
	jx1 = x1;
	jx2 = x2;
	jy1 = y1;
	jy2 = y2;
	job_flg = ob_flg;
	jw = w;
	jh = h;
	dist = Math.sqrt((x1+w/2-x2-w_bou/2)*(x1+w/2-x2-w_bou/2) + (y1+h/2-y2-h_bou/2)*(y1+h/2-y2-h_bou/2));
	jx3 = x1 + w;
	jy3 = y1 + h;
	jx4 = x2 + w_bou;
	jy4 = y2 + h_bou;
	
	switch(job_flg){
	case 1:
	    R = jw/2;
	    r=w_bou/2;
	    break;
	case 2 :
	    if(jw<jh){
		R = jw/2;
	    }else{
		R = jh/2;
	    }
	    break;
	    
	}

    }
    public void Flg(){
	switch(job_flg){
	case 1:
     	    if(dist < R+r &&jx2>0&&jy2>0){ //条件式後半は、マウス座標初期化の際に当たり判定をさせないため
		j_flg=1;
	    }else{
		j_flg=0;
	    }
	    break;
	
	case 2:
	    if(dist < 2*R){
	    j_flg=1;
	    }else{
		j_flg=0;
	    }
	    break;
	case 3:
	    if(jx1<=jx4&&jx3>=jx2&&jy1<=jy4&&jy3>=jy2){
		j_flg=1;
	    }else{
		j_flg=0;
	    }	  
	}
    }
}
