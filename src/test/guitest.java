package test;

import java.awt.*;

import javax.swing.*;
import javax.swing.filechooser.*;

import java.awt.event.*;
import java.io.File;


public class guitest {
	
	static JFrame  frame=new JFrame("陀螺测斜数据处理软件");
	static JTextArea textArea0 = new JTextArea();
	static JTextArea textArea1 = new JTextArea();
	static JScrollPane scrollPane0 = new JScrollPane(textArea0);
	static JScrollPane scrollPane1 = new JScrollPane(textArea1);
	
	
	public  static void  main(String[] args) {
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(850, 700);
		textArea0.setLineWrap(true);
		textArea1.setLineWrap(true);
		JPanel panel0 = new JPanel();
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		panel0.setBorder(BorderFactory.createTitledBorder("数据处理"));
		panel1.setBorder(BorderFactory.createTitledBorder("存取控制"));
		panel2.setBorder(BorderFactory.createTitledBorder("数据显示"));
		panel0.setLayout(new BoxLayout(panel0,BoxLayout.Y_AXIS));
		panel2.setLayout(new BoxLayout(panel2,BoxLayout.Y_AXIS));
        
		
		JButton insert = new JButton("增加");
		JButton delete = new JButton("删除");
		JButton modify = new JButton("更改");
		JButton select = new JButton("查询");
		JButton refresh= new JButton("刷新");
		insert.addActionListener(new insertlistener());
		delete.addActionListener(new deletelistener());
		modify.addActionListener(new modifylistener());
		select.addActionListener(new selectlistener());
		refresh.addActionListener(new refreshlistener());
	
		
		panel0.add(new JLabel("  "));
		panel0.add(new JLabel("  "));
		panel0.add(new JLabel("  "));
		panel0.add(insert);
		panel0.add(new JLabel("  "));
		panel0.add(new JLabel("  "));
		panel0.add(new JLabel("  "));
		panel0.add(new JLabel("  "));
		panel0.add(delete);
		panel0.add(new JLabel("  "));
		panel0.add(new JLabel("  "));
		panel0.add(new JLabel("  "));
		panel0.add(new JLabel("  "));
		panel0.add(modify);
		panel0.add(new JLabel("  "));
		panel0.add(new JLabel("  "));
		panel0.add(new JLabel("  "));
		panel0.add(new JLabel("  "));
		panel0.add(select);
		panel0.add(new JLabel("  "));
		panel0.add(new JLabel("  "));
		panel0.add(new JLabel("  "));
		panel0.add(new JLabel("  "));
		panel0.add(refresh);
		
		JButton savesource = new JButton("储存数据");
		JButton saveresult = new JButton("输出结果数据");
		JButton loadsource = new JButton("读取数据");
		JButton serialout = new JButton("序列化输出");
		JButton serialin = new JButton("序列化输入");
		savesource.addActionListener(new savesourcelistener());
		saveresult.addActionListener(new saveresultlistener());
		loadsource.addActionListener(new loadsourcelistener());
		serialout.addActionListener(new serialoutlistener());
		serialin.addActionListener(new serialinlistener());
		
		
		panel1.add(savesource);
		panel1.add(new JLabel("                    "));
		panel1.add(saveresult);
		panel1.add(new JLabel("                     "));
		panel1.add(loadsource);
		panel1.add(new JLabel("                     "));
		panel1.add(serialout);
		panel1.add(new JLabel("                     "));
		panel1.add(serialin);
		
		
		JLabel label0=new JLabel("原始数据");
		JLabel label1=new JLabel("处理结果");
		panel2.add(label0);
        panel2.add(scrollPane0);
		panel2.add(label1);
		panel2.add(scrollPane1);
		
		JMenuBar menubar=new JMenuBar();
		JMenu filemenu=new JMenu("文件");
		JMenu opmenu=new JMenu("操作");
		JMenu aboutmenu=new JMenu("关于");
		JMenuItem save=new JMenuItem("保存");
		JMenuItem load=new JMenuItem("打开");
		JMenuItem exit=new JMenuItem("退出");
		filemenu.add(save);
		filemenu.add(load);
		filemenu.add(exit);
		menubar.add(filemenu);
		menubar.add(opmenu);
		menubar.add(aboutmenu);
		
		
		
		frame.setJMenuBar(menubar);
		frame.getContentPane().add(panel0, BorderLayout.WEST);
		frame.getContentPane().add(panel1, BorderLayout.NORTH);
        frame.getContentPane().add(panel2, BorderLayout.CENTER);
        frame.setVisible(true);	
        }
	
	
	public static class insertlistener implements ActionListener{
		public void actionPerformed(ActionEvent ev){
			process.insert();
			
		}
	}
	public static class deletelistener implements ActionListener{
		public void actionPerformed(ActionEvent ev){
			process.delete();
		
		}
	}
	public static class modifylistener implements ActionListener{
		public void actionPerformed(ActionEvent ev){
			process.modify();
			
		}
	}
   
