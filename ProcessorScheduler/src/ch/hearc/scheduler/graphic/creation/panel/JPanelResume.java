
package ch.hearc.scheduler.graphic.creation.panel;

import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import ch.hearc.scheduler.graphic.creation.JPanelCreation;
import ch.hearc.scheduler.tools.Ordonnanceur;
import ch.hearc.scheduler.tools.Processus;
import ch.hearc.scheduler.tools.ProcessusTableModel;

public class JPanelResume extends JPanel
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JPanelResume(JPanelCreation jPanelCreation)
		{
		this.jPanelCreation = jPanelCreation;

		geometry();
		control();
		appearance();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	public void refresh()
		{
		this.ordonnanceur = this.jPanelCreation.getOrdonnanceur();

		Processus p = this.ordonnanceur.getListProcessus().get(this.ordonnanceur.getListProcessus().size()-1);
		this.processusTableModel.addProcessus(p);
		}

	/*------------------------------*\
	|*				Set				*|
	\*------------------------------*/

	public void setOrdonnanceur(Ordonnanceur ordonnanceur)
		{
		this.ordonnanceur = ordonnanceur;
		this.jLabelOrdonnanceur.setText(ordonnanceur.getName());
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
		this.jLabelOrdonnanceur = new JLabel();
		this.processusTableModel = new ProcessusTableModel();
		this.jTableProcessus = new JTable(this.processusTableModel);

		jTableProcessus.setPreferredScrollableViewportSize(jTableProcessus.getPreferredSize());
		jTableProcessus.setFillsViewportHeight(true);

			// Layout : Specification
			{
			FlowLayout flowlayout = new FlowLayout(FlowLayout.CENTER);
			setLayout(flowlayout);

			// flowlayout.setHgap(20);
			// flowlayout.setVgap(20);
			}

		// JComponent : add
		this.add(this.jLabelOrdonnanceur);
		this.add(new JScrollPane(this.jTableProcessus));
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
	private JTable jTableProcessus;
	private ProcessusTableModel processusTableModel;

	}
