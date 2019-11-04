package com.qfedu.ordersystem.service;

import com.qfedu.ordersystem.entry.GuoDi;

public interface HotPotService {
    GuoDi selectGuoDi();

    void changeGuoDi(int id, int imgId, String img);
}
