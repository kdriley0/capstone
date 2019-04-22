/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cosc489_pt_kdriley0;

import java.util.ArrayList;

/**
 *
 * @author kevin
 */
public class NumberRing {

    public static class Node {

        private Node pre;
        private Node next;
        private int data;

        Node(int d, Node n, Node p) {
            data = d;
            next = n;
            pre = p;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node n) {
            this.next = n;
        }

        public Node getpre() {
            return pre;
        }

        public void setPre(Node n) {
            this.pre = n;
        }

        public String toString() {
            String out = "" + data;
            return out;
        }

    }
    private Node head;
    private Node tail;
    public int size = 0;

    public NumberRing() {
        //head = tail = null;
    }

    public boolean isEmpty() {
        return size == 0;
    }

   public void insert(int n) {
        if (size == 0) {
            this.tail = new Node(n, null, null);
            tail.setNext(tail);// links back to itself
            tail.setPre(tail);
            //System.out.println("hi");
            size++;
        } else {
             
            Node newest= new Node(n, tail.getNext(),tail);
            
            tail.setNext(newest);
    //        System.out.println("tail getN " + tail.getNext().data+" newest.getNext "+newest.getNext().data);
          //  newest.setPre(tail);
            size++;
           //   System.out.println("tail"+ tail.data+"tail.getpre "+tail.getpre().data);
            
        }
    }

    

    public void Append(int n) {
        this.insert(n);
        tail = tail.getNext();
    }

    public Node delete() {
        
        Node head = tail;
        System.out.println("head "+ head.data);
        if (head == null) {
            return null;
        } else {
            tail = tail.getNext();
            tail.setNext(head.getNext());
            head.getNext().setPre(tail);
            System.out.println("tail.getN "+ tail.getNext().data);
            size--;
            
        }
        return head;
    }
    public void sort(){
        int j=0;
        Node head= tail.getNext();
        int start=head.data;
        ArrayList<Integer> al = new ArrayList<>();
        while(head.next!=null&&j<size){                         //put all of the nodes into an array
            al.add(head.data);
       //     System.out.println("head "+ head.data);
            head=this.delete();
            j++;
            
        }
        
         bubbleSort(al);                                // sort the array 
         for(int i = 0; i < size; i++){
             this.insert(al.get(i));                    // put it back
         }
         
         while(tail.next.next.data!= start){// so that it will end with the head == start
             tail=tail.next;
         }
    }
    public static void bubbleSort(ArrayList v) {
        int i, j, n = v.size();// declares the int values that this sort is going to use 
        Comparable first = 0, second;// the values  that we can use to compare with each other to see which is greater/less than 
        for (i = 1; i < n; ++i)//the outer for loop which goes from index 1  to size 
        {
            for (j = n - 1; j >= i; --j) //the inner for loop which starts at the end and works its way down  which compares the values 
            {
                first = (Comparable) v.get(j - 1);//sets the comparable first to the index j-1 so one less than the second 
                second = (Comparable) v.get(j);//sets second to be = to j or one greater than first
                if (first.compareTo(second) > 0) //checks to see if the first is greater than the second
                {
                    swap(v, j - 1, j);// if it is then it swaps the first and the second
                }
            }
        }
    }
      public static void swap(ArrayList v, int index1, int index2)
    {
        Object temp = v.get(index1);// establishes a object variable and initalises it to the object at index 1
        v.add(index1, v.get((index2)));// switches the object at index one with the object at index2
        v.add(index2, temp);//puts the object origionally held in index1 in index2
    }

    public String toString(){
        String out="";
      
         if(tail==null) {
               System.out.println("hi2");
             return out;
         }
        Node ref = tail;
          out+=ref.data+" ";
        
          while(ref.next!= tail){
      //        System.out.println(out);
              out+=ref.data+" ";
             ref=ref.next;
          }
              return out;
      }

    public void rotate() {
        if (tail != null)// if empty do nothing
        {
            tail = tail.getNext();// the old head becomes the tail 
        }
    }

    public void rotateBack() {
        if (tail != null)// if empty do nothing
        {
            tail = tail.getpre();// the old head becomes the tail 
        }
    }
}
