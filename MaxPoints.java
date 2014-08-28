public int maxPoints(Point[] points) {
        	int max = 0;
        		
    		for (Point point : points) {
    			Map<Double, Integer> map = new HashMap<Double, Integer>();
                int same = 1;
                int local_max = 0;
                double slope = 0.0;
    			for (Point another : points) {
    			    if(another != point){
    			        // if the coordinates are same, then record its number and treat them as a same point
    			        if (another.y == point.y && another.x == point.x){
    			            same += 1;
    			            continue;
    			        }
        				if (another.y == point.y)
        					slope = (double) Integer.MAX_VALUE;
        				else
        					slope = (double) (point.x - another.x)
        							/ (point.y - another.y);
        				if (map.get(slope) == null)
        					map.put(slope, 1);
        				else
        					map.put(slope, map.get(slope) + 1);
        			}
    			}
    			Set<Double> keys = map.keySet();
    			for (double key : keys)
    				local_max = Math.max(local_max, map.get(key));
    			max = Math.max(max, local_max+same);
    		}
    		return max;
    }