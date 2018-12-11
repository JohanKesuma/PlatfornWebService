/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import com.google.gson.Gson;
import helper.DokterHelper;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import pojos.Dokter;

/**
 * REST Web Service
 *
 * @author admin
 */
@Path("dokter")
public class DokterResources {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of PasienResources
     */
    public DokterResources() {
    }

    /**
     * Retrieves representation of an instance of services.PasienResources
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getJson() {
        DokterHelper test = new DokterHelper();
        List<Dokter> list = test.getDokter();
        Gson gson = new Gson();
        String json = gson.toJson(list);
        return Response
                .status(200)
                .entity(json)
                .build();
    }

    /**
     * PUT method for updating or creating an instance of PasienResources
     * @param content representation for the resource
     */
//    @PUT
//    @Consumes(MediaType.APPLICATION_JSON)
//    public void putJson(String content) {
//    }
    
    @POST
    @Path("addDokter")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addNewDokter(String data){
        Gson gson = new Gson();
        Dokter dokter = gson.fromJson(data,Dokter.class);
        DokterHelper dokterHelper = new DokterHelper();
        dokterHelper.addNewDokter(dokter.getNama(),
                dokter.getSpesialis());
        return Response
                .status(200)
                .entity(dokter)
                .build();
    }
    
    @POST
    @Path("updateDokter")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateDokter(String data){
        Gson gson = new Gson();
        Dokter dokter = gson.fromJson(data,Dokter.class);
        DokterHelper dokterHelper = new DokterHelper();
        dokterHelper.updateDokter(dokter.getId(),
                dokter.getNama(),
                dokter.getSpesialis());
        return Response
                .status(200)
                .entity(dokter)
                .build();
    }
}

