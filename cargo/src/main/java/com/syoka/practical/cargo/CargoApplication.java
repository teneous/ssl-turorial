package com.syoka.practical.cargo;

import java.io.InputStream;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.context.annotation.Bean;

import feign.Client;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import okhttp3.OkHttpClient;

import static com.syoka.practical.cargo.infrastructure.common.HttpsUtils.chooseTrustManager;
import static com.syoka.practical.cargo.infrastructure.common.HttpsUtils.prepareKeyManager;
import static com.syoka.practical.cargo.infrastructure.common.HttpsUtils.prepareTrustManager;

/**
 * @author syoka
 * @version : CargoApplication.java 2021年05月31日 16时30分
 */
@SpringBootApplication
public class CargoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CargoApplication.class, args);
    }

    /**
     * tomcat Http1.1
     */
    @Bean
    public Connector httpConnector() {
        Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
        connector.setScheme("http");
        connector.setPort(8080);
        //允许http链接接入
        connector.setSecure(true);
        //监听到http的端口号后转向到的https的端口号
//        connector.setRedirectPort(9002);
        return connector;
    }

    @Bean
    public TomcatServletWebServerFactory servletContainer() {
        TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory() {
            @Override
            protected void postProcessContext(Context context) {
                SecurityConstraint constraint = new SecurityConstraint();
                constraint.setUserConstraint("CONFIDENTIAL");
                SecurityCollection collection = new SecurityCollection();
                collection.addPattern("/*");
                constraint.addCollection(collection);
                context.addConstraint(constraint);
            }
        };
        tomcat.addAdditionalTomcatConnectors(httpConnector());
        return tomcat;
    }

    /**
     * 和itinerary建立连接的时候需要建立信任证书
     *
     * @return 建立ssl管道的okhttpclient
     */
    @Bean
    public OkHttpClient okHttpClient() throws NoSuchAlgorithmException, KeyManagementException {
        InputStream jksFile = this.getClass().getClassLoader().getResourceAsStream("cargo.jks");
        //信任服务器证书
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("itinerary.cer");

        TrustManager[] trustManagers = prepareTrustManager(inputStream);
        KeyManager[] keyManagers = prepareKeyManager(jksFile, "syoka123");

        X509TrustManager trustManager = chooseTrustManager(trustManagers);
        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(keyManagers, new TrustManager[]{trustManager}, null);

        SSLSocketFactory socketFactory = sslContext.getSocketFactory();
        return new OkHttpClient.Builder().sslSocketFactory(socketFactory, trustManager).build();
    }

    /**
     * customized feign client
     *
     * @return okhttp3 implementation
     */
    @Bean
    public Client okhttp3Client(okhttp3.OkHttpClient okHttpClient) {
        return new feign.okhttp.OkHttpClient(okHttpClient);
    }


}
