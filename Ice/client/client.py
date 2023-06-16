import sys, Ice
import Demo

with Ice.initialize(sys.argv, "config.client") as communicator:
    properties = communicator.getProperties()
    properties.setProperty("Ice.Default.Locator", "MyObjectLocator")
    properties.setProperty("MyObjectAdapter.Endpoints", "tcp -h 127.0.0.2 -p 10000")
    properties.setProperty("MyObjectAdapter.ThreadPool.Server.Size", "10")

    # Create a proxy for the object
    proxy = communicator.stringToProxy("shared/dsaa: tcp -h 127.0.0.2 -p 10000")
    my_object = Demo.MyObjectPrx.checkedCast(proxy)
    # proxy = communicator.stringToProxy("dedicated/kox: tcp -h 127.0.0.2 -p 10000")
    # my_object = Demo.MyObjectPrx.checkedCast(proxy)
    # my_object = Ice.ObjectPrx.checkedCast(proxy)
    if my_object:
        print(my_object.getName())
    else:
        print("unlucky")

    # Call methods on the object
    # my_object.getName()