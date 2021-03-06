package com.rbs.cn.had;

import com.rbs.cn.utils.HdfsUtil;
import com.rbs.cn.utils.MRInit;
import com.rbs.cn.utils.JobInit;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.io.Text;

/**
 * Created by fengtao.xue on 2018/1/7.
 */
public class MRMain {

    public static void main(String[] args) throws Exception{
        //输入路径
        String inputs = HdfsUtil.HDFS + "mrdemo/input.txt";
        //输出路径，必须是不存在的
        String output = HdfsUtil.HDFS + "mrdemo/output.txt";
        Configuration conf = new Configuration();
        JobInit job = new JobInit(new String[] {inputs}, output, conf, null,"mrdemo", MRMain.class,
                null, MRMapper.class, Text.class, Text.class,
                null, null, MRReducer.class, Text.class, Text.class);
        MRInit.initAndRunJob(new JobInit[]{job});
        /*
        Job job = Job.getInstance(conf);
        //如果需要打成jar运行，需要下面这句
        job.setJarByClass(MRMain.class);
        //job执行作业时输入和输出文件的路径
        FileInputFormat.addInputPath(job, new Path(dst));
        FileOutputFormat.setOutputPath(job, new Path(dstOut));
        //指定自定义的Mapper和Reducer作为两个阶段的任务处理类
        job.setMapperClass(MRMapper.class);
        job.setReducerClass(MRReducer.class);
        //设置最后输出结果的Key和Value的类型
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(Text.class);
        job.setOutputFormatClass(TextOutputFormat.class);
        //执行job，直到完成
        job.waitForCompletion(true);
        */
    }
}