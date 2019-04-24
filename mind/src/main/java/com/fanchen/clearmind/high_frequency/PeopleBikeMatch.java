package com.fanchen.clearmind.high_frequency;

import java.util.ArrayList;
import java.util.List;

public class PeopleBikeMatch {

    class Location{
        int x;
        int y;
        public Location(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        char[][] graph = new char[][]{
                {'O', 'P', 'O', 'B', 'P', 'O', 'P'},
                {'O', 'O', 'O', 'O', 'O', 'O', 'O'},
                {'B', 'O', 'O', 'B', 'O', 'O', 'B'}
        };
    }


    public  List<Location[][]> peopleMatchBike(char[][] grid){
        int row = grid.length;
        int col = grid[0].length;
        List<Location> peopleList = new ArrayList<>();
        List<Location> bikeList = new ArrayList<>();
        for(int i =0;i<row;i++){
            for(int j =0;j<col;j++){
                if(grid[i][j]=='P'){
                    peopleList.add(new Location(i,j));
                }else if(grid[i][j]=='B'){
                    bikeList.add(new Location(i,j));
                }
            }
        }


        return null;
    }


}
