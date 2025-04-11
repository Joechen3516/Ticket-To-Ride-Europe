import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
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


	private int turn = 0;
	private JButton next;
	private GameController game;
	private ArrayList<RouteCard> drawnRoutes;
	private int minSelection = 2;
	

	private JButton c0, c1,c2,c3,c4;
	
	private boolean c0click, c1click, c2click, c3click, c4click; 
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
		c0.setBorderPainted(true);
		add(c0);
		c1.setOpaque(false);
		c1.setContentAreaFilled(false);
		c1.setBorderPainted(true);
		add(c1);
		c2.setOpaque(false);
		c2.setContentAreaFilled(false);
		c2.setBorderPainted(true);
		add(c2);
		c3.setOpaque(false);
		c3.setContentAreaFilled(false);
		c3.setBorderPainted(true);
		add(c3);
		c4.setOpaque(false);
		c4.setContentAreaFilled(false);
		c4.setBorderPainted(true);
		add(c4);


		try {

			background = ImageIO.read(StartPanel.class.getResource("/images/midpanel1-ezgif.com-webp-to-png-converter.png"));



		} catch (Exception e) {
			System.out.println("StartPanel error: " + e.getMessage());
		}
		next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == next) {
					for(RouteCard r: selected) {
						System.out.print(r + "::");
					}
					game.addPlayerRoutes(selected);
					game.HandleAction(ActionEvents.CardScreenConfirm);	
					repaint();
				}
			}
		});

		c0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (c0click == false) {
					c0click = true;
				} else {
					c0click = false;
				}
				
				
				if (e.getSource() == c0 && selected.size() < minSelection ) {
					selected.add(drawnRoutes.get(0));
					System.out.print("drawnRoutes.get(0)");
				}
			}
		});

		c1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == c1 && selected.size() < minSelection) {
					selected.add(drawnRoutes.get(1));
				}
			}
		});

		c2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == c2 && selected.size() < minSelection) {
					selected.add(drawnRoutes.get(2));
				}
			}
		});

		c3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == c3 && selected.size() < minSelection) {
					if(drawnRoutes.size() > 3) {
						selected.add(drawnRoutes.get(3));
					}
				}
			}
		});

		c4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == c4 && selected.size() < minSelection) {
					if(drawnRoutes.size() > 3) {
						selected.add(drawnRoutes.get(4));
					}
				}
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
				int c0Y = (int)(getHeight() * 0.48);
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

		String message = "Player " + (turn+1) + ", choose which routes you want to remove";
		String minMessage = "You must keep at least " + minSelection;
		g.setColor(Color.YELLOW);
		g.setFont(new Font("TimesRoman", Font.BOLD, 75)); 
		g.drawImage(background, 0, 0, getWidth(), getHeight(), null);
		g.drawString(message, (int)(getWidth()*0.00525), (int)(getHeight()*0.09606));
		g.drawString(minMessage, (int)(getWidth()*0.00525), (int)(getHeight()*0.16811));
		g.drawString("Confirm", (int)(getWidth() * 0.83), (int)(getHeight()*0.85));


		System.out.println(getWidth() + " " + getHeight());
		if (drawnRoutes.size() == 3) {
			int xcoords = (int)(getWidth()*0.10504);
			for(int i = 0; i < 3; i++) {
				g.drawImage(drawnRoutes.get(i).getImage(), xcoords, (int)(getHeight()*0.48031), getWidth()/6, getHeight()/6, null);
				xcoords = xcoords + (int)(getWidth()*0.18382); 
			}



		} else {
			int xcoords = (int)(getWidth()*0.05252);
			for(int i = 0; i < 5; i++) {
				g.drawImage(drawnRoutes.get(i).getImage(), xcoords, (int)(getHeight()*0.48031), getWidth()/6, getHeight()/6, null);
				xcoords = xcoords + (int)(getWidth()*0.18382); 
			}
		}
		int c0X = (int)(getWidth() * 0.05208333333);
		int c0Y = (int)(getHeight() * 0.48);
		int c0Width = (int)(getWidth() * 0.17);
		int c0Height = (int)(getHeight() * 0.172);
		if(c0click) {
			g.setColor(Color.RED);
			
			g.drawRect(c0X, c0Y, c0Width, c0Height);
		}







	}

	public void OnSwitchedTo() {
		this.drawnRoutes = game.getDrawnRoutes();
		this.turn = game.getCurrentPlayerNumber();
		this.minSelection = game.getMinSelection();


	}



}
