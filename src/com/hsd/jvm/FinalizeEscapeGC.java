/*
 *   阔地教育科技有限公司版权所有（codyy.com/codyy.cn）
 *   Copyright (c) 2017, Codyy and/or its affiliates. All rights reserved.
 */
package com.hsd.jvm;

/**  
 * @Description:  对象可以在被GC时自我拯救,这种自救的机会只有一次,应为系统自会调用对象一次finalize()
 * @author huangshengda  
 * @date 2017年11月6日   
 * @version  1.0
*/
public class FinalizeEscapeGC {

	private static FinalizeEscapeGC SAVE_HOOK = null;

	public void isAlive() {
		System.out.println("yes, i am still alive !");
	}

	@Override
	protected void finalize() throws Throwable {
		FinalizeEscapeGC.SAVE_HOOK = this;
		super.finalize();
		System.out.println("finalize method executed !");
	}

	public static void main(String[] args) throws InterruptedException {
		SAVE_HOOK = new FinalizeEscapeGC();

		// 自我拯救成功
		SAVE_HOOK = null;
		System.gc();
		// 应为finalize方法优先级低,暂停0.5秒
		Thread.sleep(500);

		if (SAVE_HOOK != null) {
			SAVE_HOOK.isAlive();
		} else {
			System.out.println("no, dead");
		}

		// 自我拯救失败
		SAVE_HOOK = null;
		System.gc();
		// 应为finalize方法优先级低,暂停0.5秒
		Thread.sleep(500);

		if (SAVE_HOOK != null) {
			SAVE_HOOK.isAlive();
		} else {
			System.out.println("no, dead");
		}
	}
}
