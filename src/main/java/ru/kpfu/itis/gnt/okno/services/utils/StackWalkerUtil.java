package ru.kpfu.itis.gnt.okno.services.utils;

public class StackWalkerUtil {

    public static String getCaller() {
        var walker = StackWalker.getInstance(StackWalker.Option.RETAIN_CLASS_REFERENCE);
        var frame = walker.walk(stream -> stream.skip(2).findFirst());

        return frame.map(stackFrame -> stackFrame.getClassName() + "#" + stackFrame.getMethodName())
                .orElse("Unknown");
    }

}
