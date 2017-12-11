/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab05;

public class CListaLaczona<T> {
    
   
    
    private class CElement
        {
            public CElement prev;
            public CElement next;
            public T data;

        public CElement(CElement p, CElement n, T d) 
        {
            prev = p; next = n; data = d; 
        }
    }
     private CElement HEAD;
     private int ILE;
     
     public CListaLaczona()
     {
        HEAD = null;
        ILE = 0;
     }

     public CListaLaczona(T elem)
     {
        ILE = 1;
        HEAD = new CElement(null, null, elem);
     }

     public void add(T elem)
     {
        CElement ost = HEAD;
        if(ost==null)
        {
            HEAD = new CElement(null, null, elem);
        }
        else
        {
            while(ost.next!=null)ost=ost.next;
            ost.next = new CElement(ost, null, elem);
        }
        ILE++;
     }

     public T get(int idx)
     {
         CElement ost = HEAD;
        int i = 0;
        while ( i++ < idx )
        {
            ost = ost.next;
            if(ost==null)throw new IndexOutOfBoundsException("Indeks poza zakresem");
        }
        return ost.data;
     }

     public int size()
     {
         return ILE;
     }

     public void clear()
     {
        HEAD = null;
        ILE = 0;
     }
    
}
