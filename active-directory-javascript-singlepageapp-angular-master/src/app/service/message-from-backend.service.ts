import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MessageFromBackendService {

  constructor(private httpClient:HttpClient) { }

  getMessageFromBackend():Observable<string>{
    return this.httpClient.get<string>('http://localhost:8085/messageFromBackend', {headers : this.getAuthorisationHeader()});
  }

  getAuthorisationHeader():HttpHeaders{
    let headerValue = 'Bearer ' + sessionStorage.getItem('msal.idtoken');
    
    return new HttpHeaders({Authorization: headerValue});
  }
}
