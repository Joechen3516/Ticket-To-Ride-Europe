import java.awt.*;
import javax.swing.*;
public class GameFrame extends JFrame{
	private final static int WIDTH = 1920;
	private final static int HEIGHT = 1080;
	private CardLayout cardLayout;
	private JPanel mainPanel;
	public GameFrame() {
		cardLayout = new CardLayout();
		mainPanel = new JPanel(cardLayout);
		StartPanel start = new StartPanel(this);
		TTREGUI gamePanel = new TTREGUI(this);
		mainPanel.add(start,"startpanel");
		mainPanel.add(gamePanel,"TickettoRide");
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.setSize(WIDTH,HEIGHT);
		this.add(mainPanel);
		this.setVisible(true);
	}
	public static void main(String[]args) {
		new GameFrame();
	}
	public void switchPanel(String panelName) {
		cardLayout.show(mainPanel,panelName);
	}
}
