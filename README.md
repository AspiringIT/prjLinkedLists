# prjLinkedLists
**Top Ten Gamers**

Implement a class that maintains a list of the top 10 performers in a video game.
An entry on the list consists of a name and score, <br> 
and the list is kept sorted in descending order of scores.
Here is an example of such a list when it only has 4 elements.

Spike 120 <br>
Whiz 105  <br>
G-Man 99<br>
JediMaster 95

Use a a class based on linked lists. The class should have a **constructor** that sets up an empty list,
and a void insert(String name, int score) method that adds a name and a score pair
to the list. The insert method puts the entry in the proper position so that the list
stays sorted by score. 

The list should have a maximum size of 10. After the list has 10 elements,
an attempt to add a name with a score that is less than or equal to the minimum score on
the list is ignored, and adding a score that is greater than the minimum score causes an entry with the minimum
score to be dropped from the list.

Test the score with a graphical user interface similar to LinkedList1Demo.java The graphical
interface should support a single command of the form

*insert name score*

An example of such a command is "insert Whiz 105."

