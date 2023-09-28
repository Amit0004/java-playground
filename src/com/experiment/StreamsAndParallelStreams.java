package com.experiment;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamsAndParallelStreams {


    private static void getStreamStats() {
        List<Integer> streamInput = IntStream.rangeClosed(1, 10000).boxed().collect(Collectors.toList());
        Long streamStartTime = System.nanoTime();
        List<Integer> streamOutput = streamInput.stream().map(StreamsAndParallelStreams::square).collect(Collectors.toList());
        Long streamEndTime = System.nanoTime();
        Long executionTime = (streamEndTime - streamStartTime) / 1000000;
        System.out.println(">>>>>>>>>> stream duration : " + executionTime);
    }

    private static void getParallelStreamStats() {

        List<Integer> parallelStreamInput = IntStream.rangeClosed(1,10000).boxed().collect(Collectors.toList());
        Long streamStartTime = System.nanoTime();
        List<Integer> parallelStreamOutput = parallelStreamInput.parallelStream().map(StreamsAndParallelStreams::square).collect(Collectors.toList());
        Long streamEndTime = System.nanoTime();
        Long executionTime = (streamEndTime - streamStartTime) / 1000000;
        System.out.println(">>>>>>>>>> parallel stream duration : " + executionTime);
    }

    private static Integer square(Integer number) {
        return number * number;
    }

    public static void main(String[] args) {
        getStreamStats();
        getParallelStreamStats();
    }



}
