package shu.cssd.transportsystem.database.seeds;

import shu.cssd.transportsystem.foundation.BaseModel;
import shu.cssd.transportsystem.foundation.database.BaseSeeder;
import shu.cssd.transportsystem.models.Payment;
import shu.cssd.transportsystem.models.Permission;
import shu.cssd.transportsystem.models.User;
import shu.cssd.transportsystem.models.collections.SetOfPermissions;

public class PermissionLevelSeeder implements BaseSeeder {

    private SetOfPermissions setOfPermissions;

    @Override
    public void seed()
    {
        
        this.setOfPermissions = new SetOfPermissions();
        
        Permission permission1 = new Permission("Admin");
        Permission permission2 = new Permission("User");
        Permission permission3 = new Permission("Employee");


        this.setOfPermissions.create(permission1);
        this.setOfPermissions.create(permission2);
        this.setOfPermissions.create(permission3);
        
    }

    @Override
    public void read()
    {
        for (BaseModel model: this.setOfPermissions.all())
        {
            Permission permission = (Permission) model;

            System.out.println("PermissionID: " + permission.id + " PermissionUser: " +permission.getUsers());

        }
    }
    
    @Override
    public void relationships()
    {
    
    }
}
