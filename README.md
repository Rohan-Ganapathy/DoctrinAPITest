# Doctrin API REST-Assured Tests
> Retrieves and Processes Convid19 stats from APIs using REST-Assured with Cucumber-TestNG Hybrid framework 

[![java Version][java-image]][java-url]
[![mvn Version][mvn-image]][mvn-url]
[![cucumber Version][cucumber-image]][cucumber-url]
[![testng Version][testng-image]][testng-url]
[![restassured Version][restassured-image]][restassured-url]

Doctrin API Tests use REST-Assured library to make REST calls and retrive response details and processing them. This is wrapped around with by a library and framework build in java and maven to make writing tests, building and integrating with CI/CD systems easy. Cucumber-TestNG frameworks are also used. Cucumber makes test cases easy to maintain, create, read and understand to non-technical users while testNG is used to run the cucumber feature file and also makes it easy to integrate and scale with other systems.

![](https://github.com/Rohan-Ganapathy/doctrinimages/blob/master/Doctinlogo.jpg)

## Installation

OS X & Linux:

Install Brew

```sh
/bin/bash -c "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/master/install.sh)"
```
Install Java

```sh
brew install java
```
Install Maven

```sh
brew install maven
```
Windows:

Follow the steps to install Java and Maven: [Link](https://howtodoinjava.com/maven/how-to-install-maven-on-windows/)

## Usage example

To run the test from terminal
```sh
mvn test
```
To clean files and directories generated by maven before the running the tests
```sh
mvn clean test
```

To change the country, open the ["doctrinAPI.feature"](/src/test/resources/doctrinAPI.feature) cucumber file in any editor and enter the desiered IOS2 code for the country.
Below is an example for the country Greece with ISO2 code GR.
![](https://github.com/Rohan-Ganapathy/doctrinimages/blob/master/DoctrinAPITest/Cucumberfeature.png)

Note: The tests run in the background, give it time to finish and generate the report.

## Reporting

A text file report with the result of the run is created after each test run 
The text report file is located in 'TextReport' folder once the test has completed: [TextReport/Result.txt](/TextReport/)
![](https://github.com/Rohan-Ganapathy/doctrinimages/blob/master/DoctrinAPITest/TextReport.png)

The text file also records details on the errors that may occur if the API fails to retrive data.
![](https://github.com/Rohan-Ganapathy/doctrinimages/blob/master/DoctrinAPITest/ErrorTextReport.png)

The results are also printed to the console(As per requirement)
![](https://github.com/Rohan-Ganapathy/doctrinimages/blob/master/DoctrinAPITest/ConsoleReport.png)

A Cucumber report is generated after each test run

The report is located in target folder once the test has completed: DoctrinAPITest/target/cucumber-html-report/cucumber-html-reports/overview-features.html

The overview-features.html is the report overview
![](https://github.com/Rohan-Ganapathy/doctrinimages/blob/master/DoctrinAPITest/reportoverview.png)
The report-feature_doctrinAPI-feature.html can be accessed by clicking on the Feature name in the report overview. This shows all the test scenarios and test steps that are run as part of the test and also shows fail cases along with appropriate errors.
![](https://github.com/Rohan-Ganapathy/doctrinimages/blob/master/DoctrinAPITest/reportoverviewfeature.png)

## Meta

Author – [@RohanGanapathy](rohanganapathy@gmail.com)

[github](https://github.com/Rohan-Ganapathy)

<!-- Markdown link & img dfn's -->
[java-image]: https://img.shields.io/badge/java-1.7-orange
[java-url]: https://www.oracle.com/java/technologies/javase-jdk13-downloads.html
[mvn-image]: https://img.shields.io/badge/mvn-3.6.3-yellow
[mvn-url]: https://github.com/apache/maven
[cucumber-image]: https://img.shields.io/badge/cucumber-green
[cucumber-url]: https://github.com/cucumber/cucumber-jvm
[testng-image]: https://img.shields.io/badge/testng-darkgreen
[testng-url]: https://github.com/cucumber/cucumber-jvm/tree/master/testng
[restassured-image]: https://img.shields.io/badge/REST_assured-blue
[restassured-url]: https://github.com/cucumber/cucumber-jvm/tree/master/testng
