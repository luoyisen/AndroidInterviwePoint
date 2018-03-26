---
date: 2018-03-11 16:38
status: public
title: IntentService
---

When to use?

    The Service can be used in tasks with no UI, but shouldn't be too long. If you need to perform long tasks, you must use threads within Service.

    The IntentService can be used in long tasks usually with no communication to Main Thread. If communication is required, can use Main Thread handler or broadcast intents. Another case of use is when callbacks are needed (Intent triggered tasks).

How to trigger?

    The Service is triggered by calling method startService().

    The IntentService is triggered using an Intent, it spawns a new worker thread and the method onHandleIntent() is called on this thread.

Triggered From

    The Service and IntentService may be triggered from any thread, activity or other application component.

Runs On

    The Service runs in background but it runs on the Main Thread of the application.

    The IntentService runs on a separate worker thread.

Limitations / Drawbacks

    The Service may block the Main Thread of the application.

    The IntentService cannot run tasks in parallel. Hence all the consecutive intents will go into the message queue for the worker thread and will execute sequentially.

When to stop?

    If you implement a Service, it is your responsibility to stop the service when its work is done, by calling stopSelf() or stopService(). (If you only want to provide binding, you don't need to implement this method).

    The IntentService stops the service after all start requests have been handled, so you never have to call stopSelf().

shareimprove this answer
edited Dec 4 '14 at 9:31
answered Apr 2 '13 at 18:57
José Juan Sánchez
11.2k177

