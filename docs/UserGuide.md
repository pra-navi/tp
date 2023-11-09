---
layout: page
title: User Guide
---

Are you a School of Computing (SoC) Computing Club event planner juggling numerous tasks and contacts for your upcoming events?

Managing everything efficiently just got easier with CoordiMate!

CoordiMate is your go-to **desktop app** designed specifically for **SoC Computing Club event planners** to help you **manage your contacts and tasks** for your events, so that you can focus on the event itself.

And here's the best part – while it's perfect for members of SoC Computing Club, **event planners of all kinds** can benefit from CoordiMate's powerful features too!

<h4>Why choose CoordiMate?</h4>

1. **User-Friendly Command Line Interface (CLI)**: CoordiMate is optimized for use via a CLI, combining all the benefits of a Graphical User Interface (GUI) with the efficiency of a CLI.

2. **Speedy Navigation**: If you're a fast typist, CoordiMate will help you complete your contact and tasks management faster than traditional GUI apps, maximising your productivity.

Don't let the stress of contact and task management hinder your event planning creativity.

Let **CoordiMate** take care of the details, while you craft extraordinary events with confidence.

## Using This Guide

This document will guide you on the various features of CoordiMate and how to use them.

If you are a new user, we recommend that you read this guide starting from the [Quick Start](#quick-start) section.

If you are an experienced user, you can use the [Table of Contents](#table-of-contents) below to quickly locate the relevant section. Alternatively, you can jump to the [Command Summary](#command-summary) section for an overview of the command syntax.

Here are some annotations used in this guide:

{% include admonition.html type="danger" title="Danger" body="

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

---

<div style="page-break-after: always;"></div>

## Table of Contents

- Table of Contents
{:toc}

---

<div style="page-break-after: always;"></div>

## Quick Start

[Back to Table of Contents](#table-of-contents)

1. Ensure you have Java `11` or above installed in your computer.

2. Download the latest `CoordiMate.jar` from [here](https://github.com/AY2324S1-CS2103T-T10-2/tp/releases).

3. Copy `CoordiMate.jar` to the folder you want to use as the _home folder_ for CoordiMate. This folder will be used by CoordiMate to store its data.

4. Open a command terminal, `cd` into the folder you put `CoordiMate.jar` in, and use the `java -jar CoordiMate.jar` command to start CoordiMate.<br>

   A GUI similar to the below screenshot should appear in a few seconds. Note how the app contains some sample data.<br><br>
   ![Ui](images/Ui.png)

5. Type the command in the command box and press Enter to execute it. e.g. typing `help` and pressing Enter will open the help window.<br><br>

   Some example commands you can try:

   - `listPerson` : Lists all persons.

   - `addPerson n/John Doe p/98765432 e/johnd@example.com a/John street, block 123, #01-01` : Adds a new contact named `John Doe` with the specified details.

   - `deletePerson 3` : Deletes the 3rd contact shown in the current contact list.

   - `findTask caterer` : Finds all tasks with the word `caterer` in their title or note.

   - `listTask` : Lists all tasks.

   - `addTask T/Get Flowers n/for Finale Night` : Adds a task titled `Get Flowers` with note `for Finale Night` to the task list.

   - `markTask 1` : Marks the 1st task shown in the current task list as done.

   - `exit` : Exits the app.

6. Refer to the [Usage](#usage) section below for details of each command.

---

<div style="page-break-after: always;"></div>

## Features

[Back to Table of Contents](#table-of-contents)

1. **Easy Management of People**:

- Seamlessly create, update, and delete your contacts, ensuring your contact list is always up-to-date.

2. **Effortless Task Management**:

- CoordiMate records down your tasks and their completion status, allowing you to stay on top of your to-do list.

3. **Simplified Searching**:

- Easily locate contacts or tasks based on your criteria. No more scrolling through endless lists!

4. **Hassle-Free Data Management**:

- CoordiMate automatically saves your data on every change, so you never have to worry about losing your data.
- When CoordiMate starts, your existing data is automatically loaded, allowing you to pick up where you left off.
- For advanced users, CoordiMate offers complete data control by saving your data in a human-readable format. Locate the data file at `[JAR file location]/data/addressbook.json` to edit CoordiMate's data directly!

{% include admonition.html type="danger" title="Danger" body="

If your changes to the data file makes its format invalid, CoordiMate will not be able to load the data file, resulting in the contact and task lists being empty. <br>

Always make a backup before you edit!

" %}

---

<div style="page-break-after: always;"></div>

## Usage

[Back to Table of Contents](#table-of-contents)

{% include admonition.html type="note" title="Note" body="

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

{% include admonition.html type="warning" title="Warning" body="

If you are using a PDF version of this document, be careful when copying and pasting commands that span multiple lines as space characters surrounding line-breaks may be omitted when copied over to the application.

" %}

<div style="page-break-after: always;"></div>

### Command Aliases

[Back to Table of Contents](#table-of-contents)

CoordiMate supports predefined aliases for commands, so that you can get things done faster!<br>

**Example 1: Adding a person**

Instead of typing:

<div class="highlight">
  <pre class="highlight"><code><b>addPerson</b> n/John Doe p/12345678 e/john@example.com a/1 John Street t/friend</code></pre>
</div>

you can simply type:

<div class="highlight">
  <pre class="highlight"><code><b>ap</b> n/John Doe p/12345678 e/john@example.com a/1 John Street t/friend</code></pre>
</div>

Both commands will add a person named `John Doe` with phone number `12345678`, email `john@example.com`, address `1 John Street`, and tag `friend` to your contact list.<br><br>

<br>

**Example 2: Listing all persons**

Instead of typing:

<div class="highlight">
  <pre class="highlight"><code><b>listPerson</b></code></pre>
</div>

you can simply type:

<div class="highlight">
  <pre class="highlight"><code><b>lp</b></code></pre>
</div>

Both commands will show a full list of all the contacts in your contact list.

<br>

A summary of valid aliases is shown in the [Command Summary](#command-summary) section below.

---

<div style="page-break-after: always;"></div>

### Understanding Our UI

[Back to Table of Contents](#table-of-contents)

![Ui](images/Ui_explanation.png)

1. Menu Bar: Access to features File and Help
2. Command Line: Type your commands here. 
3. Command Result: View command results or error messages through here. 
4. Contact List: View and manage contacts here. 
5. Task List: View and organize tasks here. 
6. Data Storage: This is where user data is saved.


---

<div style="page-break-after: always;"></div>

### 1. Commands to Manage Persons

#### 1.1. Adding a person: `addPerson`

[Back to Table of Contents](#table-of-contents)

You can add new individuals to your list such as clients, vendors, or friends.

<h4>Format:</h4>

```
addPerson n/NAME p/PHONE_NUMBER e/EMAIL a/ADDRESS [t/TAG]…
```

<h4>Alias:</h4>

```
ap
```

- Provide the full name of the individual using the `n/` prefix. This field is **mandatory**.
- Provide the phone number with the `p/` prefix. This field is **mandatory**.
- Provide the email address using the `e/` prefix. This field is **mandatory**.
- Provide the address using the `a/` prefix. This field is **mandatory**.
- Tag the person using the `t/` prefix. This field is **optional**.
- You may add multiple tags to a task by specifying the `t/` prefix multiple times.
- A person is identified by their name. This means that you cannot have two persons with the same name.

{% include admonition.html type="note" title="Note" body="

A person can have any number of tags (including 0).

" %}

<h4>Example:</h4>
- `addPerson n/Charlotte Oliveiro p/93210283 e/charlotteo@example.com a/Blk 11 Ang Mo Kio Street 74, #11-04 t/flowers`
  - Adds a person named `Charlotte Oliveiro` with phone number `93210283`, email `charlotteo@example.com`,
   address `Blk 11 Ang Mo Kio Street 74, #11-04`, and tag `flowers`.<br><br>

  ![addPerson success](images/output/addPerson_success.png)

<h4>Potential Errors:</h4>

 Error message | How to resolve
---------------|---------------
`Invalid command format!...` | Ensure that the name, phone number, email address and address are specified.
`Names should only contain alphanumeric characters and spaces, and it should not be blank` | Ensure that the name specified is not blank and contain only alphanumeric characters. Whitespaces at the start and end are trimmed.
`Phone numbers should only contain numbers, and it should be at least 3 digits long` | Ensure that the phone number specified is not blank, contain only numbers and at least 3 digits long. Whitespaces at the start and end are trimmed.
`Addresses can take any values, and it should not be blank` | Ensure that the address specified is not blank. Whitespaces at the start and end are trimmed.
`Emails should be of the format local-part@domain and adhere to the following constraints: ...` | Ensure that the email specified is not blank and adheres to the constraints specified. Whitespaces at the start and end are trimmed.
`This person already exists in the address book.` | Ensure that the new name specified do not match an existing person.
`Multiple values specified for the following single-valued field(s): n/ e/ a/ p/` | Ensure that duplicate tags for name, email, address and phone number are removed.

<div style="page-break-after: always;"></div>

#### 1.2. Listing all persons: `listPerson`

[Back to Table of Contents](#table-of-contents)

You can view details of all your contacts.

<h4>Format:</h4>

```
listPerson
```

<h4>Alias:</h4>

```
lp
```

<h4>Example:</h4>
- `listPerson`
    - Shows a full list of all the contacts in your contact list.<br><br>

  ![listPerson success](images/output/listPerson_success.png)

<div style="page-break-after: always;"></div>

#### 1.3. Editing a person: `editPerson`

[Back to Table of Contents](#table-of-contents)

Enables you to change the details or particulars of an existing contact in your contact list.

<h4>Format:</h4>

```
editPerson INDEX [n/NAME] [p/PHONE] [e/EMAIL] [a/ADDRESS] [t/TAG]…
```

<h4>Alias:</h4>

```
ep
```

- Edits the person at the specified `INDEX`. The index refers to the index number shown in the displayed person list. This field is **mandatory**.
  - The index **_must be a positive integer_** 1, 2, 3, … , 2147483647.
- Existing values will be updated to the input values.
- Specify a new name with the `n/` prefix. This field is **optional**.
- Specify a new phone number with the `p/` prefix. This field is **optional**.
- Specify a new email with the `e/` prefix. This field is **optional**.
- Specify a new address with the `a/` prefix. This field is **optional**.
- Specify new tags with the `t/` prefix. This field is **optional**.
  - You may add multiple tags to a person by specifying the `t/` prefix multiple times.
  - Note that this will replace all existing tags of the task. If you wish to add to the existing tags of the task, use the [`addTagPerson` command](#31-adding-tags-to-a-person-addtagperson) instead.
  - Specifying `t/` without any tags will clear all existing tags of the task.
- At least one of the optional fields must be provided for the command to be valid.

<h4>Example:</h4>

- `editPerson 1 p/91234567 e/johndoe@example.com`
  - Edits the phone number and email address of the 1st person to be `91234567` and `johndoe@example.com` respectively.<br><br>

  ![editPerson success](images/output/editPerson_success.png)<br><br>

<h4>Potential Errors:</h4>

 Error message | How to resolve
---------------|---------------
`Invalid command format!...` | Ensure that the index is correctly specified as an integer.
`At least one field to edit must be provided.` | Ensure that at least one of name, phone, email, address or tag is specified.
`The person index provided is invalid` | Ensure that the index provided is within the valid range.
`Names should only contain alphanumeric characters and spaces, and it should not be blank` | Ensure that the name specified is not blank and contain only alphanumeric characters. Whitespaces at the start and end are trimmed.
`Phone numbers should only contain numbers, and it should be at least 3 digits long` | Ensure that the phone number specified is not blank, contain only numbers and at least 3 digits long. Whitespaces at the start and end are trimmed.
`Addresses can take any values, and it should not be blank` | Ensure that the address specified is not blank. Whitespaces at the start and end are trimmed.
`Emails should be of the format local-part@domain and adhere to the following constraints: ...` | Ensure that the email specified is not blank and adheres to the constraints specified. Whitespaces at the start and end are trimmed.
`This person already exists in the address book.` | Ensure that the new name specified do not match an existing person.

<div style="page-break-after: always;"></div>

#### 1.4. Finding a specific person: `findPerson`

[Back to Table of Contents](#table-of-contents)

Allows you to quickly find a specific person's details by their name.

{% include admonition.html type="note" title="Note" body="

This command hides all persons that do not match the search criteria. <br>
(i.e. If no persons match the search criteria, the list will be empty.)<br><br>
To reset the persons view, simply run the <code>listPerson</code> command to list all persons.

" %}

<h4>Format:</h4>

```
findPerson KEYWORD [MORE_KEYWORDS]…
```

<h4>Alias:</h4>

```
fp
```

- At least one keyword is required to search.
- The search is case-insensitive. e.g `hans` will match `Hans`.
- The order of the keywords does not matter. e.g. `Hans Bo` will match `Bo Hans`.
- Only the **name** is searched.
- Only full words will be matched e.g. `Han` will not match `Hans`.
- Persons matching at least one keyword will be returned (i.e. `OR` search).
  - e.g. `Hans Bo` will match `Hans Gruber`, `Bo Yang`.

<h4>Example:</h4>

- `findPerson alex yu`
  - Finds all persons whose names contains either `alex` or `yu`.<br><br>

  ![findPerson success with a list](images/output/findPerson_success.png)<br><br>

<h4>Potential Error:</h4>

 Error message | How to resolve
---------------|---------------
`Invalid command format!...` | Ensure that a keyword is provided.

<div style="page-break-after: always;"></div>

#### 1.5. Deleting a person entry: `deletePerson`

[Back to Table of Contents](#table-of-contents)

Allows you to remove an outdated person from your contact list with ease.

{% include admonition.html type="danger" title="Danger" body="

The person will be removed from your contact list <b>immediately</b>. This action is <b>irreversible</b>.

" %}

{% include admonition.html type="note" title="Note" body="

This command is used after the list is defined either as a filtered list through `findPerson bernice` or through `listPerson`.<br><br>
Then, the index of the person in the defined list is used to delete the person.<br><br>

" %}

<h4>Format:</h4>

```
deletePerson INDEX
```

<h4>Alias:</h4>

```
dp
```

- Deletes the person at the specified `INDEX`.
- The index refers to the index number shown in the displayed person list.
- The index **_must be a positive integer_** 1, 2, 3, … , 2147483647.

<h4>Example:</h4>

- `listPerson` followed by `deletePerson 2`
  - Deletes the 2nd person in the results of the `listPerson` command.
  - Example output for correct usage of `deletePerson` command: <br><br>
  ![deletePerson_success_with_listPerson](images/output/deletePerson_success.png)

<h4>Potential Errors:</h4>

 Error message | How to resolve
---------------|---------------
`Invalid command format!...` | Ensure that the index is correctly specified as an integer.
`The person index provided is invalid` | Ensure that the index provided is within the valid range.

<div style="page-break-after: always;"></div>

#### 1.6. Clearing all person entries: `deleteAllPerson`

[Back to Table of Contents](#table-of-contents)

Clears **all** contacts in your contact list.

{% include admonition.html type="danger" title="Danger" body="

<b>All</b> persons will be removed from your contact list <b>immediately</b>. This action is <b>irreversible</b>.

" %}

<h4>Format:</h4>

```
deleteAllPerson
```

<h4>Alias:</h4>

```
dap
```

<h4>Example:</h4>

- `deleteAllPerson`
  - Deletes all persons in your contact list.<br><br>

  ![deleteAllPerson success](images/output/deleteAllPerson_success.png)

---

<div style="page-break-after: always;"></div>

### 2. Commands to Manage Tasks

#### 2.1. Adding a task: `addTask`

[Back to Table of Contents](#table-of-contents)

Adds a task to your task list.

<h4>Format:</h4>

```
addTask T/TITLE n/NOTE [t/TAG]...
```

<h4>Alias:</h4>

```
at
```

- Provide the title of the task using the `T/` prefix. This field is **mandatory**.
- Provide the note of the task using the `n/` prefix. This field is **mandatory**.
- Tag the task using the `t/` prefix. This field is **optional**.
- You may add multiple tags to a task by specifying the `t/` prefix multiple times.
- A task is identified by the combination of its title and note. This means that you cannot have two tasks with the same title and note.

<h4></h4>

<h4>Example:</h4>

- `addTask T/Book rooms n/For day 2 t/orientation t/bookings`
  - Adds a task titled `Book rooms` with note `For day 2` and tags `orientation` and `bookings`.<br><br>

  ![addTask_success](images/output/addTask_success.png)<br><br>

<h4>Potential Errors:</h4>

 Error message | How to resolve
---------------|---------------
`Invalid command format!...` | Ensure that the title and note are specified.
`Titles/Notes can take any value, as long as it is not blank and does not start with a whitespace` | Ensure that the title and note specified are not blank. Whitespaces at the start and end are trimmed.

<div style="page-break-after: always;"></div>

#### 2.2. Listing all tasks: `listTask`

[Back to Table of Contents](#table-of-contents)

You can view details of all your tasks.

<h4>Format:</h4>

```
listTask
```

<h4>Alias:</h4>

```
lt
```

<h4>Example:</h4>
- `listTask`
    - Displays a complete list of all tasks in your task list.<br><br>

  ![listTask success](images/output/listTask_success.png)

<div style="page-break-after: always;"></div>

#### 2.3. Editing a task: `editTask`

[Back to Table of Contents](#table-of-contents)

You can edit the details of a task in your task list.

<h4>Format:</h4>

```
editTask INDEX [T/TITLE] [n/NOTE] [t/TAG]...
```

<h4>Alias:</h4>

```
et
```

- Edits the task at the specified `INDEX`. The index refers to the index number shown in the task list currently displayed. This field is **mandatory**.
  - The index **_must be a positive integer_** 1, 2, 3, … , 2147483647.
- Existing values will be updated to the input values.
- Specify a new title with the `T/` prefix. This field is **optional**.
- Specify a new note with the `n/` prefix. This field is **optional**.
- Specify new tags with the `t/` prefix. This field is **optional**.
  - You may add multiple tags to a task by specifying the `t/` prefix multiple times.
  - Note that this will replace all existing tags of the task. If you wish to add to the existing tags of the task, use the [`addTagTask` command](#32-adding-tags-to-a-task-addtagtask) instead.
  - Specifying `t/` without any tags will clear all existing tags of the task.
- At least one of the optional fields must be provided for the command to be valid.

<h4>Example:</h4>

- `editTask 2 T/Book room n/By Friday t/orientation`
  - Edits the title of the 2nd task to be `Book room`, the note to be `By Friday`, and the tag to be `orientation`.<br><br>

  ![editTask_success](images/output/editTask_success.png)

<h4>Potential Errors:</h4>

 Error message | How to resolve
---------------|---------------
`Invalid command format!...` | Ensure that the index is correctly specified as an integer.
`At least one field to edit must be provided.` | Ensure that at least one of title, note, or tag is specified.
`Titles/Notes can take any value, as long as it is not blank and does not start with a whitespace` | Ensure that the title and/or note specified are not blank. Whitespaces at the start and end are trimmed.
`This task already exists in the address book.` | Ensure that the new title and note specified do not match an existing task.

<div style="page-break-after: always;"></div>

#### 2.4. Finding a specific task: `findTask`

[Back to Table of Contents](#table-of-contents)

You can quickly locate tasks that contains your specified keywords in their title and/or note.

{% include admonition.html type="note" title="Note" body="

This command hides all tasks that do not match the search criteria. <br>
(i.e. If no tasks match the search criteria, the list will be empty.)<br><br>
To reset the tasks view, simply run the <code>listTask</code> command to list all tasks.

" %}

<h4>Format:</h4>

```
findTask KEYWORD [MORE_KEYWORDS]…
```

<h4>Alias:</h4>

```
ft
```

- At least one keyword is required to search.
- The search is case-insensitive. e.g `find` will match `Find`.
- The order of the keywords does not matter. e.g. `Find Venue` will match `Venue Find`.
- Both the **title and note** of a task are searched.
- Only full words will be matched e.g. `Venue` will not match `Venues`.
- Tasks matching at least one keyword in either the title or the note will be returned (i.e. `OR` search).
  - e.g. `Budget Venue` will match `Find Venue`, `Create Budget`.

<h4>Example:</h4>

- `findTask Find Finale`
  - Finds tasks with titles or notes containing either `Find` or `Finale`.<br><br>

  ![findTask_success](images/output/findTask_success.png)<br><br>

<h4>Potential Error:</h4>

 Error message | How to resolve
---------------|---------------
`Invalid command format!...` | Ensure that a keyword is provided.

<div style="page-break-after: always;"></div>

#### 2.5 Deleting a task entry: `deleteTask`

[Back to Table of Contents](#table-of-contents)

Allows you to remove a task from your task list with ease.

{% include admonition.html type="danger" title="Danger" body="

The task will be removed from your task list <b>immediately</b>. This action is <b>irreversible</b>.

" %}

{% include admonition.html type="note" title="Note" body="

This command is used after the list is defined either as a filtered list through `findTask caterer` or through `listTask`.<br><br>
Then, the index of the task in the defined list is used to delete the task.<br><br>

" %}

<h4>Format:</h4>

```
deleteTask INDEX
```

<h4>Alias:</h4>

```
dt
```

- Deletes the task at the specified `INDEX`.
- The index refers to the index number shown in the task list currently displayed.
- The index **_must be a positive integer_** 1, 2, 3, … , 2147483647.

<h4>Example:</h4>

- `listTask` followed by `deleteTask 2`
  - Deletes the 2nd task in the results of the `listTask` command.
  - Example output for correct usage of `deleteTask` command: <br><br>

  ![deleteTask_success](images/output/deleteTask_success.png)

<h4>Potential Errors:</h4>

 Error message | How to resolve
---------------|---------------
`Invalid command format!...` | Ensure that the index is correctly specified as an integer.
`The task index provided is invalid` | Ensure that the index provided is within the valid range.

- `deleteTask`
  - Negative example as no index is specified.<br><br>

  ![deleteTask error_no_index](images/error/deleteTask_error.png)<br><br>

- `deleteTask 1000`
  - Invalid index is provided.<br><br>

  ![deleteTask error_invalid_index](images/error/deleteTask_wrongIndex.png)

<div style="page-break-after: always;"></div>

#### 2.6. Clearing all task entries: `deleteAllTask`

[Back to Table of Contents](#table-of-contents)

Allows you to remove **all** entries from your task list.

{% include admonition.html type="danger" title="Danger" body="

<b>All</b> tasks will be removed from your task list <b>immediately</b>. This action is <b>irreversible</b>.

" %}

<h4>Format:</h4>

```
deleteAllTask
```

<h4>Alias:</h4>

```
dat
```

<h4>Example:</h4>

- `deleteAllTask`
  - Deletes all tasks in your task list.<br><br>

  ![deleteAllTask success](images/output/deleteAllTask_success.png)

<div style="page-break-after: always;"></div>

#### 2.7. Marking a task as done: `markTask`

[Back to Table of Contents](#table-of-contents)

You can indicate that a specific task as **completed**, updating that the task has been successfully completed or resolved.

<h4>Format:</h4>

```
markTask INDEX
```

<h4>Alias:</h4>

```
mt
```

- Marks the task at the specified `INDEX` as done. The index refers to the index number shown in the displayed person list. This field is **mandatory**.
- The index **_must be a positive integer_** 1, 2, 3, … , 2147483647.

{% include admonition.html type="note" title="Note" body="

Tasks are marked as not done by default.

" %}

<h4>Example:</h4>

- `listTask` followed by `markTask 1`
  - Marks the 1st task in the task list as **done**<br><br>

  ![markTask_success](images/output/markTask_success.png)<br><br>

<h4>Potential Errors:</h4>

 Error message | How to resolve
---------------|---------------
`Invalid command format!...` | Ensure that the index is correctly specified as an integer.
`The task index provided is invalid` | Ensure that the index provided is within the valid range.
`This task is already marked as done in the task list.` | Ensure that the task specified for marking is not already done in the task list.

<div style="page-break-after: always;"></div>

#### 2.8. Marking a task as not done: `unmarkTask`

[Back to Table of Contents](#table-of-contents)

You can indicate that a specific task as **not completed**, updating that the task remains open and pending further action or completion.

<h4>Format:</h4>

```
unmarkTask INDEX
```

<h4>Alias:</h4>

```
ut
```

- Marks the task at the specified `INDEX` as not done. The index refers to the index number shown in the displayed person list. This field is **mandatory**.
- The index **_must be a positive integer_** 1, 2, 3, … , 2147483647.

{% include admonition.html type="note" title="Note" body="

Tasks are marked as not done by default.

" %}

<h4>Example:</h4>

- `listTask` followed by `unmarkTask 1`
  - Marks the 1st task in the task list as **not done**<br><br>

  ![unmarkTask_success](images/output/unmarkTask_success.png)<br><br>

<h4>Potential Errors:</h4>

 Error message | How to resolve
---------------|---------------
`Invalid command format!...` | Ensure that the index is correctly specified as an integer.
`The task index provided is invalid` | Ensure that the index provided is within the valid range.
`This task is already marked as not done in the task list.` | Ensure that the specified task is not already marked as not done in the task list.

<div style="page-break-after: always;"></div>

#### 2.9. Finding all tasks that are done: `findDone`

[Back to Table of Contents](#table-of-contents)

You can filter the task list to find all the completed tasks, allowing you to review your accomplishments or track completed items with ease.

{% include admonition.html type="note" title="Note" body="

This command hides all Tasks that are not done. <br>
(i.e. If no Tasks are done, the list will be empty.)<br><br>
To reset the Tasks view, simply run the <code>listTask</code> command to list all Tasks.

" %}

<h4>Format:</h4>

```
findDone
```

<h4>Alias:</h4>

```
fd
```

<h4>Example:</h4>

- `findDone`
  - Tasks are displayed as they are marked as done.<br><br>

  ![findDone_success](images/output/findDone_success.png)<br><br>

<div style="page-break-after: always;"></div>

#### 2.10. Finding all tasks that are not done: `findNotDone`

[Back to Table of Contents](#table-of-contents)

You can filter the task list to find all the not completed tasks, allowing you to identify pending tasks, helping you focus on what needs to be done and prioritize your workflow effectively.

{% include admonition.html type="note" title="Note" body="

This command hides all Tasks that are done. <br>
(i.e. If no Tasks are not done, the list will be empty.)<br><br>
To reset the Tasks view, simply run the <code>listTask</code> command to list all Tasks.

" %}

<h4>Format:</h4>

```
findNotDone
```

<h4>Alias:</h4>

```
fnd
```

<h4>Example:</h4>

- `findNotDone`
  - Tasks are displayed as they are marked as not done.<br><br>

  ![findNotDone_success](images/output/findNotDone_success.png)<br><br>

<div style="page-break-after: always;"></div>

#### 2.11. Deleting all tasks that are done: `deleteAllDone`

[Back to Table of Contents](#table-of-contents)

You can easily clean up your task list by deleting all completed tasks, allowing you maintain an organized and clutter-free task management system.

{% include admonition.html type="danger" title="Danger" body="

<b>All</b> completed tasks will be removed from your task list <b>immediately</b>. This action is <b>irreversible</b>.

" %}

<h4>Format:</h4>

```
deleteAllDone
```

<h4>Alias:</h4>

```
dad
```

- After completing the deletion of completed tasks, the task list will automatically revert back to displaying all tasks, ensuring you have a comprehensive overview of your remaining to-dos.

<h4>Example:</h4>

- `deleteAllDone`
  - All tasks that are marked as done are deleted.<br><br>

  ![deleteAllDone_success](images/output/deleteAllDone_success.png)<br><br>

<h4>Potential Error:</h4>

 Error message | How to resolve
---------------|---------------
`No Done tasks found in task list` | Ensure that there are tasks marked as done in your task list with [`findDone` command](#29-finding-all-tasks-that-are-done-finddone).

---

<div style="page-break-after: always;"></div>

### 3. Commands to Manage Tags

#### 3.1. Adding tag(s) to a person: `addTagPerson`

[Back to Table of Contents](#table-of-contents)

Enables you to add tag(s) to the existing list of tags of an existing contact in your contact list.

<h4>Format:</h4>

```
addTagPerson INDEX [t/TAG]…
```

<h4>Alias:</h4>

```
atagp
```

- Edits the person at the specified `INDEX`. The index refers to the index number shown in the displayed task list. The
  index **_must be a positive integer_** 1, 2, 3, … , 2147483647.
- At least one tag must be provided.
- Existing list of tags will be updated after adding in the input tags.
- Tags are uniquely identified so `finance` and `Finance` are considered two different tags.

<h4>Example:</h4>

- `addTagPerson 1 t/friends t/expensive`
  - Adds the tag `expensive` to the list of existing tags of the 1st person, while `friends` is mentioned in the output to have already been included in the list of existing tags.
  - Example output for correct usage of `addTagPerson` command: <br><br>

  ![addTagPerson success](images/output/addTagPerson_success.png)

<h4>Potential Errors:</h4>

 Error message | How to resolve
---------------|---------------
`Invalid command format!...` | Ensure that the index AND tag are both specified. The index should be correctly specfiied as an integer.
`Tags names should be alphanumeric` | Ensure that the tag is specified and is alphanumeric.
`The person index provided is invalid` | Ensure that the index provided is within the valid range.

<div style="page-break-after: always;"></div>

#### 3.2. Adding tag(s) to a task: `addTagTask`

[Back to Table of Contents](#table-of-contents)

Enables you to add tag(s) to the existing list of tags of an existing task in your task list.

<h4>Format:</h4>

```
addTagTask INDEX [t/TAG]…
```

<h4>Alias:</h4>

```
atagt
```

- Edits the task at the specified `INDEX`. The index refers to the index number shown in the displayed task list. The index **_must be a positive integer_** 1, 2, 3, … , 2147483647.
- At least one tag must be provided.
- Existing list of tags will be updated after adding in the input tags.
- Tags are uniquely identified so `finance` and `Finance` are considered two different tags.

<h4>Example:</h4>

- `addTagTask 1 t/day1 t/day2`
  - Adds the tag `day2` to the list of existing tags of the 1st task, while `day1` is mentioned in the output to have already been included in the list of existing tags.
  - Example output for correct usage of `addTagTask` command: <br><br>

  ![addTagTask success](images/output/addTagTask_success.png)

<h4>Potential Errors:</h4>

 Error message | How to resolve
---------------|---------------
`Invalid command format!...` | Ensure that the index AND tag are both specified. The index should be correctly specified as an integer.
`Tags names should be alphanumeric` | Ensure that the tag is specified and is alphanumeric.
`The task index provided is invalid` | Ensure that the index provided is within the valid range.

<div style="page-break-after: always;"></div>

#### 3.3. Listing all tags: `listTag`

[Back to Table of Contents](#table-of-contents)

Provides you with a complete list of tags you have used in your contact list and task list, and the number of times each tag has been used.

The list is sorted by frequency of each tag in descending order.

If two tags have the same frequency, the tags are sorted in the order as defined in the American Standard Code for Information Interchange (ASCII).

{% include admonition.html type="note" title="Note" body="

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

#### 3.4. Finding persons and tasks with any matching tag(s): `findTag`

[Back to Table of Contents](#table-of-contents)

You can expand your search with this command when you aim to locate any person and task that corresponds with at least one of the keywords you provide.

{% include admonition.html type="note" title="Note" body="

This command hides all persons and tasks that do not match the search criteria. <br>
(i.e. If no persons or tasks match the search criteria, the list will be empty.)<br><br>
To reset the Persons and Tasks view, simply run the <code>listAll</code> command to list all persons and tasks.

" %}

<h4>Format:</h4>

```
findTag KEYWORD [MORE_KEYWORDS]...
```

<h4>Alias:</h4>

```
ftag
```

- At least one keyword is required to search.
- The search is case-sensitive, e.g. `findTag orientation` will match persons and tasks which tag(s) must contain `orientation`.
- Only full words will be matched, e.g. `findTag catering` will not match persons and tasks which tag(s) contain only `foodcatering`.
- Specify a tag with the `KEYWORD` parameter. This field is **mandatory**.
- Specify more tag(s) to refine your search scope with the `MORE_KEYWORDS` parameter. This field is **optional**.
- Persons and tasks matching **at least one** keyword in their tag(s) will be returned (i.e. OR search).
  - e.g. `findTag catering orientation` will match all persons and tasks which tags contain `catering`, `orientation` or both.

<h4>Example:</h4>

- `findTag catering orientation`
  - Shows all persons and tasks containing any of the tags `catering` or `orientation`.<br><br>

  ![findTag_success_1](images/output/findTag_success1.png)

<h4>Potential Error:</h4>

 Error message | How to resolve
---------------|---------------
`Invalid command format!...` | Ensure that a keyword is provided.

<div style="page-break-after: always;"></div>

#### 3.5. Finding persons and tasks with all matching tag(s): `findAllTag`

[Back to Table of Contents](#table-of-contents)

You can narrow your search with this command when you want to find only those persons and tasks that include every keyword you list.

{% include admonition.html type="note" title="Note" body="

This command hides all persons and tasks that do not match the search criteria. <br>
(i.e. If no persons or tasks match the search criteria, the list will be empty.)<br><br>
To reset the Persons and Tasks view, simply run the <code>listAll</code> command to list all persons and tasks.

" %}

<h4>Format:</h4>

```
findAllTag KEYWORD [MORE_KEYWORDS]...
```

<h4>Alias:</h4>

```
mt
```

- At least one keyword is required to search.
- The search is case-sensitive, e.g. `findAllTag orientation` will match persons and tasks which tag(s) must contain `orientation`.
- Only full words will be matched, e.g. `findAllTag catering` will not match persons and tasks which tag(s) contain only `foodcatering`.
- Finds the persons and tasks whose tags completely match all of the specified `KEYWORD`(s).
- Specify a tag with the `KEYWORD` parameter. This field is **mandatory**.
- Specify more tags to refine your search scope with the `MORE_KEYWORDS` parameter. This field is **optional**.
- Persons and tasks matching **all** keyword(s) in their tag(s) will be returned (i.e. AND search).
  - e.g. `findAllTag catering orientation` will match all persons and tasks which contain both `catering` and `orientation` tags.

<h4>Example:</h4>

- `findAllTag catering orientation`
  - Shows all persons and tasks containing both the tags `catering` and `orientation`.<br><br>

  ![findAllTag_success_2](images/output/findAllTag_success2.png)

<h4>Potential Error:</h4>

 Error message | How to resolve
---------------|---------------
`Invalid command format!...` | Ensure that a keyword is provided.

<div style="page-break-after: always;"></div>

#### 3.6. Deleting tag(s) from a person: `deleteTagPerson`

[Back to Table of Contents](#table-of-contents)

You can remove tag(s) from a person in your contact list.

<h4>Format:</h4>

```
deleteTagPerson INDEX t/TAG [t/MORE TAGS]…
```

- Removes specified tags from a person at the specified `INDEX`.
- Specify one or more tags with the `t/` prefix before each tag. At least one tag must be provided.
- Invalid tags will be ignored.

<h4>Example:</h4>

- `deleteTagPerson 2 t/colleagues t/friends`
  - Deletes the tags `colleagues` and `friends` from the 2nd person.<br><br>

  ![deleteTagPerson_success](images/output/deleteTagPerson_success.png)

<div style="page-break-after: always;"></div>

#### 3.7. Deleting tag(s) from a task: `deleteTagTask`

[Back to Table of Contents](#table-of-contents)

You can remove tag(s) from a task in your task list.

<h4>Format:</h4>

```
deleteTagTask INDEX t/TAG [t/MORE TAGS]…
```

- Removes specified tags from a task at the specified `INDEX`.
- Specify one or more tags with the `t/` prefix before each tag. At least one tag must be provided.
- Invalid tags will be ignored.

<h4>Example:</h4>

- `deleteTagTask 2 t/class t/finance`
  - Deletes the tags `class` and `finance` from the 2nd task.<br><br>

  ![deleteTagTask_success](images/output/deleteTagTask_success.png)

---

<div style="page-break-after: always;"></div>

### 4. General Commands

#### 4.1. Viewing help: `help`

[Back to Table of Contents](#table-of-contents)

You can view a link to access the user guide at any time, ensuring that you will never be lost.

<h4>Format:</h4>

```
help
```

<h4>Alias:</h4>

```
h
```

<h4>Example:</h4>

- `help`
  - Opens a window with a link to our user guide. You can copy the URL into a browser, or click on the "Open in browser" button to access the user guide directly.<br><br>

  ![help message](images/output/help_success.png)

<div style="page-break-after: always;"></div>

#### 4.2. Listing all persons and tasks: `listAll`

[Back to Table of Contents](#table-of-contents)

You can list all persons and tasks in your contact list and task list at the same time.

{% include admonition.html type="note" title="Note" body="

You can use this command to quickly clear all filters after using the <code>findPerson</code>, <code>findTask</code>, <code>findDone</code>, <code>findNotDone</code>, or <code>findTag</code> commands, instead of having to type the <code>listPerson</code> and <code>listTask</code> commands manually.

" %}

<h4>Format:</h4>

```
listAll
```

<h4>Example:</h4>
- `listAll`
  - Shows all the persons and tasks in your contact list and task list.<br><br>

  ![listAll success](images/output/listAll_success.png)

<div style="page-break-after: always;"></div>

#### 4.3. Exiting the program: `exit`

[Back to Table of Contents](#table-of-contents)

Once you are done with your work in CoordiMate, you can exit the program by typing a command.

<h4>Format:</h4>

```
exit
```

<h4>Example:</h4>
- `exit`
  - CoordiMate exits and the program window closes.

<br><br>

---

<div style="page-break-after: always;"></div>

## FAQ

[Back to Table of Contents](#table-of-contents)

{% include admonition.html type="question" title="How do I backup/restore my data?" body="

To make a backup:<br>

1. Locate the data file at <code>[CoordiMate JAR file location]/data/addressbook.json</code> on your current computer. <br>
2. Copy the data file to a safe location.<br><br>

To restore from a backup data file:<br>

1. Copy the data file to <code>[CoordiMate JAR file location]/data/addressbook.json</code>.<br>
2. Launch CoordiMate, and your data will be automatically imported.

" %}

<br><br>

---

<div style="page-break-after: always;"></div>

## Known Issues

[Back to Table of Contents](#table-of-contents)

{% include admonition.html type="bug" title="CoordiMate does not open on the correct screen." body="

CoordiMate remembers the last screen it was on when it was closed. If that screen is no longer available when CoordiMate is opened, you will not be able to see the application window. <br><br>

To resolve this issue, you can simply delete the <code>preferences.json</code> file that is in the same folder as the CoordiMate JAR file.

"%}

<br><br>

---

<div style="page-break-after: always;"></div>

## Command Summary

### Managing Persons

[Back to Table of Contents](#table-of-contents)

 Action | Format | Example | Alias
--------|--------|---------|------
[**Add Person**](#11-adding-a-person-addperson)| `addPerson n/NAME p/PHONE_NUMBER e/EMAIL a/ADDRESS [t/TAG]…` | `addPerson n/John Doe p/98765432 e/johnd@example.com a/John street, block 123, #01-01` | `ap`
[**List All Person**](#12-listing-all-persons-listperson) | `listPerson` | `listPerson` | `lp`
[**Edit Person**](#13-editing-a-person-editperson) | `editPerson INDEX [n/NAME] [p/PHONE] [e/EMAIL] [a/ADDRESS] [t/TAG]…​` | `editPerson 1 p/91234567 e/johndoe@example.com` | `ep`
[**Find Person**](#14-finding-a-specific-person-findperson) | `findPerson KEYWORD [MORE_KEYWORDS]…` | `findPerson John` | `fp`
[**Delete Person**](#15-deleting-a-person-entry-deleteperson) | `deletePerson INDEX` | `deletePerson 1` | `dp`
[**Delete All Person**](#16-clearing-all-person-entries-deleteallperson) | `deleteAllPerson` | `deleteAllPerson` | `dap`

<div style="page-break-after: always;"></div>

### Managing Tasks

[Back to Table of Contents](#table-of-contents)

 Action | Format | Example | Alias
--------|--------|---------|------
[**Add Task**](#21-adding-a-task-addtask) | `addTask T/TITLE n/NOTE [t/TAG]` | `addTask T/Get Flowers n/Wedding Anniversary` | `at`
[**List All Task**](#22-listing-all-tasks-listtask) | `listTask` | `listTask` | `lt`
[**Edit Task**](#23-editing-a-task-edittask) | `editTask INDEX [T/TITLE] [n/NOTE] [t/TAG]` | `editTask 1 T/Call Caterer n/Wedding Dinner` | `et`
[**Find Task**](#24-finding-a-specific-task-findtask) | `findTask KEYWORD [MORE_KEYWORDS]…` | `findTask Call Wedding` | `ft`
[**Delete Task**](#25-deleting-a-task-entry-deletetask) | `deleteTask INDEX` | `deleteTask 1` | `dt`
[**Delete All Task**](#26-clearing-all-task-entries-deletealltask) | `deleteAllTask` | `deleteAllTask` | `dat`
[**Mark Task**](#27-marking-a-task-as-done-marktask) | `markTask INDEX` | `markTask 1` | `mt`
[**Unmark Task**](#28-marking-a-task-as-not-done-unmarktask) | `unmarkTask INDEX` | `unmarkTask 1` | `ut`
[**Find Done Task**](#29-finding-all-tasks-that-are-done-finddone) | `findDone` | `findDone` | `fd`
[**Find Not Done Task**](#210-finding-all-tasks-that-are-not-done-findnotdone) | `findNotDone` | `findNotDone` | `fnd`
[**Delete All Done Task**](#211-deleting-all-tasks-that-are-done-deletealldone) | `deleteAllDone` | `deleteAllDone` | `dad`

<div style="page-break-after: always;"></div>

### Managing Tags

[Back to Table of Contents](#table-of-contents)

 Action | Format | Example | Alias
--------|--------|---------|------
[**Add Tag(s) to a Person**](#31-adding-tags-to-a-person-addtagperson) | `addTagPerson INDEX [t/TAG]…` | `addTagPerson 1 t/friends` | `atagp`
[**Add Tag(s) to a Task**](#32-adding-tags-to-a-task-addtagtask) | `addTagTask INDEX [t/TAG]…` | `addTagTask 1 t/day1` | `atagt`
[**List All Tags**](#33-listing-all-tags-listtag) | `listTag` | `listTag` | `ltag`
[**Find Tags**](#34-finding-persons-and-tasks-with-any-matching-tags-findtag) | `findTag KEYWORD [MORE_KEYWORDS]...` | `findTag orientation` | `ftag`
[**Find All Tags**](#35-finding-persons-and-tasks-with-all-matching-tags-findalltag) | `findAllTag KEYWORD [MORE_KEYWORDS]...` | `findAllTag orientation` | `fatag`
[**Delete Tag(s) from Person**](#36-deleting-tags-from-a-person-deletetagperson) | `deleteTagPerson INDEX t/TAG [t/MORE TAGS]...` | `deleteTagPerson 1 t/catering` | `dtagp`
[**Delete Tag(s) from Task**](#37-deleting-tags-from-a-task-deletetagtask) | `deleteTagTask INDEX t/TAG [t/MORE TAGS]...` | `deleteTagTask 1 t/catering` | `dtagt`

<div style="page-break-after: always;"></div>

### General

[Back to Table of Contents](#table-of-contents)

 Action | Format | Example | Alias
--------|--------|---------|------
[**View Help**](#41-viewing-help-help) | `help` | `help` | `h`
[**List All Person and Task**](#42-listing-all-persons-and-tasks-listall) | `listAll` | `listAll` | `la`
[**Exit**](#43-exiting-the-program-exit) | `exit` | `exit` | `e`
