# README #
Testing Framework powered by TestNG and Selenium 

### How to start? ###

* Download and install IntelliJ IDEA  - [here] (https://www.jetbrains.com/idea/download/#section=windows)
* Download and install Java SE Development Kit for your OS from [Oracle latest SE kit](https://www.oracle.com/technetwork/pt/java/javase/downloads/index.html)
* Download Maven from [Maven Download](https://maven.apache.org/download.cgi) and add it to your Windows PATH - [Windows guide](https://maven.apache.org/guides/getting-started/windows-prerequisites.html)
* On Windows install [GIT](https://git-scm.com/downloads)
* Open IntelliJ IDEA and clone project following this [instruction](https://www.jetbrains.com/help/webstorm/cloning-a-repository-from-github.html)
* To make sure everything works fine open Terminal in IntelliJ IDEA and run mvn clean compile - BUILD SUCCESS message should appears
* Download chromedriver compatible with your local chrome installation [here](https://chromedriver.chromium.org/downloads)
* Pur chromedriver.exe to resource folder (TBD //todo - fix this after you start using webdrivers)

### How do I get set up? ###

* run smoke suite: mvn clean -e test 

### How do I view results
Run command mvn allure:report after successful test run <br>
Report will be generated based on /target/allure-results dir and placed to target/site/allure-maven-plugin dir <br>
Open index.html in any browser <br>

**Environment variables**
Using environment variables:
1. Tap edit Run/Debug configurations menu
2. Click 'edit configurations'
3. On VM options bar tap all needed environments variable
// TBD