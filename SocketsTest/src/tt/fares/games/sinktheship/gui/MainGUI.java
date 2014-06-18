package tt.fares.games.sinktheship.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class MainGUI {
	
	private JFrame mainWindow;
	
	private JPanel mainPanel;
	private JPanel gameMenuPanel;
	private JPanel gameScreenPanel;
	private JPanel gameSlatePanel;
	private JPanel resultPanel;
	
	private JMenuBar menuBar;
	private JMenu optionMenu;
	private JMenuItem menuItem;
	
	//mode choice screen
	private JLabel modeChoiceLabel;
	private JButton pveModeButton;
	private JButton pvpModeButton;
	
	//game screen
	private JLabel turnLabel;
	private JLabel timeCountLabel;
	private JLabel gameModeLabel;
	private JButton[] gameSlate;
	
	//final screen
	private JLabel winnerLabel;
	private JLabel winTimeLabel;
	private JLabel movesToWinLabel;
	private JLabel bestScoreLabel;
	private JButton playAgainButton;
	private JButton exitButton;
	
	//Constants
	private Dimension WINDOW_SIZE = new Dimension(600,400);
	private Dimension SLATE_BOX_SIZE = new Dimension(20,20);
	private Dimension SLATE_SIZE = new Dimension(100,100);
	
	
	
	public static void main(String[] args){
		MainGUI mainGUI = new MainGUI();
	}
	
	public MainGUI(){
		mainWindow = new JFrame();
		mainWindow.setSize(600, 400);
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainWindow.setTitle("Sink the Ship");
		mainWindow.setLocation(600, 400);
		
		initMenuBar();
		initMainPanel();
		
		mainWindow.setJMenuBar(menuBar);
		mainWindow.getContentPane().add(mainPanel);
		mainWindow.setVisible(true);
	}
	
	void initMenuBar(){
		menuBar = new JMenuBar();
		optionMenu = new JMenu("Option");
		
		menuBar.add(optionMenu);
		
	}
	
	void initMainPanel(){
		mainPanel = new JPanel(new BorderLayout());
		
		initGameMenuPanel();
		mainPanel.add(gameMenuPanel);
		
	}
	
	void initGameMenuPanel(){
		gameMenuPanel = new JPanel();
		
		modeChoiceLabel = new JLabel("Choose the game mode");
		pveModeButton = new JButton("1 Player");
		pvpModeButton = new JButton("2 Players");
		
		//add the button listeners
		pveModeButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				initGameScreenPanel(1);
			}
			
		});
		
		pvpModeButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				initGameScreenPanel(2);
			}
			
		});
		
		gameMenuPanel.add(modeChoiceLabel);
		gameMenuPanel.add(pveModeButton);
		gameMenuPanel.add(pvpModeButton);
	}
	
	void initGameScreenPanel(int mode){
		gameScreenPanel = new JPanel(new BorderLayout());
		
		gameModeLabel = new JLabel();
		
		switch (mode){
			case 1: gameModeLabel.setText("you are in 1 Player Mode");
					break;
			case 2: gameModeLabel.setText("you are in 2 Players Mode");
					break;
			default: gameModeLabel.setText("error");
					 break;
		}
		
		//set the game slate
		initGameSlate();
		
		gameScreenPanel.add(gameModeLabel, BorderLayout.NORTH);
		gameScreenPanel.add(gameSlatePanel, BorderLayout.CENTER);
		
		mainPanel.removeAll();
		mainPanel.add(gameScreenPanel);
		mainPanel.validate();
			
	}
	
	void initGameSlate(){
		gameSlatePanel = new JPanel(new GridLayout(0,5));
		
		gameSlate = new JButton[25];
		
		for(int i = 0; i < gameSlate.length; i++){
			gameSlate[i] = new JButton();
			gameSlate[i].setPreferredSize(SLATE_BOX_SIZE);
			gameSlatePanel.add(gameSlate[i]);
		}
		
	}
}
