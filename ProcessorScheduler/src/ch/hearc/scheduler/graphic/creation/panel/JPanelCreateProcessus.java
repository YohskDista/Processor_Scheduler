
package ch.hearc.scheduler.graphic.creation.panel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import ch.hearc.scheduler.tools.Processus;

public class JPanelCreateProcessus extends JPanel
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JPanelCreateProcessus()
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
		this.jButtonCreateProcessus = new JButton("Créer processus");

		this.jLabelNom = new JLabel("Nom : ");
		this.jLabelArrive = new JLabel("Arrivé : ");
		this.jLabelRafale = new JLabel("Rafale(s) : ");

		this.jTextFieldNom = new JTextField("", 8);
		this.jTextFieldArrive = new JTextField("", 8);
		this.jTextFieldRafale = new JTextField("", 8);

		// Layout : Specification
		SpringLayout springLayout = new SpringLayout();

		setLayout(springLayout);

		// JComponent : add
		this.add(this.jLabelNom);
		this.add(this.jTextFieldNom);
		this.add(this.jLabelArrive);
		this.add(this.jTextFieldArrive);
		this.add(this.jLabelRafale);
		this.add(this.jTextFieldRafale);

		this.createConstraint(springLayout, jLabelNom, jTextFieldNom, 5);
		this.createConstraint(springLayout, jLabelArrive, jTextFieldArrive, 30);
		this.createConstraint(springLayout, jLabelRafale, jTextFieldRafale, 55);
		}

	private void control()
		{
		this.jButtonCreateProcessus.addMouseListener(new MouseAdapter()
			{
				@Override
				public void mouseClicked(MouseEvent e)
					{
					try
						{
						String nom = jLabelNom.getText();
						int arrive = Integer.parseInt(jLabelArrive.getText());
						int nbRafale = Integer.parseInt(jLabelRafale.getText());

						Processus processus = new Processus(nom, nbRafale, arrive);
						}
					catch(Exception err)
						{
						System.out.println("Erreur");
						}
					}
			});
		}

	private void appearance()
		{
		// rien
		}

	private void createConstraint(SpringLayout springLayout, JLabel jLabel, JTextField jTextField, int space)
		{
		springLayout.putConstraint(SpringLayout.WEST, jLabel, 0, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.NORTH, jLabel, space, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, jTextField, 5, SpringLayout.EAST, jLabel);
		springLayout.putConstraint(SpringLayout.NORTH, jTextField, space, SpringLayout.NORTH, this);
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Tools
	private JLabel jLabelNom;
	private JLabel jLabelArrive;
	private JLabel jLabelRafale;

	private JTextField jTextFieldNom;
	private JTextField jTextFieldArrive;
	private JTextField jTextFieldRafale;

	private JButton jButtonCreateProcessus;

	}
