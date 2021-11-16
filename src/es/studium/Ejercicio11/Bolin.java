package es.studium.Ejercicio11;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Bolin
{
	private int x, y;
	private Color color;
	public Bolin(int xx, int yy, Color c)
	{
		this.x = xx;
		this.y = yy;
		this.color = c;
	}
	public void mover(int direccion)
	{
		switch(direccion)
		{
		case 0:
			if(x<450)
				x+=5;
			break;
		case 1:
			if(y<550)
				y+=5;
			break;
		case 2:
			if(x>0)
				x-=5;
			break;
		case 3:
			if(y>0)
				y-=5;

			break;
		}
	}
	public void pinta(Graphics g)
	{
		Graphics2D g2d = (Graphics2D)g;
		g2d.setColor(color);
		g2d.fillOval(x, y, 25, 25);
	}
	//En que posición se está
	
	public int dameX() {
		return(this.x);
	}
	public int dameY() {
		return(this.y);
	}
}