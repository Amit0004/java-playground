package com.company;

import java.util.*;

public class FrequencyQueries {

    public static List<Integer> freqQuery(List<List<Integer>> queries) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> tracker = new HashMap<>();
        Map<Integer, Set<Integer>> freqCounter = new HashMap<>();
        for(int i = 0; i < queries.size(); i++) {
            List<Integer> q = queries.get(i);
            int op = q.get(0);
            int el = q.get(1);

            int oldCount = tracker.getOrDefault(el, 0);
            int newCount;

            switch(op) {
                case 1: {
                    newCount = oldCount + 1;
                    tracker.put(el, newCount);
                    if(freqCounter.containsKey(oldCount)) {
                        freqCounter.get(oldCount).remove(el);
                    }
                    freqCounter.putIfAbsent(newCount, new HashSet<>());
                    freqCounter.get(newCount).add(el);
                    break;
                }
                case 2: {
                    newCount = oldCount > 1 ? oldCount - 1 : 0;
                    tracker.put(el, newCount);
                    if (freqCounter.containsKey(oldCount)) {
                        freqCounter.get(oldCount).remove(el);
                    }

                    freqCounter.putIfAbsent(newCount, new HashSet<>());
                    freqCounter.get(newCount).add(el);
                    break;
                }
                case 3: {
                    if (el > queries.size()) result.add(0);
                    else {
                        result.add((el == 0 || freqCounter.getOrDefault(el, Collections.emptySet()).size() > 0) ? 1 : 0);
                    }
                    break;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        FrequencyQueries fq = new FrequencyQueries();
        List<List<Integer>> q = new ArrayList<>();
        q.add(new ArrayList<>(Arrays.asList(3, 4)));
        q.add(new ArrayList<>(Arrays.asList(2, 1003)));
        q.add(new ArrayList<>(Arrays.asList(1, 16)));
        q.add(new ArrayList<>(Arrays.asList(3, 1)));
        for(Integer i : fq.freqQuery(q)) {
            System.out.println(i);
        }
    }
}
