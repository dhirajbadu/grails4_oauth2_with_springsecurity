package com.session

public class AccessLevel implements Serializable {
    private static final long serialVersionUID = 1;

    private String logo;

    private String companyName;

    private Map<Long , String> siteMap;

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Map<Long, String> getSiteMap() {
        return siteMap;
    }

    public void setSiteMap(Map<Long, String> siteMap) {
        this.siteMap = siteMap;
    }
}
