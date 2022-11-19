package src.controle;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import src.visao.Jogador1;
import src.visao.Jogador2;
import src.visao.TelaLuta;

public class EventosJogador1 implements Runnable {

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
                    if (ControleFrame.getPlayUm().getLocation().x < 720
                            && ControleFrame.getPlayUm().getLocation().x < (ControleFrame.getPlayDois().getLocation().x
                                    - ControleFrame.getPlayDois().getWidth()))
                        ControleFrame.getPlayUm().setLocation(ControleFrame.getPlayUm().getLocation().x + 5,
                                ControleFrame.getPlayUm().getLocation().y);
                    if (ControleFrame.getPlayUm().getSprit_andar_control() >= 0
                            && ControleFrame.getPlayUm().getSprit_andar_control() < 9) {
                        ControleFrame.getPlayUm().setIcon(new ImageIcon(
                                Jogador1.getAndarSprites()[ControleFrame.getPlayUm().getSprit_andar_control()]));
                        ControleFrame.getPlayUm()
                                .setSprit_andar_control(ControleFrame.getPlayUm().getSprit_andar_control() + 1);
                    } else {

                        ControleFrame.getPlayUm().setSprit_andar_control(0);
                        ControleFrame.getPlayUm().setIcon(new ImageIcon(
                                Jogador1.getAndarSprites()[ControleFrame.getPlayUm().getSprit_andar_control()]));

                    }
                } else if (getMovieDirection()[3]) {
                    if (ControleFrame.getPlayUm().getLocation().x > 0)
                        ControleFrame.getPlayUm().setLocation(ControleFrame.getPlayUm().getLocation().x - 5,
                                ControleFrame.getPlayUm().getLocation().y);
                    if (ControleFrame.getPlayUm().getSprit_andar_control() >= 0
                            && ControleFrame.getPlayUm().getSprit_andar_control() < 9) {
                        ControleFrame.getPlayUm().setIcon(new ImageIcon(
                                Jogador1.getAndarSprites()[ControleFrame.getPlayUm().getSprit_andar_control()]));
                        ControleFrame.getPlayUm()
                                .setSprit_andar_control(ControleFrame.getPlayUm().getSprit_andar_control() - 1);
                    } else {

                        ControleFrame.getPlayUm().setSprit_andar_control(8);
                        ControleFrame.getPlayUm().setIcon(new ImageIcon(
                                Jogador1.getAndarSprites()[ControleFrame.getPlayUm().getSprit_andar_control()]));

                    }
                } else if (getMovieDirection()[0]) {
                    float vlc = 0;

                    ControleFrame.getPlayUm().setIcon(new ImageIcon(Jogador1.getPularSprite()));

                    for (int i = 0; i < 15; i++) {
                        try {
                            vlc += -(10 * 0.0333333333333);
                            ControleFrame.getPlayUm().setLocation(ControleFrame.getPlayUm().getLocation().x,
                                    Math.round(ControleFrame.getPlayUm().getY() + vlc));
                            Thread.sleep(10);
                        } catch (InterruptedException e1) {

                            e1.printStackTrace();
                        }
                    }
                    vlc = 0;
                    for (int i = 0; i < 15; i++) {
                        try {
                            vlc += (10 * 0.0333333333333);
                            ControleFrame.getPlayUm().setLocation(ControleFrame.getPlayUm().getLocation().x,
                                    Math.round(ControleFrame.getPlayUm().getY() + vlc));
                            Thread.sleep(10);
                        } catch (InterruptedException e1) {

                            e1.printStackTrace();
                        }
                    }
                    ControleFrame.getPlayUm().setSprit_andar_control(0);
                    ControleFrame.getPlayUm().setIcon(new ImageIcon(
                            Jogador1.getAndarSprites()[ControleFrame.getPlayUm().getSprit_andar_control()]));
                } else if (getMovieDirection()[4]) {
                    float vlc = 0;
                    for (int i = 0; i < 3; i++) {
                        try {
                            vlc += (10 * 0.0333333333333);
                            ControleFrame.getPlayUm().setSprit_soco_controll(i);
                            ControleFrame.getPlayUm().setIcon(new ImageIcon(Jogador1.getSocarSprites()[i]));
                            ControleFrame.getPlayUm().setLocation(Math.round(ControleFrame.getPlayUm().getX() + vlc),
                                    ControleFrame.getPlayUm().getY());
                            Thread.sleep(33);
                        } catch (InterruptedException e1) {

                            e1.printStackTrace();
                        }
                    }

                    ControleFrame.getPlayUm().setSprit_andar_control(0);
                    ControleFrame.getPlayUm().setIcon(new ImageIcon(
                            Jogador1.getAndarSprites()[ControleFrame.getPlayUm().getSprit_andar_control()]));
                    soco();
                    movieDirection[4] = false;
                    setMovieDirection(movieDirection);
                } else if (getMovieDirection()[5]) {
                    float vlc = 0;
                    for (int i = 0; i < 3; i++) {
                        try {
                            vlc += (10 * 0.0333333333333);
                            ControleFrame.getPlayUm().setSprit_chute_control(i);
                            ControleFrame.getPlayUm().setIcon(new ImageIcon(Jogador1.getSocarSprites()[i]));
                            ControleFrame.getPlayUm().setLocation(Math.round(ControleFrame.getPlayUm().getX() + vlc),
                                    ControleFrame.getPlayUm().getY());
                            Thread.sleep(33);
                        } catch (InterruptedException e1) {

                            e1.printStackTrace();
                        }
                    }
                    ControleFrame.getPlayUm().setSprit_andar_control(0);
                    ControleFrame.getPlayUm().setIcon(new ImageIcon(
                            Jogador1.getAndarSprites()[ControleFrame.getPlayUm().getSprit_andar_control()]));
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

        colision_check(ControleFrame.getPlayUm(), ControleFrame.getPlayDois(),
                ControleFrame.getPersonagem1().getsoco());

    }

    public static void chute() {
        colision_check(ControleFrame.getPlayUm(), ControleFrame.getPlayDois(),
                ControleFrame.getPersonagem1().getChute());

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

            TelaLuta.getLifebar2().setSize(TelaLuta.getLifebar2().getWidth() - forca,
                    TelaLuta.getLifebar2().getHeight());
            if (TelaLuta.getLifebar2().getWidth() <= 0) {
                for (int i = 0; i < 3; i++) {
                    try {
                        ControleFrame.getPlayDois().setIcon(new ImageIcon(Jogador2.getMorteSprites()[i]));
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
