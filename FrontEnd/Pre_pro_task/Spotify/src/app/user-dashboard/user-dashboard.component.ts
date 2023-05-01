import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AdminService } from '../services/admin.service';
import { UserService } from '../services/user.service';

@Component({
  selector: 'app-user-dashboard',
  templateUrl: './user-dashboard.component.html',
  styleUrls: ['./user-dashboard.component.css'],
})
export class UserDashboardComponent implements OnInit {
  constructor(
    private userSer: UserService,
    private adminSer: AdminService,
    private _route: Router
  ) {
    this.getAlltracks();
  }

  ngOnInit(): void {}

  addTrackToUserPlay(trackObj: any) {
    console.log(trackObj);

    this.userSer.addTrackToUserPlaylist(trackObj).subscribe((response) => {
      this.getUserDetails();
      // this.directToPlay();
    });
  }

  userDetails: any;
  getUserDetails() {
    this.userSer.getUserDetails().subscribe((response) => {
      console.log(response);
      this.userDetails = response;
    });
  }

  allTracks: any;

  getAlltracks() {
    this.adminSer.getAlltracks().subscribe((response) => {
      this.allTracks = response;
    });
  }

  
  directToPlay() {
    this.userSer.direcTto()
    this.getUserDetails();
    this._route.navigate(['play']);
    };
  

    addTrackToUserPla(trackObj: any)
    {

    }

  setSong(s: any) {
    this.userSer.currentSong = s;
    this._route.navigate(['play']);
  }
}
