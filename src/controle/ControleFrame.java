package src.controle;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import src.modelo.Personagem;
import src.visao.Jogador1;
import src.visao.Jogador2;
import src.visao.TelaIni;
import src.visao.TelaLuta;
public class ControleFrame extends JFrame implements KeyListener, MouseListener{

    private static Jogador1 playUm;
    private static Jogador2 playDois;
	private static Personagem personagemUm;
	private static Personagem personagemDois;
	private static int clique = 0;
	private static int acao1 = 0;
	private static int acao2 = 0;
	private static Runnable jogador1 = new Runnable() {
		public void run() {
			try{
				controleEventos1(acao1);
			} catch (Exception e){}
		}
	};
	private static Runnable jogador2 = new Runnable() {
		public void run() {
			try{
				controleEventos2(acao2);
			} catch (Exception e){}
		}
	};

    public ControleFrame(){

        this.setVisible(true);
		this.setSize(800, 600);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setContentPane(TelaIni.criarTela());
		repaint();
        this.addKeyListener(this);
        this.addMouseListener(this);

    }

    public static void main (String[] args) {
		new ControleFrame();
		executaThread();
	}

	public static void executaThread(){
		jogador1.run();
		jogador2.run();
	}
    
	public static Jogador1 getPlayUm() {
		if (playUm == null){
			playUm = new Jogador1();
		}
		return playUm;
	}
	public static void setPlayUm(Jogador1 playUm) {
		ControleFrame.playUm = playUm;
	}
	public static Jogador2 getPlayDois() {
		if (playDois == null){
			playDois = new Jogador2();
		}
		return playDois;
	}
	public static void setPlayDois(Jogador2 playDois) {
		ControleFrame.playDois = playDois;
	}
	public static Runnable getJogador1(){
		return jogador1;
	}
	public static Runnable getJogador2(){
		return jogador2;
	}

	public static Personagem getPersonagem1(){
		return personagemUm;
	}

	public static Personagem getPersonagem2(){
		return personagemDois;
	}

	public static void setAcao1(){
		ControleFrame.acao1 = 0;
	}

	public static void setAcao2(){
		ControleFrame.acao2 = 0;
	}

	public static void controleEventos1(int acao){
		EventosJogador1.eventosJogador1(acao);
	}

	public static void controleEventos2(int acao){
		EventosJogador2.eventosJogador2(acao);
	}

	@Override
	public void keyPressed(KeyEvent e) {
        //Eventos Jogador 1
		if (e.getKeyCode() == KeyEvent.VK_D) {
			acao1 = 1;
		}
		else if(e.getKeyCode() == KeyEvent.VK_A){
			acao1 = 2;
		}
		else if(e.getKeyCode() == KeyEvent.VK_S) {
			acao1 = 3;
		}
		else if(e.getKeyCode() == KeyEvent.VK_W){
			acao1 = 4;
		}
		else if(e.getKeyCode() == KeyEvent.VK_Q){
			acao1 = 5;
		}
		else if(e.getKeyCode() == KeyEvent.VK_E){
			acao1 = 6;
		}
		//Eventos jogador dois
        else if (e.getKeyCode() == KeyEvent.VK_KP_RIGHT) {
			acao2 = 1;
		}
		else if(e.getKeyCode() == KeyEvent.VK_LEFT){
			acao2 = 2;
		}
		else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			acao2 = 3;
		}
		else if(e.getKeyCode() == KeyEvent.VK_UP){
			acao2 = 4;
		}
		else if(e.getKeyCode() == KeyEvent.VK_SHIFT){
			acao2 = 5;
		}
		else if(e.getKeyCode() == KeyEvent.VK_SEMICOLON){
			acao2 = 6;
		}
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getX() >= 300 && e.getX() <= 400 && e.getY() >= 250 && e.getY() <= 350){
			if (clique == 0){
				personagemUm = new Personagem(15, 20, 120, Personagem.getOverall(), "P1");
			}
			else{
				personagemDois = new Personagem(15, 20, 120, Personagem.getOverall(), "P1");
			}
			clique += 1;
        }
        else if(e.getX() >= 410 && e.getX() <= 560 && e.getY() >= 250 && e.getY() <= 350){
			if (clique == 0){
				personagemUm = new Personagem(20, 5, 100, Personagem.getOverall(), "P2");
			}
			else{
				personagemDois = new Personagem(20, 5, 100, Personagem.getOverall(), "P2");
			}
			clique += 1;
        }
        else if(e.getX() >= 300 && e.getX() <= 400 && e.getY() >= 360 && e.getY() <= 470){
			if (clique == 0){
				personagemUm = new Personagem(25, 10, 170, Personagem.getOverall(), "P3");
			}
			else{
				personagemDois = new Personagem(25, 10, 170, Personagem.getOverall(), "P3");
			}
			clique += 1;
        }
        else if(e.getX() >= 410 && e.getX() <= 560 && e.getY() >= 360 && e.getY() <= 470){
			if (clique == 0){
				personagemUm = new Personagem(5, 25, 150, Personagem.getOverall(), "P4");
			}
			else{
				personagemDois = new Personagem(5, 25, 150, Personagem.getOverall(), "P4");
			}
			clique += 1;
        }
		if (clique == 2){
			this.setContentPane(TelaLuta.criarTela());
			repaint();
		}

	}

	@Override
	public void mousePressed(MouseEvent e) {
	}


	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
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
