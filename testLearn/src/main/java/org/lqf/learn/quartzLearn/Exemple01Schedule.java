package org.lqf.learn.quartzLearn;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.Map;

//定时调度器
public class Exemple01Schedule {
    //计划工厂类
    private static SchedulerFactory schedulerFactory = new StdSchedulerFactory();
    //任务名称
    private static String JOB_GROUP_NAME = "job-group-1";
    //触发器名称
    private static String TRIGGER_GROUP_NAME = "grigger-group-1";

    public static void addJob(Class<? extends Job> jobClass, String jobName, int interval, Map<String,Object> data){
        try {
            //获取任务调度器
            Scheduler scheduler = schedulerFactory.getScheduler();
            //获取任务详细信息
            JobDetail jobDetail = JobBuilder.newJob(jobClass)
                    //任务名称和组构成任务key
                    .withIdentity(jobName, JOB_GROUP_NAME)
                    .build();
            jobDetail.getJobDataMap().putAll(data);
            // 触发器
            SimpleTrigger trigger = TriggerBuilder.newTrigger()
                    //触发器key唯一标识
                    .withIdentity(jobName, TRIGGER_GROUP_NAME)
                    //调度开始时间
                    .startAt(DateBuilder.futureDate(1, DateBuilder.IntervalUnit.SECOND))
                    //调度规则
                    .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                            .withIntervalInSeconds(interval)
                            .repeatForever())
                    .build();

            scheduler.scheduleJob(jobDetail, trigger);
            // 启动
            if (!scheduler.isShutdown()) {
                scheduler.start();
            }
        } catch (SchedulerException e) {
            System.out.println(e.getMessage());
        }

    }
}
