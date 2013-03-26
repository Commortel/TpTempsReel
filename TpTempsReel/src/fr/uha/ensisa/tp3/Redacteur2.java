package fr.uha.ensisa.tp3;

import java.util.concurrent.Semaphore;

public class Redacteur2 implements Runnable
{
	private Semaphore MWriting;
	private Semaphore MPrio;
	
	public Redacteur2(Semaphore MWriting, Semaphore MPrio)
	{
		this.MWriting = MWriting;
		this.MPrio = MPrio;
	}
	
	public void run() 
	{
		try
		{
			this.MPrio.acquire();
			this.MWriting.acquire();
			
			System.out.println("Ecriture");
			Thread.sleep(1000);
			
			this.MWriting.release();
			this.MPrio.release();
		}
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
	}

}
