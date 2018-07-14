package shu.cssd.transportsystem.database.seeds;

import shu.cssd.transportsystem.foundation.BaseModel;
import shu.cssd.transportsystem.foundation.database.BaseSeeder;
import shu.cssd.transportsystem.models.SmartCard;
import shu.cssd.transportsystem.models.User;
import shu.cssd.transportsystem.models.collections.SetOfSmartCards;
import shu.cssd.transportsystem.models.collections.SetOfUsers;

import java.util.Date;

public class SmartCardSeeder implements BaseSeeder
{
    private SetOfSmartCards setOfSmartCards = new SetOfSmartCards();

    private  String [] users = new String[5];

    @Override
    public void seed()
    {
        Date date1 = new Date();
        Date date2 = new Date();


        //Seed SmartCards
        SmartCard smartCard1 = new SmartCard(users[0], 1111, 111, date1);
        SmartCard smartCard2 = new SmartCard(users[1], 2222, 222, date2);
        SmartCard smartCard3 = new SmartCard(users[2], 3333, 333, date2);
        SmartCard smartCard4 = new SmartCard(users[3], 4444, 444, date2);
        SmartCard smartCard5 = new SmartCard(users[4], 5555, 555, date2);


        this.setOfSmartCards.create(smartCard1);
        this.setOfSmartCards.create(smartCard2);
        this.setOfSmartCards.create(smartCard3);
        this.setOfSmartCards.create(smartCard4);
        this.setOfSmartCards.create(smartCard5);

    }

    @Override
    public void read()
    {

        for (BaseModel model : this.setOfSmartCards.all())
        {
            SmartCard smartCard = (SmartCard) model;

            System.out.println("SmartCardID: " + smartCard.id);
        }

    }

    @Override
    public void relationships()
    {
        SetOfUsers setOfUsers = new SetOfUsers();

        for (int i = 0; i < setOfUsers.all().size(); i++)
        {

            User user = (User) setOfUsers.all().get(i);

            this.users[i] = user.id;

        }
    }
}
