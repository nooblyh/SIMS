package lyh.SIMS.frontend;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JFrame;

import lyh.SIMS.frontend.DBOptions.MouseClick;

public class MainFrame extends JFrame
implements ActionListener{
	
	 public MainFrame(){
	        super("SIMS");
	        this.getContentPane().setLayout(new BorderLayout());
	        double width = Toolkit.getDefaultToolkit().getScreenSize().width; //得到当前屏幕分辨率的高
	        double height = Toolkit.getDefaultToolkit().getScreenSize().height;//得到当前屏幕分辨率的宽
	        this.setSize((int)width,(int)height);//设置大小
	        this.setLocation(0,0); //设置窗体居中显示
	        this.setResizable(false);//禁用最大化按钮
	        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	        
	    }
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
