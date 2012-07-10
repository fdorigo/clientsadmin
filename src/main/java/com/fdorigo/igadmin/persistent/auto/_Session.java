package com.fdorigo.igadmin.persistent.auto;

import java.util.Date;

import org.apache.cayenne.CayenneDataObject;

import com.fdorigo.igadmin.persistent.Client;
import com.fdorigo.igadmin.persistent.Package;
import com.fdorigo.igadmin.persistent.Trainer;

/**
 * Class _Session was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _Session extends CayenneDataObject {

    public static final String DATE_PROPERTY = "date";
    public static final String PRICE_PROPERTY = "price";
    public static final String TYPE_PROPERTY = "type";
    public static final String CLIENT_PROPERTY = "client";
    public static final String PACKAGE_PROPERTY = "package";
    public static final String TO_TRAINER_PROPERTY = "toTrainer";

    public static final String ID_PK_COLUMN = "ID";

    public void setDate(Date date) {
        writeProperty("date", date);
    }
    public Date getDate() {
        return (Date)readProperty("date");
    }

    public void setPrice(Double price) {
        writeProperty("price", price);
    }
    public Double getPrice() {
        return (Double)readProperty("price");
    }

    public void setType(String type) {
        writeProperty("type", type);
    }
    public String getType() {
        return (String)readProperty("type");
    }

    public void setClient(Client client) {
        setToOneTarget("client", client, true);
    }

    public Client getClient() {
        return (Client)readProperty("client");
    }


    public void setPackage(Package _package) {
        setToOneTarget("package", _package, true);
    }

    public Package getPackage() {
        return (Package)readProperty("package");
    }


    public void setToTrainer(Trainer toTrainer) {
        setToOneTarget("toTrainer", toTrainer, true);
    }

    public Trainer getToTrainer() {
        return (Trainer)readProperty("toTrainer");
    }


}
