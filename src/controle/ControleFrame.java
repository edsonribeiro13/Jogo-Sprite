package src.controle;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import src.modelo.Personagem;
import src.visao.Jogador;
import src.visao.TelaIni;
import src.visao.TelaLuta;

enum GameState {
	SELECTPLAYER,
	INGAME,
	END
};

public class ControleFrame extends JFrame implements MouseListener {

	private static Jogador playUm;
	private static Jogador playDois;
	private static Personagem personagemUm;
	private static Personagem personagemDois;
	private static int clique = 0;

	private static GameState controle = GameState.SELECTPLAYER;
	private static KeyInput keyInput = new KeyInput();
	private static JOptionPane jOptionPane;

	public static JOptionPane getjOptionPane() {
		return jOptionPane;
	}

	public static void setjOptionPane(JOptionPane jOptionPane) {
		ControleFrame.jOptionPane = jOptionPane;
	}

	public ControleFrame() {

		this.setVisible(true);
		this.setSize(800, 600);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setContentPane(TelaIni.criarTela());
		repaint();
		this.addKeyListener(keyInput);
		keyInput.runThreads();
		this.addMouseListener(this);
		TelaIni.getLabel1().addMouseListener(this);
		TelaIni.getLabel2().addMouseListener(this);
		TelaIni.getLabel3().addMouseListener(this);
		TelaIni.getLabel4().addMouseListener(this);

	}

	public static Jogador getPlayUm() {
		if (playUm == null) {
			playUm = new Jogador(personagemUm.getNome(), "P1");
			playUm.Parado();
			playUm.setBounds(0, 290, 170, 170);
		}
		return playUm;
	}

	public static void setPlayUm(Jogador playUm) {
		ControleFrame.playUm = playUm;
	}

	public static void setClique(int clique) {
		ControleFrame.clique = clique;
	}

	public static Jogador getPlayDois() {
		if (playDois == null) {
			playDois = new Jogador(personagemDois.getNome(), "P2");
			playDois.Parado();
			playDois.setBounds(700, 290, 170, 170);
		}
		return playDois;
	}

	public static void setPlayDois(Jogador playDois) {
		ControleFrame.playDois = playDois;
	}

	public static Personagem getPersonagem1() {
		return personagemUm;
	}

	public static Personagem getPersonagem2() {
		return personagemDois;
	}

	public static void setControle(GameState gs) {
		ControleFrame.controle = gs;
	}

	public static GameState getControle() {
		return ControleFrame.controle;
	}

	@Override
	public void mouseClicked(MouseEvent e) {

		if (ControleFrame.getControle() == GameState.SELECTPLAYER) {
			if (e.getSource() == TelaIni.getLabel1()) {
				if (clique == 0) {
					personagemUm = new Personagem(15, 20, 120, Personagem.getOverall(), "eagle");
				} else {
					personagemDois = new Personagem(15, 20, 120, Personagem.getOverall(), "eagle");
				}
				clique += 1;
			} else if (e.getSource() == TelaIni.getLabel2()) {
				if (clique == 0) {
					personagemUm = new Personagem(20, 5, 100, Personagem.getOverall(), "raiden");
				} else {
					personagemDois = new Personagem(20, 5, 100, Personagem.getOverall(), "raiden");
				}
				clique += 1;
			} else if (e.getSource() == TelaIni.getLabel3()) {
				if (clique == 0) {
					personagemUm = new Personagem(25, 10, 170, Personagem.getOverall(), "scorpion");
				} else {
					personagemDois = new Personagem(25, 10, 170, Personagem.getOverall(), "scorpion");
				}
				clique += 1;
			} else if (e.getSource() == TelaIni.getLabel4()) {
				if (clique == 0) {
					personagemUm = new Personagem(5, 25, 150, Personagem.getOverall(), "subzero");
				} else {
					personagemDois = new Personagem(5, 25, 150, Personagem.getOverall(), "subzero");
				}
				clique += 1;
			}
			if (clique == 2) {
				this.setContentPane(TelaLuta.criarTela());
			}
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

	static void resetTheGame(JLabel comp) {
		JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(comp);
		ControleFrame.setClique(0);
		ControleFrame.setControle(GameState.SELECTPLAYER);
		ControleFrame.setPlayUm(null);
		ControleFrame.setPlayDois(null);
		frame.setContentPane(TelaIni.criarTela());
	}

	public static void main(String[] args) {
		new ControleFrame();
	}

}
