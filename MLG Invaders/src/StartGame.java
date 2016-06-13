import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.swing.*;

public class StartGame {
	
	/**
	 * Setting params of start window
	 */
	public static void main(String[] args) throws IOException {
		
		StartWindow startWindow = new StartWindow();
		//startWindow.setTitle("Space Invaders");
		
		//int WindowHeight	= Integer.parseInt(Config.getProperties().getProperty("WindowHeight"));
		//int WindowWidth		= Integer.parseInt(Config.getProperties().getProperty("WindowWidth"));
		//startWindow.setSize(WindowWidth,WindowHeight);	
										
		//startWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//startWindow.show();
		
		
		
		// test wczytywania konfigu 
		
		//String test = Confgi.getProperties().getProperty("mlg.WindowHeight");
		//System.out.println(test);					
	}
}
	
	
	class StartWindow {
		
		
		private JFrame gameFrame;
		int WindowHeight	= Integer.parseInt(Config.getProperties().getProperty("WindowHeight"));
		int WindowWidth		= Integer.parseInt(Config.getProperties().getProperty("WindowWidth"));
		//public Config config ;
		//public int a =5;
		public StartWindow() throws IOException {

			gameFrame = new JFrame();
			//Config config = new Config() ;
			ImageIcon startGamePic = new ImageIcon("src/Icons/startGamePic.png");
			ImageIcon optionsPic = new ImageIcon("src/Icons/optionsPic.png");
			ImageIcon highScoresPic = new ImageIcon("src/Icons/highScoresPic.png");
			JMenuBar menuBar = new JMenuBar();
			gameFrame.setJMenuBar(menuBar);
			GamePanel gamePanel = new GamePanel(); //config
			Logo logo = new Logo();
			
			
			//JToolBar sideBar = new JToolBar();
			//sideBar.setOrientation(VERTICAL);
			
			
			JMenu file = new JMenu("Plik");
			JMenu help = new JMenu("Pomoc");
			menuBar.add(file);
			menuBar.add(help);
			
			/**
			 * Adding buttons
			 */
			JMenuItem newGame = new JMenuItem("Nowa gra");
			JMenuItem options = new JMenuItem("Opcje");
			JMenuItem exit = new JMenuItem("Wyjœcie");
			JMenuItem instructions = new JMenuItem("Instrukcja gry");
			JMenuItem aboutUs = new JMenuItem("O nas");
			file.add(newGame);
			file.add(options);
			file.add(exit);
			help.add(instructions);
			help.add(aboutUs);
			
			JButton newGame_Button = new JButton(startGamePic);
			JButton options_Button = new JButton(optionsPic);
			JButton highScores_Button = new JButton(highScoresPic);
			//gameFrame.add(gamePanel, BorderLayout.CENTER);
			//gameFrame.add(gamePanel);
			//add(gamePanel, BorderLayout.CENTER);
			
			
			gameFrame.add(logo, BorderLayout.CENTER);
			JToolBar toolbar = new JToolBar();
			toolbar.add(newGame_Button);
			toolbar.add(options_Button);
			toolbar.add(highScores_Button);
			gameFrame.add(toolbar, BorderLayout.NORTH);
			gameFrame.setVisible(true);
			gameFrame.pack();
			/*toolbar.setFocusable(false);
			toolbar.setEnabled(false);
			
			gamePanel.set
			
			gamePanel.setFocusable(true);
			gamePanel.setEnabled(true);
			System.out.println("toolbar fokjusejbyl: " + toolbar.isFocusable());
			System.out.println("GamePnale fokjusejbyl: " + gamePanel.isFocusable());
			/*gamePanel.setFocusable(true);
			gamePanel.requestFocus();
			gamePanel.requestDefaultFocus();
			*/
			
			
			/**
			 * Methods to make buttons work
			 */
			ActionListener startGameEvent = new ActionListener() {
				public void actionPerformed(ActionEvent event) {
					Sound.playSound("/Sounds/MLGAirHorn.wav");
					Nickname nicknameWindow = new Nickname(gameFrame, gamePanel, logo);
					// TU MOZNA SIE DOBRAC DO NICKNEJMU cos ala String export = nicknameWindow.nickname;
					//nickname.setTitle("Nickname");
					//nickname.setSize(300,140);
					//nickname.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					//nickname.show();
					
					//add(gamePanel, BorderLayout.SOUTH);
					//gamePanel.requestFocus();
					
				}
			};
			
			ActionListener highScoresEvent = new ActionListener() {
				public void actionPerformed(ActionEvent event){
					HighScores list = new HighScores();
				}
			};
			
			ActionListener aboutUsEvent = new ActionListener() {
				public void actionPerformed(ActionEvent event) {
					JOptionPane.showMessageDialog(null,
							"Grzegorz Wojciechowski\nJakub Szajner\n"
							+ "Studenci 4 semestru elektroniki Politechniki Warszawskiej", "About us", JOptionPane.INFORMATION_MESSAGE);
				}
			};

			ActionListener instructionsEvent = new ActionListener() {
				public void actionPerformed(ActionEvent event) {
					JOptionPane.showMessageDialog(null,
							"Szczegó³owe zasady gry: ", "Instructions", JOptionPane.INFORMATION_MESSAGE);
				}
			};
			
			
			ActionListener exitEvent = new ActionListener() {
				public void actionPerformed(ActionEvent event) {
					System.exit(0);
				}
			};
			/**
			 * Setting events for buttons
			 */
			newGame_Button.addActionListener(startGameEvent);
			highScores_Button.addActionListener(highScoresEvent);
			newGame.addActionListener(startGameEvent);
			instructions.addActionListener(instructionsEvent);
			aboutUs.addActionListener(aboutUsEvent);
			exit.addActionListener(exitEvent);
			
			gameFrame.setSize(WindowHeight,WindowWidth);
		}
	}