public class NextNumber {
    public static void main(String args[]) {
        int x = -22;
        int y = 1024359867;
        int z = 1920;

        System.out.println("Next of x = " + getNumber(x));
        System.out.println("Next of y = " + getNumber(y));
        System.out.println("Next of z = " + getNumber(z));
    }

    private static int getNumber(int n) {
        boolean isNegative = n < 0;
        n = isNegative ? -1*n : n;
        String ns = Integer.toString(n);
        // When the input contains all digits
        if(ns.length() >= 10 && "0123456789".chars().allMatch(c -> ns.contains(""+(char)c))) {
            return -1;
        }
        boolean notFound = true;
        int next = -1;
        while (notFound) {
            next = isNegative ? --n : ++n;
            String nextS = Integer.toString(next);
            notFound = ns.chars().anyMatch(c -> nextS.contains("" + (char) c));
        }
        return isNegative ? -1*next : next;
    }
}
