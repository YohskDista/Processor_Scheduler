
package ch.hearc.scheduler.tools;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;

public abstract class Ordonnanceur
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public Ordonnanceur(String name, int timeQuantum)
		{
		this.name = name;
		this.currentProcessus = null;
		this.listProcessus = new ArrayList<Processus>();
		this.timeQuantum = timeQuantum;
		this.indexTotal = 0;
		}

	public Ordonnanceur(String name)
		{
		this(name, 0);
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	public void addProcessus(Processus processus)
		{
		this.listProcessus.add(processus);
		}

	public void deleteProcessus(Processus processus)
		{
		this.listProcessus.remove(processus);
		}

	@Override
	public String toString()
		{
		StringBuilder builder = new StringBuilder();
		builder.append(this.name);
		return builder.toString();
		}

	public List<Box> showProcessus()
		{
		this.listBoxProcessus = new ArrayList<Box>();
		indexTotal = getStartIndex();
		createStartRafales();
		initTick();

		for(int i = indexTotal+1; i <= getTotalRafale(); i++)
			{
			this.indexTotal++;
			tick();
			}

		return this.listBoxProcessus;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Abstract						*|
	\*------------------------------------------------------------------*/

	public abstract void initTick();

	public abstract void tick();

	/*------------------------------*\
	|*				Set				*|
	\*------------------------------*/

	public void setTimeQuantum(int timeQuantum)
		{
		this.timeQuantum = timeQuantum;
		}

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	public String getName()
		{
		return this.name;
		}

	public List<Processus> getListProcessus()
		{
		return this.listProcessus;
		}

	public int getTotalRafale()
		{
		int totalRafale = getStartIndex();

		for(Processus processus:listProcessus)
			{
			totalRafale += processus.getNbRafale();
			}

		return totalRafale;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Protected						*|
	\*------------------------------------------------------------------*/

	protected int getStartIndex()
		{
		int startIndex = this.listProcessus.get(0).getArrive();

		for(Processus p : this.listProcessus)
			{
			if (p.getArrive() < startIndex)
				{
				startIndex = p.getArrive();
				}
			}

		return startIndex-1;
		}

	protected void createStartRafales()
	{
		int startRafale = getStartIndex();

		for(int i = 1; i <= startRafale; i++)
			{
			JLabel label = new JLabel(i + "");
			JButton button = new JButton();
			button.setBackground(Color.GRAY);
			button.setEnabled(false);

			Box box = Box.createVerticalBox();
			box.add(button);
			box.add(label);

			this.listBoxProcessus.add(box);
			}
	}

	/*------------------------------------------------------------------*\
	|*							Methodes Abstract						*|
	\*------------------------------------------------------------------*/

	protected abstract void changeCurrentProcessus(Processus newProc);

	protected abstract Processus getNext();

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Attributs Protected						*|
	\*------------------------------------------------------------------*/

	//Input
	protected String name;
	protected int timeQuantum;

	// Tools
	protected List<Processus> listProcessus;
	protected Processus currentProcessus;

	protected List<Box> listBoxProcessus;

	protected int indexTotal;

	}
