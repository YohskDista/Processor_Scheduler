
package ch.hearc.scheduler.graphic.creation.panel;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.lang.reflect.Field;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import ch.hearc.scheduler.graphic.creation.JPanelCreation;
import ch.hearc.scheduler.tools.Processus;

public class JPanelCreateProcessus extends JPanel
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JPanelCreateProcessus(JPanelCreation jPanelCreation)
		{
		this.jPanelCreation = jPanelCreation;

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
		this.jLabelColor = new JLabel("Couleur : ");

		this.jTextFieldNom = new JTextField("", 8);
		this.jTextFieldArrive = new JTextField("", 8);
		this.jTextFieldRafale = new JTextField("", 8);

		String[] colors = { "Black", "Red", "Green", "Blue", "Yellow" };
		this.jComboBoxColor = new JComboBox<String>(colors);

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
		this.add(this.jLabelColor);
		this.add(this.jComboBoxColor);
		this.add(this.jButtonCreateProcessus);

		this.createConstraint(springLayout, jLabelNom, jTextFieldNom, 5);
		this.createConstraint(springLayout, jLabelArrive, jTextFieldArrive, 30);
		this.createConstraint(springLayout, jLabelRafale, jTextFieldRafale, 55);
		this.createConstraint(springLayout, jLabelColor, jComboBoxColor, 80);

		springLayout.putConstraint(SpringLayout.WEST, jButtonCreateProcessus, 10, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.NORTH, jButtonCreateProcessus, 105, SpringLayout.NORTH, this);
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
						String nom = jTextFieldNom.getText();
						int arrive = Integer.parseInt(jTextFieldArrive.getText());
						int nbRafale = Integer.parseInt(jTextFieldRafale.getText());
						String strColor = (String)jComboBoxColor.getSelectedItem();

						Color color = getColor(strColor.toUpperCase());

						if (arrive >= 0 & nbRafale > 0)
							{
							Processus processus = new Processus(nom, nbRafale, arrive, color);
							jPanelCreation.addProcessus(processus);

							System.out.println("Ajout processus : " + processus);
							}
						else
							{
							System.err.println("Vérifiez vos valeurs d'arrivés et de rafales");
							}
						}
					catch (Exception err)
						{
						System.err.println(err);
						System.out.println("Erreur");
						}
					}
			});
		}

	private void appearance()
		{
		}

	private void createConstraint(SpringLayout springLayout, JComponent jLabel, JComponent jTextField, int space)
		{
		springLayout.putConstraint(SpringLayout.WEST, jLabel, 10, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.NORTH, jLabel, space, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, jTextField, 80, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.NORTH, jTextField, space, SpringLayout.NORTH, this);
		}

	private Color getColor(String strColor)
		{
		Color color = null;
		try
			{
			Field field = Color.class.getField(strColor);
			color = (Color)field.get(null);
			}
		catch (Exception e)
			{
			color = null; // Not defined
			}
		return color;
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Input
	private JPanelCreation jPanelCreation;

	// Tools
	private JLabel jLabelNom;
	private JLabel jLabelArrive;
	private JLabel jLabelRafale;
	private JLabel jLabelColor;

	private JTextField jTextFieldNom;
	private JTextField jTextFieldArrive;
	private JTextField jTextFieldRafale;
	private JComboBox<String> jComboBoxColor;

	private JButton jButtonCreateProcessus;

	}
