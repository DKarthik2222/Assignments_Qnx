package part2;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

public class Main {
    public static void main(String args[]) throws IOException, InterruptedException, ExecutionException {
        long startTime = System.currentTimeMillis();
        int threads = 4;
        ExecutorService executorService = Executors.newFixedThreadPool(threads);
        final ExecutorCompletionService<Map<String, Long>> completionService = new ExecutorCompletionService<>(executorService);

        List<List<String>> listOfLists = getSplitLists(threads);

        Map<String, Long> allCounts = executeWork(completionService, listOfLists);

        LinkedHashMap<String, Long> sortedMap = allCounts.entrySet().stream()
            .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                (oldValue, newValue) -> oldValue, LinkedHashMap::new));
      List<Long> ints=new ArrayList<Long>();
      	sortedMap.entrySet().stream().filter(x -> "program".equals(x.getKey())).forEach(x -> ints.add(x.getValue()));;
        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        System.out.println("Total execution time is " + elapsedTime + " ms");
        Optional<Long> sum=ints.stream().reduce(Long::sum);
        System.out.println("Total occurance of word 'program' is:"+sum.get());
        executorService.shutdown();
    }
    private static Map<String, Long> executeWork(ExecutorCompletionService<Map<String, Long>> completionService, List<List<String>> listOfLists) throws InterruptedException, ExecutionException {
        listOfLists.forEach(sublist -> completionService.submit(new WordCounter(sublist)));
        Map<String, Long> allCounts = new HashMap<>();
        for (int i = 0; i < listOfLists.size(); i++) {
            Map<String, Long> newCounts = completionService.take().get();
            newCounts.forEach((k, v) -> allCounts.merge(k, v, Long::sum));
        }
        return allCounts;
    }
    private static List<List<String>> getSplitLists(int threads) throws IOException {
    	File file = new File("C:\\Users\\dkarthik\\desktop\\words.txt");
	      FileInputStream fis = new FileInputStream(file);
	      byte[] byteArray = new byte[(int)file.length()];
	      fis.read(byteArray);
	      String data = new String(byteArray);
	      List<String> lines = Arrays.asList(data.split("\n"));
        return splitList(lines, lines.size() / threads);
    }


    private static List<List<String>> splitList(List<String> originalList, int partitionSize) {
        List<List<String>> partitions = new LinkedList<>();
        for (int i = 0; i < originalList.size(); i += partitionSize) {
            partitions.add(originalList.subList(i,
                Math.min(i + partitionSize, originalList.size())));
        }
        return partitions;
    }
}

