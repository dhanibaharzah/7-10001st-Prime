public class nthPrime {

    public static void main(String[] args) {
        //you can change n th number here, i put 10001 first
        int result = getNthPrime(10001);
        System.out.println("Hasil: " + result);
    }

    private static int getNthPrime(int n) {
        int max = (int) (1.4 * n * Math.log(n));
        boolean[] isPrimeArray = new boolean[max + 1];
        for (int i = 2; i <= max; i++) {
            isPrimeArray[i] = true;
        }
        for (int i = 2; i * i <= max; i++) {
            if (isPrimeArray[i]) {
                for (int j = i; i * j <= max; j++) {
                    isPrimeArray[i * j] = false;
                }
            }
        }
        
        // Find the nth prime
        int nthPrime = 0;
        int index = 0;
        for(boolean isPrime : isPrimeArray) {
            if(isPrime) {
                nthPrime++;
            }
            if(nthPrime == n) {
                return index;
            }
            index++;
        }
        throw new IllegalArgumentException("n is not valid");
    }
}
