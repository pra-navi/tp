---
layout: page
title: Xing Lingxi's Project Portfolio Page
---

### Project: CoordiMate

CoordiMate is a **desktop app for event planners**. It helps you **manage your contacts and tasks** for your events, so that you can focus on the event itself.

CoordiMate is **optimized for use via a Command Line Interface (CLI)** while still having the benefits of a Graphical User Interface (GUI).

If you can type fast, CoordiMate can help you get your contact management tasks done **faster than traditional GUI apps**.

Given below are my contributions to the project.

* **Code contributed**: [RepoSense link](https://nus-cs2103-ay2324s1.github.io/tp-dashboard/?search=HugeNoob&breakdown=true&sort=groupTitle%20dsc&sortWithin=title&since=2023-09-22&timeframe=commit&mergegroup=&groupSelect=groupByRepos&checkedFileTypes=docs~functional-code~test-code~other)<br><br>

* **New Feature**: `deleteAllPerson` ([PR #77](https://github.com/AY2324S1-CS2103T-T10-2/tp/pull/77))
  * What it does: Deletes all persons in the contacts list.
  * Justification: Provides a quick solution for clearing persons, enhancing organization and decluttering the interface.
  * Highlights: This was one of the first commands I worked on, which helped me to udnerstand the logic flow of the codebase. Unlike the `clear` command in AB3, I intentionally avoided the hard reset of the entire `AddressBook`. Instead, I took the approach of specifically resetting the `UniquePersonList`. This implementation is more robust as it integrates better with our future task functionalities. The original implementation would have cleared all tasks as well, which is not the desired behaviour.
  * Credits: The `deleteAllPerson` command was inspired by the `clear` command in AB3.<br><br>

* **New Feature**: `addTask` ([PR #84](https://github.com/AY2324S1-CS2103T-T10-2/tp/pull/84))
  * What it does: Adds a task to the task list.
  * Justification: Enables users to keep track of their tasks.
  * Highlights: Since task is a new entity that did not exist in AB3, I had to implement the logic and model flows for task to match the existing flow for persons. This meant that I had to understand the existing codebase deeply in order to make the necessary changes.
  * Credits: The `addTask` command was inspired by the `add` command in AB3.<br><br>

* **New Feature**: `editTask` ([PR #91](https://github.com/AY2324S1-CS2103T-T10-2/tp/pull/91))
  * What it does: Allows users to edit the title, note, or tags of a task.
  * Justification: Enables users to correct mistakes or update the details of their tasks.
  * Credits: The `editTask` command was inspired by the `edit` command in AB3.<br><br>

* **New Feature**: `deleteTagPerson` ([PR #120](https://github.com/AY2324S1-CS2103T-T10-2/tp/pull/120))
  * What it does: Deletes tag(s) from a person.
  * Justification: Initially, we could only specify new tags using the `editPerson` command. To delete a specific tag, the user would have to specify all existing tags, except the unwanted tag. This command provides a quick way for users to remove specific tags from a person.
  * Highlights: For this command, I had to handle the validity of the specified tags. Tags that exist on the person will be removed, while tags that do not exist will be ignored. I also gave the user feedback on the status of the deletion: specifying which tags were deleted, and which tags were not found.<br><br>

* **New Feature**: `deleteTagTask` ([PR #122](https://github.com/AY2324S1-CS2103T-T10-2/tp/pull/122))
  * What it does: Deletes tag(s) from a task.
  * Justification: Initially, we could only specify new tags using the `editTask` command. To delete a specific tag, the user would have to specify all existing tags, except the unwanted tag. This command provides a quick way for users to remove specific tags from a task.
  * Highlights: Similar to the `deleteTagPerson` command, I also had to handle the validity of the specified tags.<br><br>

* **New Feature**: Add shortened command words to existing commands ([PR #106](https://github.com/AY2324S1-CS2103T-T10-2/tp/pull/106))
  * What it does: Users can now use shortened command words for existing commands.
  * Justification: Some of our commands, such as `deleteTagPerson`, were getting lengthy and troublesome to write each time. In the spirit of catering to fast typers, we decided to add shortened command words.
  * Credits: This idea is inspired by the [C-FriendlierSyntax](https://nus-cs2103-ay2324s1.github.io/website/se-book-adapted/projectDuke/index.html#c-friendliersyntax) from iP extensions. For this task, I added shortened command words for the commands that existed at that point in time. Further shortened command words were added by other team members later on.<br><br>

* **Enhancement to existing features**: `help` ([PR #75](https://github.com/AY2324S1-CS2103T-T10-2/tp/pull/75))
  * What it does: Brings up a new window that displays the link to our user guide. A new button was added that allows users to directly open the link in their browser.
  * Justification: We wanted to improve the user experience by skipping the step of manually copy-and-pasting the link to the browser.
  * Credits: The `help` command is an adaptation of the `help` command in AB3.<br><br>

* **Project management**:
  * Introduced a [PR template](https://github.com/AY2324S1-CS2103T-T10-2/tp/pull/17) for the team to follow.
  * Proposed a 2-approval policy for PRs before merge. This improves the quality of the codebase and reduces the chances of bugs.<br><br>

* **Documentation**:
  * User Guide:
    * Added documentation for `deleteAllPerson`, `addTask`, `editTask`, `deleteTagPerson`, `deleteTagTask`, `help`, `exit`.
  * Developer Guide:
    * Added implementation details for `editTask`.
    * Added user stories and use cases for `deleteAllPerson`, `addTask`, `editTask`, `deleteTagPerson`, `deleteTagTask`, `help`.
    * Added Non-Functional Requirements section.<br><br>

* **Community**:
  * PRs reviewed by me can be found [here](https://github.com/AY2324S1-CS2103T-T10-2/tp/pulls?q=is%3Apr+reviewed-by%3AHugeNoob+).
  * Forum discussions that I have participated in can be found [here](https://github.com/nus-cs2103-AY2324S1/forum/issues?q=is%3Aissue+commenter%3AHugeNoob+).
  * Reported [10 bugs and suggestions](https://github.com/HugeNoob/ped/issues) for other teams during the PE dry run.<br><br>
