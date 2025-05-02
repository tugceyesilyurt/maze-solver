/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author u
 */
package mazesolverproject;

public class Stack<T> {
    private Node<T> top;
    
    public Stack() {  // Stack sınıfının yapıcı metodu (constructor)
        top = null;   // Yapıcı metot, top'un başlangıçta null olduğunu belirtir.
    }
    
    public boolean isEmpty() {// Stack'in boş olup olmadığını kontrol eden metot
        if (topState==null) {        // Eğer top null ise, stack boştur ve true döndürülür, aksi halde false döndürülür.
            return true;
        }
        return false;
    }
    
    public void push(T n) {      // Stack'e eleman ekleyen metot

        Node<T> newNode = new Node<>(n);   // Yeni bir düğüm (node) oluşturulur ve verilen değeri içine koyar.

        newNode.next = top;  // Yeni düğümün next referansı, top'un referansını alır.

        top = newNode;    // Top, yeni düğümü gösterir, yani yeni düğüm artık stack'in en üstünde bulunur.      
    }
    
    public T pop() { // Stack'ten eleman çıkaran metot
        Node<T> t = top;  // Top'un referansını geçici bir değişkene atar.
        if(!isEmpty()) // Eğer stack boş değilse, top'u bir altındaki düğüme kaydırır.
            top = top.next;
        return t.data;  // Çıkarılan elemanın değerini döndürür.
    }

    private static class Node<T>{  // Stack'in düğüm (node) yapısını tanımlayan iç içe sınıf (inner class)

        Node<T> next = null;  // Bir sonraki düğümün referansı
        T data ; // Düğümün içindeki veri

        Node(T data){  // Düğüm yapıcısı (constructor)
            this.data = data; // Düğümün içindeki veriyi ayarlar.
        }

    }
}

