import java.util.LinkedList;


public class Polynomial {
private LinkedList<String> terms = new LinkedList<String>(); 
      public Polynomial(String s){
           addTerm(s);
       }
       private void addTerm(String s){
           String delims="[(,)]+";
           String [] toks = s.split(delims);
           for (String p:toks){
               System.out.println(p+"Is there an empty string?");
           }
       }
       
       public static void main(String args[]) {
           Polynomial p = new Polynomial ("(2,3)(6,5)(7,9)(3,1)(4,2)");
       }
}
