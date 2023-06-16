package sr.grpc.server;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.netty.shaded.io.grpc.netty.NettyServerBuilder;
import io.grpc.stub.StreamObserver;
import sr.proto.PartyProto;
import sr.proto.PartyServiceGrpc;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.UnknownHostException;
import java.util.*;
import java.util.concurrent.Executors;

public class PartyServer {
	private String address = "127.0.0.5";
	private int port;
	private Server server;

	private SocketAddress socket;

	public PartyServer() {
		this.port = 50051;
	}

	private void start() throws IOException {

		try { socket = new InetSocketAddress(InetAddress.getByName(address), port);	} catch(UnknownHostException e) {};

		//You will want to employ flow-control so that the queue doesn't blow up your memory. You can cast StreamObserver to CallStreamObserver to get flow-control API
		server = /*ServerBuilder*/NettyServerBuilder.forAddress(socket).executor(Executors.newFixedThreadPool(16))
				.addService(new PartyServiceImpl())
				//.addService(new CalculatorImpl())
				//.addService(new AdvancedCalculatorImpl())
				.build()
				.start();
		System.out.println("Server started, listening on " + port);
		Runtime.getRuntime().addShutdownHook(new Thread() {
			@Override
			public void run() {
				System.err.println("*** shutting down gRPC server since JVM is shutting down");
				PartyServer.this.stop();
				System.err.println("*** server shut down");
			}
		});
	}

	private void stop() {
		if (server != null) {
			server.shutdown();
		}
	}

	/**
	 * Await termination on the main thread since the grpc library uses daemon threads.
	 */
	private void blockUntilShutdown() throws InterruptedException {
		if (server != null) {
			server.awaitTermination();
		}
	}


	public static void main(String[] args) throws IOException, InterruptedException {
		final PartyServer server = new PartyServer();
		server.start();
		server.blockUntilShutdown();
	}
}
