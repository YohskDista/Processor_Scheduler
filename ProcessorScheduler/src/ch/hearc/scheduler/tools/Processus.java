
package ch.hearc.scheduler.tools;

import java.awt.Color;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;

public class Processus
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public Processus(String nom, int nbRafale, int arrive, int rafaleActuel, Color color)
		{
		this.nom = nom;
		this.nbRafale = nbRafale;
		this.arrive = arrive;
		this.rafaleActuel = rafaleActuel;
		this.etat = Etat.READY;
		this.color = color;
		}

	public Processus(String nom, int nbRafale, int arrive, Color color)
		{
		this(nom, nbRafale, arrive, 0, color);
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	public Box showRafale(int index)
		{
		JLabel label = new JLabel(index + "");
		JButton button = new JButton();
		button.setBackground(color);
		button.setEnabled(false);

		Box box = Box.createVerticalBox();
		box.add(button);
		box.add(label);

		return box;
		}

	@Override
	public String toString()
		{
		StringBuilder builder = new StringBuilder();
		builder.append("Processus [nom=");
		builder.append(this.nom);
		builder.append(", nbRafale=");
		builder.append(this.nbRafale);
		builder.append(", arrive=");
		builder.append(this.arrive);
		builder.append(", rafaleActuel=");
		builder.append(this.rafaleActuel);
		builder.append(", color=");
		builder.append(this.color);
		builder.append(", etat=");
		builder.append(this.etat);
		builder.append("]");
		return builder.toString();
		}

	/*------------------------------*\
	|*				Set				*|
	\*------------------------------*/

	public void setNom(String nom)
		{
		this.nom = nom;
		}

	public void setNbRafale(int nbRafale)
		{
		this.nbRafale = nbRafale;
		}

	public void setArrive(int arrive)
		{
		this.arrive = arrive;
		}

	public void setRafaleActuel(int rafaleActuel)
		{
		this.rafaleActuel = rafaleActuel;
		}

	public void setEtat(Etat etat)
		{
		this.etat = etat;
		}

	public void setColor(Color color)
		{
		this.color = color;
		}

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	public String getNom()
		{
		return this.nom;
		}

	public int getNbRafale()
		{
		return this.nbRafale;
		}

	public int getArrive()
		{
		return this.arrive;
		}

	public int getRafaleActuel()
		{
		return this.rafaleActuel;
		}

	public Etat getEtat()
		{
		return this.etat;
		}

	public Color getColor()
		{
		return this.color;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Input
	private String nom;
	private int nbRafale;
	private int arrive;
	private int rafaleActuel;
	private Color color;

	// Tools
	private Etat etat;

	}
