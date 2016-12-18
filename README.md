THREAD
-------
wait and notify pattern
-----------------------
-never use stop() as it is deprecated due to unsafe as design

-wait() will release the key and put the thread in wait state (AKA park state)

-notify() will release the thread in wait state and put it into run state

    -this is the only way to release a thread from waiting
    -randomly choose threads that are in wait state

-notifyAll() release all threads that are in wait state and put them in run state

THREAD STATES
---------------
new - when a thread gets created but not started

runnable - thread perform its task inside run() method

terminated - when a thread finishes its task and exit

blocked - waiting at the entrance of a synchronized block

waiting - parked using a wait() method, when waiting, it does not has the key, can only run when notify() method gets invoke

time_waiting - parked using a sleep(timeout) or wait(timeout) mehtod call. The thread will be awaken (back to run state) without invoke notify() method

MISC
-----
join() - wait until the thread is finish/dies so that the main thread can continues