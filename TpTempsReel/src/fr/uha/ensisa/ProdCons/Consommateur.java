package fr.uha.ensisa.ProdCons;

import java.util.concurrent.Semaphore;

public class Consommateur implements Runnable
{
	private Semaphore NEmpty;
	private Semaphore NFull;
	private int counter;
	
	public Consommateur(Semaphore nEmpty, Semaphore nFull, int counter)
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
				this.NFull.acquire();
				this.NEmpty.release();
				System.out.println("Comsommateur : " + this.counter--);
				
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
			}
		}
	}
}
