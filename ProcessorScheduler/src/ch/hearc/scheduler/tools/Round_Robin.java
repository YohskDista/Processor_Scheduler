
package ch.hearc.scheduler.tools;

public class Round_Robin extends Ordonnanceur
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public Round_Robin(String name)
		{
		super(name);

		this.myTimeQuantum = 0;
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

		myTimeQuantum++;

		if (currentProcessus.getRafaleActuel() >= currentProcessus.getNbRafale())
			{
			currentProcessus.setEtat(Etat.FINISH);
			changeCurrentProcessus(getNext());
			}
		else if (myTimeQuantum >= timeQuantum)
			{
			currentProcessus.setEtat(Etat.READY);
			changeCurrentProcessus(getNext());
			myTimeQuantum = 0;
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
			this.myTimeQuantum = 0;

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

		indexOfCurrent = (indexOfCurrent + 1) % listProcessus.size();

		return listProcessus.get(indexOfCurrent);
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/
	// tools
	private int myTimeQuantum;
	}
