package org.example;

import com.meteor.wechatbc.plugin.Plugin;
import com.meteor.wechatbc.scheduler.Scheduler;

import java.time.Duration;
import java.time.LocalTime;

public class SchedulerExample {

    private final Scheduler scheduler;

    public SchedulerExample(Scheduler scheduler) {
        this.scheduler = scheduler;
    }

    public void scheduleDailyTask(Plugin plugin, Runnable task) {
        // 获取当前时间
        LocalTime currentTime = LocalTime.now();

        // 计算距离明天凌晨7点的时间间隔
        long initialDelay = Duration.between(currentTime, LocalTime.of(7, 0)).getSeconds();

        // 如果当前时间已经超过了凌晨7点，则设置为明天凌晨7点执行任务
        if (initialDelay < 0) {
            initialDelay += Duration.ofDays(1).getSeconds();
        }

        // 按照每天的周期执行任务
        scheduler.runTaskTimer(plugin, task, initialDelay, Duration.ofDays(1).getSeconds());
    }

    // 示例任务
    public void dailyTask() {
        // 在这里编写每天凌晨7点执行的任务逻辑
        System.out.println("执行每天凌晨7点的任务");
    }

    public static void main(String[] args) {
        // 创建 SchedulerExample 实例
        SchedulerExample example = new SchedulerExample(new YourSchedulerImplementation());

        example.scheduleDailyTask(new YourPlugin(), example::dailyTask);
    }
}
