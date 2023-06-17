package main.java.assertv;

public enum MethodCall {

    SET_WAS_RUN_TRUE("setWasRunTrue"), SET_UP("setUp");

    private final String methodName;

    MethodCall(String methodName) {
        this.methodName = methodName;
    }

    public String getMethodName() {
        return methodName;
    }
}
