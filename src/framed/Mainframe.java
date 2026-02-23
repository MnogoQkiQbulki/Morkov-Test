package framed;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.Dimension;

public class Mainframe implements ActionListener {

	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JPanel dealer = new JPanel(new FlowLayout(FlowLayout.CENTER));
	JPanel display = new JPanel(new FlowLayout(FlowLayout.CENTER));
	JPanel player = new JPanel(new FlowLayout(FlowLayout.CENTER));
	ImageIcon emptyFrame = new ImageIcon("cards/blueemptyframe.png");
	Image scaledFrame = emptyFrame.getImage().getScaledInstance(140, 150, Image.SCALE_SMOOTH);
	ImageIcon eFrame = new ImageIcon(scaledFrame);
	
	JButton hit = new JButton("Hit");
	JButton stand = new JButton("Stand");
	JButton reset = new JButton("Reset");
	JLabel announce = new JLabel("");
	
	int hitAlready = 0;
	int standAlready = 0;
	int dScore = 0;
	int pScore = 0;
	int AlreadyDidSoft = 0;
	
	JLabel dealerScore = new JLabel("Dealer score: " + dScore);
	JLabel playerScore = new JLabel("Player score: " + pScore);
	
	JLabel dcard1 = new JLabel(eFrame);
	JLabel dcard2 = new JLabel(eFrame);
	JLabel dcard3 = new JLabel(eFrame);
	JLabel dcard4 = new JLabel(eFrame);
	JLabel pcard1 = new JLabel(eFrame);
	JLabel pcard2 = new JLabel(eFrame);
	JLabel pcard3 = new JLabel(eFrame);
	JLabel pcard4 = new JLabel(eFrame);
	boolean won = false;
	boolean lost = false;
	boolean soft = false;
	
	Card card = new Card();
	CardImage cardimg = new CardImage();
	
	public void Redraw () {
		 
		hit.setEnabled(true);
		stand.setEnabled(true);
		announce.setText("");
		announce.setEnabled(true);
		
		won = false;
	    lost = false;
	    soft = false;
	    hitAlready = 0;
	    standAlready = 0;
	    AlreadyDidSoft = 0;
	    dScore = 0;
	    pScore = 0;
	    dealerScore.setText("Dealer score: " + dScore);
	    playerScore.setText("Player score: " + pScore);
	    
	    hit.setEnabled(true);
	    stand.setEnabled(true);
	    
	    pcard2.setIcon(eFrame); 
	    pcard3.setIcon(eFrame); 
	    pcard4.setIcon(eFrame);
	    
	    dcard2.setIcon(eFrame); 
	    dcard3.setIcon(eFrame); 
	    dcard4.setIcon(eFrame);
	    
	    int firstPlayer = card.Pull();
	    pcard1.setIcon(cardimg.images.get(card.Deck.get(firstPlayer)));
	    pScore = GameLogic(firstPlayer, pScore);
	    playerScore.setText("Player score is: " + pScore);
	    hitAlready = 1;

	    int firstDealer = card.Pull();
	    dcard1.setIcon(cardimg.images.get(card.Deck.get(firstDealer)));
	    dScore = GameLogic(firstDealer, dScore);
	    dealerScore.setText("Dealer score: " + dScore);
	}

