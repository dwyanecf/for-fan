package com.fanchen.clearmind.lianjia;

import java.util.*;

/**
 * For instance, the dimensions of all buildings in Figure A are recorded as:
 * [ [2 9 10], [3 7 15], [5 12 12], [15 20 10], [19 24 8] ] .
 *
 * The output is a list of "key points" (red dots in Figure B) in the format of
 * [ [x1,y1], [x2, y2], [x3, y3], ... ] that uniquely defines a skyline.
 * A key point is the left endpoint of a horizontal line segment.
 * Note that the last key point, where the rightmost building ends,
 * is merely used to mark the termination of the skyline, and always has zero height.
 * Also, the ground in between any two adjacent buildings should be considered part of the skyline contour.
 *
 * For instance, the skyline in Figure B should be represented as:
 * [ [2 10], [3 15], [7 12], [12 0], [15 10], [20 8], [24, 0] ].
 */
public class TheSkylineProblem {
    public List<int[]> getSkyline(int[][] buildings) {
       List<int[]> res= new ArrayList<>();
       List<int[]> height = new ArrayList<>();
       for(int[] b : buildings){
           height.add(new int[]{b[0],-b[2]});
           height.add(new int[]{b[1], b[2]});
       }
       Collections.sort(height,(a1,a2)->{
           return a1[0]!=a2[0]? a1[0]-a2[0]:a1[1]-a2[1];
       });
       Queue<Integer> q = new PriorityQueue<>((a,b)->(b-a));
       q.offer(0);
       int pre =0;
       for(int[] h:height){
            if(h[1]<0){
                q.offer(-h[1]);
            }else{
                q.remove(h[1]);
            }
            int cur = q.peek();
            if(cur!=pre){
                res.add(new int[]{h[0],cur});
                pre = cur;
            }
       }
       return res;
    }

//    public static void main(String[] args){
//        //[[2,9,10],[3,7,15],[5,12,12],[15,20,10],[19,24,8]]
//      int[][] buildings = {{2,9,10},{3,7,15},{5,12,12},{15,20,10},{19,24,8}};
//      getSkyline(buildings);
//    }
}
