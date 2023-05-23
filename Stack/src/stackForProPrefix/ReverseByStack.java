/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stackForProPrefix;

/**
 *
 * @author TuanVu113
 */
public class ReverseByStack {
    public static void main(String [] args){
        StackX stack = new StackX(10);
        String word = "hello";
        for(int i = 0; i<word.length(); i++){
            stack.push(word.charAt(i));
        }
       while(!stack.isEmpty()){
           char result = stack.pop();
           System.out.print(result);
           System.out.println(" ");
       } 
    }
}
