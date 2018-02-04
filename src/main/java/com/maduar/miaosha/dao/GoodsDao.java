package com.maduar.miaosha.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.maduar.miaosha.domain.User;
import com.maduar.miaosha.vo.GoodsVo;

@Mapper
public interface GoodsDao {

  @Select("SELECT g.*, mg.stock_count, mg.start_date, mg.end_date FROM miaosha_goods mg left join goods g on mg.goods_id = g.id")
  public List<GoodsVo> listGoodsVo();
}
