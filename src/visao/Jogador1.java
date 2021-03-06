package src.visao;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import src.controle.ControleFrame;
import java.awt.image.BufferedImage;

public class Jogador1 extends JLabel{

    private int sprit_andar_control = 0;
    private int sprit_soco_control = 0;
    private int sprit_chute_control = 0;

    public int getSprit_andar_control() {
		return sprit_andar_control;
	}

	public void setSprit_andar_control(int sprit_andar_control) {
		this.sprit_andar_control = sprit_andar_control;
	}

	public int getSprit_soco_control() {
		return sprit_soco_control;
	}

	public void setSprit_soco_controll(int sprit_soco_control) {
		this.sprit_soco_control = sprit_soco_control;
	}

	public int getSprit_chute_control() {
		return sprit_chute_control;
	}

	public void setSprit_chute_control(int sprit_chute_control) {
		this.sprit_chute_control = sprit_chute_control;
	}

    public static void andar(Jogador1 label){

        label.setIcon(new ImageIcon(andarSprites[0]));

    }

    public static void pular(Jogador1 label){

        label.setIcon(new ImageIcon(pularSprite));

    }

    public void atacar(Jogador1 label){

        label.setIcon(new ImageIcon(socarSprites[0]));

    }

    public void recuar(Jogador1 label){

        label.setIcon(new ImageIcon(chutarSprites[0]));

    }

    static BufferedImage[] andarSprites = {
        new Utils.ImgUtils().scaleImage(80,80,"src//utils/" + ControleFrame.getPersonagem1().getNome() + "Andar1.png"),
        new Utils.ImgUtils().scaleImage(80,80,"src//utils/" + ControleFrame.getPersonagem1().getNome() + "Andar2.png"),
        new Utils.ImgUtils().scaleImage(80,80,"src//utils/" + ControleFrame.getPersonagem1().getNome() + "Andar3.png"),
        new Utils.ImgUtils().scaleImage(80,80,"src//utils/" + ControleFrame.getPersonagem1().getNome() + "Andar4.png"),
        new Utils.ImgUtils().scaleImage(80,80,"src//utils/" + ControleFrame.getPersonagem1().getNome() + "Andar5.png"),
        new Utils.ImgUtils().scaleImage(80,80,"src//utils/" + ControleFrame.getPersonagem1().getNome() + "Andar6.png"),
        new Utils.ImgUtils().scaleImage(80,80,"src//utils/" + ControleFrame.getPersonagem1().getNome() + "Andar7.png"),
        new Utils.ImgUtils().scaleImage(80,80,"src//utils/" + ControleFrame.getPersonagem1().getNome() + "Andar8.png"),
        new Utils.ImgUtils().scaleImage(80,80,"src//utils/" + ControleFrame.getPersonagem1().getNome() + "Andar9.png")
    };

    static BufferedImage pularSprite = new Utils.ImgUtils().scaleImage(100,100,
                                                                        "src//utils/" + ControleFrame.getPersonagem1().getNome()+ "Pulo.png");

    static BufferedImage[] socarSprites = {
        new Utils.ImgUtils().scaleImage(80,80,"src//utils/" + ControleFrame.getPersonagem1().getNome() + "Soco1.png"),
        new Utils.ImgUtils().scaleImage(80,80,"src//utils/" + ControleFrame.getPersonagem1().getNome() + "Soco2.png"),
        new Utils.ImgUtils().scaleImage(80,80,"src//utils/" + ControleFrame.getPersonagem1().getNome() + "Soco3.png")
    };

    static BufferedImage[] chutarSprites = {
        new Utils.ImgUtils().scaleImage(80,80,"src//utils/" + ControleFrame.getPersonagem1().getNome() + "Chute1.png"),
        new Utils.ImgUtils().scaleImage(80,80,"src//utils/" + ControleFrame.getPersonagem1().getNome() + "Chute2.png"),
        new Utils.ImgUtils().scaleImage(80,80,"src//utils/" + ControleFrame.getPersonagem1().getNome() + "Chute3.png"),
        new Utils.ImgUtils().scaleImage(80,80,"src//utils/" + ControleFrame.getPersonagem1().getNome() + "Chute4.png")
    };

    static BufferedImage[] morteSprites = {
        new Utils.ImgUtils().scaleImage(80,80,"src//utils/" + ControleFrame.getPersonagem1().getNome() + "Morte1.png"),
        new Utils.ImgUtils().scaleImage(80,80,"src//utils/" + ControleFrame.getPersonagem1().getNome() + "Morte2.png"),
        new Utils.ImgUtils().scaleImage(80,80,"src//utils/" + ControleFrame.getPersonagem1().getNome() + "Morte3.png")
    };

    public static BufferedImage[] getAndarSprites() {
		return andarSprites;
	}

	public static BufferedImage getPularSprite() {
		return pularSprite;
	}

	public static BufferedImage[] getSocarSprites() {
		return socarSprites;
	}

	public static BufferedImage[] getChutarSprites() {
		return chutarSprites;
	}

    public static BufferedImage[] getMorteSprites() {
		return morteSprites;
	}

}
