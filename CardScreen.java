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
public class CardScreen extends JPanel{
	private BufferedImage background; 
	private String message = "Player 1, choose which routes you want to remove";
	private JButton next;
	private String message1 = "Next";
	
	public CardScreen(GameFrame frame) {
		this.setLayout(null);
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
                		frame.switchPanel("TickettoRide");
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
		System.out.println("success");
		g.setColor(Color.YELLOW);
		g.setFont(new Font("TimesRoman", Font.BOLD, 75)); 
		g.drawImage(background, 0, 0, getWidth(), getHeight(), null);
		g.drawString(message, 10, 100);
		g.drawString(message1, (int)(getWidth() * 0.86), (int)(getHeight()*0.85));
		
	}
}
