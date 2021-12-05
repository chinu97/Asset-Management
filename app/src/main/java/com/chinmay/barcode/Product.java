package com.chinmay.barcode;


public class Product
{
    private String Asset;
    private String SNo;
    private String AssetWithSubNo;
    private String SerialNumber;
    private String SerialNumber2;
    private String CapitalDate;
    private String DepnDate;
    private String Plant;
    private String CostCenter;
    private String ProfitCenter;
    private String HFMCode;
    private String Clas;
    private String ClassDescription;
    private String LocationName;
    private String AssetGL;
    private String DepnGL;
    private String Location;
    private String Qty;
    private String Life;
    private String WDV;
    private String AssetDescription;
    private String GrossValue;




    public Product()
    {

    }

    public Product(String Asset1, String Sno1, String Awsn1,String Sno11, String Sno21, String cdate1, String Ddate1, String plant1, String ccenter1, String pcenter1, String hfm1, String cls1, String clsdes1, String locationName1, String assetgl1, String depngl1, String location1, String qty1,String life1,String WDV1,String assetDes1, String grossValue1)
    {
        this.Asset=Asset1;
        this.SNo=Sno1;
        this.AssetWithSubNo=Awsn1;
        this.SerialNumber=Sno11;
        this.SerialNumber2=Sno21;
        this.CapitalDate=cdate1;
        this.DepnDate=Ddate1;
        this.Plant=plant1;
        this.CostCenter=ccenter1;
        this.ProfitCenter=pcenter1;
        this.HFMCode=hfm1;
        this.Clas=cls1;
        this.ClassDescription=clsdes1;
        this.LocationName=locationName1;
        this.AssetGL=assetgl1;
        this.DepnGL=depngl1;
        this.Location=location1;

        this.Qty=qty1;
        this.Life=life1;
        this.WDV=WDV1;
        this.AssetDescription = assetDes1;
        this.GrossValue=grossValue1;

    }

    public String getAsset() {
        return Asset;
    }

    public String getSNo() {
        return SNo;
    }

    public String getAssetWithSubNo() {
        return AssetWithSubNo;
    }

    public String getSerialNumber() {
        return SerialNumber;
    }

    public String getSerialNumber2() {
        return SerialNumber2;
    }

    public String getCapitalDate() {
        return CapitalDate;
    }

    public String getDepnDate() {
        return DepnDate;
    }

    public String getPlant() {
        return Plant;
    }

    public String getCostCenter() {
        return CostCenter;
    }

    public String getProfitCenter() {
        return ProfitCenter;
    }

    public String getHFMCode() {
        return HFMCode;
    }

    public String getClas() {
        return Clas;
    }

    public String getClassDescription() {
        return ClassDescription;
    }

    public String getLocationName() {
        return LocationName;
    }

    public String getAssetGL() {
        return AssetGL;
    }

    public String getDepnGL() {
        return DepnGL;
    }

    public String getLocation() {
        return Location;
    }

    public String getQty() {
        return Qty;
    }

    public String getLife() {
        return Life;
    }

    public String getWDV() {
        return WDV;
    }

    public String getAssetDescription() {
        return AssetDescription;
    }

    public String getGrossValue() {
        return GrossValue;
    }






}