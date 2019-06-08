package lyh.SIMS.frontend;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
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
import javax.swing.JTable;

import lyh.SIMS.frontend.DBOptions.MouseClick;

public class MainFrame extends JFrame
implements ActionListener{
	private BackgroundPanel BGP;
	private JTabbedPane TabPane = new JTabbedPane();
	private JTable StudentTable;
	//private String[] Column = 
		//{"ID","Name","Gender","Grade","Class","isLocal","PhoneNumber","Chinese","Mathematics","English"};
	private HomePanel BasicPanel;
	private JPanel BasicTablePanel;
	private JPanel BasicModifyPanel;
	private HomePanel ScorePanel;
	private JPanel ScoreTablePanel;
	private JPanel ScoreModifyPanel;
	private HomePanel ClassPanel;
	private JPanel ClassTablePanel;
	private JPanel ClassModifyPanel;
	private HomePanel CoursePanel;
	private JPanel CourseTablePanel;
	private JPanel CourseModifyPanel;
    private GridBagConstraints c = new GridBagConstraints();
	
	private void initTabPane() {
		initBasicPanel();
		TabPane.addTab("Basic", BasicPanel);
		initScorePanel();
		TabPane.add("Score",ScorePanel);
		initClassPanel();
		TabPane.add("Class",ClassPanel);
		initCoursePanel();
		TabPane.add("Course",CoursePanel);
	}
	
	
	
	
	
	
	 private void initCoursePanel() {
		// TODO Auto-generated method stub
		 CoursePanel = new HomePanel();
		 //CoursePanel.add(new JButton());

	}






	private void initClassPanel() {
		// TODO Auto-generated method stub
		ClassPanel = new HomePanel();
		//ClassPanel.add(new JButton());

	}






	private void initScorePanel() {
		// TODO Auto-generated method stub
		ScorePanel = new HomePanel();
		//ScorePanel.add(new JButton());

	}

	
	private void initBasicPanel() {
		// TODO Auto-generated method stub
		BasicPanel = new HomePanel();
		//BasicPanel.add(new JButton());

	}
	
	
	private void addCom(Component c, Container con, GridBagConstraints gbcon,
		int row, int col, int numberOfRow, int numberOfCol, double weightX, double weightY) {
		gbcon.gridx = col;
		gbcon.gridy = row;
		gbcon.gridwidth = numberOfCol;
		gbcon.gridheight = numberOfRow;
		gbcon.weightx = weightX;
		gbcon.weighty = weightY;
		con.add(c,gbcon);
	}











	public MainFrame(){
	        super("SIMS");        	        
	        double width = Toolkit.getDefaultToolkit().getScreenSize().width; //得到当前屏幕分辨率的高
	        double height = Toolkit.getDefaultToolkit().getScreenSize().height;//得到当前屏幕分辨率的宽
	        this.setSize((int)width,(int)height);//设置大小
	        this.setLocation(0,0); //设置窗体居中显示
	        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);	        
	        //BGP=new BackgroundPanel((new ImageIcon("C:\\Users\\l4728\\git\\SIMS\\src\\main\\java\\lyh\\SIMS\\frontend\\yazi.jpg")).getImage());
	        //BGP.setBounds(0,0,this.getWidth(),this.getHeight());  
	        //this.setContentPane(BGP);
	        this.getContentPane().setLayout(new BorderLayout());
	        this.initTabPane();
	        this.getContentPane().add(BorderLayout.CENTER, TabPane);
	        this.setVisible(true);
	    }
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}