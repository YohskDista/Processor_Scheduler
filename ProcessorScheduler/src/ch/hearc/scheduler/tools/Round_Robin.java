
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
		this.listBoxProcessus.add(currentProcessus.showRafale(indexTotal));

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
		int sizeParcourue = 0;
		Processus p = null;

		do
			{
			indexOfCurrent = (indexOfCurrent + 1) % listProcessus.size();
			p = listProcessus.get(indexOfCurrent);

			sizeParcourue++;
			}while(p.getEtat() == Etat.FINISH && sizeParcourue < listProcessus.size());

		return p;
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
