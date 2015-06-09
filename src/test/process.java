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
	
}
