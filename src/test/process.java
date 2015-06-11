package test;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class process {
	static JFrame iframe=new JFrame("插入数据");
	static JPanel ipanel0 = new JPanel();
	static JPanel ipanel1 = new JPanel();
	static JTextField ishendu0 =new JTextField(5);
	static JTextField ijingxie0 =new JTextField(5);
	static JTextField ifangwei0 =new JTextField(5);
	static JTextField igaobian0 =new JTextField(5);
     
	static JFrame dframe=new JFrame("删除数据");
	static JPanel dpanel0 = new JPanel();
	static JPanel dpanel1 = new JPanel();
	static JTextField did0 =new JTextField(5);
	
	static JFrame mframe=new JFrame("修改数据");
	static JPanel mpanel0 = new JPanel();
	static JPanel mpanel1 = new JPanel();
	static JTextField mid0 =new JTextField(5);
	static JTextField mshendu0 =new JTextField(5);
	static JTextField mjingxie0 =new JTextField(5);
	static JTextField mfangwei0 =new JTextField(5);
	static JTextField mgaobian0 =new JTextField(5);
	
	
	static JFrame qframe=new JFrame("查询");
	static Box qpanel0 = Box.createVerticalBox();
	static JPanel qpanel00 = new JPanel();
	static JPanel qpanel01 = new JPanel();
	
	
	static JTextField qid0 =new JTextField(8);
	static JTextField qshendu0 =new JTextField(8);
	static JTextField qjingxie0 =new JTextField(8);
	static JTextField qfangwei0 =new JTextField(8);
	static JTextField qgaobian0 =new JTextField(8);
	static JTextField qduanchang0 =new JTextField(8);
	static JTextField qnanbeipianyi0 =new JTextField(8);
	static JTextField qdongxipianyi0 =new JTextField(8);
	static JTextField qshuipingpianyi0 =new JTextField(8);
	static JTextField qbihefangwei0 =new JTextField(8);
	static JTextField qtouyingweiyi0 =new JTextField(8);
	static JTextField qchuishen0 =new JTextField(8);
	static JTextArea qresult =new JTextArea();
	static JScrollPane qpanel1 = new JScrollPane(qresult);
   
	public static void insert(){
		
		JLabel shendu = new JLabel("深度");
		JLabel jingxie = new JLabel("井斜");
		JLabel fangwei = new JLabel("方位");
		JLabel gaobian = new JLabel("高边");
		
		JButton sure =new JButton("确认添加");
		sure.addActionListener(new insertlistener());
		ipanel0.removeAll();
		ipanel1.removeAll();
		ipanel0.add(shendu);
		ipanel0.add(ishendu0);
		ipanel0.add(jingxie);
		ipanel0.add(ijingxie0);
		ipanel0.add(fangwei);
		ipanel0.add(ifangwei0);
		ipanel0.add(gaobian);
		ipanel0.add(igaobian0);
		ipanel1.add(new JLabel(" "));
		ipanel1.add(sure);
		iframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		iframe.setSize(500, 120);
		iframe.getContentPane().add(ipanel0, BorderLayout.NORTH);
		iframe.getContentPane().add(ipanel1, BorderLayout.SOUTH);
		iframe.setVisible(true);	
	}
	public static void delete(){
		
		
		JLabel id = new JLabel("ID");   
		JButton sure =new JButton("确认删除");
		sure.addActionListener(new deletelistener());
		dpanel0.removeAll();
		dpanel1.removeAll();
		dpanel0.add(id);
		dpanel0.add(did0);
        dpanel1.add(new JLabel(" "));
		dpanel1.add(sure);
		dframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		dframe.setSize(300, 120);
		dframe.getContentPane().add(dpanel0, BorderLayout.NORTH);
		dframe.getContentPane().add(dpanel1, BorderLayout.SOUTH);
		dframe.setVisible(true);	
	}
	
	
	public static void modify(){
	
		JLabel shendu = new JLabel("深度");
		JLabel jingxie = new JLabel("井斜");
		JLabel fangwei = new JLabel("方位");
		JLabel gaobian = new JLabel("高边");
		JLabel id = new JLabel("ID");
	   
		JButton sure =new JButton("确认修改");
		sure.addActionListener(new modifylistener());
		mpanel0.removeAll();
		mpanel1.removeAll();
		mpanel0.add(id);
		mpanel0.add(mid0);
		mpanel0.add(shendu);
		mpanel0.add(mshendu0);
		mpanel0.add(jingxie);
		mpanel0.add(mjingxie0);
		mpanel0.add(fangwei);
		mpanel0.add(mfangwei0);
		mpanel0.add(gaobian);
		mpanel0.add(mgaobian0);
		mpanel1.add(new JLabel(" "));
		mpanel1.add(sure);
		mframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		mframe.setSize(500, 120);
		mframe.getContentPane().add(mpanel0, BorderLayout.NORTH);
		mframe.getContentPane().add(mpanel1, BorderLayout.SOUTH);
		mframe.setVisible(true);	
	}
	
	
	public static void query(){
		
		JLabel shendu = new JLabel("深度");
		JLabel jingxie = new JLabel("井斜");
		JLabel fangwei = new JLabel("方位");
		JLabel gaobian = new JLabel("高边");
		JLabel duanchang = new JLabel("段长");
		JLabel nanbeipianyi = new JLabel("南北偏移");
		JLabel dongxipianyi = new JLabel("东西偏移");
		JLabel shuipingpianyi = new JLabel("水平偏移");
		JLabel touyingweiyi = new JLabel("投影位移");
		JLabel bihefangwei = new JLabel("闭合方位");
		JLabel chuishen = new JLabel("垂深");
		JLabel id = new JLabel("ID");
        JButton sure =new JButton("确认查询");
		sure.addActionListener(new querylistener());
		
		qpanel0.removeAll();
		qresult.removeAll();
		qpanel00.removeAll();
		qpanel01.removeAll();
		qpanel0.setBorder(BorderFactory.createTitledBorder("筛选条件"));
		qpanel1.setBorder(BorderFactory.createTitledBorder("筛选结果"));
		qpanel00.add(Box.createHorizontalStrut(15));
		qpanel00.add(id);
		qpanel00.add(qid0);
		qpanel00.add(Box.createHorizontalStrut(15));
		qpanel00.add(shendu);
		qpanel00.add(qshendu0);
		qpanel00.add(Box.createHorizontalStrut(15));
		qpanel00.add(jingxie);
		qpanel00.add(qjingxie0);
		qpanel00.add(Box.createHorizontalStrut(15));
		qpanel00.add(fangwei);
		qpanel00.add(qfangwei0);
		qpanel00.add(Box.createHorizontalStrut(15));
		qpanel00.add(gaobian);
		qpanel00.add(qgaobian0);
		qpanel00.add(Box.createHorizontalStrut(15));
		qpanel00.add(duanchang);
		qpanel00.add(qduanchang0);
		qpanel00.add(Box.createHorizontalStrut(15));
		qpanel00.add(nanbeipianyi);
		qpanel00.add(qnanbeipianyi0);
		qpanel00.add(Box.createHorizontalStrut(15));
		qpanel01.add(Box.createHorizontalStrut(15));
		qpanel01.add(dongxipianyi);
		qpanel01.add(qdongxipianyi0);
		qpanel01.add(Box.createHorizontalStrut(15));
		qpanel01.add(shuipingpianyi);
		qpanel01.add(qshuipingpianyi0);
		qpanel01.add(Box.createHorizontalStrut(15));
		qpanel01.add(touyingweiyi);
		qpanel01.add(qtouyingweiyi0);
		qpanel01.add(Box.createHorizontalStrut(15));
		qpanel01.add(bihefangwei);
		qpanel01.add(qbihefangwei0);
		qpanel01.add(Box.createHorizontalStrut(15));
		qpanel01.add(chuishen);
		qpanel01.add(qchuishen0);
		qpanel01.add(Box.createHorizontalStrut(15));
		qpanel01.add(sure);
		qpanel01.add(Box.createHorizontalStrut(15));
		qpanel0.add(qpanel00);
		qpanel0.add(qpanel01);
		
		qframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		qframe.setSize(850, 400);
		qframe.getContentPane().add(qpanel0, BorderLayout.NORTH);
		qframe.getContentPane().add(qpanel1, BorderLayout.CENTER);
		qframe.setVisible(true);	
	}
	
	
	
	
	public static class insertlistener implements ActionListener{
		public  void actionPerformed(ActionEvent ev){
			access.data[access.length+1]=new sourcedata();
			access.data[access.length+1].id=access.length+1;
			access.data[access.length+1].shendu=Float.parseFloat(ishendu0.getText());
			access.data[access.length+1].jingxie=Float.parseFloat(ijingxie0.getText());
			access.data[access.length+1].fangwei=Float.parseFloat(ifangwei0.getText());
			access.data[access.length+1].gaobian=Float.parseFloat(igaobian0.getText());
			access.length=access.length+1;
			access.sort(access.data);
			display.source();
			caculate.go();
			display.result();
			iframe.dispose();
			
		}
	}
	public static class deletelistener implements ActionListener{
		public void actionPerformed(ActionEvent ev){
			int id=Integer.parseInt(did0.getText());
			access.data[id].shendu=9999;
			access.sort(access.data);
			access.data[access.length]=null;
			access.length=access.length-1;
			access.sort(access.data);
			display.source();
			caculate.go();
			display.result();
			dframe.dispose();
		}
	}
	public static class modifylistener implements ActionListener{
		public void actionPerformed(ActionEvent ev){
			int id=Integer.parseInt(mid0.getText());
			access.data[id].shendu=Float.parseFloat(mshendu0.getText());
			access.data[id].jingxie=Float.parseFloat(mjingxie0.getText());
			access.data[id].fangwei=Float.parseFloat(mfangwei0.getText());
			access.data[id].gaobian=Float.parseFloat(mgaobian0.getText());
			access.sort(access.data);
			display.source();
			caculate.go();
			display.result();
			mframe.dispose();
		}
	}
	
	
	public static class querylistener implements ActionListener{
		public void actionPerformed(ActionEvent ev){
			sourcedata temp[]=new sourcedata[100];
			boolean qid=false;
			boolean qshendu=false;
			boolean qjingxie=false;
			boolean qfangwei=false;
			boolean qgaobian=false;
			boolean qduanchang=false;
			boolean qnanbeipianyi=false;
			boolean qdongxipianyi=false;
			boolean qshuipingpianyi=false;
			boolean qtouyingweiyi=false;
			boolean qbihefangwei=false;
			boolean qchuishen=false;
			int id=0;
			float shendu=0;
			float jingxie=0;
			float fangwei=0;
			float gaobian=0;
			float duanchang=0;
			float nanbeipianyi=0;
			float dongxipianyi=0;
			float shuipingpianyi=0;
			float touyingweiyi=0;
			float bihefangwei=0;
			float chuishen=0;
			if("".equals(qid0.getText().trim())==false){
			id=Integer.parseInt(qid0.getText());
			 qid= true;}
			if("".equals(qshendu0.getText().trim())==false){
			shendu=Float.parseFloat(qshendu0.getText());
			qshendu= true;}
			if("".equals(qjingxie0.getText().trim())==false){
			jingxie=Float.parseFloat(qjingxie0.getText());
			qjingxie= true;}
			if("".equals(qjingxie0.getText().trim())==false){
			fangwei=Float.parseFloat(qjingxie0.getText());
			qfangwei= true;}
			if("".equals(qgaobian0.getText().trim())==false){
			gaobian=Float.parseFloat(qgaobian0.getText());
			qgaobian= true;}
			if("".equals(qduanchang0.getText().trim())==false){
			duanchang=Float.parseFloat(qduanchang0.getText());
			qduanchang= true;}
			if("".equals(qnanbeipianyi0.getText().trim())==false){
			nanbeipianyi=Float.parseFloat(qnanbeipianyi0.getText());
			qnanbeipianyi= true;}
			if("".equals(qdongxipianyi0.getText().trim())==false){
			dongxipianyi=Float.parseFloat(qdongxipianyi0.getText());
			qdongxipianyi= true;}
			if("".equals(qshuipingpianyi0.getText().trim())==false){
			shuipingpianyi=Float.parseFloat(qshuipingpianyi0.getText());
			qshuipingpianyi= true;}
			if("".equals(qtouyingweiyi0.getText().trim())==false){
			touyingweiyi=Float.parseFloat(qtouyingweiyi0.getText());
			qtouyingweiyi= true;}
			if("".equals(qbihefangwei0.getText().trim())==false){
			bihefangwei=Float.parseFloat(qbihefangwei0.getText());
			qbihefangwei= true;}
			if("".equals(qchuishen0.getText().trim())==false){
			chuishen=Float.parseFloat(qchuishen0.getText());
			qchuishen= true;}
			
			int n;
            int tlength=0;
			for(n=1;n<=access.length;n++)
			{if((access.data[n].id==id||(qid==false))&&(access.data[n].shendu==shendu||(qshendu==false))
			  &&(access.data[n].jingxie==jingxie||(qjingxie==false))&&(access.data[n].fangwei==fangwei||(qfangwei==false))
			  &&(access.data[n].gaobian==gaobian||(qgaobian==false))&&(access.data[n].duanchang==duanchang||(qduanchang==false))
			  &&(access.data[n].nanbeipianyi==nanbeipianyi||(qnanbeipianyi==false))
			  &&(access.data[n].dongxipianyi==dongxipianyi||(qdongxipianyi==false))
			  &&(access.data[n].shuipingpianyi==shuipingpianyi||(qshuipingpianyi==false))
			  &&(access.data[n].touyingweiyi==touyingweiyi||(qtouyingweiyi==false))
			  &&(access.data[n].bihefangwei==bihefangwei||(qbihefangwei==false))
			  &&(access.data[n].chuishen==chuishen||(qchuishen==false)))
			{temp[tlength+1]=access.data[n];
			 tlength++;	}
			}
			if (tlength>0)
			{qresult.setText("      ID        深度         段长    "
			   		+ "    井斜          方位        高边      "
			   		+ " 南北偏移         东西偏移       水平偏移       闭合方位      投影位移        垂深     \n");
				for(n=1;n<=tlength;n++)
				{qresult.append("      "
				       +display.df1.format(temp[n].id)+"       "
		               +display.df2.format(temp[n].shendu)+"       "
			           +display.df2.format(temp[n].duanchang)+"       "
			           +display.df3.format(temp[n].jingxie)+"       "
			           +display.df4.format(temp[n].fangwei)+"       "
			           +display.df4.format(temp[n].gaobian)+"       "
			           +display.df3.format(temp[n].nanbeipianyi)+"           "
			           +display.df5.format(temp[n].dongxipianyi)+"           "
			           +display.df5.format(temp[n].shuipingpianyi)+"           "
			           +display.df4.format(temp[n].bihefangwei)+"           "
			           +display.df3.format(temp[n].touyingweiyi)+"           "
			           +display.df6.format(temp[n].chuishen)+" "+"\n");	
				}
			}
				else 
				{qresult.setText("            没有找到符合条件的结果！");}
			
			
			
			
		}
	}
	
}
