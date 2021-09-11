package be.jorisgulinck.domoticaspringbackend.models.user;

import lombok.RequiredArgsConstructor;

import java.io.Serializable;

@RequiredArgsConstructor
public class AuthenticationResponse implements Serializable
{
    private final String jwttoken;

    public String getToken() {
        return this.jwttoken;
    }
}
