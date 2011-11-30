/**
 * 
 */
package com.taobao.top.analysis.node.io;



import com.taobao.top.analysis.node.IJobExporter;
import com.taobao.top.analysis.node.job.JobTask;
import com.taobao.top.analysis.node.job.JobTaskResult;

/**
 * 文件输出适配器
 * 
 * @author fangweng
 * @Email fangweng@taobao.com
 * 2011-11-25
 *
 */
public class FileOutputAdaptor implements IOutputAdaptor {
	
	//private static final Log logger = LogFactory.getLog(FileOutputAdaptor.class);
	
	IJobExporter jobExporter; 

	public IJobExporter getJobExporter() {
		return jobExporter;
	}


	public void setJobExporter(IJobExporter jobExporter) {
		this.jobExporter = jobExporter;
	}


	@Override
	public void sendResultToOutput(JobTask jobTask,JobTaskResult jobTaskResult) {
		jobExporter.exportReport(jobTask,jobTaskResult, false);
	}

	
	@Override
	public boolean ignore(String output) {
		return output.indexOf("file:") < 0;
	}

}