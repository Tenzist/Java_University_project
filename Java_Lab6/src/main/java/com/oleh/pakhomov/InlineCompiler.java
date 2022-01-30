package com.oleh.pakhomov;

import javax.tools.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class InlineCompiler {

    public static Object getFunction(String code, String name) throws Exception {
        File codeFile = new File("dynjava/" + name + ".java");
        if (codeFile.getParentFile().exists() || codeFile.getParentFile().mkdirs()) {
            try {
                Writer writer = null;
                try {
                    writer = new FileWriter(codeFile);
                    writer.write(code);
                    writer.flush();
                } finally {
                    try {
                        writer.close();
                    } catch (Exception e) {
                    }
                }
                DiagnosticCollector<JavaFileObject> diagnostics = new DiagnosticCollector<JavaFileObject>();
                JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
                StandardJavaFileManager fileManager = compiler.getStandardFileManager(diagnostics, null, null);
                List<String> optionList = new ArrayList<String>();
                optionList.add("-classpath");
                optionList.add(System.getProperty("java.class.path") + File.pathSeparator + "dist/InlineCompiler.jar");

                Iterable<? extends JavaFileObject> compilationUnit
                        = fileManager.getJavaFileObjectsFromFiles(Arrays.asList(codeFile));
                JavaCompiler.CompilationTask task = compiler.getTask(
                        null,
                        fileManager,
                        diagnostics,
                        optionList,
                        null,
                        compilationUnit);
                if (task.call()) {
                    var classFile = new File("./");
                    URLClassLoader classLoader =
                            new URLClassLoader(new URL[]{classFile.toURI().toURL()});
                    Class<?> loadedClass = classLoader.loadClass("dynjava." + name);
                    Object obj = loadedClass.newInstance();
                    fileManager.close();
                    return obj;
                } else {
                    var errList = "";
                    for (Diagnostic<? extends JavaFileObject> diagnostic : diagnostics.getDiagnostics()) {
                        errList += "[" + name + ", "
                                + diagnostic.getKind().name() + "]: " + diagnostic.getMessage(Locale.getDefault()) + "\n";
                    }
                    fileManager.close();
                    throw new RuntimeException(errList);
                }
            } catch (IOException | ClassNotFoundException | InstantiationException | IllegalAccessException exp) {
               throw exp;
            }
        }
        throw new Exception();
    }

}