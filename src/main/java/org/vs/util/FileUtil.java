package org.vs.util;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class FileUtil {

    public String readStringFromFile(String filename) {
        String content = new String();
        try {
            content = IOUtils.toString(this.getClass().getResourceAsStream("/mock/" + filename),
                    "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return content;
    }

}
