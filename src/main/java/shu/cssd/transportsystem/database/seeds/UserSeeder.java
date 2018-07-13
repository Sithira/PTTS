package shu.cssd.transportsystem.database.seeds;

import shu.cssd.transportsystem.foundation.BaseModel;
import shu.cssd.transportsystem.foundation.database.BaseSeeder;
import shu.cssd.transportsystem.models.User;
import shu.cssd.transportsystem.models.collections.SetOfUsers;

public class UserSeeder implements BaseSeeder {

    private SetOfUsers setOfUsers = new SetOfUsers();

    @Override
    public void seed()
    {
        User user1 = new User.UserCreator(
                "Sithira",
                "sithiraac@gmail.com",
                "Rukmalgama",
                "Kottawa",
                "10230",
                "sithira",
                "admin").create();

        User user2 = new User.UserCreator(
                "Sanura",
                "sanuwijay94@gmail.com",
                "Makumbura",
                "Kottawa",
                "10230",
                "sanura",
                "admin").create();

        User user3 = new User.UserCreator(
                "Dinusha",
                "dinusha.jayashan01@gmail.com",
                "Hokandara Road, Pannipitiya",
                "Pannipitiya",
                "10230",
                "dinusha",
                "admin").create();

        User user4 = new User.UserCreator(
                "Chathu",
                "chathu@gmail.com",
                "Bambalapiitya",
                "Colombo",
                "10230",
                "chathu",
                "admin").addAsEmployee(35000,
                                                 "e0e6c973-b419-48cd-8280-aac0bb5f190c").create();

        this.setOfUsers.create(user1);
        this.setOfUsers.create(user2);
        this.setOfUsers.create(user3);
        this.setOfUsers.create(user4);

        read();
    }

    @Override
    public void read()
    {
        for (BaseModel model: this.setOfUsers.all())
        {
            User user = (User) model;

            System.out.println("UserID: " + user.id + " Name: " + user.name);

        }
    }

}
