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
                "s",
                "s",
                "s",
                "s",
                "s",
                "s",
                "s").create();

        this.setOfUsers.create(user1);

        read();
    }

    @Override
    public void read()
    {
        for (BaseModel model: this.setOfUsers.all())
        {
            User user = (User) model;

            System.out.println("UserID: " + user.id);

        }
    }

}
