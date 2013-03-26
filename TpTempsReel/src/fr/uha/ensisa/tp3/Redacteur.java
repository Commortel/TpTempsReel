package fr.uha.ensisa.tp3;

import java.util.concurrent.Semaphore;

public class Redacteur implements Runnable
{
	private Semaphore MWriting;
	
	public Redacteur(Semaphore MWriting)
	{
		this.MWriting = MWriting;
	}
	
	public void run() 
	{
		try
		{
			this.MWriting.acquire();
			
			System.out.println("Ecriture");
			Thread.sleep(1000);
			
			this.MWriting.release();
		}
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
	}

}
