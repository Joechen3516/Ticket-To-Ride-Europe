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
import java.util.Random;
import java.io.*;
public class CardScreen extends JPanel{
	private BufferedImage background; 
	
	private String message = "Player 1, choose which routes you want to remove";
	private JButton next;
	private String message1 = "Next";
	private int num = 0; 
	private BufferedImage[] routeImages;
	
	private void loadRouteImages() throws IOException {
	    routeImages = new BufferedImage[] {
	        ImageIO.read(StartPanel.class.getResource("/routes/Amsterdam-Pamplona7.jpg")),
	        ImageIO.read(StartPanel.class.getResource("/routes/Amsterdam-Wilno12.jpg")),
	        ImageIO.read(StartPanel.class.getResource("/routes/Ancora-Kharkov10.jpg")),
	        ImageIO.read(StartPanel.class.getResource("/routes/Athina-Ancora5.jpg")),
	        ImageIO.read(StartPanel.class.getResource("/routes/Athina-Wilno11.jpg")),
	        ImageIO.read(StartPanel.class.getResource("/routes/Barcelona-Bruxelles8.jpg")),
	        ImageIO.read(StartPanel.class.getResource("/routes/Barcelona-Munchen8.jpg")),
	        ImageIO.read(StartPanel.class.getResource("/routes/Berlin-Bucuresti8.jpg")),
	        ImageIO.read(StartPanel.class.getResource("/routes/Berlin-Moskva12.jpg")),
	        ImageIO.read(StartPanel.class.getResource("/routes/Berlin-Roma9.jpg")),
	        ImageIO.read(StartPanel.class.getResource("/routes/Brest-Marseille7.jpg")),
	        ImageIO.read(StartPanel.class.getResource("/routes/Brest-Petrocrad20.jpg")),
	        ImageIO.read(StartPanel.class.getResource("/routes/Brest-Venezia8.jpg")),
	        ImageIO.read(StartPanel.class.getResource("/routes/Bruxelles-Danzic9.jpg")),
	        ImageIO.read(StartPanel.class.getResource("/routes/Budapest-Sofia5.jpg")),
	        ImageIO.read(StartPanel.class.getResource("/routes/Cadiz-Stockholm21.jpg")),
	        ImageIO.read(StartPanel.class.getResource("/routes/Edinburch-Athina21.jpg")),
	        ImageIO.read(StartPanel.class.getResource("/routes/Edinburch-Paris7.jpg")),
	        ImageIO.read(StartPanel.class.getResource("/routes/Erzurm-Rostov5.jpg")),
	        ImageIO.read(StartPanel.class.getResource("/routes/Essen-Kyiv10.jpg")),
	        ImageIO.read(StartPanel.class.getResource("/routes/Frankfurt-Kobenhavn5.jpg")),
	        ImageIO.read(StartPanel.class.getResource("/routes/Frankkfurt-Smolense13.jpg")),
	        ImageIO.read(StartPanel.class.getResource("/routes/Kobenhavn-Erzurum21.jpg")),
	        ImageIO.read(StartPanel.class.getResource("/routes/Kyiv-Petrocrad6.jpg")),
	        ImageIO.read(StartPanel.class.getResource("/routes/Kyiv-Sochi8.jpg")),
	        ImageIO.read(StartPanel.class.getResource("/routes/Lisboa-Danzic20.jpg")),
	        ImageIO.read(StartPanel.class.getResource("/routes/London-Berlin7.jpg")),
	        ImageIO.read(StartPanel.class.getResource("/routes/London-Wien10.jpg")),
	        ImageIO.read(StartPanel.class.getResource("/routes/Madrid-Dieppe.jpg")),
	        ImageIO.read(StartPanel.class.getResource("/routes/Madrid-Zurich8.jpg")),
	        ImageIO.read(StartPanel.class.getResource("/routes/Marseille-Essen8.jpg")),
	        ImageIO.read(StartPanel.class.getResource("/routes/Palermo-Constantinople.jpg")),
	        ImageIO.read(StartPanel.class.getResource("/routes/Palermo-Moskva20.jpg")),
	        ImageIO.read(StartPanel.class.getResource("/routes/Paris-Wien8.jpg")),
	        ImageIO.read(StartPanel.class.getResource("/routes/Paris-Zacrad7.jpg")),
	        ImageIO.read(StartPanel.class.getResource("/routes/Rica-Bucuresti.jpg")),
	        ImageIO.read(StartPanel.class.getResource("/routes/Roma-Smyrna8.jpg")),
	        ImageIO.read(StartPanel.class.getResource("/routes/Sarajevo-Sevastopol.jpg")),
	        ImageIO.read(StartPanel.class.getResource("/routes/Smolensk-Rostov8.jpg")),
	        ImageIO.read(StartPanel.class.getResource("/routes/Sofia-Smyrna.jpg")),
	        ImageIO.read(StartPanel.class.getResource("/routes/Stockholm-Wien11.jpg")),
	        ImageIO.read(StartPanel.class.getResource("/routes/Venezia-Constantinople10.jpg")),
	        ImageIO.read(StartPanel.class.getResource("/routes/Warszawa-Smolensk6.jpg")),
	        ImageIO.read(StartPanel.class.getResource("/routes/Zacrab-Brindisi6.jpg")),
	        ImageIO.read(StartPanel.class.getResource("/routes/Zurich-Brindisi6.jpg")),
	        ImageIO.read(StartPanel.class.getResource("/routes/Zurich-Budapest6.jpg"))
	    };
	}
	
	public CardScreen(GameFrame frame){
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
	public BufferedImage[] removeImage(BufferedImage[] original, int indexToRemove) {
	    if (original == null || indexToRemove < 0 || indexToRemove >= original.length) {
	        return original;
	    }

	    BufferedImage[] newArray = new BufferedImage[original.length - 1];
	    System.arraycopy(original, 0, newArray, 0, indexToRemove);
	    System.arraycopy(original, indexToRemove + 1, newArray, indexToRemove, original.length - indexToRemove - 1);
	    return newArray;
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
		int one = ((int)(Math.random() * routeImages.length))-1;
		
		g.drawImage(routeImages[one], getWidth()/10, getHeight()/5, getWidth()/5, getHeight()/5, null);
		BufferedImage[] x1 = removeImage(routeImages, one);
		int two = ((int)(Math.random() * routeImages.length))-1;
		g.drawImage(x1[two], 7*getWidth()/20, getHeight()/5, getWidth()/5, getHeight()/5, null);
		BufferedImage[] x2=removeImage(routeImages, two);
		int three = ((int)(Math.random() * routeImages.length))-1;
		g.drawImage(x2[three], 6*getWidth()/10, getHeight()/5, getWidth()/5, getHeight()/5, null);
		BufferedImage[] x3=removeImage(routeImages, three);
		int four = ((int)(Math.random() * routeImages.length))-1;
		g.drawImage(x3[four], getWidth()/10, 3*getHeight()/5, getWidth()/5, getHeight()/5, null);
		BufferedImage[] x4 = removeImage(routeImages, four);
		int five = ((int)(Math.random() * routeImages.length))-1;
		g.drawImage(x4[(int)(Math.random() * routeImages.length)], 6*getWidth()/10, 3*getHeight()/5, getWidth()/5, getHeight()/5, null);
		BufferedImage[] x5 = removeImage(routeImages, five);
		//prevents duplicate cards
	}
}
