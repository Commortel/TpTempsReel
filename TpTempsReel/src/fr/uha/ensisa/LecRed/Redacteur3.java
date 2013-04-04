package fr.uha.ensisa.LecRed;

import java.util.concurrent.Semaphore;

public class Redacteur3 implements Runnable 
{
	private Semaphore MWriting;
	private Semaphore MReading;
	private Semaphore MPrioW;
	private int counter;
	
	public Redacteur3(Semaphore mWriting, Semaphore mReading, int wCounter) 
	{
		this.MWriting = mWriting;
		this.MReading = mReading;
		this.MPrioW = new Semaphore(1);
		this.counter = wCounter;
	}

	public void run() 
	{
		try
		{
			this.MPrioW.acquire();
				if(this.counter == 0)
					this.MReading.acquire();
				this.counter++;
			this.MPrioW.release();	
			this.MWriting.acquire();
				
			System.out.println("Ecriture");
			Thread.sleep(1000);

			this.MWriting.release();
			this.MPrioW.acquire();		
				this.counter--;
				if(this.counter == 0)
					this.MReading.release();
			this.MPrioW.release();
		}
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
	}

}
