
import java.awt.Event;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Shape;
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
import java.awt.font.FontRenderContext;
import java.awt.font.TextLayout;
import java.awt.geom.AffineTransform;
import java.awt.event.MouseEvent;
import java.awt.BasicStroke;
import java.awt.Color;
public class TTREGUI extends JPanel implements SwitchablePanel{
	private BufferedImage gamebg,gameboard,routecardback,traincardback,black,orange,red,blue,green,white,yellow,pink,wild;
	private Font f;
	private int citySide;
	private HashMap<String, JButton> cityButtons;
	private boolean done;
	private int[][] cityCoords;
	private GameController game;
	private ButtonListener listener;
	JButton showroutes = new JButton();
	private boolean routeClicked = false;
	JButton wholescreen = new JButton();
	private String selectedCity;
	JButton roadButton = new JButton("road");
	JButton stationButton = new JButton("station");
	JButton getnewroutes = new JButton();
	private boolean clickedOnCity;
	JButton traincard1 = new JButton();
	JButton traincard2 = new JButton();
	JButton traincard3 = new JButton();
	JButton traincard4 = new JButton();
	JButton traincard5 = new JButton();
	JButton traincard6 = new JButton();
	int cardturn = 0;
	private ArrayList<City> adjacentCities = new ArrayList<City>();
	private String latestCityClicked;
	private boolean clickedRoadOrStation;
	private String[] cityNames;
	JButton playerBlack = new JButton();
	JButton playerOrange = new JButton();
	JButton playerRed = new JButton();
	JButton playerBlue = new JButton();
	JButton playerGreen = new JButton();
	JButton playerWhite = new JButton();
	JButton playerYellow = new JButton();
	JButton playerPink = new JButton();
	JButton playerWild = new JButton();
	JButton confirm = new JButton();
	JButton cancel = new JButton();
	public TTREGUI(GameController game) {
		this.game = game;
		clickedRoadOrStation = false;
		f = new Font("Centaur", 0, 90);
		done = false;
		clickedOnCity = false;
		latestCityClicked = "";
		listener = new ButtonListener(this);
		cityButtons = new HashMap<String, JButton>();
		roadButton.setName("road");
		add(roadButton);
		roadButton.addActionListener(listener);
		/*roadButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(selectedCity.length() > 0 && e.getSource() == roadButton && routeClicked == false) {
					System.out.println("ROAD");
					game.HandleAction(ActionEvents.PurchaseRoad);
					
				}
				repaint();
			}
		});*/
		cancel.setName("cancel");
		add(cancel);
		cancel.setOpaque(false);
		cancel.setContentAreaFilled(false);
		cancel.setBorderPainted(false);
		cancel.addActionListener(listener);
		confirm.setName("confirm");
		add(confirm);
		confirm.setOpaque(false);
		confirm.setContentAreaFilled(false);
		confirm.setBorderPainted(false);
		confirm.addActionListener(listener);
		stationButton.setName("station");
		add(stationButton);
		stationButton.addActionListener(listener);
		/*stationButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(selectedCity.length() > 0 && e.getSource() == stationButton && routeClicked == false) {
					System.out.println("STATION");
					game.HandleAction(ActionEvents.PlaceStation);
				}
				repaint();
			}
		});*/
		playerBlack.setName("playerBlack");
		add(playerBlack);
		playerBlack.setOpaque(false);
		playerBlack.setContentAreaFilled(false);
		playerBlack.setBorderPainted(false);
		playerBlack.addActionListener(listener);
		playerOrange.setName("playerOrange");
		add(playerOrange);
		playerOrange.setOpaque(false);
		playerOrange.setContentAreaFilled(false);
		playerOrange.setBorderPainted(false);
		playerOrange.addActionListener(listener);
		playerRed.setName("playerRed");
		add(playerRed);
		playerRed.setOpaque(false);
		playerRed.setContentAreaFilled(false);
		playerRed.setBorderPainted(false);
		playerRed.addActionListener(listener);
		playerBlue.setName("playerBlue");
		add(playerBlue);
		playerBlue.setOpaque(false);
		playerBlue.setContentAreaFilled(false);
		playerBlue.setBorderPainted(false);
		playerBlue.addActionListener(listener);
		playerGreen.setName("playerGreen");
		add(playerGreen);
		playerGreen.setOpaque(false);
		playerGreen.setContentAreaFilled(false);
		playerGreen.setBorderPainted(false);
		playerGreen.addActionListener(listener);
		playerWhite.setName("playerWhite");
		add(playerWhite);
		playerWhite.setOpaque(false);
		playerWhite.setContentAreaFilled(false);
		playerWhite.setBorderPainted(false);
		playerWhite.addActionListener(listener);
		playerYellow.setName("playerYellow");
		add(playerYellow);
		playerYellow.setOpaque(false);
		playerYellow.setContentAreaFilled(false);
		playerYellow.setBorderPainted(false);
		playerYellow.addActionListener(listener);
		playerPink.setName("playerPink");
		add(playerPink);
		playerPink.setOpaque(false);
		playerPink.setContentAreaFilled(false);
		playerPink.setBorderPainted(false);
		playerPink.addActionListener(listener);
		playerWild.setName("playerWild");
		add(playerWild);
		playerWild.setOpaque(false);
		playerWild.setContentAreaFilled(false);
		playerWild.setBorderPainted(false);
		playerWild.addActionListener(listener);
		add(showroutes);
		showroutes.setOpaque(false);
		showroutes.setContentAreaFilled(false);
		showroutes.setBorderPainted(true);
		selectedCity = "";
		add(traincard1);
		traincard1.setOpaque(false);
		traincard1.setContentAreaFilled(false);
		traincard1.setBorderPainted(true);
		add(traincard2);
		traincard2.setOpaque(false);
		traincard2.setContentAreaFilled(false);
		traincard2.setBorderPainted(true);
		add(traincard3);
		traincard3.setOpaque(false);
		traincard3.setContentAreaFilled(false);
		traincard3.setBorderPainted(true);
		add(traincard4);
		traincard4.setOpaque(false);
		traincard4.setContentAreaFilled(false);
		traincard4.setBorderPainted(true);
		add(traincard5);
		traincard5.setOpaque(false);
		traincard5.setContentAreaFilled(false);
		traincard5.setBorderPainted(true);
		add(traincard6);
		traincard6.setOpaque(false);
		traincard6.setContentAreaFilled(false);
		traincard6.setBorderPainted(true);
		String[] names = {"Edinburgh", "Brest", "Lisboa", "Madrid", "London", "Dieppe", "Bruxelles", "Pamplona", "Amsterdam", "Paris", "Essen", "Berlin", "Cadiz", "Barcelona", "Marseille", "Zurich", "Roma", "Monchen", "Frankfurt", "Kobenhavn", "Stockholm", "Rica", "Danzic", "Venezia", "Palermo", "Brindisi", "Zacrad", "Wien", "Budapest", "Sarajevo", "Sofia", "Athina", "Smyrna", "Constantinople", "Ancora", "Erzurum", "Kyiv", "Moskova", "Petrograd", "Warszawa", "Bucuresti", "Wilno", "Smolensk", "Kharkov", "Rostov", "Sevastopol", "Sochi"};
		cityNames = names;
		this.setLayout(null);
		try {
			gamebg = ImageIO.read(TTREGUI.class.getResource("/images/gamebg.jfif"));
			gameboard = ImageIO.read(TTREGUI.class.getResource("/images/gameboard.PNG"));
			routecardback = ImageIO.read(TTREGUI.class.getResource("/images/routecardback.png"));
			traincardback = ImageIO.read(TTREGUI.class.getResource("/trains/cardback.png"));
			black = ImageIO.read(TTREGUI.class.getResource("/trains/black.jpg"));
			orange = ImageIO.read(TTREGUI.class.getResource("/trains/orange.jpg"));
			red = ImageIO.read(TTREGUI.class.getResource("/trains/red.jpg"));
			blue = ImageIO.read(TTREGUI.class.getResource("/trains/blue.jpg"));
			green = ImageIO.read(TTREGUI.class.getResource("/trains/green.jpg"));
			white = ImageIO.read(TTREGUI.class.getResource("/trains/white.jpg"));
			yellow = ImageIO.read(TTREGUI.class.getResource("/trains/yellow.jpg"));
			pink = ImageIO.read(TTREGUI.class.getResource("/trains/pink.jpg"));
			wild = ImageIO.read(TTREGUI.class.getResource("/trains/wild.jpg"));
		}
		catch(Exception e) {
			System.out.println("TTRE GUI image issue");
		}
		for(int i = 0; i < 47; i ++) {
			JButton but = new JButton();
			//but.setBounds(cityCoords[i][0], cityCoords[i][1], citySide, citySide);
			but.setName(names[i]);
			add(but);
			but.setOpaque(false);
	        but.setContentAreaFilled(false);
	        but.setBorderPainted(false);
			cityButtons.put(names[i], but);
			done = true;
		}
		add(getnewroutes);
        getnewroutes.setOpaque(false);
        getnewroutes.setContentAreaFilled(false);
        getnewroutes.setBorderPainted(true);
		add(wholescreen);
		wholescreen.setOpaque(false);
		wholescreen.setContentAreaFilled(false);
		wholescreen.setBorderPainted(false);
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
				showroutes.setBounds(getWidth()*1500/1920, getHeight()*820/1080, getWidth()/7, 11*getHeight()/55);
				getnewroutes.setBounds(getWidth()*1480/1920, getHeight()*50/1080 , getWidth()/12, getHeight()/5);
				wholescreen.setBounds(0, 0, getWidth(), getHeight());
				traincard1.setBounds((int)(getWidth()*0.88971),(int)(getHeight()*0.01825) , (int)(getWidth()*0.08981),(int)(getHeight()*0.09798));
				traincard2.setBounds((int)(getWidth()*0.88971),(int)(getHeight()*0.01825)+ (int)(getHeight()*0.10086) , (int)(getWidth()*0.08981),(int)(getHeight()*0.09798));
				traincard3.setBounds((int)(getWidth()*0.88971),(int)(getHeight()*0.01825)+ (int)(getHeight()*0.10086)+ (int)(getHeight()*0.10086) , (int)(getWidth()*0.08981),(int)(getHeight()*0.09798));
				traincard4.setBounds((int)(getWidth()*0.88971),(int)(getHeight()*0.01825)+ (int)(getHeight()*0.10086)+ (int)(getHeight()*0.10086) + (int)(getHeight()*0.10086), (int)(getWidth()*0.08981),(int)(getHeight()*0.09798));
				traincard5.setBounds((int)(getWidth()*0.88971),(int)(getHeight()*0.01825)+ (int)(getHeight()*0.10086)+ (int)(getHeight()*0.10086) + (int)(getHeight()*0.10086) + (int)(getHeight()*0.10086), (int)(getWidth()*0.08981),(int)(getHeight()*0.09798));
				traincard6.setBounds((int)(getWidth()*0.88971),(int)(getHeight()*580/1080), (int)(getWidth()*0.08981),(int)(getHeight()*0.09998));
				int blackX = (int)(getWidth()*0.00630);
				int blueX = blackX + (int)(getWidth()*0.08403);
				int greenX = blueX + (int)(getWidth()*0.08403);
				int orangeX = greenX + (int)(getWidth()*0.08403);
				int pinkX = orangeX + (int)(getWidth()*0.08403);
				int redX = pinkX + (int)(getWidth()*0.08403);
				int whiteX = redX + (int)(getWidth()*0.08403);
				int yellowX = whiteX + (int)(getWidth()*0.08403);
				int wildX = yellowX + (int)(getWidth()*0.08403);
				int ptrY = (int)(getHeight()*0.88377);
				playerBlack.setBounds(blackX, ptrY, (int)(getWidth()*0.07878), (int)(getHeight()*0.08646));
				playerBlue.setBounds(blueX, ptrY, (int)(getWidth()*0.07878), (int)(getHeight()*0.08646));
				playerGreen.setBounds(greenX, ptrY, (int)(getWidth()*0.07878), (int)(getHeight()*0.08646));
				playerOrange.setBounds(orangeX, ptrY, (int)(getWidth()*0.07878), (int)(getHeight()*0.08646));
				playerPink.setBounds(pinkX, ptrY, (int)(getWidth()*0.07878), (int)(getHeight()*0.08646));
				playerRed.setBounds(redX, ptrY, (int)(getWidth()*0.07878), (int)(getHeight()*0.08646));
				playerWhite.setBounds(whiteX, ptrY, (int)(getWidth()*0.07878), (int)(getHeight()*0.08646));
				playerYellow.setBounds(yellowX, ptrY, (int)(getWidth()*0.07878), (int)(getHeight()*0.08646));
				playerWild.setBounds(wildX, ptrY, (int)(getWidth()*0.07878), (int)(getHeight()*0.08646));
			}
		});
		showroutes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				

				if (e.getSource() == showroutes && routeClicked == false && !game.checkThree()) {
					System.out.println("1129");
					routeClicked = true; 
				} else if (e.getSource() == showroutes && routeClicked == true) {
					routeClicked = false; 
				}
				
				
				
				repaint();
			}
		});
		getnewroutes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                    
                    
                    if (e.getSource() == getnewroutes && routeClicked == false && !game.checkThree() && !game.getWait()) {
                            game.HandleAction(ActionEvents.RouteButton);
                            
                    }
                    repaint();
            }
		});
		wholescreen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				

				if (e.getSource() == wholescreen && routeClicked == true) {
					System.out.println("clicked whole screen");
					routeClicked = false; 
				} else if (e.getSource() == wholescreen && game.checkThree()) {
					game.replaceFive();
					 
				} else if (e.getSource() == wholescreen && game.getWait()) {
					game.waitToFalse();
					game.HandleAction(ActionEvents.LimboCard);
					 
				} 
				
				
				
				repaint();
			}
		});
		traincard1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				

				if (e.getSource() == traincard1 && routeClicked == false && !game.checkThree()&& !game.getWait()) {
					game.which5(0);
					game.HandleAction(ActionEvents.TrainCard);
				} 
				
				
				
				repaint();
			}
		});
		traincard2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				

				if (e.getSource() == traincard2 && routeClicked == false && !game.checkThree()&& !game.getWait()) {
					game.which5(1);
					game.HandleAction(ActionEvents.TrainCard);
				} 
				
				
				
				repaint();
			}
		});
		traincard3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				

				if (e.getSource() == traincard3 && routeClicked == false && !game.checkThree()&& !game.getWait()) {
					game.which5(2);
					game.HandleAction(ActionEvents.TrainCard);
				} 
				
				
				
				repaint();
			}
		});
		traincard4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				

				if (e.getSource() == traincard4 && routeClicked == false && !game.checkThree()&& !game.getWait()) {
					game.which5(3);
					game.HandleAction(ActionEvents.TrainCard);
				} 
				
				
				
				repaint();
			}
		});
		traincard5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				

				if (e.getSource() == traincard5 && routeClicked == false && !game.checkThree()&& !game.getWait()) {
					game.which5(4);
					game.HandleAction(ActionEvents.TrainCard);
				} 
				
				
				
				repaint();
			}
		});
		traincard6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                    
                    
                    if (e.getSource() == traincard6 && routeClicked == false && !game.checkThree() && !game.getWait()) {
                            game.waitToTrue();
                            game.HandleAction(ActionEvents.TrainDeck);
                    }
                    
                    
                    
                    repaint();
            }
		});
		for(String str : names) {
			JButton temp = cityButtons.get(str);
			temp.addActionListener(listener);
		}
	}
	public void paintComponent(Graphics g) {
		//System.out.println(getWidth() + " " + getHeight());
		Graphics2D g2 = (Graphics2D)g.create();
		AffineTransform initial = g2.getTransform();
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.drawImage(gamebg, 0, 0, getWidth(), getHeight(), null);
		if(game.getGuiState() == GuiState.nothing) {
			g.drawImage(gameboard, 0, 0, (int)(getWidth()*0.75557), (int)(getHeight()*0.86306), null);
			int index = 0;
			for(String str : cityNames) {
				cityButtons.get(str).setBounds(cityCoords[index][0], cityCoords[index][1], citySide, citySide);
				index++;
			}
			confirm.setBounds(-100,-100,0,0);
			cancel.setBounds(-100, -100, 0, 0);
		}
		else if(game.getGuiState() == GuiState.roadPurchasePanel) {
			g.setColor(Color.gray);
			g.fillRect(0, 0, (int)(getWidth()*0.75557), (int)(getHeight()*0.86306));
			confirm.setBounds((int)(getWidth()*0.12080), (int)(getHeight()*0.69164), (int)(getWidth()*0.15756), (int)(getHeight()*0.09606));
			g.setColor(Color.yellow);
			g.drawRect((int)(getWidth()*0.12080), (int)(getHeight()*0.69164), (int)(getWidth()*0.15756), (int)(getHeight()*0.09606));
			g.fillRect((int)(getWidth()*0.12080), (int)(getHeight()*0.69164), (int)(getWidth()*0.15756), (int)(getHeight()*0.09606));
			cancel.setBounds((int)(getWidth()*0.33088), (int)(getHeight()*0.69164), (int)(getWidth()*0.15756), (int)(getHeight()*0.09606));
			g.drawRect((int)(getWidth()*0.33088), (int)(getHeight()*0.69164), (int)(getWidth()*0.15756), (int)(getHeight()*0.09606));
			g.fillRect((int)(getWidth()*0.33088), (int)(getHeight()*0.69164), (int)(getWidth()*0.15756), (int)(getHeight()*0.09606));
			g.setColor(Color.black);
			g.drawString("Confirm", 330, 710);
			g.drawString("Cancel", 630, 710);
			for(String str : cityNames) {
				cityButtons.get(str).setBounds(-100, -100, 0, 0);
			}
			g.setColor(Color.yellow);
			g.setFont(f);
			g.drawString("Buying road from " + game.getCurrentCities().get(0) + " to " + game.getCurrentCities().get(1), 5, 100);
			Europe europe = game.getEurope();
			ArrayList<Road> roads = europe.roadSearch(europe.citySearch(game.getCurrentCities().get(0)),europe.citySearch(game.getCurrentCities().get(1)));
			Font tempF = new Font("Centaur", 0, 50);
			if(roads.size() == 1) {
				if(roads.get(0).hasMountains()) {
					
				}
				else if(roads.get(0).getLength()[1] > 0) {
					
				}
				else {
					g.setFont(tempF);
					g.drawString("Cost: " + roads.get(0).getLength()[0] + " " + roads.get(0).getColor(), (int)(getWidth()*0.23634), (int)(getHeight()*0.19212));
					int addedTrainX = 10;
					for(TrainCard t : game.getSelectedTrainCards()) {
						BufferedImage temp = null;
						switch(t.getColor()) {
							case TrainColor.Black:
								temp = black;
								break;
							case TrainColor.Orange:
								temp = orange;
								break;
							case TrainColor.Red:
								temp = red;
								break;
							case TrainColor.Blue:
								temp = blue;
								break;
							case TrainColor.Green:
								temp = green;
								break;
							case TrainColor.White:
								temp = white;
								break;
							case TrainColor.Yellow:
								temp = yellow;
								break;
							case TrainColor.Pink:
								temp = pink;
								break;
							case TrainColor.Wild:
								temp = wild;
								break;
						}
						g.drawImage(temp, addedTrainX, 250, 130, 80, null);
						addedTrainX = addedTrainX + 140;
					}
				}
			}
			else {
				
			}
		}
		else if(game.getGuiState() == GuiState.stationPurchasePanel) {
			g.setColor(Color.gray);
			g.fillRect(0, 0, (int)(getWidth()*0.75557), (int)(getHeight()*0.86306));
		}
		g.setFont(f);
		int turn = game.getCurrentPlayerNumber();
		Player p = game.getCurrentPlayer();
		if(game.checkThree()) {
            
            Font z = new Font("Centaur", 0, 25);
            g.setFont(z);
            
            g.setColor(new Color(255,49,49));
            g.drawString("Detected 3 locomotives", (int)(getWidth()*0.7576), (int)(getHeight()*0.32157));
            g.drawString("Click anywhere to proceed", (int)(getWidth()*0.7576), (int)(getHeight()*0.42157));
            
            g.setFont(f);
            
    } else if (game.getWait()) {
            if(game.getj()!= null) {
                if(game.getj().getColor() == TrainColor.Black) {
                        g.drawImage(black, getWidth()*1480/1920, getHeight()*350/1080 , (int)(getWidth()*0.07878), (int)(getHeight()*0.08646), null);
                }
                if(game.getj().getColor() == TrainColor.Yellow) {
                        g.drawImage(yellow, getWidth()*1480/1920, getHeight()*350/1080 , (int)(getWidth()*0.07878), (int)(getHeight()*0.08646), null);
                }
                if(game.getj().getColor() == TrainColor.Wild) {
                        g.drawImage(wild, getWidth()*1480/1920, getHeight()*350/1080 , (int)(getWidth()*0.07878), (int)(getHeight()*0.08646), null);
                }
                if(game.getj().getColor() == TrainColor.Red) {
                        g.drawImage(red, getWidth()*1480/1920, getHeight()*350/1080 , (int)(getWidth()*0.07878), (int)(getHeight()*0.08646), null);
                }
                if(game.getj().getColor() == TrainColor.Green) {
                        g.drawImage(green, getWidth()*1480/1920, getHeight()*350/1080 , (int)(getWidth()*0.07878), (int)(getHeight()*0.08646), null);
                }
                if(game.getj().getColor() == TrainColor.Pink) {
                        g.drawImage(pink, getWidth()*1480/1920, getHeight()*350/1080 , (int)(getWidth()*0.07878), (int)(getHeight()*0.08646), null);
                }
                if(game.getj().getColor() == TrainColor.Orange) {
                        g.drawImage(black, getWidth()*1480/1920, getHeight()*350/1080 , (int)(getWidth()*0.07878), (int)(getHeight()*0.08646), null);
                }
                if(game.getj().getColor() == TrainColor.Blue) {
                        g.drawImage(blue, getWidth()*1480/1920, getHeight()*350/1080 , (int)(getWidth()*0.07878), (int)(getHeight()*0.08646), null);
                }
                if(game.getj().getColor() == TrainColor.White) {
                        g.drawImage(blue, getWidth()*1480/1920, getHeight()*350/1080 , (int)(getWidth()*0.07878), (int)(getHeight()*0.08646), null);
                }
        }
            Font z = new Font("Centaur", 0, 25);
            g.setFont(z);
            
            g.setColor(new Color(255,49,49));
            g.drawString("Drawn Card from Draw pile", (int)(getWidth()*0.7576), (int)(getHeight()*0.32157));
            g.drawString("Click anywhere to proceed", (int)(getWidth()*0.7576), (int)(getHeight()*0.42157));
            g.setFont(f);
    }
		if(turn == 1)
			g.setColor(new Color(255,49,49));
		else if(turn == 2)
			g.setColor(new Color(0,74,173));
		else if(turn == 3)
			g.setColor(new Color(0,191,99));
		else 
			g.setColor(new Color(193,255,114));
		g.drawString("Player " + turn, (int)(getWidth()*0.7976), (int)(getHeight()*0.72157));
		g.drawImage(routecardback, getWidth()*1480/1920, getHeight()*50/1080 , getWidth()/12, getHeight()/5, null);
		
		//Drawing adjacent cities
		
		for(City city : adjacentCities) {
			if(game.getCurrentCitiesSize() != 2 && game.getCurrentCitiesSize() != 0) {
				g.setColor(Color.yellow);
				JButton adjCity = cityButtons.get(city.getName());
				g.fillRect(adjCity.getX() - 2, adjCity.getY() - 2, citySide + 5, citySide + 5);
			}
		}
		
		
		//Drawing routes
		ArrayList<RouteCard> rout = p.getRoutes();
		int y = getHeight()*885/1080;
		AffineTransform rot = new AffineTransform(0.75503,0,0,0.75541,(int)(getWidth()*0.89063),(int)(getHeight()*0.63914));
		double angle = Math.toRadians(270);
		rot.rotate(angle);
		if(!routeClicked) {
			
			if(rout.size()<4) {
				for(int i = 0; i < rout.size(); i++) {
					g.drawImage(rout.get(i).getImage(), getWidth()*1500/1920, y, getWidth()/7, getHeight()/7, null);
					y = y-getHeight()*70/1920;
				}
				
			} else {
				for(int i = 0; i < 3; i++) {
					g.drawImage(rout.get(i).getImage(), getWidth()*1500/1920, y, getWidth()/7, getHeight()/7, null);
					y = y-getHeight()*70/1920;
				}
				
			}
			g2.drawImage(traincardback, rot, null);
			ArrayList<TrainCard> currCards = game.getShow5();
			int trX = (int)(getWidth()*0.88971);
			int trY = (int)(getHeight()*0.01825);
			int trW = (int)(getWidth()*0.08981);
			int trH = (int)(getHeight()*0.09798);
			
		    g.drawImage(routecardback, getWidth()*1480/1920, getHeight()*50/1080 , getWidth()/12, getHeight()/5, null);
		    
			
			for(TrainCard tr : currCards) {
				//System.out.println(tr.getColor());
				BufferedImage temp = null;
				if(tr != null) {
					switch(tr.getColor()) {
						case TrainColor.Black:
							temp = black;
							break;
						case TrainColor.Orange:
							temp = orange;
							break;
						case TrainColor.Red:
							temp = red;
							break;
						case TrainColor.Blue:
							temp = blue;
							break;
						case TrainColor.Green:
							temp = green;
							break;
						case TrainColor.White:
							temp = white;
							break;
						case TrainColor.Yellow:
							temp = yellow;
							break;
						case TrainColor.Pink:
							temp = pink;
							break;
						case TrainColor.Wild:
							temp = wild;
							break;
					}
					g.drawImage(temp, trX, trY, trW, trH, null);
					trY = trY + (int)(getHeight()*0.10086);
			}else {
				temp = null;
			}
		}
	

		
	} else  {
		if (rout.size() < 7) {
			for(int i = 0; i < rout.size(); i++) {
				g.drawImage(rout.get(i).getImage(), getWidth()*1500/1920, y, getWidth()/7, getHeight()/7, null);
				y = y-getHeight()*300/1920;
			}
		} else {
			for(int i = 0; i < rout.size(); i++) {
				g.drawImage(rout.get(i).getImage(), getWidth()*1500/1920, y, getWidth()/10, getHeight()/10, null);
				y = y-getHeight()*200/1920;
			}
		}
		
			
}
		//Drawing player trains
		int blackX = (int)(getWidth()*0.00630);
		int blueX = blackX + (int)(getWidth()*0.08403);
		int greenX = blueX + (int)(getWidth()*0.08403);
		int orangeX = greenX + (int)(getWidth()*0.08403);
		int pinkX = orangeX + (int)(getWidth()*0.08403);
		int redX = pinkX + (int)(getWidth()*0.08403);
		int whiteX = redX + (int)(getWidth()*0.08403);
		int yellowX = whiteX + (int)(getWidth()*0.08403);
		int wildX = yellowX + (int)(getWidth()*0.08403);
		int blackStringX = (int)(getWidth()*0.03330);
		int blueStringX = blackStringX + (int)(getWidth()*0.08403);
		int greenStringX = blueStringX + (int)(getWidth()*0.08403);
		int orangeStringX = greenStringX + (int)(getWidth()*0.08403);
		int pinkStringX = orangeStringX + (int)(getWidth()*0.08403);
		int redStringX = pinkStringX + (int)(getWidth()*0.08403);
		int whiteStringX = redStringX + (int)(getWidth()*0.08403);
		int yellowStringX = whiteStringX + (int)(getWidth()*0.08403);
		int wildStringX = yellowStringX + (int)(getWidth()*0.08403);
		int ptrY = (int)(getHeight()*0.88377);
		int ptrStringY = (int)(getHeight()*0.94677);
		Font f = new Font("Fira Code", Font.PLAIN, 70);
		g.setFont(f);
		for(TrainColor color : p.getHand().keySet()) {
			ArrayList<TrainCard> trains = p.getHand().get(color);
			//System.out.println(trains);
			if(trains.size() != 0) {
				switch(color) {
					case TrainColor.Black:{
						g.drawImage(black, blackX, ptrY, (int)(getWidth()*0.07878), (int)(getHeight()*0.08646), null);
						g.setColor(Color.white);
						g.drawString("" + trains.size(), blackStringX, ptrStringY);
						break;
					}
					case TrainColor.Orange:{
						g.drawImage(orange, orangeX, ptrY, (int)(getWidth()*0.07878), (int)(getHeight()*0.08646), null);
						g.setColor(Color.black);
						g.drawString("" + trains.size(), orangeStringX, ptrStringY);
						break;
					}
					case TrainColor.Red:{
						g.drawImage(red, redX, ptrY, (int)(getWidth()*0.07878), (int)(getHeight()*0.08646), null);
						g.setColor(Color.black);
						g.drawString("" + trains.size(), redStringX, ptrStringY);
						break;
					}
					case TrainColor.Blue:{
						g.drawImage(blue, blueX, ptrY, (int)(getWidth()*0.07878), (int)(getHeight()*0.08646), null);
						g.setColor(Color.black);
						g.drawString("" + trains.size(), blueStringX, ptrStringY);
						break;
					}
					case TrainColor.Green:{
						g.drawImage(green, greenX, ptrY, (int)(getWidth()*0.07878), (int)(getHeight()*0.08646), null);
						g.setColor(Color.black);
						g.drawString("" + trains.size(), greenStringX, ptrStringY);
						break;
					}
					case TrainColor.White:{
						g.drawImage(white, whiteX, ptrY, (int)(getWidth()*0.07878), (int)(getHeight()*0.08646), null);
						g.setColor(Color.black);
						g.drawString("" + trains.size(), whiteStringX, ptrStringY);
						break;
					}
					case TrainColor.Yellow:{
						g.drawImage(yellow, yellowX, ptrY, (int)(getWidth()*0.07878), (int)(getHeight()*0.08646), null);
						g.setColor(Color.black);
						g.drawString("" + trains.size(), yellowStringX, ptrStringY);
						break;
					}
					case TrainColor.Pink:{
						g.drawImage(pink, pinkX, ptrY, (int)(getWidth()*0.07878), (int)(getHeight()*0.08646), null);
						g.setColor(Color.black);
						g.drawString("" + trains.size(), pinkStringX, ptrStringY);
						break;
					}
					case TrainColor.Wild:{
						g.drawImage(wild, wildX, ptrY, (int)(getWidth()*0.07878), (int)(getHeight()*0.08646), null);
						g.setColor(Color.black);
						g.drawString("" + trains.size(), wildStringX, ptrStringY);
						break;
					}
				}
			}
		}
		stationButton.setBounds(-100, -100, 0, 0);
		roadButton.setBounds(-100, 100, 0, 0);
		if(selectedCity.length() > 0 && cityButtons.get(selectedCity).getY() > 100 && clickedOnCity) {
			g.setColor(Color.yellow);
			JButton tempButton = cityButtons.get(selectedCity);
			int[] tempX = {tempButton.getX() + tempButton.getWidth(), tempButton.getX() + tempButton.getWidth() + 40, tempButton.getX() + tempButton.getWidth() + 40};
			int[] tempY = {tempButton.getY() + tempButton.getHeight()/2, tempButton.getY() + tempButton.getHeight()/2 - 80, tempButton.getY() + tempButton.getHeight()/2 + 80};
			g.fillPolygon(tempX, tempY, 3);
			g.setColor(Color.white);
			g.fillRect(tempButton.getX() + tempButton.getWidth() + 40, tempButton.getY() + tempButton.getHeight()/2 - 80, (int)(getWidth()*0.09606), (int)(getHeight()*0.15607));
			g.setColor(Color.black);
			g.setFont(new Font("Fira Code", Font.PLAIN, 20));
			stationButton.setBounds(tempButton.getX() + tempButton.getWidth() + 60, tempButton.getY() + tempButton.getHeight()/2 + 10, (int)(getWidth()*0.07353), (int)(getHeight()*0.02882));
			roadButton.setBounds(tempButton.getX() + tempButton.getWidth() + 60, tempButton.getY() + tempButton.getHeight()/2 - 50, (int)(getWidth()*0.07353), (int)(getHeight()*0.02882));
		}
		else if(selectedCity.length() > 0 && cityButtons.get(selectedCity).getY() < 100 && clickedOnCity) {
			g.setColor(Color.yellow);
			JButton tempButton = cityButtons.get(selectedCity);
			int[] tempX = {tempButton.getX() + tempButton.getWidth()/2, tempButton.getX() + tempButton.getWidth()/2 - 80, tempButton.getX() + tempButton.getWidth()/2 + 80};
			int[] tempY = {tempButton.getY() + tempButton.getHeight()/2, tempButton.getY() + tempButton.getHeight() + 40, tempButton.getY() + tempButton.getHeight() + 40};
			g.fillPolygon(tempX, tempY, 3);
			g.setColor(Color.white);
			g.fillRect(tempButton.getX() + tempButton.getWidth()/2 - 80, tempButton.getY() + tempButton.getHeight() + 40, (int)(getWidth()*0.08336), (int)(getHeight()*0.12007));
			g.setColor(Color.black);
			g.setFont(new Font("Fira Code", Font.PLAIN, 20));
			stationButton.setBounds(tempButton.getX() + tempButton.getWidth()/2 - 60, tempButton.getY() + tempButton.getHeight() + 110, (int)(getWidth()*0.06565), (int)(getHeight()*0.02882));
			roadButton.setBounds(tempButton.getX() + tempButton.getWidth()/2 - 60, tempButton.getY() + tempButton.getHeight() + 50, (int)(getWidth()*0.06565), (int)(getHeight()*0.02882));
		}
		g2.setTransform(initial);
		ArrayList<Player> players = game.getPlayers();
		for(Player player : players) {
			Color c = player.getColor();
			ArrayList<Road> roads = player.getRoads();
			for(Road r : roads) {
				double[] xs = r.getxs();
				double[] ys = r.getys();
				double[] as = r.getas();
				
				for(int i = 0; i < xs.length; i++) {
					AffineTransform old = g2.getTransform();
					g2.setColor(c);

					int x = (int) (xs[i]*getWidth());
					int yx = (int) (ys[i]*getHeight());
					double a = as[i];
					g2.rotate(a,x,yx);
					g2.fill3DRect(x, yx, 12, 50, true);
					g2.draw3DRect(x,yx,12,50,true);
					g2.draw3DRect(x+1,yx+1,12,43,true);
					g2.draw3DRect(x+2,yx+2,12,43,true);
					g2.draw3DRect(x+3,yx+3,12,43,true);
					g2.draw3DRect(x+4,yx+4,12,43,true);
					g2.draw3DRect(x+5,yx+5,12,43,true);
					g2.setTransform(old);
				}

			}

		}
	}
	@Override
	public void OnSwitchedTo() {
		// TODO Auto-generated method stub
		repaint();
	}
	public GameController getGame() {
		return game;
	}
	public HashMap<String, JButton> getCityButtons(){
		return cityButtons;
	}
	public void setPhase(ActionEvents state) {
		
	}
	public void setSelectedCity(String city) {
		selectedCity = city;
	}
	public boolean clickedOnCity() {
		return clickedOnCity;
	}
	public void changeClickedOnCity() {
		clickedOnCity = !clickedOnCity;
	}
	public String getSelectedCity() {
		return selectedCity;
	}
	public void setAdjacentCities(ArrayList<City> arr) {
		adjacentCities = arr;
	}
	public void setLatestCityClicked(String city) {
		latestCityClicked = city;
	}
	public String getLatestCityClicked() {
		return latestCityClicked;
	}
	public void changeClickedRoadOrStation() {
		clickedRoadOrStation = !clickedRoadOrStation;
	}
	public boolean getClickedRoadOrStation() {
		return clickedRoadOrStation;
	}
}

