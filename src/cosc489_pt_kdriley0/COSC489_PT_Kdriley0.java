/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cosc489_pt_kdriley0;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Kevin Riley spring 19 for capstone class
 */
public class COSC489_PT_Kdriley0 {

    static NumberRing nr = new NumberRing();

    public static void main(String[] args) throws IOException {
        input();
        int num = 0;
        String input = "";
        
        while (true) {
             System.out.println(nr.toString());
            Scanner scan = new Scanner(System.in);
            System.out.println(" What would you like to do you options are \n"
                    + "insert, append, delete, jump, sort, print or q to quit");
            input = scan.nextLine();
            input = input.toLowerCase();
            if (input.compareTo("insert") == 0) {
                System.out.println("what number do you want to insert");
                num = scan.nextInt();
                nr.insert(num);
            }
            if (input.compareTo("print") == 0) {
                System.out.println(nr.toString());
            }
            if (input.compareTo("q") == 0) {
               break;
            }
            if (input.compareTo("delete") == 0) {
                nr.delete();
            }
             if (input.compareTo("append") == 0) {
                System.out.println("what number do you want to insert");
                num = scan.nextInt();
                nr.Append(num);
            }
        }
    }

    public static void input() throws IOException {
        String line = "";

        File in = new File("../COSC489_PT_Input.txt");

        Scanner scan = new Scanner(in);
        while (scan.hasNext()) {
            line = scan.nextLine();
            String[] arr = line.split(",");
            for (int i = 0; i < arr.length; i++) {
                //System.out.println(arr[i]);
                nr.insert(Integer.parseInt(arr[i]));

            }
        }

    }

}
