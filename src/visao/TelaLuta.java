package src.visao;

import java.awt.image.BufferedImage;

import javax.swing.JButton;
import javax.swing.JPanel;
import src.controle.ControleFrame;
public class TelaLuta {
    
    BufferedImage imgBackground = new Utils.ImgUtils().scaleImage(750,750,"../utils/UESB.jpeg");
    private static JPanel panel = new JPanel();
    private static JButton lifeBar1 = new JButton();
	private static JButton lifeBar2 = new JButton();

    public static JPanel criarTela(){
        //Adicionar Background
        lifeBar1.setBounds(0, 0, 100, 20);
		lifeBar2.setBounds(550, 0, 100, 20);
        panel.add(lifeBar1);
        panel.add(lifeBar2);

        panel.add(ControleFrame.getPlayUm());
        panel.add(ControleFrame.getPlayDois());

        return panel;
    }

}
