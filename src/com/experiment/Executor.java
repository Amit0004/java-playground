package com.experiment;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Executor {

    public static void main(String[] args) {
        List<Laptop> list = new ArrayList<>();
        list.add(new Laptop("Mac", 32, 512));
        list.add(new Laptop("Microsoft", 16, 1024));
        list.add(new Laptop("Dell", 64, 256));

//        Comparator<Laptop> comp = new Comparator<Laptop>() {
//            @Override
//            public int compare(Laptop o1, Laptop o2) {
//                if(o1.getRam() > o2.getRam()) {
//                    return 1;
//                }
//                return -1;
//            }
//        };

        Collections.sort(list, (o1, o2) -> {
            if(o1.getRam() > o2.getRam()) {
                return 1;
            }
            return -1;
        });

        for(Laptop l : list) {
            System.out.println(l.getRam());
        }

    }
}
