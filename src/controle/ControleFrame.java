package src.controle;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import src.visao.JogadorUm;
import src.visao.TelaIni;
import src.visao.JogadorDois;
public class ControleFrame extends JFrame implements KeyListener, MouseListener{

    private static JogadorUm playUm = new JogadorUm();
    private static JogadorDois playDois = new JogadorDois();
    private static char pulo = '0';

    public ControleFrame(){

        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setContentPane(TelaIni.criarTela());
        this.addKeyListener(this);
        this.addMouseListener(this);

        while(true){
            //Adicionar o pulo e o ataque com o tempo correto
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

    public void ataque(){

    }
    
	public static JogadorUm getPlayUm() {
		return playUm;
	}
	public static void setPlayUm(JogadorUm playUm) {
		ControleFrame.playUm = playUm;
	}
	public static JogadorDois getPlayDois() {
		return playDois;
	}
	public static void setPlayDois(JogadorDois playDois) {
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
				playUm.setIcon(new ImageIcon(JogadorUm.getAndarSprites()[playUm.getSprit_andar_control()]));
				playUm.setSprit_andar_control(playUm.getSprit_andar_control() + 1);
			}else
			{

				playUm.setSprit_andar_control(0);
				playUm.setIcon(new ImageIcon(JogadorUm.getAndarSprites()[playUm.getSprit_andar_control()]));
				
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
        //Eventos Jogador 2
		
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

        }
        else if(e.getSource() == TelaIni.getLabel2()){

        }
        else if(e.getSource() == TelaIni.getLabel3()){

        }
        else if(e.getSource() == TelaIni.getLabel4()){

        }
        else if(e.getSource() == TelaIni.getLabel5()){

        }
        else if(e.getSource() == TelaIni.getLabel6()){

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
