package es.studium.Ejercicio11;


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class PrincipalBola extends JFrame implements KeyListener//New
{
	private static final long serialVersionUID = 1L;
	
	static PanelBola panel = new PanelBola();//New tiene que ser común a todos los hilos que se creen
	
	public PrincipalBola()
	{
		super();
	}

	public static void main(String args[])
	{
		PrincipalBola f = new PrincipalBola();
		f.addKeyListener(f);//New
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setTitle("Bolas");
		f.setContentPane(panel);//New
		f.setSize(500, 600);
		f.setVisible(true);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		
		switch(arg0.getKeyCode()) {
		case 37://Izquierda cursor
			panel.mover(2);
			break;
		case 38:
			panel.mover(3);
			break;
		case 39:
			panel.mover(0);
			break;
		case 40:
			panel.mover(1);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
