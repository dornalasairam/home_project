package com.troweprice.automation.utilities;

import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import com.github.mustachejava.MustacheFactory;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;

public class CommonUtils {

    public static String transformTemplate(String templateName, Object object) {
        MustacheFactory mf = new DefaultMustacheFactory();
        Mustache mustache = mf.compile(templateName);
        StringWriter stringWriter = new StringWriter();
        mustache.execute(stringWriter, object);
        return stringWriter.toString();
    }

    public static void cleanDirectory() {
        try {
            FileUtils.cleanDirectory(new File(".\\Downloads"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void deleteFile(String fileName) {
        File file = new File(".\\Downloads\\" + fileName);
        boolean result = file.delete();
        Assert.assertTrue(result);
    }

    public static boolean isFileExists(String fileName) {
        File file = new File(".\\Downloads\\" + fileName);
        return file.exists();
    }
}
