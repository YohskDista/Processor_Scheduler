
package ch.hearc.scheduler.graphic.visualization;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import ch.hearc.scheduler.graphic.visualization.panel.JPanelAction;
import ch.hearc.scheduler.graphic.visualization.panel.JPanelCommande;
import ch.hearc.scheduler.tools.Ordonnanceur;
import ch.hearc.scheduler.tools.Processus;

public class JPanelVisualization extends JPanel
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JPanelVisualization()
		{
		geometry();
		control();
		appearance();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	public void addProcessus(Processus processus)
		{
		if (this.jPanelAction.getOrdonnanceur() == null) { return; }

		this.jPanelAction.addProcessus(processus);
		}

	public void deleteProcessus(Processus processus)
		{
		if (this.jPanelAction.getOrdonnanceur() == null) { return; }

		this.jPanelAction.deleteProcessus(processus);
		}

	/*------------------------------*\
	|*				Set				*|
	\*------------------------------*/

	public void setOrdonnanceur(Ordonnanceur ordonnanceur)
		{
		this.jPanelAction.setOrdonnanceur(ordonnanceur);
		}

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	public Ordonnanceur getOrdonnanceur()
		{
		return this.jPanelAction.getOrdonnanceur();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private void geometry()
		{
			// JComponent : Instanciation
		this.jPanelAction = new JPanelAction();
		this.jPanelCommande = new JPanelCommande(jPanelAction);

			// Layout : Specification
			{
			BorderLayout borderLayout = new BorderLayout();
			setLayout(borderLayout);

			// flowlayout.setHgap(20);
			// flowlayout.setVgap(20);
			}

		// JComponent : add
		this.add(this.jPanelAction, BorderLayout.CENTER);
		this.add(this.jPanelCommande, BorderLayout.SOUTH);
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
	private JPanelAction jPanelAction;
	private JPanelCommande jPanelCommande;

	}
