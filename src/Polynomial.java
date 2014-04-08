import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;


public class Polynomial{
private LinkedList<int []> terms = new LinkedList<int []>(); 
      public Polynomial(String s){
           addTerm(s);
       }
      
      public class termComp implements Comparator<int[]>{
            public int compare(int[] a, int[] b){
                if (a[1] > b[1]) { return -1; }
                else if (a[1] == b[1]) { return 0; }
                else { return 1; }
            }
      }

       private void addTerm(String s){
           String delims="[()]+";
           String [] toks = s.split(delims);
           for (String p:toks){
               
               if (!p.equals("")){
                   int[] toadd = new int[] {0,0};
                   String delims1="[,]+";
                   String [] toks1 = p.split(delims1);
                   int cas =0;
                   
                   for (String q:toks1){
                       toadd[cas]=Integer.parseInt(q);
                       cas++;
                   }                   
                terms.addLast(toadd);
               }               
           }
           Collections.sort(terms,new termComp());
           for (int[] r:terms){
               System.out.println("Term1: "+r[0]+" Term2: "+r[1]);
           }
           System.out.println("----------------------------------------");
       }
       private Polynomial addPoly(Polynomial p){
           Polynomial a = p;
           int size =p.terms.size();
           for (int i=0;i<size;i++){
                for (int[] t:terms){
                    boolean present=false;
                    for (int[]q:a.terms){
                        if (q[1]==t[1])
                            present =true;
                    }
                    
                    if (p.terms.get(i)[1]==t[1]){
                        a.terms.get(i)[0]=p.terms.get(i)[0]+t[0];
                    }
                    if (p.terms.get(i)[1]!=t[1] && !(a.terms.contains(t)) && (!present)){
                        a.terms.add(t);
                    }
                }
           }
           Collections.sort(a.terms,new termComp());
           for (int[] r:a.terms){
               System.out.println("Term1: "+r[0]+" Term2: "+r[1]);
           }           
           return a;
           
       }
       private void merge(){
           for (int i=0;i<this.terms.size()-1;i++){
               boolean merge=false;
               do{
                   if (this.terms.get(i)[1]==this.terms.get(i+1)[1]){
                       
                       this.terms.get(i)[0]+=this.terms.get(i+1)[0];
                       this.terms.remove(i+1);
                       merge =true;
                   }
                   else 
                       merge = false;
               }
               while (merge);
               
           }System.out.println("Merge----------------------------------------");
           for (int[] r:this.terms){
               System.out.println("Term1: "+r[0]+" Term2: "+r[1]);
           }  System.out.println("Merge done----------------------------------------");
       }
       private Polynomial multiPoly(Polynomial p){
           Polynomial a = new Polynomial("(0,0)");
           for (int i[]:p.terms){                
               for (int [] j: terms){
                   int[] w = new int[2];
                   w[0]=i[0]*j[0];
                   w[1]=i[1]+j[1];
                   a.terms.add(w);
               }
           }
           Collections.sort(a.terms,new termComp());
           System.out.println("Multi----------------------------------------");
           for (int[] r:a.terms){
               System.out.println("Term1: "+r[0]+" Term2: "+r[1]);
           }  System.out.println("Multi done----------------------------------------");
           return a;
       }
       
       public static void main(String args[]) {
          Polynomial p = new Polynomial ("(2,3)(6,5)(7,9)(3,1)(4,2)");
           Polynomial z = new Polynomial ("(2,3)(6,5)(7,9)(3,1)(4,2)(4,8)");
           Polynomial e = p.addPoly(z);
           Polynomial q = p.multiPoly(z);
           //Polynomial a = new Polynomial ("(2,3)(1,3)");
           //a.merge();
           q.merge();
       }
       

}//I want to be able to see this in my git history
///I want to see if this one really works!

