#### spring-boot-rmi-starter使用指南，源代码详细见https://github.com/blue19demon/spring-boot-rmi-starter
#### spring-boot-rmi-starter使用demo见https://github.com/blue19demon/spring-rmi/tree/master/boot-rmi-starter-release-demo
#### How to get a Git project into your build:
#### Step 1. Add the JitPack repository to your build file
	<repositories>
		<repository>
		    <id>jitpack.io</id>
		    <url>https://jitpack.io</url>
		</repository>
	</repositories>
#### Step 2. API Add the dependency
		<dependency>
			<groupId>com.github.blue19demon.spring-boot-rmi-starter</groupId>
			<artifactId>spring-boot-rmi-costomer-common-starter</artifactId>
			<version>2.0.0.RELEASE</version>
		</dependency>
#### Step 3. provider Add the dependency
		<dependency>
			<groupId>com.github.blue19demon.spring-boot-rmi-starter</groupId>
			<artifactId>spring-boot-rmi-costomer-common-starter</artifactId>
			<version>2.0.0.RELEASE</version>
		</dependency>
#### Step 4. costomer Add the dependency
	<dependency>
		<groupId>com.github.blue19demon.spring-boot-rmi-starter</groupId>
		<artifactId>spring-boot-rmi-costomer-starter</artifactId>
		<version>2.0.0.RELEASE</version>
	</dependency>
#### Share this release:

#### TweetLink
#### That's it! The first time you request a project JitPack checks out the code, builds it and serves the build artifacts (jar, aar).
#### If the project doesn't have any GitHub Releases you can use the short commit hash or 'master-SNAPSHOT' as the version.
