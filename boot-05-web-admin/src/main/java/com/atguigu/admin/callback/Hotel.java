package com.atguigu.admin.callback;

public class Hotel {
    // 叫醒服务
    public void wakeService(CallBack callBack) {

        System.out.println("顾客预约了叫醒服务");

        try {
            // 模拟时间过了一晚上
            Thread.sleep(3000);

            System.out.println("时间过去了一夜");

            //回调
            callBack.beWakedUp();

        } catch (InterruptedException e) {

            e.printStackTrace();

        }

    }

}