	public static class selectlistener implements ActionListener{
		public void actionPerformed(ActionEvent ev){
		       
		}
	}

	
	public static class refreshlistener implements ActionListener{
		public void actionPerformed(ActionEvent ev){
			access.sort(access.data);
			display.source();
			caculate.go();
			display.result();
	        
		}
	}
	public static class savesourcelistener implements ActionListener{
		public void actionPerformed(ActionEvent ev){
			JFileChooser filesave= new JFileChooser();
			filesave.setFileFilter(txtfilter);
			filesave.showSaveDialog(frame);
			File filePath =filesave.getSelectedFile();
			if (filePath==null)
				return;
			String name=filePath.getAbsolutePath();
			filePath=new File(name+".txt");
		    access.save(filePath);
			
		}
	}
	public static class saveresultlistener implements ActionListener{
		public void actionPerformed(ActionEvent ev){
			JFileChooser filesave= new JFileChooser();
			filesave.setFileFilter(txtfilter);
			filesave.showSaveDialog(frame);
			File filePath =filesave.getSelectedFile();
			if (filePath==null)
				return;
			String name=filePath.getAbsolutePath();
			filePath=new File(name+".txt");
			access.export(filePath);
		}
	}
	public static class loadsourcelistener implements ActionListener{
		public void actionPerformed(ActionEvent ev){
			JFileChooser fileload= new JFileChooser();
			fileload.setFileFilter(txtfilter);
			fileload.showOpenDialog(frame);
			
			File filePath = fileload.getSelectedFile();
			if (filePath==null)
				return;
	        access.readTxtFile(filePath);
	        access.sort(access.data);
	        display.source();
	        caculate.go();
			display.result();
	        }
	}
	public static class serialoutlistener implements ActionListener{
		public void actionPerformed(ActionEvent ev){
			JFileChooser fileout= new JFileChooser();
			fileout.setFileFilter(serfilter);
			fileout.showSaveDialog(frame);
			File filePath =fileout.getSelectedFile();
			
			if (filePath==null)
				return;
			String name=filePath.getAbsolutePath();
			filePath=new File(name+".ser");
			access.serialout(filePath);
		}
	}
	public static class serialinlistener implements ActionListener{
		public void actionPerformed(ActionEvent ev){
			JFileChooser filein= new JFileChooser();
			filein.setFileFilter(serfilter);
			filein.showSaveDialog(frame);
			File filePath =filein.getSelectedFile();
			if (filePath==null)
				return;
			access.serialin(filePath);
			display.source();
			display.result();
		}
	}
	private static FileNameExtensionFilter txtfilter =new FileNameExtensionFilter("txt文本","txt");
	private static FileNameExtensionFilter serfilter =new FileNameExtensionFilter("ser序列化文件","ser");
	
		
	
	
	
	
}  


    
