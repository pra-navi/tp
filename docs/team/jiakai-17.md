---
layout: page
title: Li Jiakai's Project Portfolio Page
---

### Project: CoordiMate

CoordiMate is a **desktop application** designed specifically for **SoC Computing Club event planners** to help **manage their contacts and tasks** for their events, so that they can focus on the event itself.

Given below are my contributions to the project.

* **New Feature**: Implemented the `findPerson` command. (PR [#74](https://github.com/AY2324S1-CS2103T-T10-2/tp/pull/74))
  * **What it does**: It allows users to quickly filter their contact list to show only contacts whose names match a given keyword.
  * **Justification**: This feature allows users to quickly find the contact they are looking for, without having to scroll through the entire contact list. Without this feature, finding a specific contact would be cumbersome if the user has a large number of contacts.
  * **Credits**: The `findPerson` command was adapted from the `find` command in the AddressBook-Level3 project (AB3) created by the [SE-EDU initiative](https://se-education.org).<br><br>


* **New Feature**: Implemented the `Task` objects and loading/saving of tasks. (PR [#81](https://github.com/AY2324S1-CS2103T-T10-2/tp/pull/81), [#83](https://github.com/AY2324S1-CS2103T-T10-2/tp/pull/83))
  * **What it does**: It specifies the attributes that a `Task` should have.
  * **Justification**: This feature allows CoordiMate to handle tasks and execute commands related to tasks.
  * **Highlights**: This feature required me to create a new classes to represent the various attributes that a `Task` should have, and to update the existing code to make it compatible with the new `Task` class.<br><br>


* **New Feature**: Implemented the `findTask` command. (PR [#85](https://github.com/AY2324S1-CS2103T-T10-2/tp/pull/85))
  * **What it does**: It allows users to quickly filter their task list to show only tasks whose titles or note match a given keyword.
  * **Justification**: This feature allows users to quickly find the task they are looking for, without having to scroll through the entire task list. Without this feature, finding a specific task would be cumbersome if the user has a large number of tasks.
  * **Highlights**: While implementing this feature, I had to create the relevant `Predicate<Task>` classes such that the `findTask` command can search for tasks based on the title or note of the task and filter the task list.
  * **Credits**: The `findTask` command was inspired by the `find` command in AB3.<br><br>


* **New Feature**: Implemented the `listTags` command. (PR [#102](https://github.com/AY2324S1-CS2103T-T10-2/tp/pull/102))
  * **What it does**: It allows users to view all the tags that have been used in the contact and task list.
  * **Justification**: When the contact and task lists get long, it can be difficult for the users to remember the tags that they have used. This feature allows users to quickly view all the tags that have been used so far, along with their frequencies.

<div style="page-break-after: always;"></div>

* **Code contributed**: [RepoSense link](https://nus-cs2103-ay2324s1.github.io/tp-dashboard/?search=jiakai-17&breakdown=true)

* **Project management**:
  * Set up GitHub Actions and Codecov to track code coverage.
  * Added icons to CoordiMate and Product Website.<br><br>

* **Enhancements to existing features**:
  * Added status icons to UI to denote whether a task is done. (PR [#94](https://github.com/AY2324S1-CS2103T-T10-2/tp/pull/94))<br><br>

* **Documentation**:
  * **User Guide**:
    * Added Admonitions to User Guide. (PR [#2](https://github.com/AY2324S1-CS2103T-T10-2/tp/pull/2))
    * Added documentation for the `findPerson`, `findTask` and `listTags` commands. (PR [#70](https://github.com/AY2324S1-CS2103T-T10-2/tp/pull/70/), [#108](https://github.com/AY2324S1-CS2103T-T10-2/tp/pull/108))<br><br>
  * **Developer Guide**:
    * Added Admonitions to Developer Guide. (PR [#54](https://github.com/AY2324S1-CS2103T-T10-2/tp/pull/54))
    * Added user stories and use cases for `findPerson`, `findTask` and `listTags` commands. (PR [#54](https://github.com/AY2324S1-CS2103T-T10-2/tp/pull/54), [#121](https://github.com/AY2324S1-CS2103T-T10-2/tp/pull/121))
    * Added implementation details of `findTask` feature. (PR [#100](https://github.com/AY2324S1-CS2103T-T10-2/tp/pull/100/))
    * Updated existing Storage and Model class diagrams to include `Task` class. (PR [#121](https://github.com/AY2324S1-CS2103T-T10-2/tp/pull/121))
    * Converted existing PNG diagrams to SVG format for better readability. (PR [#121](https://github.com/AY2324S1-CS2103T-T10-2/tp/pull/121))<br><br>

* **Community**:
  * PRs reviewed (with non-trivial review comments): [#86](https://github.com/AY2324S1-CS2103T-T10-2/tp/pull/86), [#117](https://github.com/AY2324S1-CS2103T-T10-2/tp/pull/117), [#118](https://github.com/AY2324S1-CS2103T-T10-2/tp/pull/118)
  * Contributed to forum discussions: Forum [#25](https://github.com/nus-cs2103-AY2324S1/forum/issues/25), Forum [#34](https://github.com/nus-cs2103-AY2324S1/forum/issues/34)
  * Reported 6 bugs and suggestions during PE Dry Run. ([Repo](https://github.com/jiakai-17/ped/issues))<br><br>

* **Tools**:
  * Integrated Cloudflare Pages to test product website deployments.
  * Set up GitHub Actions to automate releases. (PR [#5](https://github.com/AY2324S1-CS2103T-T10-2/tp/pull/5))<br><br>
