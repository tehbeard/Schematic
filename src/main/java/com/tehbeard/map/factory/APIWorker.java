package com.tehbeard.map.factory;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface APIWorker {
API value();
    public enum API{
        BUKKIT,
        WORKBENCH
    }
}
