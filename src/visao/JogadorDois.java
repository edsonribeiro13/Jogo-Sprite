package src.visao;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.image.BufferedImage;

public class JogadorDois extends JLabel{
    
    JLabel label;
    private int sprit_andar_control = 0;
    private int sprit_pular_control = 0;
    private int sprit_atacar_control = 0;
    private int sprit_recuar_control = 0;

    public JogadorDois()
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

	public int getSprit_pular_control() {
		return sprit_pular_control;
	}

	public void setSprit_pular_control(int sprit_pular_control) {
		this.sprit_pular_control = sprit_pular_control;
	}

	public int getSprit_atacar_control() {
		return sprit_atacar_control;
	}

	public void setSprit_atacar_control(int sprit_atacar_control) {
		this.sprit_atacar_control = sprit_atacar_control;
	}

	public int getSprit_recuar_control() {
		return sprit_recuar_control;
	}

	public void setSprit_recuar_control(int sprit_recuar_control) {
		this.sprit_recuar_control = sprit_recuar_control;
	}

    public void andar(){

        label.setIcon(new ImageIcon(andarSprites[0]));

    }

    public void pular(){

        label.setIcon(new ImageIcon(pularSprites[0]));

    }

    public void atacar(){

        label.setIcon(new ImageIcon(atacarSprites[0]));

    }

    public void recuar(){

        label.setIcon(new ImageIcon(recuarSprites[0]));

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

    static BufferedImage[] pularSprites = {
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

    static BufferedImage[] atacarSprites = {
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

    static BufferedImage[] recuarSprites = {
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

    public static BufferedImage[] getAndarSprites() {
		return andarSprites;
	}

	public static BufferedImage[] getPularSprites() {
		return pularSprites;
	}

	public static BufferedImage[] getAtacarSprites() {
		return atacarSprites;
	}

	public static BufferedImage[] getRecuarSprites() {
		return recuarSprites;
	}

}
