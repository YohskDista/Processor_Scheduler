package ch.hearc.scheduler.graphic.creation.panel;

import java.awt.Color;
import java.awt.FlowLayout;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

import ch.hearc.scheduler.tools.FCFS;
import ch.hearc.scheduler.tools.Ordonnanceur;
import ch.hearc.scheduler.tools.Round_Robin;
import ch.hearc.scheduler.tools.SJF_NonPreemptif;
import ch.hearc.scheduler.tools.SJF_Preemptif;

public class JPanelCreateOrdonnanceur extends JPanel
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JPanelCreateOrdonnanceur()
		{
		createListOrdonnanceur();

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

	private void createListOrdonnanceur()
		{
		this.mapOrdonnanceur = new HashMap<String, Ordonnanceur>(NB_TYPE_ORDONNANCEUR);

		this.mapOrdonnanceur.put("FCFS", new FCFS("FCFS"));
		this.mapOrdonnanceur.put("SJF non Préemptif", new SJF_NonPreemptif("SJF non Préemptif"));
		this.mapOrdonnanceur.put("SJF Préemptif", new SJF_Preemptif("SJF Préemptif"));
		this.mapOrdonnanceur.put("Round Robin", new Round_Robin("Round Robin"));
		}

	private void geometry()
		{
			// JComponent : Instanciation
		this.jComboBoxChooseOrdonnanceur = new JComboBox<Ordonnanceur>();
		this.jButtonCreateOrdonnanceur = new JButton("Créer");

		this.boxV = Box.createVerticalBox();
		this.boxV.add(this.jComboBoxChooseOrdonnanceur);
		this.boxV.add(this.jButtonCreateOrdonnanceur);

		for(Entry<String, Ordonnanceur> entry : mapOrdonnanceur.entrySet())
			{
			this.jComboBoxChooseOrdonnanceur.addItem(entry.getValue());
			}

			// Layout : Specification
			{
			FlowLayout flowlayout = new FlowLayout(FlowLayout.CENTER);
			setLayout(flowlayout);

			// flowlayout.setHgap(20);
			// flowlayout.setVgap(20);
			}

		// JComponent : add
		this.add(this.boxV);
		}

	private void control()
		{
		// rien
		}

	private void appearance()
		{
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Tools
	private Map<String, Ordonnanceur> mapOrdonnanceur;

	private JComboBox<Ordonnanceur> jComboBoxChooseOrdonnanceur;
	private JButton jButtonCreateOrdonnanceur;

	private Box boxV;

	// Constantes
	private final static int NB_TYPE_ORDONNANCEUR = 4;
	}
