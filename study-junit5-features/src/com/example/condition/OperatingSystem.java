package com.example.condition;

public enum OperatingSystem {
    WINDOWS, LINUX, UNKNOWN;

    public static OperatingSystem determine(){
        var osName = System.getProperty("os.name").toLowerCase();
        if (osName.contains("win"))
            return WINDOWS;
        if (osName.contains("nix"))
            return LINUX;
        return UNKNOWN;
    }
}
