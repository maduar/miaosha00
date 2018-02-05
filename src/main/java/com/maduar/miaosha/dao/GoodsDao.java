package com.maduar.miaosha.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import com.maduar.miaosha.domain.Goods;
import com.maduar.miaosha.domain.MiaoshaGoods;
import com.maduar.miaosha.domain.User;
import com.maduar.miaosha.vo.GoodsVo;

@Mapper
public interface GoodsDao {

  @Select("select g.*,mg.stock_count, mg.start_date, mg.end_date,mg.miaosha_price from miaosha_goods mg left join goods g on mg.goods_id = g.id")
  public List<GoodsVo> listGoodsVo();
  
  @Select("select * from miaosha_goods ")
  public List<MiaoshaGoods> listMiaoshaGoods();
  
  @Select("select * from goods")
  public List<Goods> listGoods();
  
  @Select("select g.*,mg.stock_count, mg.start_date, mg.end_date,mg.miaosha_price from miaosha_goods mg left join goods g on mg.goods_id = g.id where g.id = #{goodsId}")
  public GoodsVo getGoodsVoByGoodsId(@Param("goodsId")Long goodsId);
}