
1) Draw the class diagram for the classes above. Make sure to include all fields and methods in your class diagram.

Answer: Please refer to the UML diagram PNG which is found within the database folder of Task 2.


2) Which SOLID principle is this program violating? Briefly explain.

Answer: This program violates the Open-Closed Principle that requires classes to be open for extensions,
        but closed for modifications. If we wanted to implement a third shape, we would have to modify 
        various existing classes to add that. Additionally, If we wanted to change the color identity 
        of the shapes, we would have to redo the constructors of each Shape, therefore modifying a 
        previously existing class.