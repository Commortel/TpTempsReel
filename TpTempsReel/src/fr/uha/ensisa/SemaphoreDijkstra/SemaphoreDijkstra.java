package fr.uha.ensisa.SemaphoreDijkstra;

public class SemaphoreDijkstra 
{
	private int counter, blocked;
	
	public SemaphoreDijkstra(int counter)
	{
		this.counter = counter;
		this.blocked = 0;
	}
	
	public synchronized void P() throws Exception
	{
		if(--this.counter == 0)
		{
			this.blocked++;
			System.out.println("Nombre de threads bloqués : " + this.blocked);
			wait();
		}
	}
	
	public synchronized void V()
	{
		if(this.blocked != 0)
		{
			notify();
			this.blocked--;
		}
		else
			this.counter++;
	}
}
