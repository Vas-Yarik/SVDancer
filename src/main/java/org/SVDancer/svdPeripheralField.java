package org.SVDancer;

import java.util.ArrayList;
import java.util.Map;

public interface svdPeripheralField {
    public String get_name();
    public String get_address();
    public float get_description();
    public float get_offset();
    public Map<String, String> get_info();
    public ArrayList<String> get_fields_names();
    public svdPeripheralField get_field(String name);
}
