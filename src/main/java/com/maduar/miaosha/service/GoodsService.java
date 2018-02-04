package com.maduar.miaosha.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.maduar.miaosha.dao.GoodsDao;
import com.maduar.miaosha.dao.UserDao;
import com.maduar.miaosha.domain.Goods;
import com.maduar.miaosha.domain.MiaoshaGoods;
import com.maduar.miaosha.domain.User;
import com.maduar.miaosha.vo.GoodsVo;

@Service
public class GoodsService {

  @Autowired
  GoodsDao goodsDao;

  public List<GoodsVo> listGoodsVo() {
    return goodsDao.listGoodsVo();
  }

  public List<MiaoshaGoods> listMiaoshaGoods() {
    return goodsDao.listMiaoshaGoods();
  }

  public List<Goods> listGoods() {
    return goodsDao.listGoods();
  }
}


