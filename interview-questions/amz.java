class solution {
	public List<List<Integer>> optimalUtilization(int maxTravelDist,
													List<List<Integer>> forwardRouteList,
													List<List<Integer>> returnRouteList){
		class RouteComparator implements Comparable<List<Integer>> {
			@Override
			public int compare(List<Integer> o1, List<Integer> o2) {
				return o1.get(1) - o2.get(1);
			}
		}

		forwardRouteList.sort(new RouteComparator);
		returnRouteList.sort(new RouteComparator);
		long difference = Long.MAX_VALUE;
		

		while () {}
	}
}