#
# One-on-One

A basic One-on-One application used for collecting and editing the employee feedback by manager, so that the HR can view all the necessary details.

**Getting Started**

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

**Prerequisites**

For building and running the application you need:

- [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html):The Java Development Kit (JDK) is a software development environment used for developing Java applications and applets.
- [Spring Tool Suite v4](https://spring.io/tools):The Spring Tool Suite  is an Eclipse-based development environment that is customized for developing Spring applications.
- [Maven 4](https://maven.apache.org/):MAVEN is a build automation tool ,It downloads Java libraries and Maven plug-ins from repositories and stores them in a local cache.
- [MySql](https://www.mysql.com/):It is a full-featured relational database management system (RDBMS)


**Installation**

- [Mysql installation and configuration](https://support.rackspace.com/how-to/installing-mysql-server-on-ubuntu/)
- [Link to install JDK 1.8](http://tipsonubuntu.com/2016/07/31/install-oracle-java-8-9-ubuntu-16-04-linux-mint-18)
- [Link to install Spring Tool Suite](https://spring.io/tools)


**Running the application locally**

There are several ways to run a Spring Boot application on your local machine. One way is to execute the main method in the OneOnOne-master/src/main/java/com/nineleaps/OneonOne/OneonOne.Application  class from your IDE.

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

mvn spring-boot:run

**Folder Structure**
// prettier-ignore
.
├── BackEndOneOnOne.iml
├── mvnw
├── mvnw.cmd
├── pom.xml
├── README.md
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── nineleaps
│   │   │           ├── constants
│   │   │           │   └── Constant.java
│   │   │           ├── controller
│   │   │           │   ├── EmployeeDataController.java
│   │   │           │   ├── FeedbackController.java
│   │   │           │   ├── HrDataController.java
│   │   │           │   ├── LoginController.java
│   │   │           │   ├── ManagerDataController.java
│   │   │           │   └── SuperHrDataController.java
│   │   │           ├── datarepositories
│   │   │           │   ├── EmployeeDataRepository.java
│   │   │           │   ├── EmployeeGoalRepository.java
│   │   │           │   ├── EmployeeReportRepository.java
│   │   │           │   ├── HRDataRepository.java
│   │   │           │   ├── ManagerDataRepository.java
│   │   │           │   ├── ManagerDetailsRepository.java
│   │   │           │   └── QuestionAndAnswer.java
│   │   │           ├── exception
│   │   │           │   ├── RoleException.java
│   │   │           │   └── TokenException.java
│   │   │           ├── interceptor
│   │   │           │   ├── EmployeeInterceptor.java
│   │   │           │   ├── HrInterceptor.java
│   │   │           │   ├── Interceptor.java
│   │   │           │   ├── ManagerInterceptor.java
│   │   │           │   ├── SuperHrInterceptor.java
│   │   │           │   └── TokenInterceptor.java
│   │   │           ├── oneonone
│   │   │           │   ├── EmployeeData.java
│   │   │           │   ├── Employeegoals.java
│   │   │           │   ├── EmployeeReport.java
│   │   │           │   ├── ManagerDetails.java
│   │   │           │   ├── OneonOne.java
│   │   │           │   └── QuestionandAnswer.java
│   │   │           ├── services
│   │   │           │   ├── EmployeeDataServices.java
│   │   │           │   ├── HRDataServices.java
│   │   │           │   ├── InterceptorServices.java
│   │   │           │   ├── ManagerDataServices.java
│   │   │           │   └── TokenDataServices.java
│   │   │           └── swaggerconfig
│   │   │               └── SwaggerConfig.java
│   │   └── resources
│   │       ├── application.properties
│   │       ├── static
│   │       └── templates
│   └── test
│   │   └── META-INF
│   │       ├── MANIFEST.MF
│   │       └── maven
│   │           └── com.nineleaps
│   │               └── oneonone
│   │                   ├── pom.properties
│   │                   └── pom.xml
│   ├── javadoc-bundle-options
│   │   ├── javadoc-options-javadoc-resources.xml
│   │   └── package-list
│   ├── site
│   │   └── apidocs
│   │       ├── com
│   │       │   └── nineleaps
│   │       │       ├── controller
│   │       │       │   ├── EmployeeDataController.html
│   │       │       │   ├── FeedbackController.html
│   │       │       │   ├── HrDataController.html
│   │       │       │   ├── LoginController.html
│   │       │       │   ├── ManagerDataController.html
│   │       │       │   └── SuperHrDataController.html
│   │       │       ├── interceptor
│   │       │       │   ├── EmployeeInterceptor.html
│   │       │       │   ├── HrInterceptor.html
│   │       │       │   ├── Interceptor.html
│   │       │       │   ├── ManagerInterceptor.html
│   │       │       │   └── SuperHrInterceptor.html
│   │       │       ├── services
│   │       │       │   ├── EmployeeDataServices.html
│   │       │       │   ├── HRDataServices.html
│   │       │       │   ├── ManagerDataServices.html
│   │       │       │   └── TokenDataServices.html
│   │       │       └── swaggerconfig
│   │       │           └── SwaggerConfig.html
│   │       ├── javadoc.sh
│   │       ├── options
│   │       └── packages
│   ├── sonar
│   │   └── report-task.txt
│   └── test-classes
│       └── com
│           └── nineleaps
│               └── SignUpApi
│                   └── SignUpApiApplicationTests.class
├── test
└── tree

