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
		try {
			
            background = ImageIO.read(StartPanel.class.getResource("/images/midpanel1-ezgif.com-webp-to-png-converter.png"));
            
        
            
        } catch (Exception e) {
            System.out.println("StartPanel error: " + e.getMessage());
        }
		next.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == next) {
                	game.HandleAction(ActionEvents.CardScreenConfirm);
                 	repaint();
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
		System.out.println("success");
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
				xcoords = xcoords +350; 
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