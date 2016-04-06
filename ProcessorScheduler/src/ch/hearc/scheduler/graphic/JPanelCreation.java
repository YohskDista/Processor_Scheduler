package ch.hearc.scheduler.graphic;

import java.awt.BorderLayout;

import javax.swing.Box;
import javax.swing.JPanel;

import ch.hearc.scheduler.graphic.creation.JPanelCreateOrdonnanceur;
import ch.hearc.scheduler.graphic.creation.JPanelCreateProcessus;

public class JPanelCreation extends JPanel
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JPanelCreation()
		{
		geometry();
		control();
		appearance();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	/*------------------------------*\
	|*				Set				*|
	\*------------------------------*/

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private void geometry()
		{
			// JComponent : Instanciation
		this.jPanelCreateOrdonnanceur = new JPanelCreateOrdonnanceur();
		this.jPanelCreateProcessus = new JPanelCreateProcessus();

		this.boxV = Box.createVerticalBox();

		this.boxV.add(jPanelCreateOrdonnanceur);
		this.boxV.add(jPanelCreateOrdonnanceur);

		setLayout(new BorderLayout());
		add(boxV, BorderLayout.CENTER);
		}

	private void control()
		{
		// rien
		}

	private void appearance()
		{
		// rien
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Tools
	private JPanelCreateOrdonnanceur jPanelCreateOrdonnanceur;
	private JPanelCreateProcessus jPanelCreateProcessus;
	private Box boxV;

	}
