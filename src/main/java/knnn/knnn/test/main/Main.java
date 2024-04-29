package knnn.knnn.test.main;


import org.apache.commons.math3.stat.correlation.Covariance;
import org.apache.commons.math3.stat.descriptive.moment.Mean;
import org.apache.commons.math3.stat.descriptive.moment.Variance;

public class Main {
    public static double calculateMahalanobisDistance(double[] point1, double[] point2) {
        double[][] data = {{point1[0], point1[1], point1[2]}, {point2[0], point2[1], point2[2]}};
        double[] mean = new double[]{new Mean().evaluate(data[0], data[1])};
        Covariance covariance = new Covariance();
        double covariance1 = covariance.covariance(point1, point2);
        double[] variance = new double[]{new Variance().evaluate(data[0], data[1])};
        double denominator = 0.0;
        for (int i = 0; i < mean.length; i++) {
            denominator += (data[i][0] - mean[i]) * (data[i][1] - mean[i]) / (variance[i] * covariance1);
        }
        return Math.sqrt(denominator);
    }

    public static void main(String[] args) {
        double[] point1 = {5, 10, 15};
        double[] point2 = {20, 25, 30};
        double distance = calculateMahalanobisDistance(point1, point2);
        System.out.println("The Mahalanobis distance between the two points is: " + distance);
    }
}