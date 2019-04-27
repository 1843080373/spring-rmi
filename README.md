#### spring-boot-rmi-starter使用指南，源代码详细见https://github.com/blue19demon/spring-boot-rmi-starter
#### spring-boot-rmi-starter使用demo见https://github.com/blue19demon/spring-rmi/tree/master/boot-rmi-starter-release-demo
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
		@Autowired
		private UserRemoteService userRemoteService;
		@Test
		public void test() {
			System.out.println(helloRemoteService.say("张三年"));
			System.out.println(userRemoteService.save(user));
		}
	}
#### 远程调用接口suucess！！！
#### 第一次请求项目时，JitPack会检查代码，构建它并提供构建工件（jar，aar）。
#### 如果项目没有任何GitHub版本，您可以使用短提交哈希或'master-SNAPSHOT'作为版本。
