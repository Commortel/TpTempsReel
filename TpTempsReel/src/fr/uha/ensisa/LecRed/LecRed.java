package fr.uha.ensisa.LecRed;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class LecRed
{
	private static void firstStrategy()
	{
		Semaphore MReading = new Semaphore(1);
		Semaphore MWriting = new Semaphore(1);
		int counter = 0;
		Random r = new Random();
		
		while(true) 
		{
			if(r.nextDouble() > 0.5)
			{
				Lecteur l = new Lecteur(MReading,MWriting,counter);
				l.run();
				counter = l.counter;
			}
			else
				new Redacteur(MWriting).run();
			System.out.println("----->Counter : " + counter);
		}
	}
	
	private static void secondStrategy()
	{
		Semaphore MReading = new Semaphore(1);
		Semaphore MWriting = new Semaphore(1);
		Semaphore MPrio = new Semaphore(1);
		int counter = 0;
		Random r = new Random();
		
		while(true) 
		{
			if(r.nextDouble() > 0.5)
				new Lecteur(MReading,MWriting, counter).run();
			else
				new Redacteur2(MWriting,MPrio).run();
		}
	}
	
	private static void thirdStrategy()
	{
		Semaphore MReading = new Semaphore(1);
		Semaphore MWriting = new Semaphore(1);
		Semaphore MPrio = new Semaphore(1);
		Random r = new Random();
		
		while(true) 
		{
			if(r.nextDouble() > 0.5)
				new Lecteur2(MReading,MWriting,MPrio).run();
			else
				new Redacteur2(MWriting,MPrio).run();
		}
	}
	
	private static void fourthStrategy()
	{
		Semaphore MReading = new Semaphore(1);
		Semaphore MWriting = new Semaphore(1);
		int RCounter = 0;
		int WCounter = 0;
		Random r = new Random();
		
		while(true) 
		{
			if(r.nextDouble() > 0.5)
				new Lecteur3(MReading,MWriting, RCounter).run();
			else
				new Redacteur3(MWriting,MReading, WCounter).run();
		}
	}
	
	public static void main(String[] args)
	{
		//firstStrategy();
		//secondStrategy();
		//thirdStrategy();
		fourthStrategy();
	}
}
