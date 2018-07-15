package shu.cssd.transportsystem.database.seeds;

import shu.cssd.transportsystem.foundation.BaseModel;
import shu.cssd.transportsystem.foundation.database.BaseSeeder;
import shu.cssd.transportsystem.models.Permission;
import shu.cssd.transportsystem.models.User;
import shu.cssd.transportsystem.models.collections.SetOfPermissions;
import shu.cssd.transportsystem.models.collections.SetOfUsers;

public class UserSeeder implements BaseSeeder {

    private SetOfUsers setOfUsers = new SetOfUsers();

    private  String [] permissions = new String[5];

    @Override
    public void seed()
    {
        User user1 = new User.Builder(
                "Sithira",
                "sithiraac@gmail.com",
                "Rukmalgama",
                "Kottawa",
                "10230",
                "sithira",
                "admin").create();

        User user2 = new User.Builder(
                "Sanura",
                "sanuwijay94@gmail.com",
                "Makumbura",
                "Kottawa",
                "10230",
                "sanura",
                "admin").create();

        User user3 = new User.Builder(
                "Dinusha",
                "dinusha.jayashan01@gmail.com",
                "Hokandara Road, Pannipitiya",
                "Pannipitiya",
                "10230",
                "dinusha",
                "admin").create();

        User user4 = new User.Builder(
                "Chathu",
                "chathu@gmail.com",
                "Bambalapiitya",
                "Colombo",
                "10230",
                "chathu",
                "admin").addAsEmployee(35000, permissions[3]).create();

        User user5 = new User.Builder(
                "Vindula",
                "vindu@gmail.com",
                "Kotte",
                "Colombo",
                "10230",
                "vindula",
                "admin").create();


        this.setOfUsers.create(user1);
        this.setOfUsers.create(user2);
        this.setOfUsers.create(user3);
        this.setOfUsers.create(user4);
        this.setOfUsers.create(user5);

    }

    @Override
    public void read()
    {

        for (BaseModel model: this.setOfUsers.all())
        {
            User user = (User) model;

            System.out.println("UserID: " + user.id + " Name: " + user.name);

            System.out.println("Employee_PermissionID: " + user.permission_id);

        }
    }

    @Override
    public void relationships()
    {
        SetOfPermissions setOfPermissions = new SetOfPermissions();
        SetOfUsers setOfUsers = new SetOfUsers();

	    System.out.println("PERM SIZE: " + setOfPermissions.all().size());

        for (int i = 0; i < setOfUsers.all().size(); i++)
        {

			//User user = (User) this.setOfUsers.all().get(i);

            Permission permission = (Permission) setOfPermissions.all().get(i);

			this.permissions[i] = permission.id;
			//user.permission_id = setOfPermissions.all().get(i).id;
			
        }
    }

}

