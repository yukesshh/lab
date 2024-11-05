import java.util.Scanner;
public class EXP7 
{
    static final int I = 9999;
    public static void main(String[] args) 
    {
	Scanner s = new Scanner(System.in);
	System.out.println("Enter number of nodes: ");
	int n = s.nextInt();
	s.nextLine();
	char[] a = new char[n];
	for (int i = 0; i < n; i++) 
	{
	    a[i] = (char) ('A' + i);
	}
	int[][] d = new int[n][n];
	int[][] h = new int[n][n];
	System.out.println("Enter the distances (9999 if no connection): ");
	for (int i = 0; i < n; i++) 
	{
	    for (int j = 0; j < n; j++) 
	    {
		System.out.print("Distance from " + a[i] + " to " + a[j] + ": ");
		d[i][j] = s.nextInt();
		if (i == j) 
		{
		    d[i][j] = 0;
		}
		h[i][j] = (d[i][j] == I) ? -1 : j;
	    }
	}
	System.out.println("\nInitial Tables:");
	p(a, d, h);
	for (int x = 0; x < n - 2; x++) 
	{
	    for (int i = 0; i < n; i++) 
	    {
	        for (int j = 0; j < n; j++) 
		{
		    for (int k = 0; k < n; k++) 
		    {
			if (d[i][k] + d[k][j] < d[i][j]) 
			{
				d[i][j] = d[i][k] + d[k][j];
				h[i][j] = h[i][k];
			}
		    }
		}
	    }
	    System.out.println("\nAfter iteration " + (x + 1) + ":");
	    p(a, d, h);
	}
	System.out.println("\nFinal Tables:");
	p(a, d, h);
    }
    private static void p(char[] a, int[][] d, int[][] h) 
    {
	int n = a.length;
	for (int i = 0; i < n; i++) 
	{
	    System.out.println("Table for node " + a[i] + ":");
	    System.out.println("Dst\tDis\tHop");
	    for (int j = 0; j < n; j++) 
	    {
		if (d[i][j] == I) 
		{
		    System.out.println(a[j] + "\tINF\t-");
		} 
		else 
		{
			System.out.println(a[j] + "\t" + d[i][j] + "\t" + a[h[i][j]]);
		}
	    }
	    System.out.println();
	}
    }
}