
package ch.hearc.scheduler.tools;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SJF_NonPreemptif extends Ordonnanceur
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public SJF_NonPreemptif(String name)
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
		selectProcessusToSort(listProcessus);
		sortList();

		currentProcessus = listProcessusSelectable.get(0);
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
		selectProcessusToSort(listProcessus);
		sortList();

		for(Processus processus:listProcessusSelectable)
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
		listProcessusSelectable.sort(new Comparator<Processus>()
			{

				@Override
				public int compare(Processus p1, Processus p2)
					{
					if (p1.getNbRafale() == p2.getNbRafale())
						{
						return p1.getArrive() - p2.getArrive();
						}
					else
						{
						return p1.getNbRafale() - p2.getNbRafale();
						}
					}
			});
		}

	private void selectProcessusToSort(List<Processus> listAllProcessus)
		{
		listProcessusSelectable.clear();

		for(Processus processus:listAllProcessus)
			{
			if (processus.getArrive() <= (indexTotal + 1))
				{
				listProcessusSelectable.add(processus);
				}
			}
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/
	// Tools
	private List<Processus> listProcessusSelectable;
	}
