#Programming Exercies

## Problems

### Expression Evaluation

Given a expression like 2+3+5/2+2 implement a evaluator. 

[Code](./expression)

### LRU

Implement a sized based LRU cache. 
The cache is of a maximum size.
 When full, it should evict the least recently used. 
 
1. Implement get() should be  O(1) 
2. Implement insert() should be O(1)

Bonus what if there was a "expiry" in the cache as well? What are the complications?  
    
[Code](./lru)

## List Serialization

Given a list of strings, convert into one string such that you can convert it back to the list

1. toString() should convert ["cat", "dogs", "giraffes" ] to "\<Some String\>"
2. fromString() should convert "\<Some String\>" to ["cat", "dogs", "giraffes" ]

The format of <Some String> is upto the user.

[Code](./arraySerialization)

## Ordered Powers of Primes

Given a prime number generator, give me a ordered list of their powers upto a given number. 

For 10, list should be like 

orderedPrimes(10) = [2, 3, 4, 5, 7, 8, 9, 16, 25, 27]

For starters, instead of primes, we can restrict this to  2,3,5

In this case for an input of 10, we have
orderedPowers(10) = [2, 3, 4, 5, 8, 9, 16, 25, 27, 32]



