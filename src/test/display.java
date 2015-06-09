package test;

import java.text.*;

public class display {
	
	static DecimalFormat df1 = new DecimalFormat("00"); 
	static  DecimalFormat df2 = new DecimalFormat("0000"); 
	static  DecimalFormat df3 = new DecimalFormat("00.00"); 
	static DecimalFormat df4 = new DecimalFormat("000.0"); 
	static DecimalFormat df5 = new DecimalFormat("000.00");
	static DecimalFormat df6 = new DecimalFormat("0000.00");
   public static void source()
   {   
	   guitest.textArea0.setText("                                ID          深度  "
	   		+ "         井斜          方位            高边    \n");
	   for(int i=1;i<=access.length;i++)
	       guitest.textArea0.append (  "                               "+
	    		   df1.format(access.data[i].id)+"         "+
	    		   df2.format(access.data[i].shendu)+"         "+
	    		   df3.format(access.data[i].jingxie)+"         "+
	    		   df4.format(access.data[i].fangwei)+"         "+
	    		   df4.format(access.data[i].gaobian)+"         "+"\n");
	}

   public static void result()
   {   
	   guitest.textArea1.setText("      ID        深度         段长    "
	   		+ "    井斜          方位        高边      "
	   		+ " 南北偏移         东西偏移       水平偏移       闭合方位      投影位移        垂深     \n");
	   int i;
	   
	   for(i=1;i<=access.length;i++){
		   guitest.textArea1.append("      "
				       +df1.format(access.data[i].id)+"       "
		               +df2.format(access.data[i].shendu)+"       "
			           +df2.format(access.data[i].duanchang)+"       "
			           +df3.format(access.data[i].jingxie)+"       "
			           +df4.format(access.data[i].fangwei)+"       "
			           +df4.format(access.data[i].gaobian)+"       "
			           +df3.format(access.data[i].nanbeipianyi)+"           "
			           +df5.format(access.data[i].dongxipianyi)+"           "
			           +df5.format(access.data[i].shuipingpianyi)+"           "
			           +df4.format(access.data[i].bihefangwei)+"           "
			           +df3.format(access.data[i].touyingweiyi)+"           "
			           +df6.format(access.data[i].chuishen)+" "+"\n");
			}
   }
   
		public void refresh(){
			access.sort(access.data);
			source();
			caculate.go();
			result();
	        
		}
	}

