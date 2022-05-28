package src.visao;

import java.awt.image.BufferedImage;
import java.util.Map;
import javax.swing.ImageIcon;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

public class Utils {

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
		public int colision_check(JLabel LA, JLabel LB)
		{
			//Coleta informações do primeiro jogador
			int label_A_x = LA.getX();
			int label_A_y = LA.getY();
			int label_A_h = LA.getHeight();
			int label_A_w = LA.getWidth();

			//Coleta informações do segundo
			int label_B_x = LB.getX();
			int label_B_y= LB.getY();
			int label_B_h = LB.getHeight();
			int label_B_w = LB.getWidth();

			//Realiza as verificações para ver se existi colisão
			if (label_A_x < label_B_x + label_B_w &&
			label_A_x + label_A_w > label_B_x &&
			label_A_y < label_B_y + label_B_h &&
			label_A_y + label_A_h > label_B_y) {
				//Houve colisão

				lifeBar1.setSize(lifeBar1.getWidth()-1, lifeBar1.getHeight());
				lifeBar2.setSize(lifeBar2.getWidth()-1, lifeBar2.getHeight());
				return 1;
			}
			//não houve colisão
			return 0;

	}
    }

}
