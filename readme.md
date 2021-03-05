Midtrans cucumber framework

Tools and Technologies
JAVA
Maven
JUNIT
Cucumber
Selenium

Setup before running
Install JAVA
Install Maven
Install IDE (optional)
Set JAVA_PATH
Export project to IDE (optional)

Project is build on MacOs
To work with win machine drivers path need to be changed. Download the drivers from below link and replace it on /resources/driver/

To work with Linux machine download the drivers from below link and replace it on /resources/driver/ 

chromedriver :https://chromedriver.chromium.org/downloads 
geckodriver : https://github.com/mozilla/geckodriver/releases

Steps to run tests from terminal
Go to project directory - midtrans from terminal
cd ${user.dir}/midtrans
mvn clean install
mvn test -Dcucumber.options="--tags @smoke"

Reports can be view at : - midtrans/target/HtmlReports
