class Solution {
    public int[][] reconstructQueue(int[][] people) {

        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) return o1[0] - o2[0];
                else return o1[1] - o2[1];
            }
        });

        for (int i = 0; i < people.length; i++) {
            ArrayList<Integer> temp = new ArrayList();
            for (int j = 0; j < i; j++) {
                if (people[j][0] >= people[i][0]) {
                    temp.add(j);
                }
            }
            if (temp.size() > people[i][1]) {
                int[] k = {people[i][0], people[i][1]};
                int index = temp.get(people[i][1]);
                for (int j = i - 1; j >= index; j--) {
                    people[j + 1][0] = people[j][0];
                    people[j + 1][1] = people[j][1];
                }
                people[index][0] = k[0];
                people[index][1] = k[1];
            }
        }

        return people;

    }
}