# Cryptarithmetic-Solver

A Cryptaritmetic Solver for numerical base of 6 or 10 using Backtracking search. The algorithm woks only for addition of the two strings. In main() there are already three examples of strings that solved by running the program.
The 3 examples are: <br/>
I. TO + TO = FOR , numerical base = 6
II. TOO + TOO = FOR , numerical base = 6 
III. WON + WON = TOO , nuerical base = 10

Solutions:
Case 1, "TO + TO = FOR"
T-1 O-2 F-0 R-4 
T-2 O-5 F-0 R-4 
T-4 O-3 F-1 R-0 

Case 2, "TOO + TOO = FOR"
T-0 O-5 F-1 R-4 
T-1 O-5 F-3 R-4 

Case 3, "WON + WON = TOO"
No solution found!

If you want to change the input strings for a different result just change the String values in main.
