package game;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;





//this class produces the window and gives a frame to the whole application


public class MainFrame extends JFrame implements ActionListener{

	

	private SettingsPanel rightPanel;

	private Canvas leftPanel;

	

	/**

	 * constructor, initiates the components, and sets the

	 * properties of the frame

	 */

	public MainFrame() {

		setLayout(new BorderLayout());

		

		rightPanel = new SettingsPanel(this);

		rightPanel.initComponents();

		

		leftPanel = new Canvas();

				

		add(leftPanel, BorderLayout.WEST);

		add(rightPanel, BorderLayout.CENTER);

	

		setDefaultCloseOperation(EXIT_ON_CLOSE);

		setTitle("Bubble Burst Game");	

		setSize(Constants.WINDOW_SIZE_X, Constants.WINDOW_SIZE_Y);

		setResizable(true);

		setVisible(true);

		setSize(2*Constants.WINDOW_SIZE_X-getContentPane().getSize().width,

				2*Constants.WINDOW_SIZE_Y-getContentPane().getSize().height);

		 

	}

	

	/**

	 * makes the left panel display the highscores

	 */

	public void init(){

		leftPanel.displayHighscore(0, true);

	}

	

	/**

	 * can be called when the game is won, displays the highscores

	 * @param score the achieved score

	 */

	public void gameWon(long score){

		rightPanel.updateScore(score);

		leftPanel.displayHighscore(score, true);

	}

	

	/**

	 * can be called when the game is lost, displays the highscores

	 * @param score the achieved score

	 */

	public void gameLost(long score){

		rightPanel.updateScore(score);

		leftPanel.displayHighscore(score, false);

	}

	

	/**

	 * makes the right panel update the score counter to the current one

	 * @param score the currently achieved score

	 */

	public void updateScore(long score){

		rightPanel.updateScore(score);

	}



	/**

	 * {@inheritDoc}

	 */

	@Override

	public void actionPerformed(ActionEvent e) {

		if(e.getActionCommand().equals("NEWGAME")){

			leftPanel.newGame(rightPanel.getRow(), rightPanel.getColor());

			leftPanel.getGame().setMainFrame(this);

		}

		else if(e.getActionCommand().equals("STOPGAME")){

			if(leftPanel.getGame() != null){

				leftPanel.getGame().stop();

				leftPanel.displayHighscore(0, true);

			}

		}

	}

}
