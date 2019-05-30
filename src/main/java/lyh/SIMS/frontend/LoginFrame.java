package lyh.SIMS.frontend;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginFrame extends JFrame
implements ActionListener{
    private JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
    private JPanel InputPanel = new JPanel();
    private JPanel userPanel = new JPanel();
    private JPanel passwordPanel = new JPanel();
    private JButton ConfirmButton = new JButton("登录");
    private JButton CancelButton = new JButton("退出");
    private JTextField user = new JTextField(8);
    private JPasswordField password = new JPasswordField(8);
    
    private void initLayout() {
        initInputPannel();
        this.getContentPane().setLayout(new BorderLayout());
        this.add(BorderLayout.CENTER,InputPanel);
        initButtonPanel();
        this.add(BorderLayout.SOUTH,buttonPanel);
    }
    
	private void initButtonPanel() {
		// TODO Auto-generated method stub
        GridBagConstraints gridBag = new GridBagConstraints();
		ConfirmButton.addActionListener(this);
		buttonPanel.add(ConfirmButton);
        buttonPanel.add(ConfirmButton);
        CancelButton.addActionListener(this);
        buttonPanel.add(CancelButton);
	}

	private void initInputPannel() {
		// TODO Auto-generated method stub
		user.addActionListener(this);
		user.setPreferredSize(new Dimension(10,40));
		userPanel.add(new JLabel("账号："));
		userPanel.add(user);
		password.addActionListener(this);
		password.setPreferredSize(new Dimension(10,40));
		passwordPanel.add(new JLabel("密码："));
		passwordPanel.add(password);
		InputPanel.setLayout(new GridLayout(3,1));
		JLabel head = new JLabel(">>>>>>>>>>>>>>>>>小学生成绩管理系统<<<<<<<<<<<<<<<<<",JLabel.CENTER);
		head.setFont(new Font("Dialog", 1, 30));
		InputPanel.add(head);
		InputPanel.add(userPanel);
		InputPanel.add(passwordPanel);
		
	}

	public LoginFrame() {
        super("Login");
        this.getContentPane().setLayout(new BorderLayout());
        double width = Toolkit.getDefaultToolkit().getScreenSize().width/2; //得到当前屏幕分辨率的高
        double height = Toolkit.getDefaultToolkit().getScreenSize().height/2;//得到当前屏幕分辨率的宽
        this.setSize((int)width,(int)height);//设置大小
        this.setLocation((int)width/2,(int)height/2); //设置窗体居中显示
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        initLayout();
        this.setVisible(true);
    }
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
