package at.ac.fhcampuswien.newsanalyzer.downloader;



import java.util.List;
import java.util.concurrent.*;

public class ParallelDownloader extends Downloader{

    // Creates a thread pool that reuses a fixed number of threads
    ExecutorService executor = Executors.newFixedThreadPool(5);


    @Override
    public int process(List<String> urls) {
        int count = 0;
        long startPar= System.currentTimeMillis();
        for (String url : urls) {
            try {
                Future<?> future = executor.submit(()->{saveUrl2File(url);});
                count++;
            }catch(Exception e){
                System.out.println("Not found, can't download");
            }
        }long endPar= System.currentTimeMillis();
        System.out.println("Download time for parallel: " + ((endPar-startPar)) + "milliseconds");
        // shutdown threads
        executor.shutdown();
        return count;
    }




}
