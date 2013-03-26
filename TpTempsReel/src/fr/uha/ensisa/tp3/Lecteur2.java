package fr.uha.ensisa.tp3;

import java.util.concurrent.Semaphore;

public class Lecteur2 implements Runnable {

	private Semaphore MReading;
	private Semaphore MWriting;
	private Semaphore MPrio;
	private int counter;

	
	public Lecteur2(Semaphore MReading, Semaphore MWriting, Semaphore MPrio)
	{
		this.MReading = MReading;
		this.MWriting = MWriting;
		this.MPrio = MPrio;
		this.counter = 0;
	}

	public void run() 
	{
		try 
		{
			this.MPrio.acquire();
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
			this.MPrio.release();
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
	}

}
