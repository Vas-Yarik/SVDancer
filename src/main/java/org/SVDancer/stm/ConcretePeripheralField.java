package org.SVDancer.stm;
import org.SVDancer.svdPeripheralField;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class fieldNode{
    private final String nodeName;
    private final String nodeValue;
    private final List<fieldNode> children;

    public fieldNode(String name, String val) {
        nodeName = name;
        nodeValue = val;
        children = new ArrayList<>();
    }

    public fieldNode() {
        nodeName = "Empty";
        nodeValue = "Empty";
        children = new ArrayList<>();
    }

    public void addChild(fieldNode node) {
        children.add(node);
    }

    public void add_children(List<fieldNode> childrenList) {
        children.addAll(childrenList);
    }

    public String get_name() {
        return nodeName;
    }

    public String get_value() {
        return nodeValue;
    }

    public fieldNode get_child(String name) {
        for (fieldNode item : children) {
            if (item.get_name().equals(name)) {
                // TODO return child copy
                return item;
            }
        }
        return new fieldNode();
    }
}

public class ConcretePeripheralField implements svdPeripheralField {
    private fieldNode fieldsTreeRoot;

    public ConcretePeripheralField(Node svd) {
        if (svd.getNodeType() == Node.ELEMENT_NODE) {
            fieldsTreeRoot = new fieldNode();
            fieldsTreeRoot.add_children(parse_svd(svd));
        }
    }

    private ConcretePeripheralField() {}

    private List<fieldNode> parse_svd(Node svd) {
        List<fieldNode> tempNodesList = new ArrayList<>();
        NodeList tempSvdNodes = svd.cloneNode(true).getChildNodes();
        for (int fieldIndex = 0; fieldIndex < tempSvdNodes.getLength(); fieldIndex++) {
            if (tempSvdNodes.item(fieldIndex).getNodeType() == Node.ELEMENT_NODE) {
                fieldNode tempNode;
                if (tempSvdNodes.item(fieldIndex).getChildNodes().getLength() > 1) {
//                System.out.println("field: " + fieldIndex + ". Name: " + tempSvdNodes.item(fieldIndex).getNodeName() + ". Type: " + tempSvdNodes.item(fieldIndex).getNodeType());
//                System.out.println("Text: " + tempSvdNodes.item(fieldIndex).getTextContent());
                    tempNode = new fieldNode(tempSvdNodes.item(fieldIndex).getNodeName(), "");
                    tempNode.add_children(parse_svd(tempSvdNodes.item(fieldIndex).cloneNode(true)));
                } else {
                    tempNode = new fieldNode(tempSvdNodes.item(fieldIndex).getNodeName(), tempSvdNodes.item(fieldIndex).getTextContent());
                    tempNodesList.add(tempNode);
//                    System.out.println("field: " + fieldIndex + ". Name: " + tempSvdNodes.item(fieldIndex).getNodeName() + ". Type: " + tempSvdNodes.item(fieldIndex).getNodeType());
//                    System.out.println("Text: " + tempSvdNodes.item(fieldIndex).getTextContent());
                }
            }
        }
        return tempNodesList;
    }

    @Override
    public String get_name() {
        return fieldsTreeRoot.get_child("name").get_value();
    }
    @Override
    public String get_address() {
        return fieldsTreeRoot.get_child("baseAddress").get_value();
    }

    @Override
    public float get_description() {
        return 0;
    }

    @Override
    public float get_offset() {
        return 0;
    }

    @Override
    public Map<String, String> get_info() {
        return Map.of();
    }

    @Override
    public ArrayList<String> get_fields_names() {
        return null;
    }

    @Override
    public svdPeripheralField get_field(String name) {
        return null;
    }
}
