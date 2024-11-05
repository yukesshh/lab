import java.util.Scanner;
class Main 
{
    public static void main(String[] a) 
    {
	Scanner s = new Scanner(System.in);
	System.out.print("Enter bucket size: ");
	int B = s.nextInt();
	System.out.print("Enter number of queries: ");
	int Q = s.nextInt();
	System.out.print("Enter input packet size: ");
	int I = s.nextInt();
	System.out.print("Enter output packet size: ");
	int O = s.nextInt();
	int S = 0;
	for (int i = 0; i < Q; i++) 
	{
	    int L = B - S;
	    if (I <= L) 
	    {
		S += I; 
	    } 
	    else 
	    {
		System.out.println("Packet loss = " + (I - L)); 
	    }
	    System.out.println("Buffer size = " + S + " out of bucket size = " + B);
	    S -= O; 
	    if (S < 0) S = 0; 
	}
	System.out.println("Final buffer size = " + S + " out of bucket size = " + B);
	s.close();
    }
}