package LeetCode.Easy;

import java.util.HashMap;
import java.util.Iterator;

/**
 * Given n points in the plane that are all pairwise distinct, a "boomerang" is a tuple of points (i, j, k)
 * such that the distance between i and j equals the distance between i and k (the order of the tuple matters).
 * <p>
 * Find the number of boomerangs. You may assume that n will be at most 500 and coordinates of points are
 * all in the range [-10000, 10000] (inclusive).
 * <p>
 * Input:
 * [[0,0],[1,0],[2,0]]
 * <p>
 * Output:
 * 2
 * <p>
 * Explanation:
 * The two boomerangs are [[1,0],[0,0],[2,0]] and [[1,0],[2,0],[0,0]]
 */
public class _447_NumberOfBoomerangs {
    public int numberOfBoomerangs(int[][] points) {
        int result;
        HashMap<Double, Integer> distance;

        result = 0;
        double tmpDist;
        for (int i = 0; i < points.length; i++) {
            distance = new HashMap<Double, Integer>();
            for (int j = 0;j < points.length ; j++) {
                if(j == i)
                    continue;
                tmpDist = getDistance(points[i], points[j]);
                if (distance.containsKey(tmpDist)) {
                    distance.put(tmpDist, distance.get(tmpDist) + 1);
                } else {
                    distance.put(tmpDist, 1);
                }
            }
            Iterator<Double> it = distance.keySet().iterator();
            while (it.hasNext()) {
                tmpDist = distance.get(it.next());
                if (tmpDist >= 2) {
                    result += tmpDist * (tmpDist - 1);
                }
            }
        }
        return result;
    }

    private double getDistance(int[] point1, int[] point2) {
        double distance = 0;
        for (int i = 0; i < point1.length; i++) {
            distance += Math.pow(point1[i] - point2[i], 2);
        }
        return Math.sqrt(distance);
    }
}
