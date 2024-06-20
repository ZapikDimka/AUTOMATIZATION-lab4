package org.ZapikDimka;

import com.google.auto.service.AutoService;
import org.ZapikDimka.annotations.CompileTimeAnnotation;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.element.TypeElement;
import javax.annotation.processing.Filer;
import javax.lang.model.element.Element;
import javax.lang.model.SourceVersion;
import javax.tools.JavaFileObject;
import java.io.IOException;
import java.io.Writer;
import java.util.Set;

@AutoService(Processor.class)
@SupportedAnnotationTypes("org.ZapikDimka.annotations.CompileTimeAnnotation")
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class CompileTimeAnnotationProcessor extends AbstractProcessor {

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        System.out.println("CompileTimeAnnotationProcessor: process started.");
        for (Element element : roundEnv.getElementsAnnotatedWith(CompileTimeAnnotation.class)) {
            System.out.println("Processing element: " + element.getSimpleName());
            CompileTimeAnnotation annotation = element.getAnnotation(CompileTimeAnnotation.class);
            String className = element.getSimpleName() + "Generated";
            String classContent = "package org.ZapikDimka.generated;\n\n" +
                    "public class " + className + " {\n" +
                    "    public void generatedMethod() {\n" +
                    "        System.out.println(\"This is a generated method.\");\n" +
                    "    }\n" +
                    "}\n";
            try {
                Filer filer = processingEnv.getFiler();
                JavaFileObject file = filer.createSourceFile("org.ZapikDimka.generated." + className);
                try (Writer writer = file.openWriter()) {
                    writer.write(classContent);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return true;
    }
}
