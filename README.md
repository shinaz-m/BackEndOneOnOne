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
