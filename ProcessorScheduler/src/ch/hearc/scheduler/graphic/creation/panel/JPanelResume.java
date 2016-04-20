
package ch.hearc.scheduler.graphic.creation.panel;

import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ch.hearc.scheduler.graphic.creation.JPanelCreation;
import ch.hearc.scheduler.tools.Ordonnanceur;
import ch.hearc.scheduler.tools.Processus;
import ch.hearc.scheduler.tools.panel.JPanelProcessusCreate;

public class JPanelResume extends JPanel
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JPanelResume(JPanelCreation jPanelCreation)
		{
		this.jPanelCreation = jPanelCreation;
		this.listJPanelProcessusCreates = new ArrayList<JPanelProcessusCreate>();

		geometry();
		control();
		appearance();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	public void deleteProcessus(JPanelProcessusCreate jPanelProcessusCreate, Processus processus)
		{
		this.boxV.remove(jPanelProcessusCreate);
		this.listJPanelProcessusCreates.remove(jPanelProcessusCreate);
		this.jPanelCreation.deleteProcessus(processus);

		this.revalidate();
		}

	public void addProcessus(Processus processus)
		{
		JPanelProcessusCreate jPanelProcessusCreate = new JPanelProcessusCreate(this, processus);
		this.listJPanelProcessusCreates.add(jPanelProcessusCreate);

		this.boxV.add(jPanelProcessusCreate);
		this.revalidate();
		}

	/*------------------------------*\
	|*				Set				*|
	\*------------------------------*/

	public void setOrdonnanceur(Ordonnanceur ordonnanceur)
		{
		this.ordonnanceur = ordonnanceur;
		this.jLabelOrdonnanceur.setText(ordonnanceur.getName());
		this.erase();
		}

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private void erase()
		{
		for(JPanelProcessusCreate jPanelProcessusCreate:listJPanelProcessusCreates)
			{
			this.boxV.remove(jPanelProcessusCreate);
			}

		this.listJPanelProcessusCreates = new ArrayList<JPanelProcessusCreate>();
		revalidate();
		}

	private void geometry()
		{
		// JComponent : Instanciation
		this.jLabelOrdonnanceur = new JLabel();

			// Layout : Specification
			{
			this.boxV = Box.createVerticalBox();

			// flowlayout.setHgap(20);
			// flowlayout.setVgap(20);
			}

		// JComponent : add
		boxV.add(this.jLabelOrdonnanceur);

		for(JPanelProcessusCreate jPanelProcessusCreate:listJPanelProcessusCreates)
			{
			boxV.add(jPanelProcessusCreate);
			}

		this.add(boxV);
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
	private JPanelCreation jPanelCreation;

	// Tools
	private Ordonnanceur ordonnanceur;
	private JLabel jLabelOrdonnanceur;
	private List<JPanelProcessusCreate> listJPanelProcessusCreates;

	private Box boxV;

	}
