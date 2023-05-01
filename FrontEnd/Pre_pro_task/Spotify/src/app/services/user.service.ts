import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { AuthService } from './auth.service';

@Injectable({
  providedIn: 'root',
})
export class UserService {
  constructor(private client: HttpClient, private auth: AuthService) {}

  authAppBeBaseUrl = 'http://localhost:5555/auth-app';
  productAppBeBaseUrl = 'http://localhost:24242/track-app';

  currentSong: any;

  addSongToPlaylist: any;
  registerUser(signupdata: any) {
    return this.client.post(
      this.authAppBeBaseUrl + '/register-user1',
      signupdata
    );
  }

  loginCheck(logindata: any) {
    return this.client.post(this.authAppBeBaseUrl + '/login-check', logindata);
  }

  getUserDetails() {
    let httpHeaders = new HttpHeaders({
      Authorization: 'Bearer ' + localStorage.getItem('jwt'),
    });
    let requestOptions = { headers: httpHeaders };
    return this.client.get(
      this.productAppBeBaseUrl + '/get-user-details',
      requestOptions
    );
  }

  addTrackToUserPlaylist(productObj: any) {
    let httpHeaders = new HttpHeaders({
      Authorization: 'Bearer ' + localStorage.getItem('jwt'),
    });
    let requestOptions = { headers: httpHeaders };
    return this.client.post(
      this.productAppBeBaseUrl + '/add-track-to-user',
      productObj,
      requestOptions
    );
  }

  deleteTrackByUser(trackId: any) {
    let httpHeaders = new HttpHeaders({
      Authorization: 'Bearer ' + localStorage.getItem('jwt'),
    });
    let requestOptions = { headers: httpHeaders };
    return this.client.post(
      this.productAppBeBaseUrl + '/delete-track-by-user',
      trackId,
      requestOptions
    );
  }
  direcTto() {
    this.addSongToPlaylist;
  }
}
