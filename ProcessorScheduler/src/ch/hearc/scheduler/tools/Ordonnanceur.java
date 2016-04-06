
package ch.hearc.scheduler.tools;

import java.util.ArrayList;
import java.util.List;

public abstract class Ordonnanceur
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public Ordonnanceur(String name)
		{
		this.name = name;
		this.currentProcessus = null;
		this.listProcessus = new ArrayList<Processus>();
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
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	//Input
	protected String name;

	// Tools
	protected List<Processus> listProcessus;
	protected Processus currentProcessus;

	}
