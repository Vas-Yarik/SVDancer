package org.SVDancer.stm;
import org.SVDancer.svdCpu;
import org.w3c.dom.Node;

import java.util.ArrayList;

public class cpu implements svdCpu{
    public cpu(){fieldsList = new ArrayList<field>();}

    @Override
    public void add_field(Node svdField) {
        fieldsList.add(new field(svdField));
    }
    private ArrayList<field> fieldsList;
}
