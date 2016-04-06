
package ch.hearc.scheduler.graphic.creation;
import java.awt.BorderLayout;

import javax.swing.Box;
import javax.swing.JPanel;

import ch.hearc.scheduler.graphic.creation.panel.JPanelCreateOrdonnanceur;
import ch.hearc.scheduler.graphic.creation.panel.JPanelCreateProcessus;
import ch.hearc.scheduler.graphic.visualization.JPanelVisualization;
import ch.hearc.scheduler.tools.Ordonnanceur;
import ch.hearc.scheduler.tools.Processus;


public class JPanelCreation extends JPanel
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JPanelCreation(JPanelVisualization jPanelVisualization)
		{
		this.jPanelVisualization = jPanelVisualization;

		geometry();
		control();
		appearance();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	public void addProcessus(Processus processus)
		{
		this.jPanelVisualization.addProcessus(processus);
		}

	/*------------------------------*\
	|*				Set				*|
	\*------------------------------*/

	public void setOrdonnanceur(Ordonnanceur ordonnanceur)
		{
		this.jPanelVisualization.setOrdonnanceur(ordonnanceur);
		}

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private void geometry()
		{
		// JComponent : Instanciation
		this.jPanelCreateOrdonnanceur = new JPanelCreateOrdonnanceur(this);
		this.jPanelCreateProcessus = new JPanelCreateProcessus(this);

		this.boxV = Box.createVerticalBox();

		this.boxV.add(jPanelCreateOrdonnanceur);
		this.boxV.add(jPanelCreateProcessus);

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

	// Input
	private JPanelVisualization jPanelVisualization;

	// Tools
	private JPanelCreateOrdonnanceur jPanelCreateOrdonnanceur;
	private JPanelCreateProcessus jPanelCreateProcessus;
	private Box boxV;

	}
