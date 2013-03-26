package fr.uha.ensisa.tp3;

public class Training extends Thread
{
    private int m_id;
	public static int counter = 0;
	
	public Training(int id)
	{
		this.m_id = id;
	}
	
	public synchronized void run()
	{
		int tmp = counter;
		tmp = tmp + 1;
		int tmp2 = tmp;
		counter = tmp2;
	}
	
	public static void main(String[] args) throws InterruptedException 
	{
		Training[] mytn = new Training[1000];
		
		for(int i=0; i < mytn.length; i++)
		{
			mytn[i] = new Training(i);
			mytn[i].start();
		}
		for(int i=0; i < mytn.length; i++)
		{
			mytn[i].join();
		}
		System.out.println("Compteur : " + counter);
	}
}
