Lab 6 - Exercise 2 - Task 1

Part a (3 marks) Which SOLID principle is this program violating? Briefly explain.

    There is a clear violation of Liskov Substitution as two unrelated classes are both
    attempting to extend abstract class Vehicle; however, Bicycle’s do not have engines.
    This inherently changes the behavior of our program.

Part b (7 marks) If needed, re-write each class completely to remove the code smell
in question. If not, simply write no change needed for a class.

    See src folder for changes to each class. If changes were made they, comments will
    explain or highlight them.

