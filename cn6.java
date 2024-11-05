import java.util.*;
class Main
{
    public static void main(String[] args) 
    {
	Scanner s = new Scanner(System.in);
	System.out.print("Enter number of nodes: ");
	int n = s.nextInt();
	int[][] g = new int[n][n];
	System.out.println("Enter the distance matrix (use 9999 for infinity):");
	for (int i = 0; i < n; i++)
	    for (int j = 0; j < n; j++)
		g[i][j] = s.nextInt();
	System.out.print("Enter source node: ");
	int src = s.nextInt();
	int[] d = new int[n];
	boolean[] v = new boolean[n];
	Arrays.fill(d, 9999);
	d[src] = 0;
	for (int c = 0; c < n - 1; c++) 
	{
	    int u = -1;
	    for (int i = 0; i < n; i++)
		if (!v[i] && (u == -1 || d[i] < d[u]))
		    u = i;
	    v[u] = true;
	    for (int j = 0; j < n; j++)
		if (!v[j] && g[u][j] != 9999 && d[u] + g[u][j] < d[j])
		    d[j] = d[u] + g[u][j];
	}
	System.out.println("Shortest distances from node " + src + ":");
	for (int i = 0; i < n; i++)
	    System.out.println("To " + i + " - " + (d[i] == 9999 ? "Infinity" : d[i]));
	s.close();
    }
}