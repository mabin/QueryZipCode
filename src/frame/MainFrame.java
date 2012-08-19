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
import javax.swing.filechooser.FileFilter;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;

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
		
		lblxml = new JLabel("111");
		lblxml.setFont(new Font("111", Font.BOLD, 25));
		lblxml.setBounds(10, 88, 87, 39);
		singlePanel.add(lblxml);
		
		srcField = new JTextField();
		srcField.setBounds(120, 93, 556, 39);
		singlePanel.add(srcField);
		srcField.setColumns(10);
		
		GenrateBtn = new JButton("222");
		GenrateBtn.setFont(new Font("222", Font.PLAIN, 20));
		GenrateBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == GenrateBtn){
				consoleArea.append(srcField.getText());
				printLog("\r\n333");
				}
			}
		});
		GenrateBtn.setBounds(120, 231, 249, 39);
		singlePanel.add(GenrateBtn);
		
		srcBtn = new JButton("444");
		srcBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (arg0.getSource() == srcBtn){
				JFileChooser singleChooser = new JFileChooser();
				singleChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
				singleChooser.setDialogTitle("444");
				
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
					printLog("555"+singleChooser.getSelectedFile().getAbsolutePath());
				}
			}
			}
		});
		srcBtn.setBounds(686, 93, 77, 39);
		singlePanel.add(srcBtn);
		
		
		
		JLabel label = new JLabel("666");
		label.setFont(new Font("666", Font.BOLD, 25));
		label.setBounds(10, 167, 100, 39);
		singlePanel.add(label);
		
		destField = new JTextField();
		destField.setColumns(10);
		destField.setBounds(120, 172, 556, 39);
		singlePanel.add(destField);
		
		JButton destBtn = new JButton("777");
		destBtn.setBounds(686, 172, 77, 39);
		singlePanel.add(destBtn);
		
		JButton restBtn = new JButton("8888");
		restBtn.setFont(new Font("8888", Font.PLAIN, 20));
		restBtn.setBounds(425, 231, 249, 39);
		singlePanel.add(restBtn);
		
		JLabel lblQueryInformationFrom = new JLabel("Query Information From Zip Code");
		lblQueryInformationFrom.setHorizontalAlignment(SwingConstants.CENTER);
		lblQueryInformationFrom.setFont(new Font("9999", Font.BOLD, 25));
		lblQueryInformationFrom.setBounds(126, 23, 531, 39);
		singlePanel.add(lblQueryInformationFrom);
		
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
