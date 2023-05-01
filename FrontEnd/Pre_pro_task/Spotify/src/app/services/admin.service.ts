import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AdminService {

  constructor(private client: HttpClient) { }

  trackAppBeBaseUrl = "http://localhost:24242/track-app";

  getAlltracks() {
    return this.client.get(this.trackAppBeBaseUrl + "/get-all-tracks");
  }

  getTrackById() {

  }

  addTrack(trackObj: any) {
    let httpHeaders = new HttpHeaders({
      'Authorization': 'Bearer ' + localStorage.getItem("jwt")
    });
    let requestOptions = { headers: httpHeaders }
    return this.client.post
      (this.trackAppBeBaseUrl + "/admin/add-new-track", trackObj, requestOptions);

  }

  updateTrack(trackObj: any) {
    {
      let httpHeaders = new HttpHeaders({
        'Authorization': 'Bearer ' + localStorage.getItem("jwt")
      });
      let requestOptions = { headers: httpHeaders }
      return this.client.put
        (this.trackAppBeBaseUrl + "/admin/update-track", trackObj, requestOptions);
    }
  }

  deleteTrack(trackId: any) {
    let httpHeaders = new HttpHeaders({
      'Authorization': 'Bearer ' + localStorage.getItem("jwt")
    });
    let requestOptions = { headers: httpHeaders }
    return this.client.delete(this.trackAppBeBaseUrl + "/admin/delete-track/" + trackId);


  }


























}
