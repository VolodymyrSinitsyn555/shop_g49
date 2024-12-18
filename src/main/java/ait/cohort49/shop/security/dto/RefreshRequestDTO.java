package ait.cohort49.shop.security.dto;

import java.util.Objects;

public class RefreshRequestDTO {
    private String refreshToken;

    public RefreshRequestDTO(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    @Override
    public String toString() {
        return String.format("Refresh request: refreshToken: %s", refreshToken);
    }

    public String getRefreshToken() {

        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    @Override
    public final boolean equals(Object o) {
        if (!(o instanceof RefreshRequestDTO that)) return false;

        return Objects.equals(refreshToken, that.refreshToken);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(refreshToken);
    }
}
