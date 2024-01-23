package com.javaxx;

import java.util.*;
import java.lang.String;

import static com.javaxx.Sanjeev.DynamicIO.*;


public class Main {
    public static void main(String[] args){

        clrscr();
        print("Enter your numbers");
        String user_main_input = input();
        PrimitiveCalculation plus = new PrimitiveCalculation();
        plus.calculation(user_main_input);
        if(plus.user_input_char.length>0){
            System.out.print("Result: ");
            for(char i:plus.user_input_char){
                System.out.print(i);
            }
        }

    }
}


