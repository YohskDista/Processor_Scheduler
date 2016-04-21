
package ch.hearc.scheduler.tools;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SJF_Preemptif extends Ordonnanceur
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public SJF_Preemptif(String name)
		{
		super(name);

		listProcessusSelectable = new ArrayList<Processus>();
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
		}

	@Override
	public void tick()
		{
		System.out.println("");
		System.out.println("Current : " + currentProcessus);

		int rafaleActu = currentProcessus.getRafaleActuel();
		rafaleActu++;
		currentProcessus.setRafaleActuel(rafaleActu);
		this.listBoxProcessus.add(currentProcessus.showRafale(indexTotal));

		if (currentProcessus.getRafaleActuel() > currentProcessus.getNbRafale())
			{
			currentProcessus.setEtat(Etat.FINISH);
			}
		else
			{
			currentProcessus.setEtat(Etat.READY);
			}

		changeCurrentProcessus(getNext());
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
		listProcessusSelectable.clear();

		System.out.println("Passe1 : " + listProcessus.toString());

		for(Processus processus:listProcessus)
			{
			if (processus.getArrive() <= indexTotal && processus.getEtat() == Etat.READY)
				{
				listProcessusSelectable.add(processus);
				}
			}

		System.out.println("Passe 2 : " + listProcessusSelectable.toString());
		System.out.println("Nb tick : " + indexTotal);

		if (listProcessusSelectable.size() > 0)
			{
			try
				{
				sortListRafaleLeft();
				}
			catch (NullPointerException e)
				{
				// Rien
				}
			return listProcessusSelectable.get(0);
			}

		return null;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/**
	 * Sorting list by their arrival time and after, by their nb of rafale left
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
						return (p1.getNbRafale() - p1.getRafaleActuel()) - (p2.getNbRafale() - p2.getRafaleActuel());
						}
					else
						{
						return p1.getArrive() - p2.getArrive();
						}
					}

			});
		}

	/**
	 * Sorting list by their nb of rafale left
	 */
	private void sortListRafaleLeft()
		{
		listProcessusSelectable.sort(new Comparator<Processus>()
			{

				@Override
				public int compare(Processus p1, Processus p2)
					{
					return (p1.getNbRafale() - p1.getRafaleActuel()) - (p2.getNbRafale() - p2.getRafaleActuel());
					}
			});
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Tools
	List<Processus> listProcessusSelectable;
	}
