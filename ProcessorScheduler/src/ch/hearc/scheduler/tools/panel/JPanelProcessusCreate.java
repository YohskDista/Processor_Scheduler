package ch.hearc.scheduler.tools.panel;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ch.hearc.scheduler.graphic.creation.panel.JPanelResume;
import ch.hearc.scheduler.tools.Processus;

public class JPanelProcessusCreate extends JPanel
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JPanelProcessusCreate(JPanelResume jPanelResume, Processus processus)
		{
		this.jPanelResume = jPanelResume;
		this.processus = processus;

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
		this.jLabelProcess = new JLabel(this.processus.getNom());
		this.jButtonColor = new JButton();
		this.jButtonDelete = new JButton();

		this.jButtonColor.setBackground(this.processus.getColor());
		this.jButtonColor.setForeground(this.processus.getColor());
		this.jButtonColor.setEnabled(false);
		this.jButtonColor.setSize(100, 50);
		this.jButtonColor.setPreferredSize(new Dimension(60, 20));

		this.jButtonDelete.setText("X");

			// Layout : Specification
			{
			FlowLayout flowlayout = new FlowLayout(FlowLayout.CENTER);
			setLayout(flowlayout);

			// flowlayout.setHgap(20);
			// flowlayout.setVgap(20);
			}

		// JComponent : add
		this.add(this.jLabelProcess);
		this.add(this.jButtonColor);
		this.add(this.jButtonDelete);
		}

	private void control()
		{
		this.jButtonDelete.addActionListener(new ActionListener()
			{

				@Override
				public void actionPerformed(ActionEvent e)
					{
					deleteProcessus();
					}
			});
		}

	private void appearance()
		{
		// rien
		}

	private void deleteProcessus()
	{
	this.jPanelResume.deleteProcessus(this, processus);
	}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Input
	private JPanelResume jPanelResume;
	private Processus processus;

	// Tools
	private JLabel jLabelProcess;
	private JButton jButtonDelete;
	private JButton jButtonColor;


	}
