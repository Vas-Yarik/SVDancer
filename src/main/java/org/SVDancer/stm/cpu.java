package org.SVDancer.stm;
import org.SVDancer.svdCpu;
import org.w3c.dom.Node;

import java.util.ArrayList;

public class cpu implements svdCpu{
    public cpu(){fieldsList = new ArrayList<ConcretePeripheralField>();}

    @Override
    public void add_field(Node svdField) {
        fieldsList.add(new ConcretePeripheralField(svdField));
        System.out.println(fieldsList.getLast().get_name());
        System.out.println(fieldsList.getLast().get_address());
    }
    private ArrayList<ConcretePeripheralField> fieldsList;
}
