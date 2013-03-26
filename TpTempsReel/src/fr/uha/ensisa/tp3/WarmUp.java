package fr.uha.ensisa.tp3;

public class WarmUp extends Thread 
{
	private int m_id;
	
	public WarmUp(int id)
	{
		this.m_id = id;
	}
	
	public void run()
	{
		System.out.println("Je suis le Thread X " + m_id);
		System.out.println("Je suis le Thread X " + m_id);
	}
	
	public static void main(String[] args) 
	{
		WarmUp[] mywu = new WarmUp[4];
		
		for(int i=0; i < mywu.length; i++)
		{
			mywu[i] = new WarmUp(i);
			mywu[i].start();
		}
	}

}
