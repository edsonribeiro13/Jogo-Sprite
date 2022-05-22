package src.visao;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.image.BufferedImage;

public class Jogador extends JLabel{

    static JLabel label;
    private int sprit_andar_control = 0;
    private int sprit_soco_control = 0;
    private int sprit_chute_control = 0;

    public Jogador()
    {

        label = new JLabel();
        label.setBounds(100, 100, 100, 100);

    }

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

    public static Jogador andar(){

        label.setIcon(new ImageIcon(andarSprites[0]));

        return (Jogador) label;

    }

    public static Jogador pular(){

        label.setIcon(new ImageIcon(pularSprite));

        return (Jogador) label;

    }

    public void atacar(){

        label.setIcon(new ImageIcon(socarSprites[0]));

    }

    public void recuar(){

        label.setIcon(new ImageIcon(chutarSprites[0]));

    }

    static BufferedImage[] andarSprites = {
        new Utils.ImgUtils().scaleImage(100,100,"sprites//andar1.png"),
        new Utils.ImgUtils().scaleImage(50,50,"sprites//andar2.png"),
        new Utils.ImgUtils().scaleImage(50,50,"sprites//andar3.png"),
        new Utils.ImgUtils().scaleImage(50,50,"sprites//andar4.png"),
        new Utils.ImgUtils().scaleImage(50,50,"sprites//andar5.png"),
        new Utils.ImgUtils().scaleImage(50,50,"sprites//andar6.png"),
        new Utils.ImgUtils().scaleImage(50,50,"sprites//andar7.png"),
        new Utils.ImgUtils().scaleImage(50,50,"sprites//andar8.png"),
        new Utils.ImgUtils().scaleImage(50,50,"sprites//andar9.png")
    };

    static BufferedImage pularSprite = new Utils.ImgUtils().scaleImage(100,100,"sprites//andar1.png");

    static BufferedImage[] socarSprites = {
        new Utils.ImgUtils().scaleImage(100,100,"sprites//andar1.png"),
        new Utils.ImgUtils().scaleImage(50,50,"sprites//andar2.png"),
        new Utils.ImgUtils().scaleImage(50,50,"sprites//andar3.png")
    };

    static BufferedImage[] chutarSprites = {
        new Utils.ImgUtils().scaleImage(100,100,"sprites//andar1.png"),
        new Utils.ImgUtils().scaleImage(50,50,"sprites//andar2.png"),
        new Utils.ImgUtils().scaleImage(50,50,"sprites//andar3.png"),
        new Utils.ImgUtils().scaleImage(50,50,"sprites//andar4.png")
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

}
