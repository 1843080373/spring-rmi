## 2.0.1.RELEASE版本使用起来更加便捷，使用指南如下
#### spring-boot-rmi-starter源代码详细见https://github.com/blue19demon/spring-boot-rmi-starter/tree/01c860b3458bcbf59e79f4462ae9b0b45d289f9e
#### spring-boot-rmi-starter使用demo见https://github.com/blue19demon/spring-rmi/tree/bf80a30b07b2a787ddda842b347997ff883d4e27/boot-rmi-starter-release-demo

#### 步骤1. 
#### 将JitPack存储库添加到构建文件中
	<repositories>
		<repository>
		    <id>jitpack.io</id>
		    <url>https://jitpack.io</url>
		</repository>
	</repositories>
#### provider 添加依赖项
	<dependency>
		<groupId>com.github.blue19demon.spring-boot-rmi-starter</groupId>
		<artifactId>spring-boot-rmi-provider-starter</artifactId>
		<version>2.0.1.RELEASE</version>
	</dependency>
#### 步骤2. costomer 添加依赖项
	<dependency>
		<groupId>com.github.blue19demon.spring-boot-rmi-starter</groupId>
		<artifactId>spring-boot-rmi-costomer-starter</artifactId>
		<version>2.0.1.RELEASE</version>
	</dependency>
#### 步骤3.项目中的使用
#### API 项目中定义接口
	public interface HelloRemoteService {
		public String say(String name);
	}
#### provider 项目实现接口，添加注解
	@RemoteService
	public class HelloWSService implements HelloRemoteService {
		public String say(String name) {
			return "hello "+name;
		}
	}
##### application.yml上下文配置文件中新增如下内容，配置服务端暴露接口信息（目前版本只支持放在classpath路径下的文件名一致的文件）
	rmi:
          port: 1009
#### costomer 项目主启动类上新增注解
	@SpringBootApplication
	@EnableAutoRemoteLookup
	public class CostomerApplication {
		public static void main(String[] args) {
			SpringApplication.run(CostomerApplication.class, args);
		} 
	}
##### application.yml上下文配置文件中新增如下内容，配置客户端lookup接口信息（目前版本只支持放在classpath路径下的文件名一致的文件）
	rmi:
	  url: 127.0.0.1:1009
	  remoteClientScan:
	    basePackages: com.rmi.api
#### 启动provider项目，发布RMI接口
#### costomer调用
	@RunWith(SpringJUnit4ClassRunner.class)
	@SpringBootTest(classes={CostomerApplication.class})
	public class RmiCostomerTester {
		@Autowired
		private HelloRemoteService helloRemoteService;
		@Test
		public void test() {
			System.out.println(helloRemoteService.say("张三年"));
		}
	}
#### 远程调用接口success！！！

## 2.0.0.RELEASE版本使用指南	
#### spring-boot-rmi-starter源代码详细见https://github.com/blue19demon/spring-boot-rmi-starter/tree/4dd4f7339e7bba0eea291b395e6635cd81be125c
#### spring-boot-rmi-starter使用demo见https://github.com/blue19demon/spring-rmi/tree/cf00d51bea2b8ea48728e13a90048418e8a4d2a7/boot-rmi-starter-release-demo
	
#### 要将Git项目放入您的构建中：
#### 步骤1.将JitPack存储库添加到构建文件中
	<repositories>
		<repository>
		    <id>jitpack.io</id>
		    <url>https://jitpack.io</url>
		</repository>
	</repositories>
#### 步骤2. API 添加依赖项
	<dependency>
		<groupId>com.github.blue19demon.spring-boot-rmi-starter</groupId>
		<artifactId>spring-boot-rmi-costomer-common-starter</artifactId>
		<version>2.0.0.RELEASE</version>
	</dependency>
#### 步骤3. provider 添加依赖项
	<dependency>
		<groupId>com.github.blue19demon.spring-boot-rmi-starter</groupId>
		<artifactId>spring-boot-rmi-provider-starter</artifactId>
		<version>2.0.0.RELEASE</version>
	</dependency>
#### 步骤4. costomer 添加依赖项
	<dependency>
		<groupId>com.github.blue19demon.spring-boot-rmi-starter</groupId>
		<artifactId>spring-boot-rmi-costomer-starter</artifactId>
		<version>2.0.0.RELEASE</version>
	</dependency>
#### 步骤5.项目中的使用
#### API 项目中定义接口，并加上注解
	@RemoteClient
	public interface HelloRemoteService {
		public String say(String name);
	}

#### provider 项目实现接口，添加注解
	@RemoteService(serviceInterface=HelloRemoteService.class)
	@RmiServiceProperty(registryPort = 1234)
	@Service
	public class HelloWSService implements HelloRemoteService {
		public String say(String name) {
			return "hello "+name;
		}
	}
#### costomer 项目主启动类上新增注解
	@SpringBootApplication
	@RemoteClientScan(value = "com.rmi.api",url = "127.0.0.1:1234")
	public class CostomerApplication {
		public static void main(String[] args) {
			SpringApplication.run(CostomerApplication.class, args);
		} 
	}
#### 启动provider项目，发布RMI接口
#### costomer调用
	@RunWith(SpringJUnit4ClassRunner.class)
	@SpringBootTest(classes={CostomerApplication.class})
	public class RmiCostomerTester {
		@Autowired
		private HelloRemoteService helloRemoteService;
		@Test
		public void test() {
			System.out.println(helloRemoteService.say("张三年"));
		}
	}
#### 远程调用接口success！！！

#### 第一次请求项目时，JitPack会检查代码，构建它并提供构建工件（jar，aar）。
#### 如果项目没有任何GitHub版本，您可以使用短提交哈希或'master-SNAPSHOT'作为版本。
