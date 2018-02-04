package com.maduar.miaosha.domain;

import java.util.Date;

public class OrderInfo {
  private Long id;
  private Long userId;
  private Long gooddsId;
  private Long deliveryAddrId;
  private String goodsName;
  private Integer goodsCount;
  private Double goodsPrice;
  private Integer orderChannetl;
  private Integer status;
  private Date createDate;
  private Date payDate;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public Long getGooddsId() {
    return gooddsId;
  }

  public void setGooddsId(Long gooddsId) {
    this.gooddsId = gooddsId;
  }

  public Long getDeliveryAddrId() {
    return deliveryAddrId;
  }

  public void setDeliveryAddrId(Long deliveryAddrId) {
    this.deliveryAddrId = deliveryAddrId;
  }

  public String getGoodsName() {
    return goodsName;
  }

  public void setGoodsName(String goodsName) {
    this.goodsName = goodsName;
  }

  public Integer getGoodsCount() {
    return goodsCount;
  }

  public void setGoodsCount(Integer goodsCount) {
    this.goodsCount = goodsCount;
  }

  public Double getGoodsPrice() {
    return goodsPrice;
  }

  public void setGoodsPrice(Double goodsPrice) {
    this.goodsPrice = goodsPrice;
  }

  public Integer getOrderChannetl() {
    return orderChannetl;
  }

  public void setOrderChannetl(Integer orderChannetl) {
    this.orderChannetl = orderChannetl;
  }

  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  public Date getCreateDate() {
    return createDate;
  }

  public void setCreateDate(Date createDate) {
    this.createDate = createDate;
  }

  public Date getPayDate() {
    return payDate;
  }

  public void setPayDate(Date payDate) {
    this.payDate = payDate;
  }


}
