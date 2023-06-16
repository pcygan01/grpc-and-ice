package sr.ice.server;

import Demo.MyObject;
import Demo.MyObject;
import com.zeroc.Ice.Current;

import java.util.spi.CurrencyNameProvider;

public class MyObjectI implements MyObject {
	private final int servantId;
	public MyObjectI(int id){
		this.servantId = id;
	}
	public String getName(Current current) {
		return String.format("Hello world from %d!", this.servantId);
	}
	public int getId(Current current){
		return this.servantId;
	}
}

