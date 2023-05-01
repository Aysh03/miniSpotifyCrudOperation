import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AdminService } from '../services/admin.service';
import { UserService } from '../services/user.service';

@Component({
  selector: 'app-playing',
  templateUrl: './playing.component.html',
  styleUrls: ['./playing.component.css'],
})
export class PlayingComponent implements OnInit {
  constructor(private userSer: UserService,
    private adminSer: AdminService,
    private _route: Router) {}

  ngOnInit(): void {
    this.song = this.userSer.currentSong;
    this.getUserDetails();
    // this.userSer.direcTto();
  }

  song: any;


  userDetails: any;
  getUserDetails() {
    this.userSer.getUserDetails().subscribe((response) => {
      console.log(response);
      this.userDetails = response;
    });
  }

// playSong()
// {
//   this.song = this.userSer.currentSong;
// }











  
}
