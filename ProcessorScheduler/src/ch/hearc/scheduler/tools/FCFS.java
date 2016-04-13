
package ch.hearc.scheduler.tools;

import java.util.Comparator;

public class FCFS extends Ordonnanceur
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public FCFS(String name)
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
		changeCurrentProcessus(getNext());
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
		int indexOfCurrent = listProcessus.indexOf(currentProcessus);

		System.out.println("Index : " + indexOfCurrent);

		if (indexOfCurrent + 1 < listProcessus.size())
			{
			indexOfCurrent++;
			}

		return listProcessus.get(indexOfCurrent);
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private void sortList()
		{
		listProcessus.sort(new Comparator<Processus>()
			{

				@Override
				public int compare(Processus p1, Processus p2)
					{
					return p1.getArrive() - p2.getArrive();
					}
			});
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/
	}
