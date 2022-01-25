# Selenium-Java-Extent Framework

A Maven framework in which to build Selenium tests written in Java with Extent reports of test results. Framework is based on page object model.


## Getting Started

Download or clone the repo into your local machine.

```
https://github.com/SajidMehmood88/laserhub.git
```

### Run tests locally

Right click the test or testng.xml and select "Run" to start the test.

### Run tests through the commandline

To run the test, use your CI or point Maven to the project and use the:

```
mvn test
```

##  Logging

Logging can be easily added to tests by using the static methods from the Log class.

Available logging levels are:

|Logging Level|Method                                       |
|:------------|:--------------------------------------------|
|Info         |Log.Info("This is an info level message");   |

## Reporting

The reporting provided by the framework is Extent.
Screenshots are taken after failure (if any), which will display on each step of the report.

## ChromeDriver Version
ChromeDriver 93.0.4577.63

Link to download compatible ChromeDriver https://chromedriver.chromium.org/downloads

## Built With

* [Selenium](https://github.com/SeleniumHQ/selenium) - Browser automation framework
* [Maven](https://maven.apache.org/) - Dependency management
* [TestNG](https://github.com/cbeust/testng) - Testing framework
* [ExtentReports](https://github.com/extent-framework/) - Reporting framework
