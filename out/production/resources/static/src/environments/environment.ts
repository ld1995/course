export const environment = {
  production: false,
  requestedScopes: 'openid profile write:user',
  configFirebase : {
    apiKey: 'AIzaSyDNB4_bEwPu_tWqlCKWWBWERa0t8apmFtY',
    authDomain: 'file-upload-4cd87.firebaseapp.com',
    databaseURL: 'https://file-upload-4cd87.firebaseio.com',
    projectId: 'file-upload-4cd87',
    storageBucket: 'file-upload-4cd87.appspot.com',
    messagingSenderId: '178178725598'
  },
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
