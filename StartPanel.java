import java.awt.Event;
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

public class StartPanel extends JPanel{
	private BufferedImage startbg,play;
	private JButton button;
	public StartPanel(GameFrame frame) {
		this.setLayout(null);
		button = new JButton();
		button.setBounds(798,418,342,206);
		add(button);
		button.setOpaque(false);
		button.setContentAreaFilled(false);
		button.setBorderPainted(false);
		try {
			startbg = ImageIO.read(StartPanel.class.getResource("/images/startbg.png"));
			play = ImageIO.read(StartPanel.class.getResource("/images/play.png"));
		}
		catch(Exception e) {
			System.out.println("StartPanel error");
		}
		button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == button) {
					System.out.println("worked");
					frame.switchPanel("TTREGUI");
				}
			}
		});
	}
	public void paint(Graphics g) {
		g.drawImage(startbg, 0, 0, getWidth(), getHeight(), null);
		g.drawImage(play,798,418,342,206,null);
	}
}
