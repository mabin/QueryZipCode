package frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;



import java.awt.GridLayout;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.filechooser.FileFilter;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.util.List;
import java.util.Map;

import javax.swing.JComboBox;
import javax.swing.SwingConstants;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private String companyName;
	private JMenuBar menuBar;
	private JMenu mnNewMenu;
	private JMenuItem mntmNewMenuItem;
	private JPanel optPanel;
	private JPanel consolepanel;
	private JScrollPane scrollPane;
	private JTextArea consoleArea;
	private JPanel singlePanel;
	private JLabel lblxml;
	private JTextField srcField;
	private JComboBox<String> comboBox,comboBox_1;
	private JButton srcBtn,GenrateBtn;
	private JTextField destField;
	
	public MainFrame() {
		setTitle("XML2PDF");
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnNewMenu = new JMenu("\u5E2E\u52A9");
		menuBar.add(mnNewMenu);
		
		mntmNewMenuItem = new JMenuItem("\u5173\u4E8E");
		mnNewMenu.add(mntmNewMenuItem);
		setSize(800, 600);
		
		//Container container = this.getContentPane();
		getContentPane().setLayout(null);
		
		optPanel = new JPanel();
		optPanel.setBounds(0, 0, 784, 280);
		getContentPane().add(optPanel);
		optPanel.setLayout(new GridLayout(1, 2, 0, 0));
		
		singlePanel = new JPanel();
		//singlePanel.setBorder(UIManager.getBorder("SplitPane.border"));
		optPanel.add(singlePanel);
		singlePanel.setLayout(null);
		
		lblxml = new JLabel("源文件");
		lblxml.setFont(new Font("微软雅黑", Font.BOLD, 25));
		lblxml.setBounds(10, 88, 87, 39);
		singlePanel.add(lblxml);
		
		srcField = new JTextField();
		srcField.setBounds(120, 93, 556, 39);
		singlePanel.add(srcField);
		srcField.setColumns(10);
		
		GenrateBtn = new JButton("生成");
		GenrateBtn.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		GenrateBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == GenrateBtn){
				consoleArea.append(srcField.getText());
				printLog("\r\nÉú³É³É¹¦£¬Çë´ò¿ªÄ¿±êÎÄ¼þ¼Ð");
				}
			}
		});
		GenrateBtn.setBounds(120, 231, 249, 39);
		singlePanel.add(GenrateBtn);
		
		srcBtn = new JButton("选择");
		srcBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (arg0.getSource() == srcBtn){
				JFileChooser singleChooser = new JFileChooser();
				singleChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
				singleChooser.setDialogTitle("µ¼Èëµ¥¸öÎÄ¼þ ");
				
				singleChooser.setFileFilter(new FileFilter(){

					@Override
					public boolean accept(File arg0) {
						if (arg0.isDirectory()){
							return true;
						}
						return arg0.getName().endsWith(".XML");
					}

					@Override
					public String getDescription() {
						// TODO Auto-generated method stub
						return "*.XML";
					}
					
				});
				int result = singleChooser.showOpenDialog(singlePanel); 
				if (result == JFileChooser.APPROVE_OPTION){
					srcField.setText(singleChooser.getSelectedFile().getAbsolutePath());
					printLog("Ñ¡ÔñÁË"+singleChooser.getSelectedFile().getAbsolutePath());
				}
			}
			}
		});
		srcBtn.setBounds(686, 93, 77, 39);
		singlePanel.add(srcBtn);
		
		
		comboBox.setBounds(130, 202, 142, 21);
		singlePanel.add(comboBox);
		
		JLabel label = new JLabel("输出文件");
		label.setFont(new Font("微软雅黑", Font.BOLD, 25));
		label.setBounds(10, 167, 100, 39);
		singlePanel.add(label);
		
		destField = new JTextField();
		destField.setColumns(10);
		destField.setBounds(120, 172, 556, 39);
		singlePanel.add(destField);
		
		JButton destBtn = new JButton("选择");
		destBtn.setBounds(686, 172, 77, 39);
		singlePanel.add(destBtn);
		
		JButton restBtn = new JButton("重置");
		restBtn.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		restBtn.setBounds(425, 231, 249, 39);
		singlePanel.add(restBtn);
		
		JLabel lblQueryInformationFrom = new JLabel("Query Information From Zip Code");
		lblQueryInformationFrom.setHorizontalAlignment(SwingConstants.CENTER);
		lblQueryInformationFrom.setFont(new Font("微软雅黑", Font.BOLD, 25));
		lblQueryInformationFrom.setBounds(126, 23, 531, 39);
		singlePanel.add(lblQueryInformationFrom);
		comboBox.setSelectedIndex(0);
		comboBox.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if (e.getSource() == comboBox) {
					
					companyName = comboBox.getSelectedItem().toString();
					printLog("ÄãÑ¡ÔñÁË  "+companyName);
				}
			}
		});
		
		comboBox_1.setBounds(149, 202, 142, 21);
		comboBox_1.setSelectedIndex(0);
		comboBox_1.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getSource() == comboBox_1) {
					
					// TODO Auto-generated method stub
					companyName = comboBox_1.getSelectedItem().toString();
					printLog("ÄãÑ¡ÔñÁË  "+companyName);
				}
			}
		});
		
		consolepanel = new JPanel();
		consolepanel.setBounds(0, 281, 784, 260);
		getContentPane().add(consolepanel);
		consolepanel.setLayout(new GridLayout(0, 1, 0, 0));
		
		scrollPane = new JScrollPane();
		scrollPane.setEnabled(false);
		scrollPane.setViewportBorder(null);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		consolepanel.add(scrollPane,BorderLayout.CENTER);
		
		consolepanel.add(scrollPane);
		
		consoleArea = new JTextArea();
		consoleArea.setBackground(Color.BLACK);
		consoleArea.setForeground(Color.GREEN);
		consoleArea.setWrapStyleWord(true);
		consoleArea.setEditable(false);
		scrollPane.setViewportView(consoleArea);
	}
	
	private void printLog(String logInfo){
		consoleArea.append(logInfo+"\n");
	}
}
