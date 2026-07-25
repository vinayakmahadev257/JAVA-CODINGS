class UndergroundSystem {


    private static class CheckInInfo {
        String stationName;
        int checkInTime;

        CheckInInfo(String stationName, int checkInTime) {
            this.stationName = stationName;
            this.checkInTime = checkInTime;
        }
    }
    private static class JourneyData {
        double totalTime;
        int tripCount;

        JourneyData(double totalTime, int tripCount) {
            this.totalTime = totalTime;
            this.tripCount = tripCount;
        }
    }

    private Map<Integer, CheckInInfo> checkInMap;
    private Map<String, JourneyData> journeyMap;

    public UndergroundSystem() {
        checkInMap = new HashMap<>();
        journeyMap = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        checkInMap.put(id, new CheckInInfo(stationName, t));
    }
    
    public void checkOut(int id, String stationName, int t) {
        CheckInInfo info = checkInMap.remove(id);
        
        String routeKey = info.stationName + "->" + stationName;
        int travelTime = t - info.checkInTime;
        JourneyData data = journeyMap.getOrDefault(routeKey, new JourneyData(0, 0));
        data.totalTime += travelTime;
        data.tripCount += 1;
        
        journeyMap.put(routeKey, data);
    }
    
    public double getAverageTime(String startStation, String endStation) {
        String routeKey = startStation + "->" + endStation;
        JourneyData data = journeyMap.get(routeKey);
        
        return data.totalTime / data.tripCount;
    }
}