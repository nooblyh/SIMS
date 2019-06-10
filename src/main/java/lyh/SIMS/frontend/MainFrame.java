package lyh.SIMS.frontend;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;

import lyh.SIMS.database.StudentData;
import lyh.SIMS.frontend.DBOptions.MouseClick;

public class MainFrame extends JFrame
implements ActionListener{
	private BackgroundPanel BGP;
	private JTabbedPane TabPane = new JTabbedPane();
	//private JTable StudentTable;
	//private String[] Column = 
		//{"ID","Name","Gender","Grade","Class","isLocal","PhoneNumber","Chinese","Mathematics","English"};
	private HomePanel WelcomePanel;
	
	private HomePanel BasicPanel;
	private JTable BasicTablePanel;
	private JPanel BasicModifyPanel;
	private JTextField BasicID;
	private JButton Search;
	private JButton Delete;
	private JTextField BasicName;
	private JRadioButton male;
	private JRadioButton female;
	private JRadioButton BasicGrade1;
	private JRadioButton BasicGrade2;
	private JRadioButton BasicGrade3;
	private JRadioButton BasicGrade4;
	private JRadioButton BasicClass1;
	private JRadioButton BasicClass2;
	private JRadioButton BasicClass3;
	private JRadioButton BasicClass4;
	private JRadioButton Local;
	private JRadioButton nonLocal;
	private JTextField PhoneNumber;
	private JButton BasicConfirm;
	
	private HomePanel ScorePanel;
	private JTable ScoreTablePanel;
	private JPanel ScoreModifyPanel;
	private JTextField ScoreID;
	private JTextField Subject;
	private JTextField Score;
	private JLabel Scoreid = new JLabel("学号：");
	private JLabel Scoresubject = new JLabel("学科：");
	private JLabel Scorescore = new JLabel("分数：");
	private JButton ScoreConfirm;
	
	private HomePanel ClassPanel;
	private JTable ClassTablePanel;
	private JPanel ClassModifyPanel;
	private JRadioButton ClassGrade1;
	private JRadioButton ClassGrade2;
	private JRadioButton ClassGrade3;
	private JRadioButton ClassGrade4;
	private JRadioButton ClassClass1;
	private JRadioButton ClassClass2;
	private JRadioButton ClassClass3;
	private JRadioButton ClassClass4;
	private JButton ClassConfirm;
	
	private HomePanel CoursePanel;
	private JTable CourseTablePanel;
	private JPanel CourseModifyPanel;
	
	private void initTabPane() {
		initWelcomePanel();
		TabPane.addTab("Welcome",WelcomePanel);
		initBasicPanel();
		TabPane.addTab("Basic", BasicPanel);
		initScorePanel();
		TabPane.add("Score",ScorePanel);
		initClassPanel();
		TabPane.add("Class",ClassPanel);
		//initCoursePanel();
		//TabPane.add("Course",CoursePanel);
	}
	
	
	
	
	
	
	 private void initWelcomePanel() {
		// TODO Auto-generated method stub
		 WelcomePanel = new HomePanel();
	}






	private void initCoursePanel() {
		// TODO Auto-generated method stub
		CoursePanel = new HomePanel();
	}






	private void initClassPanel() {
		// TODO Auto-generated method stub
		ClassPanel = new HomePanel();
		ClassPanel.setLayout(new BorderLayout());
		 StudentData sd = new StudentData();
		 Vector meta = sd.getMeta();
		 Vector score = sd.getAll();
		 ClassTablePanel = new JTable(score,meta);
		 ClassTablePanel.setFont(new Font("微软雅黑",Font.PLAIN, 20));
		 DefaultTableCellRenderer r = new DefaultTableCellRenderer();   
		 r.setHorizontalAlignment(JLabel.CENTER);   
		 ClassTablePanel.setDefaultRenderer(Object.class, r);
		 ClassTablePanel.setRowHeight(24);
		 ClassTablePanel.setEnabled(false);
		 JScrollPane ScrollPanel=new JScrollPane(ClassTablePanel);
		 ScrollPanel.setPreferredSize(new Dimension(1500,0));
		 ClassPanel.add(BorderLayout.EAST,ScrollPanel);
		 ClassModifyPanel = new JPanel();
		 ClassModifyPanel.setLayout(new GridLayout(11,1));
		 ClassModifyPanel.setPreferredSize(new Dimension(300,0));
		 ClassModifyPanel.setBackground(null);
		 ClassModifyPanel.setOpaque(false);
		 ClassGrade1 = new JRadioButton("大一");
		 ClassGrade2 = new JRadioButton("大二");
		 ClassGrade3 = new JRadioButton("大三");
		 ClassGrade4 = new JRadioButton("大四");
		 ClassGrade1.setOpaque(false);
		 ClassGrade2.setOpaque(false);
		 ClassGrade3.setOpaque(false);
		 ClassGrade4.setOpaque(false);
		 ButtonGroup Grade = new ButtonGroup();
		 Grade.add(ClassGrade1);
		 Grade.add(ClassGrade2);
		 Grade.add(ClassGrade3);
		 Grade.add(ClassGrade4);
		 ClassClass1 = new JRadioButton("一班");
		 ClassClass2 = new JRadioButton("二班");
		 ClassClass3 = new JRadioButton("三班");
		 ClassClass4 = new JRadioButton("四班");
		 ClassClass1.setOpaque(false);
		 ClassClass2.setOpaque(false);
		 ClassClass3.setOpaque(false);
		 ClassClass4.setOpaque(false);
		 ButtonGroup Class = new ButtonGroup();
		 Class.add(ClassClass1);
		 Class.add(ClassClass2);
		 Class.add(ClassClass3);
		 Class.add(ClassClass4);
		 JLabel head1 = new JLabel("选择年级",JLabel.CENTER);
		 head1.setFont(new Font("Dialog", 1, 30));
		 ClassModifyPanel.add(head1);
		 ClassModifyPanel.add(ClassGrade1);
		 ClassModifyPanel.add(ClassGrade2);
		 ClassModifyPanel.add(ClassGrade3);
		 ClassModifyPanel.add(ClassGrade4);
		 JLabel head2 = new JLabel("选择班级",JLabel.CENTER);
		 head2.setFont(new Font("Dialog", 1, 30));
		 ClassModifyPanel.add(head2);
		 ClassModifyPanel.add(ClassClass1);
		 ClassModifyPanel.add(ClassClass2);
		 ClassModifyPanel.add(ClassClass3);
		 ClassModifyPanel.add(ClassClass4);
		 ClassConfirm = new JButton("确定");
		 ClassConfirm.addActionListener(this);
		 ClassModifyPanel.add(ClassConfirm);
		 ClassPanel.add(BorderLayout.WEST,ClassModifyPanel);
		 
		 
	}

	private void initClassPanel(int grade,int _class) {
		// TODO Auto-generated method stub
		ClassPanel = new HomePanel();
		ClassPanel.setLayout(new BorderLayout());
		 StudentData sd = new StudentData();
		 Vector meta = sd.getMeta();
		 Vector score = sd.getByClass(grade,_class);
		 ClassTablePanel = new JTable(score,meta);
		 ClassTablePanel.setFont(new Font("微软雅黑",Font.PLAIN, 20));
		 DefaultTableCellRenderer r = new DefaultTableCellRenderer();   
		 r.setHorizontalAlignment(JLabel.CENTER);   
		 ClassTablePanel.setDefaultRenderer(Object.class, r);
		 ClassTablePanel.setRowHeight(24);
		 ClassTablePanel.setEnabled(false);
		 JScrollPane ScrollPanel=new JScrollPane(ClassTablePanel);
		 ScrollPanel.setPreferredSize(new Dimension(1500,0));
		 ClassPanel.add(BorderLayout.EAST,ScrollPanel);
		 ClassModifyPanel = new JPanel();
		 ClassModifyPanel.setLayout(new GridLayout(11,1));
		 ClassModifyPanel.setPreferredSize(new Dimension(300,0));
		 ClassModifyPanel.setBackground(null);
		 ClassModifyPanel.setOpaque(false);
		 ClassGrade1 = new JRadioButton("大一");
		 ClassGrade2 = new JRadioButton("大二");
		 ClassGrade3 = new JRadioButton("大三");
		 ClassGrade4 = new JRadioButton("大四");
		 ClassGrade1.setOpaque(false);
		 ClassGrade2.setOpaque(false);
		 ClassGrade3.setOpaque(false);
		 ClassGrade4.setOpaque(false);
		 ButtonGroup Grade = new ButtonGroup();
		 Grade.add(ClassGrade1);
		 Grade.add(ClassGrade2);
		 Grade.add(ClassGrade3);
		 Grade.add(ClassGrade4);
		 ClassClass1 = new JRadioButton("一班");
		 ClassClass2 = new JRadioButton("二班");
		 ClassClass3 = new JRadioButton("三班");
		 ClassClass4 = new JRadioButton("四班");
		 ClassClass1.setOpaque(false);
		 ClassClass2.setOpaque(false);
		 ClassClass3.setOpaque(false);
		 ClassClass4.setOpaque(false);
		 ButtonGroup Class = new ButtonGroup();
		 Class.add(ClassClass1);
		 Class.add(ClassClass2);
		 Class.add(ClassClass3);
		 Class.add(ClassClass4);
		 JLabel head1 = new JLabel("选择年级",JLabel.CENTER);
		 head1.setFont(new Font("Dialog", 1, 30));
		 ClassModifyPanel.add(head1);
		 ClassModifyPanel.add(ClassGrade1);
		 ClassModifyPanel.add(ClassGrade2);
		 ClassModifyPanel.add(ClassGrade3);
		 ClassModifyPanel.add(ClassGrade4);
		 JLabel head2 = new JLabel("选择班级",JLabel.CENTER);
		 head2.setFont(new Font("Dialog", 1, 30));
		 ClassModifyPanel.add(head2);
		 ClassModifyPanel.add(ClassClass1);
		 ClassModifyPanel.add(ClassClass2);
		 ClassModifyPanel.add(ClassClass3);
		 ClassModifyPanel.add(ClassClass4);
		 ClassConfirm = new JButton("确定");
		 ClassConfirm.addActionListener(this);
		 ClassModifyPanel.add(ClassConfirm);
		 ClassPanel.add(BorderLayout.WEST,ClassModifyPanel);
		 
		 
	}




	private void initScorePanel() {
		ScorePanel = new HomePanel();
		ScorePanel.setLayout(new BorderLayout());
		 StudentData sd = new StudentData();
		 Vector meta = sd.getScoreMeta();
		 Vector score = sd.getScore();
		 ScoreTablePanel = new JTable(score,meta);
		 ScoreTablePanel.setFont(new Font("微软雅黑",Font.PLAIN, 20));
		 DefaultTableCellRenderer r = new DefaultTableCellRenderer();   
		 r.setHorizontalAlignment(JLabel.CENTER);   
		 ScoreTablePanel.setDefaultRenderer(Object.class, r);
		 ScoreTablePanel.setRowHeight(24);
		 ScoreTablePanel.setEnabled(false);
		 JScrollPane ScrollPanel=new JScrollPane(ScoreTablePanel);
		 ScrollPanel.setPreferredSize(new Dimension(1500,0));
		 ScorePanel.add(BorderLayout.EAST,ScrollPanel);
		 ScoreModifyPanel = new JPanel(null);
		 ScoreModifyPanel.setPreferredSize(new Dimension(300,0));
		 ScoreModifyPanel.setBackground(null);
		 ScoreModifyPanel.setOpaque(false);
		 
		 JLabel head1 = new JLabel("修改学生分数",JLabel.CENTER);
		 head1.setFont(new Font("Dialog", 1, 30));
		 head1.setBounds(0,0,300,100);
		 ScoreModifyPanel.add(head1);
		 
		 Scoreid.setBounds(0, 200, 50, 50);
		 ScoreModifyPanel.add(Scoreid);
		 ScoreID = new JTextField(12);
		 ScoreID.setBounds(50, 200, 200, 50);
		 ScoreModifyPanel.add(ScoreID);
		 
		 Scoresubject.setBounds(0, 450, 50, 50);
		 ScoreModifyPanel.add(Scoresubject);
		 Subject = new JTextField(12);
		 Subject.setBounds(50, 450, 200, 50);
		 ScoreModifyPanel.add(Subject);
		 
		 Scorescore.setBounds(0, 700, 50, 50);
		 ScoreModifyPanel.add(Scorescore);
		 Score = new JTextField(12);
		 Score.setBounds(50, 700, 200, 50);
		 ScoreModifyPanel.add(Score);
		 
		 ScoreConfirm = new JButton("确定");
		 ScoreConfirm.setBounds(50, 850, 100, 50);
		 ScoreModifyPanel.add(ScoreConfirm);
		 
		 ScorePanel.add(BorderLayout.WEST,ScoreModifyPanel);
		 
		 
		 
	}

	
	private void initBasicPanel() {
		// TODO Auto-generated method stub
		//BasicPanel.add(new JButton());
		 BasicPanel = new HomePanel();
		 BasicPanel.setLayout(new BorderLayout());
		 StudentData sd = new StudentData();
		 Vector meta = sd.getBasicMeta();
		 Vector basic = sd.getBasic();
		 BasicTablePanel = new JTable(basic,meta);
		 BasicTablePanel.setFont(new Font("微软雅黑",Font.PLAIN, 20));
		 DefaultTableCellRenderer r = new DefaultTableCellRenderer();   
		 r.setHorizontalAlignment(JLabel.CENTER);   
		 BasicTablePanel.setDefaultRenderer(Object.class, r);
		 BasicTablePanel.setRowHeight(24);
		 BasicTablePanel.setEnabled(false);
		 JScrollPane ScrollPanel=new JScrollPane(BasicTablePanel);
		 ScrollPanel.setPreferredSize(new Dimension(1000,0));
		 BasicPanel.add(BorderLayout.EAST,ScrollPanel);
		 //addCom(CourseTablePanel,CoursePanel,c,0,0,100,100,1,1);
		 BasicModifyPanel = new JPanel(new GridBagLayout());
		 BasicModifyPanel.setPreferredSize(new Dimension(900,0));
		 BasicModifyPanel.setBackground(null);
		 BasicModifyPanel.setOpaque(false);
		 GridBagConstraints c = new GridBagConstraints();
		 //c.fill = GridBagConstraints.VERTICAL;
		 JLabel head1 = new JLabel("修改学生个人信息",JLabel.CENTER);
		 head1.setFont(new Font("Dialog", 1, 30));
		 addCom(head1,BasicModifyPanel,c,0,1,1,1,0.1,0.1);
		 addCom(new JLabel("学号："),BasicModifyPanel,c,1,0,1,1,0.1,0.1);
		 BasicID = new JTextField(12);
		 addCom(BasicID,BasicModifyPanel,c,1,0,1,2,0.1,0.1);
		 Search = new JButton("查找");
		 Search.addActionListener(this);
		 addCom(Search,BasicModifyPanel,c,1,2,1,1,0.1,0.1);
		 Delete = new JButton("删除记录");
		 Delete.setBackground(Color.RED);
		 Delete.addActionListener(this);
		 addCom(Delete,BasicModifyPanel,c,1,3,1,1,0.1,0.1);
		 BasicConfirm = new JButton("确定");
		 BasicConfirm.addActionListener(this);
		 BasicName = new JTextField(12);
		 addCom(new JLabel("姓名："),BasicModifyPanel,c,6,0,1,1,0.1,0.1);
		 addCom(BasicName,BasicModifyPanel,c,6,0,1,2,0.1,0.1);
		 male = new JRadioButton("男");
		 female = new JRadioButton("女");
		 ButtonGroup gender = new ButtonGroup();
		 gender.add(male);
		 gender.add(female);
		 addCom(male,BasicModifyPanel,c,7,0,1,1,0.1,0.1);
		 addCom(female,BasicModifyPanel,c,7,1,1,1,0.1,0.1);
		 BasicGrade1 = new JRadioButton("大一");
		 BasicGrade2 = new JRadioButton("大二");
		 BasicGrade3 = new JRadioButton("大三");
		 BasicGrade4 = new JRadioButton("大四");
		 ButtonGroup Grade = new ButtonGroup();
		 Grade.add(BasicGrade1);
		 Grade.add(BasicGrade2);
		 Grade.add(BasicGrade3);
		 Grade.add(BasicGrade4);
		 addCom(BasicGrade1,BasicModifyPanel,c,10,0,1,1,0.1,0.1);
		 addCom(BasicGrade2,BasicModifyPanel,c,10,1,1,1,0.1,0.1);
		 addCom(BasicGrade3,BasicModifyPanel,c,10,2,1,1,0.1,0.1);
		 addCom(BasicGrade4,BasicModifyPanel,c,10,3,1,1,0.1,0.1);
		 BasicClass1 = new JRadioButton("一班");
		 BasicClass2 = new JRadioButton("二班");
		 BasicClass3 = new JRadioButton("三班");
		 BasicClass4 = new JRadioButton("四班");
		 ButtonGroup Class = new ButtonGroup();
		 Class.add(BasicClass1);
		 Class.add(BasicClass2);
		 Class.add(BasicClass3);
		 Class.add(BasicClass4);
		 addCom(BasicClass1,BasicModifyPanel,c,13,0,1,1,0.1,0.1);
		 addCom(BasicClass2,BasicModifyPanel,c,13,1,1,1,0.1,0.1);
		 addCom(BasicClass3,BasicModifyPanel,c,13,2,1,1,0.1,0.1);
		 addCom(BasicClass4,BasicModifyPanel,c,13,3,1,1,0.1,0.1);
		 Local = new JRadioButton("本地生");
		 nonLocal = new JRadioButton("外地生");
		 ButtonGroup local = new ButtonGroup();
		 local.add(male);
		 local.add(female);
		 addCom(Local,BasicModifyPanel,c,16,0,1,1,0.1,0.1);
		 addCom(nonLocal,BasicModifyPanel,c,16,1,1,1,0.1,0.1);
		 PhoneNumber = new JTextField(12);
		 JLabel pn = new JLabel("电话：");
		 //pn.setOpaque(true);
		 addCom(pn,BasicModifyPanel,c,19,0,1,1,0.1,0.1);
		 addCom(PhoneNumber,BasicModifyPanel,c,19,0,1,2,0.1,0.1);
		 addCom(BasicConfirm,BasicModifyPanel,c,23,1,1,1,0.1,0.1);
		 BasicPanel.add(BorderLayout.WEST,BasicModifyPanel);
		 
		 
		 
		 

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
	        this.setSize((int)width,(int)height-53);//设置大小
	        this.setLocation(0,0); //设置窗体居中显示
	        this.setResizable(false);
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
		if(ClassConfirm==(JButton)e.getSource()) {
			int grade = 0,_class = 0;
			if(ClassGrade1.isSelected())
				grade =  1;
			if(ClassGrade2.isSelected())
				grade =  2;
			if(ClassGrade3.isSelected())
				grade =  3;
			if(ClassGrade4.isSelected())
				grade =  4;
			if(ClassClass1.isSelected())
				_class = 1;
			if(ClassClass2.isSelected())
				_class = 2;
			if(ClassClass3.isSelected())
				_class = 3;
			if(ClassClass4.isSelected())
				_class = 4;
			TabPane.remove(3);
			ClassPanel.removeAll();
			ClassPanel.repaint();
			if(grade == 0&&_class == 0)
				initClassPanel();
			else
				initClassPanel(grade,_class);
			ClassPanel.setVisible(false);
			TabPane.add(ClassPanel, 3);
			TabPane.setTitleAt(3, "Class");
			TabPane.setSelectedIndex(3);
		}
		
		
		if(Delete==(JButton)e.getSource()) {
			StudentData sd = new StudentData();
			if(sd.delete(Integer.valueOf(BasicID.getText()))) {
				JOptionPane.showMessageDialog(null, "删除成功！", "SIMS",JOptionPane.INFORMATION_MESSAGE);
				TabPane.remove(1);
				BasicPanel.removeAll();
				BasicPanel.repaint();
				initBasicPanel();
				BasicPanel.setVisible(true);
				TabPane.add(BasicPanel, 1);
				TabPane.setTitleAt(1, "Basic");
				TabPane.setSelectedIndex(1);
			}
			else
				JOptionPane.showMessageDialog(null, "学生不存在！", "SIMS",JOptionPane.INFORMATION_MESSAGE);
				
		}
		
		if(Search==(JButton)e.getSource()) {
			StudentData sd = new StudentData();
			Vector student = sd.getByID(Integer.valueOf(BasicID.getText()));
			BasicName.setText(student.get(1).toString());
			if((int)student.get(2)==1)
				male.setSelected(true);
			else
				female.setSelected(true);
			if((int)student.get(3)==1)
				BasicGrade1.setSelected(true);
			if((int)student.get(3)==2)
				BasicGrade2.setSelected(true);
			if((int)student.get(3)==3)
				BasicGrade3.setSelected(true);
			if((int)student.get(3)==4)
				BasicGrade4.setSelected(true);
			if((int)student.get(4)==1)
				BasicClass1.setSelected(true);
			if((int)student.get(4)==2)
				BasicClass2.setSelected(true);
			if((int)student.get(4)==3)
				BasicClass3.setSelected(true);
			if((int)student.get(4)==4)
				BasicClass4.setSelected(true);
			if((int)student.get(5)==1)
				Local.setSelected(true);
			else
				nonLocal.setSelected(true);
			PhoneNumber.setText(student.get(6).toString());
		}
		if(BasicConfirm==(JButton)e.getSource()) {
			boolean modify = true;
			StudentData sd = new StudentData();
			String student[] = new String[7];
			student[0] = BasicID.getText();
			student[1] = BasicName.getText();
			if(male.isSelected())
				student[2] = "1";
			else
				student[2] = "0";
			if(BasicGrade1.isSelected())
				student[3] = "1";
			if(BasicGrade2.isSelected())
				student[3] = "2";
			if(BasicGrade3.isSelected())
				student[3] = "3";
			if(BasicGrade4.isSelected())
				student[3] = "4";
			if(BasicClass1.isSelected())
				student[4] = "1";
			if(BasicClass2.isSelected())
				student[4] = "2";
			if(BasicClass3.isSelected())
				student[4] = "3";
			if(BasicClass4.isSelected())
				student[4] = "4";
			if(Local.isSelected())
				student[5] = "1";
			else
				student[5] = "0";
			student[6] = PhoneNumber.getText();
			try{
				Vector retrive= sd.getByID(Integer.valueOf(BasicID.getText()));
				if(retrive.size()==0)
					throw new NumberFormatException();
			}catch (NumberFormatException e1) {	
				JOptionPane.showMessageDialog(null, "用户不存在，将增加学生信息！", "SIMS",JOptionPane.INFORMATION_MESSAGE);
				if(sd.BasicInsert(student)) {
					JOptionPane.showMessageDialog(null, "增加成功！", "SIMS",JOptionPane.INFORMATION_MESSAGE);
					TabPane.remove(1);
					BasicPanel.removeAll();
					BasicPanel.repaint();
					initBasicPanel();
					BasicPanel.setVisible(true);
					TabPane.add(BasicPanel, 1);
					TabPane.setTitleAt(1, "Basic");
					TabPane.setSelectedIndex(1);
				}
				else
					JOptionPane.showMessageDialog(null, "增加失败，请正确填写！", "SIMS",JOptionPane.INFORMATION_MESSAGE);
				modify = false;
			}
			if(modify) {
				if(sd.BasicSet(student)) {
					JOptionPane.showMessageDialog(null, "修改成功！", "SIMS",JOptionPane.INFORMATION_MESSAGE);
					TabPane.remove(1);
					BasicPanel.removeAll();
					BasicPanel.repaint();
					initBasicPanel();
					BasicPanel.setVisible(true);
					TabPane.add(BasicPanel, 1);
					TabPane.setTitleAt(1, "Basic");
					TabPane.setSelectedIndex(1);
				}
				else
					JOptionPane.showMessageDialog(null, "修改失败，请正确填写！", "SIMS",JOptionPane.INFORMATION_MESSAGE);
			}
		}
		
	}
}