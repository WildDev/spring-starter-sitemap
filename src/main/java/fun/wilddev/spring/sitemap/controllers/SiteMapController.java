package fun.wilddev.spring.sitemap.controllers;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import fun.wilddev.spring.sitemap.conf.Mappers;
import fun.wilddev.spring.sitemap.xml.basic.XmlSiteMap;
import fun.wilddev.spring.sitemap.xml.basic.mappers.XmlDynamicSiteMapEntryMapper;
import fun.wilddev.spring.web.controllers.AbstractController;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.http.ResponseEntity;

import fun.wilddev.spring.sitemap.api.*;
import org.springframework.web.bind.annotation.*;

/**
 * Sitemap endpoint controller
 */
@ConditionalOnProperty(name = "sitemap.endpoint.enabled", matchIfMissing = true)
@RequestMapping("/sitemap")
@RestController
public class SiteMapController extends AbstractController {

    /**
     * Server response mapper
     */
    private final XmlMapper xmlMapper;

    /**
     * Sitemap entries mapper
     */
    private final XmlDynamicSiteMapEntryMapper xmlDynamicSiteMapEntryMapper;

    /**
     * {@link SiteMapLoader} reference
     */
    private final SiteMapLoader siteMapLoader;

    /**
     * All-args constructor
     *
     * @param xmlMapper - server response mapper
     * @param xmlDynamicSiteMapEntryMapper - sitemap entries mapper
     * @param siteMapLoader - {@link SiteMapLoader} reference
     */
    public SiteMapController(@Qualifier(Mappers.XML_MAPPER) XmlMapper xmlMapper,
                             XmlDynamicSiteMapEntryMapper xmlDynamicSiteMapEntryMapper,
                             SiteMapLoader siteMapLoader) {

        this.xmlMapper = xmlMapper;
        this.xmlDynamicSiteMapEntryMapper = xmlDynamicSiteMapEntryMapper;
        this.siteMapLoader = siteMapLoader;
    }

    /**
     * Exposes xml sitemap
     *
     * @return xml sitemap
     * @throws Exception - is expected to be thrown for unhandled errors
     */
    @GetMapping(value = "/xml", produces = "application/xml")
    public ResponseEntity<?> getSiteMapXml() throws Exception {

        List<SiteMapEntry> list = siteMapLoader.load();

        return list == null ? notFound() : ok(xmlMapper.writeValueAsString(
                new XmlSiteMap(list.stream().map(xmlDynamicSiteMapEntryMapper::map).toList())));
    }
}
