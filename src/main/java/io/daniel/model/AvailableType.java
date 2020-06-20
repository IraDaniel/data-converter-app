package io.daniel.model;

import org.apache.commons.lang3.StringUtils;

import java.util.stream.Stream;

public enum AvailableType {
    CSV("text/csv"),
    JSON("application/json");

    String mimeType;

    AvailableType(String mimeType) {
        this.mimeType = mimeType;
    }

    public String getMimeType() {
        return mimeType;
    }

    public static AvailableType fromMimeType(String type) {
        return Stream.of(values())
                .filter(availableType -> StringUtils.equalsIgnoreCase(availableType.getMimeType(), type))
                .findFirst().orElse(null);
    }
}
