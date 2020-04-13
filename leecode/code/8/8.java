class Solution {
    public int myAtoi(String str) {
        int count = 0;
        long sum = 0;
        int flag = 0;
        for(int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                continue;
            } else if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                if (sum < 0) {
                    sum = sum * 10 - (str.charAt(i) - '0');
                    if (sum <= -2147483648) {
                        return -2147483648;
                    }
                } else {
                    sum = sum * 10 + str.charAt(i) - '0';
                    if (sum > 2147483647) {
                        return 2147483647;
                    }
                }
                count++;
                if(i + 1 < str.length()) {
                    if (str.charAt(i + 1) < '0' || str.charAt(i + 1) > '9') {
                        if (flag == 1) {
                                if (sum > 0) {
                                    sum = -1 * sum;
                                }
                            }
                        return (int)sum;
                    }
                }
            } else if (str.charAt(i) == '-') {
                flag = 1;
                if (count == 0) {
                    if (i + 1 < str.length()) { 
                        if (str.charAt(i + 1) >= '0' && str.charAt(i + 1) <= '9') {
                            sum = -1 * (str.charAt(i + 1) - '0');
                            i++;
                            if (i + 1 < str.length()) {
                                if (str.charAt(i + 1) < '0' || str.charAt(i + 1) > '9') {
                                    if (flag == 1) {
                                            if (sum > 0) {
                                                sum = -1 * sum;
                                            }
                                        }
                                    return (int)sum;
                                }
                            }
                        } else {
                            if (flag == 1) {
                                if (sum > 0) {
                                    sum = -1 * sum;
                                }
                            }
                            return (int)sum;
                        }
                    } else {
                        return 0;
                    }
                    count++;
                }
            } else if (str.charAt(i) == '+') {
                if (count == 0) {
                    if (i + 1 < str.length()) {
                        if (str.charAt(i + 1) >= '0' && str.charAt(i + 1) <= '9') {
                            sum = 1 * (str.charAt(i + 1) - '0');
                            i++;
                            if (i + 1 < str.length()) {
                                if (str.charAt(i + 1) < '0' || str.charAt(i + 1) > '9') {
                                    if (flag == 1) {
                                            if (sum > 0) {
                                                sum = -1 * sum;
                                            }
                                        }
                                    return (int)sum;
                                }
                            }
                        } else {
                            if (flag == 1) {
                                if (sum > 0) {
                                    sum = -1 * sum;
                                }
                            }
                            return (int)sum;
                        }
                    } else {
                        return 0;
                    }
                    count++;
                }
            } else {
                break;
            }
        }
        if (flag == 1) {
            if (sum > 0) {
                sum = -1 * sum;
            }
        }
        return (int)sum;
    }
}
