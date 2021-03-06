package com.fdorigo.igadmin.persistent.auto;

import java.util.Date;
import java.util.List;

import org.apache.cayenne.CayenneDataObject;

import com.fdorigo.igadmin.persistent.Location;
import com.fdorigo.igadmin.persistent.Package;
import com.fdorigo.igadmin.persistent.Session;
import com.fdorigo.igadmin.persistent.Trainer;

/**
 * Class _Client was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _Client extends CayenneDataObject {

    public static final String ADDRESS_APT_PROPERTY = "addressApt";
    public static final String ADDRESS_CITY_PROPERTY = "addressCity";
    public static final String ADDRESS_NUM_PROPERTY = "addressNum";
    public static final String ADDRESS_STATE_PROPERTY = "addressState";
    public static final String ADDRESS_STREET_PROPERTY = "addressStreet";
    public static final String ADDRESS_ZIP_PROPERTY = "addressZip";
    public static final String DATE_BIRTH_PROPERTY = "dateBirth";
    public static final String DATE_JOINED_PROPERTY = "dateJoined";
    public static final String EMAIL_ADDRESS_PROPERTY = "emailAddress";
    public static final String NAME_FIRST_PROPERTY = "nameFirst";
    public static final String NAME_LAST_PROPERTY = "nameLast";
    public static final String NAME_MIDDLE_PROPERTY = "nameMiddle";
    public static final String PHONE_PRIMARY_PROPERTY = "phonePrimary";
    public static final String PHONE_SECONDARY_PROPERTY = "phoneSecondary";
    public static final String LOCATION_PROPERTY = "location";
    public static final String PACKAGES_PROPERTY = "packages";
    public static final String SESSIONS_PROPERTY = "sessions";
    public static final String TRAINER_PROPERTY = "trainer";

    public static final String ID_PK_COLUMN = "ID";

    public void setAddressApt(String addressApt) {
        writeProperty("addressApt", addressApt);
    }
    public String getAddressApt() {
        return (String)readProperty("addressApt");
    }

    public void setAddressCity(String addressCity) {
        writeProperty("addressCity", addressCity);
    }
    public String getAddressCity() {
        return (String)readProperty("addressCity");
    }

    public void setAddressNum(String addressNum) {
        writeProperty("addressNum", addressNum);
    }
    public String getAddressNum() {
        return (String)readProperty("addressNum");
    }

    public void setAddressState(String addressState) {
        writeProperty("addressState", addressState);
    }
    public String getAddressState() {
        return (String)readProperty("addressState");
    }

    public void setAddressStreet(String addressStreet) {
        writeProperty("addressStreet", addressStreet);
    }
    public String getAddressStreet() {
        return (String)readProperty("addressStreet");
    }

    public void setAddressZip(String addressZip) {
        writeProperty("addressZip", addressZip);
    }
    public String getAddressZip() {
        return (String)readProperty("addressZip");
    }

    public void setDateBirth(Date dateBirth) {
        writeProperty("dateBirth", dateBirth);
    }
    public Date getDateBirth() {
        return (Date)readProperty("dateBirth");
    }

    public void setDateJoined(Date dateJoined) {
        writeProperty("dateJoined", dateJoined);
    }
    public Date getDateJoined() {
        return (Date)readProperty("dateJoined");
    }

    public void setEmailAddress(String emailAddress) {
        writeProperty("emailAddress", emailAddress);
    }
    public String getEmailAddress() {
        return (String)readProperty("emailAddress");
    }

    public void setNameFirst(String nameFirst) {
        writeProperty("nameFirst", nameFirst);
    }
    public String getNameFirst() {
        return (String)readProperty("nameFirst");
    }

    public void setNameLast(String nameLast) {
        writeProperty("nameLast", nameLast);
    }
    public String getNameLast() {
        return (String)readProperty("nameLast");
    }

    public void setNameMiddle(String nameMiddle) {
        writeProperty("nameMiddle", nameMiddle);
    }
    public String getNameMiddle() {
        return (String)readProperty("nameMiddle");
    }

    public void setPhonePrimary(String phonePrimary) {
        writeProperty("phonePrimary", phonePrimary);
    }
    public String getPhonePrimary() {
        return (String)readProperty("phonePrimary");
    }

    public void setPhoneSecondary(String phoneSecondary) {
        writeProperty("phoneSecondary", phoneSecondary);
    }
    public String getPhoneSecondary() {
        return (String)readProperty("phoneSecondary");
    }

    public void setLocation(Location location) {
        setToOneTarget("location", location, true);
    }

    public Location getLocation() {
        return (Location)readProperty("location");
    }


    public void addToPackages(Package obj) {
        addToManyTarget("packages", obj, true);
    }
    public void removeFromPackages(Package obj) {
        removeToManyTarget("packages", obj, true);
    }
    @SuppressWarnings("unchecked")
    public List<Package> getPackages() {
        return (List<Package>)readProperty("packages");
    }


    public void addToSessions(Session obj) {
        addToManyTarget("sessions", obj, true);
    }
    public void removeFromSessions(Session obj) {
        removeToManyTarget("sessions", obj, true);
    }
    @SuppressWarnings("unchecked")
    public List<Session> getSessions() {
        return (List<Session>)readProperty("sessions");
    }


    public void setTrainer(Trainer trainer) {
        setToOneTarget("trainer", trainer, true);
    }

    public Trainer getTrainer() {
        return (Trainer)readProperty("trainer");
    }


}
