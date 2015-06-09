package test;
public class caculate {
	public static double[] delta_x=new double[100];
	public static double[] delta_y=new double[100];
	public static double[] delta_z=new double[100];
			public static double		delta_depth;
	
	
	public static void go()
	{
		int i;
		double temp, temp_depth, temp_x, temp_y, h1, dog_angle;
		double I_angle, A1, A2, cosI1, cosI2, sinI1, sinI2;
		double max_I, max_dog;
		double temshf1;
		double bihe_angle,duanl,tywy; /*99,12*/

		
		
		
		cal_delta_xyz();
		temp_depth = 0.0;
		temp_x = temp_y = 0.0;

		I_angle = A1 = 0.0;
		cosI1 = Math.cos(I_angle);
		sinI1 = Math.sin(I_angle);
		dog_angle = 0.0;
		h1 = 0 ;
		max_I = max_dog =0.0;
		int j;
		for (j=1; j<=access.length; j++) {
			
			i= j;
			temp_depth += delta_z[i];
			temp_x += delta_x[i];
			temp_y += delta_y[i];
			temp = Math.sqrt(temp_x*temp_x + temp_y*temp_y);
            access.data[i].nanbeipianyi=-(float)temp_y;
            access.data[i].dongxipianyi=(float)temp_x;
            access.data[i].shuipingpianyi=(float)temp;
            access.data[i].chuishen=(float)temp_depth;
			I_angle = access.data[i].jingxie * Math.PI / 180.0;
			A2 = access.data[i].fangwei * Math.PI / 180.0;
			cosI2 = Math.cos(I_angle);
			sinI2 = Math.sin(I_angle);
			if (Math.abs(access.data[i].shendu-h1)>0.01) {

			
				temshf1=cosI1*cosI2 + sinI1*sinI2*Math.cos(A2 - A1);
				if(temshf1>1.0) temshf1=1.0;
				if(temshf1<-1.0) temshf1=-1.0;
				dog_angle=Math.acos(temshf1);
				/*****************************************/

	/*			dog_angle = acos(cosI1*cosI2 + sinI1*sinI2*cos(A2 - A1));
	*/
				dog_angle = dog_angle * 180.0 / Math.PI;	/* degree */
				dog_angle = 25.0 * dog_angle / Math.abs(access.data[i].shendu - h1); /* degree/25m */
			}
	/**99,12**/
			if ((Math.abs(temp_y)<0.01) && (Math.abs(temp_x)<0.01))
				bihe_angle = Math.PI / 2.0;
			else
				bihe_angle = Math.atan2(-temp_y, temp_x);
			bihe_angle = 90.0 - bihe_angle * 180.0 / Math.PI;
			if (bihe_angle<0.0)
				bihe_angle += 360.0;
			access.data[i].bihefangwei=(float)bihe_angle;

			if(i==1) duanl = access.data[i].shendu;
			else
			duanl = access.data[i].shendu-access.data[i-1].shendu;
			access.data[i].duanchang=(float)duanl;
			tywy =-temp_y;
	        access.data[i].touyingweiyi=(float)tywy;

			A1 = A2;
			cosI1 = cosI2;
			sinI1 = sinI2;
			h1 = access.data[i].shendu;
			if (access.data[i].jingxie>max_I) {
				max_I = access.data[i].jingxie;
				
			}
			if (dog_angle>max_dog)
				max_dog = dog_angle;
		    
			
		
		
		}
		

}
		
		
		
		public  static void cal_delta_xyz()
		{
			int i, n, m;
			double temp, I_angle, A_angle, dog_angle, A, F;
			double cosI1, cosI2, sinI1, sinI2, cosA1, cosA2, sinA1, sinA2;
		
			double temshf1;
			/********************************/

			delta_depth = 0.0;
			n = 1;
			I_angle = 0.0;
			A_angle = 0.0;
			A = A_angle;
			cosI1 = Math.cos(I_angle);
			sinI1 = Math.sin(I_angle);
			cosA1 = Math.cos(A_angle + Math.PI);
			sinA1 = Math.sin(A_angle);
			I_angle = access.data[n].jingxie* Math.PI / 180.0;
			A_angle = access.data[n].fangwei * Math.PI / 180.0;
			cosI2 = Math.cos(I_angle);
			sinI2 = Math.sin(I_angle);
			cosA2 = Math.cos(A_angle + Math.PI);
			sinA2 = Math.sin(A_angle);
				temshf1=cosI1*cosI2 + sinI1*sinI2*Math.cos(A_angle - A);
			if(temshf1>1.0) temshf1=1.0;
			if(temshf1<-1.0) temshf1=-1.0;
			dog_angle=Math.acos(temshf1);
			dog_angle /= 2.0;
			if (dog_angle<0.000001)
				dog_angle = 0.000001;
			F = Math.tan(dog_angle) / dog_angle;
			A = A_angle;
			temp = 0.5 * F * access.data[1].shendu;
		/**	if(tuoluo_depth[tuoluo_index[0]]>5.0)
			{
		**/
			delta_x[n] = temp * (sinI1 * sinA1 + sinI2 * sinA2);	/* east-west */
			delta_y[n] = temp * (sinI1 * cosA1 + sinI2 * cosA2);	/* south-north */
			delta_z[n] = temp * (cosI1 + cosI2);
		/**	}
			else
			delta_x[0] = delta_y[0] = delta_z[0] = 0.0;
		**/
			cosI1 = cosI2;
			sinI1 = sinI2;
			cosA1 = cosA2;
			sinA1 = sinA2;

			for (i=2; i<=access.length; i++) {
				n = i;
				I_angle = access.data[n].jingxie * Math.PI / 180.0;
				A_angle = access.data[n].fangwei * Math.PI / 180.0;
				cosI2 = Math.cos(I_angle);
				sinI2 = Math.sin(I_angle);
				cosA2 = Math.cos(A_angle + Math.PI);
				sinA2 = Math.sin(A_angle);

				
				temshf1=cosI1*cosI2 + sinI1*sinI2*Math.cos(A_angle - A);
				if(temshf1>1.0) temshf1=1.0;
				if(temshf1<-1.0) temshf1=-1.0;
				dog_angle=Math.acos(temshf1);
			

		
				dog_angle /= 2.0;
				if (dog_angle<0.000001)
					dog_angle = 0.000001;
				F = Math.tan(dog_angle) / dog_angle;
				A = A_angle;
				m = n-1;
				temp = 0.5 * F *(access.data[n].shendu - access.data[m].shendu);
				delta_x[n] = temp * (sinI1 * sinA1 + sinI2 * sinA2);	/* east-west */
				delta_y[n] = temp * (sinI1 * cosA1 + sinI2 * cosA2);	/* south-north */
				delta_z[n] = temp * (cosI1 + cosI2);
				delta_depth += delta_z[n];
				cosI1 = cosI2;
				sinI1 = sinI2;
				cosA1 = cosA2;
				sinA1 = sinA2;
			}
		}
	}