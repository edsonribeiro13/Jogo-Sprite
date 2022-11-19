package src.controle;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import src.modelo.Personagem;
import src.visao.Jogador1;
import src.visao.Jogador2;
import src.visao.TelaIni;
import src.visao.TelaLuta;

enum GameState {
	SELECTPLAYER,
	INGAME,
	END
};
public class ControleFrame extends JFrame implements MouseListener{

    private static Jogador1 playUm;
    private static Jogador2 playDois;
	private static Personagem personagemUm;
	private static Personagem personagemDois;
	private static int clique = 0;
	private static GameState controle = GameState.SELECTPLAYER;
	private static KeyInput keyInput = new KeyInput();

	public ControleFrame(){

        this.setVisible(true);
		this.setSize(800, 600);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setContentPane(TelaIni.criarTela());
		repaint();
        this.addKeyListener(keyInput);
		keyInput.runThreads();
        this.addMouseListener(this);
    }

    public static void main (String[] args) {
		new ControleFrame(); ;
	}

    
	public static Jogador1 getPlayUm() {
		if (playUm == null){
			playUm = new Jogador1();
			Jogador1.andar(playUm);
			playUm.setBounds(0, 380, 80, 80);
		}
		return playUm;
	}
	public static void setPlayUm(Jogador1 playUm) {
		ControleFrame.playUm = playUm;
	}
	public static Jogador2 getPlayDois() {
		if (playDois == null){
			playDois = new Jogador2();
			Jogador2.andar(playDois);
			playDois.setBounds(400, 380, 80, 80);
		}
		return playDois;
	}
	public static void setPlayDois(Jogador2 playDois) {
		ControleFrame.playDois = playDois;
	}


	public static Personagem getPersonagem1(){
		return personagemUm;
	}

	public static Personagem getPersonagem2(){
		return personagemDois;
	}


	public static void setControle(GameState gs){
		ControleFrame.controle = gs;
	}

	public static GameState getControle()
	{
		return ControleFrame.controle;
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getX() >= 300 && e.getX() <= 400 && e.getY() >= 250 && e.getY() <= 350){
			if (clique == 0){
				personagemUm = new Personagem(15, 20, 120, Personagem.getOverall(), "P1");
			}
			else{
				personagemDois = new Personagem(15, 20, 120, Personagem.getOverall(), "P1LadoB");
			}
			clique += 1;
        }
        else if(e.getX() >= 410 && e.getX() <= 560 && e.getY() >= 250 && e.getY() <= 350){
			if (clique == 0){
				personagemUm = new Personagem(20, 5, 100, Personagem.getOverall(), "P2");
			}
			else{
				personagemDois = new Personagem(20, 5, 100, Personagem.getOverall(), "P2LadoB");
			}
			clique += 1;
        }
        else if(e.getX() >= 300 && e.getX() <= 400 && e.getY() >= 360 && e.getY() <= 470){
			if (clique == 0){
				personagemUm = new Personagem(25, 10, 170, Personagem.getOverall(), "P3");
			}
			else{
				personagemDois = new Personagem(25, 10, 170, Personagem.getOverall(), "P3LadoB");
			}
			clique += 1;
        }
        else if(e.getX() >= 410 && e.getX() <= 560 && e.getY() >= 360 && e.getY() <= 470){
			if (clique == 0){
				personagemUm = new Personagem(5, 25, 150, Personagem.getOverall(), "P4");
			}
			else{
				personagemDois = new Personagem(5, 25, 150, Personagem.getOverall(), "P4LadoB");
			}
			clique += 1;
        }

		if(clique == 1){
			System.out.println("Player 1 selecionado.");
		}
		else if (clique == 2){
			System.out.println("Player 2 selecionado.");
			this.setContentPane(TelaLuta.criarTela());
			setControle(GameState.INGAME);
		}
		

	}

	@Override
	public void mousePressed(MouseEvent e) {
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
