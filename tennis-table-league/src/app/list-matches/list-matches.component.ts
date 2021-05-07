import { Component, OnInit } from '@angular/core';
import { Observable } from "rxjs";
import { MatchesService } from '../matches.service';
import { Matches } from '../Matches';
import { Router } from '@angular/router';

@Component({
  selector: 'app-list-matches',
  templateUrl: './list-matches.component.html',
  styleUrls: ['./list-matches.component.css']
})
export class ListMatchesComponent implements OnInit {

  listOfPlayer: Observable<Matches[]>;

  constructor(private matchesService: MatchesService,
    private router: Router) {}

  ngOnInit() {
    this.reloadData();
  }
  
  reloadData() {
    this.listOfPlayer = this.matchesService.getMatchesList();
  }

  updateMatch(matchId: number){
    this.router.navigate(['update', matchId]);
  }
}
