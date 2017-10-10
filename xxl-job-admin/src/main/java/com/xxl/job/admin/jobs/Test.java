package com.xxl.job.admin.jobs;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.log.XxlJobLogger;

public class Test extends IJobHandler{

    @Override
    public ReturnT<String> execute(String... params) throws Exception {
        
        
        XxlJobLogger.log("sdkjfkajsdklfjaklsdjfla");
        XxlJobLogger.log("sdkjfkajsdklfjaklsdjfla");
        XxlJobLogger.log("sdkjfkajsdklfjaklsdjfla");
        
        System.out.println("jdfkljasjfsdjflka;sdf");
        System.out.println("jdfkljasjfsdjflka;sdf");
        System.out.println("jdfkljasjfsdjflka;sdf");
        System.out.println("jdfkljasjfsdjflka;sdf");
        System.out.println("jdfkljasjfsdjflka;sdf");
        return  ReturnT.SUCCESS;
    }

}
