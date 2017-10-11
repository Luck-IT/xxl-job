package com.xxl.job.admin.core.jobbean;

import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.thread.JobThread;

/**
 * 本地执行的Job类
 * @author Eric Wu   E-mail: wuwenjun3@ceair.com
 * @date 2017年9月21日  下午3:31:09
 */
public class LocalJobBean {
    
    private static Logger logger = LoggerFactory.getLogger(LocalJobBean.class);
    
    /**
     * 存储任务执行器
     */
    private static ConcurrentHashMap<String,IJobHandler> executorRepository = new ConcurrentHashMap<String,IJobHandler>();
    
    
    public static IJobHandler getJobHandler(String name) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        if(executorRepository.contains(name)) {
            return executorRepository.get(name);
        }else {
            //Class<?> jobClass = Class.forName(name,true,ClassLoader.getSystemClassLoader());
            Class<?> jobClass = Class.forName(name);
            IJobHandler handler = (IJobHandler)jobClass.newInstance();
            executorRepository.put(name,handler);
            return handler;
        }
    }
    
}
