package org.SVDancer;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileInputStream;
import java.util.Map;

public class YAML {
    private final String yamlName;
    public YAML(String name) {
        yamlName = name;
    }

    public void parse() throws Exception{
        Yaml yaml = new Yaml();
        try (FileInputStream stm_mem = new FileInputStream(new File(yamlName))) {
            Map<String, Object> field = yaml.load(stm_mem);
            System.out.println(field.get("memory map").getClass().getTypeName());
//            System.out.println(yaml.load(stm_mem).toString());
//            System.out.println(yaml.dump(yaml.load(stm_mem)));
        } finally {
            System.out.println("try Final");
        }
    }
}
