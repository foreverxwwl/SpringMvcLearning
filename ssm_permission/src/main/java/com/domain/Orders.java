package com.domain;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * @outhor li
 * @create 2020-03-03 18:17
 * 订单类
 */
public class Orders {
    private String id;
    private String orderNum;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime orderTime;
    private String orderTimeStr;
    private int orderStatus;
    private String orderStatusStr;
    private int peopleCount;
    private Product product;
    private List<Traveller> travellers;
    private Member member;
    private Integer payType;
    private String payTypeStr;
    private String orderDesc;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(LocalDateTime orderTime) {
        this.orderTime = orderTime;
    }

    public String getOrderTimeStr() {
        if (orderTime != null){
            orderTimeStr = orderTime.format(DateTimeFormatter.ISO_DATE);
        }
        return orderTimeStr;
    }

    public void setOrderTimeStr(String orderTimeStr) {
        this.orderTimeStr = orderTimeStr;
    }

    public int getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(int orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getOrderStatusStr() {
        //订单状态(0 未支付 1 已支付)
        if(orderStatus==0){
            orderStatusStr="未支付";
        }else if(orderStatus==1){
            orderStatusStr="已支付";
        }
        return orderStatusStr;
    }

    public void setOrderStatusStr(String orderStatusStr) {
        this.orderStatusStr = orderStatusStr;
    }

    public int getPeopleCount() {
        return peopleCount;
    }

    public void setPeopleCount(int peopleCount) {
        this.peopleCount = peopleCount;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public List<Traveller> getTravellers() {
        return travellers;
    }

    public void setTravellers(List<Traveller> travellers) {
        this.travellers = travellers;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public String getPayTypeStr() {
        //支付方式(0 支付宝 1 微信 2其它)
        if(payType==0){
            payTypeStr="支付宝";
        }else if(payType==1){
            payTypeStr="微信";
        }else if(payType==2){
            payTypeStr="其它";
        }
        return payTypeStr;
    }

    public void setPayTypeStr(String payTypeStr) {
        this.payTypeStr = payTypeStr;
    }

    public String getOrderDesc() {
        return orderDesc;
    }

    public void setOrderDesc(String orderDesc) {
        this.orderDesc = orderDesc;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id='" + id + '\'' +
                ", orderNum='" + orderNum + '\'' +
                ", orderTime=" + orderTime +
                ", orderTimeStr='" + orderTimeStr + '\'' +
                ", orderStatus=" + orderStatus +
                ", orderStatusStr='" + orderStatusStr + '\'' +
                ", peopleCount=" + peopleCount +
                ", product=" + product +
                ", travellers=" + travellers +
                ", member=" + member +
                ", payType=" + payType +
                ", payTypeStr='" + payTypeStr + '\'' +
                ", orderDesc='" + orderDesc + '\'' +
                '}';
    }
}