# 在线留言平台 (Survey Platform)

基于Spring Boot的在线留言和问答平台项目。

## 🚀 功能特性

- ✅ 用户登录/注销（带验证码功能）
- ✅ 发布留言/讨论帖
- ✅ 回复留言
- ✅ 实时验证码生成
- ✅ 简洁的用户界面
- ✅ 内存数据存储

## 🛠️ 技术栈

- **后端框架**: Spring Boot 3.1.8
- **Java版本**: JDK 17+
- **模板引擎**: Thymeleaf
- **前端**: HTML, CSS, JavaScript (jQuery)
- **构建工具**: Maven
- **服务器**: 内嵌Tomcat 10

## 📁 项目结构

```text
survey-platform/
├── src/main/java/com/example/survey/platform/
│   ├── controller/    # 控制器
│   │   ├── LoginController.java
│   │   ├── MessageController.java
│   │   ├── CaptchaController.java
│   │   └── LogoutController.java
│   ├── dao/           # 数据访问接口和实现
│   │   ├── UserDao.java
│   │   ├── MessageDao.java
│   │   ├── ReplyDao.java
│   │   └── impl/
│   ├── model/
│   │   ├── User.java
│   │   ├── Message.java
│   │   └── Reply.java
│   ├── config/
│   │   └── AppConfig.java
│   ├── util/
│   │   └── CaptchaGenerator.java
│   └── SurveyPlatformApplication.java
├── src/main/resources/
│   ├── templates/
│   ├── static/css/
│   └── application.properties
├── pom.xml
└── README.md
```


## 🚀 快速开始

### 环境要求
- JDK 17 或更高版本
- Maven 3.6+（或使用项目自带的mvnw）

### 运行步骤
1. 克隆项目
```bash
git clone https://github.com/你的用户名/survey-platform.git
cd survey-platform
```

2. 运行应用
```bash
# 使用Maven Wrapper（推荐）
./mvnw spring-boot:run

# 或使用本地Maven
mvn spring-boot:run
```

3. 访问应用
打开浏览器访问：http://10.100.164.33:8081

### 测试账户
- 用户名：alice, 密码：123
- 用户名：bob, 密码：123  
- 用户名：tom, 密码：123

## 📦 部署

### 打包应用
```bash
mvn clean package
```
生成的JAR文件：`target/survey-platform-1.0-SNAPSHOT.jar`

### 运行JAR文件
```bash
java -jar target/survey-platform-1.0-SNAPSHOT.jar
```

### 自定义端口
```bash
java -jar target/survey-platform-1.0-SNAPSHOT.jar --server.port=8081
```

## 🔧 开发

### 主要功能模块
1. **用户管理**：登录、注销、会话管理
2. **留言系统**：发布、查看、回复留言
3. **验证码**：图形验证码生成和验证
4. **数据持久化**：内存存储（可扩展为数据库）

### 扩展建议
- 添加数据库支持
- 添加用户注册功能
- 添加文件上传功能
- 添加管理员权限
- 添加搜索功能

## 📄 API接口

| 方法 | 路径            | 描述           |
| ---- | --------------- | -------------- |
| GET  | /login          | 显示登录页面   |
| POST | /login          | 用户登录       |
| GET  | /logout         | 用户注销       |
| GET  | /message/list   | 留言列表       |
| GET  | /message/post   | 发布留言页面   |
| POST | /message/post   | 提交留言       |
| GET  | /message/detail | 留言详情       |
| POST | /message/reply  | 回复留言       |
| GET  | /captcha        | 获取验证码图片 |

