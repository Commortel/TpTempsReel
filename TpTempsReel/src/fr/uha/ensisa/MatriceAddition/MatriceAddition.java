package fr.uha.ensisa.MatriceAddition;

import java.awt.Point;
import java.util.Arrays;

public class MatriceAddition extends Thread 
{
	private static int A[][], B[][], C[][];
	private Point m_start, m_end;
	
	static{
		A = new int[][]{ {1,1,1,1},{ 1,1,1,1}, {1,1,1,1}, {1,1,1,1}};
		B = new int[][]{ {1,1,2,2},{ 1,1,2,2}, {3,3,4,4}, {3,3,4,4}}; 
		C = new int[A.length][B.length];
	}
	
	public MatriceAddition(Point m_start, Point m_end)
	{
		this.m_start = m_start;
		this.m_end = m_end;
	}

	public void run() 
	{
		for(int i = m_start.x; i <= m_end.x; i++)
			for(int j = m_start.y; j <= m_end.y; j++)
				C[j][i] = A[j][i] + B[j][i];
	}
	
	public static void main(String[] args) throws Exception 
	{
		MatriceAddition worker[] = new MatriceAddition[4];
		
		worker[0] = new MatriceAddition(new Point(0,0), new Point((A.length/2)-1,(A.length/2)-1));
		worker[1] = new MatriceAddition(new Point(A.length/2,0), new Point(A.length-1,(A.length/2)-1));
		worker[2] = new MatriceAddition(new Point(0,A.length/2), new Point((A.length/2)-1,A.length-1));
		worker[3] = new MatriceAddition(new Point(A.length/2,A.length/2), new Point(A.length-1,A.length-1));
		
		for(int i = 0; i < worker.length; i++)
			worker[i].start();
		
		for(int i = 0; i < worker.length; i++)
			worker[i].join();
		
		for(int i = 0; i < worker.length; i++)
			System.out.println(Arrays.toString(C[i]));		
	}
}
