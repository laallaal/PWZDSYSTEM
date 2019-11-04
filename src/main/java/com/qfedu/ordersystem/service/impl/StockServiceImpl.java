package com.qfedu.ordersystem.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qfedu.ordersystem.dao.StockDao;
import com.qfedu.ordersystem.entry.MenuStock;
import com.qfedu.ordersystem.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Stream
 * @version 1.0
 * @date 2019/10/25 22:02
 */
@Service
public class StockServiceImpl extends ServiceImpl<StockDao, MenuStock> implements StockService {
    @Autowired
    StockDao stockDao;

    @Override
    public int selectByMid(Integer mid) {
        return stockDao.selectStockByMid (mid);
    }
}
