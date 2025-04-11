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
	private int citySide;

	public TTREGUI(GameFrame frame) {
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
		g.fillRect((int)(getWidth()*0.10189), (int)(getHeight()*0.0317),citySide,citySide);
		//Edinburgh
		g.fillRect((int)(getWidth()*0.07458), (int)(getHeight()*0.39673), citySide, citySide);
		//Brest
		g.fillRect((int)(getWidth()*0.00525), (int)(getHeight()*0.76849), citySide, citySide);
		//Lisbon
		g.fillRect((int)(getWidth()*0.05777), (int)(getHeight()*0.73775), citySide, citySide);
		//Madrid
		g.fillRect((int)(getWidth()*0.15331), (int)(getHeight()*0.23631), citySide, citySide);
		//London
		g.fillRect((int)(getWidth()*0.14391), (int)(getHeight()*0.35927), citySide, citySide);
		//Dieppe
		g.fillRect((int)(getWidth()*0.20903), (int)(getHeight()*0.30451), citySide, citySide);
		//Bruxelles
		g.fillRect((int)(getWidth()*0.13288), (int)(getHeight()*0.62824), citySide, citySide);
		//Pamplona
		g.fillRect((int)(getWidth()*0.22584), (int)(getHeight()*0.24015), citySide, citySide);
		//Amsterdam
		g.fillRect((int)(getWidth()*0.18225), (int)(getHeight()*0.41883), citySide, citySide);
		//Paris
		g.fillRect((int)(getWidth()*0.28851), (int)(getHeight()*0.25456), citySide, citySide);
		//Essen
		g.fillRect((int)(getWidth()*0.36450), (int)(getHeight()*0.27328), citySide, citySide);
		//Berlin
		g.fillRect((int)(getWidth()*0.05672), (int)(getHeight()*0.83958), citySide, citySide);
		//Cadiz
		g.fillRect((int)(getWidth()*0.14181), (int)(getHeight()*0.75216), citySide, citySide);
		//Barcelona
		g.fillRect((int)(getWidth()*0.24895), (int)(getHeight()*0.62152), citySide, citySide);
		//Marseille
		g.fillRect((int)(getWidth()*0.27048), (int)(getHeight()*0.49472), citySide, citySide);
		//Zurich
		g.fillRect((int)(getWidth()*0.33981), (int)(getHeight()*0.66090), citySide, citySide);
		//Roma
		g.fillRect((int)(getWidth()*0.32038), (int)(getHeight()*0.40826), citySide, citySide);
		//Munchen
		g.fillRect((int)(getWidth()*0.27731), (int)(getHeight()*0.34874), citySide, citySide);
		//Frankfurt
		g.fillRect((int)(getWidth()*0.34296), (int)(getHeight()*0.10951), citySide, citySide);
		//Kobenhavn
		g.fillRect((int)(getWidth()*0.42227), (int)(getHeight()*0.00288), citySide, citySide);
		//Stockholm
		g.fillRect((int)(getWidth()*0.51471), (int)(getHeight()*0.04323), citySide, citySide);
		//Riga
		g.fillRect((int)(getWidth()*0.45168), (int)(getHeight()*0.16523), citySide, citySide);
		//Danzig
		g.fillRect((int)(getWidth()*0.33351), (int)(getHeight()*0.53794), citySide, citySide);
		//Venezia
		g.fillRect((int)(getWidth()*0.36922), (int)(getHeight()*0.84054), citySide, citySide);
		//Palermo
		g.fillRect((int)(getWidth()*0.40599), (int)(getHeight()*0.69549), citySide, citySide);
		//Brindisi
		g.fillRect((int)(getWidth()*0.39811), (int)(getHeight()*0.55620), citySide, citySide);
		//Zagrab
		g.fillRect((int)(getWidth()*0.40704), (int)(getHeight()*0.43036), citySide, citySide);
		//Wien
		g.fillRect((int)(getWidth()*0.44568), (int)(getHeight()*0.46590), citySide, citySide);
		//Budapest
		g.fillRect((int)(getWidth()*0.46218), (int)(getHeight()*0.63401), citySide, citySide);
		//Sarajevo
		g.fillRect((int)(getWidth()*0.51471), (int)(getHeight()*0.64745), citySide, citySide);
		//Sofia
		g.fillRect((int)(getWidth()*0.50000), (int)(getHeight()*0.80019), citySide, citySide);
		//Athina
		g.fillRect((int)(getWidth()*0.56618), (int)(getHeight()*0.83573), citySide, citySide);
		//Smyrna
		g.fillRect((int)(getWidth()*0.60032), (int)(getHeight()*0.72815), citySide, citySide);
		//Constantinople
		g.fillRect((int)(getWidth()*0.65851), (int)(getHeight()*0.80211), citySide, citySide);
		//Angora
		g.fillRect((int)(getWidth()*0.72059), (int)(getHeight()*0.77233), citySide, citySide);
		//Erzurum
		g.fillRect((int)(getWidth()*0.60534), (int)(getHeight()*0.33433), citySide, citySide);
		//Kyiv
		g.fillRect((int)(getWidth()*0.71901), (int)(getHeight()*0.20077), citySide, citySide);
		//Moskva
		g.fillRect((int)(getWidth()*0.64483), (int)(getHeight()*0.03730), citySide, citySide);
		//Petrograd
		g.fillRect((int)(getWidth()*0.48897), (int)(getHeight()*0.26129), citySide, citySide);
		//Warszawa
		g.fillRect((int)(getWidth()*0.56145), (int)(getHeight()*0.56004), citySide, citySide);
		//Bucuresti
		g.fillRect((int)(getWidth()*0.57511), (int)(getHeight()*0.22757), citySide, citySide);
		//Wilno
		g.fillRect((int)(getWidth()*0.65389), (int)(getHeight()*0.23535), citySide, citySide);
		//Smolensk
		g.fillRect((int)(getWidth()*0.70746), (int)(getHeight()*0.40538), citySide, citySide);
		//Kharkov
		g.fillRect((int)(getWidth()*0.73937), (int)(getHeight()*0.47746), citySide, citySide);
		//Rostov
		g.fillRect((int)(getWidth()*0.66702), (int)(getHeight()*0.58021), citySide, citySide);
		//Sevastopol
		g.fillRect((int)(getWidth()*0.73748), (int)(getHeight()*0.59942), citySide, citySide);
		//Sochi
	}
}

/*cityButtons = new HashMap<String, JButton>();
		String[] names = {"Edinburgh", "Brest", "Lisbon", "Madrid", "London", "Dieppe", "Bruxelles", "Pamplona", "Amsterdam", "Paris", "Essen", "Berlin", "Cadiz", "Barcelona", "Marseille", "Zurich", "Roma", "Munchen", "Frankfurt", "Kobenhavn", "Stockholm", "Riga", "Danzig", "Venezia", "Palermo", "Brindisi", "Zagrab", "Wien", "Budapest", "Sarajevo", "Sofia", "Athina", "Smyrna", "Constantinople", "Angora", "Erzurum", "Kyiv", "Moskva", "Petrograd", "Warszawa", "Bucuresti", "Wilno", "Smolensk", "Kharkov", "Rostov", "Sevastopol", "Sochi"};
for(int i = 0; i < 47; i ++) {
			JButton but = new JButton(names[i]);
			
		}
*/
