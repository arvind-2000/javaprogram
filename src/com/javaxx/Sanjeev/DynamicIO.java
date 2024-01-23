package com.javaxx.Sanjeev;
import java.util.*;
public class DynamicIO{
    // public static void main(String[] args){
    //     var x = "hello world";
    //     print("Below is Dynamic variable");
    //     print(x);
    //     print("Below is Dynamic input");
    //     var y = input();
    //     // print(y.getClass()=="class java.lang.Integer"?"True":"false");
    //     // System.out.println(y.getClass().getName);
    //     print(y);
    // }
    public static <T> void print(T args){
        if (args instanceof int[]){
            int temp[] = (int[])args;
            System.out.print("array([");
            for (int i: temp)
                System.out.print(i+" ");
            System.out.println("])");
        }
        else if (args instanceof int[][]){
            int temp[][] = (int[][])args;
            System.out.print("array([");
            for (int i=0;i<temp.length;i++){
                if (i>0)
                    System.out.print("       [");
                else
                    System.out.print("[");
                for (int j:temp[i])
                    System.out.print(j+" ");
                System.out.print("]");
                if (i<(temp.length-1))
                    System.out.println();
            }
            System.out.println("])");
        }
        else if (args instanceof char[]){
            char temp[] = (char[])args;
            System.out.print("array([");
            for (char i: temp)
                System.out.print(i+" ");
            System.out.println("])");
        }
        else
            System.out.println(args);
    }

    public static <T> void print(T args, boolean nextline) {
        if (!nextline)
            System.out.print(args);
        else
            System.out.println(args);
    }

    public static void clrscr(){
        System.out.print("\033[H\033[2J");
    }

    @SuppressWarnings("unchecked")
    public static <T> T input(){
        Object result;
        Scanner sc = new Scanner(System.in);
        boolean i = sc.hasNextInt(),
                l = sc.hasNextLong(),
                f = sc.hasNextFloat(),
                d = sc.hasNextDouble(),
                b = sc.hasNextBoolean();
        if (i) {
            result = sc.nextInt();
        }
        else if (l) {
            result = sc.nextLong();
        }
        else if (f) result = sc.nextFloat();
        else if (d) result = sc.nextDouble();
        else if (b) result = sc.nextBoolean();
        else result = sc.nextLine();
        return (T) result;
    }

    public static String dtype(Object variable){
        Class<?> type = variable.getClass();
        return type.getSimpleName();
    }

}