package com.tathvatech.site.service;

import java.util.List;

public interface SiteService {
    void createSite(UserContext context, Site site) throws Exception;

    void updateSite(UserContext context, Site site) throws Exception;

    void deleteSite(UserContext context, int sitePk) throws Exception;

    Site getSite(int sitePk);

    Site getSiteByName(String siteName);

    List<Site> getSites(SiteFilter siteFilter);

    List<SiteQuery> getSiteList(SiteFilter siteFilter);

    void setLinkedSupplier(UserContext userContext, SiteOID siteOID,
                           SupplierOID supplierOID);

    SiteGroup saveSiteGroup(UserContext context, SiteGroup siteGroup) throws Exception;

    List<SiteGroup> getSiteGroupList();
}
