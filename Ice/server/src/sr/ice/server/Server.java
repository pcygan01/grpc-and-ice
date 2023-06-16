package sr.ice.server;

import com.zeroc.Ice.*;

import java.lang.Object;
import java.util.HashMap;
import java.util.Map;

class MyObjectLocator implements ServantLocator {
	private int id = 0;

	public LocateResult locate(Current current) {
		ServantLocator.LocateResult r = new ServantLocator.LocateResult();
		com.zeroc.Ice.Object servant = current.adapter.find(current.id);
		if (servant == null) // We don't have a servant already
		{
			System.out.println("making dedicated servant ");


			servant = new MyObjectI(id++);

			// Add the servant to the ASM.
			//
			current.adapter.add(servant, current.id);
		}

		r.returnValue = servant;
		return r;
	}
	@Override
	public void deactivate(String s) {

	}
	@Override
	public void finished(Current current, com.zeroc.Ice.Object object, Object o) throws UserException {

	}
}


	public class Server{
	public static void main(String[] args) {
		try (Communicator communicator = Util.initialize(args)) {
			ObjectAdapter adapter = communicator.createObjectAdapterWithEndpoints("MyObjectAdapter", "tcp -h 127.0.0.2 -p 10000 -z : udp -h 127.0.0.2 -p 10000 -z");
//			ObjectAdapter adapter = communicator.createObjectAdapter("DemoAdapter");
//"default -h localhost -p 10000"
			// Dodanie dedykowanego serwanta
			Identity identity = new Identity();
			identity.name = "MyObject";
			System.out.println("making shared servant");
			adapter.addDefaultServant(new MyObjectI(1), "shared");
			adapter.addServantLocator(new MyObjectLocator(), "dedicated");
//			adapter.addDefaultServant(new MyObjectI(1), new Identity("adapter1","shared"));
//			adapter.addServantLocator(new MyObjectLocator(), "dedicated");

			// Dodanie serwanta współdzielonego
			adapter.activate();

			System.out.println("Server started...");
			communicator.waitForShutdown();
		} catch (LocalException e) {
			e.printStackTrace();
		}
	}
}