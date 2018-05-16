# Dispatcher for samebug notifier agent

The agent inlines additional code to the `java.lang.Throwable.printStackTrace` method
and this inline code references classes that are declared in the `samebug-notifier-agent`
project. However these classes are not visible from the system classloader.

A workaround is described in this [issue](https://github.com/raphw/byte-buddy/issues/110#issuecomment-204832833)
(from the author of [byte-buddy](https://github.com/raphw/byte-buddy),
the bytecode manipulation lib used by the agent). The agent loads a jar of the shared classes
and injects it to the bootstrap class loader, so it becomes available for all classloaders.
On the other hand, the agent project itself declares this jar as a provided dependency, so
it can be compiled, but there will be no clash.
