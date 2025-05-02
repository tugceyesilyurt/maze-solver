/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mazesolverproject;

/**
 *
 * @author u
 */


public class MazeSolverProject {

    public static void main(String[] args) {
        int grid = 5;
        int[][] maze = getMaze(grid); //getMaze(grid) metodunu kullanarak bir labirent oluşturuluyor ve maze değişkenine atanıyor.

        
        Stack <CurrentInfo>path = new Stack(); //Bir Stack olan path oluşturuluyor.
                                                // labirenti gezdikçe bunun içi dolacak

        maze[1][1]=2;  //Labirentin başlangıç noktası olan maze[1][1] konumuna 2 atanıyor (bu, başlangıç noktasını temsil eder).
        MazeUtility.plotMaze(maze);   //MazeUtility.plotMaze(maze) metodu çağrılarak labirentin ilk hali ekrana yazdırılıyor.
       mazestep solver=new mazestep(maze);
        
        


        try{
            solver.solveMaze(maze,path,grid);
        }catch (Exception e) {
            System.out.println("There is no solution ");
            System.exit(0);
        }

        /*Şimdi, main metodun geri kalanında ise, labirent üzerinde gezinmeye yönelik bir algoritma yazılması bekleniyor.
          Ancak, bu kısım henüz yazılmamış ve yorum satırları içinde bir açıklama verilmiş:

        // To do: starting from the coordinates [1,1], use the path stack to navigate in the maze and 
        // find a way to [2*grid-1, 2*grid-1] coordinates
        // use the following code to print the maze at each step
        // MazeUtility.plotMaze(maze);  
        // DO NOT change any of the given code   */
    }
    
      public static int[][] getMaze(int grid) {
        MazeGenerator maze = new MazeGenerator(grid);
        String str = maze.toString();
        
        int[][] maze2D = MazeUtility.Convert2D(str);    
        return maze2D;

        
        /*Bu açıklamada, [1,1] koordinatlarından başlayarak, path stack'ini kullanarak labirentte gezinmeye 
         ve [2*grid-1, 2*grid-1] koordinatlarına ulaşmaya çalışmanız isteniyor.
         Her adımda labirentin durumunu ekrana yazdırmak için MazeUtility.plotMaze(maze) metodu kullanılmalı. 
         Ancak, bu işlemleri gerçekleştirecek olan kod henüz yazılmamıştır ve bu görevi tamamlamak size düşüyor.   */
    }   
}

