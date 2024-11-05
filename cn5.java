import java.io.*;
class Main 
{
    public static void main(String[] args) throws IOException 
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter Generator: ");
        String g = br.readLine();
        System.out.print("Enter Data: ");
        String d = br.readLine();
        String c = d + div(d + "0".repeat(g.length() - 1), g);
        System.out.println("Transmitted Code Word: " + c);
        System.out.print("Enter Received Code Word: ");
        String r = br.readLine();
        System.out.println(div(r, g).contains("1") ? "Errors in received code." : "No errors in received
code.");
    }
    static String div(String n, String g) 
    {
        String rem = n.substring(0, g.length());
        for (int i = g.length(); i <= n.length(); i++) 
        {
	    rem = rem.charAt(0) == '0' ? rem.substring(1) : xor(rem, g).substring(1);
	    if (i < n.length()) 
		rem += n.charAt(i);
        }
        return rem;
    }
    static String xor(String a, String b) 
    {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < b.length(); i++)
            res.append(a.charAt(i) == b.charAt(i) ? '0' : '1');
        return res.toString();
    }
}