import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ParticipantsService {

  private baseUrl = 'http://localhost:8081/participants';

  constructor(private http: HttpClient) { }
 
  createParticipants(participants: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl}`+`/add/request`,participants);
  }

  getParticipantsList(): Observable<any> {
    return this.http.get(`${this.baseUrl}`+`/list/all`);
  }

  /*getEmployee(id: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/${id}`)`;
  }
  updateEmployee(id: number, value: any): Observable<Object> {
    return this.http.put(`${this.baseUrl}/${id}`, value);
  }
*/
  deleteParticipants(participantsId: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}`+`/remove/${participantsId}`, { responseType: 'text' });
  }

  searchParticipants(teamname: string): Observable<any> {
    return this.http.get(`${this.baseUrl}`+`/search/teamname/${teamname}`);
  }

  
}
