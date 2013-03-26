package fr.uha.ensisa.tp3;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class LecRed
{
	public static void main(String[] args)
	{
		Semaphore MReading = new Semaphore(1);
		Semaphore MWriting = new Semaphore(1);
		Random r = new Random();
		
		while(true) 
		{
			if(r.nextDouble() > 0.5)
				new Lecteur(MReading,MWriting).run();
			else
				new Redacteur(MWriting).run();
		}
	}
}
