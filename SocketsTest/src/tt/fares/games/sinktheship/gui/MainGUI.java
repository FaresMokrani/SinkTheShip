package tt.fares.games.sinktheship.gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class MainGUI {
	
	//main window
	private JFrame mainWindow;
	
	private JPanel mainPanel;
	private JPanel gameMenuPanel;
	private JPanel gameOptionPanel1;
	private JPanel gameOptionPanel2;
	private JPanel gameScreenPanel;
	private JPanel gameSlatePanel;
	private JPanel resultPanel;
	
	private JMenuBar menuBar;
	private JMenu optionMenu;
	private JMenuItem menuItem;
	
	//mode menu screen
	private JLabel modeChoiceLabel;
	private JButton pveModeButton;
	private JButton pvpModeButton;
	
	//options menu screen1
	private JLabel optionTitleLbl1;
	private JLabel nmbOfShipsLbl;
	private JLabel slateSizeLbl;
	private ButtonGroup nmbOfShipsRadioGroup;
	private JRadioButton threeShipsRadio;
	private JRadioButton fourShipsRadio;
	private JRadioButton fiveShipsRadio;
	private ButtonGroup slateSizeRadioGroup;
	private JRadioButton slate5x5Radio;
	private JRadioButton slate7x7Radio;
	private JButton optionSubmit1;
	
	//options menu screen2
	private JLabel optionTitleLbl2;
	private JLabel nameOfShipLbl;
	private JTextField[] namesOfShipsTF;
	private JLabel[] shipsNumbersLbl;
	private ButtonGroup[] sizeOfShipRadioGroup;
	private JRadioButton[] sizeRadios;
	private JButton optionSubmit2;
	
	
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
	private int NUMBER_OF_SIZES = 3;
	
	//value holders
	private int nmbOfShips = 0;
	private int[] sizesOfShips;
	private int slateSize = 0;
	private String[] namesOfShips;
	
	//game helpers
	public GameHelper gameHelper;
	public int nmbOfTries;
	public int nmbOfHitShips = 0;
	
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
				initGameOptionPanel1();
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
	
	void initGameOptionPanel1(){
		gameOptionPanel1 = new JPanel();
		
		optionTitleLbl1 = new JLabel("Choose your preferences:");
		
		slateSizeLbl = new JLabel("Choose the size of the sea");
		slateSizeRadioGroup = new ButtonGroup();
		slate5x5Radio = new JRadioButton("5x5");
		slate7x7Radio = new JRadioButton("7x7");
		slateSizeRadioGroup.add(slate5x5Radio);
		slateSizeRadioGroup.add(slate7x7Radio);
		
		
		nmbOfShipsLbl = new JLabel("How many ships do you wish to have?");
		threeShipsRadio = new JRadioButton("3");
		fourShipsRadio = new JRadioButton("4");
		fiveShipsRadio = new JRadioButton("5");
		nmbOfShipsRadioGroup = new ButtonGroup();
		nmbOfShipsRadioGroup.add(threeShipsRadio);
		nmbOfShipsRadioGroup.add(fourShipsRadio);
		nmbOfShipsRadioGroup.add(fiveShipsRadio);
		
		
		optionSubmit1 = new JButton("Next");
		
		//add action listener on the submit button
		optionSubmit1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(slate5x5Radio.isSelected()){
					slateSize = 25;
					nmbOfTries = 17;
				}else if(slate7x7Radio.isSelected()){
					slateSize = 49;
					nmbOfTries = 25;
				}
				if(threeShipsRadio.isSelected()){
					nmbOfShips = 3;
				}else if(fourShipsRadio.isSelected()){
					nmbOfShips = 4;
				}else if(fiveShipsRadio.isSelected()){
					nmbOfShips = 5;
				}
				initGameOptionPanel2(slateSize, nmbOfShips);
			}
		});
		
		gameOptionPanel1.add(optionTitleLbl1);
		gameOptionPanel1.add(slateSizeLbl);
		gameOptionPanel1.add(slate5x5Radio);
		gameOptionPanel1.add(slate7x7Radio);
		gameOptionPanel1.add(nmbOfShipsLbl);
		gameOptionPanel1.add(threeShipsRadio);
		gameOptionPanel1.add(fourShipsRadio);
		gameOptionPanel1.add(fiveShipsRadio);
		gameOptionPanel1.add(optionSubmit1);
		
		mainPanel.removeAll();
		mainPanel.add(gameOptionPanel1);
		mainPanel.validate();
		
	}
	
	void initGameOptionPanel2(int slateSize, int nmbOfShips){
		gameOptionPanel2 = new JPanel();
		
		//number of ships Place Holder
		final int nmb = nmbOfShips;
		
		optionTitleLbl2 = new JLabel("Choose your ships characteristics");
		gameOptionPanel2.add(optionTitleLbl2);
		
		//dynamically create the corresponding text fields, labels and radio buttons
		nameOfShipLbl = new JLabel("Choose the names and sizes for your ships");
		gameOptionPanel2.add(nameOfShipLbl);
		namesOfShipsTF = new JTextField[nmbOfShips];
		shipsNumbersLbl = new JLabel[nmbOfShips];
		sizeOfShipRadioGroup = new ButtonGroup[nmbOfShips];
		sizeRadios = new JRadioButton[nmbOfShips*3];
				
		for(int i=0; i<nmbOfShips; i++){
			int sizeRadioText = 0; //to display the right sizes in the radio buttons
			namesOfShipsTF[i] = new JTextField("Enter the name of this ship");
			gameOptionPanel2.add(namesOfShipsTF[i]);
			shipsNumbersLbl[i] = new JLabel("Ship "+(i+1));
			gameOptionPanel2.add(shipsNumbersLbl[i]);
			sizeOfShipRadioGroup[i] = new ButtonGroup();
			for(int j=i*NUMBER_OF_SIZES; j<((i+1)*NUMBER_OF_SIZES); j++){
				sizeRadios[j] = new JRadioButton(""+(NUMBER_OF_SIZES+sizeRadioText));
				sizeOfShipRadioGroup[i].add(sizeRadios[j]);
				gameOptionPanel2.add(sizeRadios[j]);
				sizeRadioText++;
			}
		}
		
		
		optionSubmit2 = new JButton("Next");
		
		//add an action listener to the submit button
		optionSubmit2.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				sizesOfShips = new int[nmb];
				namesOfShips = new String[nmb];
				for(int i=0; i< nmb; i++){
					namesOfShips[i] = namesOfShipsTF[i].getText();
					for(int j=i*NUMBER_OF_SIZES; j<(i+1)*NUMBER_OF_SIZES; j++){
						if(sizeRadios[j].isSelected()){
							sizesOfShips[i] = Integer.parseInt(sizeRadios[j].getText()); 
						}
					}
				}
				initGameScreenPanel(1);
			}
			
		});
		
		gameOptionPanel2.add(optionSubmit2);
		
		mainPanel.removeAll();
		mainPanel.add(gameOptionPanel2);
		mainPanel.validate();
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
		int nmbOfColumns = (int)(Math.sqrt(slateSize));
		
		gameSlatePanel = new JPanel(new GridLayout(0,nmbOfColumns));
		
		gameSlate = new JButton[slateSize];
		
		//start the game helper that will set the ships on the slate (by instantiating GameLogic class)
		gameHelper = new GameHelper(slateSize, nmbOfShips, sizesOfShips, namesOfShips);
		
		for(int i = 0; i < gameSlate.length; i++){
			gameSlate[i] = new JButton();
			gameSlate[i].setPreferredSize(SLATE_BOX_SIZE);
			gameSlate[i].setName(String.valueOf(i));
			gameSlatePanel.add(gameSlate[i]);
			
			gameSlate[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					//get the Button that triggered the event
					JButton temp = (JButton)e.getSource();
					int boxNumber = Integer.parseInt(temp.getName());
					System.out.println("Ships name: "+temp.getName());
					if(gameHelper.gameLogic.gameSlateMap[boxNumber] == 1){
						temp.setText("O");
						hitsCounter(boxNumber);
					}else{
						temp.setText("X");
					}
					temp.setEnabled(false);
					checkNmbOfTries();
				}
			});
		}
	}
	
	//Checks if the boats were hit or sunk
	void hitsCounter(int boxNumber){
		for(Ship ship: gameHelper.battleShips){
			if (ship.hasLocation(boxNumber)){
				if(ship.isSunk()){
					nmbOfHitShips++;
					JOptionPane.showMessageDialog(mainWindow, "You just sunk: "+ ship.name);
					if(nmbOfHitShips == nmbOfShips){
						JOptionPane.showMessageDialog(mainWindow, "Congratulation !!! You destroyed all your enemey's ships");
						disableSlate();
					}
				}
			}
		}
	}
	
	//Disable all the buttons on the slate
	void disableSlate(){
		for(JButton button:gameSlate){
			button.setEnabled(false);
			//to do: initiate the result screen
		}
	}
	
	//checks the number of tries the player used up
	void checkNmbOfTries(){
		nmbOfTries--;
		if (nmbOfTries == 0){
			JOptionPane.showMessageDialog(mainWindow, "You used up all your canon balls!","Inane Warning", JOptionPane.WARNING_MESSAGE);
			disableSlate();
		}
	}
}
