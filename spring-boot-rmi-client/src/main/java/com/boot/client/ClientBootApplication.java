package com.boot.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;

import com.boot.rmi.service.name.ServiceName;
import com.boot.rmi.ws.HelloRemoteService;
import com.boot.rmi.ws.OrderRemoteService;
import com.boot.rmi.ws.UserRemoteService;

@SpringBootApplication
public class ClientBootApplication {
	
	@Value("${rmi.server-url}")
	private String rmiServerURL;
	
	@Value("${rmi.server-port}")
	private String rmiServerPORT;
	
	public static void main(String[] args) {
		SpringApplication.run(ClientBootApplication.class, args);
	}
	
	/*本地注册远程服务，通过tcp 调用远程方法*/  
    @Bean  
    public RmiProxyFactoryBean rmiProxyFactoryBeanHello() {  
        RmiProxyFactoryBean rmiProxyFactoryBean = new RmiProxyFactoryBean();  
        rmiProxyFactoryBean.setServiceUrl("rmi://"+rmiServerURL+":"+rmiServerPORT+"/"+ServiceName.HELLO_SERVCIE);   
        rmiProxyFactoryBean.setServiceInterface(HelloRemoteService.class);   
        return rmiProxyFactoryBean;  
    }  
    
    /*本地注册远程服务，通过tcp 调用远程方法*/  
    @Bean  
    public RmiProxyFactoryBean rmiProxyFactoryBeanOrder() {  
        RmiProxyFactoryBean rmiProxyFactoryBean = new RmiProxyFactoryBean();  
        rmiProxyFactoryBean.setServiceUrl("rmi://"+rmiServerURL+":"+rmiServerPORT+"/"+ServiceName.ORDER_SERVCIE);   
        rmiProxyFactoryBean.setServiceInterface(OrderRemoteService.class);   
        return rmiProxyFactoryBean;  
    }  
    
    /*本地注册远程服务，通过tcp 调用远程方法*/  
    @Bean  
    public RmiProxyFactoryBean rmiProxyFactoryBeanUser() {  
        RmiProxyFactoryBean rmiProxyFactoryBean = new RmiProxyFactoryBean();  
        rmiProxyFactoryBean.setServiceUrl("rmi://"+rmiServerURL+":"+rmiServerPORT+"/"+ServiceName.USER_SERVCIE);   
        rmiProxyFactoryBean.setServiceInterface(UserRemoteService.class);   
        return rmiProxyFactoryBean;  
    }  
}
