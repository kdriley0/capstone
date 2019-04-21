/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cosc489_pt_kdriley0;

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
            next = n;
        }

        public Node getpre() {
            return pre;
        }

        public void setPre(Node n) {
            pre = n;
        }

        public String toString() {
            String out = "" + data;
            return out;
        }

    }
    private Node tail = null;
    public int size = 0;

    public NumberRing() {//make a new numberRing
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
            newest.setPre(tail);
            size++;
              System.out.println("tail"+ tail.data+"tail.getpre "+tail.getpre().data);
            
        }
    }
    public void Append(int n){
        this.insert(n);
        tail=tail.getNext();
    }
    public void delete(){
        Node head = tail.getNext();
        if(head==tail) tail=null;
        else{
            tail=tail.getNext();
            tail.setNext(head.getNext());
            head.getNext().setPre(tail);
        }
    }
    public String toString(){
        String out="";
      
         if(tail==null) {
               System.out.println("hi2");
             return out;
         }
        Node ref = tail.next;
        
          while(ref.next!= tail.next){
//              System.out.println(out);
              out+=ref.data+" ";
             ref=ref.next;
          }
              return out;
      }
     public void rotate(){
          if (tail != null)// if empty do nothing
          tail=tail.getNext();// the old head becomes the tail 
      }
     public void rotateBack(){
          if (tail != null)// if empty do nothing
          tail=tail.getpre();// the old head becomes the tail 
      }
}