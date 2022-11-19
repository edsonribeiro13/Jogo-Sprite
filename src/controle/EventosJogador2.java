package src.controle;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import src.visao.Jogador1;
import src.visao.Jogador2;
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
                            && ControleFrame.getPlayDois().getLocation().x > ControleFrame.getPlayUm().getLocation().x
                                    + ControleFrame.getPlayUm().getWidth())
                        ControleFrame.getPlayDois().setLocation(ControleFrame.getPlayDois().getLocation().x - 5,
                                ControleFrame.getPlayDois().getLocation().y);
                    if (ControleFrame.getPlayDois().getSprit_andar_control() < 9
                            && ControleFrame.getPlayDois().getSprit_andar_control() >= 0) {
                        ControleFrame.getPlayDois().setIcon(new ImageIcon(
                                Jogador2.getAndarSprites()[ControleFrame.getPlayDois().getSprit_andar_control()]));
                        ControleFrame.getPlayDois()
                                .setSprit_andar_control(ControleFrame.getPlayDois().getSprit_andar_control() + 1);
                    } else {

                        ControleFrame.getPlayDois().setSprit_andar_control(0);
                        ControleFrame.getPlayDois().setIcon(new ImageIcon(
                                Jogador2.getAndarSprites()[ControleFrame.getPlayDois().getSprit_andar_control()]));

                    }
                } else if (getMovieDirection()[3]) {
                    if (ControleFrame.getPlayDois().getLocation().x < 720)
                        ControleFrame.getPlayDois().setLocation(ControleFrame.getPlayDois().getLocation().x + 5,
                                ControleFrame.getPlayDois().getLocation().y);
                    if (ControleFrame.getPlayDois().getSprit_andar_control() < 9
                            && ControleFrame.getPlayDois().getSprit_andar_control() >= 0) {
                        ControleFrame.getPlayDois().setIcon(new ImageIcon(
                                Jogador2.getAndarSprites()[ControleFrame.getPlayDois().getSprit_andar_control()]));
                        ControleFrame.getPlayDois()
                                .setSprit_andar_control(ControleFrame.getPlayDois().getSprit_andar_control() - 1);
                    } else {

                        ControleFrame.getPlayDois().setSprit_andar_control(8);
                        ControleFrame.getPlayDois().setIcon(new ImageIcon(
                                Jogador2.getAndarSprites()[ControleFrame.getPlayDois().getSprit_andar_control()]));

                    }
                } else if (getMovieDirection()[0]) {
                    float vlc = 0;

                    ControleFrame.getPlayDois().setIcon(new ImageIcon(Jogador2.getPularSprite()));

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
                } else if (getMovieDirection()[4]) {
                    float vlc = 0;
                    for (int i = 0; i < 3; i++) {
                        try {
                            vlc += (10 * 0.0333333333333);
                            ControleFrame.getPlayDois().setSprit_soco_controll(i);
                            ControleFrame.getPlayDois().setIcon(new ImageIcon(Jogador2.getSocarSprites()[i]));
                            ControleFrame.getPlayDois().setLocation(
                                    Math.round(ControleFrame.getPlayDois().getX() - vlc),
                                    ControleFrame.getPlayDois().getY());
                            Thread.sleep(33);
                        } catch (InterruptedException e1) {

                            e1.printStackTrace();
                        }
                    }

                    ControleFrame.getPlayDois().setSprit_andar_control(0);
                    ControleFrame.getPlayDois().setIcon(
                            new ImageIcon(
                                    Jogador2.getAndarSprites()[ControleFrame.getPlayDois().getSprit_andar_control()]));
                    soco();
                    movieDirection[4] = false;
                    setMovieDirection(movieDirection);
                } else if (getMovieDirection()[5]) {
                    float vlc = 0;
                    for (int i = 0; i < 3; i++) {
                        try {
                            vlc += (10 * 0.0333333333333);
                            ControleFrame.getPlayDois().setSprit_chute_control(i);
                            ControleFrame.getPlayDois().setIcon(new ImageIcon(Jogador2.getSocarSprites()[i]));
                            ControleFrame.getPlayDois().setLocation(
                                    Math.round(ControleFrame.getPlayDois().getX() - vlc),
                                    ControleFrame.getPlayDois().getY());
                            Thread.sleep(33);
                        } catch (InterruptedException e1) {

                            e1.printStackTrace();
                        }
                    }
                    ControleFrame.getPlayDois().setSprit_andar_control(0);
                    ControleFrame.getPlayDois().setIcon(
                            new ImageIcon(
                                    Jogador2.getAndarSprites()[ControleFrame.getPlayDois().getSprit_andar_control()]));
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

        colision_check(ControleFrame.getPlayDois(), ControleFrame.getPlayUm(),
                ControleFrame.getPersonagem2().getsoco());

    }

    public static void chute() {

        colision_check(ControleFrame.getPlayDois(), ControleFrame.getPlayUm(),
                ControleFrame.getPersonagem2().getChute());

    }

    public static boolean colision_check(JLabel LA, JLabel LB, int forca) {
        // Coleta informações do primeiro jogador
        int label_A_x = LA.getX();
        int label_A_y = LA.getY();
        int label_A_h = LA.getHeight();
        int label_A_w = LA.getWidth();

        // Coleta informações do segundo
        int label_B_x = LB.getX();
        int label_B_y = LB.getY();
        int label_B_h = LB.getHeight();
        int label_B_w = LB.getWidth();

        // Realiza as verificações para ver se existi colisão
        if (label_A_x < label_B_x + label_B_w &&
                label_A_x + label_A_w > label_B_x &&
                label_A_y < label_B_y + label_B_h &&
                label_A_y + label_A_h > label_B_y) {
            // Houve colisão

            TelaLuta.getLifebar1().setSize(TelaLuta.getLifebar1().getWidth() - forca,
                    TelaLuta.getLifebar1().getHeight());
            if (TelaLuta.getLifebar1().getWidth() <= 0) {
                for (int i = 0; i < 3; i++) {
                    try {
                        ControleFrame.getPlayUm().setIcon(new ImageIcon(Jogador1.getMorteSprites()[i]));
                        Thread.sleep(33);
                    } catch (InterruptedException e1) {

                        e1.printStackTrace();
                    }
                }
                ControleFrame.setControle(GameState.END);
            }
        }
        return true;

    }

}
