import grpc
import party_pb2
import party_pb2_grpc
import time

def run():
    # create a gRPC channel and stub
    channel = grpc.insecure_channel('127.0.0.5:50051')
    stub = party_pb2_grpc.PartyServiceStub(channel)

    # create a party request
    request = party_pb2.PartyRequest(city='Los Angeles', tickets=2)

    # call the SubscribeToParty RPC and get the response iterator
    response_iterator = stub.SubscribeToParty(request)

    # iterate over the response iterator to receive the stream of Party messages
    for party in response_iterator:
        print(f"Party name: {party.name}")
        print(f"City: {party.city}")
        print(f"Number of tickets: {party.tickets}")
        print(f"Artists: {', '.join(party.artists)}")
        print('---')

if __name__ == '__main__':
    while True:
        try:
            run()
        except KeyboardInterrupt:
            print("Closing the client")
            break
        except Exception as e:
            print("Error:", e)
            time.sleep(5)