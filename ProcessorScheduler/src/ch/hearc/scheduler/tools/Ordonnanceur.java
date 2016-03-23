
package ch.hearc.scheduler.tools;

import java.util.List;

public abstract class Ordonnanceur
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public Ordonnanceur()
		{
		// Rien
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

	protected abstract Processus changeCurrentProcessus();

	protected abstract void tick();

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/
	// Tools
	protected List<Processus> listProcessus;
	protected Processus currentProcessus;
	}
