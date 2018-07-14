//package shu.cssd.transportsystem.database.seeds;
//
//import shu.cssd.transportsystem.foundation.BaseModel;
//import shu.cssd.transportsystem.foundation.database.BaseSeeder;
//import shu.cssd.transportsystem.models.Stop;
//import shu.cssd.transportsystem.models.Token;
//import shu.cssd.transportsystem.models.collections.SetOfStops;
//import shu.cssd.transportsystem.models.collections.SetOfTokens;
//
//public class TokenSeeder implements BaseSeeder
//{
//    private SetOfTokens setOfTokens = new SetOfTokens();
//
//    private  String [] stop = new String[5];
//
//    @Override
//    public void seed()
//    {
//        Token token1 = new Token(stop[0], stop[6]);
//        Token token2 = new Token(stop[2], stop[8]);
////        Token token3 = new Token(stop[], stop[]);
////        Token token4 = new Token(stop[], stop[]);
////        Token token5 = new Token(stop[], stop[]);
//
//
//        this.setOfTokens.create(token1);
//        this.setOfTokens.create(token2);
////        this.setOfJourney.create(journey3);
////        this.setOfJourney.create(journey4);
////        this.setOfJourney.create(journey5);
//
//        read();
//    }
//
//    @Override
//    public void read()
//    {
//        for (BaseModel model: this.setOfTokens.all())
//        {
//            Token token = (Token) model;
//
//            System.out.println("TokenID: " + token.id);
//
//        }
//    }
//
//    @Override
//    public void relationships()
//    {
//        SetOfStops setOfStops = new SetOfStops();
//
//        for (int i = 0; i < setOfStops.all().size(); i++)
//        {
//
//            Stop stop = (Stop) setOfStops.all().get(i);
//
//            this.stop[i] = stop.id;
//
//        }
//    }
//}
