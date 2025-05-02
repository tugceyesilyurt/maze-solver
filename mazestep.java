/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mazesolverproject;

/**
 *
 * @author u
 */


public class mazestep {
    CurrentInfo current;
    int[][] tempMaze;

    public mazestep(int[][] maze) {
        this.tempMaze = new int[maze.length][];
        for (int i = 0; i < maze.length; i++) {
            this.tempMaze[i] = maze[i].clone();
        }
        this.current = new CurrentInfo();
    }
    public void solveMaze(int[][] maze, Stack<CurrentInfo> path, int grid) {
        boolean flag = false;
        path.push(current);
        while (true) {
            System.out.println("Current position : (" + current.row +","+current.col+")");
            if (tempMaze[current.row][current.col + 1] == 0) { //mark=tempMaze
                current.col++;
                maze[current.row][current.col] = 2;
                maze[current.row][current.col - 1] = 0;
                flag = true;
            }
            else if (tempMaze[current.row][current.col - 1] == 0) {
                current.col--;
                maze[current.row][current.col] = 2;
                maze[current.row][current.col + 1] = 0;
                flag = true;
            }
            else if (tempMaze[current.row + 1][current.col] == 0) {
                current.row++;
                maze[current.row][current.col] = 2;
                maze[current.row - 1][current.col] = 0;
                flag = true;
            }
            else if (tempMaze[current.row - 1][current.col] == 0) {
                current.row--;
                maze[current.row][current.col] = 2;
                maze[current.row + 1][current.col] = 0;
                flag = true;
            }
            else { // no path out cornered
                try {
                    maze[current.row][current.col]=0;
                    current = path.pop();
                    maze[current.row][current.col]=2;

                } catch (Exception e) {
                    System.out.println("There is no solution ");
                    System.exit(0);
                }
                flag = false;
            }
            if (flag) {
                tempMaze[current.row][current.col] = 2;
                path.push(new CurrentInfo(current.row,current.col));
                flag=false;
            }

            System.out.println();
            MazeUtility.plotMaze(maze);

            if(current.row==2*grid-1 && current.col==2*grid-1){
                return;
            }
        }
    }

}

