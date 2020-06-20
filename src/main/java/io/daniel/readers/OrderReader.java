package io.daniel.readers;

import io.daniel.model.AvailableType;
import io.daniel.model.ParsedLine;

import java.io.File;
import java.util.List;

public interface OrderReader {

    List<ParsedLine> readOrders(File file);

    AvailableType getFileType();
}
