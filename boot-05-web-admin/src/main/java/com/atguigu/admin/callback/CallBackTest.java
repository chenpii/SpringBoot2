package com.atguigu.admin.callback;

public class CallBackTest {
    public static void main(String[] args) {
        Hotel hotel = new Hotel();
        Customer customer = new Customer(hotel);
        customer.bookWakeService();
    }
}
