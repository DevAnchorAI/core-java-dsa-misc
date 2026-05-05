SimpleThreadPool demo

This small project adds a SimpleThreadPool executor and demonstrates usage in `src/Main.java`.

Compile (PowerShell):

```powershell
cd C:\WORK\CODE\DSAWorkspace\ThreadApp
javac -d out src\*.java
java -cp out Main
```

What to expect:
- The program creates a pool with 3 workers, submits 6 tasks, each sleeps 500ms.
- After shutdown and awaitTermination, it prints whether all tasks finished within 5s.
- Submitting after shutdown throws RejectedExecutionException (caught and printed).

Edge cases to try:
- Create the pool with 0 threads (should throw IllegalArgumentException).
- Call submit after shutdown (should throw RejectedExecutionException).

