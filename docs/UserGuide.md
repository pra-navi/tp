---
layout: page
title: User Guide
---

Do you have trouble managing contacts?

Don't worry, CoordiMate is here to help!

Are you a SOC Computing Club event planner juggling numerous tasks and contacts for your upcoming events? 
Managing everything efficiently just got easier with CoordiMate!

CoordiMate is your go-to **desktop app designed specifically for SOC Computing Club event planners**. 
It helps you **manage your contacts and tasks** for your events, so that you can focus on the event itself.

Whether you're organizing a workshop, seminar, or a grand social event, CoordiMate is tailored 
to meet the unique needs of SOC Computing Club event planners. 
And here's the best part – while it's perfect for SOC Computing Club, 
**event planners of all kinds** can benefit from CoordiMate's powerful features too!

Don't let the stress of managing contacts and tasks weigh you down. Let CoordiMate handle the details, 
so you can focus on creating extraordinary events.

Why choose CoordiMate? Here's why:

1. **Tailored Precision**: Designed with SOC Computing Club event planners in mind, 
CoordiMate ensures every feature meets your specific requirements.

2. **Efficient Management**: Seamlessly handle your contacts and tasks, 
allowing you to focus on the creative aspects of your event.

3. **User-Friendly CLI**: CoordiMate is optimized for use via a Command Line Interface (CLI), 
offering the speed of typing with all the benefits of a Graphical User Interface (GUI).

4. **Speedy Performance**: If you're a fast typist, CoordiMate will help you complete your contact and 
tasks management faster than traditional GUI apps, ensuring your productivity soars.

Don't let the stress of contact and task management hinder your event planning creativity. 
Let CoordiMate take care of the details, empowering you to craft extraordinary events with confidence.

Ready to plan your events effortlessly?  
**CoordiMate is here to support your success!**

This comprehensive user guide contains all the information you need to get started with CoordiMate. 

