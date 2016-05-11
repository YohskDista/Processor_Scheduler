
package ch.hearc.scheduler.tools;

import java.util.Comparator;

public class SJF_NonPreemptif extends Ordonnanceur
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public SJF_NonPreemptif(String name)
		{
		super(name);
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Methodes Abstract						*|
	\*------------------------------------------------------------------*/

	@Override
	public void initTick()
		{
		sortList();
		currentProcessus = listProcessus.get(0);
		currentProcessus.setEtat(Etat.RUNNING);
		}

	@Override
	public void tick()
		{
		int rafaleActu = currentProcessus.getRafaleActuel();
		rafaleActu++;
		currentProcessus.setRafaleActuel(rafaleActu);
		this.listBoxProcessus.add(currentProcessus.showRafale(indexTotal));

		if (currentProcessus.getRafaleActuel() >= currentProcessus.getNbRafale())
			{
			currentProcessus.setEtat(Etat.FINISH);
			changeCurrentProcessus(getNext());
			}
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

	@Override
	protected void changeCurrentProcessus(Processus newProc)
		{
		try
			{
			currentProcessus = newProc;
			currentProcessus.setEtat(Etat.RUNNING);
			}
		catch (NullPointerException e)
			{
			System.out.println("Program finish");
			}
		}

	@Override
	protected Processus getNext()
		{
		sortList();

		for(Processus processus:listProcessus)
			{
			if (processus.getEtat() == Etat.READY) { return processus; }
			}

		return null;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/**
	 * Sorting list by their arrival time and after, by nb of rafale
	 */
	private void sortList()
		{
		listProcessus.sort(new Comparator<Processus>()
			{

				@Override
				public int compare(Processus p1, Processus p2)
					{
					if (p1.getArrive() == p2.getArrive())
						{
						return p1.getNbRafale() - p2.getNbRafale();
						}
					else
						{
						return p1.getArrive() - p2.getArrive();
						}
					}
			});
		}
	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/
	}
