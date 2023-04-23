# OctoAPI
###### Rest API

This is the API for Octopodius project.

- [0 Technologies](#0-technologies)
- [1 Architecture](#1-architecture)
  - [1.1 Why many DTOs?](#11-why-many-dtos)
  - [1.2 Authorization and Authentication](#12-authorization-and-authentication)
- [2 Infrastructure](#2-infrastructure)
  - [2.1 Database Diagram](#21-database-diagram)
  - [2.2 Docker](#22-docker)
  - [2.3 Cloud Services](#23-cloud-services)

## 0 Technologies

[<img height="32em" alt="Java 17" src="https://www.svgrepo.com/show/353924/java.svg" />][java]
[<img height="32em" alt="Spring Framework" src="https://www.svgrepo.com/show/376350/spring.svg" />][spring]
[<img height="32em" alt="PostgreSQL" src="https://www.svgrepo.com/show/354200/postgresql.svg" />][pg]

## 1 Architecture

#### 1.1 Why many DTOs?

Organization of project, architecture, and improve the security of application datas against **Mass Assignment Attack**, [read more about this cheatsheet on OWASP](https://cheatsheetseries.owasp.org/cheatsheets/Mass_Assignment_Cheat_Sheet.html).

#### 1.2 Authorization and Authentication

###### 1.2.1 **JWT Token**

<details>

![Authorization](./docs/uml/V1/Authorization_n_Authentication.png)

</details>

#### 1.3 Security

###### 1.3.1 **Security Configurations**

- CSRF: Disable the protection against Cross-Site Request Forgery, because the JWT Token protect the application against it (redundancy if it is enabled and use JWT Token);
- Stateless Authentication: The application uses JWT Token, so the configuration is STATELESS instead the default (STATEFULL);
- Filters added (SecurityFilter.class): Spring Filters to check the JWT Token, validate and identify the user;
- Password Hash: BCrypt implemented to hash the user password;
- Spring Security: Configurations made using the Spring Security.


## 2 Infrastructure

#### 2.1 Database diagram

###### 2.1.1 ERD Diagram

<details>

![V1 Diagram](./docs/infra/V1_Diagram.png)

</details>

#### 2.2 Docker

###### 2.2.1 To-Do List

- [ ] Create Dockerfile to run the Spring Application

#### 2.3 Cloud Services

###### 2.3.1 To-Do List

- [ ] Azure Repository
- [ ] Azure PostgreSQL Database
- [ ] Azure Containers/Kubernets
- [ ] Azure KeyVault
- [ ] CI/CD and Pipelines
- [ ] Use DNS
- [ ] Use TLS/SSL certificates

[java]: https://docs.oracle.com/en/java/
[spring]: https://docs.spring.io/spring-framework/docs/current/reference/html/index.html
[pg]: https://www.postgresql.org/docs/
