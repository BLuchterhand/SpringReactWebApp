package com.benlu.demo.tools;

import com.benlu.demo.model.Person;
import com.benlu.demo.repository.UserRepository;
import com.benlu.demo.service.FilesStorageService;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class TsvReader {

    UserRepository userRepository;

    public TsvReader(UserRepository _userRepository) throws IOException, URISyntaxException {
        userRepository = _userRepository;
    }

    public void initDB(String path) throws IOException, URISyntaxException {
        File file = new File(path);

        StringTokenizer tokenizer;
        BufferedReader TSVFile = new BufferedReader(new FileReader(file.getPath()));
        String dataRow = TSVFile.readLine();

        while (dataRow != null){
            tokenizer = new StringTokenizer(dataRow,"\t");
            List<String>dataArray = new ArrayList<String>() ;
            while(tokenizer.hasMoreElements()){
                dataArray.add(tokenizer.nextElement().toString());
            }
            userRepository.save(new Person(dataArray.get(0), dataArray.get(1), dataArray.get(2), dataArray.get(3), dataArray.get(4), dataArray.get(5)));
            dataRow = TSVFile.readLine();
        }

        TSVFile.close();

        System.out.println("Done importing data!");
    }

    private File getFileFromResource(Path fileName) throws URISyntaxException {

        ClassLoader classLoader = getClass().getClassLoader();
        URL resource = classLoader.getResource(String.valueOf(fileName));
        if (resource == null) {
            throw new IllegalArgumentException("file not found! " + fileName);
        } else {

            // failed if files have whitespaces or special characters
            //return new File(resource.getFile());

            return new File(resource.toURI());
        }

    }

}
