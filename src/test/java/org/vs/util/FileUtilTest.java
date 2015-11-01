package org.vs.util;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"file:src/main/resources/spring/applicationContext.xml"})
public class FileUtilTest {

    @Autowired
    FileUtil fileUtil;
    
    @Test
    public void testReadStringFromFile() throws Exception {
        String content = fileUtil.readStringFromFile("test.json");
        assertEquals("Hello", content);
    }
}