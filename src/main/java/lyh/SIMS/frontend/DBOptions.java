package lyh.SIMS.frontend;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.TitledBorder;

public class DBOptions extends JDialog
implements ActionListener
{
    private JTabbedPane dbTabPane = new JTabbedPane();
    private JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
    private JButton okButton = new JButton("OK");
    private JButton cancelButton = new JButton("Cancel");
    private JButton helpButton = new JButton("Help");
    private JPanel loginPanel = new JPanel(new GridLayout(10, 1));
    private JCheckBox pwdBox = new JCheckBox("Remember passwords", true);
    private JCheckBox dspBox = new JCheckBox("Display all schemaa", true);
    private JPanel queryPanel = new JPanel(new GridLayout(3, 1));
    private JPanel radioPanel = new JPanel(new GridLayout(3, 1));
    private JRadioButton needRadio = new JRadioButton("As needed", true);
    private JRadioButton allRadio = new JRadioButton("All", false);
    private JRadioButton cacheRadio = new JRadioButton("Uncached", false);
    private JPanel boxPanel = new JPanel(new GridLayout(3, 1));
    private JCheckBox reqBox = new JCheckBox("Request Updatable queries", true);
    private JCheckBox saveBox = new JCheckBox("Save Changes using transactions", true);
    private JCheckBox autoBox = new JCheckBox("Automatically generate catalog in queries", true);
    private GridBagConstraints gridBag = new GridBagConstraints();
    private JPanel drvPanel = new JPanel(new GridBagLayout());
    private JLabel tipLabel = new JLabel("Note: Please Confirm the drivers are on the classpath when attempting to use it.");
    private JLabel urlLabel = new JLabel("Sample URL:");
    private String[] drvStrs = {"sun.jdbc.odbc.JdbcOdbcDriver", "com.sybase.jdbc.SybDriver"
                              , "com.informix.jdbc.IfxDriver", "com.borland.datastore.jdbc.DataStoreDriver"
                              , "COM.ibm.db2.app.jdbc.DB2Driver", "oracle.jdbc.driver.OracleDriver"
                              , "interbase.interclient.Driver", "weblogic.jdbc.mssqlserver4.Driver"};
    private String[] smpUrl = {"jdbc:odbc:odbcDataSource", "jdbc:sybase:Tds:hostname:2025"
                             , "informix-sqli://hostname:1526/dbname:INFORMIXSERVER=informixservername;user=username;password=password"
                             , "borland:dslocal:directoryAndFile.jds", "jdbc:db2://hostname:50002/database"
                             , "jdbc:oracle:thin:@hostname:1521:ORCL", "interbase://hostname/directoryAndFile.gdb"
                             , "weblogic:mssqlserver4:hostname:1433"};
    private JTable drvTable = new JTable(8, 1);
    private JScrollPane drvScroll = new JScrollPane(drvTable);
    private JTextField urlField = new JTextField();
    private JButton addButton = new JButton("Add");
    private JButton editButton = new JButton("Edit");
    private JButton removeButton = new JButton("Remove");

    public DBOptions(Frame parent, String title, boolean modal)
    {
        super(parent, title, modal);
        this.getContentPane().setLayout(new BorderLayout());
        double width = Toolkit.getDefaultToolkit().getScreenSize().width; //得到当前屏幕分辨率的高
        double height = Toolkit.getDefaultToolkit().getScreenSize().height;//得到当前屏幕分辨率的宽
        this.setSize((int)width,(int)height);//设置大小
        this.setLocation(0,0); //设置窗体居中显示
        this.setResizable(false);//禁用最大化按钮
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        initLayout();
        MouseClick mc = new MouseClick();
        drvTable.addMouseListener(mc);
    }

    private void initLayout()
    {
        initDBTabPane();
        this.getContentPane().add(BorderLayout.CENTER, dbTabPane);
        initButtonPanel();
        this.getContentPane().add(BorderLayout.SOUTH, buttonPanel);
    }

    private void add(Container cn, Component c, GridBagConstraints gbc, int x, int y, int w, int h)
    {
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.gridwidth = w;
        gbc.gridheight = h;
        cn.add(c, gbc);
    }

    private void initDBTabPane()
    {
        pwdBox.setMnemonic('P');
        loginPanel.add(pwdBox);
        dspBox.setMnemonic('D');
        loginPanel.add(dspBox);
        dbTabPane.add("Login", loginPanel);
        needRadio.setMnemonic('N');
        needRadio.addActionListener(this);
        allRadio.setMnemonic('A');
        allRadio.addActionListener(this);
        cacheRadio.setMnemonic('U');
        cacheRadio.addActionListener(this);
        radioPanel.setBorder(new TitledBorder("Load Option"));
        radioPanel.add(needRadio);
        radioPanel.add(allRadio);
        radioPanel.add(cacheRadio);
        queryPanel.add(radioPanel);
        reqBox.setMnemonic('R');
        boxPanel.add(reqBox);
        saveBox.setMnemonic('S');
        boxPanel.add(saveBox);
        autoBox.setMnemonic('t');
        boxPanel.add(autoBox);
        queryPanel.add(boxPanel);
        dbTabPane.add("Query", queryPanel);
        initDrvPanel();
    }

    private void initButtonPanel()
    {
        okButton.setMnemonic('O');
        okButton.addActionListener(this);
        buttonPanel.add(okButton);
        cancelButton.setMnemonic('C');
        cancelButton.addActionListener(this);
        buttonPanel.add(cancelButton);
        helpButton.setMnemonic('H');
        helpButton.addActionListener(this);
        buttonPanel.add(helpButton);
    }

    private void initDrvPanel()
    {
        gridBag.fill = GridBagConstraints.HORIZONTAL;
        gridBag.weightx = 100;
        gridBag.weighty = 0;
        tipLabel.setForeground(Color.black);
        this.add(drvPanel, tipLabel, gridBag, 0, 0, 4, 1);
        urlLabel.setForeground(Color.black);
        this.add(drvPanel, urlLabel, gridBag, 0, 5, 4, 1);
        urlField.setText("jdbc:odbc:DataSources");
        urlField.setEditable(false);
        this.add(drvPanel, urlField, gridBag, 0, 6, 4, 1);
        gridBag.weightx = 0;
        gridBag.weighty = 0;
        addButton.setMnemonic('A');
        addButton.addActionListener(this);
        this.add(drvPanel, addButton, gridBag, 3, 1, 1, 1);
        editButton.setMnemonic('E');
        editButton.addActionListener(this);
        this.add(drvPanel, editButton, gridBag, 3, 2, 1, 1);
        removeButton.setMnemonic('R');
        removeButton.addActionListener(this);
        this.add(drvPanel, removeButton, gridBag, 3, 3, 1, 1);
        gridBag.fill = GridBagConstraints.BOTH;
        gridBag.weightx = 100;
        gridBag.weighty = 100;
        for (int i = 0; i < 8; i++)
            drvTable.setValueAt(drvStrs[i], i, 0);
        drvTable.getColumn(drvTable.getColumnName(0)).setHeaderValue("All Drivers");
        drvTable.setShowGrid(false);
        this.add(drvPanel, drvScroll, gridBag, 0, 1, 3, 4);
        dbTabPane.add("Drivers", drvPanel);
    }

    public void actionPerformed(ActionEvent event)
    {
        Object src = event.getSource();
        if (src == okButton || src == cancelButton)
        {
            this.setVisible(false);
            this.dispose();
        }
        else if (src == helpButton)
        {
            JOptionPane.showMessageDialog(this
                                         , "Sorry, Help is not available!"
                                         , "Alert"
                                         , JOptionPane.QUESTION_MESSAGE
                                         , new ImageIcon("D:\\icon\\about24.gif"));
        }
        else if (src == needRadio)
        {
            needRadio.setSelected(true);
            allRadio.setSelected(false);
            cacheRadio.setSelected(false);
        }
        else if (src == allRadio)
        {
            needRadio.setSelected(false);
            allRadio.setSelected(true);
            cacheRadio.setSelected(false);
        }
        else if (src == cacheRadio)
        {
            needRadio.setSelected(false);
            allRadio.setSelected(false);
            cacheRadio.setSelected(true);
        }
    }

    class MouseClick extends MouseAdapter
    {
        public void mouseClicked(MouseEvent me)
        {
            if (me.getClickCount() == 1)
            {
                urlField.setText(smpUrl[drvTable.getSelectedRow()]);
            }
        }
    }
}