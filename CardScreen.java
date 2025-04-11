import java.awt.Color;
import java.awt.Event;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
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
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;
import java.io.*;
@SuppressWarnings("serial")
public class CardScreen extends JPanel implements SwitchablePanel{
	private BufferedImage background; 


	private int turn = 0;
	private JButton next;
	private GameController game;
	private ArrayList<RouteCard> drawnRoutes;
	private int minSelection = 2;


	private JButton c0;
	private JButton c1;
	private JButton c2;
	private JButton c3;
	private JButton c4;

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

		c0.setBounds(100, 500, 315, 175);
		c1.setBounds(550, 500, 315, 175);
		c2.setBounds(900, 500, 315, 175);
		c3.setBounds(1250, 500, 315, 175);
		c4.setBounds(1600, 500, 315, 175);

		c0.setOpaque(true);
		c0.setContentAreaFilled(true);
		c0.setBorderPainted(true);
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
				int w = getWidth();
				int h = getHeight();
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
				
				int c1X = (int)(getWidth() * 0.05208333333);
				int c1Y = (int)(getHeight() * 0.48);
				int c1Width = (int)(getWidth() * 0.17);
				int c1Height = (int)(getHeight() * 0.172);
				
				c1.setBounds(c1X, c1Y, c1Width, c1Height);
				
				//c1.setBounds(w * (550/1920), h * (500/1920), w * (100/1920), w * (100/1920));
				//c2.setBounds(w * (900/1920), h * (500/1920), w * (100/1920), w * (100/1920));
				//c3.setBounds(w * (1250/1920), h * (500/1920), w * (100/1920), w * (100/1920));
				//c4.setBounds(w * (1600/1920), h * (500/1920), w * (100/1920), w * (100/1920));
				
				
				
				
				
				
				
				
				
				
				
				
				
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
		g.drawString(message, 10, 100);
		g.drawString(minMessage, 10, 175);
		g.drawString("Confirm", (int)(getWidth() * 0.83), (int)(getHeight()*0.85));



		if (drawnRoutes.size() == 3) {
			int xcoords = 200;
			for(int i = 0; i < 3; i++) {
				g.drawImage(drawnRoutes.get(i).getImage(), xcoords, 500, getWidth()/6, getHeight()/6, null);
				xcoords = xcoords +(350/1920); 
			}



		} else {
			int xcoords = 100;
			for(int i = 0; i < 5; i++) {
				g.drawImage(drawnRoutes.get(i).getImage(), xcoords, 500, getWidth()/6, getHeight()/6, null);
				xcoords = xcoords +350; 
			}
		}







	}

	public void OnSwitchedTo() {
		this.drawnRoutes = game.getDrawnRoutes();
		this.turn = game.getCurrentPlayerNumber();
		this.minSelection = game.getMinSelection();


	}



}
