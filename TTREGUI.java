
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
import java.util.ArrayList;
import java.util.HashMap;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import java.awt.event.MouseEvent;
import java.awt.Color;
public class TTREGUI extends JPanel implements SwitchablePanel{
	private BufferedImage gamebg,gameboard,routecardback,traincardback;
	private Font f;
	private int citySide;
	private HashMap<String, JButton> cityButtons;
	private boolean done;
	private int[][] cityCoords;
	private GameController game;
	private ButtonListener listener;
	private Mouse m;
	private double[] xs = {0.34978991596638653,0.3739495798319328,0.38813025210084034,0.38760504201680673};
	private double[] ys = {0.6839577329490875,0.7070124879923151,0.7463976945244957,0.7953890489913544};
	private double[] as = {-1.1239026293174175,-0.6334340818005209,-6.281592653589794,-5.622282585256936};
	private ArrayList<Player> players = new ArrayList<>();


	public TTREGUI(GameController game) {
		this.game = game;

		m = new Mouse();
		this.addMouseListener(m);
		f = new Font("Centaur", 0, 90);
		done = false;
		listener = new ButtonListener();
		cityButtons = new HashMap<String, JButton>();
		String[] names = {"Edinburgh", "Brest", "Lisbon", "Madrid", "London", "Dieppe", "Bruxelles", "Pamplona", "Amsterdam", "Paris", "Essen", "Berlin", "Cadiz", "Barcelona", "Marseille", "Zurich", "Roma", "Munchen", "Frankfurt", "Kobenhavn", "Stockholm", "Riga", "Danzig", "Venezia", "Palermo", "Brindisi", "Zagrab", "Wien", "Budapest", "Sarajevo", "Sofia", "Athina", "Smyrna", "Constantinople", "Angora", "Erzurum", "Kyiv", "Moskva", "Petrograd", "Warszawa", "Bucuresti", "Wilno", "Smolensk", "Kharkov", "Rostov", "Sevastopol", "Sochi"};
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
		for(int i = 0; i < 47; i ++) {
			JButton but = new JButton();
			//but.setBounds(cityCoords[i][0], cityCoords[i][1], citySide, citySide);
			but.setName(names[i]);
			add(but);
			//but.setOpaque(false);
			//but.setContentAreaFilled(false);
			// but.setBorderPainted(false);
			cityButtons.put(names[i], but);
			done = true;
		}
		this.addComponentListener(new ComponentAdapter() {
			public void componentResized(ComponentEvent e) {
				int[][] temp2d = {{(int)(getWidth()*0.10189), (int)(getHeight()*0.03170)}, {(int)(getWidth()*0.07458), (int)(getHeight()*0.39673)}, {(int)(getWidth()*0.00525), (int)(getHeight()*0.76849)}, {(int)(getWidth()*0.05777), (int)(getHeight()*0.73775)}, {(int)(getWidth()*0.15331), (int)(getHeight()*0.23631)}, {(int)(getWidth()*0.14391), (int)(getHeight()*0.35927)}, {(int)(getWidth()*0.20903), (int)(getHeight()*0.30451)}, {(int)(getWidth()*0.13288), (int)(getHeight()*0.62824)}, {(int)(getWidth()*0.22584), (int)(getHeight()*0.24015)}, {(int)(getWidth()*0.18225), (int)(getHeight()*0.41883)}, {(int)(getWidth()*0.28851), (int)(getHeight()*0.25456)}, {(int)(getWidth()*0.36450), (int)(getHeight()*0.27328)}, {(int)(getWidth()*0.05672), (int)(getHeight()*0.83958)}, {(int)(getWidth()*0.14181), (int)(getHeight()*0.75216)}, {(int)(getWidth()*0.24895), (int)(getHeight()*0.62152)}, {(int)(getWidth()*0.27048), (int)(getHeight()*0.49472)}, {(int)(getWidth()*0.33981), (int)(getHeight()*0.66090)}, {(int)(getWidth()*0.32038), (int)(getHeight()*0.40826)}, {(int)(getWidth()*0.27731), (int)(getHeight()*0.34874)}, {(int)(getWidth()*0.34296), (int)(getHeight()*0.10951)}, {(int)(getWidth()*0.42227), (int)(getHeight()*0.00288)}, {(int)(getWidth()*0.51471), (int)(getHeight()*0.04323)}, {(int)(getWidth()*0.45168), (int)(getHeight()*0.16523)}, {(int)(getWidth()*0.33351), (int)(getHeight()*0.53794)}, {(int)(getWidth()*0.36922), (int)(getHeight()*0.84054)}, {(int)(getWidth()*0.40599), (int)(getHeight()*0.69549)}, {(int)(getWidth()*0.39811), (int)(getHeight()*0.55620)}, {(int)(getWidth()*0.40704), (int)(getHeight()*0.43036)}, {(int)(getWidth()*0.44568), (int)(getHeight()*0.46590)}, {(int)(getWidth()*0.46218), (int)(getHeight()*0.63401)}, {(int)(getWidth()*0.51471), (int)(getHeight()*0.64745)}, {(int)(getWidth()*0.50000), (int)(getHeight()*0.80019)}, {(int)(getWidth()*0.56618), (int)(getHeight()*0.83573)}, {(int)(getWidth()*0.60032), (int)(getHeight()*0.72815)}, {(int)(getWidth()*0.65851), (int)(getHeight()*0.80211)}, {(int)(getWidth()*0.72059), (int)(getHeight()*0.77233)}, {(int)(getWidth()*0.60534), (int)(getHeight()*0.33433)}, {(int)(getWidth()*0.71901), (int)(getHeight()*0.20077)}, {(int)(getWidth()*0.64483), (int)(getHeight()*0.03730)}, {(int)(getWidth()*0.48897), (int)(getHeight()*0.26129)}, {(int)(getWidth()*0.56145), (int)(getHeight()*0.56004)}, {(int)(getWidth()*0.57511), (int)(getHeight()*0.22757)}, {(int)(getWidth()*0.65389), (int)(getHeight()*0.23535)}, {(int)(getWidth()*0.70746), (int)(getHeight()*0.40538)}, {(int)(getWidth()*0.73937), (int)(getHeight()*0.47746)}, {(int)(getWidth()*0.66702), (int)(getHeight()*0.58021)}, {(int)(getWidth()*0.73548), (int)(getHeight()*0.59942)}};
				cityCoords = temp2d;
				citySide = (int)(getWidth()*0.011556);
				int index = 0;
				for(String str : names) {
					cityButtons.get(str).setBounds(cityCoords[index][0], cityCoords[index][1], citySide, citySide);
					index++;
				}
			}
		});
		for(String str : names) {
			JButton temp = cityButtons.get(str);
			temp.addActionListener(listener);
		}
	}
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D)g.create();
		AffineTransform initial = g2.getTransform();
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.drawImage(gamebg, 0, 0, getWidth(), getHeight(), null);
		g.drawImage(gameboard, 0, 0, (int)(getWidth()*0.75557), (int)(getHeight()*0.86306), null);
		g.setFont(f);
		int turn = game.getCurrentPlayerNumber();
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

		g2.setTransform(initial);

		for(Player p : players) {
			Color c = p.getColor();
			ArrayList<Road> roads = p.getRoads();
			for(Road r : roads) {
				double[] xs = r.getxs();
				double[] ys = r.getys();
				double[] as = r.getas();
				
				for(int i = 0; i < 4; i++) {
					AffineTransform old = g2.getTransform();
					g2.setColor(c);

					int x = (int) (xs[i]*getWidth());
					int y= (int) (ys[i]*getHeight());
					double a = as[i];
					g2.rotate(a,x,y);
					g2.fill3DRect(x, y, 12, 50, true);
					g2.draw3DRect(x,y,12,50,true);
					g2.draw3DRect(x+1,y+1,12,43,true);
					g2.draw3DRect(x+2,y+2,12,43,true);
					g2.draw3DRect(x+3,y+3,12,43,true);
					g2.draw3DRect(x+4,y+4,12,43,true);
					g2.draw3DRect(x+5,y+5,12,43,true);
					g2.setTransform(old);
				}

			}

		}


	}
	@Override
	public void OnSwitchedTo() {
		this.players = game.getPlayers();
		repaint();
	}
}

class ButtonListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {

		JButton button = (JButton) e.getSource();
		String source = button.getName();




	}


}


class Mouse implements MouseListener{
	ArrayList<Double> xs = new ArrayList<Double>();
	ArrayList<Double> ys = new ArrayList<Double>();
	ArrayList<Double> xss = new ArrayList<Double>();
	ArrayList<Double> yss = new ArrayList<Double>();
	ArrayList<Double> a = new ArrayList<Double>();
	@Override
	public void mouseClicked(MouseEvent e) {


		if(e.getButton() == 1) {

			xs.add(e.getX()/1904.0);
			ys.add(e.getY()/1041.0);
			yss.add((double) e.getY());
			xss.add((double) e.getX());


		}

		if(e.getButton() == 3) {
			a.add((Math.atan2(xss.getLast() - e.getX(), yss.getLast() - e.getY()))*-1-3.14);
		}


	}

	@Override
	public void mousePressed(MouseEvent e) {
		if(e.getButton()==2) {


			System.out.print("new double[]{");
			for(int i = 0; i < xs.size()-1;i++) {
				System.out.print(xs.get(i) + ",");	
			}
			System.out.print(xs.getLast() + "}");

			System.out.print(",");

			System.out.print("new double[]{");
			for(int i = 0; i < ys.size()-1;i++) {
				System.out.print(ys.get(i) + ",");	
			}
			System.out.print(ys.getLast() + "}");

			System.out.print(",");

			System.out.print("new double[]{");
			for(int i = 0; i < xs.size()-1;i++) {
				System.out.print(a.get(i) + ",");	
			}
			System.out.print(a.getLast() + "}");

		}

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
