package fr.uha.ensisa.tp3;

import java.util.concurrent.Semaphore;

public class Lecteur implements Runnable 
{
	private Semaphore MReading;
	private Semaphore MWriting;
	private int counter = 0;
	
	public Lecteur(Semaphore MReading, Semaphore MWriting)
	{
		this.MReading = MReading;
		this.MWriting = MWriting;
		this.counter = 0;
	}
	
	public void run() 
	{
		try 
		{
			this.MReading.acquire();
			if(this.counter == 0)
				this.MWriting.acquire();
			this.counter++;
			this.MReading.release();	
			
			System.out.println("Lecture");
			Thread.sleep(100);
			
			this.MReading.acquire();
			this.counter--;
			if(this.counter == 0)
				this.MWriting.release();
			this.MReading.release();
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
		
	}

}
