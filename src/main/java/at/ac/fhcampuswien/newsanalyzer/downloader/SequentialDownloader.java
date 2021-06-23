package at.ac.fhcampuswien.newsanalyzer.downloader;

import java.util.List;

public class SequentialDownloader extends Downloader {

    @Override
    public int process(List<String> urls) {
        int count = 0;
        long startSeq= System.currentTimeMillis();
        for (String url : urls) {
            try {
                String fileName = saveUrl2File(url);
                if (fileName != null)
                    count++;
            }catch(Exception e){
                System.out.println("Not found, can't download");
            }
        }long endSeq= System.currentTimeMillis();
        System.out.println("Download time for sequential: " + ((endSeq-startSeq)) + "milliseconds");
        return count;
    }
}
