/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


package mazesolverproject;


public class MazeUtility {
    
    public static int[][] Convert2D(String str) { // 2D int dizisi oluşturup bir labirenti temsil eden String'i bu diziye dönüştüren metod
                int i=0;
                int j=0;
                
                for (i=0;str.charAt(i)!='\n';i++) {}  // İlk satırın uzunluğunu bulmak için '\n' karakterine kadar olan karakter sayısını hesapla                  
                int[][] maze2D = new int[i+1][i+1];   // Labirenti temsil edecek 2D int dizisini oluştur (i+1, çünkü diziler 0'dan başlar)
                i=0; // i'yi sıfırla (satır sayısı)
                j=0;  //j'i sıfırla (sütun sayısı)
                
        for (int c = 0; c<str.length(); c++) {  // String üzerinde dolaşarak labirenti 2D int dizisine dönüştür
            
            if (str.charAt(c)=='X') {  
                maze2D[i][j]=1; // 'X' karakteri duvarı temsil eder, bu nedenle 1 olarak atanır
                j++;
            }
            else if (str.charAt(c)=='O') {
                maze2D[i][j]=2;// 'O' karakteri hedefi temsil eder, bu nedenle 2 olarak atanır
                j++;
            }
            else if (str.charAt(c)==' ') {  
                j++;                   // Boş karakter, bir şey atanmaz, sadece sütun sayısı artırılır

            }
            else if (str.charAt(c)=='\n') {
                i++; j=0;    // Yeni satır karakteri, satır sayısını artır ve sütun sayısını sıfırla
            }                    
        }
        return maze2D;   // Dönüştürülmüş labirenti içeren 2D int dizisini geri döndür

    }
    
    public static void plotMaze(int[][] maze) {
        for (int i=0;i<maze.length;i++) {  // Bu döngü labirentin satırlarını temsil eder.
            for (int j=0;j<maze[0].length;j++) //, her bir satırdaki sütunları temsil eder. maze[0].length ifadesi, labirentin bir satırdaki sütun sayısını belirler. Burada, labirentin her satırının aynı uzunluğa sahip olduğu varsayılır.
                if (maze[i][j]==1)
                    System.out.print('X'); //Eğer labirentin bu konumunda duvar (1) bulunuyorsa, 'X' karakterini ekrana yazdırır.
                else if (maze[i][j]==2)  
                    System.out.print('O'); //Eğer labirentin bu konumunda hedef (2) bulunuyorsa, 'O' karakterini ekrana yazdırır.
                else
                    System.out.print(' '); //boşluk karakterini ekrana yazdırır.
            System.out.println();   //Her bir satırın sonunda bir satır sonu karakteri ekler, böylece bir sonraki satıra geçilir.
        }        
    }
}
