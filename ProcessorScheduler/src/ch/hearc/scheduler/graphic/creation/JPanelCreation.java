
package ch.hearc.scheduler.graphic.creation;

import java.awt.BorderLayout;

import javax.swing.Box;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

import ch.hearc.scheduler.graphic.creation.panel.JPanelCreateOrdonnanceur;
import ch.hearc.scheduler.graphic.creation.panel.JPanelCreateProcessus;
import ch.hearc.scheduler.graphic.creation.panel.JPanelResume;
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
		this.jPanelResume.addProcessus(processus);
		}

	public void deleteProcessus(Processus processus)
		{
		this.jPanelVisualization.deleteProcessus(processus);
		}

	/*------------------------------*\
	|*				Set				*|
	\*------------------------------*/

	public void setOrdonnanceur(Ordonnanceur ordonnanceur)
		{
		this.jPanelVisualization.setOrdonnanceur(ordonnanceur);
		this.jPanelResume.setOrdonnanceur(this.jPanelVisualization.getOrdonnanceur());
		}

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	public Ordonnanceur getOrdonnanceur()
		{
		return this.jPanelVisualization.getOrdonnanceur();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private void geometry()
		{
		// JComponent : Instanciation
		this.jPanelCreateOrdonnanceur = new JPanelCreateOrdonnanceur(this);
		this.jPanelCreateProcessus = new JPanelCreateProcessus(this);
		this.jPanelResume = new JPanelResume(this);

		this.jSplitOrdonnProcess = new JSplitPane(JSplitPane.VERTICAL_SPLIT, this.jPanelCreateOrdonnanceur, this.jPanelCreateProcessus);
		this.jSplitOrdonnProcess.setDividerLocation(100);
		this.jSplitResumeOther = new JSplitPane(JSplitPane.VERTICAL_SPLIT, this.jSplitOrdonnProcess, this.jPanelResume);

		this.boxV = Box.createVerticalBox();

		this.boxV.add(jSplitResumeOther);

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
	private JPanelResume jPanelResume;
	private Box boxV;

	private JSplitPane jSplitOrdonnProcess;
	private JSplitPane jSplitResumeOther;

	}
