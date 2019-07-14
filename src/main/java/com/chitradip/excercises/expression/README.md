# Expression Evalulation

The task is to evaluate an expression of type `2*3+4`

## Naive Implementation

The first implementation assumes only +,-,*,/ . 

There are 2 precedences +,- is lower precedence and *,/ are in higher precedence. 

The solution is to simply go over the input twice. In the first iteration evaluate multiplications and divisions. 

## PostFix

This is the standard way to do precedence evaluations. 

To evaluate postfix expression, we use a stack of number and when we encounter a operator, we pop 2 numbers out of the
 stack and apply it. 

We first convert the infix representation to a postfix representation. To do this, we use a stack of operands.
We push the operands in a stack unless the operand on top of the stack has higher precedence. 

##Less general postfix 

We can do step 1 and 2 from PostFix (above) by doing the operations in the same pass. 

Here we have 2 stacks one with numbers and one with operands. When we encounter numbers, we push it into a stack. 
When we encounter a operator, we either push it in the stack or pop the top out of the stack and apply the operands. (postfix step above) 

This evalutates a postfix expression while creating it in one step. s