- If you're a **new user**, head to our [Quick Start](#quick-start) section for a smooth initiation.  
- For **returning users** needing a quick refresher, our [Command Summary](#command-summary) section will be your handy guide.


## Using This Guide

This document will guide you on the various features of CoordiMate and how to use them.

If you are a new user, we recommend that you read this guide starting from the [Quick Start](#quick-start) section.

If you are an advanced user, you can use the [Table of Contents](#table-of-contents) below to quickly locate the relevant section. Alternatively, you can jump to the [Command Summary](#command-summary) section for an overview of the command syntax.

Here are some annotations used in this guide:

{% include admonition.html type="danger" title="Danger!" body="

Be careful when performing these operations as they can lead to data loss.

" %}

{% include admonition.html type="warning" title="Warning" body="

Take note of these as they can cause unexpected behaviour when using CoordiMate.

" %}

{% include admonition.html type="note" title="Note" body="

Contains useful information to help you use CoordiMate better.

" %}

{% include admonition.html type="question" title="Question" body="

Answers to frequently asked questions about CoordiMate.

" %}

{% include admonition.html type="bug" title="Known Issue" body="

Known issues that you may face when using CoordiMate and how to resolve them.

" %}

Throughout this guide, you will see different text styles that are used to highlight important information.

- <a href="javascript: void(0)">Text in blue</a> are links which you can click on to jump to the relevant section.
- `Text with light blue background` are commands or file names which are used for CoordiMate.

<div style="page-break-after: always;"></div>

---

## Table of Contents

- Table of Contents
{:toc}

---

<div style="page-break-after: always;"></div>

## Quick start

1. Ensure you have Java `11` or above installed in your Computer.

2. Download the latest `CoordiMate.jar` from [here](https://github.com/AY2324S1-CS2103T-T10-2/tp/releases).

3. Copy `CoordiMate.jar` to the folder you want to use as the _home folder_ for CoordiMate. This folder will be used by CoordiMate to store its data.

4. Open a command terminal, `cd` into the folder you put `CoordiMate.jar` in, and use the `java -jar CoordiMate.jar` command to start CoordiMate.<br>

   A GUI similar to the below picture should appear in a few seconds. Note how the app contains some sample data.<br><br>
   ![Ui](images/Ui.png)

5. Type the command in the command box and press Enter to execute it. e.g. typing **`help`** and pressing Enter will open the help window.<br>
   Some example commands you can try:

   * `listPerson` : Lists all persons.

   * `addPerson n/John Doe p/98765432 e/johnd@example.com a/John street, block 123, #01-01` : Adds a new contact named `John Doe` with the specified details.

   * `deletePerson 3` : Deletes the 3rd contact shown in the current contact list.

   * `findTask Get` : Finds all tasks with the word `caterer` in their title or note.

   * `listTask` : Lists all tasks.

   * `addTask T/Get Flowers n/Wedding Anniversary` : Adds a task titled `Get Flowers` with note `Wedding Anniversary` to the task list.

   * `markTask 1` : Marks the 1st task shown in the current task list as done.

   * `exit` : Exits the app.

6. Refer to the [Usage](#usage) section below for details of each command.

---

<div style="page-break-after: always;"></div>

## Features

1. Create, Read, Update, Delete (CRUD) Person
2. Find Person
3. CRUD Task
4. Find Task
5. Automatic saving and loading of data from save file
    1. CoordiMate automatically saves its data as a JSON file located at `[JAR file location]/data/CoordiMate.json`.
    2. There is no need to save manually.
    3. On startup, CoordiMate will automatically load existing data (if any) from the JSON file.
6. Editable file format
   1. Advanced users are welcome to update data directly by editing that data file.

{% include admonition.html type="danger" title="Potentially Dangerous Operation!" body="

If your changes to the data file makes its format invalid, CoordiMate will discard all data and start with an empty data file at the next run.

Always make a backup before you edit!

" %}

---

<div style="page-break-after: always;"></div>

## Usage

{% include admonition.html type="note" title="Note: About Command Formats" body="

<ul>
  <li>
    <p>
      Words in <code>UPPER_CASE</code> are the parameters to be supplied by the user.<br>
      e.g. in <code>addPerson n/NAME</code>, <code>NAME</code> is a parameter which can be used as <code>addPerson n/John Doe</code>, where <code>John Doe</code> is the value of the parameter <code>NAME</code>. <br>
    </p>
  </li>

  <li>
    <p>
      Items in square brackets are optional.<br>
      e.g <code>n/NAME [t/TAG]</code> can be used as <code>n/John Doe t/friend</code> or as <code>n/John Doe</code>.<br>
      Note that the square brackets (<code>[</code> and <code>]</code>) are not part of the syntax.
    </p>
  </li>

  <li>
    <p>
      Items in square brackets with <code>…</code> after them can be used multiple times, including zero times.<br>
      e.g. <code>[t/TAG]…​</code> can be used as <code> </code> (i.e. 0 times), <code>t/friend</code>, <code>t/friend t/family</code> etc.
    </p>
  </li>

  <li>
    <p>
      Parameters can be in any order.<br>
      e.g. if the command specifies <code>n/NAME p/PHONE_NUMBER</code>, <code>p/PHONE_NUMBER n/NAME</code> is also acceptable.
    </p>
  </li>

  <li>
    <p>
      Extraneous parameters for commands that do not take in parameters (such as <code>help</code>, <code>listPerson</code>, <code>deleteAllPerson</code>, <code>listTask</code>, <code>deleteAllTask</code> and <code>exit</code>) will be ignored.<br>
      e.g. if the command specifies <code>help 123</code>, it will be interpreted as <code>help</code>.
    </p>
  </li>
</ul>

" %}

{% include admonition.html type="warning" title="Warning: Using the PDF version of this document" body="

If you are using a PDF version of this document, be careful when copying and pasting commands that span multiple lines as space characters surrounding line-breaks may be omitted when copied over to the application.

" %}

<div style="page-break-after: always;"></div>

### 1. Viewing help: `help`

You can view a link to access the user guide at any time, ensuring that you will never be lost.

<h4>Format:</h4>

```
help
```

<h4>Examples:</h4>

- `help`
  - Opens a window with a link to our user guide. You can copy the URL into a browser, or click on the "Open in browser" button to access the user guide directly. <br><br>

  ![help message](images/output/help_success.png)

<div style="page-break-after: always;"></div>

### 2. Adding a person: `addPerson`

You can add new individuals to your list such as clients, vendors, or friends.

<h4>Format:</h4>

```
addPerson n/NAME p/PHONE_NUMBER e/EMAIL a/ADDRESS [t/TAG]…
```
- Provide the full name of the individual using the `n/` prefix. This field is **mandatory**.
- Provide the phone number with the `p/` prefix. This field is **mandatory**.
- Provide the email address using the `e/` prefix. This field is **mandatory**.
- Provide the address using the `a/` prefix. This field is **mandatory**.
- Tag the person using the `t/` prefix. This field is **optional**.

{% include admonition.html type="note" title="A person can have any number of tags (including 0)." %}

<h4>Examples:</h4>
- `addPerson n/Charlotte Oliveiro p/93210283 e/charlotteo@example.com a/Blk 11 Ang Mo Kio Street 74, #11-04 t/flowers`
  - Adds a person named `Charlotte Oliveiro` with phone number `93210283`, email `charlotteo@example.com`, 
   address `Blk 11 Ang Mo Kio Street 74, #11-04`, and tag `flowers`. <br><br>
  
  ![addPerson success](images/output/addPerson_success.png)

<h4>Errors:</h4>
- `addPerson`

  - Negative example as the name, phone number, email address, and address are not specified. <br><br>
  
  ![addPerson error](images/error/addPerson_error.png)

<div style="page-break-after: always;"></div>

### 3. Listing all persons: `listPerson`

You can view details of all your contacts.

<h4>Format:</h4>

```
listPerson
```

<h4>Examples:</h4>
- `listPerson`
    - Shows a full list of all the contacts in your contact list. <br><br>

  ![listPerson success](images/output/listPerson_success.png)

<div style="page-break-after: always;"></div>

### 4. Editing a person: `editPerson`

Enables you to change the details or particulars of an existing contact in your contact list.

<h4>Format:</h4>

```
editPerson INDEX [n/NAME] [p/PHONE] [e/EMAIL] [a/ADDRESS] [t/TAG]…
```

- Edits the person at the specified `INDEX`. The index refers to the index number shown in the displayed person list. The index **_must be a positive integer_** 1, 2, 3, …
- At least one of the optional fields must be provided.
- Existing values will be updated to the input values.
- When editing tags, the existing tags of the person will be removed i.e adding of tags is not cumulative.
- You can remove all the person’s tags by typing `t/` without specifying any tags after it.

<h4>Examples:</h4>

- `editPerson 1 p/91234567 e/johndoe@example.com` 
  - Edits the phone number and email address of the 1st person to be `91234567` and `johndoe@example.com` respectively.<br><br>
    ![editPerson success](images/output/editPerson_success.png)

- `editPerson 2 n/Betsy Crower t/` 
   - Edits the name of the 2nd person to be `Betsy Crower` and clears all existing tags.<br><br>
     ![editPerson success](images/output/editPerson_success_clearTag.png)

<h4>Errors:</h4>

- `editPerson`
    - Negative example as no index or field is specified.<br><br>
    ![editPerson error](images/error/editPerson_error.png)
- `editPerson 1`
  - Negative example as no fields are specified.<br><br>
    ![editPerson error](images/error/editPerson_missingFields.png)
- `editPerson 10 p/91234567 e/johndoe@example.com`
    - Negative example as invalid index provided.<br><br>
    ![editPerson wrongIndex](images/error/editPerson_wrongIndex.png)

<div style="page-break-after: always;"></div>

### 5. Finding a specific person: `findPerson`

Allows you to quickly find a specific person's details by their name.

{% include admonition.html type="note" title="Note" body="

This command hides all persons that do not match the search criteria. <br>
To reset the Persons view, simply run the <code>listPerson</code> command to list all persons.

" %}

<h4>Format:</h4>

```
findPerson KEYWORD [MORE_KEYWORDS]…
```

- At least one keyword is required to search.
- The search is case-insensitive. e.g `hans` will match `Hans`.
- The order of the keywords does not matter. e.g. `Hans Bo` will match `Bo Hans`.
- Only the **name** is searched.
- Only full words will be matched e.g. `Han` will not match `Hans`.
- Persons matching at least one keyword will be returned (i.e. `OR` search).
  - e.g. `Hans Bo` will match `Hans Gruber`, `Bo Yang`.

<h4>Examples:</h4>

- `findPerson alex yu`
  - Finds all persons whose names contains either `alex` or `yu`.<br><br>
  ![findPerson success with a list](images/output/findPerson_success.png)

- `findPerson David`
  - No results are displayed as no person has a name that contains `David`.<br><br>
  ![findPerson success with zero results](images/output/findPerson_noResults.png)

<h4>Errors:</h4>

- `findPerson`
  - Negative example as no keywords are specified.<br><br>
  ![findPerson error](images/error/findPerson_error.png)

<div style="page-break-after: always;"></div>

### 6. Deleting a person entry: `deletePerson`

{% include admonition.html type="danger" title="Potentially Dangerous Operation!" body="This action is irreversible." %}

Allows you to remove an outdated person from your contact list with ease.

<h4>Format:</h4>

```
deletePerson INDEX
```

- Deletes the person at the specified `INDEX`.
- The index refers to the index number shown in the displayed person list.
- The index **_must be a positive integer_** 1, 2, 3, …

<h4>Examples:</h4>

- `listPerson` followed by `deletePerson 2`
  - Deletes the 2nd person in your contact list.<br><br>
  ![deletePerson_success_with_listPerson](images/output/deletePerson_success.png)

- `findPerson Bernice` followed by `deletePerson 1` 
  - Deletes the 1st person in the results of the `findPerson` command.<br><br>
  ![deletePerson_success_with_findPerson](images/output/deletePerson_success_filteredList.png)

<h4>Errors:</h4>

- `deletePerson`
  - Negative example as no index is specified.<br><br>
  ![deletePerson error_no_index](images/error/deletePerson_error.png)

- `deletePerson 1000`
  - Invalid index is provided.<br><br>
  ![deletePerson error_invalid_index](images/error/deletePerson_wrongIndex.png)

<div style="page-break-after: always;"></div>

### 7. Clearing all person entries: `deleteAllPerson`

Clears all contacts in your contact list.

{% include admonition.html type="danger" title="Potentially Dangerous Operation!" body="
CoordiMate will discard <b>all</b> Person data and start with an empty data file at the next run.<br>" %}

<h4>Format:</h4>

```
deleteAllPerson
```

<h4>Examples:</h4>

- `deleteAllPerson`
  - Deletes all persons in your contact list. <br><br>

  ![deleteAllPerson success](images/output/deleteAllPerson_success.png)

<div style="page-break-after: always;"></div>

### 8. Adding a task: `addTask`

Adds a task to your task list.

<h4>Format:</h4>

```
addTask T/TITLE n/NOTE [t/TAG]...
```

<h4>Examples:</h4>

- `addTask T/Book rooms n/For day 2 t/orientation t/bookings`
  - Adds a task titled `Book rooms` with note `For day 2` and tags `orientation` and `bookings`. <br><br>

  ![addTask_success](images/output/addTask_success1.png)

- `addTask T/Call Caterers n/For 292 people t/orientation`
  - Adds a task titled `Call Caterers` with note `For 292 people` and tag `orientation`. <br><br>

  ![addTask_success](images/output/addTask_success2.png)

<h4>Errors:</h4>

- `addTask T/Book rooms`
  - Negative example as the note is not specified. <br><br>

  ![addTask_error](images/error/addTask_error.png)

<div style="page-break-after: always;"></div>

### 9. Listing all tasks: `listTask`

You can view details of all your tasks.

<h4>Format:</h4>

```
listTask
```

<h4>Examples:</h4>
- `listTask`
    - Displays a complete list of all tasks in your task list. <br><br>

  ![listTask success](images/output/listTask_success.png)

<div style="page-break-after: always;"></div>

### 10. Editing a task: `editTask`

You can edit the details of a task in your task list.

<h4>Format:</h4>

```
editTask INDEX [T/TITLE] [n/NOTE] [t/TAG]...
```

- Edits the task at the specified `INDEX`. The index refers to the index number shown in the task list currently displayed.
- Specify a new title with the `T/` prefix. This field is **optional**.
- Specify a new note with the `n/` prefix. This field is **optional**.
- Specify new tags with the `t/` prefix. This field is **optional**.
- At least one of the optional fields must be provided for the command to be valid.

<h4>Examples:</h4>

- `editTask 1 T/Find Caterer`
  - Edits the title of the 1st task to be `Find Caterer`. <br><br>

  ![editTask_success](images/output/editTask_success1.png)

- `editTask 2 T/Book room n/By Friday t/orientation`
  - Edits the title of the 2nd task to be `Book room`, the note to be `By Friday`, and the tag to be `orientation`. <br><br>

  ![editTask_success](images/output/editTask_success2.png)

<h4>Errors:</h4>

- `editTask`
  - Negative example as the index is not specified. <br><br>

  ![editTask_error](images/error/editTask_error.png)

<div style="page-break-after: always;"></div>

### 11. Finding a specific task: `findTask`

You can quickly locate tasks that contains your specified keywords in their title and/or note.

{% include admonition.html type="note" title="Note" body="

This command hides all Tasks that do not match the search criteria. <br>
To reset the Tasks view, simply run the <code>listTask</code> command to list all Tasks.

" %}

<h4>Format:</h4>

```
findTask KEYWORD [MORE_KEYWORDS]…
```

- At least one keyword is required to search.
- The search is case-insensitive. e.g `find` will match `Find`.
- The order of the keywords does not matter. e.g. `Find Venue` will match `Venue Find`.
- Both the **title and note** of a task are searched.
- Only full words will be matched e.g. `Venue` will not match `Venues`.
- Tasks matching at least one keyword in either the title or the note will be returned (i.e. `OR` search).
  - e.g. `Budget Venue` will match `Find Venue`, `Create Budget`.

<h4>Examples:</h4>

- `findTask Find Finale`
  - Finds tasks with titles or notes containing either `Find` or `Finale`.<br><br>
  ![findTask_success](images/output/findTask_success.png)

- `findTask Photography`
  - No results are displayed as no task has a title or note that contains `Photography`.<br><br>
  ![findTask_noResults](images/output/findTask_noResults.png)

<h4>Errors:</h4>

- `findTask`
  - Negative example as no keywords are specified.<br><br>
  ![findTask_error](images/error/findTask_error.png)

<div style="page-break-after: always;"></div>

### 12. Deleting a task entry: `deleteTask`

{% include admonition.html type="danger" title="Potentially Dangerous Operation!" body="This action is irreversible." %}

Allows you to remove a task from your task list with ease.

<h4>Format:</h4>

`deleteTask INDEX`

- Deletes the task at the specified `INDEX`.
- The index refers to the index number shown in the task list currently displayed.

<h4>Examples:</h4>

- `listTask` followed by `deleteTask 2`
    - Deletes the 2nd task in your task list.<br><br>
      ![deleteTask_success_with_listTask](images/output/deleteTask_success.png)

- `findTask caterer` followed by `deleteTask 1`
    - Deletes the 1st task in the results of the `findTask` command.<br><br>
      ![deleteTask_success_with_findTask](images/output/deleteTask_success_filteredList.png)

<h4>Errors:</h4>

- `deleteTask`
    - Negative example as no index is specified.<br><br>
      ![deleteTask error_no_index](images/error/deleteTask_error.png)

- `deleteTask 1000`
    - Invalid index is provided.<br><br>
      ![deleteTask error_invalid_index](images/error/deleteTask_wrongIndex.png)

<div style="page-break-after: always;"></div>

### 13. Clearing all task entries: `deleteAllTask`

{% include admonition.html type="danger" title="Potentially Dangerous Operation!" body="
CoordiMate will discard <b>all</b> Task data and start with an empty data file at the next run.<br>" %}

Allows you to remove all entries from your task list.

<h4>Format:</h4>

```
deleteAllTask
```

<h4>Examples:</h4>

- `deleteAllTask`
  - Deletes all tasks in your task list. <br><br>
  ![deleteAllTask success](images/output/deleteAllTask_success.png)

<div style="page-break-after: always;"></div>

### 14. Marking a task as done: `markTask`

Allows you to indicate that a specific task as **completed**.

<h4>Format:</h4>

```
markTask INDEX
```

- Marks the task at the specified `INDEX`.
- The index refers to the index number shown in the displayed task list.
- The index **_must be a positive integer_** 1, 2, 3, …

{% include admonition.html type="note" title="Tasks are marked as not done by default." %}

<h4>Examples:</h4>

- `listTask` followed by `markTask 1` 
  - Marks the 1st task in the task list as **done** <br><br>
    ![markTask_success](images/output/markTask_success.png)

- `findTask budget` followed by `markTask 1` 
  - Marks the 1st task in the results of the `findTask` command as **done** <br><br>
    ![markTask_success](images/output/markTask_success_filteredList.png)

<h4>Errors:</h4>
- `markTask`
  - Negative example as no index is given. <br><br>
  ![markTask_error](images/error/markTask_error.png)

- `markTask 10`
  - Negative example as invalid index is given. <br><br>
  ![markTask_wrongIndex](images/error/markTask_wrongIndex.png)

<div style="page-break-after: always;"></div>

### 15. Marking a task as not done: `unmarkTask`

Allows you to indicate that a specific task as **not completed**.

<h4>Format:</h4>

```
unmarkTask INDEX
```

- Marks the task at the specified `INDEX`.
- The index refers to the index number shown in the displayed task list.
- The index **_must be a positive integer_** 1, 2, 3, …

{% include admonition.html type="note" title="Tasks are marked as not done by default." %}

<h4>Examples:</h4>

- `listTask` followed by `unmarkTask 1` 
  - Marks the 1st task in the task list as **not done** <br><br>
    ![unmarkTask_success](images/output/unmarkTask_success.png)

- `findTask budget` followed by `unmarkTask 1` 
  - marks the 1st task in the results of the `findTask` command as **not done** <br><br>
    ![unmarkTask_success](images/output/unmarkTask_success_filteredList.png)

<h4>Errors:</h4>

- `unmarkTask`
  - Negative example as no index is given. <br><br>
  ![unmarkTask_error](images/error/unmarkTask_error.png)

- `unmarkTask 10`
  - Negative example as invalid index is given. <br><br>
  ![markTask_wrongIndex](images/error/unmarkTask_wrongIndex.png)

<div style="page-break-after: always;"></div>

### 16. Finding all tasks that are done: `findDone`

You can filter the task list to find all the completed tasks, allowing you to review your accomplishments or track completed items with ease.

{% include admonition.html type="note" title="Note" body="

This command hides all Tasks that are not done. <br>
To reset the Tasks view, simply run the <code>listTask</code> command to list all Tasks.

" %}

<h4>Format:</h4>

```
findDone
```

<h4>Examples:</h4>

- `findDone`
  - Tasks are displayed as they are marked as done. <br><br>
  ![findDone_success](images/output/findDone_success.png)

- `findDone`
  - There are no tasks to be displayed, as no Task is done. <br><br>
  ![findDone_noResults](images/output/findDone_noResults.png)

<div style="page-break-after: always;"></div>

### 17. Finding all tasks that are not done: `findNotDone`

You can filter the task list to find all the not completed tasks, allowing you to identify pending tasks, helping you focus on what needs to be done and prioritize your workflow effectively

{% include admonition.html type="note" title="Note" body="

This command hides all Tasks that are not done. <br>
To reset the Tasks view, simply run the <code>listTask</code> command to list all Tasks.

" %}

<h4>Format:</h4>

```
findNotDone
```

<h4>Examples:</h4>

- `findNotDone`
  - Tasks are displayed as they are marked as not done. <br><br>
  ![findNotDone_success](images/output/findNotDone_success.png)

- `findNotDone`
  - There are no tasks to be displayed, as no Task is not done. <br><br>
  ![findNotDone_noResults](images/output/findNotDone_noResults.png)

<div style="page-break-after: always;"></div>

### 18. Listing all tags: `listTag`

Provides you with a complete list of tags you have used in your contact list and task list, and the number of times each tag has been used.

The list is sorted by frequency of each tag in descending order.

If two tags have the same frequency, the tags are sorted in ASCII order.

{% include admonition.html type="note" title="About ASCII" body="

The American Standard Code for Information Interchange (ASCII) is a character encoding standard that is well understood by computers. <br>
In ASCII ordering, uppercase letters come before lowercase letters (<code>A</code> comes before <code>a</code>), unlike in alphabetical ordering where case does not matter. <br>
For more information, see <a href='https://en.wikipedia.org/wiki/ASCII' rel='noopener noreferrer' target='_blank'>ASCII</a> on Wikipedia.

" %}

<h4>Format:</h4>

```
listTag
```

<h4>Example:</h4>

- `listTag`
  - Shows you a list of all tags used in your contact list and task list and the number of times each tag has been used.<br><br>
  ![listTag success](images/output/listTag_success.png)

<div style="page-break-after: always;"></div>

### 19. Finding persons and tasks by tag: `findTag`

You can search for persons and tasks using tags.

<h4>Format:</h4>
    
    findTag TAG [MORE_TAGS]...

- Finds the persons and tasks whose tags contain at least one of the specified `TAG`.
- Specify a tag with the `TAG` parameter. This field is **mandatory**.
- Specify more tags to expand your search scope with the `MORE_TAGS` parameter. This field is **optional**.

<h4>Examples:</h4>

- `findTag catering orientation`
    - Shows all persons and tasks with tags containing the words "catering" or "orientation". <br><br>
      
    ![findTag_success_1](images/output/findTag_success1.png)
  
- `findTag orientation`
    - Shows all persons and tasks with tags containing the word "orientation". <br><br>
      
    ![findTag_success_2](images/output/findTag_success2.png)

<h4>Errors:</h4>

- `findTag`
    - An invalid command format. The application expects one or more keywords after `findTag`. <br><br>
      
    ![FindTag Example 2](images/error/findTag_error.png)

<div style="page-break-after: always;"></div>

### 20. Exiting the program: `exit`

Once you are done with your work in CoordiMate, you can exit the program by typing a command.

<h4>Format:</h4>

```
exit
```

Output:

- CoordiMate exits and the program window closes.

<div style="page-break-after: always;"></div>

## FAQ

{% include admonition.html type="question" title="How do I transfer my data to another computer?" body="

Install the app in the other computer and overwrite the empty data file with your previous save file.

" %}

---

<div style="page-break-after: always;"></div>

## Known issues

{% include admonition.html type="bug" title="Bug: The GUI will open off-screen if you switch between multiple screens." body="

Delete the <code>preferences.json</code> file created by CoordiMate before running CoordiMate again.

"%}

---

<div style="page-break-after: always;"></div>

## Command summary

 Action | Format | Example
--------|--------|----------
[**View Help**](#1-viewing-help-help) | `help` | `help`
[**Add Person**](#2-adding-a-person-addperson)|`addPerson n/NAME p/PHONE_NUMBER e/EMAIL a/ADDRESS [t/TAG]…`|`addPerson n/John Doe p/98765432 e/johnd@example.com a/John street, block 123, #01-01`
[**List All Person**](#3-listing-all-persons-listperson) | `listPerson` | `listPerson`
[**Edit Person**](#4-editing-a-person-editperson) | `editPerson INDEX [n/NAME] [p/PHONE] [e/EMAIL] [a/ADDRESS] [t/TAG]…​` | `editPerson 1 p/91234567 e/johndoe@example.com`
[**Find Person**](#5-finding-a-specific-person-findperson) | `findPerson KEYWORD [MORE_KEYWORDS]…` | `findPerson John`
[**Delete Person**](#6-deleting-a-person-entry-deleteperson) | `deletePerson INDEX` | `deletePerson 1`
[**Delete All Person**](#7-clearing-all-person-entries-deleteallperson) | `deleteAllPerson` | `deleteAllPerson`
[**Add Task**](#8-adding-a-task-addtask) | `addTask t/TITLE n/NOTE` | `addTask t/Get Flowers n/Wedding Anniversary`
[**List All Task**](#9-listing-all-tasks-listtask) | `listTask` | `listTask`
[**Edit Task**](#10-editing-a-task-edittask) | `editTask INDEX [t/TITLE] [n/NOTE]` | `editTask 1 t/Call Caterer`
[**Find Task**](#11-finding-a-specific-task-findtask) | `findTask KEYWORD [MORE_KEYWORDS]…` | `findTask Call Wedding`
[**Delete Task**](#12-deleting-a-task-entry-deletetask) | `deleteTask INDEX` | `deleteTask 1`
[**Delete All Task**](#13-clearing-all-task-entries-deletealltask) | `deleteAllTask` | `deleteAllTask`
[**Mark Task**](#14-marking-a-task-as-done-marktask) | `markTask INDEX` | `markTask 1`
[**Unmark Task**](#15-marking-a-task-as-not-done-unmarktask) | `unmarkTask INDEX` | `unmarkTask 1`
[**Find Done Task**](#16-finding-all-tasks-that-are-done-finddone) | `findDone` | `findDone`
[**Find Not Done Task**](#17-finding-all-tasks-that-are-not-done-findnotdone) | `findNotDone` | `findNotDone`
[**List All Tags**](#18-listing-all-tags-listtag) | `listTag` | `listTag`
[**Find Tags**](#19-finding-persons-and-tasks-by-tag-findtag) | `indTag TAG [MORE_TAGS]...` | `findTag orientation`
[**Exit**](#20-exiting-the-program-exit) | `exit` | `exit`
