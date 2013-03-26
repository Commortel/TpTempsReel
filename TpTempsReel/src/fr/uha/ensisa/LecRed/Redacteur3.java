package fr.uha.ensisa.LecRed;

import java.util.concurrent.Semaphore;

public class Redacteur3 implements Runnable 
{
	private Semaphore MWriting;
	private Semaphore MReading;
	private Semaphore MPrio;
	private int counter;
	
	public Redacteur3(Semaphore mWriting, Semaphore mReading, Semaphore mPrio, int wCounter) 
	{
		this.MWriting = mWriting;
		this.MReading = mReading;
		this.MPrio = mPrio;
		this.counter = wCounter;
	}

	public void run() 
	{
		try
		{
			this.MPrio.acquire();
				if(this.counter == 0)
					this.MReading.acquire();
				this.counter++;
			this.MPrio.release();	
				this.MWriting.acquire();
				
				System.out.println("Ecriture");
				Thread.sleep(1000);

				this.MWriting.release();
			this.MPrio.acquire();		
				this.counter++;
				if(this.counter == 0)
					this.MReading.release();
			this.MPrio.release();
		}
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
	}

}
