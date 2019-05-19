package com.elementsauth.tokenstore;

import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;

public class TokenStoreConfig {

    public TokenStore tokenStore() {
        return new InMemoryTokenStore();
    }

}
