# Expression Evalulation

The task is to evaluate an expression of type `2*3+4`

## Naive Implementation

The first implementation assumes only +,-,*,/ . 

There are 2 precedences +,- is lower precedence and *,/ are in higher precedence. 

The solution is to simply go over the input twice. In the first iteration evaluate multiplications and divisions. 