package hashTable;




import java.util.concurrent.ThreadLocalRandom;



public class mainn {

	

	public static void main(String[] args) {

		insertIntoSepChainHashMap(); // 1st ques

		

		

	}

	

	public static void insertIntoSepChainHashMap() {

		//q1 

		for(int i = 1 ; i <= 13 ; i++) {

			int n = (int)(Math.pow(2,i));

			//int n = 30;	

			System.out.println("N: " + n);

			

			System.out.println("Separate Chaining");

			String[] ans = randomStrings(n);

//			for(int j = 0 ; j < n ;j++) {

//				System.out.println(ans[j]);

//			}

			SeparateChainingHashTable<String> scMap = new SeparateChainingHashTable<>();

			long avg = (long) 0.0;

			System.out.println("Time taken for insertion: ");

			for(int j = 0 ; j < n ; j++) {

				long start = System.nanoTime();

				scMap.insert(ans[j]);

				long end = System.nanoTime();

				avg = avg + (end - start);

				//System.out.print((end - start) + ", ");

				

			}

			System.out.println();

			avg = avg / n;

			System.out.println("Average time taken for insertion in Sep. Chaining: " + avg);

			avg = 0;

			String[] testRandom = randomStrings(n);// q2

			System.out.println("Time taken for search: ");

			for(int j = 0 ; j < n ; j++) {

				long start = System.nanoTime();

				boolean x = scMap.contains(testRandom[j]);

				long end = System.nanoTime();

				//System.out.print((end - start) + ", ");

				if(x) {

					scMap.remove(testRandom[j]);

				}

				avg = avg + (end - start);

			}

			avg = avg / n;

			System.out.println();

			System.out.println("Average time taken for search in Sep. Chaining: " + avg);

			

			//q3

			

			System.out.println("Quadratic Probing");

			ans = randomStrings(n);

//			for(int j = 0 ; j < n ;j++) {

//				System.out.println(ans[j]);

//			}

			QuadraticProbingHashTable<String> qMap = new QuadraticProbingHashTable<>();

			avg = (long) 0.0;

			System.out.println("Time taken for insertion: ");

			for(int j = 0 ; j < n ; j++) {

				long start = System.nanoTime();

				qMap.insert(ans[j]);

				long end = System.nanoTime();

				avg = avg + (end - start);

				//System.out.print((end - start) + ", ");

				

			}

			System.out.println();

			avg = avg / n;

			System.out.println("Average time taken for insertion in Quadratic Probing: " + avg);

			avg = 0;

			testRandom = randomStrings(n);// q2

			System.out.println("Time taken for search: ");

			for(int j = 0 ; j < n ; j++) {

				long start = System.nanoTime();

				boolean x = qMap.contains(testRandom[j]);

				long end = System.nanoTime();

				//System.out.print((end - start) + ", ");

				if(x) {

					qMap.remove(testRandom[j]);

				}

				avg = avg + (end - start);

			}

			avg = avg / n;

			System.out.println();

			System.out.println("Average time taken for search in Quadratic Probing: " + avg);

			

			

			// Cuckoo

			

//			System.out.println("Cuckoo hash table");

//			ans = randomStrings(n);

////			for(int j = 0 ; j < n ;j++) {

////				System.out.println(ans[j]);

////			}

//	CuckooHashTable<String> qMap = new CuckooHashTable<>();

//			avg = (long) 0.0;

//			System.out.println("Time taken for insertion: ");

//			for(int j = 0 ; j < n ; j++) {

//				long start = System.nanoTime();

//				qMap.insert(ans[j]);

//				long end = System.nanoTime();

//				avg = avg + (end - start);

//				//System.out.print((end - start) + ", ");

//				

//			}

//			System.out.println();

//			avg = avg / n;

//			System.out.println("Average time taken for insertion in Quadratic Probing: " + avg);

//			avg = 0;

//			testRandom = randomStrings(n);// q2

//			System.out.println("Time taken for search: ");

//			for(int j = 0 ; j < n ; j++) {

//				long start = System.nanoTime();

//				boolean x = qMap.contains(testRandom[j]);

//				long end = System.nanoTime();

//				//System.out.print((end - start) + ", ");

//				if(x) {

//					qMap.remove(testRandom[j]);

//				}

//				avg = avg + (end - start);

//			}

//			avg = avg / n;

//			System.out.println();

//			System.out.println("Average time taken for search in Quadratic Probing: " + avg);

			

			

		}

	}

	

	public static String[] randomStrings(int n) {

		String[] ans = new String[n];

			

		int cnst = 65;

		int min = 0;

		int max = 25;

		for(int k = 0 ; k < n ; k++) {

			String s = "";

			for(int j = 0 ; j < 10 ; j++) {

				int randomNum = ThreadLocalRandom.current().nextInt(cnst + min, cnst + max + 1);

				s = s + (char)randomNum;

			}

			ans[k] = s;

		}

		return ans;

	}

}