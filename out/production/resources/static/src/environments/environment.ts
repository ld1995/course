export const environment = {
  production: false,
  requestedScopes: 'openid profile write:user',
  configAuth0 : {
    clientID: 'NTEBZd6RcvU8vl87rB4KPgzW5C7FvTEs',
    domain: 'ld1995.eu.auth0.com',
    responseType: 'token id_token',
    audience: 'spring-boot-jwts',
    redirectUri: 'http://localhost:4200',
    scope: 'openid profile write:user'//this.requestedScopes
  },
  webServiceEndpoint : 'http://localhost:8080/api'
};
