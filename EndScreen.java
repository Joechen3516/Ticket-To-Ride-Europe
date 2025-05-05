import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class EndScreen extends JPanel implements SwitchablePanel{
	private GameController game;
	private BufferedImage bg;
	public EndScreen(GameController game) {
		this.game = game;
		this.setLayout(null);
		try {
			bg = ImageIO.read(EndScreen.class.getResource("/images/endscreen.png"));
		}
		catch(Exception e) {
			System.out.println("End Screen error");
		}
	}
	public void paintComponent(Graphics g) {
		g.drawImage(bg, 0, 0, getWidth(), getHeight(), null);
		Font f = new Font("YouYuan", Font.ITALIC, 160);
        g.setFont(f);
        g.setColor(Color.black);
        g.drawString("Game Over", 130, 300);
        f = new Font("Times New Roman", Font.BOLD, 60);
        Player p = game.getPlayers().get(0);
        for(Player player : game.getPlayers()) {
        	if(player.getRoadScore() > p.getRoadScore()) {
        		System.out.println("replaced");
        		p = player;
        	}
        }
        String pNum = "";
        if(p.getColor().equals(new Color(255,49,49))) {
        	pNum = "1";
        }
        else if(p.getColor().equals(new Color(0,74,173))) {
        	pNum = "2";
        }
        else if(p.getColor().equals(new Color(0,191,99))) {
        	pNum = "3";
        }
        else if(p.getColor().equals(new Color(193,255,114))){
        	pNum = "4";
        }
        g.drawString("Player " + pNum + " won!", 150, 400);
	}
	@Override
	public void OnSwitchedTo() {
		// TODO Auto-generated method stub
		
	}

}
