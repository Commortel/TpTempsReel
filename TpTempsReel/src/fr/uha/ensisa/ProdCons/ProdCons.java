package fr.uha.ensisa.ProdCons;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class ProdCons 
{
	public static void main(String[] args)
	{
		Semaphore NEmpty = new Semaphore(10);
		Semaphore NFull = new Semaphore(10);
		int counter = 1;
		Random r = new Random();
		
		new Producteur(NEmpty, NFull, counter).run();
		new Consommateur(NEmpty, NFull, counter).run();
		
		/*while(true) 
		{
			if(r.nextDouble() < 0.5)
				new Producteur(NEmpty, NFull, counter).run();
			else
				new Consommateur(NEmpty, NFull, counter).run();
		}*/
	}
}
