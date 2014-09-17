/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
    public int maxPoints(Point[] points) {
        if(points == null || points.length == 0)
            return 0;
        int max = 0;
        for(Point p : points){
            Map<Double, Integer> map = new HashMap<Double, Integer>();
            int same = 0;
            for(Point an : points){
                if(p.x == an.x && p.y == an.y){
                    same++;
                    continue;
                }
                double slope = 0.0;
                if(p.x == an.x)
                    slope = 0.0;
                else if(p.y == an.y)
                    slope = Double.MAX_VALUE;
                else
                    //beaware of this type casting thing, integer divided by integer is a integer, not a double
                    slope = (double)(p.x - an.x)/(p.y - an.y);
                if(map.get(slope) == null)
                    map.put(slope, 1);
                else
                    map.put(slope, map.get(slope)+1);
            }
            // then we get max points for this p
            int local_max = 0;
            for(double slope : map.keySet()){
                local_max = Math.max(local_max, map.get(slope));
            }
            max = Math.max(max, local_max+same);
        }
        return max;
    }
}
