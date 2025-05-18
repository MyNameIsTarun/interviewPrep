package dsa_problems;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class TestCollection {
    public static void main(String[] args)
    {
        List<Integer> al = new CopyOnWriteArrayList();
        al.add(1);
        al.add(2);
        al.add(3);
        al.add(4);
        al.add(5);

        System.out.println(al);

        Iterator<Integer> itr = al.iterator();
//        itr = al.iterator();
        while (itr.hasNext()) {
            if (itr.next() == 3) {
//                al.remove(3);
//            	itr.remove();
            	al.removeIf(n -> n == 3);
            }
        }

        System.out.println(al);
    }
} 
