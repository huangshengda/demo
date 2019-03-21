/*
 *   阔地教育科技有限公司版权所有（codyy.com/codyy.cn）
 *   Copyright (c) 2017, Codyy and/or its affiliates. All rights reserved.
 */
package main.com.hsd.mq.rocketmq.demo;

import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.client.producer.DefaultMQProducer;
import com.alibaba.rocketmq.client.producer.SendResult;
import com.alibaba.rocketmq.common.message.Message;

/**  
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author huangshengda  
 * @date 2017年8月2日   
 * @version  1.0
*/
public class Producer {
	public static void main(String[] args) throws MQClientException {
		DefaultMQProducer producer = new DefaultMQProducer("Producer");
		// nameserver服务,多个以;分开
		producer.setNamesrvAddr("192.168.133.128:9876");
		try {
			producer.start();

			Message msg = new Message("PushTopic", "push", "1", "Just for test.".getBytes());
			SendResult result = producer.send(msg);
			System.out.println("id:" + result.getMsgId() + " result:" + result.getSendStatus());

			msg = new Message("PushTopic", "push", "2", "Just for test.".getBytes());
			result = producer.send(msg);
			System.out.println("id:" + result.getMsgId() + " result:" + result.getSendStatus());

			msg = new Message("PullTopic", "pull", "1", "Just for test.".getBytes());
			result = producer.send(msg);
			System.out.println("id:" + result.getMsgId() + " result:" + result.getSendStatus());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			producer.shutdown();
		}
	}
}
