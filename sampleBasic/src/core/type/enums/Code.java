package core.type.enums;

import java.util.HashMap;
import java.util.Map;

public enum Code {
    CODE_1("string1"),
    CODE_2("string2"),
    CODE_3("string3"),
    // etc
    ;

    private static class Holder {
        static Map<String, Code> CODE_MAP = new HashMap<>();
    }

    private final String code;

    private Code(String code) {
        this.code = code;
        Holder.CODE_MAP.put(code, this);
    }

    public String getCode() {
        return this.code;
    }

    public static Code convertFromString(String code) {
        return Holder.CODE_MAP.get(code);
    }
}