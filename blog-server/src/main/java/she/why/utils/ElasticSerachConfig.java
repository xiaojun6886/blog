package she.why.utils;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 实现自动注入elasticserach
 * Created by xiaojun on 2020/5/25.
 */
@Configuration
public class ElasticSerachConfig {

    //自动注入client
//    @Bean(name="client")
    public TransportClient esClint() throws UnknownHostException
    {
        Settings settings = Settings.builder().build();
        InetSocketTransportAddress master=new InetSocketTransportAddress(InetAddress.getByName("dd.easyjava.xyz"),9200);
        TransportClient client =new PreBuiltTransportClient(settings).addTransportAddress(master);
        return client;
    }
}
