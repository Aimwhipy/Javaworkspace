package test;



import java.io.*;
import java.math.BigDecimal;

import com.itextpdf.text.*;  
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;  


public class access {
	public static sourcedata[] data=new sourcedata[100];
	public static int length;
	
    public static void readTxtFile(File file){
        
    	try {
                
                //File file=new File(filePath);
    		    if (file==null)
    		    		return;
                if(file.isFile() && file.exists())
                { //�ж��ļ��Ƿ����
                	FileReader read = new FileReader(file);
                    //InputStreamReader read = new InputStreamReader(new FileInputStream(file));
                	//FileInputStream read = new FileInputStream(file);
                    BufferedReader bufferedreader = new BufferedReader(read);
                    String lineTxt = null;
                    int i=1;
                    while((lineTxt = bufferedreader.readLine()) != null)
                    {
                       // System.out.println(lineTxt);          
                    	String[] st=new String[5];
                    	st= lineTxt.split(" +");  
                    	
                    	data[i]=new sourcedata();
                  	    data[i].id=i;
                  	    data[i].shendu=Float.parseFloat(st[1]);
                  	    data[i].jingxie=Float.parseFloat(st[2]);
                  	    data[i].fangwei=Float.parseFloat(st[3]);
                        data[i].gaobian=Float.parseFloat(st[4]); 
                        length=i;
                        i=i+1;   
                       
                   }
                    
                    read.close();
             }
                else{
               System.out.println("�Ҳ���ָ�����ļ�");
                    }
              } catch (Exception e) {
               System.out.println("��ȡ�ļ����ݳ���");
               e.printStackTrace();
         }
     
    }
     
     public  static void format(sourcedata[] test){
    	for (int i=1;i<=length;i++)
    	{test[i].jingxie=(new BigDecimal(test[i].jingxie)).setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
    	 test[i].fangwei=(new BigDecimal(test[i].fangwei)).setScale(1, BigDecimal.ROUND_HALF_UP).floatValue();
    	 test[i].gaobian=(new BigDecimal(test[i].gaobian)).setScale(1, BigDecimal.ROUND_HALF_UP).floatValue();
    	 test[i].nanbeipianyi=(new BigDecimal(test[i].nanbeipianyi)).setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
    	 test[i].dongxipianyi=(new BigDecimal(test[i].dongxipianyi)).setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
    	 test[i].shuipingpianyi=(new BigDecimal(test[i].shuipingpianyi)).setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
    	 test[i].bihefangwei=(new BigDecimal(test[i].bihefangwei)).setScale(1, BigDecimal.ROUND_HALF_UP).floatValue();
    	 test[i].touyingweiyi=(new BigDecimal(test[i].touyingweiyi)).setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
    	 test[i].chuishen=(new BigDecimal(test[i].chuishen)).setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
    	}	
    }
     
    public  static void sort(sourcedata[] test){
        sourcedata temp=new sourcedata();
        for(int i=1;i<=length-1;i++){
            for(int j=1;j<=length-i;j++){
                if(test[j].shendu>test[j+1].shendu)
                {
                    temp=test[j];
                    test[j]=test[j+1];
                    test[j+1]=temp;
                    test[j].id=j;
                    test[j+1].id=j+1;
                }
            }
        }
    }     
    public static void save(File file){
   	 try
   	 {FileWriter filewriter = new FileWriter(file);
   	  for (int i =1; i <= access.length; i++) 
   	   {
          filewriter.write("   "+
       		            access.data[i].shendu+"    "+
   	                    access.data[i].jingxie+"    "+
   	                    access.data[i].fangwei+"    "+
   	                    access.data[i].gaobian+"    "+"\r\n");
          filewriter.flush();
           }
   	   filewriter.close();
   	  }
   	  catch(IOException ex){
   		 ex.printStackTrace();
   	   }
   	 }
   	
   	public static void export(File file){
   		
  try
   		 {
	      BaseFont bfChinese=BaseFont.createFont("C:/WINDOWS/Fonts/SIMSUN.TTC,1",BaseFont.IDENTITY_H,BaseFont.NOT_EMBEDDED);
	      Font FontChinese = new Font(bfChinese, 9, Font.NORMAL); 
	      Font title = new Font(bfChinese, 12, Font.BOLD); 
   			Document pdfDoc = new Document();
   			FileOutputStream filewriter = new FileOutputStream(file);
   			PdfWriter.getInstance(pdfDoc, filewriter);  
   			pdfDoc.open();
   			pdfDoc.add(new Paragraph("                              ���ݲ�б���ݴ�����               \n\r",title));
   			Paragraph paragraph = new Paragraph("   ID    ���    �γ�   "
   	   		+ " ��б     ��λ     �߱�   "
   	   		+ " �ϱ�ƫ��  ����ƫ��  ˮƽƫ��  �պϷ�λ ͶӰλ��    ����     \n",FontChinese);
   			pdfDoc.add(paragraph);
   		  for (int i =1; i <= access.length; i++) 
   		   {
   			paragraph = new Paragraph("   "
   				       +display.df1.format(access.data[i].id)+"    "
   		               +display.df2.format(access.data[i].shendu)+"    "
   			           +display.df2.format(access.data[i].duanchang)+"    "
   			           +display.df3.format(access.data[i].jingxie)+"    "
   			           +display.df4.format(access.data[i].fangwei)+"    "
   			           +display.df4.format(access.data[i].gaobian)+"    "
   			           +display.df3.format(access.data[i].nanbeipianyi)+"    "
   			           +display.df5.format(access.data[i].dongxipianyi)+"    "
   			           +display.df5.format(access.data[i].shuipingpianyi)+"    "
   			           +display.df4.format(access.data[i].bihefangwei)+"    "
   			           +display.df3.format(access.data[i].touyingweiyi)+"    "
   			           +display.df6.format(access.data[i].chuishen)+" "+"\r\n",FontChinese);
   			pdfDoc.add(paragraph);
   	        }
   		pdfDoc.close();  
   		  }
   		  catch(Exception ex){
   			 ex.printStackTrace();
   		   }
   		
   		
   	}
   public static void serialout(File file){
	   try 
	   {FileOutputStream streamout=new FileOutputStream(file);
	    ObjectOutputStream obout=new ObjectOutputStream(streamout);
	    //sourcedata[] tempdata=new sourcedata[100];
	    //tempdata=data;
	   // int changdu=length;
	    obout.writeObject(data);
	    obout.writeObject(length);
	    obout.close();
	   }
	   catch(Exception e)
	   {   
		   System.out.println("cuocucoucocuocuco"); }
	   
   }
   
   
   public static void serialin(File file){
	   try 
	   {FileInputStream streamin=new FileInputStream(file);
	    ObjectInputStream obin=new ObjectInputStream(streamin);
	   
	    Object tempdata=obin.readObject();
	    Object templength=obin.readObject();
	    data=(sourcedata[]) tempdata;
	    length=(int) templength;
	  //  data=indata;
	  //  length=changdu;
	    obin.close();
	   }
	   catch(Exception e)
	   {   
		  System.out.println("cuocucoucocuocuco");}
	   
   }
   	
   	
  
   
}
 

