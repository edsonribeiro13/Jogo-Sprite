package src;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Dvd extends JFrame implements KeyListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JFrame frame = new JFrame();
	JLabel label = new JLabel();
	BufferedImage img1 = new ImgUtils().scaleImage(50,50,"sprites1.png");
	BufferedImage img2 = new ImgUtils().scaleImage(50,50,"sprites2.png");
	JPanel panel = new JPanel();
	char pulo;
	
	public Dvd() {
		label.setBounds(100, 100, 50, 50);
		
		label.setIcon(new ImageIcon(img1));

		panel.setLayout(null);
		panel.setSize(700, 700);
		panel.add(label);
		panel.setBackground(Color.BLACK);
		panel.setVisible(true);
		
		frame.setVisible(true);
		frame.setSize(700, 700);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setContentPane(panel);
		
		frame.addKeyListener(this);
		float speed = 0;
		while(true) {
			//gravidade
			try {

				Thread.sleep(10);
				speed += (1 * 0.0333333333333);
				label.setLocation(label.getLocation().x, Math.round(label.getY() + speed));
				System.out.println(label.getY());

				if(pulo == 'w') {
					label.setIcon(new ImageIcon(img2));
					pulo();
					label.setIcon(new ImageIcon(img1));
					pulo = '5';
				}
				if (label.getY() > 500)
				{
					label.setLocation(label.getX(), 500);
					speed = 0;
				}

			} catch (InterruptedException e1) {

				e1.printStackTrace();
			}
			


			
		}
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stu
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_D) {
			label.setLocation(label.getLocation().x + 3, label.getLocation().y);
		}
		else if(e.getKeyCode() == KeyEvent.VK_A){
			label.setLocation(label.getLocation().x - 3, label.getLocation().y);
		}
		else if(e.getKeyCode() == KeyEvent.VK_S) {
			
			label.setLocation(label.getLocation().x, label.getLocation().y + 2);

			
			
		}
		else if(e.getKeyCode() == KeyEvent.VK_W){
			pulo = 'w';
		}
		
		/*try {
			Thread.sleep(10);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}*/
	}
	
	public static void main (String[] args) {
		
		new Dvd();
		
	}
	
	public static class ImgUtils {

		public BufferedImage scaleImage(int WIDTH, int HEIGHT, String filename) {
		    BufferedImage bi = null;
		    try {
		        ImageIcon ii = new ImageIcon(filename);//path to image
		        bi = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		        Graphics2D g2d = (Graphics2D) bi.createGraphics();
		        g2d.addRenderingHints((Map<?, ?>) new RenderingHints(RenderingHints.KEY_RENDERING,RenderingHints.VALUE_RENDER_QUALITY));
		        g2d.drawImage(ii.getImage(), 0, 0, WIDTH, HEIGHT, null);
		    } catch (Exception e) {
		        e.printStackTrace();
		        return null;
		    }
		    return bi;
		}

		 }
	public void pulo() {
		float vlc = 0;
		
		System.out.println(label.getY());
		for (int i = 0 ; i < 15; i++) {
			try {
				vlc += -(10 * 0.0333333333333);
				label.setLocation(label.getLocation().x, Math.round(label.getY() + vlc));
				Thread.sleep(10);
				repaint();
				
			} catch (InterruptedException e1) {

				e1.printStackTrace();
			}
		}
		System.out.println(label.getY());
	}

}
