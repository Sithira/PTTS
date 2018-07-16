//package shu.cssd.transportsystem.database.seeds;
//
//import shu.cssd.transportsystem.foundation.BaseModel;
//import shu.cssd.transportsystem.foundation.database.BaseSeeder;
//import shu.cssd.transportsystem.models.Journey;
//import shu.cssd.transportsystem.models.Route;
//import shu.cssd.transportsystem.models.Stop;
//import shu.cssd.transportsystem.models.User;
//import shu.cssd.transportsystem.models.collections.SetOfJourney;
//import shu.cssd.transportsystem.models.collections.SetOfRoutes;
//import shu.cssd.transportsystem.models.collections.SetOfStops;
//import shu.cssd.transportsystem.models.collections.SetOfUsers;
//
//public class JourneySeeder implements BaseSeeder
//{
//    private SetOfJourney setOfJourney = new SetOfJourney();
//
//    private  String [] users = new String[5];
//    private  String [] routes = new String[5];
//    private  String [] stop = new String[5];
//
//    @Override
//    public void seed()
//    {
//
//        Journey journey1 = new Journey(users[0], stop[0], stop[6],135D);
//        Journey journey2 = new Journey(users[1], stop[2], stop[6],175D);
//        Journey journey3 = new Journey(users[2], stop[2], stop[8],50D);
//        Journey journey4 = new Journey(users[3], stop[1], stop[8],300D);
//        Journey journey5 = new Journey(users[3], stop[0], stop[3],250D);
//        Journey journey6 = new Journey(users[3], stop[3], stop[0],250D);
//
//
//        this.setOfJourney.create(journey1);
//        this.setOfJourney.create(journey2);
//        this.setOfJourney.create(journey3);
//        this.setOfJourney.create(journey4);
//        this.setOfJourney.create(journey5);
//        this.setOfJourney.create(journey6);
//
//        read();
//    }
//
//    @Override
//    public void read()
//    {
//        for (BaseModel model: this.setOfJourney.all())
//        {
//            Journey journey = (Journey) model;
//
//            System.out.println("JourneyID: " + journey.id);
//
//        }
//    }
//
//    @Override
//    public void relationships()
//    {
//        SetOfUsers setOfUsers = new SetOfUsers();
//        SetOfRoutes setOfRoutes = new SetOfRoutes();
//        SetOfStops setOfStops = new SetOfStops();
//
//        for (int i = 0; i < setOfUsers.all().size(); i++)
//        {
//
//            User user = (User) setOfUsers.all().get(i);
//
//            this.users[i] = user.id;
//
//        }
//
//        for (int i = 0; i < setOfRoutes.all().size(); i++)
//        {
//
//            Route route = (Route) setOfRoutes.all().get(i);
//
//            this.routes[i] = route.id;
//
//        }
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
