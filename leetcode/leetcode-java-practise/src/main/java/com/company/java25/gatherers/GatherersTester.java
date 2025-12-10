package com.company.java25.gatherers;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Gatherers;
import java.util.stream.IntStream;

/*
 * Gatherers.fold -> collapse elements into a single result
 * Gatherers.scan(seed, op) -> running total/accumulation (like reduce, but we see every step)
 * Gatherers.windowFixed(size) -> split stream into fixed size batches
 * Gatherers.windowSliding(size) -> create overlapping sliding windows
 * Gatherers.mapConcurrent(size) -> run mapping functions concurrently (great for I/O network tasks)
 * */
public class GatherersTester {

    static void main() {
        GatherersTester tester = new GatherersTester();
        tester.sumUsingStream();
        tester.sumUsingGatherersFold();

        tester.sumUsingStreamAtomicInteger();
        tester.sumUsingGatherersScan();

        tester.splitIntoFixedSizeBatchUsingStream();
        tester.splitIntoFixedSizeBatchUsingGatherersWindowFixed();

        tester.slidingWindowUsingStream();
        tester.slidingWindowUsingGatherersWindowFixed();

    }

    private void sumUsingStream() {
        List<Integer> numbers = List.of(10, 20, 30, 40);
        int sum = numbers.stream().reduce(0, Integer::sum);
        System.out.println(sum);
    }

    private void sumUsingGatherersFold() {
        List<Integer> numbers = List.of(10, 20, 30, 40);
        numbers.stream()
                .gather(Gatherers.fold(() -> 0, Integer::sum))
                .findFirst().ifPresent(System.out::println);
    }

    private void sumUsingStreamAtomicInteger() {
        List<Integer> transactions = List.of(1000, -200, -500, 200, -300);
        // 800, 300, 500, 200
        AtomicInteger runningTotal = new AtomicInteger(0);
        List<Integer> balanceHistory = transactions.stream()
                .map(runningTotal::addAndGet)
                .toList();
        System.out.println(balanceHistory);
    }

    private void sumUsingGatherersScan() {
        List<Integer> transactions = List.of(1000, -200, -500, 200, -300);
        // 800, 300, 500, 200
        List<Integer> balanceHistory = transactions.stream()
                .gather(Gatherers.scan(() -> 0, Integer::sum))
                .toList();
        System.out.println(balanceHistory);
    }

    private void splitIntoFixedSizeBatchUsingStream() {
        List<Integer> orders = List.of(101, 102, 103, 104, 105, 106, 107);
        // [101,102,103], [104,105,106], [107]
        int batchSize = 3;
        List<List<Integer>> batches = IntStream.range(0, batchSize)
                .mapToObj(i -> orders.subList(i * batchSize, Math.min((i + 1) * batchSize, orders.size())))
                .toList();
        System.out.println("orderIds in batches: " + batches);
    }

    // Kafka and Async Pipeline
    private void splitIntoFixedSizeBatchUsingGatherersWindowFixed() {
        List<Integer> orders = List.of(101, 102, 103, 104, 105, 106, 107);
        // [101,102,103], [104,105,106], [107]
        int batchSize = 3;
        List<List<Integer>> batches = orders.stream()
                .gather(Gatherers.windowFixed(batchSize))
                .toList();
        System.out.println("orderIds in batches: " + batches);
    }

    // Moving average of stock price
    // Rolling temp sensor reading
    private void slidingWindowUsingStream() {
        List<Integer> orders = List.of(101, 102, 103, 104, 105, 106, 107);
        // [[101,102,103], [102,103,104], [103,104,105]]
        int windowSize = 3;
        List<List<Integer>> orderIdList = IntStream.range(0, 3)
                .mapToObj(i -> orders.subList(i, i + windowSize))
                .toList();
        System.out.println("Processing with stream : " + orderIdList);
    }

    private void slidingWindowUsingGatherersWindowFixed() {
        List<Integer> orders = List.of(101, 102, 103, 104, 105, 106, 107);
        // [[101,102,103], [102,103,104], [103,104,105]]
        int windowSize = 3;
        List<List<Integer>> orderIdListGatherers = orders.stream()
                .gather(Gatherers.windowFixed(windowSize))
                .toList();
        System.out.println("Processing with Gatherers : " + orderIdListGatherers);
    }

}
