package src.visao;

import java.awt.image.BufferedImage;
import javax.swing.JPanel;
import src.controle.ControleFrame;
public class TelaLuta {
    
    BufferedImage imgBackground = new Utils.ImgUtils().scaleImage(750,750,"../utils/UESB.jpeg");
    private static JPanel panel = new JPanel();

    public JPanel criarTela(){
        //Adicionar Background
        panel.add(ControleFrame.getPlayUm());
        panel.add(ControleFrame.getPlayDois());
        return panel;
    }

}
