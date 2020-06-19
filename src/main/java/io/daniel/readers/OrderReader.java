package io.daniel;

import java.util.List;

public interface OrderReader {

    List<OrderRequest> readOrders(String fileName);
}
