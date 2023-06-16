package sr.proto;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.54.0)",
    comments = "Source: party.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class PartyServiceGrpc {

  private PartyServiceGrpc() {}

  public static final String SERVICE_NAME = "tutorial.PartyService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<sr.proto.PartyProto.PartyRequest,
      sr.proto.PartyProto.Party> getSubscribeToPartyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SubscribeToParty",
      requestType = sr.proto.PartyProto.PartyRequest.class,
      responseType = sr.proto.PartyProto.Party.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<sr.proto.PartyProto.PartyRequest,
      sr.proto.PartyProto.Party> getSubscribeToPartyMethod() {
    io.grpc.MethodDescriptor<sr.proto.PartyProto.PartyRequest, sr.proto.PartyProto.Party> getSubscribeToPartyMethod;
    if ((getSubscribeToPartyMethod = PartyServiceGrpc.getSubscribeToPartyMethod) == null) {
      synchronized (PartyServiceGrpc.class) {
        if ((getSubscribeToPartyMethod = PartyServiceGrpc.getSubscribeToPartyMethod) == null) {
          PartyServiceGrpc.getSubscribeToPartyMethod = getSubscribeToPartyMethod =
              io.grpc.MethodDescriptor.<sr.proto.PartyProto.PartyRequest, sr.proto.PartyProto.Party>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SubscribeToParty"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  sr.proto.PartyProto.PartyRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  sr.proto.PartyProto.Party.getDefaultInstance()))
              .setSchemaDescriptor(new PartyServiceMethodDescriptorSupplier("SubscribeToParty"))
              .build();
        }
      }
    }
    return getSubscribeToPartyMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static PartyServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PartyServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<PartyServiceStub>() {
        @java.lang.Override
        public PartyServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new PartyServiceStub(channel, callOptions);
        }
      };
    return PartyServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static PartyServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PartyServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<PartyServiceBlockingStub>() {
        @java.lang.Override
        public PartyServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new PartyServiceBlockingStub(channel, callOptions);
        }
      };
    return PartyServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static PartyServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PartyServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<PartyServiceFutureStub>() {
        @java.lang.Override
        public PartyServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new PartyServiceFutureStub(channel, callOptions);
        }
      };
    return PartyServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void subscribeToParty(sr.proto.PartyProto.PartyRequest request,
        io.grpc.stub.StreamObserver<sr.proto.PartyProto.Party> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSubscribeToPartyMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service PartyService.
   */
  public static abstract class PartyServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return PartyServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service PartyService.
   */
  public static final class PartyServiceStub
      extends io.grpc.stub.AbstractAsyncStub<PartyServiceStub> {
    private PartyServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PartyServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PartyServiceStub(channel, callOptions);
    }

    /**
     */
    public void subscribeToParty(sr.proto.PartyProto.PartyRequest request,
        io.grpc.stub.StreamObserver<sr.proto.PartyProto.Party> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getSubscribeToPartyMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service PartyService.
   */
  public static final class PartyServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<PartyServiceBlockingStub> {
    private PartyServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PartyServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PartyServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public java.util.Iterator<sr.proto.PartyProto.Party> subscribeToParty(
        sr.proto.PartyProto.PartyRequest request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getSubscribeToPartyMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service PartyService.
   */
  public static final class PartyServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<PartyServiceFutureStub> {
    private PartyServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PartyServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PartyServiceFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_SUBSCRIBE_TO_PARTY = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SUBSCRIBE_TO_PARTY:
          serviceImpl.subscribeToParty((sr.proto.PartyProto.PartyRequest) request,
              (io.grpc.stub.StreamObserver<sr.proto.PartyProto.Party>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getSubscribeToPartyMethod(),
          io.grpc.stub.ServerCalls.asyncServerStreamingCall(
            new MethodHandlers<
              sr.proto.PartyProto.PartyRequest,
              sr.proto.PartyProto.Party>(
                service, METHODID_SUBSCRIBE_TO_PARTY)))
        .build();
  }

  private static abstract class PartyServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    PartyServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return sr.proto.PartyProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("PartyService");
    }
  }

  private static final class PartyServiceFileDescriptorSupplier
      extends PartyServiceBaseDescriptorSupplier {
    PartyServiceFileDescriptorSupplier() {}
  }

  private static final class PartyServiceMethodDescriptorSupplier
      extends PartyServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    PartyServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (PartyServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new PartyServiceFileDescriptorSupplier())
              .addMethod(getSubscribeToPartyMethod())
              .build();
        }
      }
    }
    return result;
  }
}
