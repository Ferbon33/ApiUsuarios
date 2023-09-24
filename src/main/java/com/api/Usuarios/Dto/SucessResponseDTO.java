package com.api.Usuarios.Dto;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "user",
        "id",
        "created",
        "modified",
        "last_login",
        "token",
        "isactive"
})

public class SucessResponseDTO extends BaseDTO {

    @JsonProperty("user")
    private String user;
    @JsonProperty("id")
    private Long id;
    @JsonProperty("created")
    private LocalDateTime created;
    @JsonProperty("modified")
    private LocalDateTime modified;
    @JsonProperty("last_login")
    private LocalDateTime lastLogin;
    @JsonProperty("token")
    private String token;
    @JsonProperty("isactive")
    private boolean isactive;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("user")
    public String getUser() {
        return user;
    }

    @JsonProperty("user")
    public void setUser(String user) {
        this.user = user;
    }

    @JsonProperty("id")
    public Long getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Long id) {
        this.id = id;
    }

    @JsonProperty("created")
    public LocalDateTime getCreated() {
        return created;
    }

    @JsonProperty("created")
    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    @JsonProperty("modified")
    public LocalDateTime getModified() {
        return modified;
    }

    @JsonProperty("modified")
    public void setModified(LocalDateTime modified) {
        this.modified = modified;
    }

    @JsonProperty("last_login")
    public LocalDateTime getLastLogin() {
        return lastLogin;
    }

    @JsonProperty("last_login")
    public void setLastLogin(LocalDateTime lastLogin) {
        this.lastLogin = lastLogin;
    }

    @JsonProperty("token")
    public String getToken() {
        return token;
    }

    @JsonProperty("token")
    public void setToken(String token) {
        this.token = token;
    }

    @JsonProperty("isactive")
    public boolean getIsactive() {
        return isactive;
    }

    @JsonProperty("isactive")
    public void setIsactive(boolean isactive) {
        this.isactive = isactive;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }
}
