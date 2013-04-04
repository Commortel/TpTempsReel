package fr.uha.ensisa.wall;

public class Worker extends Thread 
{
	private int task;
	
	public Worker(int task)
	{
		this.task = task;
	}

	public void run() 
	{
		while(true)
		{
			try 
			{
				if(this.task != 0)
				{
					
					System.out.println("Worker " + this.getId() + " Task left : " + this.task);
					this.task--;
					Thread.sleep(500);
				}
				else
				{
					notifyAll();
					wait();
				}
				
			} 
			catch (InterruptedException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
