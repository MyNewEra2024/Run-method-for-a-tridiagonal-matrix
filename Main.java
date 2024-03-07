public class Main
{
	public static void main(String[] args) {

        int n = 100;

        double[] a = new double[n];
        double[] b = new double[n];
        double[] c = new double[n];
        double[] d = new double[n];
        double[] X = new double[n];

        double[] alp = new double[n];
        double[] bet = new double[n];

        for (int i = 0; i < n; i++) {
            b[i] = i + 1;
            a[i] = 0.4;
            c[i] = 0.5;
            d[i] = 12;
        }

        alp[0] = -c[0] / b[0];
        bet[0] = d[0] / b[0];

        for (int i = 1; i < n; i++) { 
            alp[i] = -c[i] / (a[i] * alp[i - 1] + b[i]);
            bet[i] = (d[i] - a[i] * bet[i - 1]) / (a[i] * alp[i - 1] + b[i]);
        }

        X[n - 1] = (d[n - 1] - a[n - 1] * bet[n - 2]) / (alp[n - 2] + b[n - 1]);

        for (int i = n - 2; i >= 0; i--) {
            X[i] = alp[i] * X[i + 1] + bet[i];
        }

        for (int i = 0; i < n; i++) {
            System.out.printf("X[%d] = %.8f%n", i + 1, X[i]);
        }
	}
}
