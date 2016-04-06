
package ch.hearc.scheduler.tools;

import java.util.ArrayList;
import java.util.List;

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

	/*------------------------------------------------------------------*\
	|*							Methodes Abstract						*|
	\*------------------------------------------------------------------*/

	public abstract void initTick();

	public abstract void tick();

	/*------------------------------*\
	|*				Set				*|
	\*------------------------------*/

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	public String getName()
		{
		return this.name;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Protected						*|
	\*------------------------------------------------------------------*/

	protected int getTotalRafale()
		{
		int totalRafale = 0;

		for(Processus processus:listProcessus)
			{
			totalRafale += processus.getNbRafale();
			}

		return totalRafale;
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

	}
