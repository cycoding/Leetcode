public class MaxPoints {
	public int maxPoints(Point[] points) {
		int max = 0;

		for (Point point : points) {
			Map<Double, Integer> map = new HashMap<Double, Integer>();
			for (Point another : points) {
				if (another != point) {

					double slope = (point.x - another.x)
							/ (point.y - another.y);
					if (map.get(slope) == null) {
						map.put(slope, 1);
					} else
						map.put(slope, map.get(slope) + 1);
					max = Math.max(max, map.get(slope));
				}
			}
		}
		return max;
	}
}
