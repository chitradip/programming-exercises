## Creating random number generators from other random number gnereators

### Mututally prime 

Here as and example, we try to create Rand 7 with Rand 5. 

Since 5 and 7 are mutually prime, this is tricky to get right. Two random numbers from rand5 gives a space of 25 integers

However, since 25 ( or any power of 5) will not be divisible by 7, we cannot just MOD by 7, since it will inflate the probablity of 0-4

we can dicard anything over 20 to get a space of 0-20 which have 21 numbers uniformly. moding this by 7 will give us rand7

 

