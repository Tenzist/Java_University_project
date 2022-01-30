package com.oleh.pakhomov;

public class FuncGeneration {
    public static String generateCodeFunctionF(String userCode) {
        StringBuilder sb = new StringBuilder(200);
        sb.append("package dynjava;\n");
        sb.append("""
                    interface IMathFunction {
                        public Double calculate(Double x);
                    }\n\n
                """);
        sb.append("public class FunctionF implements IMathFunction {\n");
        sb.append("   public Double calculate(Double x) {\n");
        sb.append("      " + userCode + "\n");
        sb.append("   }\n");
        sb.append("}\n");
        return sb.toString();
    }

    public static String generateCodeFunctionG(String userCode) {
        StringBuilder sb = new StringBuilder(200);
        sb.append("package dynjava;\n");
        sb.append("""
                    interface IMathFunction {
                        public Double calculate(Double x);
                    }\n\n
                """);
        sb.append("public class FunctionG implements IMathFunction {\n");
        sb.append("   public Double calculate(Double x) {\n");
        sb.append("      " + userCode + "\n");
        sb.append("   }\n");
        sb.append("}\n");
        return sb.toString();
    }
}