	public Mainframe() {
		
	
		
		playerScore.setPreferredSize(new Dimension(150, 20));
	    dealerScore.setPreferredSize(new Dimension(150, 20));
	    panel.setBackground(new Color(255, 245, 235));
	    dealer.setBackground(new Color(255, 245, 235));
	    display.setBackground(new Color(255, 245, 235));
	    player.setBackground(new Color(255, 245, 235));
		won = false; 
		lost = false; 
		soft = false; 		 
		dScore = 0; 
		pScore = 0;
		dealer.add(dcard1); 
		dealer.add(dcard2); 
		dealer.add(dcard3); 
		dealer.add(dcard4); 
		dealer.add(dealerScore);
		hit.addActionListener(this); 
		stand.addActionListener(this); 
		reset.addActionListener(this);
		display.add(hit); 
		display.add(stand); 
		display.add(reset); 
		display.add(announce);
		announce.setEnabled(false);
		player.add(pcard1); 
		player.add(pcard2); 
		player.add(pcard3); 
		player.add(pcard4); 
		player.add(playerScore);
		panel.setBorder(BorderFactory.createEmptyBorder(30,30,30,30));
		panel.setLayout(new GridLayout(3,0));
		display.setBorder(BorderFactory.createEmptyBorder(50,0,0,60));
		panel.add(dealer); 
		panel.add(display); 
		panel.add(player);
		frame.add(panel, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Carrot blackjack");
		frame.setSize(900, 600);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setMinimumSize(frame.getSize());
		
		ImageIcon icon = new ImageIcon("cards/carrot.png");
		frame.setIconImage(icon.getImage());
		
		Redraw();
				
	}

	public static void main(String[] args) {
		new Mainframe();
		System.out.println("Wow");
		System.out.println(System.getProperty("user.dir"));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		
		if (source == hit) {
			if (hitAlready < 4) {
				int cardPicked = card.Pull();
				String mapToImage = card.Deck.get(cardPicked);
				
				pScore = GameLogic(cardPicked, pScore);
				
				playerScore.setText("Player score is: " + pScore);
				
				if (soft == true && pScore != 21) {
					playerScore.setText("Player score is: " + pScore + " (Soft)");
				}
				
				if(lost == true && AlreadyDidSoft < 2) {
					announce.setEnabled(true);
					announce.setText("LOST");
					hit.setEnabled(false);
					stand.setEnabled(false);
				}
				
				if(won == true) {
					announce.setEnabled(true);
					announce.setText("WON");
					hit.setEnabled(false);
					stand.setEnabled(false);
				}
				
				
				if (hitAlready == 0) 
				{ 
					pcard1.setIcon(cardimg.images.get(mapToImage)); hitAlready++;
				}
				else if (hitAlready == 1) 
				{ 
					pcard2.setIcon(cardimg.images.get(mapToImage)); hitAlready++; 
				}
				else if (hitAlready == 2) 
				{ 
					pcard3.setIcon(cardimg.images.get(mapToImage)); hitAlready++; 
				}
				else if (hitAlready == 3) 
				{ 
					pcard4.setIcon(cardimg.images.get(mapToImage)); hitAlready++; 
				}
				
			}
		} 
		
		else if (source == stand) 
		{
			hit.setEnabled(false);
			
			won = false;
			lost = false;
			soft = false;
			AlreadyDidSoft = 0;
						
			if (standAlready <= 3) {
				
				int cardPicked = card.Pull();
				String mapToImage = card.Deck.get(cardPicked);
				
				dScore = GameLogic(cardPicked,dScore);
				
				dealerScore.setText("Dealer score is: " + dScore);
				
				if (dScore > pScore) {
					announce.setEnabled(true);
					announce.setText("LOST. DEALER WON.");
					hit.setEnabled(false);
					stand.setEnabled(false);
				}
				
				
				
				if (standAlready == 0) {
					dcard2.setIcon(cardimg.images.get(mapToImage)); standAlready++;
				}
				else if (standAlready == 1) {
					dcard3.setIcon(cardimg.images.get(mapToImage)); standAlready++;
				}
				else if (standAlready == 2) {
					dcard4.setIcon(cardimg.images.get(mapToImage)); standAlready++;
				}
				
					if (dScore >= 17 && pScore > dScore) {
						lost = true;
					}
					else if (dScore == 17 && pScore == 17) {
						announce.setEnabled(true);
						announce.setText("PUSH");
						hit.setEnabled(false);
						stand.setEnabled(false);
					}
				
					if(won == true) {
						announce.setEnabled(true);
						announce.setText("LOST. DEALER WON.");
						hit.setEnabled(false);
						stand.setEnabled(false);
					}	
					
					if(lost == true && AlreadyDidSoft < 2) {
						announce.setEnabled(true);
						announce.setText("WON. DEALER LOST.");
						hit.setEnabled(false);
						stand.setEnabled(false);
					}
					
					
			}
		} 
		else if (source == reset) 
		{
			Redraw();
		}
	}
	private int GameLogic(int cardPicked, int currentScore) {
	    
	    if((cardPicked == 13 || cardPicked == 26 || cardPicked == 39 || cardPicked == 52) && currentScore > 10) { currentScore++; }
	    else if ((cardPicked == 13 || cardPicked == 26 || cardPicked == 39 || cardPicked == 52) && currentScore == 10) { won = true; currentScore += 11; }
	    else if ((cardPicked == 13 || cardPicked == 26 || cardPicked == 39 || cardPicked == 52) && currentScore < 10) { soft = true; AlreadyDidSoft++; currentScore += 11; }

	    if((cardPicked == 1 || cardPicked == 14 || cardPicked == 27 || cardPicked == 40) && currentScore > 19) { lost = true; if(soft && AlreadyDidSoft < 2) { lost = false; currentScore -= 10; soft = false; } currentScore += 2; }
	    else if ((cardPicked == 1 || cardPicked == 14 || cardPicked == 27 || cardPicked == 40) && currentScore == 19) { won = true; currentScore += 2; }
	    else if ((cardPicked == 1 || cardPicked == 14 || cardPicked == 27 || cardPicked == 40) && currentScore < 19) { currentScore += 2; }

	    if((cardPicked == 2 || cardPicked == 15 || cardPicked == 28 || cardPicked == 41) && currentScore > 18) { lost = true; if(soft && AlreadyDidSoft < 2) { lost = false; currentScore -= 10; soft = false; } currentScore += 3; }
	    else if ((cardPicked == 2 || cardPicked == 15 || cardPicked == 28 || cardPicked == 41) && currentScore == 18) { won = true; currentScore += 3; }
	    else if ((cardPicked == 2 || cardPicked == 15 || cardPicked == 28 || cardPicked == 41) && currentScore < 18) { currentScore += 3; }

	    if((cardPicked == 3 || cardPicked == 16 || cardPicked == 29 || cardPicked == 42) && currentScore > 17) { lost = true; if(soft && AlreadyDidSoft < 2) { lost = false; currentScore -= 10; soft = false; } currentScore += 4; }
	    else if ((cardPicked == 3 || cardPicked == 16 || cardPicked == 29 || cardPicked == 42) && currentScore == 17) { won = true; currentScore += 4; }
	    else if ((cardPicked == 3 || cardPicked == 16 || cardPicked == 29 || cardPicked == 42) && currentScore < 17) { currentScore += 4; }

	    if((cardPicked == 4 || cardPicked == 17 || cardPicked == 30 || cardPicked == 43) && currentScore > 16) { lost = true; if(soft && AlreadyDidSoft < 2) { lost = false; currentScore -= 10; soft = false; } currentScore += 5; }
	    else if ((cardPicked == 4 || cardPicked == 17 || cardPicked == 30 || cardPicked == 43) && currentScore == 16) { won = true; currentScore += 5; }
	    else if ((cardPicked == 4 || cardPicked == 17 || cardPicked == 30 || cardPicked == 43) && currentScore < 16) { currentScore += 5; }

	    if((cardPicked == 5 || cardPicked == 18 || cardPicked == 31 || cardPicked == 44) && currentScore > 15) { lost = true; if(soft && AlreadyDidSoft < 2) { lost = false; currentScore -= 10; soft = false; } currentScore += 6; }
	    else if ((cardPicked == 5 || cardPicked == 18 || cardPicked == 31 || cardPicked == 44) && currentScore == 15) { won = true; currentScore += 6; }
	    else if ((cardPicked == 5 || cardPicked == 18 || cardPicked == 31 || cardPicked == 44) && currentScore < 15) { currentScore += 6; }

	    if((cardPicked == 6 || cardPicked == 19 || cardPicked == 32 || cardPicked == 45) && currentScore > 14) { lost = true; if(soft && AlreadyDidSoft < 2) { lost = false; currentScore -= 10; soft = false; } currentScore += 7; }
	    else if ((cardPicked == 6 || cardPicked == 19 || cardPicked == 32 || cardPicked == 45) && currentScore == 14) { won = true; currentScore += 7; }
	    else if ((cardPicked == 6 || cardPicked == 19 || cardPicked == 32 || cardPicked == 45) && currentScore < 14) { currentScore += 7; }

	    if((cardPicked == 7 || cardPicked == 20 || cardPicked == 33 || cardPicked == 46) && currentScore > 13) { lost = true; if(soft && AlreadyDidSoft < 2) { lost = false; currentScore -= 10; soft = false; } currentScore += 8; }
	    else if ((cardPicked == 7 || cardPicked == 20 || cardPicked == 33 || cardPicked == 46) && currentScore == 13) { won = true; currentScore += 8; }
	    else if ((cardPicked == 7 || cardPicked == 20 || cardPicked == 33 || cardPicked == 46) && currentScore < 13) { currentScore += 8; }

	    if((cardPicked == 8 || cardPicked == 21 || cardPicked == 34 || cardPicked == 47) && currentScore > 12) { lost = true; if(soft && AlreadyDidSoft < 2) { lost = false; currentScore -= 10; soft = false; } currentScore += 9; }
	    else if ((cardPicked == 8 || cardPicked == 21 || cardPicked == 34 || cardPicked == 47) && currentScore == 12) { won = true; currentScore += 9; }
	    else if ((cardPicked == 8 || cardPicked == 21 || cardPicked == 34 || cardPicked == 47) && currentScore < 12) { currentScore += 9; }

	    if(((cardPicked >= 9 && cardPicked <= 12) || (cardPicked >= 22 && cardPicked <= 25) ||
	        (cardPicked >= 35 && cardPicked <= 38) || (cardPicked >= 48 && cardPicked <= 51)) && currentScore > 11) { lost = true; if(soft && AlreadyDidSoft < 2) { lost = false; currentScore -= 10; soft = false; } currentScore += 10; }
	    else if (((cardPicked >= 9 && cardPicked <= 12) || (cardPicked >= 22 && cardPicked <= 25) ||
	        (cardPicked >= 35 && cardPicked <= 38) || (cardPicked >= 48 && cardPicked <= 51)) && currentScore == 11) { won = true; currentScore += 10; }
	    else if (((cardPicked >= 9 && cardPicked <= 12) || (cardPicked >= 22 && cardPicked <= 25) ||
	        (cardPicked >= 35 && cardPicked <= 38) || (cardPicked >= 48 && cardPicked <= 51)) && currentScore < 11) { currentScore += 10; }

	    return currentScore;
	}
}
