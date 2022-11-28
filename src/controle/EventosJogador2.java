package src.controle;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import src.visao.TelaIni;
import src.visao.TelaLuta;

public class EventosJogador2 implements Runnable {
    // top, right, down, left
    private boolean[] movieDirection = {
            false,
            false,
            false,
            false,
            false,
            false
    };

    public boolean[] getMovieDirection() {
        return movieDirection;
    }

    public void setMovieDirection(boolean[] movieDirection) {
        this.movieDirection = movieDirection;
    }

    private int Opcao;

    public int getOpcao() {
        return Opcao;
    }

    public void setOpcao(int Opcao) {
        this.Opcao = Opcao;
    }

    @Override
    public void run() {
        try {
            while (true) {
                if (getMovieDirection()[1]) {
                    if (ControleFrame.getPlayDois().getLocation().x > 0
                            && ControleFrame.getPlayDois().getLocation().x > (ControleFrame.getPlayUm().getLocation().x
                                    + (ControleFrame.getPlayUm().getWidth()/2)))
                        ControleFrame.getPlayDois().setLocation(ControleFrame.getPlayDois().getLocation().x - 5,
                                ControleFrame.getPlayDois().getLocation().y);
                    ControleFrame.getPlayDois().andar();
                } else if (getMovieDirection()[3]) {
                    if (ControleFrame.getPlayDois().getLocation().x < 720)
                        ControleFrame.getPlayDois().setLocation(ControleFrame.getPlayDois().getLocation().x + 5,
                                ControleFrame.getPlayDois().getLocation().y);
                    ControleFrame.getPlayDois().andar();

                    
                } else if (getMovieDirection()[0]) {
                    float vlc = 0;

                    ControleFrame.getPlayDois().setIcon(new ImageIcon(ControleFrame.getPlayDois().getParadoSprite()));

                    for (int i = 0; i < 15; i++) {
                        try {
                            vlc += -(10 * 0.0333333333333);
                            ControleFrame.getPlayDois().setLocation(ControleFrame.getPlayDois().getLocation().x,
                                    Math.round(ControleFrame.getPlayDois().getY() + vlc));
                            Thread.sleep(10);
                        } catch (InterruptedException e1) {

                            e1.printStackTrace();
                        }
                    }
                    vlc = 0;
                    for (int i = 0; i < 15; i++) {
                        try {
                            vlc += (10 * 0.0333333333333);
                            ControleFrame.getPlayDois().setLocation(ControleFrame.getPlayDois().getLocation().x,
                                    Math.round(ControleFrame.getPlayDois().getY() + vlc));
                            Thread.sleep(10);
                        } catch (InterruptedException e1) {

                            e1.printStackTrace();
                        }
                    }
                    ControleFrame.getPlayDois().Parado();
                } else if (getMovieDirection()[4]) {
                    soco();
                    movieDirection[4] = false;
                    setMovieDirection(movieDirection);
                } else if (getMovieDirection()[5]) {

                    chute();
                    movieDirection[5] = false;
                    setMovieDirection(movieDirection);
                }
                Thread.sleep(30);
            }

        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public static void soco() {
        ControleFrame.getPlayDois().setLocation(
                        Math.round(ControleFrame.getPlayDois().getX() - 2),
                        ControleFrame.getPlayDois().getY());
        colision_check(ControleFrame.getPlayDois(), ControleFrame.getPlayUm(),
                        ControleFrame.getPersonagem2().getsoco());
        ControleFrame.getPlayDois().setLocation(
                        Math.round(ControleFrame.getPlayDois().getX() + 2),
                        ControleFrame.getPlayDois().getY());

    }

    public static void chute() {
        ControleFrame.getPlayDois().setLocation(
            Math.round(ControleFrame.getPlayDois().getX() - 2),
            ControleFrame.getPlayDois().getY());
        colision_check(ControleFrame.getPlayDois(), ControleFrame.getPlayUm(),
                ControleFrame.getPersonagem2().getChute());
        ControleFrame.getPlayDois().setLocation(
            Math.round(ControleFrame.getPlayDois().getX() + 2),
            ControleFrame.getPlayDois().getY());

    }

    public static boolean colision_check(JLabel LA, JLabel LB, int forca) {
        // Coleta informações do primeiro ControleFrame.getPlayDois()
        int label_A_x = LA.getX();
        int label_A_y = LA.getY();
        int label_A_h = LA.getHeight();
        int label_A_w = LA.getWidth();

        // Coleta informações do segundo
        int label_B_x = LB.getX();
        int label_B_y = LB.getY();
        int label_B_h = LB.getHeight();
        int label_B_w = LB.getWidth();

        // Verifica se existe colisão
        if (label_A_x < label_B_x + label_B_w &&
                label_A_x + label_A_w > label_B_x &&
                label_A_y < label_B_y + label_B_h &&
                label_A_y + label_A_h > label_B_y) {
            // Houve colisão

            TelaLuta.getLifebar1().setSize(TelaLuta.getLifebar1().getWidth() - forca,
                    TelaLuta.getLifebar1().getHeight());
            if (TelaLuta.getLifebar1().getWidth() <= 0) {
                ControleFrame.getPlayUm().morrer();
                JOptionPane.showMessageDialog(null, "Jogador 2 venceu!");
                ControleFrame.resetTheGame(ControleFrame.getPlayDois());

            }
        }
        return true;

    }

}
