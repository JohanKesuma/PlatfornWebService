/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import com.google.gson.Gson;
import helper.KlinikHelper;
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
import pojos.Klinik;

/**
 * REST Web Service
 *
 * @author admin
 */
@Path("klinik")
public class KlinikResources {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of PasienResources
     */
    public KlinikResources() {
    }

    /**
     * Retrieves representation of an instance of services.PasienResources
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getJson() {
        KlinikHelper test = new KlinikHelper();
        List<Klinik> list = test.getKlinik();
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
    @Path("addKlinik")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addNewKlinik(String data){
        Gson gson = new Gson();
        Klinik klinik = gson.fromJson(data,Klinik.class);
        KlinikHelper klinikHelper = new KlinikHelper();
        klinikHelper.addNewKlinik(klinik.getIdKlinik(),
                klinik.getNama(),
                klinik.getSpesialis());
        return Response
                .status(200)
                .entity("Tambah Klinik Berhasil")
                .build();
    }
}

