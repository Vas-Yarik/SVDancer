package org.SVDancer;
import org.w3c.dom.Node;
import org.SVDancer.stm.cpu;

public class Main {
    static void main(){
        cpu stmCpu = new cpu();
        SVD stmFile = new SVD("STM32H743.svd", stmCpu);
        stmFile.parse();
        YAML stmYaml = new YAML("stm32_h743_dancer.yaml");
        try {
            stmYaml.parse();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
