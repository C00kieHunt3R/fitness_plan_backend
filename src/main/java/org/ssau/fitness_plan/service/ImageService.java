package org.ssau.fitness_plan.service;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

@Service
public class ImageService {

    public byte[] getImage(String image) throws IOException {
        //InputStream in = getClass().getResourceAsStream("src/main/resources/images/" + image); //images/img_3.png
        InputStream in = new FileInputStream("src/main/resources/images/" + image);
        byte[] bytes = IOUtils.toByteArray(in);
        in.close();
        return bytes;
    }
}
