Rate-limiting

Throttling the users for allowing fair share of resources among all of them, preventing abuse by particualr users etc.


Functional Requirements
rate limiting of an API based on user/client identifier 

Non-Functional Requirements
Low latency
Accurate
Scalable
Fault tolerant and highly available (Not required. If rate limiter fails,should not throttle.)

Implementation/Low-Level Design : Single server 
Token Bucket Implementation

1. Maintaninig the rate limiter rules config either in database or other distributed storage like s3.
2. Service will periodically pull the config and cache in-memory.
3. Pass this config to rate limiter class. 
4. Rate limiter class will implement the token bucket algorithm.
5. Token bucket algorithm -> Each client/user will have it's own bucket with maximum size. For each request
   belonging to this user , a token will be removed from the bucket. If bucket is empty, request will be rejected.




Solution over distributed world.

1. If rate limiting is happening on IP lever/Client or user level, enable LB sticky session so that 
    all the requests from same client will be routed to same server. Disadvantage is that if server goes down , it'll affect the accuracy
    of rate limiting for this user or if the server is overloaded, it'll start impacting the other users on this node.
2. Allow host to talk to each other. Disadvantage is communication between host take time and there are chances that
   you'll end up processing more-number of request for a particular user than intended.
3. Communication between hosts 
      a. Tell everyone-everything.Full mesh topology.How does host is going to discover itself ? Use 3rd party service where each host register itself.
         Host will send heartbeat to this 3rd party service. Each host than can ask to get all the host information.
         Disadvantages is that it can work for small cluster with small number of host. Number of message exchange between host's will grow exponentially.
      b. Gossip Protocol. http://highscalability.com/blog/2023/7/16/gossip-protocol-explained.html
      c. Distributed Cache. Each buckets will be stored in redis
      

Distributed Cache Solution

1. Each buckets can be stored in the redis.
2. Sync problem. Problem will happen in get and then set lock. Concurrent same user id request can set lower value and hence can effect the
   accuracy of rate limiting. One of the way is to use lock. Smart way can be to use lock similar to 2 phase locking.
   Not scalable and can become bottleneck. Another approach is to use lua script which executes atomically (get and set as one operation).
3. Increase latency is another disadvantage. If we can deal with eventual consistent model,each host can periodically updates the counter atomically and then can pull the values.
   https://konghq.com/blog/engineering/how-to-design-a-scalable-rate-limiting-algorithm
   Shorter sync interval can make it more accurate but will put load on data store.
4. Lot of other detail can be found in this link https://github.com/system-design-forked/system-design/blob/master/RateLimiter.md#nginx-based-rate-limiting


Other algorithms

1.Leaking bucket algorithm :  When a request arrives, the application will check if queue is full. If not, it is inserted else drop. Deque is done at regular interval
2.Fixed window algorithm : Count the number of request in a fixed window of time. If it exceeds the limit, drop the request. Edge case a burst of traffic at the edges of time windows
could cause more requests than allowed quota to go through.
3.Sliding window log algorithm: The algo keeps track of requested timestamp. When a new request comes in, remove all the outdated timestamps. Outdated timestamps are defined as those older than the start of the current time window. Add timestamp of the new request to the log. If the log size is the same or lower than the allowed count, a request is accepted.
Otherwise, it is rejected.
4.Sliding window counter algorithm: For a new window that arrives at t% of the new window with size s , it is calculated using
Requests in current window + requests in the previous window * (s-t)




