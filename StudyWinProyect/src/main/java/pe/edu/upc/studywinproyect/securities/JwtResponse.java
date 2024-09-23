package pe.edu.upc.studywinproyect.securities;

import java.io.Serial;
import java.io.Serializable;

/*
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

clase 5
@AllArgsConstructor
@Getter*/
public class JwtResponse implements Serializable {

    @Serial
    private static final long serialVersionUID = -8091879091924046844L;
    private final String jwttoken;

    public String getJwttoken() {
        return jwttoken;
    }

    public JwtResponse(String jwttoken) {
        super();
        this.jwttoken = jwttoken;
    }

}