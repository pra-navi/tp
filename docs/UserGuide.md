---
layout: page
title: User Guide
---

AddressBook Level 3 (AB3) is a **desktop app for managing contacts, optimized for use via a Command Line Interface** (CLI) while still having the benefits of a Graphical User Interface (GUI). If you can type fast, AB3 can get your contact management tasks done faster than traditional GUI apps.

* Table of Contents
{:toc}

--------------------------------------------------------------------------------------------------------------------

## Quick start

1. Ensure you have Java `11` or above installed in your Computer.

1. Download the latest `addressbook.jar` from [here](https://github.com/se-edu/addressbook-level3/releases).

1. Copy the file to the folder you want to use as the _home folder_ for your AddressBook.

1. Open a command terminal, `cd` into the folder you put the jar file in, and use the `java -jar addressbook.jar` command to run the application.<br>
   A GUI similar to the below should appear in a few seconds. Note how the app contains some sample data.<br>
   ![Ui](images/Ui.png)

1. Type the command in the command box and press Enter to execute it. e.g. typing **`help`** and pressing Enter will open the help window.<br>
   Some example commands you can try:

   * `list` : Lists all contacts.

   * `add n/John Doe p/98765432 e/johnd@example.com a/John street, block 123, #01-01` : Adds a contact named `John Doe` to the Address Book.

   * `delete 3` : Deletes the 3rd contact shown in the current list.

   * `clear` : Deletes all contacts.

   * `exit` : Exits the app.

1. Refer to the [Features](#features) below for details of each command.

--------------------------------------------------------------------------------------------------------------------

## Features

<div markdown="block" class="alert alert-info">

**:information_source: Notes about the command format:**<br>

* Words in `UPPER_CASE` are the parameters to be supplied by the user.<br>
  e.g. in `add n/NAME`, `NAME` is a parameter which can be used as `add n/John Doe`.

* Items in square brackets are optional.<br>
  e.g `n/NAME [t/TAG]` can be used as `n/John Doe t/friend` or as `n/John Doe`.

* Items with `…`​ after them can be used multiple times including zero times.<br>
  e.g. `[t/TAG]…​` can be used as ` ` (i.e. 0 times), `t/friend`, `t/friend t/family` etc.

* Parameters can be in any order.<br>
  e.g. if the command specifies `n/NAME p/PHONE_NUMBER`, `p/PHONE_NUMBER n/NAME` is also acceptable.

* Extraneous parameters for commands that do not take in parameters (such as `help`, `list`, `exit` and `clear`) will be ignored.<br>
  e.g. if the command specifies `help 123`, it will be interpreted as `help`.

* If you are using a PDF version of this document, be careful when copying and pasting commands that span multiple lines as space characters surrounding line-breaks may be omitted when copied over to the application.
</div>

### 1. Viewing help: `help`

You can access the help page at any time, ensuring that you will never be lost.

Format:

```
help
```

Examples:

- `help`

Output:

- Opens a window with a link to our user guide.

  ![help message](images/output/help_success.png)

<div style="page-break-after: always;"></div>

### 2. Adding a person: `addPerson`

Add new people that you meet, be it new clients, vendors or friends.

Format:

```
addPerson n/NAME p/PHONE_NUMBER e/EMAIL a/ADDRESS [t/TAG]…
```

{% include admonition.html type="info" title="A person can have any number of tags (including 0)." %}

Examples:

- `addPerson n/John Doe p/98765432 e/johnd@example.com a/John street, block 123, #01-01`
- `addPerson n/Betsy Crowe t/friend e/betsycrowe@example.com a/Newgate Prison p/1234567 t/criminal`

Output:

![addPerson success](images/addPerson_success.png)

Errors:

![addPerson error](images/error/addPerson_error.png)

<div style="page-break-after: always;"></div>


### 3. Listing all persons: `listPerson`

Presents you with a comprehensive list of contacts in your contact list.

Format:

```
listPerson
```

Examples:

- `listPerson`

Output:

![listPerson success](images/listPerson_success.png)

<div style="page-break-after: always;"></div>

### 4. Editing a person: `editPerson`

Enables you to change the details or particulars of an existing contact in your contact list.

Format:

```
editPerson INDEX [n/NAME] [p/PHONE] [e/EMAIL] [a/ADDRESS] [t/TAG]…
```

- Edits the person at the specified `INDEX`. The index refers to the index number shown in the displayed person list. The index **_must be a positive integer_** 1, 2, 3, …
- At least one of the optional fields must be provided.
- Existing values will be updated to the input values.
- When editing tags, the existing tags of the person will be removed i.e adding of tags is not cumulative.
- You can remove all the person’s tags by typing `t/` without specifying any tags after it.

Examples:

- `editPerson 1 p/91234567 e/johndoe@example.com` Edits the phone number and email address of the 1st person to be `91234567` and `johndoe@example.com` respectively.
- `editPerson 2 n/Betsy Crower t/` Edits the name of the 2nd person to be `Betsy Crower` and clears all existing tags.

Output:

![editPerson success](images/editPerson_success.png)

Errors:

- Incorrect parameters or command format
![editPerson error](images/error/editPerson_error.png)

- Incorrect or missing index
![editPerson wrongIndex](images/error/editPerson_wrongIndex.png)

<div style="page-break-after: always;"></div>

### 6. Deleting a person's contact : `deletePerson`

{% include admonition.html type="danger" title="Potentially Dangerous Operation!" body="This action is irreversible." %}

Erase an outdated vendor from your contact list with ease.

Format:

```
deletePerson INDEX
```

- Deletes the person at the specified `INDEX`.
- The index refers to the index number shown in the displayed person list.
- The index **_must be a positive integer_** 1, 2, 3, …

Examples:

- `listPerson` followed by `deletePerson 2` deletes the 2nd person in the contact list.
- `findPerson Betsy` followed by `deletePerson 1` deletes the 1st person in the results of the `findPerson` command.

Output:

![deletePerson success](images/output/deletePerson_success.png)

Errors:

![deletePerson error](images/error/deletePerson_error.png)

<div style="page-break-after: always;"></div>

### 7. Clearing all person entries: `deleteAllPerson`

{% include admonition.html type="danger" title="Potentially Dangerous Operation!" body="
AddressBook will discard <b>all</b> Person data and start with an empty data file at the next run.<br>" %}

Clears all contacts in your contact list.

Format:

```
deleteAllPerson
```

Examples:

- `deleteAllPerson`
  - Deletes all persons in your contact list.

Output:

- All persons in the contact list are deleted.

  ![deleteAllPerson success](images/deleteAllPerson_success.png)

<div style="page-break-after: always;"></div>

### 8. Adding a task: `addTask`

Adds a task to your task list.

Format:

```
addTask t/TITLE n/NOTE
```

Examples:

- `addTask t/Get Flowers n/Wedding Anniversary`
- `addTask t/Call Caterers n/Reunion Dinner`

Output:

![addTask_success](images/output/addTask_success.png)

Errors:

![addTask_error](images/error/addTask_error.png)

<div style="page-break-after: always;"></div>

### 9. Listing all tasks: `listTask`

Provides you with a complete list of tasks in your task list.

Format:

```
listTask
```

Examples:

- `listTask`

Output:

![listTask_success](images/output/listTask_success.png)


<div style="page-break-after: always;"></div>

### 10. Editing a task: `editTask`

You can edit the details of a task in your task list.

Format:

```
editTask INDEX [t/TITLE] [n/NOTE]
```

- Edits the task at the specified `INDEX`.
- The index refers to the index number shown in the task list currently displayed.
- Specify a new title with the `t/` prefix. This field is **optional**.
- Specify a new note with the `n/` prefix. This field is **optional**.

Examples:

- `editTask 1 t/Call Caterer`
  - Edits the title of the 1st task to be `Call Caterer`.
- `editTask 2 t/Book room n/By Friday`
  - Edits the title of the 2nd task to be `Book room` and the note to be `By Friday`.
- `editTask`
  - Negative example as the index is not specified.

Output:

- Title of task 1 is edited to `Call Caterer`.

  ![editTask_success](images/output/editTask_success1.png)

- Title of task 2 is edited to `Book room` and note is edited to `By Friday`.

  ![editTask_success](images/output/editTask_success2.png)

Errors:

- Index is not specified.

  ![editTask_error](images/error/editTask_error.png)

<div style="page-break-after: always;"></div>

### 12. Deleting a task entry: `deleteTask`

{% include admonition.html type="danger" title="Potentially Dangerous Operation!" body="This action is irreversible." %}

You can remove a task from your task list.

Format:

`deleteTask INDEX`

- Deletes the task at the specified `INDEX`.
- The index refers to the index number shown in the task list currently displayed.

Examples:

- `deleteTask 2`
  - Deletes the 2nd task in the task list.
- `findTask Call` followed by `deleteTask 1`
  - Deletes the 1st task in the results of the `findTask` command.

Output:

- Deletes task 2.

  ![deleteTask_success](images/output/deleteTask_success1.png)

Errors:

- Index specified is not available in the task list.

  ![deleteTask_error](images/error/deleteTask_error1.png)

<div style="page-break-after: always;"></div>

### 13. Clearing all task entries: `deleteAllTask`

{% include admonition.html type="danger" title="Potentially Dangerous Operation!" body="
AddressBook will discard <b>all</b> Task data and start with an empty data file at the next run.<br>" %}

Allows you to remove all entries from your task list.

Format:

```
deleteAllTask
```

Examples:

- `deleteAllTask`

Output:

![deleteAllTask success](images/output/deleteAllTask_success.png)

<div style="page-break-after: always;"></div>

### 14. Marking a task as done: `markTask`

Allows you to indicate that a specific task as **completed**.

Format:

```
markTask INDEX
```

- Marks the task at the specified `INDEX`.
- The index refers to the index number shown in the displayed task list.
- The index **_must be a positive integer_** 1, 2, 3, …

{% include admonition.html type="info" title="Tasks are marked as not done by default." %}

Examples:

- `listTask` followed by `markTask 2` marks the 2nd task in the task list as **done**.
- `findTask Call` followed by `markTask 1` marks the 1st task in the results of the `findTask` command as **done**.

Output:

![markTask_success](images/output/markTask_success.png)

Errors:

![markTask_error](images/error/markTask_error.png)

<div style="page-break-after: always;"></div>

### 15. Marking a task as not done: `unmarkTask`

Allows you to indicate that a specific task as **not completed**.

Format:

```
unmarkTask INDEX
```

- Marks the task at the specified `INDEX`.
- The index refers to the index number shown in the displayed task list.
- The index **_must be a positive integer_** 1, 2, 3, …

{% include admonition.html type="info" title="Tasks are marked as not done by default." %}

Examples:

- `listTask` followed by `unmarkTask 2` marks the 2nd task in the task list as **not done**.
- `findTask Call` followed by `unmarkTask 1` marks the 1st task in the results of the `findTask` command as **not done**.

Output:

![unmarkTask_success](images/output/unmarkTask_success.png)

Errors:

![unmarkTask_error](images/error/unmarkTask_error.png)

<div style="page-break-after: always;"></div>

### 15. Exiting the program : `exit`

You can exit the program.

Format: `exit`

<div style="page-break-after: always;"></div>

--------------------------------------------------------------------------------------------------------------------

## FAQ

**Q**: How do I transfer my data to another Computer?<br>
**A**: Install the app in the other computer and overwrite the empty data file it creates with the file that contains the data of your previous AddressBook home folder.

--------------------------------------------------------------------------------------------------------------------

## Known issues

1. **When using multiple screens**, if you move the application to a secondary screen, and later switch to using only the primary screen, the GUI will open off-screen. The remedy is to delete the `preferences.json` file created by the application before running the application again.

--------------------------------------------------------------------------------------------------------------------

## Command summary

Action | Format, Examples
--------|------------------
**Add** | `add n/NAME p/PHONE_NUMBER e/EMAIL a/ADDRESS [t/TAG]…​` <br> e.g., `add n/James Ho p/22224444 e/jamesho@example.com a/123, Clementi Rd, 1234665 t/friend t/colleague`
**Clear** | `clear`
**Delete** | `delete INDEX`<br> e.g., `delete 3`
**Edit** | `edit INDEX [n/NAME] [p/PHONE_NUMBER] [e/EMAIL] [a/ADDRESS] [t/TAG]…​`<br> e.g.,`edit 2 n/James Lee e/jameslee@example.com`
**Find** | `find KEYWORD [MORE_KEYWORDS]`<br> e.g., `find James Jake`
**List** | `list`
**Help** | `help`
