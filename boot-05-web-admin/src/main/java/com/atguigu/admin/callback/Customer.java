package com.atguigu.admin.callback;

public class Customer implements CallBack {

    //顾客同时持有酒店类的对象
    private Hotel hotel;

    public Customer(Hotel hotel) {
        this.hotel = hotel;
    }

    @Override
    public void beWakedUp() {
        System.out.println("被叫醒了");
    }

    public void bookWakeService() {
        hotel.wakeService(this);
    }
}
