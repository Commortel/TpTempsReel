package fr.uha.ensisa.wall;

public class Leader extends Thread 
{
	private static int counter;
	private Worker[] workers;
	
	public Leader(int counter, Worker[] workers)
	{
		this.counter = counter;
		this.workers = workers;
	}
	
	public void run() 
	{
		System.out.print(workers.length);
		for(int i = 0; i < workers.length; i++)
		{
			workers[i] = new Worker(this.counter);
			workers[i].start();
		}
		while(true)
		{
			if(this.counter != 0)
			{
				System.out.println("Leader sleeping");
				notifyAll();
				try { wait(); } 
				catch (InterruptedException e) {e.printStackTrace();}
			}
			else
			{
				System.out.println("Leader reload");
				this.counter = 15;
			}
		}
	}
}
