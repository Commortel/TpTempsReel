package fr.uha.ensisa.wall;

public class ThreadPool 
{
	public static void main(String[] args) 
	{
		Worker[] workers = new Worker[5];
		new Leader(15,workers).run();
	}

}
