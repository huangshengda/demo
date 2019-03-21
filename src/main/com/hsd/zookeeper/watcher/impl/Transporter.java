package main.com.hsd.zookeeper.watcher.impl;

import java.util.ArrayList;
import java.util.List;

import com.hsd.zookeeper.watcher.i.Watched;
import com.hsd.zookeeper.watcher.i.Watcher;

/**  
 * @Description: TODO(这里用一句话描述这个类的作用)  
 * @author huangshengda  
 * @date 2017年8月30日   
 *  
*/
public class Transporter implements Watched {
	private List<Watcher> list = new ArrayList<Watcher>();

	/* (non-Javadoc)
	 * @see bjsxt.watcher.i.Watched#addWatcher(bjsxt.watcher.i.Watcher)
	 */
	@Override
	public void addWatcher(Watcher watcher) {
		list.add(watcher);

	}

	/* (non-Javadoc)
	 * @see bjsxt.watcher.i.Watched#removeWatcher(bjsxt.watcher.i.Watcher)
	 */
	@Override
	public void removeWatcher(Watcher watcher) {
		list.remove(watcher);

	}

	/* (non-Javadoc)
	 * @see bjsxt.watcher.i.Watched#notifyWatchers()
	 */
	@Override
	public void notifyWatchers() {
		for (Watcher watcher : list) {
			watcher.update();
		}

	}

}
