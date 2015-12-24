import java.net.InetSocketAddress;

import net.spy.memcached.MemcachedClient;

public class TestClient {

	public static void main(String[] args) throws Exception {

		MemcachedClient client = new MemcachedClient(new InetSocketAddress(
				"192.168.0.100", 11211));
		// 60是超时数，默认以秒为单位
		client.set("test", 60, "1111测试memcache成功了吧");

		System.out.println(client.get("test"));
		client.shutdown();// 关闭连接

	}

}
