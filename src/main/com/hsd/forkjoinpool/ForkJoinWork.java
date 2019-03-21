package main.com.hsd.forkjoinpool;

import java.util.concurrent.RecursiveTask;

/**
 * @Author:huangshengda
 * @Description:
 * @Date: 2018/10/26
 */
public class ForkJoinWork extends RecursiveTask<Long> {

    private Long start;
    private Long end;

    public static final  Long critical = 100000L;//临界值

    public ForkJoinWork(Long start, Long end) {
        this.start = start;
        this.end = end;
    }

    protected Long compute() {
        //判断是否拆完毕
        Long length = end -start;
        if(length <= critical){
            Long sum = 0L;
            for(long i = start; i < end; i ++){
                sum += i;
            }
            return sum;
        }else{
            //没有拆分完毕就开始拆分
            Long middle = (end + start)/2;//计算的两个值的中间值
            ForkJoinWork right = new ForkJoinWork(start,middle);
            right.fork();//拆分，并压入线程队列
            ForkJoinWork left = new ForkJoinWork(middle+1,end);
            left.fork();//拆分，并压入线程队列

            //合并
            return right.join() + left.join();
        }
    }
}
