class UndergroundSystem {
    
    int count = 0;
    int [] nums = new int[10001];
    String [] starts = new String[10001];
    String [] ends = new String[10001];
    int [] times = new int[10001];
    
    public UndergroundSystem() {
    }
    
    public void checkIn(int id, String stationName, int t) {
        nums[count] = id;
        starts[count] = stationName;
        times[count] = t;
        count++;
    }
    
    public void checkOut(int id, String stationName, int t) {
        int i = 0;
        for (i = 0; i < count; i++) {
            if (id == nums[i]) {
                String temp = ends[i];
                if (temp == null) {
                    break;
                }
            }
        }
        ends[i] = stationName;
        times[i] = t - times[i];
    }
    
    public double getAverageTime(String startStation, String endStation) {
        int time = 0;
        int jishu = 0;
        for (int i = 0; i < count; i++) {
            if (starts[i].equals(startStation)) {
                if (endStation.equals(ends[i])) {
                    time += times[i];
                    jishu++;
                }
            }
        }
        if (jishu == 0)
            return 0;
        else
            return time * 1.0 / jishu;
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */
