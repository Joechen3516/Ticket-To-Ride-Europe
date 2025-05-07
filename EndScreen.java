import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;

public class EndScreen extends JPanel implements SwitchablePanel{
	private GameController game;
	private BufferedImage endscreen;
	JButton back = new JButton();
	public EndScreen(GameController game) {
		add(back);
		this.game = game;
		try {
			endscreen = ImageIO.read(EndScreen.class.getResource("/images/endscreen.png"));
		}
		catch(Exception e) {
			System.out.println("End Screen image error");
		}
		this.setLayout(null);
		this.addComponentListener(new ComponentAdapter(){	
			public void componentResized(ComponentEvent e) {
				back.setBounds((int)(getWidth()*0.81169), (int)(getHeight()*0.82840), (int)(getWidth()*0.16234), (int)(getHeight()*0.11834));
			}
		});
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == back)
					game.restart();
			}
		});
	}
		
	public void paintComponent(Graphics g) {
		g.drawImage(endscreen, 0, 0, getWidth(), getHeight(), null);
		Font f = new Font("Sylfaen", Font.ITALIC, 132);
		g.setColor(Color.black);
		g.setFont(f);
		g.drawString("Game Over", (int)(getWidth()*0.02442), (int)(getHeight()*0.25669));
		System.out.println(getWidth() + " " + getHeight());
		Player winner = game.getPlayers().get(0);
		Player longest = game.getPlayers().get(0);
		for(Player p : game.getPlayers()) {
			if(p.getRoadScore() > winner.getRoadScore()) {
				winner = p;
			}
			if(p.getLongestLength() > winner.getLongestLength()) {
				longest = p;
			}
		}
		int winnerNum = 0;
		if(winner.getColor().equals(new Color(193,255,114))){
			winnerNum = 1;
		}
		else if(winner.getColor().equals(new Color(0,191,99))) {
			winnerNum = 2;
		}
		else if(winner.getColor().equals(new Color(0,74,173))) {
			winnerNum = 3;
		}
		else {
			winnerNum = 4;
		}
		int longestNum = 0;
		if(winner.getColor().equals(new Color(193,255,114))){
			longestNum = 1;
		}
		else if(winner.getColor().equals(new Color(0,191,99))) {
			longestNum = 2;
		}
		else if(winner.getColor().equals(new Color(0,74,173))) {
			longestNum = 3;
		}
		else {
			longestNum = 4;
		}
		
		f = new Font("Times New Roman", Font.BOLD, 66);
		g.setFont(f);
		g.drawString("Player " + winnerNum + " won!", (int)(getWidth()*0.103890), (int)(getHeight()*0.33953));
		f = new Font("Times New Roman", Font.BOLD, 40);
		g.setFont(f);
		g.drawString("Player " + longestNum + " wins the European Express Bonus", (int)(getWidth()*0.03781), (int)(getHeight()*0.39053));
		f = new Font("Times New Roman", 0, 49);
		g.setFont(f);
		int lbY = (int)(getHeight()*0.47337);
		int pNum = 1;
		for(Player p : game.getPlayers()) {
			g.drawString("Player " + pNum + ": " + p.calculateTotalScore(), (int)(getHeight()*0.06494), lbY);
			lbY = lbY + (int)(getHeight()*0.08165);
			pNum++;
		}
	}
	public void OnSwitchedTo() {
		
		
	}

}