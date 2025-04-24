import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class CardScreen extends JPanel implements SwitchablePanel{
	private BufferedImage background; 


	private int turn;
	private JButton next;
	private GameController game;
	private ArrayList<RouteCard> drawnRoutes;
	
	private BufferedImage gameImage; 


	private JButton c0, c1,c2,c3,c4;

	private boolean c0click = false; 
	private boolean c1click = false; 
	private boolean c2click = false; 
	private boolean c3click = false; 
	private boolean c4click = false; 
	
	
	private ArrayList<RouteCard> selected = new ArrayList<RouteCard>();

	private void loadRouteImages() throws IOException {

	}

	public CardScreen(GameController controller){
		this.setLayout(null);
		game = controller;

		next = new JButton();

		next.setOpaque(false);
		next.setContentAreaFilled(false);
		next.setBorderPainted(false);
		add(next);

		c0 = new JButton();
		c1 = new JButton();
		c2 = new JButton();
		c3 = new JButton();
		c4 = new JButton();



		c0.setOpaque(false);
		c0.setContentAreaFilled(false);
		c0.setBorderPainted(false);
		add(c0);
		c1.setOpaque(false);
		c1.setContentAreaFilled(false);
		c1.setBorderPainted(false);
		add(c1);
		c2.setOpaque(false);
		c2.setContentAreaFilled(false);
		c2.setBorderPainted(false);
		add(c2);
		c3.setOpaque(false);
		c3.setContentAreaFilled(false);
		c3.setBorderPainted(false);
		add(c3);
		c4.setOpaque(false);
		c4.setContentAreaFilled(false);
		c4.setBorderPainted(false);
		add(c4);


		try {

			background = ImageIO.read(StartPanel.class.getResource("/images/midpanel1-ezgif.com-webp-to-png-converter.png"));
			gameImage =  ImageIO.read(StartPanel.class.getResource("/images/gameboard.PNG"));


		} catch (Exception e) {
			System.out.println("StartPanel error: " + e.getMessage());
		}
		next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == next && selected.size() > 1 && drawnRoutes.size() == 5) {
					for(RouteCard r: selected) {
						System.out.print(r.toString() + "::");
					}
					game.addPlayerRoutes(selected);
					while(selected.size() > 0) {
						selected.remove(0);
					}
					game.HandleAction(ActionEvents.CardScreenConfirm);	
					c0click = false;
					c1click = false;
					c2click = false; 
					c3click = false; 
					c4click = false; 
					repaint();
				}
				if (e.getSource() == next && selected.size() > 0 && drawnRoutes.size() == 3) {
					for(RouteCard r: selected) {
						System.out.print(r.toString() + "::");
					}
					game.addPlayerRoutes(selected);
					while(selected.size() > 0) {
						selected.remove(0);
					}
					game.HandleAction(ActionEvents.CardScreenConfirm);	
					c0click = false;
					c1click = false;
					c2click = false; 
					c3click = false; 
					c4click = false;
					game.nextTurn();
					repaint();
				}
			}
		});

		c0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				

				if (e.getSource() == c0 && c0click == false) {
					selected.add(drawnRoutes.get(0));
					
				}
				if (e.getSource() == c0 && c0click == true) {
					selected.remove(drawnRoutes.get(0));
					
				}
				if (c0click == false) {
					c0click = true;
				} else {
					c0click = false;
				}
				
				repaint();
			}
		});

		c1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				if (e.getSource() == c1 && c1click == false) {
					selected.add(drawnRoutes.get(1));
					
				}
				if (e.getSource() == c1 && c1click == true) {
					selected.remove(drawnRoutes.get(1));
					
				}
				
				if (c1click == false) {
					c1click = true;
				} else {
					c1click = false;
				}
				
				
				repaint();
			}
		});

		c2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				if (e.getSource() == c2 && c2click == false) {
					selected.add(drawnRoutes.get(2));
					
				}
				if (e.getSource() == c2 && c2click == true) {
					selected.remove(drawnRoutes.get(2));
					
				}
				if (c2click == false) {
					c2click = true;
				} else {
					c2click = false;
				}
				
				repaint();
			}
		});

		c3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (e.getSource() == c3 && c3click == false) {
					if(drawnRoutes.size() > 3) {
						selected.add(drawnRoutes.get(3));
						
					}
				}
				if (e.getSource() == c3 && c3click == true) {
					selected.remove(drawnRoutes.get(3));
					
				}
				if (c3click == false) {
					c3click = true;
				} else {
					c3click = false;
				}
				
				repaint();
			}
		});

		c4.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				if (e.getSource() == c4 && c4click == false ) {
					if(drawnRoutes.size() > 3) {
						selected.add(drawnRoutes.get(4));
						
					}
				}
				if (e.getSource() == c4 && c4click == true) {
					selected.remove(drawnRoutes.get(4));
					
				}
				
				
				if (c4click == false) {
					c4click = true;
				} else {
					c4click = false;
				}
				
				
				repaint();
			}
		});
		this.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {

				int btnX = (int) (getWidth() * 0.80279);
				int btnY = (int) (getHeight() * 0.78663);
				int btnWidth = (int) (getWidth() * 0.86341);
				int btnHeight = (int) (getHeight() * 0.79105);
				next.setBounds(btnX, btnY, btnWidth, btnHeight);




				int c0X = (int)(getWidth() * 0.05208333333);
				int c0Y = (int)(getHeight() * 0.28);
				int c0Width = (int)(getWidth() * 0.17);
				int c0Height = (int)(getHeight() * 0.172);

				c0.setBounds(c0X, c0Y, c0Width, c0Height);

				int c1X = (int)(getWidth() * 0.05208333333)+(int)(getWidth()*0.18382);


				c1.setBounds(c1X, c0Y, c0Width, c0Height);

				int c2X = (int)(getWidth() * 0.05208333333)+(int)(getWidth()*0.18382)+(int)(getWidth()*0.18382);


				c2.setBounds(c2X, c0Y, c0Width, c0Height);
				int c3X = (int)(getWidth() * 0.05208333333)+(int)(getWidth()*0.18382)+(int)(getWidth()*0.18382)+(int)(getWidth()*0.18382);


				c3.setBounds(c3X, c0Y, c0Width, c0Height);

				int c4X = (int)(getWidth() * 0.05208333333)+(int)(getWidth()*0.18382)+(int)(getWidth()*0.18382)+(int)(getWidth()*0.18382)+(int)(getWidth()*0.18382);


				c4.setBounds(c4X, c0Y, c0Width, c0Height);














			}
		});
	}


	public void paintComponent(Graphics g) {
		try {
			loadRouteImages();
		} catch (IOException e) {

			e.printStackTrace();
		}
		String update; 
		String message; 
		int minselection;
		if( drawnRoutes.size() == 3) {
			message = "Player " + (turn) + ", choose which routes you want to keep";
			if (selected.size() < 1) {
				
				update = "You must keep at least " + (-(selected.size()-1)) +" more";
				
			} else {
				
				
				update = "You have selected the mininum amount of routes";
				
			}
			minselection = 1; 
		} else {
			message = "Player " + (turn+1) + ", choose which routes you want to keep";
			if (selected.size() < 2) {
				
				update = "You must keep at least " + (-(selected.size()-2)) +" more";
				
			} else {
				
				
				update = "You have selected the mininum amount of routes";
				
			}
			minselection = 2; 
			
		}
		String minMessage = "Click to select, click again to unselect";
		
		
		g.setColor(Color.YELLOW);
		g.setFont(new Font("TimesRoman", Font.BOLD, 75)); 
		g.drawImage(background, 0, 0, getWidth(), getHeight(), null);
		
		
		g.drawImage(gameImage, (int)(getWidth()*300/1920), (int)(getHeight()*875/1920), getWidth()/2, getHeight()/2, null);
		
		g.drawString(message, (int)(getWidth()*0.00525), (int)(getHeight()*0.09606));
		g.drawString(minMessage, (int)(getWidth()*0.00525), (int)(getHeight()*0.16811));
		
		if (selected.size() < minselection ) {
			g.setColor(Color.RED);
			
		} else {
			g.setColor(Color.GREEN);
		}
		g.drawString(update, (int)(getWidth()*0.00525), (int)(getHeight()*0.24811));
		g.setColor(Color.YELLOW);
		g.drawString("Confirm", (int)(getWidth() * 0.83), (int)(getHeight()*0.85));


		
		if (drawnRoutes.size() == 3) {
			int xcoords = (int)(getWidth()*0.05252);
			for(int i = 0; i < 3; i++) {
				g.drawImage(drawnRoutes.get(i).getImage(), xcoords, (int)(getHeight()*0.28031), getWidth()/6, getHeight()/6, null);
				xcoords = xcoords + (int)(getWidth()*0.18382); 
			}



		} else {
			int xcoords = (int)(getWidth()*0.05252);
			for(int i = 0; i < 5; i++) {
				g.drawImage(drawnRoutes.get(i).getImage(), xcoords, (int)(getHeight()*0.28031), getWidth()/6, getHeight()/6, null);
				xcoords = xcoords + (int)(getWidth()*0.18382); 
			}
		}
		Graphics2D g2 = (Graphics2D) g;
		if(c0click) {
			g2.setColor(Color.RED);
			g2.setStroke(new BasicStroke(10));
			g2.drawRect((int)(getWidth() * 0.05208333333), (int)(getHeight() * 0.28),(int)(getWidth() * 0.17),(int)(getHeight() * 0.172));
			g2.setColor(Color.YELLOW);
		}
		if(c1click) {
			g2.setColor(Color.RED);
			g2.setStroke(new BasicStroke(10));
			g2.drawRect((int)(getWidth() * 0.05208333333)+(int)(getWidth()*0.18382), (int)(getHeight() * 0.28),(int)(getWidth() * 0.17),(int)(getHeight() * 0.172));
			g2.setColor(Color.YELLOW);
		}
		if(c2click) {
			g2.setColor(Color.RED);
			g2.setStroke(new BasicStroke(10));
			g2.drawRect((int)(getWidth() * 0.05208333333)+(int)(getWidth()*0.18382)+(int)(getWidth()*0.18382), (int)(getHeight() * 0.28),(int)(getWidth() * 0.17),(int)(getHeight() * 0.172));
			g2.setColor(Color.YELLOW);
		}
		if(c3click) {
			g2.setColor(Color.RED);
			g2.setStroke(new BasicStroke(10));
			g2.drawRect((int)(getWidth() * 0.05208333333)+(int)(getWidth()*0.18382)+(int)(getWidth()*0.18382)+(int)(getWidth()*0.18382), (int)(getHeight() * 0.28),(int)(getWidth() * 0.17),(int)(getHeight() * 0.172));
			g2.setColor(Color.YELLOW);
		}
		if(c4click) {
			g2.setColor(Color.RED);
			g2.setStroke(new BasicStroke(10));
			g2.drawRect((int)(getWidth() * 0.05208333333)+(int)(getWidth()*0.18382)+(int)(getWidth()*0.18382)+(int)(getWidth()*0.18382)+(int)(getWidth()*0.18382), (int)(getHeight() * 0.28),(int)(getWidth() * 0.17),(int)(getHeight() * 0.172));
			g2.setColor(Color.YELLOW);
		}
		
		
		
		
		
		
		







	}

	public void OnSwitchedTo() {
		this.drawnRoutes = game.getDrawnRoutes();
		this.turn = game.getCurrentPlayerNumber();
		


	}
	
	



}