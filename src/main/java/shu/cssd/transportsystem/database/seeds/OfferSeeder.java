package shu.cssd.transportsystem.database.seeds;

import shu.cssd.transportsystem.foundation.BaseModel;
import shu.cssd.transportsystem.foundation.database.BaseSeeder;
import shu.cssd.transportsystem.models.Offer;
import shu.cssd.transportsystem.models.collections.SetOfOffers;

public class OfferSeeder implements BaseSeeder
{
    private SetOfOffers setOfOffers = new SetOfOffers();

    @Override
    public void seed()
    {
        Offer offer1 = new Offer("All day offer", 3, 0.2F);
        Offer offer2 = new Offer("All day offer", 5, 0.5F);
        Offer offer3 = new Offer("All day offer", 7, 0.6F);

        this.setOfOffers.create(offer1);
        this.setOfOffers.create(offer2);
        this.setOfOffers.create(offer3);

        read();
    }

    @Override
    public void read()
    {
        for (BaseModel model: this.setOfOffers.all())
        {
            Offer offer = (Offer) model;

            System.out.println("OfferID: " + offer.id);

        }
    }

    @Override
    public void relationships() {

    }
}
