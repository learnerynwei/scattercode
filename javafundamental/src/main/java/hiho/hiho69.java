package hiho;

import java.util.Scanner;

public class hiho69 {
	public static int score(int n, int d[], int T){
		if( n <= 0) return 0;
		int s[] = new int[n];
		int r[] = new int[n];

		if( d[0] >= T){
			s[0] = 0;
			r[0] = 0;
		}else{
			s[0] = 1;
			r[0] = T - d[0];
		}

		for (int i = 1; i < d.length; i++) {
			if( r[i-1] +  T > d[i]){
				s[i] = s[ i-1 ] + 1;
				r[i] = r[i-1] + T - d[i];
			}else{
				s[i] = s[i-1];
				r[i] = 0;
			}
		}
		return s[d.length - 1];
	}

	public static void main(String[] args){
		int n, k;
		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();
		k = scanner.nextInt();
		//scanner.;
//		String line = scanner.nextLine();
		int d[] = new int[n];
		for (int i = 0; i < d.length; i++) {
			d[i] = scanner.nextInt();
		}
		int left = 1, right = k+1;
		int target = (n+1)/2;
		while( left  < right){
			int mid = left + (right - left)/2;
			int score = hiho69.score(n, d, mid);

			if( score < target) left = mid + 1;
			else right = mid;
		}
		System.out.println(right);
	}
}