/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stackForProPrefix;
public class StackX {
    int maxSize;
   int top;
   char[] stackChar;

    public StackX(int maxSize) {
        this.maxSize = maxSize;
        this.top = -1;
        this.stackChar = new char[maxSize];
    }
   public void push(char j){
       stackChar[++top] = j;
   }
   public char pop(){
       return stackChar[top--];
   }
   public boolean isEmpty(){
     return (top == -1);  
   }
   public boolean isFull(){
       return (top==maxSize-1);
   }
}
