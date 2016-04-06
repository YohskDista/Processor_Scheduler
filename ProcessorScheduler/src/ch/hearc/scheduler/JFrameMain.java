
package ch.hearc.scheduler;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JSplitPane;

import ch.hearc.scheduler.graphic.creation.JPanelCreation;
import ch.hearc.scheduler.graphic.visualization.JPanelVisualization;

public class JFrameMain extends JFrame
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JFrameMain()
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
		this.jPanelVisualization = new JPanelVisualization();
		this.jPanelCreation = new JPanelCreation(this.jPanelVisualization);

		this.jSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, this.jPanelCreation, this.jPanelVisualization);
		this.jSplitPane.setDividerLocation(200);
		this.jSplitPane.setOneTouchExpandable(true);

			// Layout : Specification
			{
			BorderLayout borderLayout = new BorderLayout();
			setLayout(borderLayout);

			// borderLayout.setHgap(20);
			// borderLayout.setVgap(20);
			}

		// JComponent : add
		add(this.jSplitPane, BorderLayout.CENTER);
		}

	private void control()
		{
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		}

	private void appearance()
		{
		setSize(900, 600);
		setLocationRelativeTo(null); // frame centrer
		setVisible(true); // last!
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Tools
	private JPanelCreation jPanelCreation;
	private JPanelVisualization jPanelVisualization;

	private JSplitPane jSplitPane;

	}
