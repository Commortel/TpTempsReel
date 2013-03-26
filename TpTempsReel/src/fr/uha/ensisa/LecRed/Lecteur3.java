package fr.uha.ensisa.LecRed;

import java.util.concurrent.Semaphore;

public class Lecteur3 implements Runnable 
{
	private Semaphore MReading;
	private Semaphore MWriting;
	private Semaphore MPrio;
	private Semaphore MPrioR;
	private int counter;
	
	public Lecteur3(Semaphore mReading, Semaphore mWriting, Semaphore mPrio,Semaphore mPrioR, int rCounter) 
	{
		this.MReading = new Semaphore(1);
		this.MWriting = new Semaphore(1);
		this.MPrio = new Semaphore(1);
		this.MPrioR = new Semaphore(1);
		this.counter = rCounter;
	}

	public void run() 
	{
		try 
		{
			this.MPrio.acquire();
				this.MReading.acquire();
					this.MPrioR.acquire();
						if(this.counter == 0)
							this.MWriting.acquire();
						this.counter++;
					this.MPrioR.release();
				this.MReading.release();	
					
				System.out.println("Lecture");
				Thread.sleep(100);
					
				this.MPrioR.acquire();
					this.counter--;
					if(this.counter == 0)
						this.MWriting.release();
				this.MPrioR.release();
			this.MPrio.release();
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
	}

}
