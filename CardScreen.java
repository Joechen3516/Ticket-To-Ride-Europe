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
public class CardScreen extends JPanel{
	private BufferedImage background; 
	
	private String message = "Player 1, choose which routes you want to remove";
	private JButton next;
	private String message1 = "Next";
	private int num = 0; 
	private GameController game;
	
	private void loadRouteImages() throws IOException {
	    
	}
	
	public CardScreen(GameController controller){
		this.setLayout(null);
		game = controller;
		
		next = new JButton();
        add(next);
        next.setOpaque(false);
        next.setContentAreaFilled(false);
        next.setBorderPainted(true);
		try {
			
            background = ImageIO.read(StartPanel.class.getResource("/images/midpanel1-ezgif.com-webp-to-png-converter.png"));
            
        
            
        } catch (Exception e) {
            System.out.println("StartPanel error: " + e.getMessage());
        }
		next.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == next) {
                	System.out.println("clicked");
                	num++;
                 	if (num ==1 ) {
                 		message = "Player 2, choose which routes you want to remove";
                 	} else if (num == 2) {
                 		message = "Player 3, choose which routes you want to remove";
                 	}else if (num == 3){
                 		message = "Player 4, choose which routes you want to remove";
                 	} else if(num == 4) {
                 		
                 	}
                 	repaint();
                      // Ensure this matches GameFrame
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("success");
		g.setColor(Color.YELLOW);
		g.setFont(new Font("TimesRoman", Font.BOLD, 75)); 
		g.drawImage(background, 0, 0, getWidth(), getHeight(), null);
		g.drawString(message, 10, 100);
		g.drawString("You must keep at least 2 cards", 10, 175);
		g.drawString(message1, (int)(getWidth() * 0.86), (int)(getHeight()*0.85));
		
		
		ArrayList<RouteCard> drawnRoutes = game.getDrawnRoutes();
		if (drawnRoutes.size() == 3) {
			int xcoords = 200;
			for(int i = 0; i < 3; i++) {
				g.drawImage(drawnRoutes.get(i).getImage(), xcoords, 500, getWidth()/3, getHeight()/3, null);
				xcoords = xcoords +50; 
			}
		} else {
			int xcoords = 100;
			for(int i = 0; i < 5; i++) {
				g.drawImage(drawnRoutes.get(i).getImage(), xcoords, 500, getWidth()/3, getHeight()/3, null);
				xcoords = xcoords +50; 
			}
			
		}
		
		
		
		
		
		
		
	}
}