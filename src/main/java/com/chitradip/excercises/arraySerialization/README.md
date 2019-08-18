## Array Serialization

### Overall Solution.
THe solution is to make a comma seperated string of all the strings. 

The major problem is that the string itself can contain a comma or anything that is used as a delimiter. So we have to escape it.

We use ',' as a delimiter and '\\' as an escape character. 

The logic is simple, while encoding, escape the ',''s  and the '\\'s. While decoding unescape them

### Encoding

First escape each word i.e. replace ',' with '\\,' and '\\' with '\\\\'. 
Then, join the words using ','s

### Decoding

we need to go throught the string to identify "unescaped" commas.  Seperate the words at the unescaped commas, and then 
unescape the individual words themselves (i.e. replace '\\\\' with '\\' and '\\,' with ',') to get back the original list. 

