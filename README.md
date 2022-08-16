# Randomness

Writing JUnit test classes, I often find myself writing

```
    private static final Random RANDOM = new Random();
```

I suppose I could make `RANDOM` public in one test class and have the other test 
classes import it. [FINISH WRITING]