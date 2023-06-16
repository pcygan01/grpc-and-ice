package sr.grpc.server;

import io.grpc.stub.StreamObserver;
import jdk.jfr.Event;
import sr.proto.PartyProto;
import sr.proto.PartyServiceGrpc;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class PartyServiceImpl extends PartyServiceGrpc.PartyServiceImplBase {
    List<PartyProto.Party> partyList;
    private Map<String, Set<StreamObserver<PartyProto.Party>>> subscriptions;
    private final Map<String, List<PartyProto.Party>> buffer = new ConcurrentHashMap<>();

//    @Override
//    public void subscribeToParty(StreamObserver<PartyProto.Party> responseObserver) {
//        return;
//        return new StreamObserver<PartyProto.Party>() {
//            private String clientId;
//
//            @Override
//            public void onNext(PartyProto.Party party) {
//                System.out.println("onnext");
//                if (clientId == null) {
//                    clientId = party.getCity() + "-" + party.getTickets();
//                    Set<StreamObserver<PartyProto.Party>> observers = subscriptions.computeIfAbsent(clientId, k -> new HashSet<>());
//                    observers.add(responseObserver);
//                }
//            }
//
//            @Override
//            public void onError(Throwable t) {
//                System.err.println("Encountered error in subscribeToParty: " + t);
//            }
//
//            @Override
//            public void onCompleted() {
//                if (clientId != null) {
//                    Set<StreamObserver<PartyProto.Party>> observers = subscriptions.get(clientId);
//                    if (observers != null) {
//                        observers.remove(responseObserver);
//                        if (observers.isEmpty()) {
//                            subscriptions.remove(clientId);
//                        }
//                    }
//                }
//            }
//        };
//    }

    private void sendMatchingParties(String clientId) {
        Set<StreamObserver<PartyProto.Party>> observers = subscriptions.get(clientId);
        if (observers != null) {
            for (PartyProto.Party party : getMatchingParties(clientId)) {
                for (StreamObserver<PartyProto.Party> observer : observers) {
                    try{
                        observer.onNext(party);
                    }
                    catch{
                        buffer.computeIfAbsent(clientId, k -> new CopyOnWriteArrayList<>().add(PartyProto.Party));
                    }
                }
            }
        }
    }

    private Set<PartyProto.Party> getMatchingParties(String clientId) {
        Set<PartyProto.Party> matchingParties = new HashSet<>();
        String[] clientParams = clientId.split("-");
        String clientCity = clientParams[0];
        int clientTickets = Integer.parseInt(clientParams[1]);
        for (PartyProto.Party party : partyList) {
            if (party.getCity().equals(clientCity) && party.getTickets() >= clientTickets) {
                matchingParties.add(party);
            }

        }
        return matchingParties;
    }

    public PartyServiceImpl() {
        System.out.println("partyserviceimpl");
        this.subscriptions = new HashMap<>();
        List<PartyProto.Party> partyList = new ArrayList<>();
        partyList.add(PartyProto.Party.newBuilder()
                .setName("Party 1")
                .setCity("New York")
                .setTickets(100)
                .addArtists("Artist 1")
                .addArtists("Artist 2")
                .build());
        partyList.add(PartyProto.Party.newBuilder()
                .setName("Party 2")
                .setCity("Los Angeles")
                .setTickets(50)
                .addArtists("Artist 3")
                .addArtists("Artist 4")
                .build());
        partyList.add(PartyProto.Party.newBuilder()
                .setName("Party 3")
                .setCity("Miami")
                .setTickets(75)
                .addArtists("Artist 5")
                .addArtists("Artist 6")
                .build());
        System.out.println(partyList);
//        new Timer().scheduleAtFixedRate(new TimerTask() {
//            @Override
//            public void run() {
//                for (String clientId : subscriptions.keySet()) {
//                    sendMatchingParties(clientId);
//                }
//            }
//        }, 0, 10000);
    }

    @Override
    public void subscribeToParty(PartyProto.PartyRequest request, StreamObserver<PartyProto.Party> responseObserver) {
//        super.subscribeToParty(request, responseObserver);
        sendMatchingParties();
//        System.out.println("subscribe");
//        responseObserver.onNext(PartyProto.Party.newBuilder()
//                .setName("Party 2")
//                .setCity("Los Angeles")
//                .setTickets(50)
//                .addArtists("Artist 3")
//                .addArtists("Artist 4")
//                .build());

    }
}