package test;

import java.awt.*;


import javax.swing.*;
import javax.swing.filechooser.*;

import java.awt.print.*;
import java.awt.event.*;
import java.awt.print.Printable;
import java.awt.print.PrinterJob;
import java.io.File;


public class guitest {
	
	static JFrame  frame=new JFrame("陀螺测斜数据处理软件");
	static JTextArea textArea0 = new JTextArea();
	static JTextArea textArea1 = new JTextArea();
	static JScrollPane scrollPane0 = new JScrollPane(textArea0);
	static JScrollPane scrollPane1 = new JScrollPane(textArea1);
	
	
	public  static void  main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		
		
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
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
		panel1.setLayout(new BoxLayout(panel1,BoxLayout.X_AXIS));
		panel2.setLayout(new BoxLayout(panel2,BoxLayout.Y_AXIS));
        
		
		JButton insert = new JButton("增加 ");
		JButton delete = new JButton("删除");
		JButton modify = new JButton("更改");
		JButton select = new JButton("查询");
		JButton refresh= new JButton("刷新");
		insert.addActionListener(new insertlistener());
		delete.addActionListener(new deletelistener());
		modify.addActionListener(new modifylistener());
		select.addActionListener(new selectlistener());
		refresh.addActionListener(new refreshlistener());
		
		Box hbox=Box.createHorizontalBox();
		Box vbox=Box.createVerticalBox();
		 
	    
		panel0.add(vbox);
		vbox.add(Box.createVerticalGlue());
		vbox.add(insert);
		vbox.add(Box.createVerticalGlue());
		vbox.add(delete);
		vbox.add(Box.createVerticalGlue());
		vbox.add(modify);
		vbox.add(Box.createVerticalGlue());
		vbox.add(select);
		vbox.add(Box.createVerticalGlue());
	
		
		JButton savesource = new JButton("储存数据");
		JButton saveresult = new JButton("输出处理报告");
		JButton loadsource = new JButton("读取数据");
		JButton serialout = new JButton("序列化输出");
		JButton serialin = new JButton("序列化输入");
		JButton print = new JButton("打印");
		savesource.addActionListener(new savesourcelistener());
		saveresult.addActionListener(new saveresultlistener());
		loadsource.addActionListener(new loadsourcelistener());
		serialout.addActionListener(new serialoutlistener());
		serialin.addActionListener(new serialinlistener());
		print.addActionListener(new printlistener());
		
		
		hbox.add(Box.createHorizontalGlue());
		hbox.add(savesource);
		hbox.add(Box.createHorizontalGlue());
		hbox.add(saveresult);
		hbox.add(Box.createHorizontalGlue());
	    hbox.add(loadsource);
	    hbox.add(Box.createHorizontalGlue());
		hbox.add(serialout);
		hbox.add(Box.createHorizontalGlue());
		hbox.add(serialin);
		hbox.add(Box.createHorizontalGlue());
		hbox.add(print);
		hbox.add(Box.createHorizontalGlue());
		panel1.add(hbox);
		
		
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
			process.query();
			
			
			
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
			int i=filesave.showSaveDialog(frame);
			if (i==JFileChooser.APPROVE_OPTION){
			File filePath =filesave.getSelectedFile();
			if (filePath==null)
				return;
			String name=filePath.getAbsolutePath();
			if (name.endsWith(".txt"))
				;
			else
			filePath=new File(name+".txt");
		    access.save(filePath);
			}
		}
	}
	public static class saveresultlistener implements ActionListener{
		public void actionPerformed(ActionEvent ev){
			JFileChooser filesave= new JFileChooser();
			filesave.setFileFilter(pdffilter);
			int i=filesave.showSaveDialog(frame);
			if (i==JFileChooser.APPROVE_OPTION){
			File filePath =filesave.getSelectedFile();
			if (filePath==null)
				return;
			String name=filePath.getAbsolutePath();
			if (name.endsWith(".pdf"))
				;
			else
			filePath=new File(name+".pdf");
			access.export(filePath);
		}
	}
	}
	public static class loadsourcelistener implements ActionListener{
		public void actionPerformed(ActionEvent ev){
			JFileChooser fileload= new JFileChooser();
			fileload.setFileFilter(txtfilter);
			int i=fileload.showOpenDialog(frame);
			if (i==JFileChooser.APPROVE_OPTION){
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
	}
	public static class serialoutlistener implements ActionListener{
		public void actionPerformed(ActionEvent ev){
			JFileChooser fileout= new JFileChooser();
			fileout.setFileFilter(serfilter);
			int i=fileout.showSaveDialog(frame);
			if (i==JFileChooser.APPROVE_OPTION)
			{
			File filePath =fileout.getSelectedFile();
			
			if (filePath==null)
				return;
			String name=filePath.getAbsolutePath();
			if (name.endsWith(".ser"))
				;
			else
			filePath=new File(name+".ser");
			access.serialout(filePath);
		}
		}
	}
	public static class serialinlistener implements ActionListener{
		public void actionPerformed(ActionEvent ev){
			JFileChooser filein= new JFileChooser();
			filein.setFileFilter(serfilter);
			int i=filein.showSaveDialog(frame);
			if (i==JFileChooser.APPROVE_OPTION){
			File filePath =filein.getSelectedFile();
			if (filePath==null)
				return;
			access.serialin(filePath);
			display.source();
			display.result();
		}
	}
	}
	
	
	public static class printlistener implements ActionListener{
		public void actionPerformed(ActionEvent ev){
		      try{
		    	PrinterJob job=PrinterJob.getPrinterJob();
		       
		       boolean ok=job.printDialog();
		       if(!ok)
		    	   return;
		       job.setPrintable(new Printable(){
		    	   private final int WIDTH=130;
		    	   private final int HEIGHT=130;
		    	   public int print(Graphics graphics,PageFormat pageFormat,int pageIndex) {
		    		   if (pageIndex>0)
		    			   return Printable.NO_SUCH_PAGE;
		    		   int x=(int)pageFormat.getImageableX();
		    		   int y=(int)pageFormat.getImageableY();
		    		
		    		   Graphics2D g2=(Graphics2D)graphics;
		    		   g2.setStroke(new BasicStroke(4.0F));
		    		   g2.setColor(Color.BLUE);
		    		   g2.drawOval(x+10,y+10,WIDTH,HEIGHT);
		    		   return Printable.PAGE_EXISTS;
		    	   }
		       });
		    	 job.print();   
		       }
		       catch (Exception e){
		    	   e.printStackTrace();
		       }
		}
	}
	private static FileNameExtensionFilter txtfilter =new FileNameExtensionFilter("txt文本","txt");
	private static FileNameExtensionFilter serfilter =new FileNameExtensionFilter("ser序列化文件","ser");
	private static FileNameExtensionFilter pdffilter =new FileNameExtensionFilter("PDF文档","pdf");

	
}  


    
