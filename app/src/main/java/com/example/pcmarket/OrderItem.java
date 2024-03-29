package com.example.pcmarket;

public class OrderItem {
    String id_zamowionego_produktu;
    String id_zamowienia;
    String id_produktu;
    String ilosc;

    public OrderItem(String id_zamowionego_produktu, String id_zamowienia, String id_produktu, String ilosc) {
        this.id_zamowionego_produktu = id_zamowionego_produktu;
        this.id_zamowienia = id_zamowienia;
        this.id_produktu = id_produktu;
        this.ilosc = ilosc;
    }

    public String getId_zamowionego_produktu() {
        return id_zamowionego_produktu;
    }

    public void setId_zamowionego_produktu(String id_zamowionego_produktu) {
        this.id_zamowionego_produktu = id_zamowionego_produktu;
    }

    public String getId_zamowienia() {
        return id_zamowienia;
    }

    public void setId_zamowienia(String id_zamowienia) {
        this.id_zamowienia = id_zamowienia;
    }

    public String getId_produktu() {
        return id_produktu;
    }

    public void setId_produktu(String id_produktu) {
        this.id_produktu = id_produktu;
    }

    public String getIlosc() {
        return ilosc;
    }

    public void setIlosc(String ilosc) {
        this.ilosc = ilosc;
    }
}
