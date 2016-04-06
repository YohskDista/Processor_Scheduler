
package ch.hearc.scheduler.graphic.visualization.panel;

import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JPanel;

public class JPanelCommande extends JPanel
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JPanelCommande(JPanelAction jPanelAction)
		{
		this.jPanelAction = jPanelAction;

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
		this.jButtonStart = new JButton("Start");
		this.jButtonResume = new JButton("Pause");
		this.jButtonStop = new JButton("Stop");

			// Layout : Specification
			{
			FlowLayout flowlayout = new FlowLayout(FlowLayout.CENTER);
			setLayout(flowlayout);

			// flowlayout.setHgap(20);
			// flowlayout.setVgap(20);
			}

		// JComponent : add
		this.add(this.jButtonStart);
		this.add(this.jButtonResume);
		this.add(this.jButtonStop);
		}

	private void control()
		{
		this.jButtonStart.addMouseListener(new MouseAdapter()
			{
				@Override
				public void mouseClicked(MouseEvent e)
					{
					// TODO Auto-generated method stub

					}
			});

		this.jButtonResume.addMouseListener(new MouseAdapter()
			{
				@Override
				public void mouseClicked(MouseEvent e)
					{
					// TODO Auto-generated method stub

					}
			});

		this.jButtonStop.addMouseListener(new MouseAdapter()
			{
				@Override
				public void mouseClicked(MouseEvent e)
					{
					// TODO Auto-generated method stub

					}
			});
		}

	private void appearance()
		{
		// rien
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Input
	private JPanelAction jPanelAction;

	// Tools
	private JButton jButtonStart;
	private JButton jButtonResume;
	private JButton jButtonStop;

	}
