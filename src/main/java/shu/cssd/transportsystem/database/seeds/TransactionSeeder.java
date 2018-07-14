package shu.cssd.transportsystem.database.seeds;

import shu.cssd.transportsystem.foundation.BaseModel;
import shu.cssd.transportsystem.foundation.database.BaseSeeder;
import shu.cssd.transportsystem.models.Transaction;
import shu.cssd.transportsystem.models.collections.SetOfTransactions;

public class TransactionSeeder implements BaseSeeder {

    private SetOfTransactions setOfTransactions = new SetOfTransactions();

    @Override
    public void seed()
    {
        Transaction transaction1 = new Transaction.TransactionCreator("1", "").create();
        Transaction transaction2 = new Transaction.TransactionCreator("2", "").create();
        Transaction transaction3 = new Transaction.TransactionCreator("3", "").create();
        Transaction transaction4 = new Transaction.TransactionCreator("4", "").create();


        this.setOfTransactions.create(transaction1);
        this.setOfTransactions.create(transaction2);
        this.setOfTransactions.create(transaction3);
        this.setOfTransactions.create(transaction4);

        read();
    }

    @Override
    public void read()
    {
        for (BaseModel model: this.setOfTransactions.all())
        {
            Transaction transaction = (Transaction) model;

            System.out.println("TransacctionID: " + transaction.id);

        }
    }
    
    @Override
    public void relationships()
    {
    
    }
}
