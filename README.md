# Serenity BDD Automation Test With Zalenium Docker Grid

Project has been developed by using Cucumber, Serenity, Junit, Selenium tools and Docker, Zalenium for Grid structure.

## Installation

**Docker**
Docker container includes everything needed to run an application: code, runtime, system tools, system libraries and
settings so that users can easily install and deploy their tests.

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
    -         -Denvironment=staging
    -         -Denvironment= prod
    -         Default is prod

***

## Reporting

- Reports
    -         Watch historical test videos :  http://localhost:4444/dashboard/#
    -         Live watch : http://localhost:4444/grid/admin/live?refresh=10
    -         Report ui : /SerenityWebUiAutomation/target/site/serenity/index.html
    -         Boutique csv = Download from /SerenityWebUiAutomation/target/site/serenity/index.html or check project folder
    -         Grid panel :  http://localhost:4444/console

***

## Success Cases

- Data driven Boutique image and status
- Data driven Login cases
- Parallel cross browser
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
