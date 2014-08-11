public class Solution {
    public List<List<String>> findLadders(String start, String end,
			Set<String> dict) {
		List<List<String>> res = new ArrayList<List<String>>();
		// unvisited store all the words not visited in dict
		Set<String> unvisited = new HashSet<String>(dict);
		//visited store all the words visited in dict
		Set<String> visited = new HashSet<String>();	
		unvisited.add(end);
		visited.add(start);
		// this map records all the parents of one word
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		for(String str : unvisited)
			map.put(str, new LinkedList<String>());
		unvisited.remove(start);
		
		int curLevel = 1;
		int nextLevel = 0;
		Queue<String> queue = new LinkedList<String>();
		queue.add(start);
		boolean found = false;
		
		while(!queue.isEmpty()){
			String word = queue.poll();
			for(String next : findNextWords(word, unvisited)){
				// if this word is first added in this level, then we add it to queue
				if(visited.add(next)){
					nextLevel++;
					queue.offer(next);
				// we can't remove the visited word from unvisited now because other words from same level may generate this word
				// 	unvisited.remove(next);
				}
				map.get(next).add(word);
				if(next.equals(end)){
					found = true;
				}
			}
			
			curLevel--;
			// if all the words from last traverse are visited, then go to next level
			if(curLevel == 0){
				if(found)
					break;
				// when we finish traversing this level, we can remove all visited words from unvisited
				unvisited.removeAll(visited);
				curLevel = nextLevel;
				nextLevel = 0;
			}
		}
		if(found){
			List<String> solu = new ArrayList<String>();
			solu.add(end);
			findPath(start, end, map, solu, res);
		}
		return res;
	}
	public List<String> findNextWords(String word, Set<String> unvisited){
		List<String> res = new ArrayList<String>();
		for(int i = 0; i < word.length(); i++){
			StringBuffer sb = new StringBuffer(word);
			for(char ch = 'a'; ch <= 'z'; ch++){
				if(ch != word.charAt(i)){
					sb.setCharAt(i, ch);
					String temp = sb.toString();
					if(unvisited.contains(temp))
						res.add(temp);
				}
			}
		}
		return res;
	}
	public void findPath(String start, String word, Map<String, List<String>> map, List<String> solu, List<List<String>> res){
		if(word.equals(start)){
			res.add(new ArrayList<String>(solu));
			return;
		}
		List<String> parents = map.get(word);
		for(String str : parents){
			solu.add(0, str);
			findPath(start, str, map, solu, res);
			solu.remove(0);
		}
	}
}