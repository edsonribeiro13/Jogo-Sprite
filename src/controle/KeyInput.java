package src.controle;

import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;

public class KeyInput extends KeyAdapter {

	private EventosJogador1 eventosJogador1;
	private EventosJogador2 eventosJogador2;

	// top, right, down, left, Q, E
	private boolean[] movieDirectionForPlayer1 = {
			false,
			false,
			false,
			false,
			false,
			false
	};
	// top, right, down, left, shift, semicolon
	private boolean[] movieDirectionForPlayer2 = {
			false,
			false,
			false,
			false,
			false,
			false
	};

	@Override
	public void keyReleased(KeyEvent e) {
		if (ControleFrame.getControle() != GameState.END) {
			if (e.getKeyCode() == KeyEvent.VK_UP)
				movieDirectionForPlayer1[0] = false;
			if (e.getKeyCode() == KeyEvent.VK_RIGHT)
				movieDirectionForPlayer1[1] = false;
			if (e.getKeyCode() == KeyEvent.VK_DOWN)
				movieDirectionForPlayer1[2] = false;
			if (e.getKeyCode() == KeyEvent.VK_LEFT)
				movieDirectionForPlayer1[3] = false;
			if (e.getKeyCode() == KeyEvent.VK_SHIFT)
				movieDirectionForPlayer1[4] = true;
			if (e.getKeyCode() == KeyEvent.VK_SEMICOLON)
				movieDirectionForPlayer1[5] = true;

			if (e.getKeyCode() == KeyEvent.VK_W)
				movieDirectionForPlayer2[0] = false;
			if (e.getKeyCode() == KeyEvent.VK_D)
				movieDirectionForPlayer2[1] = false;
			if (e.getKeyCode() == KeyEvent.VK_S)
				movieDirectionForPlayer2[2] = false;
			if (e.getKeyCode() == KeyEvent.VK_A)
				movieDirectionForPlayer2[3] = false;
			if (e.getKeyCode() == KeyEvent.VK_Q)
				movieDirectionForPlayer2[4] = true;
			if (e.getKeyCode() == KeyEvent.VK_E)
				movieDirectionForPlayer2[5] = true;

			eventosJogador1.setMovieDirection(movieDirectionForPlayer1);
			eventosJogador2.setMovieDirection(movieDirectionForPlayer2);
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (ControleFrame.getControle() != GameState.END) {
			if (e.getKeyCode() == KeyEvent.VK_UP)
				movieDirectionForPlayer1[0] = true;
			if (e.getKeyCode() == KeyEvent.VK_RIGHT)
				movieDirectionForPlayer1[1] = true;
			if (e.getKeyCode() == KeyEvent.VK_DOWN)
				movieDirectionForPlayer1[2] = true;
			if (e.getKeyCode() == KeyEvent.VK_LEFT)
				movieDirectionForPlayer1[3] = true;

			if (e.getKeyCode() == KeyEvent.VK_W)
				movieDirectionForPlayer2[0] = true;
			if (e.getKeyCode() == KeyEvent.VK_D)
				movieDirectionForPlayer2[1] = true;
			if (e.getKeyCode() == KeyEvent.VK_S)
				movieDirectionForPlayer2[2] = true;
			if (e.getKeyCode() == KeyEvent.VK_A)
				movieDirectionForPlayer2[3] = true;

			eventosJogador1.setMovieDirection(movieDirectionForPlayer1);
			eventosJogador2.setMovieDirection(movieDirectionForPlayer2);
		}
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	public EventosJogador1 getEventosJogador1() {
		if (eventosJogador1 == null) {
			eventosJogador1 = new EventosJogador1();
		}
		return eventosJogador1;
	}

	public void setEventosJogador1(EventosJogador1 eventosJogador1) {
		this.eventosJogador1 = eventosJogador1;
	}

	public EventosJogador2 getEventosJogador2() {
		if (eventosJogador2 == null) {
			eventosJogador2 = new EventosJogador2();
		}
		return eventosJogador2;
	}

	public void setEventosJogador2(EventosJogador2 eventosJogador2) {
		this.eventosJogador2 = eventosJogador2;
	}

	public void runThreads() {

		new Thread(getEventosJogador1()).start();
		new Thread(getEventosJogador2()).start();
	}

}
