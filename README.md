# PersonRelationsBFS
A quick BFS solution to find the minimum relation distance between two people 

We define a direct relation between two people as follows: Person A is directly related to
person B if either their full name and/or address are exactly equal (case-sensitive).
We define an n-level relation between person A and person B if you can reach from person A
to person B in exactly n direct relation hops. 1-level relation is a direct relation.

I implemented the graph as a hashmap because it was quicker but a graph would be more readable
Both will have the same runtime if both will store a set of seen relations
