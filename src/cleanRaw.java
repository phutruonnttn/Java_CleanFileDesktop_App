
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import javafx.scene.shape.Path;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author truongnguyen
 */
public class cleanRaw {
    
    public static void main(String[] args) throws IOException {
        File folder = new File("/Users/truongnguyen/Desktop");
        File[] listOfFiles = folder.listFiles();
 
        for (File file : listOfFiles) {
            if (file.isFile()) {
                if(getFileExtension(file).equals("pdf")){
                    File fileImage = new File("/Users/truongnguyen/Desktop/document");
                    if(!fileImage.exists()){
                        fileImage.mkdir();
                    }
                    Files.move(Paths.get(file.getPath()), Paths.get(fileImage.getPath()+"/"+file.getName()));
                    
                }
            }
        }
    }
 
    public static String getFileExtension(File file) {
        String name = file.getName();
        int lastIndexOf = name.lastIndexOf(".");
        if (lastIndexOf == -1) {
            return ""; // empty extension
        }
        return name.substring(lastIndexOf+1);
    }
}
