
import com.sun.xml.internal.bind.unmarshaller.Messages;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Collections;
import java.util.Timer;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
 
class Board extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	final JButton[] cards = new JButton[30];              //array holding JButtons for cards
	int cardOne, cardTwo = 0;                             // create two variables to hold the index of the button clicked
	int cardsClicked = 0;                               // create a variable to keep track of the clicks 
	int[] removedCards = new int[30];                     // create an array to hold the state of the tiles to end the game
	final JMenuBar menuBar = new JMenuBar();
	final JMenu gameMenu = new JMenu();
	final JMenu helpMenu = new JMenu();
	final JMenuItem newMenuItem = new JMenuItem();
	final JMenuItem customMenuItem = new JMenuItem();
	final JMenuItem scoresMenuItem = new JMenuItem();
	final JMenuItem exitMenuItem = new JMenuItem();
	final JMenuItem helpMenuItem = new JMenuItem();
	final JMenuItem aboutMenuItem = new JMenuItem();
	final JFileChooser chooser = new JFileChooser();
	String directory;	//directory chosen
	private final String[] images =  new String[] {"1.png","2.png","3.png","4.png","5.png","6.png","7.png","8.png","9.png","10.png","11.png","12.png","13.png","14.png","15.png"};
	final ImageIcon unknown = new ImageIcon("unknown.png");
	Messages msg = new Messages();
	Timer timer = new Timer();
	
	public Board(){
		
		super("MEMORY GAME");
		setSize(800,750);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
		setJMenuBar(menuBar);
		gameMenu.setText("Game");
		menuBar.add(gameMenu);
		helpMenu.setText("Help");
		menuBar.add(helpMenu);
		
		newMenuItem.setText("New");
		customMenuItem.setText("Custom");
		scoresMenuItem.setText("High Scores");
		exitMenuItem.setText("Exit");
		helpMenuItem.setText("Contents");
		aboutMenuItem.setText("About");
		
		gameMenu.add(newMenuItem);
		gameMenu.add(customMenuItem);
		gameMenu.addSeparator();
		gameMenu.add(scoresMenuItem);
		gameMenu.addSeparator();
		gameMenu.add(exitMenuItem);
		
		helpMenu.add(helpMenuItem);
		helpMenu.addSeparator();
		helpMenu.add(aboutMenuItem);
		
		newMenuItem.addActionListener(this);
		customMenuItem.addActionListener(this);
		scoresMenuItem.addActionListener(this);
		exitMenuItem.addActionListener(this);
		helpMenuItem.addActionListener(this);
		aboutMenuItem.addActionListener(this);
	
		setLayout(new BorderLayout());
	
		final JPanel cardPanel = new JPanel();         //panel to hold the cards
		cardPanel.setSize(800,650);	                
		cardPanel.setLayout(new GridLayout(5,6));      //layout for 30 cards
        add(cardPanel, BorderLayout.CENTER);           
	
		//create cards
		for( int i=0; i<cards.length; i++)
		{
			cards[i] = new JButton();	 
			cards[i].setIcon(unknown);   
			cards[i].addActionListener(this);
			cardPanel.add(cards[i]);        			
			removedCards[i] = 0;             
		}
		shuffle();                    			  //shuffle cards
		setResizable(false);                     
		setVisible(true);		                 
	}
	
	public void actionPerformed(final ActionEvent evt){
		if( evt.getSource().equals(newMenuItem)){
				shuffle(); 
		}
		else if( evt.getSource().equals(customMenuItem)){
			System.out.println("testing this");
		}
		else if(evt.getSource().equals(scoresMenuItem)){
			msg.scores();
		}
		else if( evt.getSource().equals(exitMenuItem)){
				System.exit(-1);
		}
		else if( evt.getSource().equals(helpMenuItem)){
			msg.help();							
		}
		else if( evt.getSource().equals(aboutMenuItem))	{
			msg.about();							
		}
		else{	//user clicked on a button
			for( int i=0; i<cards.length; i++){	
				if( evt.getSource().equals(cards[i])){		
						if( cardsClicked == 2)	                			
						isMatch();	
						if( cardsClicked < 2){
						trackCards(cardsClicked, i);   // call this method to store the index of the button clicked
						cards[i].setEnabled(false);           // disable the tile clicked ( so the icon can be shown)
						cardsClicked ++;                       // increment cardsClicked 
						endGame();				                 // check if it is the end of the game
						break;                                   // break the loop if done early
					}				
				}				 
			}				
		}			
	} 
 
	public void trackCards(int theClicks, int thePosition){
		if( theClicks == 0) 
			cardOne = thePosition;   // set cardOne to the index of the first button clicked
		else if( theClicks == 1 )
			cardTwo = thePosition;	 // set cardTwo to the index of the first button clicked		
	}
 
	public void isMatch()	{
// creating two local strings to hold the name of the pictures assigned to the chosen tiles in the disable state
		String firstButton = "" + cards[cardOne].getDisabledIcon();     
		String secondButton = "" + cards[cardTwo].getDisabledIcon(); 
		//compare for match
		if( firstButton.equals(secondButton)){	
			cards[cardOne].setVisible(false);
			cards[cardTwo].setVisible(false); 
			removedCards[cardOne] = 1;     // update the removed tiles array to keep track of the tiles removed
			removedCards[cardTwo] = 1;     
		}
		else {		
			cards[cardOne].setEnabled(true);
			cards[cardTwo].setEnabled(true);
		}
		cardsClicked = 0; // reset the counter for cardsClicked
	}
 
	public void endGame(){
		int countremovedCards = 0;
		for( int i=0; i<removedCards.length; i++){
			if( removedCards[i] == 1){
				countremovedCards ++;
			}
		}
		if( countremovedCards + cardsClicked == 30){
			cards[cardOne].setVisible(false);    // set the visibility of the last button at index cardOne to false
			cards[cardTwo].setVisible(false);    // set the visibility of the last button at index cardTwo to false
			shuffle();   // shuffle start a new game
	    }	
    }	
 
	public void hideCards(){
		for( int i=0; i<cards.length; i++){
			cards[i].setEnabled(true);
		}
	}
 
	public void shuffle(){	
		Collections.shuffle(Arrays.asList(cards));
		Collections.shuffle(Arrays.asList(images));
		for( int i=0; i<cards.length; i++){
			cards[i].setEnabled(true);
			cards[i].setVisible(true);
			cards[i].setDisabledIcon(new ImageIcon( images[i%15] )); 
			removedCards[i] = 0;
		}
		cardsClicked = 0;
	}
}

