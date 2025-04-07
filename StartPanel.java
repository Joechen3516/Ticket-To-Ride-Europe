import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;

public class StartPanel extends JPanel {
    private BufferedImage startbg, play;
    private JButton button;

    public StartPanel(GameController controller) {
        this.setLayout(null);
        button = new JButton();
        add(button);

        // Ensure button background is transparent (optional)
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);

        try {
            startbg = ImageIO.read(StartPanel.class.getResource("/images/startbg.png"));
            play = ImageIO.read(StartPanel.class.getResource("/images/play.png"));
        } catch (Exception e) {
            System.out.println("StartPanel error: " + e.getMessage());
        }

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == button) {
                    controller.HandleAction(ActionEvents.Start);
                }
            }
        });

        // Add component listener to adjust button size dynamically
        this.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                int btnX = (int) (getWidth() * 0.42279);
                int btnY = (int) (getHeight() * 0.38663);
                int btnWidth = (int) (getWidth() * 0.16341);
                int btnHeight = (int) (getHeight() * 0.19105);
                button.setBounds(btnX, btnY, btnWidth, btnHeight);
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(startbg, 0, 0, getWidth(), getHeight(), null);
        g.drawImage(play, (int) (getWidth() * 0.42279), (int) (getHeight() * 0.38663), 
                    (int) (getWidth() * 0.16341), (int) (getHeight() * 0.19105), null);
    }
}