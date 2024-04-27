package com.hcltech.hackaton.squadten.portfoliomanagement.api.portfolio.domain;

public class Position {
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPorfolio_id() {
        return porfolio_id;
    }

    public void setPorfolio_id(int porfolio_id) {
        this.porfolio_id = porfolio_id;
    }

    public int getInstrument_id() {
        return instrument_id;
    }

    public void setInstrument_id(int instrument_id) {
        this.instrument_id = instrument_id;
    }

    private int porfolio_id;
    private int instrument_id;
}
