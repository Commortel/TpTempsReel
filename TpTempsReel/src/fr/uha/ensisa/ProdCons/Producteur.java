package fr.uha.ensisa.ProdCons;

import java.util.concurrent.Semaphore;

public class Producteur implements Runnable
{
	private Semaphore NEmpty;
	private Semaphore NFull;
	private int counter;
	
	public Producteur(Semaphore nEmpty, Semaphore nFull, int counter)
	{
		this.NEmpty = nEmpty;
		this.NFull = nFull;
		this.counter = counter;
	}
	
	public void run() 
	{
		while(true)
		{
			try 
			{
				System.out.println("Producteur : " + this.counter++);
				this.NEmpty.acquire();
				this.NFull.release();
				
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
			}
		}
	}

}
