package org.SVDancer;

import org.w3c.dom.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class SWD {
    public SWD(String fileName)
    {
        try {
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document doc = builder.parse(new File(fileName));
            doc.getDocumentElement().normalize();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
