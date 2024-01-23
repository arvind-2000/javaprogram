package com.javaxx;

class PrimitiveCalculation extends LineExtraction{

    void calculation(String input){
        char[] signs = {'*','/','+','-'};
        signloc(input);

        for(int i = 0;i<LineExtraction_all_sign.length;i++){
            for(int j = 0;j<LineExtraction_all_sign[i].length;j++){
                String s = "";
                char[] result2 =brain(user_input_char,LineExtraction_all_sign[i][j],signs[i]);
                for(char k:result2){
                    if((int)k!=0){
                        s+=k;
                    }
                }
                signloc(s);
//                print("this is the result:"+new String(user_input_char));


            }

        }


    }

    char[] brain(char[] user_input_char_sj, int current_sign_value, char current_sign_char){

        int place_value = 0;
        int after_number = 0;
        int after_stopper = -1;
        char[] signs = {'*','/','+','-'};
        for (int i=current_sign_value+1; i<user_input_char_sj.length;i++){
            if (user_input_char_sj[i] == signs[0] || user_input_char_sj[i] == signs[1] || user_input_char_sj[i] == signs[2] || user_input_char_sj[i] == signs[3]){

                after_stopper=i;
                break;
            }
            else{
                // print(after_number);
                after_number*=Math.pow(10,place_value);
                // print(after_number);
                after_number+=Character.getNumericValue(user_input_char_sj[i]);
                // print(after_number);
                if (place_value == 0)
                    place_value++;
            }
        }
//        print("This is the after number: "+after_number);
        place_value = 0;
        int before_number = 0;
        int before_stopper = -1;
        for (int i=current_sign_value-1; i>=0;i--){
            if (user_input_char_sj[i] == signs[0] || user_input_char_sj[i] == signs[1] || user_input_char_sj[i] == signs[2] || user_input_char_sj[i] == signs[3]){
                before_stopper=i;
                break;
            }
            else{
                before_number+=Character.getNumericValue(user_input_char_sj[i])*Math.pow(10,place_value);
                place_value++;
            }
        }
        // if (user_input_char_sj[before_stopper] == '-')
        //     before_number*=(-1);
//        print("This is the before number: "+before_number);
        int calculated_number_i;
        if (current_sign_char == '+')
            calculated_number_i = before_number+after_number;
        else if (current_sign_char == '*')
            calculated_number_i =  before_number*after_number;
        else if (current_sign_char == '/')
            calculated_number_i =  before_number/after_number;
        else
            calculated_number_i = before_number-after_number;
        // print("debug line 98");
        // print(before_number);
        // print(after_number);
        // print(calculated_number_i);
        String calculated_number_s = Integer.toString(calculated_number_i);
        char[] calculated_number_ca = calculated_number_s.toCharArray();
        // print("This is calculation: ");
        // print(calculated_number_ca);
        // print(after_stopper);
        // print(before_stopper);
        char[] final_array;
        if (before_stopper == -1 && after_stopper == -1)
            final_array = new char[calculated_number_ca.length];
        else
            final_array = new char[before_stopper+1+calculated_number_ca.length+(user_input_char_sj.length-after_stopper)];
        // print("debug line 89");
        // print(final_array.length);
        // print(final_array);
        for (int i=0; i<before_stopper; i++){
            final_array[i]=user_input_char_sj[i];
        }
        // print("debug line 94");
        // print(final_array);
        // print(before_stopper);
        if (before_stopper == -1)
            before_stopper = 0;
        else{
            final_array[before_stopper] = user_input_char_sj[before_stopper];
            before_stopper++;
        }
        for (char i: calculated_number_ca){
            final_array[before_stopper] = i;
            before_stopper++;
        }
        // print(final_array);
        // print(after_stopper);
        if (after_stopper != -1){
            for (int i=after_stopper; i<user_input_char_sj.length; i++){
                final_array[before_stopper] = user_input_char_sj[i];
                before_stopper++;
            }
        }
        // print(final_array);
        return final_array;
    }
}