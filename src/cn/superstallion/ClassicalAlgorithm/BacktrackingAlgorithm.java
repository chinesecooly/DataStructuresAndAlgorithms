package cn.superstallion.ClassicalAlgorithm;

import java.util.Arrays;

/**
 *  回溯算法
 */
public class BacktrackingAlgorithm {

    public static void main(String[] args) {
        getWay(maze, 1, 1);
        for (int[] row:maze){
            System.out.println(Arrays.toString(row));
        }
    }

    public static int[][] maze={
            {1,1,1,1,1},
            {1,0,0,0,1},
            {1,0,1,0,1},
            {1,1,0,0,1},
            {1,1,1,1,1}
    };

    public static boolean getWay(int[][] maze,int x,int y){
        if (maze[maze.length-2][maze[0].length-2]==2){
            return true;
        }else if(maze[x][y]==0){
            maze[x][y]=2;
            if (getWay(maze,x+1,y)){
                return true;
            }else if (getWay(maze,x,y+1)){
                return true;
            }else if(getWay(maze,x-1,y)){
                return true;
            }else if (getWay(maze,x,y-1)){
                return true;
            }else {
                maze[x][y]=3;
                return false;
            }
        }else {
            return false;
        }
    }
}
