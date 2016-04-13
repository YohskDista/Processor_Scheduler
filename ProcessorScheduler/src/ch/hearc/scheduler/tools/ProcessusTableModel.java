
package ch.hearc.scheduler.tools;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class ProcessusTableModel extends AbstractTableModel
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public ProcessusTableModel()
		{
		this.listProcessus = new ArrayList<Processus>();
		}

	public ProcessusTableModel(List<Processus> listProcessus)
		{
		this.listProcessus = listProcessus;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/
	@Override
	public int getColumnCount()
		{
		return this.tabEntetes.length;
		}

	@Override
	public String getColumnName(int column)
		{
		return this.tabEntetes[column];
		}

	@Override
	public Object getValueAt(int row, int column)
		{
		Processus processus = getProcessus(row);

		switch(column)
			{
			case 0:
				return processus.getNom();
			case 1:
				return processus.getNbRafale();
			case 2:
				return processus.getNbRafale();
			default:
				return null;
			}
		}

	@Override
	public int getRowCount()
		{
		return this.listProcessus.size();
		}

	public void addProcessus(Processus processus)
		{
		insertProcessus(getRowCount(), processus);
		}

	public void insertProcessus(int row, Processus processus)
		{
		this.listProcessus.add(row, processus);
		this.fireTableRowsInserted(row, row);
		}

	/*------------------------------*\
	|*				Set				*|
	\*------------------------------*/

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	public Processus getProcessus(int row)
		{
		return this.listProcessus.get(row);
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Tools
	private final String[] tabEntetes = { "Nom", "Arrivée", "Rafale(s)" };
	private List<Processus> listProcessus;
	}
