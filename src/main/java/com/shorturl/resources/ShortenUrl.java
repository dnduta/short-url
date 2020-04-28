package com.shorturl.resources;

import com.shorturl.entities.ShortUrl;
import com.shorturl.models.Shorter;
import com.shorturl.services.UrlShortener;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.NetworkInterface;
import java.net.URI;
import java.util.Enumeration;
import java.util.Iterator;

@Path("/short-url")
public class ShortenUrl {

    @Autowired
    private UrlShortener urlShortener;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response shorten(@QueryParam("url") String url) throws Exception
    {
        return Response.status(Response.Status.OK).entity(new Shorter("http://localhost:8080/"+urlShortener.saveUrl(url).getKey())).build();
    }

    @GET
    @Path("/{hash}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUrl(@PathParam("hash") String hash) throws Exception
    {
        ShortUrl url = urlShortener.getUrl(hash);
        return Response.temporaryRedirect( new URI(url.getOriginal())).build();
    }

}
