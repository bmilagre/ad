package ch.hslu.ad.sw04;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.UUID;

public class StackCompare {
    private static final Logger LOG = LoggerFactory.getLogger(StackCompare.class);

    public static void main(String[] args) {
        Integer[] batchSizes = {100000, 1000000, 100000000};
        String[] sampleData = getSampleData(100000);

        LOG.info("Starting with test cases");
        LOG.info("_________________________");

        for(Integer batchSize : batchSizes) {
            LOG.info("Testing with size: " + batchSize);
            LOG.info("Result of JavaStack: " + testJavaStack(batchSize, sampleData) + "ms;");
            LOG.info("Result of CustomStack: " + testCustomStack(batchSize, sampleData) + "ms;");
            LOG.info("Result of DequeStack: " + testDequeStack(batchSize, sampleData) + "ms;");
            LOG.info("_________________________");
        }

        LOG.info("Ending with test cases");
    }

    private static Long testJavaStack(int size, String[] sampleData){
        final java.util.Stack<String> stack = new java.util.Stack<>();
        stack.setSize(size);

        final long startTime = System.nanoTime();

        for(String s : sampleData){
            stack.push(s);
        }

        final long endTime = System.nanoTime();

        return (endTime-startTime)/1000000L;
    }

    private static Long testCustomStack(int size, String[] sampleData){
        final ch.hslu.ad.sw02.Stack<String> stack = new ch.hslu.ad.sw02.Stack<>(size);

        final long startTime = System.nanoTime();

        for(String s : sampleData){
            stack.push(s);
        }

        final long endTime = System.nanoTime();

        return (endTime-startTime)/1000000L;
    }

    private static Long testDequeStack(int size, String[] sampleData){
        final Deque<String> stack = new ArrayDeque<>(size);

        final long startTime = System.nanoTime();

        for(String s : sampleData){
            stack.addFirst(s);
        }

        final long endTime = System.nanoTime();

        return (endTime-startTime)/1000000L;
    }

    public static String[] getSampleData(int size){
        String[] data = new String[size];

        for(int i = 0; i < size; i++){
            String randomStr = UUID.randomUUID().toString();
            data[i] = randomStr;
        }

        return data;
    }
}
