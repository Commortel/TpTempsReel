package fr.uha.ensisa.tp3;

import java.util.concurrent.Semaphore;

public class Redacteur2 implements Runnable
{
	private Semaphore MWriting;
	private Semaphore MAlone;
	
	public Redacteur2(Semaphore MWriting)
	{
		this.MWriting = MWriting;
		this.MAlone = new Semaphore(1);
	}
	
	public void run() 
	{
		try
		{
			this.MAlone.acquire();
			this.MWriting.acquire();
			
			System.out.println("Ecriture");
			Thread.sleep(1000);
			
			this.MWriting.release();
			this.MAlone.release();
		}
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
	}

}
