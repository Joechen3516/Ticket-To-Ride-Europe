import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.*;
import javax.imageio.ImageIO;

public class CardScreen extends JPanel {
    private BufferedImage background, gamebg;
    private String message;
    private static final int MIN_SELECTIONS = 2; 
    private JButton next;
    private List<RouteCard> displayedRoutes;
    private Europe europe;
    private GameFrame frame;
    private static final int ROUTE_CARD_WIDTH = 200;
    private static final int ROUTE_CARD_HEIGHT = 120;
    private static final int REGULAR_CARDS = 4;
    private static final int LONG_CARDS = 1;
    private List<RouteCard> allRegularRoutes;
    private List<RouteCard> allLongRoutes;
    
    
    private static final int CARD_SPACING = 20; // Vertical space between cards
    private static final int CARD_RIGHT_MARGIN = 50; // Space from right edge
    private static final int CARD_TOP_MARGIN = 50; // Space from top
    private static final int LONG_ROUTE_OFFSET = 30;
    
    private Set<Integer> selectedCardIndices = new LinkedHashSet<>();
    
    
    private PlayerColor[] playerOrder = PlayerColor.values();
    private int currentPlayerIndex = 0;
    private Map<PlayerColor, List<RouteCard>> playerRoutes = new HashMap<>();
    public CardScreen(GameFrame frame) {
        this.frame = frame;
        this.setLayout(null);
        this.europe = new Europe();
        europe.initializeCities();
        
        for (PlayerColor color : playerOrder) {
            playerRoutes.put(color, new ArrayList<>());
        }
        // Initialize message for first player
        message = playerOrder[currentPlayerIndex] + " player, choose which routes you want to keep";
        
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                handleCardClick(e.getX(), e.getY());
            }
        });

        try {
            europe.createDefaultRoutes();
            allRegularRoutes = new ArrayList<>();
            allLongRoutes = new ArrayList<>();
            for (RouteCard route : europe.getRoutes()) {
                if (route.isLong()) {
                    allLongRoutes.add(route);
                } else {
                    allRegularRoutes.add(route);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            background = ImageIO.read(getClass().getResource("/images/midpanel1-ezgif.com-webp-to-png-converter-min.png"));
            gamebg = ImageIO.read(getClass().getResource("/images/gameboard.PNG"));
        } catch (Exception e) {
            System.out.println("CardScreen error: " + e.getMessage());
            background = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
        }

        selectNewRoutes();

        next = new JButton("NEXT") {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                
                // Draw border in current player's color
                g2.setColor(Color.YELLOW); 
                g2.setStroke(new BasicStroke(4));
                g2.drawRoundRect(2, 2, getWidth()-5, getHeight()-5, 20, 20);
                
                g2.setStroke(new BasicStroke(2));
                g2.drawRoundRect(4, 4, getWidth()-9, getHeight()-9, 15, 15);
                
                g2.setColor(new Color(0, 0, 0, 150));
                g2.fillRoundRect(4, 4, getWidth()-8, getHeight()-8, 15, 15);
                
                g2.setColor(Color.YELLOW);
                g2.setFont(new Font("Arial", Font.BOLD, 28));
                FontMetrics fm = g2.getFontMetrics();
                int textX = (getWidth() - fm.stringWidth(getText())) / 2;
                int textY = (getHeight() - fm.getHeight()) / 2 + fm.getAscent();
                g2.drawString(getText(), textX, textY);
                
                g2.dispose();
            }
        };
        
        next.setContentAreaFilled(false);
        next.setBorderPainted(false);
        next.setFocusPainted(false);
        add(next);

        next.addActionListener(e -> {
        	if (selectedCardIndices.size() < MIN_SELECTIONS) {
                JOptionPane.showMessageDialog(this, 
                    "You must select at least " + MIN_SELECTIONS + " routes to proceed",
                    "Selection Required",
                    JOptionPane.WARNING_MESSAGE);
                return;
            }
        	
        	
        	// Add selected routes to current player
            PlayerColor currentPlayer = playerOrder[currentPlayerIndex];
            for (int index : selectedCardIndices) {
                RouteCard selectedRoute = displayedRoutes.get(index);
                playerRoutes.get(currentPlayer).add(selectedRoute);
                
                // Print to console
                System.out.println(currentPlayer + " player selected route: " + 
                    selectedRoute.getCityA() + " to " + selectedRoute.getCityB());
            }
            
            currentPlayerIndex++;
            if (currentPlayerIndex < playerOrder.length) {
                message = playerOrder[currentPlayerIndex] + " player, choose which routes you want to keep";
                selectNewRoutes();
                selectedCardIndices.clear();
            } else {
                // Print all player route assignments before switching panels
                printAllPlayerRoutes();
                frame.switchPanel("TickettoRide");
                return;
            }
            repaint();
        });

        this.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                positionElements();
            }
        });
        
        
    }
    
    
    private void printAllPlayerRoutes() {
        System.out.println("\nFinal Route Assignments:");
        for (PlayerColor color : playerOrder) {
            System.out.println(color + " Player's Routes:");
            for (RouteCard route : playerRoutes.get(color)) {
                System.out.println("  - " + route.getCityA() + " to " + route.getCityB() + 
                                 " (" + route.getPoints() + " points)");
            }
        }
    }
    private Color getCurrentPlayerColor() {
        switch(playerOrder[currentPlayerIndex]) {
            case Yellow: return Color.YELLOW;
            case Green: return Color.GREEN;
            case Blue: return Color.BLUE;
            case Red: return Color.RED;
            default: return Color.YELLOW;
        }
    }
    private void handleCardClick(int clickX, int clickY) {
        if (displayedRoutes == null || displayedRoutes.isEmpty()) return;
        
        // Calculate positions from top right
        int regularCardX = getWidth() - ROUTE_CARD_WIDTH - CARD_RIGHT_MARGIN;
        int longRouteX = regularCardX - ROUTE_CARD_WIDTH - LONG_ROUTE_OFFSET;
        
        // Check which card was clicked
        for (int i = 0; i < displayedRoutes.size(); i++) {
            RouteCard card = displayedRoutes.get(i);
            int baseCardY = CARD_TOP_MARGIN + (i * (ROUTE_CARD_HEIGHT + CARD_SPACING));
            int cardY = card.isLong() ? baseCardY - 150 : baseCardY; // Apply same offset
            int cardX = card.isLong() ? longRouteX : regularCardX;
            
            if (clickX >= cardX && clickX <= cardX + ROUTE_CARD_WIDTH &&
                clickY >= cardY && clickY <= cardY + ROUTE_CARD_HEIGHT) {
                toggleCardSelection(i);
                repaint();
                break;
            }
        }
    }
    private void toggleCardSelection(int index) {
        if (selectedCardIndices.contains(index)) {
            selectedCardIndices.remove(index);
        } else {
            selectedCardIndices.add(index);
        }
        // Update button state after selection change
        next.setEnabled(selectedCardIndices.size() >= MIN_SELECTIONS);
        repaint();
    }

    private void selectNewRoutes() {
        displayedRoutes = new ArrayList<>();
        
        // Select 4 regular routes
        Collections.shuffle(allRegularRoutes);
        int regularToSelect = Math.min(REGULAR_CARDS, allRegularRoutes.size());
        displayedRoutes.addAll(allRegularRoutes.subList(0, regularToSelect));
        allRegularRoutes.removeAll(displayedRoutes);
        
        // Select 1 long route (always place on far right)
        if (!allLongRoutes.isEmpty()) {
            Collections.shuffle(allLongRoutes);
            RouteCard longRoute = allLongRoutes.remove(0);
            displayedRoutes.add(longRoute); // Will be drawn last (far right)
        } else {
            // Fallback if no long routes left
            if (!allRegularRoutes.isEmpty()) {
                Collections.shuffle(allRegularRoutes);
                displayedRoutes.add(allRegularRoutes.remove(0));
            }
        }
    }

    private void positionElements() {
        // Position NEXT button slightly higher (reduced the +20 to +10)
        int btnX = getWidth() - (int)(getWidth() * 0.15) - CARD_RIGHT_MARGIN;
        int btnY = CARD_TOP_MARGIN + (displayedRoutes.size() * (ROUTE_CARD_HEIGHT + CARD_SPACING))-100; // Changed from +20 to +10
        int btnWidth = (int)(getWidth() * 0.15);
        int btnHeight = (int)(getHeight() * 0.1);
        next.setBounds(btnX, btnY, btnWidth, btnHeight);
        
        next.setEnabled(selectedCardIndices.size() >= MIN_SELECTIONS);
    }
    

    @Override
    protected void paintComponent(Graphics g) {
    	super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        g.drawImage(background, 0, 0, getWidth(), getHeight(), null);
        g.drawImage(gamebg, 0, 200, 2*getWidth()/3, 2*getHeight()/3, null);
        // Draw instruction text
        g.setColor(Color.YELLOW);
        g.setFont(new Font("TimesRoman", Font.BOLD, 40)); 
        g.drawString(message, 50, 80);
        
        if (displayedRoutes != null && !displayedRoutes.isEmpty()) {
            int regularCardX = getWidth() - ROUTE_CARD_WIDTH - CARD_RIGHT_MARGIN;
            int longRouteX = regularCardX - ROUTE_CARD_WIDTH - LONG_ROUTE_OFFSET;
            
            // Draw regular cards first (vertical stack)
            for (int i = 0; i < displayedRoutes.size(); i++) {
                RouteCard card = displayedRoutes.get(i);
                if (card.isLong()) continue; // Skip long route for now
                
                int cardY = CARD_TOP_MARGIN + (i * (ROUTE_CARD_HEIGHT + CARD_SPACING));
                drawRouteCard(g, card, regularCardX, cardY);
                
                if (selectedCardIndices.contains(i)) {
                    g2.setColor(Color.RED);
                    g2.setStroke(new BasicStroke(6));
                    g2.drawRect(regularCardX - 5, cardY - 5, 
                              ROUTE_CARD_WIDTH + 10, ROUTE_CARD_HEIGHT + 10);
                }
            }
            
            // Draw long route (left of last regular card)
            RouteCard longRoute = displayedRoutes.get(displayedRoutes.size() - 1);
            if (longRoute.isLong()) {
            	int baseCardY = CARD_TOP_MARGIN + ((displayedRoutes.size() - 1) * (ROUTE_CARD_HEIGHT + CARD_SPACING));
            	int cardY = baseCardY - 150; // Move up by 150 pixels
            	
                drawRouteCard(g, longRoute, longRouteX, cardY);
                
                if (selectedCardIndices.contains(displayedRoutes.size() - 1)) {
                    g2.setColor(Color.RED);
                    g2.setStroke(new BasicStroke(6));
                    g2.drawRect(longRouteX - 5, cardY - 5, 
                              ROUTE_CARD_WIDTH + 10, ROUTE_CARD_HEIGHT + 10);
                } else {
                    // Yellow border for unselected long route
                    g2.setColor(Color.YELLOW);
                    g2.setStroke(new BasicStroke(4));
                    g2.drawRect(longRouteX - 3, cardY - 3, 
                              ROUTE_CARD_WIDTH + 6, ROUTE_CARD_HEIGHT + 6);
                }
            }
        }
        
        // Update instruction based on selection count
        if (selectedCardIndices.size() < MIN_SELECTIONS) {
            g.setColor(Color.ORANGE);
            g.drawString("Select at least " + (MIN_SELECTIONS - selectedCardIndices.size()) + " more routes", 50, 130);
        } else {
            g.setColor(Color.GREEN);
            g.drawString("You can proceed to next player", 50, 130);
        }
        g.drawString("Click to select/deselect routes", 50, 180);
        
        
    }

    private void drawRouteCard(Graphics g, RouteCard card, int x, int y) {
        BufferedImage cardImage = card.getImage();
        
        if (cardImage != null) {
            g.drawImage(cardImage, x, y, ROUTE_CARD_WIDTH, ROUTE_CARD_HEIGHT, null);
        } else {
            // Fallback rectangle if image fails to load
            g.setColor(card.isLong() ? new Color(255, 255, 200) : Color.WHITE);
            g.fillRect(x, y, ROUTE_CARD_WIDTH, ROUTE_CARD_HEIGHT);
            g.setColor(Color.BLACK);
            g.drawString(card.getCityA() + " to " + card.getCityB(), x + 10, y + 20);
            if (card.isLong()) {
                g.drawString("LONG ROUTE", x + 10, y + 40);
            }
        }
    }
}