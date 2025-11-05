package org.SVDancer;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.Console;
import java.io.File;
import java.text.CompactNumberFormat;
import java.util.ArrayList;

public class SVD {
    public SVD(String fileName, svdCpu cpu)
    {
        cpuImpl = cpu;
        try {
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            doc = builder.parse(new File(fileName));
            doc.getDocumentElement().normalize();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void parse()
    {
        NodeList nodeList = doc.getElementsByTagName("peripheral");
        for (int nodeIndex = 0; nodeIndex < nodeList.getLength(); nodeIndex++) {
            Node item = nodeList.item(nodeIndex);
            if (item.getNodeType() == Node.ELEMENT_NODE) {
//                System.out.println(("Finded node: " + nodeIndex + " value: " + item.getTextContent()));
                cpuImpl.add_field(item);
            }
        }
    }
//
//    private void parse_register(Node register)
//    {
//        ArrayList<String> result;
//        while ( register.hasChildNodes()) {
//            if (register.getNodeType() == Node.ELEMENT_NODE) {
//                return;
////                result.add()
//            }
//        }
//    }
//
//    public ArrayList<Node> get_peripherals()
//    {
//        NodeList nodeList = doc.getElementsByTagName("peripheral");
//        ArrayList<Node> nodes = new ArrayList<Node>();
//        for (int nodeIndex = 0; nodeIndex < nodeList.getLength(); nodeIndex++) {
//            nodes.add(nodeList.item(nodeIndex));
//        }
//        return nodes;
//    }

    private final Document doc;
    private svdCpu cpuImpl;
}
