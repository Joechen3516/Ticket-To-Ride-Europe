import java.awt.*;
import java.util.List;

import javax.swing.*;
public class GameFrame extends JFrame implements GameListener{
	private final static int WIDTH = 1920;
	private final static int HEIGHT = 1080;
	private CardLayout cardLayout;
	private JPanel mainPanel;
	private GameController controller;
	public GameFrame(GameController controller) {
		this.controller = controller;
		
		setTitle("Ticket To Ride Europe");
		this.setSize(WIDTH,HEIGHT);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		
		cardLayout = new CardLayout();
		mainPanel = new JPanel(cardLayout);
		
		StartPanel start = new StartPanel(controller);
		TTREGUI gamePanel = new TTREGUI(this);
		CardScreen chooseRoutes = new CardScreen(controller);
		controller.addPanelSwitch("Destination", chooseRoutes);
		mainPanel.add(start,"Start");
		mainPanel.add(gamePanel,"Game");
		mainPanel.add(chooseRoutes,"Destination");
		
		
		this.add(mainPanel);
		this.setVisible(true);
		
		controller.addListener(this);
	}

	public void switchPanel(String panelName) {
		cardLayout.show(mainPanel,panelName);
	}
	@Override
	public void onScreenChange(String newScreen) {
		cardLayout.show(mainPanel,newScreen);
		if(newScreen == "Destination") {
			this.switchPanel(newScreen);
		}else if(newScreen == "Game") {
			
		}else if(newScreen == "Start") {
			
		}
		
	}

}
