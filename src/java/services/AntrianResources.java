/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import com.google.gson.Gson;
import helper.AntrianHelper;
import java.util.Date;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import pojos.Antrian;

/**
 *
 * @author johan
 */

@Path("antrian")
public class AntrianResources {
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of PasienResources
     */
    public AntrianResources() {
    }

    /**
     * Retrieves representation of an instance of services.PasienResources
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getJson() {
        AntrianHelper test = new AntrianHelper();
        List<Antrian> list = test.getAntrian();
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
    @Path("addAntrian")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addNewAntrian(String data){
        Gson gson = new Gson();
        Antrian antrian = gson.fromJson(data,Antrian.class);
        AntrianHelper helper = new AntrianHelper();
        helper.addAntrian(antrian.getTanggal(),
                antrian.getNoRm(),
                antrian.getNama(),
                antrian.getAlamat(),
                antrian.getNamaKlinik());
        return Response
                .status(200)
                .entity(antrian)
                .build();
    }
    
    @GET
    @Path("cariAntrian")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAntrianJson(@QueryParam("tanggal") String tanggal) {
        AntrianHelper test = new AntrianHelper();
        List<Antrian> list = test.cariAntrian(tanggal);
        Gson gson = new Gson();
        String json = gson.toJson(list);
        return Response
                .status(200)
                .entity(json)
                .build();
    }
}
