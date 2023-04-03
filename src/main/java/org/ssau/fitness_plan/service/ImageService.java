package org.ssau.fitness_plan.service;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class ImageService {

    public List<String> getAll() throws IOException {
        File directoryPath = new File("src/main/resources/images");
        File files[] = directoryPath.listFiles();
        InputStream in;
        List<String> fnames = new ArrayList<>();
        for (File file : files) {
            fnames.add(file.getName());
//            in.reset();
        }
        return fnames;
    }

    public byte[] getImage(String image) throws IOException {
        //InputStream in = getClass().getResourceAsStream("src/main/resources/images/" + image); //images/img_3.png
        InputStream in = new FileInputStream("src/main/resources/images/" + image);
        byte[] bytes = in.readAllBytes();//IOUtils.toByteArray(in);
        in.close();
        return bytes;
    }
}
