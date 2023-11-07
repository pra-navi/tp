---
layout: page
title: Megan Loo's Project Portfolio Page
---

### Project: CoordiMate

CoordiMate is an intuitive desktop application designed specifically for School of Computing (SoC) Computing Club event planners. 

It streamlines the complexities of contact and task management with its user-friendly interface, ensuring seamless navigation and increased productivity for efficient event planning. 

Given below are my contributions to the project.

* **New Feature**: `editPerson` (PR [#76](https://github.com/AY2324S1-CS2103T-T10-2/tp/pull/76))
  * What it does: Allows users to modify existing person records, updating contact details as needed.
  * Justification: Enhances flexibility and accuracy in managing contacts, ensuring up-to-date information.
  * Credits: The `editPerson` command was adapted from the `edit` command in the AddressBook-Level3 project (AB3) created by the [SE-EDU initiative](https://se-education.org).<br><br>

* **New Feature**: `deleteAllTask` (PR [#90](https://github.com/AY2324S1-CS2103T-T10-2/tp/pull/90))
  * What it does: Enables users to delete all tasks at once, cleaning up to a fresh new start of the task list.
  * Justification: Provides a quick solution for clearing tasks, enhancing organization and decluttering the interface.
  * Highlights:  This feature required me to have an in-depth understanding of the execution pipeline for commands and making the right design decisions when creating and manipulating a task list based on existing UniquePersonList.
  * Credits: The `deleteAllTask` command was inspired by the `clear` command in AB3.<br><br>

* **New Feature**: `markTask` & `unmarkTask` (PR [#86](https://github.com/AY2324S1-CS2103T-T10-2/tp/pull/86))
  * What it does: Allows users to mark tasks as completed or undo task completion status, indicating progress and keeping track of accomplished tasks.
  * Justification: Easy task status update, ensuring users stay on top of their to-do list, aiding in progress assessment and prioritization.
  * Highlights: This feature involved creating a new "Status" field and "TaskStatus" enumeration, ensuring a clear distinction between completed (DONE) and pending (NOT_DONE) tasks. Utilizing STATUS_DONE and STATUS_NOT_DONE constants further enhanced readability and differentiation of task states within the Status class. <br><br>
  
* **New Feature**: `findDone` & `findNotDone` (PR [#99](https://github.com/AY2324S1-CS2103T-T10-2/tp/pull/99))
  * What it does: Facilitates quick search and display of all completed or pending tasks, aiding in review and prioritization.
  * Justification: Instant retrieval of completed or pending tasks, promoting effective task analysis.
  * Highlights: Implementing this feature required an in-depth understanding of how lists are displayed in JavaFX. New predicates were implemented based on the existing PREDICATE_SHOW_ALL_PERSONS in AB3. <br><br>

* **New Feature**: `deleteAllDone` (PR [#115](https://github.com/AY2324S1-CS2103T-T10-2/tp/pull/115))
  * What it does: Provides the option to delete all completed tasks, keeping the task list concise and relevant.
  * Justification: Reduces clutter, ensuring users focus on ongoing and upcoming tasks without distractions.
  * Highlights: Implementing this feature required an in-depth understanding of how dynamic nature of the list and the necessity to maintain order, the loop approach was adjusted. 
The loop iteration from the back was found to be essential for proper deletion, overcoming index errors and ensuring the accurate removal of completed tasks.<br><br>

* **Code contributed**: [RepoSense link](https://nus-cs2103-ay2324s1.github.io/tp-dashboard/?search=m1oojv&breakdown=true)<br><br>

* **Project management**:
  * Set up assertions for gradle (PR [#110](https://github.com/AY2324S1-CS2103T-T10-2/tp/pull/110))
  * Addressed javafx plugin + problem that was brought up in the forum (PR [#18](https://github.com/AY2324S1-CS2103T-T10-2/tp/pull/18))
  * Opened issues for each milestones (Issue [#41](https://github.com/AY2324S1-CS2103T-T10-2/tp/issues/41), [#98](https://github.com/AY2324S1-CS2103T-T10-2/tp/issues/98), [#114](https://github.com/AY2324S1-CS2103T-T10-2/tp/issues/114))<br><br>

* **Enhancements to existing features**:
  * Update help messages data to have more realistic tags towards event planning.<br><br>

* **Documentation**:
  * User Guide:
    * Add documentation for the `editPerson`, `deleteAllTask`, `markTask`, `unmarkTask`, `findDone`, `findNotDone` and `deleteAllDone` commands.
    * Add self drawn mockups of GUI for User Guide (Commit [#0a25954](https://github.com/AY2324S1-CS2103T-T10-2/tp/pull/20/commits/0a25954d0d7a5b4d0a5b5da7ddf313bd0861c78b))
  * Developer Guide:
    * Add user stories and use cases for `editPerson`, `deleteAllTask`, `markTask`, `unmarkTask`, `findDone`, `findNotDone` and `deleteAllDone` commands.
    * Added implementation details of `markTask` feature.<br><br>

* **Community**:
  * PRs reviewed (with non-trivial review comments): [Coming soon!]
  * Contributed to forum discussions: Forum [#6](https://github.com/nus-cs2103-AY2324S1/forum/issues/6)
  * Reported 5 bugs and suggestions during PE Dry Run. ([Repo](https://github.com/m1oojv/ped/issues))<br><br>

* **Tools**:
  * Created mockup templates for teammates to use when adding mockups to the UG ([link](https://docs.google.com/presentation/d/1fXBqhAU6SSoSZdYVog3G9v5H6gXFMCzPAQ2BjzzWzM4/edit#slide=id.p))<br><br>
