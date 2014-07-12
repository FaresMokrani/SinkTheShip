package vsAI;

import java.awt.*;
import java.awt.event.*;
import java.io.*;

import javax.swing.*;

public class BattleField {
	
	private Frame maingui ;
	private Panel initPanel;
	private Panel seaPanel;
	private CheckboxGroup mapsize;
	private CheckboxGroup difficulty;
	private BattleEngine engine;
	private JButton[][] pos=new JButton[5][5]; 
	private int attempts,gameWon;
	
	public  BattleField()
	{
		loadInit();
	}
	
	public static void main(String[] args)
	{
		BattleField field = new BattleField();
		
	}
	
	private void loadInit()
	{
		maingui= new Frame("Battleship");
		maingui.setSize(400, 400);
		//maingui.setBackground(Color.HSBtoRGB(250, 250, 250));	
		maingui.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent we ){
				System.exit(0);
			}
		});
		maingui.setVisible(true);
		
		initPanel= new Panel();
		initPanel.setLayout(new GridLayout(3, 1));
		
		
		
		Color cl = new Color(249,249,249);
		initPanel.setBackground(cl);
		
		Panel check = new Panel();
		Panel diff = new Panel();
		
		Button start= new Button("START");
		 
		start.addActionListener(new ButtonClickListner());
		
		mapsize = new CheckboxGroup();
		Checkbox fourShips= new Checkbox("4 Ships (1*4 squares, 2*3squares and 1* 2 squares)",mapsize,true);
		Checkbox sixShips= new Checkbox("6 Ships (2*4 squares, 2*3squares and 2* 2 squares)",mapsize,false);
		
		difficulty = new CheckboxGroup();
		Checkbox hard = new Checkbox("Hard",difficulty,false);
		Checkbox medium = new Checkbox("Medium",difficulty,true);
		Checkbox easy = new Checkbox("Easy",difficulty,false);
		
		check.add(fourShips);
		check.add(sixShips);
		
		diff.add(hard);
		diff.add(medium);
		diff.add(easy);
		
		initPanel.add(check);
		initPanel.add(diff);
		initPanel.add(start);
		maingui.add(initPanel);
		
	}
	
	private void loadField(String s, String d)
	{
		
//		 System.out.print(s );
//		System.out.print(d );
		if(s.equals("4") )
		{	 
		attempts=20;
		gameWon=12;
		engine = new BattleEngine(4);	
		Panel field = new Panel();
		GridLayout lf = new GridLayout(5,5);
		field.setLayout(lf);
		/**/
		for(int i=0; i<5;++i )
		for(int j=0; j<5;++j )	
		{
			
			pos[i][j]=new JButton(""+i+"-"+j);
			pos[i][j].setBackground(new Color(0,128,128));
			pos[i][j].setForeground(Color.WHITE);
			//pos[i][j].setAlignment(Label.CENTER);
			pos[i][j].setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
			pos[i][j].setActionCommand(i+""+j);
			pos[i][j].addActionListener(new PosHit());
			 
			field.add(pos[i][j]);
		}
		//field.setSize(400, 400);
		//field.setBackground(new Color(0,128,128));
		lf.setHgap(3);
		lf.setVgap(3); 
		//Button start= new Button("START");
		 
		seaPanel=new Panel(new GridLayout(1,1));
		//field.add(start);
		seaPanel.add(field);
		//seaPanel.setSize(400, 400);
		//initPanel.setVisible(false);
		//seaPanel.setVisible(true);
		maingui.remove(initPanel);
		Panel main= new Panel(new GridLayout(2, 1));
		//main.remove(seaPanel);
		main.add(seaPanel);
		
		Button restart= new Button("Restart");
		restart.addActionListener(new ButtonRestart());
		main.add(restart);
		maingui.add(main);
		maingui.setVisible(true);
		
		}
		
	}
	
	private class ButtonClickListner implements ActionListener
	{
		public void actionPerformed(ActionEvent ae)
		{
			
			String lab= (mapsize.getSelectedCheckbox()).getLabel();
			lab=lab.substring(0,1);
			
			
			String dif= (difficulty.getSelectedCheckbox()).getLabel();
			dif=dif.substring(0,1);
			
			
			loadField(lab,dif);
			
			
			
			
		}


	}
		private class ButtonRestart implements ActionListener
	{
		public void actionPerformed(ActionEvent ae)
		{
			
			maingui.setVisible(false);
			maingui.dispose();
			BattleField newfield = new BattleField();
			
			
		}


	}
	private class PosHit implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			
			if(attempts>0)
			{	
			--attempts;
			String command= e.getActionCommand();
			int i = Integer.parseInt(command.substring(0,	1))
				,j= Integer.parseInt(command.substring(1,	2))		;
			//pos[i][j].setBackground(new Color(100,100,28));
			//System.out.println(i+"-"+j);
			
			int idship=engine.testHit(i, j);
			
			if(idship!=-1)
			{
				pos[i][j].setBackground(new Color(100,100,28));
				pos[i][j].setText(""+idship);
				--gameWon;
				
				if(gameWon==0){
					attempts=0;
					JOptionPane.showMessageDialog(null,"You Won the GAME,  \n ----------------------GAME OVER !------------------", "You Win !", JOptionPane.PLAIN_MESSAGE);

				}
			}
			}else if(gameWon==0) JOptionPane.showMessageDialog(null,"You Won the GAME, \n GAME OVER !", "You Win !", JOptionPane.PLAIN_MESSAGE);
			else JOptionPane.showMessageDialog(null,"You have used all your attempts, GAME OVER !", "You lose !", JOptionPane.PLAIN_MESSAGE);
		}
		
		
	}
}


