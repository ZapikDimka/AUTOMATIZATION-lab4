package org.ZapikDimka;

import org.ZapikDimka.annotations.RuntimeAnnotation;
import org.ZapikDimka.annotations.CompileTimeAnnotation;

@CompileTimeAnnotation("ExampleClass")
public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        RuntimeAnnotationProcessor.processAnnotations(main);
    }

    @RuntimeAnnotation("ExampleMethod")
    public void annotatedMethod() {
        System.out.println("This method is annotated with RuntimeAnnotation.");
    }
}
