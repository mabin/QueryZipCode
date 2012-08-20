package frame;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.filechooser.FileFilter;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.SwingConstants;

import utils.OptData;
import utils.OptFile;

import beans.AddressInfo;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JMenuBar menuBar;
	private JMenu mnNewMenu;
	private JMenuItem mntmNewMenuItem;
	private JPanel optPanel;
	private JPanel singlePanel;
	private JLabel lblxml;
	private JTextField srcField;
	private JButton srcBtn,GenrateBtn;
	private JTextField destField;
	private JButton destBtn,dbBtn ;
	
	String sourceFilePath;
	String destFilePath;
	String databaseFilePath;
	List<AddressInfo> addrs = new ArrayList<AddressInfo>();
	private JLabel label_1;
	private JTextField dbtextField;
	
	public MainFrame() {
		setTitle("Query Info From ZipCode");
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnNewMenu = new JMenu("\u5E2E\u52A9");
		menuBar.add(mnNewMenu);
		
		mntmNewMenuItem = new JMenuItem("\u5173\u4E8E");
		mnNewMenu.add(mntmNewMenuItem);
		setSize(800, 450);
		
		//Container container = this.getContentPane();
		getContentPane().setLayout(null);
		
		optPanel = new JPanel();
		optPanel.setBounds(0, 0, 784, 400);
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
					sourceFilePath = srcField.getText();
					databaseFilePath = dbtextField.getText();
					destFilePath = destField.getText()+"\\out.xls";
					OptData data = new OptData();
					data.initData(sourceFilePath, databaseFilePath);
					List<AddressInfo> result = data.PackageData();
					OptFile.setFileData(destFilePath, result);
					int isOK = JOptionPane.showConfirmDialog(null, destFilePath, "目标文件已经生成成功",
				              JOptionPane.ERROR_MESSAGE);
					if (isOK != -1){
						srcField.setText("");
						destField.setText("");
						dbtextField.setText("");
					}
				}
			}
		});
		GenrateBtn.setBounds(120, 310, 249, 39);
		singlePanel.add(GenrateBtn);
		
		srcBtn = new JButton("选择");
		srcBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (arg0.getSource() == srcBtn){
				JFileChooser singleChooser = new JFileChooser();
				singleChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
				singleChooser.setDialogTitle("选择源文件");
				
				singleChooser.setFileFilter(new FileFilter(){

					@Override
					public boolean accept(File arg0) {
						if (arg0.isDirectory()){
							return true;
						}
						return arg0.getName().endsWith(".xls");
					}

					@Override
					public String getDescription() {
						// TODO Auto-generated method stub
						return "*.xls";
					}
					
				});
				int result = singleChooser.showOpenDialog(singlePanel); 
				if (result == JFileChooser.APPROVE_OPTION){
					srcField.setText(singleChooser.getSelectedFile().getAbsolutePath());
				}
			}
			}
		});
		srcBtn.setBounds(686, 93, 77, 39);
		singlePanel.add(srcBtn);
		
		
		
		JLabel label = new JLabel("目标文件");
		label.setFont(new Font("微软雅黑", Font.BOLD, 25));
		label.setBounds(10, 167, 100, 39);
		singlePanel.add(label);
		
		destField = new JTextField();
		destField.setColumns(10);
		destField.setBounds(120, 172, 556, 39);
		singlePanel.add(destField);
		
		destBtn = new JButton("选择");
		destBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == destBtn){
					JFileChooser singleChooser = new JFileChooser();
					singleChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
					singleChooser.setDialogTitle("选择目标文件目录");
					
					singleChooser.setFileFilter(new FileFilter(){

						@Override
						public boolean accept(File arg0) {
							if (arg0.isDirectory()){
								return true;
							}
							return arg0.getName().endsWith(".xls");
						}

						@Override
						public String getDescription() {
							// TODO Auto-generated method stub
							return "*.xls";
						}
						
					});
					int result = singleChooser.showOpenDialog(singlePanel); 
					if (result == JFileChooser.APPROVE_OPTION){
						destField.setText(singleChooser.getSelectedFile().getAbsolutePath());
					}
				}
			}
		});
		destBtn.setBounds(686, 172, 77, 39);
		singlePanel.add(destBtn);
		
		JButton restBtn = new JButton("清空");
		restBtn.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		restBtn.setBounds(427, 310, 249, 39);
		singlePanel.add(restBtn);
		
		JLabel lblQueryInformationFrom = new JLabel("Query Information From Zip Code");
		lblQueryInformationFrom.setHorizontalAlignment(SwingConstants.CENTER);
		lblQueryInformationFrom.setFont(new Font("微软雅黑", Font.BOLD, 25));
		lblQueryInformationFrom.setBounds(126, 23, 531, 39);
		singlePanel.add(lblQueryInformationFrom);
		
		label_1 = new JLabel("\u6570\u636E\u6587\u4EF6");
		label_1.setFont(new Font("微软雅黑", Font.BOLD, 25));
		label_1.setBounds(10, 248, 100, 39);
		singlePanel.add(label_1);
		
		dbtextField = new JTextField();
		dbtextField.setColumns(10);
		dbtextField.setBounds(120, 253, 556, 39);
		singlePanel.add(dbtextField);
		
		dbBtn = new JButton("\u9009\u62E9");
		dbBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == dbBtn){
					JFileChooser singleChooser = new JFileChooser();
					singleChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
					singleChooser.setDialogTitle("选择数据库文件");
					
					singleChooser.setFileFilter(new FileFilter(){

						@Override
						public boolean accept(File arg0) {
							if (arg0.isDirectory()){
								return true;
							}
							return arg0.getName().endsWith(".xls");
						}

						@Override
						public String getDescription() {
							// TODO Auto-generated method stub
							return "*.xls";
						}
						
					});
					int result = singleChooser.showOpenDialog(singlePanel); 
					if (result == JFileChooser.APPROVE_OPTION){
						dbtextField.setText(singleChooser.getSelectedFile().getAbsolutePath());
					}
				
				}
			}
		});
		dbBtn.setBounds(686, 248, 77, 39);
		singlePanel.add(dbBtn);
	}
}
