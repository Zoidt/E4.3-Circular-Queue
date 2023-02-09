# Exercise 4.3 - ⭕️ Circular Queue

## 🎯 Objectives

- **Implement** an circular queue data structure in Java.

## 🔨 Setup

1. Clone the repo (or download the zip) for this exercise, which you can find [here](https://github.com/JAC-CS-Programming-4-W23/E4.3-Circular-Queue).
2. Start IntelliJ, go to `File -> Open...`, and select the cloned/downloaded folder.
3. If at the top it says "Project JDK is not defined", click "Setup JDK" on the top right, and select the JDK version you have installed on your machine.

   ![Setup JDK](./images/Setup-JDK.png)

4. To get the unit tests to work, open `QueueTest.java` and add JUnit to the classpath:

   ![Setup Tests](./images/Setup-Tests.png)

   - Just click "OK" on the resulting dialogue window and all the test-related red squigglies should disappear.

## 🔍 Context

How do we *not* run out of space at the end of the array? Where is there space to be *had*? What if we could reclaim the lost space in the lower portion of the array?

- **Idea 1**: How about when we hit the end, we shift everything back down to the lower portion of the array. Moving back to the original space.
- **Idea 2**: How about we let the queue "wrap" around the edges of the array. It would be as if the array we're a circle.

The first idea seems easy enough to code. We will sometimes have a costly `enqueue` operation. The second idea can be confusing at first, but has the potential to be efficient for all operations!

Here is an example of a "circular" array with **idea 1** in purple and **idea 2** in blue and green:

[![Circular Queue](./images/Circular-Queue.gif)](https://jac-cs-programming-4-w23.github.io/Notes/#/4-Queues/?id=⭕%EF%B8%8F-circular-queue)

- An array is never really circular. We will code our use of array indices to treat the boundary between the `0` index array and the `capacity - 1`.

### ％ Modulus

A standard way to implement the circular array is to use the modulus operation `%`. To see this, take a look at this sequence of expressions using the `%` operator, imagining that we have an array of length 4:

```text
0 % 4 = 0
1 % 4 = 1
2 % 4 = 2
3 % 4 = 3
4 % 4 = 0
5 % 4 = 1
6 % 4 = 2
... and so on ...
```

What we see is that any positive number `x` could be "flattened" into an array position between `0` and `length - 1`. We can now use this for our `enqueue()` and `dequeue()` methods!

## 🚦 Let's Go

Using the class `IntQueue` you developed in the [last exercise](https://github.com/JAC-CS-Programming-4-W23/E4.2-Queue-Array):

1. Implement the methods of the `Queue` API: `enqueue(..)`, `dequeue()`, `front()`.
2. Challenge: implement `isEmpty()` and `isFull()`.
3. Throw exception `QueueOverflowException` and `QueueUnderflowException` when the caller has not met the operation preconditions.
4. Pass the unit test in the class `TestQueue`.

### 👑 Bonus - Queueable Interface

1. Create a `Queueable` interface which includes the necessary methods for a queue.
2. Have your `IntQueue` implement the `Queueable` interface and override all the interface's methods.
3. You can have the interface just use `int`s, but for an extra challenge, can you make it use generics instead?
   - No worries if you can't do this last part because we'll be learning generics later in the semester!

## 🔬 Observations

- Which operation is more efficient and why?
- What is the impact here?

---

[You won't BELIEVE this INSANE trick to jump the queue!!! (Gone Beany) | 480p reupload ultra SD](https://youtu.be/FiDNKryIza4)
