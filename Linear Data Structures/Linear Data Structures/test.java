import java.util.concurrent.ThreadLocalRandom;

public class test {
	public static void main(String []args) {
	int n=2;
	for (int i =1;i<=5;i++) {
	n=(int) Math.pow(n, i);
		String[] s1 = new String[n];
	
	for(int k=0;k<n;k++) {

		String s = "";

		for(int j = 0 ; j < 10 ; j++) {

			int randomNum = ThreadLocalRandom.current().nextInt(97,122);
			s = s + (char)randomNum;
			
		}

		s1[k] = s;
		
	}
	}
	//for(int i=0;i<n;i++)
	//System.out.println(s1[1048577]);
	}
}
