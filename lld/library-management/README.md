Library management software is built to take care of basic housekeeping functionality of the library.

System Requirements (Please clarify with the interviewer)

1.A book is searchable by title,publication,author.
2.Each book will have a unique identification number and rack numer.
3.There are multiple copies of the book.Member should be able to issue a book.
4.Librarian should be able to create/manage the member account creation.
5.System should be able to issue the fine.
6.Maximum book issued by the member = 5.
7.Maxiumum day for which the user can book = 10.
8.User should be able to reserved a book
9.Whenever the reserve book is availabel, system should send the notification to the user (who reserved the book)


API's.

1. /add/delete/update -> the books
2. issue -> issue a book by the user
3. return -> return a book by the user
4. create/delete membership
5. searchcatalogue -> search the book by it's metadata.
6. reserve -> reserve the book which is not availabel

Actors in the system

1.Members
2.Librarian
3.System.
Inspired from https://github.com/JaspreetChhabra/LibraryManagementSystem