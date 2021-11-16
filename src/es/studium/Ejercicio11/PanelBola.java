package es.studium.Ejercicio11;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import javax.swing.JPanel;
public class PanelBola extends JPanel implements Runnable
{
	private static final long serialVersionUID = 1L;
	private int numBolas = 5;

	Thread[] hilosBola;
	Thread hiloBolin;//New 10
	Bola[] bola;
	Bolin bolin;//New 10
	boolean fin = false;//New 11

	public PanelBola()
	{
		hilosBola = new Thread[numBolas];
		hiloBolin = new Thread(this);//New 10
		bolin = new Bolin (400,500, Color.BLACK);//New 10
		bola = new Bola[numBolas];

		for (int i=0;i<hilosBola.length;i++)
		{
			hilosBola[i]= new Thread(this);

			Random aleatorio = new Random();
			int velocidad = aleatorio.nextInt(50);
			int posX=aleatorio.nextInt(250)+50;
			int posY=aleatorio.nextInt(300)+50;
			Color color = new Color(aleatorio.nextInt(254),
					aleatorio.nextInt(254), aleatorio.nextInt(254));
			bola[i]= new Bola(posX, posY, velocidad, color);
		}
		for (int i=0; i<hilosBola.length; ++i)
		{
			hilosBola[i].start();
		}
		hiloBolin.start();//New


		setBackground(Color.white);
	}
	public void run()
	{
		for (int i=0; i<hilosBola.length; ++i)
		{
			while (Thread.currentThread()== (hilosBola[i]) && (!fin))//New 11
			{
				try
				{
					Thread.sleep(bola[i].velocidad());
					bola[i].mover();
				}
				catch (InterruptedException e) {}
				repaint();
			}
		}
	}
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		for(int i=0; i<bola.length;++i)
		{
			bola[i].pinta(g);
		}
		bolin.pinta(g);//New
		g.drawString("Salida", 230, 30); //New 11
	}
	//New metodo

	public void mover (int direccion) {
		//New 11
		int xBolin, yBolin;
		int xBola, yBola;
		xBolin = bolin.dameX();
		yBolin = bolin.dameY();

		if((xBolin>=200)&&(xBolin<=241)&&(yBolin<=20))//Con la salida
		{
			if(!fin) // Para mostrar solo una vez
			{
				System.out.println("Has salido ileso!");
			}
			// Esta sería la forma natural de matar los hilos
			// Pero el método stop() está deprecated
			/*for (int i=0; i<hilosBola.length; ++i)
		{
		hilosBola[i].stop();
		}
		hiloBolin.stop();*/
			
			fin = true;
		}
		else
		{
			for (int i=0; i<hilosBola.length; ++i)
			{
				xBola = bola[i].dameX();
				yBola = bola[i].dameY();
				if((xBolin+12>=xBola-25)&&(yBolin+12>=yBola-25)&&(xBolin-12<=xBola+25)&&(yBolin-12<=yBola+25))
				{
					if(!fin)
					{
						System.out.println("Has muerto!");
					}
					fin = true;
				}
			}
			if(!fin)
			{
				bolin.mover(direccion);
			}
		}
		//New 11
	}
}