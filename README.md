# ECSE321 Project Group 06 [![Build Status](https://travis-ci.com/McGill-ECSE321-Winter2019/ecse321-group-project-06.svg?token=1hWgpGRW29zUadc5ySpu&branch=master)](https://travis-ci.com/McGill-ECSE321-Winter2019/ecse321-group-project-06)
 Company Viewpoint of CO-OP-ERATOR

## Main Scope of the Project
There are already several co-op programs offered by McGill University, and the number of such co-op programs may increase in the future. In a co-op program, students need to take multiple semesters at companies as an integral part of their curriculum in so-called co-op terms. The scope of the software engineering group project of the Winter 2019 ECSE321 course is to develop a software system for managing co-op terms for such co-op programs. 

In a team of five students, our goal is to gather requriements, design a multi-tier software solution to satisfy those requirements, implement the system, validate that the system is satisfying the requirements, and develop a release pipeline to automate the software delivery process. Viewpoints (Student, Company, Co-op Administrator, and Academic manager) developed by multiple teams will be integrated with each other via service calls. 

Our team focuses on company (employer) viewpoint. An employer can do the following actions in the CO-OPERATOR System:
- Confirm when a student has started the co-op position
- Complete a student evaluation form as a confirmation of completion 
- download a proof of co-op placement and access taxk credit forms with instructions 
- Be notified about or invited to upcoming events

# Deliverable 1

## Main Tasks
- Requirement model: Functional & Non functional Requirements, Use cases, Use case specification 
- Domain model
- Database design
- Test cases for persistence layer

## Design Decision
Design decisions:
- Created User class which has student, employer, coop administrator and academic manager generalizations. This makes the organization more clean.
- Created the id attribute for each class. The id is used as the primary key attribute to differentiate each object. 
- Created two data structures, date and time to have a better representation of some data.

## Documents 
    
- **Requirements Model**
    - [System Requirements](https://github.com/McGill-ECSE321-Winter2019/ecse321-group-project-06/wiki/System-Requirements)
    - [Use Cases](https://github.com/McGill-ECSE321-Winter2019/ecse321-group-project-06/wiki/5-Use-Case-Specifications)
    - [Use Case Diagram](https://github.com/McGill-ECSE321-Winter2019/ecse321-group-project-06/wiki/Use-Case-Diagram)

- **Domain Model**
    - [class diagram](https://github.com/McGill-ECSE321-Winter2019/ecse321-group-project-06/wiki/Domain-Model)
  
- **Minutes**
    - [Meeting Minutes 1.1](https://github.com/McGill-ECSE321-Winter2019/ecse321-group-project-06/wiki/Deliverable-1-Meeting-Minutes-1.1)
    - [Meeting Minutes 1.2](https://github.com/McGill-ECSE321-Winter2019/ecse321-group-project-06/wiki/Deliverable-1-Meeting-Minutes-1.2)
    - [Meeting Minutes 1.3](https://github.com/McGill-ECSE321-Winter2019/ecse321-group-project-06/wiki/Deliverable-1-Meeting-Minutes-1.3)
    - [Meeting Minutes 1.4](https://github.com/McGill-ECSE321-Winter2019/ecse321-group-project-06/wiki/Deliverable-1-Meeting-Minutes-1.4)
    - [Meeting Minutes 1.5](https://github.com/McGill-ECSE321-Winter2019/ecse321-group-project-06/wiki/Deliverable-1-Meeting-Minutes-1.5)
    
- **Effort Table**
    - [Effort Table](https://github.com/McGill-ECSE321-Winter2019/ecse321-group-project-06/wiki/Deliverable-1-Effort-Table)   

## Table 
| Team's Member Name | Total Hours | Requirements Model | Domain Model | Persistence Layer | Testing of  Persistence Layer | Build System and  Continuous Integration | Documentation | Meeting |
|--------------------|-------------|--------------------|--------------|-------------------|-------------------------------|------------------------------------------|---------------|---------|
| Lily Li            |  23.5        |  3.5                |    4     |     0.5      |    3      |    8                                        |  1.5           |  3    |
| Yin Zhang          |  19.5        |  2.5                |    8     |      2       |    3      |    1                                        |  0             |  3     |
| Irene Huang        |  19.5        |  3.5                |    2     |      0       |    8      |    1                                        |  2             |  3     |
| Xinquan Wang       |  19.5        |  3.5                |    2     |      0       |    10     |    1                                        |  0             |   3    |
| Zhuzhen Li         |  19.5        |  3.5                |    2     |      0       |    8      |    1                                        |  2             |   3    |
