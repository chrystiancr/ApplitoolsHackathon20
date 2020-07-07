# Applitools Cross Browser Testing Hackathon 20

## The Challenge:
The challenge is to build the automation suite for the first version of the app and use it to find bugs in the second version (V2) of the app.  You need to automate three (3) main tasks across seven (7) different combinations of browsers and screen resolutions (viewports). Further, you need to automate the tasks in both the traditional approach and the Modern approach through Visual AI, for both V1 and V2 versions of the app. By “traditional approach”, we mean without using Applitools Visual AI. You can execute the traditional tests either locally or by using other cross-browser cloud solutions that you are already familiar with.

### Results: 
 - The traditional approach tests report can be found at root of the project (Traditional-V1-TestResults.txt, Traditional-V2-TestResults.txt)
 - The modern approach tests results can be found on [Applitools Eyes Dashboard](https://eyes.applitools.com/app/test-results/00000251808193934975/?accountId=wYVTSJTtSU2CZDfkJNAC7w~~)

## The Application:
- IntelliJ IDEA
- Maven 3.6.3
- Java 8
- TestNG 7.1.0
- Selenium 3.141.59
- WebdriverManager 4.0.0
- Applitools SDK 3.164.0

## Usage:
- mvn test
- test suite config: modern-test-testng.xml / traditional-test-testng.xml
- envs: config.proprieties