import java.awt.Event;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import java.awt.event.MouseEvent;
import java.awt.Color;
public class TTREGUI extends JPanel{
	private BufferedImage gamebg,gameboard,routecardback,traincardback;
	private Font f;
	private GameController game;
	private int citySide;
	public TTREGUI(GameFrame frame) {
		game = new GameController();
		f = new Font("Centaur", 0, 90);
		this.setLayout(null);
		try {
			gamebg = ImageIO.read(TTREGUI.class.getResource("/images/gamebg.jfif"));
			gameboard = ImageIO.read(TTREGUI.class.getResource("/images/gameboard.PNG"));
			routecardback = ImageIO.read(TTREGUI.class.getResource("/images/routecardback.png"));
			traincardback = ImageIO.read(TTREGUI.class.getResource("/trains/cardback.png"));
		}
		catch(Exception e) {
			System.out.println("TTRE GUI image issue");
		}
	}
	public void paintComponent(Graphics g) {
		System.out.println(getWidth() + " " + getHeight());
		citySide = (int)(getWidth()*0.011556);
		Graphics2D g2 = (Graphics2D)g.create();
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.drawImage(gamebg, 0, 0, getWidth(), getHeight(), null);
		g.drawImage(gameboard, 0, 0, (int)(getWidth()*0.75557), (int)(getHeight()*0.86306), null);
		g.setFont(f);
		//int turn = game.getTurn() + 1;
		int turn = 1;
		if(turn == 1)
			g.setColor(new Color(255,49,49));
		else if(turn == 2)
			g.setColor(new Color(0,74,173));
		else if(turn == 3)
			g.setColor(new Color(0,191,99));
		else 
			g.setColor(new Color(193,255,114));
		g.drawString("Player " + turn, (int)(getWidth()*0.7976), (int)(getHeight()*0.72157));
		AffineTransform rot = new AffineTransform(0.75503,0,0,0.75541,(int)(getWidth()*0.89063),(int)(getHeight()*0.63914));
		double angle = Math.toRadians(270);
		rot.rotate(angle);
		g2.drawImage(traincardback, rot, null);
		g.fillRect((int)(getWidth()*0.10189),(int)(getHeight()*0.0317),citySide,citySide);
		g.fillRect(140, 415, citySide, citySide);
	}
}