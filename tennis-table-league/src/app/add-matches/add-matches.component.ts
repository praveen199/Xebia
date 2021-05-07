import { Component, OnInit } from '@angular/core';
import { Observable } from "rxjs";
import { MatchesService } from '../matches.service';
import { Matches } from '../Matches';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-matches',
  templateUrl: './add-matches.component.html',
  styleUrls: ['./add-matches.component.css']
})
export class AddMatchesComponent implements OnInit {

  matches: Matches = new Matches();
  submitted = false;

  constructor(private matchesService: MatchesService,
    private router: Router) {}

  ngOnInit() {
  }
  onSubmit() {
    this.submitted = true;
    this.save();    
  }

  save() {
    this.matchesService.createMatches(this.matches).subscribe(data => {
      console.log(data)
      this.matches = new Matches();
      //this.gotoList();
    }, 
    error => console.log(error));
  }
}