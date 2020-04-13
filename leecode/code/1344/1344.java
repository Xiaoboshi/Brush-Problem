class Solution {
    public double angleClock(int hour, int minutes) {
        double a = minutes / 60.0;
        double b = minutes / 5.0;
        a += (double)hour;
        if (a >= 12){
            a -= 12;
        }

        double c = Math.max(a, b) - Math.min(a, b);
        c *= 30;
        if (c > 180){
            c = 360 - c;
        }
        return c;

    }
}
