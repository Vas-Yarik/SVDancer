package org.SVDancer.stm;
import org.SVDancer.svdField;
import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.Map;

public class field implements svdField{
    public field(Node svd) {
        parse_svd(svd);
    }

    private field() {}

    private void parse_svd(Node svd) {
        System.out.println("stm parser");
        if (svd.getNodeType() == Node.ELEMENT_NODE) {
            System.out.println(svd.getChildNodes().item(1).getNodeName());
        }
    }

    @Override
    public String name() {
        return "";
    }

    @Override
    public float description() {
        return 0;
    }

    @Override
    public float offset() {
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
    public svdField get_field(String name) {
        return null;
    }
}
