package src.controle;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import src.visao.Jogador2;
import src.visao.TelaLuta;

public class EventosJogador2 {
    public static void eventosJogador2(int opc){
        if (opc == 1){
            ControleFrame.getPlayDois().setLocation(ControleFrame.getPlayDois().getLocation().x + 5, 
                                                    ControleFrame.getPlayDois().getLocation().y);
            if(ControleFrame.getPlayDois().getSprit_andar_control() < 9)
            {
                ControleFrame.getPlayDois().setIcon(new ImageIcon(Jogador2.getAndarSprites()[ControleFrame.getPlayDois().getSprit_andar_control()]));
                ControleFrame.getPlayDois().setSprit_andar_control(ControleFrame.getPlayDois().getSprit_andar_control() + 1);
            }else
            {

                ControleFrame.getPlayDois().setSprit_andar_control(0);
                ControleFrame.getPlayDois().setIcon(new ImageIcon(Jogador2.getAndarSprites()[ControleFrame.getPlayDois().getSprit_andar_control()]));
                
            }
        }
        else if (opc == 2){
            ControleFrame.getPlayDois().setLocation( ControleFrame.getPlayDois().getLocation().x - 5,  ControleFrame.getPlayDois().getLocation().y);
            if(ControleFrame.getPlayDois().getSprit_andar_control() > 0)
            {
                ControleFrame.getPlayDois().setIcon(new ImageIcon(Jogador2.getAndarSprites()[ControleFrame.getPlayDois().getSprit_andar_control()]));
                ControleFrame.getPlayDois().setSprit_andar_control(ControleFrame.getPlayDois().getSprit_andar_control() - 1);
            }else
            {

                ControleFrame.getPlayDois().setSprit_andar_control(9);
                ControleFrame.getPlayDois().setIcon(new ImageIcon(Jogador2.getAndarSprites()[ControleFrame.getPlayDois().getSprit_andar_control()]));
                
            }
        }
        else if (opc == 3){
            ControleFrame.getPlayDois().setLocation(ControleFrame.getPlayDois().getLocation().x, ControleFrame.getPlayDois().getLocation().y + 5);
        }
        else if (opc == 4){
            float vlc = 0;

            ControleFrame.getPlayDois().setIcon(new ImageIcon(Jogador2.getPularSprite()));
		
            for (int i = 0 ; i < 15; i++) {
                try {
                    vlc += -(10 * 0.0333333333333);
                    ControleFrame.getPlayDois().setLocation(ControleFrame.getPlayDois().getLocation().x, 
                                                        Math.round(ControleFrame.getPlayDois().getY() + vlc));
                    Thread.sleep(10);
                } catch (InterruptedException e1) {

                    e1.printStackTrace();
                }
            }
        }
        else if (opc == 5){
            float vlc = 0;
            for (int i = 0 ; i < 3; i++) {
                try {
                    vlc += -(10 * 0.0333333333333);
                    ControleFrame.getPlayDois().setSprit_soco_controll(i);
                    ControleFrame.getPlayDois().setIcon(new ImageIcon(Jogador2.getSocarSprites()
                                                      [ControleFrame.getPlayDois().getSprit_andar_control()]));
                    ControleFrame.getPlayDois().setLocation(Math.round(ControleFrame.getPlayDois().getX() + vlc), 
                                                        ControleFrame.getPlayDois().getY());
                    Thread.sleep(10);
                } catch (InterruptedException e1) {

                    e1.printStackTrace();
                }
            }
            soco(ControleFrame.getJogador2());
            ControleFrame.getPlayDois().setSprit_andar_control(0);
            ControleFrame.getPlayDois().setIcon(new ImageIcon(Jogador2.getAndarSprites()[ControleFrame.getPlayDois().getSprit_andar_control()]));
        }
        else if (opc == 6){
            float vlc = 0;
            for (int i = 0 ; i < 3; i++) {
                try {
                    vlc += -(10 * 0.0333333333333);
                    ControleFrame.getPlayDois().setSprit_chute_control(i);
                    ControleFrame.getPlayDois().setIcon(new ImageIcon(Jogador2.getSocarSprites()
                                                      [ControleFrame.getPlayDois().getSprit_chute_control()]));
                    ControleFrame.getPlayDois().setLocation(Math.round(ControleFrame.getPlayDois().getX() + vlc), 
                                                        ControleFrame.getPlayDois().getY());
                    Thread.sleep(10);
                } catch (InterruptedException e1) {

                    e1.printStackTrace();
                }
            }
            ControleFrame.getPlayDois().setSprit_andar_control(0);
            ControleFrame.getPlayDois().setIcon(new ImageIcon(Jogador2.getAndarSprites()[ControleFrame.getPlayDois().getSprit_andar_control()]));
            chute(ControleFrame.getJogador2());
        }
        ControleFrame.setAcao2();
    }

    public static void soco(Runnable jogador){
        try {
            jogador.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        colision_check(ControleFrame.getPlayDois(), ControleFrame.getPlayUm(),
                        ControleFrame.getPersonagem2().getsoco());
        jogador.notify();
    }

    public static void chute(Runnable jogador){
        try {
            jogador.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        colision_check(ControleFrame.getPlayDois(), ControleFrame.getPlayUm(),
                        ControleFrame.getPersonagem2().getChute());
        jogador.notify();
    }

    public static int colision_check(JLabel LA, JLabel LB, int forca)
		{
			//Coleta informações do primeiro jogador
			int label_A_x = LA.getX();
			int label_A_y = LA.getY();
			int label_A_h = LA.getHeight();
			int label_A_w = LA.getWidth();

			//Coleta informações do segundo
			int label_B_x = LB.getX();
			int label_B_y= LB.getY();
			int label_B_h = LB.getHeight();
			int label_B_w = LB.getWidth();

			//Realiza as verificações para ver se existi colisão
			if (label_A_x < label_B_x + label_B_w &&
			label_A_x + label_A_w > label_B_x &&
			label_A_y < label_B_y + label_B_h &&
			label_A_y + label_A_h > label_B_y) {
				//Houve colisão

				TelaLuta.getLifebar1().setSize(TelaLuta.getLifebar1().getWidth()-forca, TelaLuta.getLifebar1().getHeight());
				return 1;
			}
			//não houve colisão
			return 0;

	}

}
