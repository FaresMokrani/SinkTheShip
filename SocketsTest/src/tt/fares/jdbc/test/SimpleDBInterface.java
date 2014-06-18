package tt.fares.jdbc.test;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class SimpleDBInterface {

	private String title = "DB Test";
	private int windowSize = 650;
	private int tfWidth = 550;
	private int tfHeight = 40;
	private Dimension tfDimension = new Dimension(tfWidth, tfHeight);
	
	private JFrame myWindow = new JFrame(title);
	private JTabbedPane mainTabs = new JTabbedPane();
	private JPanel displayPanel;
	private JPanel updatePanel;
	private JPanel createPanel;
	private JPanel displayTopPanel = new JPanel();
	private JPanel displayBottomPanel = new JPanel();
	private JScrollPane myScrollPanel;
	
	
	private JButton displaySubmitButton = new JButton("Submit");
	private JButton updateSubmitButton = new JButton("Submit");
	private JButton createSubmitButton = new JButton("Submit");
	
	private JLabel displayIdLabel = new JLabel("Id");
	private JLabel displayNameLabel = new JLabel("Name");
	private JLabel displayLastNameLabel = new JLabel("Last Name");
	private JLabel displayPostLabel = new JLabel("Post");
	private JLabel displayQueryLabel = new JLabel("Query");
	private JLabel updateNameLabel = new JLabel("Name");
	private JLabel updateLastNameLabel = new JLabel("Last Name");
	private JLabel updatePostLabel = new JLabel("Post");
	private JLabel updateQueryLabel = new JLabel("Query");
	private JLabel createQueryLabel = new JLabel("Query");
	
	private JTextField displayIdTF = new JTextField();
	private JTextField displayNameTF = new JTextField();
	private JTextField displayLastNameTF = new JTextField();
	private JTextField displayPostTF = new JTextField();
	private JTextField displayQueryTF = new JTextField();
	private JTextField updateQueryTF = new JTextField();
	private JTextField updateNameTF = new JTextField();
	private JTextField updateLastNameTF = new JTextField();
	private JTextField updatePostTF = new JTextField();
	private JTextField createQueryTF = new JTextField();
	
	private JTable resultTable;
	
	//set DB Connection
	private final Connection myConnection = MyDBConnection.connectToDB();
	
	
	public SimpleDBInterface(){
		myWindow.setSize(windowSize, windowSize);
		myWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//Initialize main Panels
		initDisplayPanel();
		initUpdatePanel();
		initCreatePanel();
		
		myWindow.getContentPane().add(mainTabs);
		myWindow.setVisible(true);
	}
	
	public static void main(String[] args){
		SimpleDBInterface myInterface = new SimpleDBInterface();
	}

	//Initialize Display Panel
	private void initDisplayPanel(){
		displayQueryTF.setPreferredSize(tfDimension);
		displayQueryTF.setText("Enter your display query in this box");
		
		displayPanel = new JPanel(new BorderLayout());
		
		displayTopPanel.add(displayQueryLabel);
		displayTopPanel.add(displayQueryTF);
		displayTopPanel.add(displaySubmitButton);
		
		displayPanel.add(displayTopPanel, BorderLayout.NORTH);
		
		//adding the listener
		displaySubmitButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				displaySubmitAction();
			}
			
		});
		
		//adding the Display Panel to the Tabs
		mainTabs.addTab("Display Query", displayPanel);
		
	}
	
	//Initialize Update Panel
	private void initUpdatePanel(){
		updateQueryTF.setPreferredSize(tfDimension);
		updateQueryTF.setText("Enter your update query in this box");
		
		updateNameTF.setPreferredSize(new Dimension(100,20));
		updateLastNameTF.setPreferredSize(new Dimension(100,20));
		updatePostTF.setPreferredSize(new Dimension(100,20));
		
		updatePanel = new JPanel();
		updatePanel.add(updateQueryLabel);
		updatePanel.add(updateQueryTF);
		updatePanel.add(updateNameLabel);
		updatePanel.add(updateNameTF);
		updatePanel.add(updateLastNameLabel);
		updatePanel.add(updateLastNameTF);
		updatePanel.add(updatePostLabel);
		updatePanel.add(updatePostTF);
		updatePanel.add(updateSubmitButton);
		
		//adding the listener
		updateSubmitButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				updateSubmitAction();
			}
			
		});
		
		//adding the Update Panel to the Tabs
		mainTabs.addTab("Update Query", updatePanel);
	}
	
	//Initialize Create Panel
	private void initCreatePanel(){
		createQueryTF.setPreferredSize(tfDimension);
		createQueryTF.setText("Enter your create query in this box");
		
		createPanel = new JPanel();
		createPanel.add(createQueryLabel);
		createPanel.add(createQueryTF);
		createPanel.add(createSubmitButton);
		
		//adding the listener
		createSubmitButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				createSubmitAction();
			}
			
		});
		
		//adding the Create Panel to the Tabs
		mainTabs.addTab("Create Query", createPanel);
	}
	
	//Action on Submit Button Click
	private void displaySubmitAction() {
		// TODO Auto-generated method stub
		
		Statement stmt = null;
		String query = displayQueryTF.getText();
		System.out.println(query);
		
		try {
			stmt = myConnection.createStatement();
			ResultSet rslt = stmt.executeQuery(query);
			ResultSetMetaData rsmd = rslt.getMetaData();
			int colNumber = rsmd.getColumnCount();
			
			rslt.last();
			int rowNumber = rslt.getRow();
			
			System.out.println(rowNumber);
			
			String[] colNames = new String[colNumber];
			String[][] rowsContent = new String[rowNumber][colNumber];

			for(int i=0; i<colNumber; i++){
				colNames[i] = rsmd.getColumnLabel(i+1);
			}
			
	
			rslt.beforeFirst();
			int i = 0, j=0;
			while(rslt.next()){
				int id = rslt.getInt("Id");
				String name = rslt.getString("LastName");
				rowsContent[i][j] = String.valueOf(id);
				j++;
				rowsContent[i][j] = name;
				j=0;
				i++;
			}
			rslt.close();
			resultTable = new JTable(rowsContent, colNames); 
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			resultTable = new JTable(); 
			JOptionPane.showMessageDialog(null, e1.getMessage(), "Error!", JOptionPane.ERROR_MESSAGE);
		}
		
		//Adding the result table to the Scroll Panel and the ScrollPane to the Second main Panel
		displayBottomPanel.removeAll();
		myScrollPanel = new JScrollPane(resultTable);
		resultTable.setFillsViewportHeight(true);
		displayBottomPanel.add(myScrollPanel);
		displayPanel.add(displayBottomPanel, BorderLayout.CENTER);
		//validate is needed when you add something to a container that's already visible
		displayPanel.validate();
		
	}
	
	//Action on Update Button Click
	private void updateSubmitAction(){
		String queryTFContent = updateQueryTF.getText();
		String query = "";
		PreparedStatement prestmt = null;
		if(queryTFContent.startsWith("insert") || queryTFContent.startsWith("update")){
			try {
				prestmt = myConnection.prepareStatement(queryTFContent);
				System.out.println(prestmt.toString());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			query = "insert into DevTeamMemeber(Name, LastName, Post) values (?, ?, ?);";
			try {
				prestmt = myConnection.prepareStatement(queryTFContent);
				prestmt.setString(1, updateNameTF.getText());
				prestmt.setString(2, updateLastNameTF.getText());
				prestmt.setString(3, updatePostTF.getText());
				
				System.out.println(prestmt.toString());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	//Action on Create Button Click
	private void createSubmitAction(){
			
	}

}
