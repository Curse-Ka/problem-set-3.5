/**
 * INSTRUCTIONS.
 * 
 * The following exercises are, perhaps, more mathematically inclined than previous
 * problem sets. While they might be challenging, they are certainy doable.
 * 
 * You can (and should!) solve each of them using only the operators, conditional control
 * structures, and iterative control strucurs we've covered. You are not permitted to use
 * recursive code in your solutions.
 * 
 * Please be mindful of the expected outputs, as your code will be tested against that
 * directly. If you're unsure, please ask for clarification.
 * 
 * This problem set is worth 25 points and is due no later than 11:59pm on October 28, 2018.
 */

public class ProblemSet3_5 {
	
	public static void main(String[] args) {
		ProblemSet3_5 ps = new ProblemSet3_5();
		
		// test your solutions here
		
		ps.primes(1, 1000);
		ps.leapYears(5);
		ps.palindromicNumbers(123454321);
		ps.fibonacci(12);
		ps.multiples(5, 6, 120);
	}
	
	/**
	 * How many prime numbers are there between @start and @end, where @start and @end
	 * are positive integers in the range [1, @Integer.MAX_VALUE]?
	 * 
	 * Print your solution in the following formats: "There is X prime number."
	 *                                               "There are X prime numbers."
	 * 
	 * @param start
	 * @param end
	 */
	
	public void primes(int start, int end) {
		int primeCount = 0;
		boolean prime = false;
		
		for (int cnt = 1; cnt <= end; cnt++) {
			prime = true;
			
			if (cnt == 0 || cnt == 1) {
				prime = false;
			}
			
			double sqrt = Math.sqrt(cnt);
			for (int cnt2 = 2; cnt2 < (sqrt + 1); cnt2++) {
				if (cnt % cnt2 == 0) {
					prime = false;
				}
			}
			
			if (cnt == 2) {
				prime = true;
			}
			
			if (prime) {
				primeCount++;
			}
			
		}
		if (primeCount == 0 || primeCount > 1) {
			System.out.println("There are " + primeCount + " prime numbers");
		} else {
			System.out.println("There is " + primeCount + " prime number");
		}
	}
	
	/**
	 * What are the next @count leap years?
	 * 
	 * Print your solution in the following formats: "The next leap year is X."
	 *                                               "The next 2 leap years are X and Y."
	 *                                               "THe next N leap years are A, ..., X, Y, and Z."
	 * 
	 * @param count
	 */
	
	public void leapYears(int count) {
		if (count == 1) {
			System.out.println("The next leap year is 2020.");
			return;
		} else {
			System.out.print("The next " + count + " leap years are 2020");
		}
		
		int year = 2024;
		for (int cnt = 1; cnt < (count - 1); cnt++) {
			System.out.print(", " + year);
			year += 4;
		}
		if (count > 2) {
			System.out.print(",");
		}
		System.out.println(" and " + year + ".");
	}
	
	/**
	 * Is @number a palindromic number?
	 * 
	 * Print your solution in the following formats: "X is a palindromic number."
	 *                                               "X is not a palindromic number."
	 *                                               
	 * @param number
	 */
	
	public void palindromicNumbers(int number) {
		int size = 0;
		int numCopy = number;
		do {
			size = (numCopy > 0) ? (size + 1) : (size);
			numCopy /= 10;
		} while (numCopy > 0);
				
		int lowDig;
		int highDig;
		boolean palendromic = true;
		
		for (int cnt = 1; cnt <= size/2; cnt++) {
			lowDig = (number % (int) (Math.pow(10, cnt))) / (int) (Math.pow(10,(cnt - 1)));
			highDig = (number / (int) (Math.pow(10,(size - (cnt))))) % 10;
			palendromic = (lowDig == highDig) ? true : false;
		}
		if (palendromic) {
			System.out.println(number + " is a palendromic number");
		} else {
			System.out.println(number + " is not a palendromic number");
		}
	}
	
	/**
	 * What is the @nth Fibonacci number, where @n is a positive integer?
	 * 
	 * Print your solution in the following formats: "The 21st Fibonacci number is X."
	 *                                               "The 22nd Fibonacci number is X."
	 *                                               "The 23rd Fibonacci number is X."
	 *                                               "The 24th Fibonacci number is X."
	 *                                               
	 * @param n
	 */
	
	public void fibonacci(int n) {
		int num1 = 1;
		int num2 = 1;
		int sum = 1;
		for (int cnt = 0; cnt < (n - 2); cnt++) {
			sum = num1 + num2;
			num1 = num2;
			num2 = sum;
		}
		
		String appendage;
		switch (n % 10) {
			case 1:
				appendage = "st";
				break;
			case 2:
				appendage = "nd";
				break;
			case 3:
				appendage = "rd";
				break;
			default:
				appendage = "th";
		
		}
		
		if (n > 10 && n < 20) {
			appendage = "th";
		}
		
		System.out.println("The " + n + appendage + " Fibbonacci number is " + sum);
	}
	
	/**
	 * What is the sum of all multiples of @x and @y less than @limit, where @x, @y, and
	 * @limit are positive integers?
	 * 
	 * Print your solution in the following format: "The sum is X."
	 * 
	 * @param limit
	 */
	
	public void multiples(int x, int y, int limit) {
		long sum = 0;
		for (int count = 1; count <= limit; count++) {
			if (count % x == 0 && (count / x) % y == 0) {
				sum += count;
			}
		}
		System.out.println(sum);
	}
	
}