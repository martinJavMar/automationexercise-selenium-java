package utils;

import java.io.File;

public class DownloadUtils {
	
	 public static boolean isDownloadCompleted(String folderPath) {

	        File folder = new File(folderPath);


	        for(int i = 0; i < 10; i++) {


	            File[] files = folder.listFiles();


	            if(files != null) {

	                for(File file : files) {

	                    if(file.length() > 0 
	                       && !file.getName().endsWith(".crdownload")) {

	                        return true;
	                    }
	                }
	            }


	            try {
	                Thread.sleep(1000);
	            } catch (InterruptedException e) {
	                Thread.currentThread().interrupt();
	            }

	        }


	        return false;
	    }
       
}


