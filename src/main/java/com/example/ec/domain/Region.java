package com.example.ec.domain;

/**
 * Created by Ext-MayukhG on 7/26/2018.
 */
public enum Region {
    Central_Coast("Central Coast"), Southern_California("Southern California"), Northern_California("Northern California"), Varies("Varies");
    private String label;

    Region(String label) {
        this.label = label;
    }

    public static Region findByLabel(String byLabel) {
        for (Region r:Region.values()) {
            if(r.label.equalsIgnoreCase(byLabel))
                return r;
        }
        return null;
    }
}
