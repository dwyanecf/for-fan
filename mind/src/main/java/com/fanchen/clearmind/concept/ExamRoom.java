package com.fanchen.clearmind.concept;

import java.util.TreeSet;

public class ExamRoom {
    public int N;
    public TreeSet<Integer> locations;

    public ExamRoom(int N) {
        this.N = N;
        locations = new TreeSet();
    }

    public int seat() {
        //Let's determine student, the position of the next
        //student to sit down.
        int curLocation = 0;
        if (locations.size() > 0) {
            //Tentatively, dist is the distance to the closest student,
            //which is achieved by sitting in the position 'student'.
            //We start by considering the left-most seat.
            int dist = locations.first();
            Integer prev = null;
            for (Integer loc : locations) {
                if (prev != null) {
                    //For each pair of adjacent students in positions (prev, s),
                    //d is the distance to the closest student;
                    //achieved at position prev + d.
                    int d = (loc - prev) / 2;
                    if (d > dist) {
                        dist = d;
                        curLocation = prev + d;
                    }
                }
                prev = loc;
            }

            //Considering the right-most seat.
            if (N - 1 - locations.last() > dist)
                curLocation = N - 1;
        }

        //Add the student to our sorted TreeSet of positions.
        locations.add(curLocation);
        return curLocation;
    }

    public void leave(int p) {
        locations.remove(p);
    }

    public static void main(String[] args){
        ExamRoom ex = new ExamRoom(10);
        ex.seat();
        ex.seat();
        ex.seat();
        ex.seat();
        ex.leave(4);
        ex.seat();
    }
}
