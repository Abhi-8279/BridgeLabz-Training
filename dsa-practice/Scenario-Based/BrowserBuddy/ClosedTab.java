

class StackNode {
 String data;      // store data
 StackNode below;  // reference to the node below

 public StackNode(String data) {
     this.data = data;
     this.below = null;
 }
}

public class ClosedTab {
 private StackNode top; // top of the stack

 public void push(String data) {
     StackNode newNode = new StackNode(data);

     newNode.below = top; 
     top = newNode;      
 }

 // method to return and remove the top element
 public String pop() {
     if (top == null) {
         System.out.println("No closed tab to restore");
         return null;
     }
     String url = top.data; 

     top = top.below; 
     return url;
 }
}
