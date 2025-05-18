package dsa_problems;

public class SquareRoot {

	public static void main(String[] args) {
		
		int x = 2147483647;
		
		int ans = 0;
        int low = 1, high = x;

        while(low <= high){
            int mid = (low+high)/2;

            if(mid == x/mid){
                ans = mid;
                break;
            }
            else if(mid < x/mid){
                ans = mid;
                low = mid+1;
            }
            else {
                high = mid-1;
            }
        }
		
		System.out.println(ans);

	}

}
