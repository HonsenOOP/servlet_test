package com.test;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 各省数据独立，分库存偖。为了提高计算性能，统计时采用每个省开一个线程先计算单省结果，最后汇总。
 *
 * @author guangbo email:weigbo@163.com
 *
 */
public class Total {

    // private ConcurrentHashMap result = new ConcurrentHashMap();

    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(4,
                new TotalTask());

        // 实际系统是查出所有省编码code的列表，然后循环，每个code生成一个线程。
        new BillTask( barrier, "北京").start();
        new BillTask( barrier, "上海").start();
        new BillTask( barrier, "广西").start();
        new BillTask( barrier, "四川").start();
        new BillTask( barrier, "黑龙江").start();

    }
}

/**
 * 主任务：汇总任务
 */
class TotalTask implements Runnable {

    TotalTask() {
    }

    public void run() {
        // 读取内存中各省的数据汇总，过程略。
        System.out.println("=======================================");
        System.out.println("开始全国汇总");
    }
}

/**
 * 子任务：计费任务
 */
class BillTask extends Thread {
    // 计费服务
    private CyclicBarrier barrier;
    // 代码，按省代码分类，各省数据库独立。
    private String code;

    BillTask(CyclicBarrier barrier, String code) {
        this.barrier = barrier;
        this.code = code;
    }

    public void run() {
        System.out.println("开始计算--" + code + "省--数据！");
        // 把bill方法结果存入内存，如ConcurrentHashMap,vector等,代码略
        System.out.println(code + "省已经计算完成,并通知汇总Service！");
        try {
            // 通知barrier已经完成
            barrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }

}