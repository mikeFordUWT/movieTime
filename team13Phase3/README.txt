We wrote our code in Java in Eclipse. I’ve attached the jar file needed for 
connecting to a mysql server via java, just in case it doesn’t work.

if it doesn’t work. 

http://www.ccs.neu.edu/home/kathleen/classes/cs3200/JDBCtutorial.pdf

That’s a link to a PDF that will walk through how to install the jar in build path.

A few things worth noting. 

The app is not fully functional.
Some of the features, described in Phase 1 and 2, such as 
displaying a poster and being able to rate movies and see the avg 
rating, are not built in.

To run the code, just press run from the Runner class in the view package.

*****LOG IN CREDENTIALS AT BOTTOM OF THIS DOCUMENT*******

Criteria:

INSERT:
We have one insert statement that is when a movie is added to a user’s 
watch list.

UPDATE:
Our update statement is when a user adds that same movie to their 
favorites list.

**** A movie can not be added directly to the Favorites list if it is 
not first in in the watch list. The code will break and it will have 
to be restarted if a movie is added directly to the favorites list.

OTHER:
Our other interactions are that the user’s name is displayed on the 
main user page upon log in, as well as the user’s watch and favorite 
list. These 3 items are pulled from the database. 

Also when a movie is searched for it will display a movie page, if it 
exists, and all of the info is pulled from the database. 

All of our queries are either in DBConnection or DatabaseAccess, which 
are both in the data package. 


******SUGGESTED MOVIE SEARCHES********
Star Wars
scott pilgrim
mad max
A Clockwork Orange


********* LOG IN CREDENTIALS*******
(THIS ONE IS ALSO YOUR CREDENTIALS TO ACCESS MY SERVER) which is: 

fordm13.vergil.u.washington.edu   Port: 1138

(****SAME FOR SERVER*****)
user: jilarson@uw.edu
pass: husky123


user: fordm13@uw.edu
pass: password

user: andybleich@gmail.com
pass: league19


I’ve supplied the second two, which only work in the java app, so you 
can see that it is pulling different info for each user(Name, Watch 
List, Favorite List).
