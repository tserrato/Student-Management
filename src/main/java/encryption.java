
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tjser
 */
public class encryption {
    
    public static String encrypt(String input){
        char[] out = new char[input.length()];
        char[] chars= input.toCharArray();
        int i = 0;
        for(char c: chars){
            c+=7;
            out[i] = c;
            i++;

        }
        return String.valueOf(out);
        

        
    }


     


    public static String decrypt(String input){
        String decrypt;
        int end;
            char[] out = new char[input.length()];
        char[] chars= input.toCharArray();
        int i = 0;
        for(char c: chars){
            c-=7;
            out[i] = c;
            i++;

        }
         decrypt = String.valueOf(out);
         end = decrypt.lastIndexOf("]");
         return decrypt.substring(0,end+1);
}
}
