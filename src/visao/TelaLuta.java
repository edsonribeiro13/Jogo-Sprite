package src.visao;

import java.awt.image.BufferedImage;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import src.controle.ControleFrame;
import java.awt.Color;

public class TelaLuta {
    
    private static BufferedImage imgBackground = new Utils.ImgUtils().scaleImage(800,150,"src//utils/UESB.jpeg");
    private static BufferedImage lifeBarIcon = new Utils.ImgUtils().scaleImage(100,100,"src//utils/LifeBarIcon.png");

    private static JPanel panel = new JPanel();
    private static JLabel lifeBar1 = new JLabel();
	private static JLabel lifeBar2 = new JLabel();
    private static JLabel labelImgBackground = new JLabel();
    

    public static JPanel criarTela(){
        //Adicionar Background

        panel.setVisible(true);
        panel.setSize(800, 600);
        panel.setLayout(null);
        panel.setBackground(Color.DARK_GRAY);

        lifeBar1.setIcon(new ImageIcon(lifeBarIcon));
        lifeBar2.setIcon(new ImageIcon(lifeBarIcon));
        labelImgBackground.setIcon(new ImageIcon(imgBackground));

        lifeBar1.setBounds(0, 160, ControleFrame.getPersonagem1().getVida(), 20);
		lifeBar2.setBounds(550, 160, ControleFrame.getPersonagem2().getVida(), 20);
        labelImgBackground.setBounds(0, 0, 800, 150);

        panel.add(lifeBar1);
        panel.add(lifeBar2);
        panel.add(labelImgBackground);
        panel.add(ControleFrame.getPlayUm());
        panel.add(ControleFrame.getPlayDois());

        return panel;
    }

    public static JLabel getLifebar1(){
        return lifeBar1;
    }

    public static JLabel getLifebar2(){
        return lifeBar2;
    }

}
