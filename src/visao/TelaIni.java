package src.visao;

import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TelaIni {
    
    private static BufferedImage imgBackground = new Utils.ImgUtils().scaleImage(750,750,"../utils/UESB.jpeg");
    private static JLabel labelImgBackground = new JLabel();
    private static BufferedImage imgPersonagem1 = new Utils.ImgUtils().scaleImage(100,100,"");
    private static JLabel label1 = new JLabel();
    private static BufferedImage imgPersonagem2 = new Utils.ImgUtils().scaleImage(100,100,"");
    private static JLabel label2 = new JLabel();
    private static BufferedImage imgPersonagem3 = new Utils.ImgUtils().scaleImage(100,100,"");
    private static JLabel label3 = new JLabel();
    private static BufferedImage imgPersonagem4 = new Utils.ImgUtils().scaleImage(100,100,"");
    private static JLabel label4 = new JLabel();
    private static BufferedImage imgPersonagem5 = new Utils.ImgUtils().scaleImage(100,100,"");
    private static JLabel label5 = new JLabel();
    private static BufferedImage imgPersonagem6 = new Utils.ImgUtils().scaleImage(100,100,"");
    private static JLabel label6 = new JLabel();

    private static JPanel panel = new JPanel();

    public static JPanel criarTela(){
        labelImgBackground.setIcon(new ImageIcon(imgBackground));
        label1.setIcon(new ImageIcon(imgPersonagem1));
        label2.setIcon(new ImageIcon(imgPersonagem2));
        label3.setIcon(new ImageIcon(imgPersonagem3));
        label4.setIcon(new ImageIcon(imgPersonagem4));
        label5.setIcon(new ImageIcon(imgPersonagem5));
        label6.setIcon(new ImageIcon(imgPersonagem6));

        label1.setBounds(400, 400, 100, 100);
        label2.setBounds(500, 400, 100, 100);
        label3.setBounds(600, 400, 100, 100);
        label4.setBounds(400, 510, 100, 100);
        label5.setBounds(500, 510, 100, 100);
        label6.setBounds(600, 510, 100, 100);

        panel.add(label1);
        panel.add(label2);
        panel.add(label3);
        panel.add(label4);
        panel.add(label5);
        panel.add(label6);

        return panel;
    }

	public static JLabel getLabel1() {
		return label1;
	}

	public static void setLabel1(JLabel label1) {
		TelaIni.label1 = label1;
	}

	public static JLabel getLabel2() {
		return label2;
	}

	public static void setLabel2(JLabel label2) {
		TelaIni.label2 = label2;
	}

	public static JLabel getLabel3() {
		return label3;
	}

	public static void setLabel3(JLabel label3) {
		TelaIni.label3 = label3;
	}

	public static JLabel getLabel4() {
		return label4;
	}

	public static void setLabel4(JLabel label4) {
		TelaIni.label4 = label4;
	}

	public static JLabel getLabel5() {
		return label5;
	}

	public static void setLabel5(JLabel label5) {
		TelaIni.label5 = label5;
	}

	public static JLabel getLabel6() {
		return label6;
	}

	public static void setLabel6(JLabel label6) {
		TelaIni.label6 = label6;
	}

    

}
