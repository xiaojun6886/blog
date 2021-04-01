package she.why.utils;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 用来创建关闭es客户端
 * Created by xiaojun on 2020/5/25.
 */
public class EsUtils {

    public synchronized static Client getClient() {
        Settings settings = Settings.builder().
                put("client.transport.sniff", true)
                .build();//自动嗅探其他集群的ip 如果有则加入
        InetSocketTransportAddress master = null;
        try {
            master = new InetSocketTransportAddress(InetAddress.getByName("dd.easyjava.xyz"),9200);
            TransportClient client = new PreBuiltTransportClient(settings).addTransportAddress(master);
            return client;
        }
        catch (UnknownHostException e) {
            e.printStackTrace();
            throw new RuntimeException("elasticSearch Client init error 连接创建失败"+e);
        }
    }
    /**
     * 用于关闭elasticSearch
     */
    public static void closeClient(Client client) {
        if (null != client) {
            try {
                client.close();
            } catch (Exception e) {
                throw new RuntimeException("连接关闭失败");
            }
        }
    }
}
