package nl.hu.bep.battlesnake.webservices;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import nl.hu.bep.battlesnake.model.GameInformation;

import javax.json.Json;
import javax.json.JsonReader;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.StringReader;
import java.util.Map;

class MoveResponse {
    public String move;
    public String shout;

    public MoveResponse(String move, String shout) {
        this.move = move;
        this.shout = shout;
    }
}

@JsonIgnoreProperties(ignoreUnknown = true)
class BattlesnakeRequest {
    public int turn;
    public Map<String, Object> you;
}


@Path("/snake")
public class BattlesnakeResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getGameInfo() {
        GameInformation info = new GameInformation();
        info.setAuthor("bartvaneijkelenburg");

        return Response.ok(info).build();
    }

    @POST
    @Path("/start")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response startGame() {

        return Response.ok().build();
    }

    @POST
    @Path("/move")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response moveSnake(BattlesnakeRequest request) {
        System.out.println("Snake: " + request.you.get("name"));

        MoveResponse move = new MoveResponse("up", "Going up!");
        return Response.ok(move).build();
    }

    @POST
    @Path("/end")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response endGame() {

        return Response.ok().build();
    }
}
