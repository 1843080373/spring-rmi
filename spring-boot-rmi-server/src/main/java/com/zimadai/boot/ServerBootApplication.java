package com.zimadai.boot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.remoting.rmi.RmiServiceExporter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.boot.rmi.service.name.ServiceName;
import com.boot.rmi.ws.HelloRemoteService;
import com.boot.rmi.ws.OrderRemoteService;
import com.boot.rmi.ws.UserRemoteService;

@SpringBootApplication
@EnableTransactionManagement
@MapperScan("com.zimadai.boot.mapper") // 将项目中对应的mapper类的路径加进来就可以了
public class ServerBootApplication {
	@Autowired
	private HelloRemoteService helloRemoteService;

	@Autowired
	private OrderRemoteService orderRemoteService;
	
	@Autowired
	private UserRemoteService userRemoteService;
	

	@Value("${rmi.server-port}")
	private String rmiServerPORT;
	
	public static void main(String[] args) {
		SpringApplication.run(ServerBootApplication.class, args);
	}

	/* rmi 服务器暴漏 服务 */
	@Bean
	public RmiServiceExporter rmiServiceExporterHello() {
		RmiServiceExporter rmiServiceExporter = new RmiServiceExporter();
		// 客户端通过rmi调用的端口
		rmiServiceExporter.setRegistryPort(Integer.parseInt(rmiServerPORT));
		// 客户端调用注册调用的服务名
		rmiServiceExporter.setServiceName(ServiceName.HELLO_SERVCIE);
		// 注册的service
		rmiServiceExporter.setService(helloRemoteService);
		// 注册的接口
		rmiServiceExporter.setServiceInterface(HelloRemoteService.class);
		return rmiServiceExporter;
	}
	
	/* rmi 服务器暴漏 服务 */
	@Bean
	public RmiServiceExporter rmiServiceExporterOrder() {
		RmiServiceExporter rmiServiceExporter = new RmiServiceExporter();
		// 客户端通过rmi调用的端口
		rmiServiceExporter.setRegistryPort(Integer.parseInt(rmiServerPORT));
		// 客户端调用注册调用的服务名
		rmiServiceExporter.setServiceName(ServiceName.ORDER_SERVCIE);
		// 注册的service
		rmiServiceExporter.setService(orderRemoteService);
		// 注册的接口
		rmiServiceExporter.setServiceInterface(OrderRemoteService.class);
		return rmiServiceExporter;
	}
	
	/* rmi 服务器暴漏 服务 */
	@Bean
	public RmiServiceExporter rmiServiceExporterUser() {
		RmiServiceExporter rmiServiceExporter = new RmiServiceExporter();
		// 客户端通过rmi调用的端口
		rmiServiceExporter.setRegistryPort(Integer.parseInt(rmiServerPORT));
		// 客户端调用注册调用的服务名
		rmiServiceExporter.setServiceName(ServiceName.USER_SERVCIE);
		// 注册的service
		rmiServiceExporter.setService(userRemoteService);
		// 注册的接口
		rmiServiceExporter.setServiceInterface(UserRemoteService.class);
		return rmiServiceExporter;
	}
}
