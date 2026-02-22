package framed;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Mainframe implements ActionListener {

	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JPanel dealer = new JPanel(new FlowLayout(FlowLayout.CENTER));
	JPanel display = new JPanel(new FlowLayout(FlowLayout.CENTER));
	JPanel player = new JPanel(new FlowLayout(FlowLayout.CENTER));
	ImageIcon emptyFrame = new ImageIcon("emptyFrame.png");
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
		if(lost == true) {
			hit.setEnabled(true);
			stand.setEnabled(true);
			announce.setText("");
		}
		won = false;
	    lost = false;
	    soft = false;
	    hitAlready = 0;
	    standAlready = 0;
	    dScore = 0;
	    pScore = 0;
	    dealerScore.setText("Dealer score: " + dScore);
	    playerScore.setText("Player score: " + pScore);
	    dealer.add(dcard1); dealer.add(dcard2); dealer.add(dcard3); dealer.add(dcard4); dealer.add(dealerScore);
	    player.add(pcard1); player.add(pcard2); player.add(pcard3); player.add(pcard4); player.add(playerScore);
	    pcard1.setIcon(eFrame); pcard2.setIcon(eFrame); pcard3.setIcon(eFrame); pcard4.setIcon(eFrame);
	    dcard1.setIcon(eFrame); dcard2.setIcon(eFrame); dcard3.setIcon(eFrame); dcard4.setIcon(eFrame);
	}

	public Mainframe() {
		Redraw();
		won = false; lost = false; soft = false; hitAlready = 0; dScore = 0; pScore = 0;
		dealer.add(dcard1); dealer.add(dcard2); dealer.add(dcard3); dealer.add(dcard4); dealer.add(dealerScore);
		hit.addActionListener(this); stand.addActionListener(this); reset.addActionListener(this);
		display.add(hit); display.add(stand); display.add(reset); display.add(announce);
		announce.setEnabled(false);
		player.add(pcard1); player.add(pcard2); player.add(pcard3); player.add(pcard4); player.add(playerScore);
		panel.setBorder(BorderFactory.createEmptyBorder(30,30,30,30));
		panel.setLayout(new GridLayout(3,0));
		panel.add(dealer); panel.add(display); panel.add(player);
		frame.add(panel, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Morkov blackjack");
		frame.pack();
		frame.setVisible(true);
		frame.setMinimumSize(frame.getSize());
		frame.setMaximumSize(frame.getSize());
		ImageIcon icon = new ImageIcon("carrot.png");
		frame.setIconImage(icon.getImage());
	}

	public static void main(String[] args) {
		new Mainframe();
		System.out.println("Hi!");
		System.out.println(System.getProperty("user.dir"));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		
		if (source == hit) {
			if (hitAlready < 4) {
				int cardPicked = card.Pull();
				String mapToImage = card.Deck.get(cardPicked);
				
				if((cardPicked == 13 || cardPicked == 26 || cardPicked == 39 || cardPicked == 52) && pScore > 10) { pScore++; }
				else if ((cardPicked == 13 || cardPicked == 26 || cardPicked == 39 || cardPicked == 52) && pScore == 10) { won = true; pScore += 11; }
				else if ((cardPicked == 13 || cardPicked == 26 || cardPicked == 39 || cardPicked == 52) && pScore < 10) { soft = true; pScore += 11; }
				
				if((cardPicked == 1 || cardPicked == 14 || cardPicked == 27 || cardPicked == 40) && pScore > 19) { lost = true; pScore += 2; }
				else if ((cardPicked == 1 || cardPicked == 14 || cardPicked == 27 || cardPicked == 40) && pScore == 19) { won = true; pScore += 2; }
				else if ((cardPicked == 1 || cardPicked == 14 || cardPicked == 27 || cardPicked == 40) && pScore < 19) { pScore += 2; }
				
				if((cardPicked == 2 || cardPicked == 15 || cardPicked == 28 || cardPicked == 41) && pScore > 18) { lost = true; pScore += 3; }
				else if ((cardPicked == 2 || cardPicked == 15 || cardPicked == 28 || cardPicked == 41) && pScore == 18) { won = true; pScore += 3; }
				else if ((cardPicked == 2 || cardPicked == 15 || cardPicked == 28 || cardPicked == 41) && pScore < 18) { pScore += 3; }
				
				if((cardPicked == 3 || cardPicked == 16 || cardPicked == 29 || cardPicked == 42) && pScore > 17) { lost = true; pScore += 4; }
				else if ((cardPicked == 3 || cardPicked == 16 || cardPicked == 29 || cardPicked == 42) && pScore == 17) { won = true; pScore += 4; }
				else if ((cardPicked == 3 || cardPicked == 16 || cardPicked == 29 || cardPicked == 42) && pScore < 17) { pScore += 4; }
				
				if((cardPicked == 4 || cardPicked == 17 || cardPicked == 30 || cardPicked == 43) && pScore > 16) { lost = true; pScore += 5; }
				else if ((cardPicked == 4 || cardPicked == 17 || cardPicked == 30 || cardPicked == 43) && pScore == 16) { won = true; pScore += 5; }
				else if ((cardPicked == 4 || cardPicked == 17 || cardPicked == 30 || cardPicked == 43) && pScore < 16) { pScore += 5; }
				
				if((cardPicked == 5 || cardPicked == 18 || cardPicked == 31 || cardPicked == 44) && pScore > 15) { lost = true; pScore += 6; }
				else if ((cardPicked == 5 || cardPicked == 18 || cardPicked == 31 || cardPicked == 44) && pScore == 15) { won = true; pScore += 6; }
				else if ((cardPicked == 5 || cardPicked == 18 || cardPicked == 31 || cardPicked == 44) && pScore < 15) { pScore += 6; }
				
				if((cardPicked == 6 || cardPicked == 19 || cardPicked == 32 || cardPicked == 45) && pScore > 14) { lost = true; pScore += 7; }
				else if ((cardPicked == 6 || cardPicked == 19 || cardPicked == 32 || cardPicked == 45) && pScore == 14) { won = true; pScore += 7; }
				else if ((cardPicked == 6 || cardPicked == 19 || cardPicked == 32 || cardPicked == 45) && pScore < 14) { pScore += 7; }
				
				if((cardPicked == 7 || cardPicked == 20 || cardPicked == 33 || cardPicked == 46) && pScore > 13) { lost = true; pScore += 8; }
				else if ((cardPicked == 7 || cardPicked == 20 || cardPicked == 33 || cardPicked == 46) && pScore == 13) { won = true; pScore += 8; }
				else if ((cardPicked == 7 || cardPicked == 20 || cardPicked == 33 || cardPicked == 46) && pScore < 13) { pScore += 8; }
				
				if((cardPicked == 8 || cardPicked == 21 || cardPicked == 34 || cardPicked == 47) && pScore > 12) { lost = true; pScore += 9; }
				else if ((cardPicked == 8 || cardPicked == 21 || cardPicked == 34 || cardPicked == 47) && pScore == 12) { won = true; pScore += 9; }
				else if ((cardPicked == 8 || cardPicked == 21 || cardPicked == 34 || cardPicked == 47) && pScore < 12) { pScore += 9; }
				
				if(((cardPicked >= 9 && cardPicked <= 12) || (cardPicked >= 22 && cardPicked <= 25) ||
				    (cardPicked >= 35 && cardPicked <= 38) || (cardPicked >= 48 && cardPicked <= 51)) && pScore > 11) { lost = true; pScore += 10; }
				else if (((cardPicked >= 9 && cardPicked <= 12) || (cardPicked >= 22 && cardPicked <= 25) ||
				    (cardPicked >= 35 && cardPicked <= 38) || (cardPicked >= 48 && cardPicked <= 51)) && pScore == 11) { won = true; pScore += 10; }
				else if (((cardPicked >= 9 && cardPicked <= 12) || (cardPicked >= 22 && cardPicked <= 25) ||
				    (cardPicked >= 35 && cardPicked <= 38) || (cardPicked >= 48 && cardPicked <= 51)) && pScore < 11) { pScore += 10; }
				
				playerScore.setText("Player score is: " + pScore);
				
				if(lost == true) {
					announce.setEnabled(true);
					announce.setText("LOSS");
					hit.setEnabled(false);
					stand.setEnabled(false);
				}
				
				if (hitAlready == 0) { pcard1.setIcon(cardimg.images.get(mapToImage)); hitAlready++; }
				else if (hitAlready == 1) { pcard2.setIcon(cardimg.images.get(mapToImage)); hitAlready++; }
				else if (hitAlready == 2) { pcard3.setIcon(cardimg.images.get(mapToImage)); hitAlready++; }
				else if (hitAlready == 3) { pcard4.setIcon(cardimg.images.get(mapToImage)); hitAlready++; }
			}
		} else if (source == stand) {
			
		} else if (source == reset) {
			Redraw();
		}
	}
}
