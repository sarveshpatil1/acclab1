package hashTable;

import java.util.concurrent.ThreadLocalRandom;

public class LAB1CHT {
	public static int n=2;
	static CuckooHashTable<String> cht=new CuckooHashTable<>(new StringHashFamily( 3 ), n);
	
	public static String[] randomStrings(int n) {

		String[] s1 = new String[n];
		int k=0;
		while(k<n) {

			String s = "";

			for(int j = 0 ; j < 10 ; j++) {

				int randomNum = ThreadLocalRandom.current().nextInt(97,122);
				s = s + (char)randomNum;
				
			}

			s1[k] = s;
			k++;
		}
		return s1;
	}
	

	public static long CHTinsert(String s2[],int n)
	{
		 long start,end,avg=0,s,e;
		//String s2[]=randomStrings(n);
		//CuckooHashTable<String> cht=new CuckooHashTable<>(new StringHashFamily( 3 ), n);
		for(int i=0;i<n;i++) {
			start=System.nanoTime();
			cht.insert(s2[i]);
			end=System.nanoTime();
			avg+=(end-start);
		}
		avg=avg/n;
		return avg;
			
	}
	
	public static long CHTdelete(String s2[],int n) {
		 long start,end,avg=0,s,e;
		
		//CuckooHashTable<String> cht=new CuckooHashTable<>(new StringHashFamily( 3 ), n);
		 
		for(int j=0;j<n;j++) 
		{
			start=System.nanoTime();
			if(cht.contains(s2[j])) 
			{
			    cht.remove(s2[j]);
			}
			end=System.nanoTime();
			avg+=(end-start);
		}
		
		avg=avg/n;
		return avg;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int up=20;
		System.out.println("\nINSERTION\n");
		
		for(int i=1;i<=up;i++) {
			n=(int)Math.pow(2, i);
			String s2[]=randomStrings(n);
			System.out.println("The avg time taken for CuckooHashTable insertion for "+i+"th iteration is: "+CHTinsert(s2,n));
		}
		System.out.println("\nDELETION\n");

		for(int i=1;i<=up;i++) {
			 n=(int) Math.pow(2, i);
				String s2[]=randomStrings(n);
				System.out.println("The avg time taken for CuckooHashTable deletion for "+i+"th iteration is: "+CHTdelete(s2,n));
	}
		System.out.println("\n\nE.O.O");
	}

}
