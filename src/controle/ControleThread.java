package src.controle;

public class ControleThread {

    public static void soco(Runnable jogador){
        jogador.run();
        try {
            jogador.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (ControleFrame.getPlayUm().getX() == ControleFrame.getPlayDois().getX()){
            System.out.println("HIT");
        }
        jogador.notify();
    }

    public static void chute(Runnable jogador){
        jogador.run();
        try {
            jogador.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (ControleFrame.getPlayUm().getX() == ControleFrame.getPlayDois().getX()){
            System.out.println("HIT");
        }
        jogador.notify();
    }
}
