import dto.Identifier;
import exception.CustomException;

import java.util.concurrent.ConcurrentHashMap;

public class TokenBucket {
    private final int maxToken,refillRatePerSecond;
    private static ConcurrentHashMap<String,RateLimitStatus> map=new ConcurrentHashMap<>();
    public TokenBucket(int maxToken, int refillRatePerSecond) {
        this.maxToken=maxToken;
        this.refillRatePerSecond=refillRatePerSecond;
    }


//    @Override
    public boolean allowRequest(Identifier identifier, int tokenCount) throws InterruptedException {
         refill(identifier);
         if(tokenCount > map.get(identifier.toString()).currentTokenCount){
             return false;
             //throw new CustomException("Not allowed");
         }
         map.compute(identifier.toString(),(key,status) ->{
             RateLimitStatus rateLimitStatus = map.get(identifier.toString());
             rateLimitStatus.currentTokenCount = rateLimitStatus.currentTokenCount - tokenCount;
             return rateLimitStatus;
         });
         return true;
    }

    public void refill(Identifier identifier) {
        map.compute(identifier.toString(),(key,status) ->{
            RateLimitStatus rateLimitStatus = map.get(identifier.toString());
            if(rateLimitStatus == null){
                rateLimitStatus = new RateLimitStatus((System.currentTimeMillis()), maxToken);
                return rateLimitStatus;
            }
            long currentTime = System.currentTimeMillis();
            long gap = currentTime - rateLimitStatus.lastRefillTime;
            long tokenValue = Math.min((gap*(refillRatePerSecond)/1000)+ rateLimitStatus.currentTokenCount, maxToken);
            System.out.println("Token value = "  + tokenValue + "gap " + gap);
            rateLimitStatus.currentTokenCount = (int)tokenValue;
            rateLimitStatus.lastRefillTime=currentTime;
            return rateLimitStatus;
        });
    }
}
