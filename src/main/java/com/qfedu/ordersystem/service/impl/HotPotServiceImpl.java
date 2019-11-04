package com.qfedu.ordersystem.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qfedu.ordersystem.dao.HotPotDao;
import com.qfedu.ordersystem.entry.GuoDi;
import com.qfedu.ordersystem.service.HotPotService;
import org.springframework.stereotype.Service;

@Service
public class HotPotServiceImpl extends ServiceImpl<HotPotDao, GuoDi> implements HotPotService {


    @Override
    public GuoDi selectGuoDi() {

        GuoDi guoDi = getBaseMapper().selectGuoDi();
        return guoDi;
    }

    @Override
    public void changeGuoDi(int id, int imgId, String img) {

        switch (imgId) {

            case 1:
                getBaseMapper().changeimg1(id, img);
                break;
            case 2:
                getBaseMapper().changeimg2(id, img);
                break;
            case 3:
                getBaseMapper().changeimg3(id, img);
                break;
            case 4:
                getBaseMapper().changeimg4(id, img);
                break;
            default:
                    break;

        }



    }


}
