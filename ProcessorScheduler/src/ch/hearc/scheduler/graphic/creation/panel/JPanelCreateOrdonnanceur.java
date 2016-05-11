
package ch.hearc.scheduler.graphic.creation.panel;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ch.hearc.scheduler.graphic.creation.JPanelCreation;
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

	public JPanelCreateOrdonnanceur(JPanelCreation jPanelCreation)
		{
		this.jPanelCreation = jPanelCreation;

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
		this.jLabelQuantum = new JLabel("Quantum : ");
		this.jTextFieldQuantum = new JTextField();

		this.boxVQuantum = Box.createHorizontalBox();
		this.boxVQuantum.add(jLabelQuantum);
		this.boxVQuantum.add(jTextFieldQuantum);

		this.boxVQuantum.setVisible(false);

		this.boxV = Box.createVerticalBox();
		this.boxV.add(this.jComboBoxChooseOrdonnanceur);
		this.boxV.add(this.boxVQuantum);
		this.boxV.add(this.jButtonCreateOrdonnanceur);

		for(Entry<String, Ordonnanceur> entry:mapOrdonnanceur.entrySet())
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
		this.jButtonCreateOrdonnanceur.addMouseListener(new MouseAdapter()
			{

				@Override
				public void mouseClicked(MouseEvent arg0)
					{
					Ordonnanceur ordonnanceur = (Ordonnanceur)jComboBoxChooseOrdonnanceur.getSelectedItem();

					int quantum = 1;
					try
						{
						quantum = Integer.parseInt(jTextFieldQuantum.getText());
						}
					catch (Exception e)
						{
						jTextFieldQuantum.setText("1");
						quantum = 1;
						}

					ordonnanceur.setTimeQuantum(quantum);

					jPanelCreation.setOrdonnanceur(ordonnanceur);
					System.out.println("Création ordonnanceur : " + ordonnanceur);
					}
			});

		this.jComboBoxChooseOrdonnanceur.addActionListener(new ActionListener()
			{

				@Override
				public void actionPerformed(ActionEvent e)
					{
					Ordonnanceur ordonnanceur = (Ordonnanceur)jComboBoxChooseOrdonnanceur.getSelectedItem();
					if (ordonnanceur.getName().equals("Round Robin"))
						{
						boxVQuantum.setVisible(true);
						}
					else
						{
						boxVQuantum.setVisible(false);
						}
					}
			});
		}

	private void appearance()
		{
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Input
	private JPanelCreation jPanelCreation;

	// Tools
	private Map<String, Ordonnanceur> mapOrdonnanceur;

	private JComboBox<Ordonnanceur> jComboBoxChooseOrdonnanceur;
	private JButton jButtonCreateOrdonnanceur;

	private JLabel jLabelQuantum;
	private JTextField jTextFieldQuantum;

	private Box boxV;
	private Box boxVQuantum;

	// Constantes
	private final static int NB_TYPE_ORDONNANCEUR = 4;
	}
