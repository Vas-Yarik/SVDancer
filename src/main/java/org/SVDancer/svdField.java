package org.SVDancer;

import java.util.ArrayList;
import java.util.Map;

public interface svdField {
    public String name();
    public float description();
    public float offset();
    public Map<String, String> get_info();
    public ArrayList<String> get_fields_names();
    public svdField get_field(String name);
}
