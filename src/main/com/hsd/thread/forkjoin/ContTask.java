/*
 *   阔地教育科技有限公司版权所有（codyy.com/codyy.cn）
 *   Copyright (c) 2017, Codyy and/or its affiliates. All rights reserved.
 */
package main.com.hsd.thread.forkjoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**  
 * @Description: TODO(这里用一句话描述这个类的作用)  
 * @author huangshengda  
 * @date 2017年6月8日   
 * @version  1.0
*/
@SuppressWarnings("serial")
public class ContTask extends RecursiveTask<Integer> {

	private static final int THREASHOLD = 2;// 阀值

	private int start;

	private int end;

	public ContTask(int start, int end) {
		super();
		this.start = start;
		this.end = end;
	}

	@Override
	protected Integer compute() {
		int sum = 0;

		boolean canCampute = (end - start) <= THREASHOLD;
		if (canCampute) {
			for (int i = start; i <= end; i++) {
				sum += i;
			}
		} else {
			int middle = (start + end) / 2;
			ContTask leftTask = new ContTask(start, middle);
			ContTask rightTask = new ContTask(middle + 1, end);
			ForkJoinTask<Integer> leftFork = leftTask.fork();
			ForkJoinTask<Integer> rightFork = rightTask.fork();
			Integer leftJoin = leftFork.join();
			Integer rightJoin = rightFork.join();
			sum = leftJoin + rightJoin;
		}
		return sum;
	}

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ForkJoinPool forkJoinPool = new ForkJoinPool();
		ContTask contTask = new ContTask(1, 6);
		ForkJoinTask<Integer> ret = forkJoinPool.submit(contTask);
		System.out.println(ret.get());
	}

}
