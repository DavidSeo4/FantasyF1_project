import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-competitions-home',
  templateUrl: './competitions-home.component.html',
  styleUrls: ['./competitions-home.component.css']
})
export class CompetitionsHomeComponent implements OnInit {

  username: string; 

  constructor(private router: Router) {
   }

  ngOnInit() {
  }

  newLeagueRoute(){
    this.router.navigate(['/main/home/new']);
    const url = `/main/home/new?isdetail=true`;
    this.router.navigateByUrl(url);
  }

  searchPrivateRoute(){
    this.router.navigate(['/main/competitions/search']);
    const url = `/main/competitions/search?isdetail=true`;
    this.router.navigateByUrl(url);
  }

}
