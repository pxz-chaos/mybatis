package com.peixin.mapper;

import com.peixin.domain.Order;
import com.peixin.domain.User;

import java.util.List;

public interface OrderMapper {
    List<Order> findMulti();
}
