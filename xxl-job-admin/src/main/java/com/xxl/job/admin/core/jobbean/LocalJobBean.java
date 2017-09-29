package com.xxl.job.admin.core.jobbean;

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
     * 执行Job的类
     */
    private Class<?> jobClass;
    /**
     * 执行参数
     */
    private String executeParm;
    
    public Class<?> getJobClass() {
        return jobClass;
    }
    public void setJobClass(String jobClass) throws ClassNotFoundException {
        this.jobClass = Class.forName(jobClass);
    }
    public String getExecuteParm() {
        return executeParm;
    }
    public void setExecuteParm(String executeParm) {
        this.executeParm = executeParm;
    }
    
    public ReturnT<String> run() throws Exception{
        //logger.
        Object object = jobClass.newInstance();
        IJobHandler job= (IJobHandler) object;
        return job.execute(this.executeParm);    
    }
    
}
