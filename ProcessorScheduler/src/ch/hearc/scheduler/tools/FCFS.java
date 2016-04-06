
package ch.hearc.scheduler.tools;

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
		changeCurrentProcessus(getNext());
		}

	@Override
	public void tick()
		{
		int rafaleActu = currentProcessus.getRafaleActuel();
		rafaleActu++;
		currentProcessus.setRafaleActuel(rafaleActu);

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
		return listProcessus.get(indexOfCurrent + 1);
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/
	}
