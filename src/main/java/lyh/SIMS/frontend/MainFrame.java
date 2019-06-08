package lyh.SIMS.frontend;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import lyh.SIMS.frontend.DBOptions.MouseClick;

public class MainFrame extends JFrame
implements ActionListener{
	private BackgroundPanel BGP;
	private JTabbedPane TabPane = new JTabbedPane();
	
	
	
	
	
	 public MainFrame(){
	        super("SIMS");
	        this.getContentPane().setLayout(null);
	        double width = Toolkit.getDefaultToolkit().getScreenSize().width; //得到当前屏幕分辨率的高
	        double height = Toolkit.getDefaultToolkit().getScreenSize().height;//得到当前屏幕分辨率的宽
	        this.setSize((int)width,(int)height);//设置大小
	        this.setLocation(0,0); //设置窗体居中显示
	        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	        this.setVisible(true);
	        BGP=new BackgroundPanel((new ImageIcon("C:\\Users\\l4728\\git\\SIMS\\src\\main\\java\\lyh\\SIMS\\frontend\\yazi.jpg")).getImage());
	        BGP.setBounds(0,0,this.getWidth(),this.getHeight());  
	        this.add(BGP);
	    }
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
