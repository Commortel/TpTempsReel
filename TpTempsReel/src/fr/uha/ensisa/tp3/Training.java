package fr.uha.ensisa.tp3;

import java.util.concurrent.Semaphore;

public class Training extends Thread
{
    private Semaphore m_mutex;
	public static int counter = 0;
	
	public Training(Semaphore mutex)
	{
		this.m_mutex = mutex;
	}
	
	public void run()
	{
		try 
		{
			this.m_mutex.acquire();
			int tmp = counter;
			tmp = tmp + 1;
			int tmp2 = tmp;
			counter = tmp2;
			this.m_mutex.release();
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws InterruptedException 
	{
		Training[] mytn = new Training[1000];
		Semaphore mutex = new Semaphore(1);
		
		for(int i=0; i < mytn.length; i++)
		{
			mytn[i] = new Training(mutex);
			mytn[i].start();
		}
		for(int i=0; i < mytn.length; i++)
		{
			mytn[i].join();
		}
		System.out.println("Compteur : " + counter);
	}
}
