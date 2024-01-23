package com.javaxx;
import static com.javaxx.Sanjeev.DynamicIO.*;

class LineExtraction{
    int[][] LineExtraction_all_sign;
    char[] user_input_char;
    void signloc(String user_input){
        this.user_input_char = user_input.toCharArray();
        int[] plus = sj_find(this.user_input_char,'+');
        int[] minus = sj_find(this.user_input_char,'-');
        int[] mul = sj_find(this.user_input_char,'*');
        int[] div = sj_find(this.user_input_char,'/');
        // PEMDAS
        int all_sign[][] = {mul,div,plus,minus};
        this.LineExtraction_all_sign  = all_sign;
        // print("debug signloc");
        // print(all_sign);
    }

    int[] sj_find(char[] arr, char sign){
        int count = 0;
        for (int i=1; i<arr.length; i++)
            if (arr[i] == sign)
                count++;

        int indexes[] = new int [count];
        int j=0;
        for (int i=1; i<arr.length; i++)
            if (arr[i] == sign){
                indexes[j] = i;
                j++;
            }
        return indexes;
    }
}