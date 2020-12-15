public class oddPascal {
	
	public static final int ROW = 50;
	
	public static void main(String[] args) {
		int odds = 0;
		int total = 0;
		int theodds = 0;
		for (int i = 0; i <= ROW; i++) {
			String binaryString = Integer.toBinaryString(i);
        	String[] binary = binaryString.split("");
        	int hamming = getSum(binary);
        	theodds += Math.pow(2, hamming);
			String line = i+ "";
			for (int x = ROW; x > i; x--) {
				if (x % 2 == 0) {
					line += " ";
				}
			}
			for (int j = 0; j <= i; j++) {
				total++;
				String coff = coefficient(i, j) + "";
				if (isEven(coff)) {
					line += 0;
				}
				else {
					line += 1;
					odds++;
				}
			}
			System.out.println(line);
		}
		System.out.println("The percentage of numbers that are odd is: " + 100*(double)odds/total);
	}
	
	static long coefficient(int row, int num) {
		long res = 1; 
		String result = res + "";
        // Since C(n, k) = C(n, n-k) 
        if (num > row - num) 
        	num = row - num; 
  
        // Calculate value of 
        // [n * (n-1) *---* (n-k+1)] / [k * (k-1) *----* 1] 
        for (int i = 0; i < num; ++i) { 
        	result = result.substring(result.length()-result.length());
        	res = Long.parseLong(result);
            res *= (row - i); 
            res /= (i + 1); 
            result = res + "";
        } 
  
        return res; 
	}
	
	static boolean isEven(String c) {
		if (Integer.parseInt(c.substring(c.length()-1)) % 2 == 0) {
			return true;
		}
		return false;
	}
	
	static int getSum(String[] str) 
    {     
        int sum = 0;
        
        for (int i = 0; i < str.length; i++) {
        	if (Integer.parseInt(str[i]) == 1) {
        		sum++;
        	}
        }
        return sum;
    }
}