package lyh.SIMS.frontend;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import lyh.SIMS.database.UserData;

public class LoginFrame extends JFrame
implements ActionListener{
	private BackgroundPanel BGP;
    private JPanel ButtonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));    
    private JPanel ButtonPanel1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
    private JPanel ButtonPanel2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
    private JPanel InputPanel = new JPanel();
    private JPanel RegisterPanel = new JPanel();
    private JPanel RegisterPanel1 = new JPanel();
    
    private JPanel userPanel = new JPanel();
    private JPanel user1Panel = new JPanel();
    private JPanel user2Panel = new JPanel();

    private JPanel passwordPanel = new JPanel();
    private JPanel password1Panel = new JPanel();
    private JPanel password2Panel = new JPanel();
    
    private JButton ConfirmButton = new JButton("登录");
    private JButton RegisterButton = new JButton("注册");
    private JButton IntoRegisterButton = new JButton("注册");
    private JButton ReturnButton = new JButton("返回");
    private JButton RegisterConfirmButton = new JButton("确定");
    private JButton ReturnButton1 = new JButton("返回");


    private JTextField user = new JTextField(12);
    private JTextField user1 = new JTextField(12);
    private JTextField user2 = new JTextField(12);
    private JPasswordField password = new JPasswordField(12);
    private JPasswordField password1 = new JPasswordField(12);
    private JPasswordField password2 = new JPasswordField(12);


    private void initLayout() {
    	this.getContentPane().setLayout(new BorderLayout());
        this.add(BorderLayout.CENTER,InputPanel);
        this.add(BorderLayout.SOUTH,ButtonPanel);
        
    }
    
    
    
	private void initRegisterLayout() {
        this.getContentPane().setLayout(new BorderLayout());
        this.add(BorderLayout.CENTER,RegisterPanel);
        this.add(BorderLayout.SOUTH,ButtonPanel1);
	}
    
	private void initRegisterLayout1() {
        this.getContentPane().setLayout(new BorderLayout());
        this.add(BorderLayout.CENTER,RegisterPanel1);
        this.add(BorderLayout.SOUTH,ButtonPanel2);
	}
	
	private void initButtonPanel() {
		ConfirmButton.addActionListener(this);
		ButtonPanel.add(ConfirmButton);
		RegisterButton.addActionListener(this);
		ButtonPanel.add(RegisterButton);
        IntoRegisterButton.addActionListener(this);
        ButtonPanel1.add(IntoRegisterButton);
		ReturnButton.addActionListener(this);
		ButtonPanel1.add(ReturnButton);
		RegisterConfirmButton.addActionListener(this);
		ButtonPanel2.add(RegisterConfirmButton);
		ReturnButton1.addActionListener(this);
		ButtonPanel2.add(ReturnButton1);
		
	}
	 
	private void initInputPannel() {
		user.setPreferredSize(new Dimension(6,40));
		userPanel.add(new JLabel("账号："));
		userPanel.add(user);
		password.setPreferredSize(new Dimension(6,40));
		passwordPanel.add(new JLabel("密码："));
		passwordPanel.add(password);
		InputPanel.setLayout(new GridLayout(3,1,10,10));
		JLabel head = new JLabel("学生成绩管理系统",JLabel.CENTER);
		head.setFont(new Font("Dialog", 1, 30));
		InputPanel.add(head);
		InputPanel.add(userPanel);
		InputPanel.add(passwordPanel);
		user1.setPreferredSize(new Dimension(6,40));
		user1Panel.add(new JLabel("管理员账号："));
		user1Panel.add(user1);
		password1.setPreferredSize(new Dimension(6,40));
		password1Panel.add(new JLabel("密码："));
		password1Panel.add(password1);
		RegisterPanel.setLayout(new GridLayout(3,1,10,10));
		JLabel head1 = new JLabel("用户注册",JLabel.CENTER);
		head1.setFont(new Font("Dialog", 1, 30));
		RegisterPanel.add(head1);
		RegisterPanel.add(user1Panel);
		RegisterPanel.add(password1Panel);
		user2.setPreferredSize(new Dimension(6,40));
		user2Panel.add(new JLabel("新账号："));
		user2Panel.add(user2);
		password2.setPreferredSize(new Dimension(6,40));
		password2Panel.add(new JLabel("新账号密码："));
		password2Panel.add(password2);
		RegisterPanel1.setLayout(new GridLayout(3,1,10,10));
		JLabel head2 = new JLabel("注册新账号",JLabel.CENTER);
		head2.setFont(new Font("Dialog", 1, 30));
		RegisterPanel1.add(head2);
		RegisterPanel1.add(user2Panel);
		RegisterPanel1.add(password2Panel);
	}

	public LoginFrame() {
        super("Login");
        this.getContentPane().setLayout(new BorderLayout());
        BGP=new BackgroundPanel((new ImageIcon("C:\\Users\\l4728\\git\\SIMS\\src\\main\\java\\lyh\\SIMS\\frontend\\yazi.jpg")).getImage());
        BGP.setBounds(0,0,100,100);
        new Color(getDefaultCloseOperation());
        this.add(BGP);
        this.setSize(500,300);//设置大小
        this.setLocationRelativeTo(null);  //设置窗体居中显示
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.setResizable(false);
        initInputPannel();
        initButtonPanel();
        initLayout();
        this.setVisible(true);
    }
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(RegisterButton==(JButton)e.getSource()) {
			this.getContentPane().removeAll();
			this.repaint();
			initRegisterLayout();
	        this.setVisible(true);

		}
		
		if(ReturnButton==(JButton)e.getSource()) {
			this.getContentPane().removeAll();
			this.repaint();
			initLayout();
			this.setVisible(true);
		}
		
		if(ReturnButton1==(JButton)e.getSource()) {
			this.getContentPane().removeAll();
			this.repaint();
			initLayout();
			this.setVisible(true);
		}
		
		if(IntoRegisterButton == (JButton)e.getSource()) {
			String userstr = user1.getText();
			if(!userstr.equals("admin"))
				JOptionPane.showMessageDialog(null, "该账号不是管理员账号！", "错误",JOptionPane.ERROR_MESSAGE);
			String passwordstr = String.valueOf(password1.getPassword());
			UserData ud = new UserData();
			boolean vertification = false;
			try {
				vertification = ud.vertify(userstr, passwordstr);
				}catch(NullPointerException e1) {
					System.out.println("账号不存在！");
					Toolkit.getDefaultToolkit().beep();
					JOptionPane.showMessageDialog(null, "账号不存在！", "错误",JOptionPane.ERROR_MESSAGE);
				}finally {
				if(vertification) {
					this.getContentPane().removeAll();
					this.repaint();
					initRegisterLayout1();
					this.setVisible(true);
				}
				else {
					System.out.println("登陆失败");
					JOptionPane.showMessageDialog(null, "登陆失败！", "错误",JOptionPane.ERROR_MESSAGE);
					ud.close();
				}
			}
			user1.setText(null);
			password1.setText(null);
		}
		
		if(RegisterConfirmButton==(JButton)e.getSource()) {
			UserData ud = new UserData();
			if(ud.addUser(user2.getText(), password2.getPassword())) {
				JOptionPane.showMessageDialog(null, "注册成功！", "SIMS",JOptionPane.INFORMATION_MESSAGE);
				this.getContentPane().removeAll();
				this.repaint();
				initLayout();
				this.setVisible(true);
			}
			else {
				Toolkit.getDefaultToolkit().beep();
				JOptionPane.showMessageDialog(null, "注册失败！", "错误",JOptionPane.ERROR_MESSAGE);
			}
			user2.setText(null);
			password2.setText(null);
		}
		
		if(ConfirmButton==(JButton)e.getSource()) {
			String userstr = user.getText();
			String passwordstr = String.valueOf(password.getPassword());
			UserData ud = new UserData();
			boolean vertification = false;
			try {
				vertification = ud.vertify(userstr, passwordstr);
				}catch(NullPointerException e1) {
					System.out.println("账号不存在！");
					Toolkit.getDefaultToolkit().beep();
					JOptionPane.showMessageDialog(null, "账号不存在！", "错误",JOptionPane.ERROR_MESSAGE);
				}finally {
				if(vertification) {
					System.out.println("登陆成功");
					JOptionPane.showMessageDialog(null, "欢迎使用SIMS！", "SIMS",JOptionPane.INFORMATION_MESSAGE);
					ud.close();
					this.setVisible(false);
					new MainFrame();
				}
				else {
					System.out.println("登陆失败");
					JOptionPane.showMessageDialog(null, "登陆失败！", "错误",JOptionPane.ERROR_MESSAGE);
					ud.close();
				}
			}
		}
	}
	
}
