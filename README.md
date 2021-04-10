# Serenity BDD Automation Test With Zalenium Docker Grid
This project is built with Cucumber, Serenity, Junit and Selenium. Also used Docker and Zalenium for Grid structure

## Installation
**Docker**
Tests are very easy to install and deploy in a Docker container.
```sh
docker info
docker pull elgalu/selenium
```

Then run compose file in project directory
```sh
cd <project/path>
docker-compose up --force-recreate
```


## Executing the tests

```
sh cd <project/path>
mvn clean verify -Dserenity.runner=ParallelRunner -Dwebdriver.driver=chrome

Run with options
mvn clean verify -Dserenity.runner=ParallelRunner -Dwebdriver.driver=chrome -Denvironment=prod
```

- Run options
    - *Driver* : -Dwebdriver.driver=firefox
    - *Filter*
    -         -Dcucumber.filter.tags="@Login"
    -         -Dcucumber.filter.tags="@Login or @Performance"
    - *Enviroment*
    -         -Denvironment=prod
    -         -Denvironment=test
    -         Default is prod

***

## Reporting
- Reports
    -         Watch test live and historical :  http://localhost:4444/dashboard/# 
    -         Report ui : /SerenityWebUiAutomation/target/site/serenity/index.html
    -         Grid panel :  http://localhost:4444/console
***


## Success Cases
- Data driven Boutique image and status status
- Data driven Login cases
- Parallel crosss browser
- Zalenium with Selenium grid docker
- Reporting

***

## Tools
- Junit
- Serenity BDD
- Cucumber
- Selenium grid
- Docker
- Zalenium
- Webdrivermanager - bonigarcia
- Maven
***
