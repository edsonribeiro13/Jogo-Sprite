package src.controle;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.concurrent.Executor;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import src.modelo.Personagem;
import src.visao.Jogador;
import src.visao.TelaIni;
import src.visao.TelaLuta;
public class ControleFrame extends JFrame implements KeyListener, MouseListener{

    private static Jogador playUm = new Jogador();
    private static Jogador playDois = new Jogador();
	private static Personagem personagemUm;
	private static Personagem personagemDois;
	private static int clique = 0;
    private static char pulo = '0';
	private static char pulo2 = '0';

    public ControleFrame(){

        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setContentPane(TelaIni.criarTela());
        this.addKeyListener(this);
        this.addMouseListener(this);

        while(true){

			float speed = 0, speed2 = 0;

            try {

				Thread.sleep(10);
				speed += (1 * 0.0333333333333);
				playUm.setLocation(playUm.getLocation().x, Math.round(playUm.getY() + speed));

				if(pulo == 'w') {
					playUm = Jogador.pular();
					pulo();
					playUm = Jogador.andar();
					pulo = '5';
				}
				if (playUm.getY() > 500)
				{
					playUm.setLocation(playUm.getX(), 500);
					speed = 0;
				}

			} catch (InterruptedException e1) {

				e1.printStackTrace();
			}

			try {

				Thread.sleep(10);
				speed2 += (1 * 0.0333333333333);
				playDois.setLocation(playDois.getLocation().x, Math.round(playDois.getY() + speed2));

				if(pulo2 == 'w') {
					playDois = Jogador.pular();
					pulo();
					playDois = Jogador.andar();
					pulo2 = '5';
				}
				if (playDois.getY() > 500)
				{
					playDois.setLocation(playDois.getX(), 500);
					speed2 = 0;
				}

			} catch (InterruptedException e1) {

				e1.printStackTrace();
			}
        }

    }

    public static void main (String[] args) {
		new ControleFrame();
	}

    public void pulo() {
		float vlc = 0;
		
		for (int i = 0 ; i < 15; i++) {
			try {
				vlc += -(10 * 0.0333333333333);
				playUm.setLocation(playUm.getLocation().x, Math.round(playUm.getY() + vlc));
				Thread.sleep(10);
				repaint();
				
			} catch (InterruptedException e1) {

				e1.printStackTrace();
			}
		}
		
	}
    
	public static Jogador getPlayUm() {
		return playUm;
	}
	public static void setPlayUm(Jogador playUm) {
		ControleFrame.playUm = playUm;
	}
	public static Jogador getPlayDois() {
		return playDois;
	}
	public static void setPlayDois(Jogador playDois) {
		ControleFrame.playDois = playDois;
	}


	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
        //Eventos Jogador 1
		if (e.getKeyCode() == KeyEvent.VK_D) {
			playUm.setLocation(playUm.getLocation().x + 5, playUm.getLocation().y);
			if(playUm.getSprit_andar_control() < 9)
			{
				playUm.setIcon(new ImageIcon(Jogador.getAndarSprites()[playUm.getSprit_andar_control()]));
				playUm.setSprit_andar_control(playUm.getSprit_andar_control() + 1);
			}else
			{

				playUm.setSprit_andar_control(0);
				playUm.setIcon(new ImageIcon(Jogador.getAndarSprites()[playUm.getSprit_andar_control()]));
				
			}

		}
		else if(e.getKeyCode() == KeyEvent.VK_A){
			playUm.setLocation(playUm.getLocation().x - 5, playUm.getLocation().y);
		}
		else if(e.getKeyCode() == KeyEvent.VK_S) {
			
			playUm.setLocation(playUm.getLocation().x, playUm.getLocation().y + 5);
			
		}
		else if(e.getKeyCode() == KeyEvent.VK_W){
			pulo = 'w';
		}
		else if(e.getKeyCode() == KeyEvent.VK_Q){
			Runnable jogador = new Runnable() {
				public void run() {
					try{
						EventosJogador2.eventosJogador2(0);
					} catch (Exception e){}
				}
			};
			ControleThread.soco(jogador);
		}
		else if(e.getKeyCode() == KeyEvent.VK_E){
			Runnable jogador = new Runnable() {
				public void run() {
					try{
						EventosJogador2.eventosJogador2(0);
					} catch (Exception e){}
				}
			};
			ControleThread.chute(jogador);
		}
		//Eventos jogador dois
        else if (e.getKeyCode() == KeyEvent.VK_KP_RIGHT) {
			playDois.setLocation(playDois.getLocation().x + 5, playDois.getLocation().y);
			if(playDois.getSprit_andar_control() < 9)
			{
				playDois.setIcon(new ImageIcon(Jogador.getAndarSprites()[playDois.getSprit_andar_control()]));
				playDois.setSprit_andar_control(playDois.getSprit_andar_control() + 1);
			}else
			{

				playDois.setSprit_andar_control(0);
				playDois.setIcon(new ImageIcon(Jogador.getAndarSprites()[playDois.getSprit_andar_control()]));
				
			}

		}
		else if(e.getKeyCode() == KeyEvent.VK_LEFT){
			playDois.setLocation(playDois.getLocation().x - 5, playDois.getLocation().y);
		}
		else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			
			playDois.setLocation(playDois.getLocation().x, playDois.getLocation().y + 5);
			
		}
		else if(e.getKeyCode() == KeyEvent.VK_UP){
			pulo2 = 'w';
		}
		else if(e.getKeyCode() == KeyEvent.VK_SHIFT){
			Runnable jogador = new Runnable() {
				public void run() {
					try{
						EventosJogador1.eventosJogador1(0);
					} catch (Exception e){}
				}
			};
			ControleThread.soco(jogador);
		}
		else if(e.getKeyCode() == KeyEvent.VK_SEMICOLON){
			Runnable jogador = new Runnable() {
				public void run() {
					try{
						EventosJogador1.eventosJogador1(0);
					} catch (Exception e){}
				}
			};
			ControleThread.chute(jogador);
		}
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		if(e.getSource() == TelaIni.getLabel1()){
			if (clique == 0){
				personagemUm = new Personagem(15, 20, 120, Personagem.getOverall(), "P1");
			}
			else{
				personagemDois = new Personagem(15, 20, 120, Personagem.getOverall(), "P1");
			}
			clique += 1;
        }
        else if(e.getSource() == TelaIni.getLabel2()){
			if (clique == 0){
				personagemUm = new Personagem(20, 5, 100, Personagem.getOverall(), "P2");
			}
			else{
				personagemDois = new Personagem(20, 5, 100, Personagem.getOverall(), "P2");
			}
			clique += 1;
        }
        else if(e.getSource() == TelaIni.getLabel3()){
			if (clique == 0){
				personagemUm = new Personagem(25, 10, 170, Personagem.getOverall(), "P3");
			}
			else{
				personagemDois = new Personagem(25, 10, 170, Personagem.getOverall(), "P3");
			}
			clique += 1;
        }
        else if(e.getSource() == TelaIni.getLabel4()){
			if (clique == 0){
				personagemUm = new Personagem(5, 25, 150, Personagem.getOverall(), "P4");
			}
			else{
				personagemDois = new Personagem(5, 25, 150, Personagem.getOverall(), "P4");
			}
			clique += 1;
		if (clique == 2)
			this.setContentPane(TelaLuta.criarTela());
        }

	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
