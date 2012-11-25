package com.tehbeard.map.factory;

public @interface APIWorker {
API value();
    public enum API{
        BUKKIT,
        WORKBENCH
    }
}