class ButtonListener implements ActionListener{
	private TTREGUI gui;
	public ButtonListener(TTREGUI gui) {
		super();
		this.gui = gui;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		GameController tempGame = gui.getGame();
		JButton button = (JButton) e.getSource();
		String source = button.getName();
		System.out.println("Source: " + source);
		HashMap<String, JButton> tempCityButtons = gui.getCityButtons();
		if(tempCityButtons.get(source) != null && gui.clickedOnCity() == false) {
			if(tempGame.getCurrentCitiesSize() == 0) {
				gui.setLatestCityClicked(source);
				gui.setSelectedCity(source);
				gui.changeClickedOnCity();
			}
			else {
				gui.setLatestCityClicked(source);
				gui.setSelectedCity(source);
				tempGame.giveCity(gui.getLatestCityClicked());
				tempGame.HandleAction(ActionEvents.purchaseRoad);
			}
		}
		else if(gui.clickedOnCity() == true && source.equals(gui.getSelectedCity())) {
			
			
			gui.setSelectedCity("");
			gui.changeClickedOnCity();
			
			
		}
		else if(gui.clickedOnCity() == true && source.equals("road")) {
			gui.changeClickedRoadOrStation();
			tempGame.giveCity(gui.getLatestCityClicked());
			tempGame.HandleAction(ActionEvents.purchaseRoad);
			gui.setAdjacentCities(tempGame.getEurope().getAvailableAdjacentCities(tempGame.getEurope().citySearch(gui.getSelectedCity())));
			gui.changeClickedOnCity();
			
			
		}
		else if(gui.clickedOnCity() == true && source.equals("station")) {
			gui.changeClickedRoadOrStation();
			tempGame.HandleAction(ActionEvents.placeStation);
			gui.changeClickedOnCity();
		}
		else if(tempGame.getGuiState() == GuiState.roadPurchasePanel && source.equals("playerBlack")) {
			if(tempGame.getCurrentPlayer().getHand().get(TrainColor.Black).size() > 0)
				tempGame.HandleAction(ActionEvents.addedTrainCard, TrainColor.Black);
		}
		else if(tempGame.getGuiState() == GuiState.roadPurchasePanel && source.equals("playerOrange")) {
			if(tempGame.getCurrentPlayer().getHand().get(TrainColor.Orange).size() > 0)
				tempGame.HandleAction(ActionEvents.addedTrainCard, TrainColor.Orange);
		}
		else if(tempGame.getGuiState() == GuiState.roadPurchasePanel && source.equals("playerRed")) {
			if(tempGame.getCurrentPlayer().getHand().get(TrainColor.Red).size() > 0)
				tempGame.HandleAction(ActionEvents.addedTrainCard, TrainColor.Red);
		}
		else if(tempGame.getGuiState() == GuiState.roadPurchasePanel && source.equals("playerBlue")) {
			if(tempGame.getCurrentPlayer().getHand().get(TrainColor.Blue).size() > 0)
				tempGame.HandleAction(ActionEvents.addedTrainCard, TrainColor.Blue);
		}
		else if(tempGame.getGuiState() == GuiState.roadPurchasePanel && source.equals("playerGreen")) {
			if(tempGame.getCurrentPlayer().getHand().get(TrainColor.Green).size() > 0)
				tempGame.HandleAction(ActionEvents.addedTrainCard, TrainColor.Green);
		}
		else if(tempGame.getGuiState() == GuiState.roadPurchasePanel && source.equals("playerWhite")) {
			if(tempGame.getCurrentPlayer().getHand().get(TrainColor.White).size() > 0)
				tempGame.HandleAction(ActionEvents.addedTrainCard, TrainColor.White);
		}
		else if(tempGame.getGuiState() == GuiState.roadPurchasePanel && source.equals("playerYellow")) {
			if(tempGame.getCurrentPlayer().getHand().get(TrainColor.Yellow).size() > 0)
				tempGame.HandleAction(ActionEvents.addedTrainCard, TrainColor.Yellow);
		}
		else if(tempGame.getGuiState() == GuiState.roadPurchasePanel && source.equals("playerPink")) {
			if(tempGame.getCurrentPlayer().getHand().get(TrainColor.Pink).size() > 0)
				tempGame.HandleAction(ActionEvents.addedTrainCard, TrainColor.Pink);
		}
		else if(tempGame.getGuiState() == GuiState.roadPurchasePanel && source.equals("playerWild")) {
			if(tempGame.getCurrentPlayer().getHand().get(TrainColor.Wild).size() > 0)
				tempGame.HandleAction(ActionEvents.addedTrainCard, TrainColor.Wild);
		}
		gui.repaint();
	}
	
}