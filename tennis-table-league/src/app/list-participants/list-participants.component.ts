import { Component, OnInit } from '@angular/core';
import { Observable } from "rxjs";
import { ParticipantsService } from '../participants.service';
import { Participants } from '../Participants';
import { Router } from '@angular/router';


@Component({
  selector: 'app-list-participants',
  templateUrl: './list-participants.component.html',
  styleUrls: ['./list-participants.component.css']
})
export class ListParticipantsComponent implements OnInit {

  listOfParticipants: Observable<Participants[]>;

  constructor(private participantsService: ParticipantsService,
    private router: Router) {}

  ngOnInit() {
    this.reloadData();
  }

  reloadData() {
    this.listOfParticipants = this.participantsService.getParticipantsList();
  }

  deleteParticipants(participantsId: number) {
    this.participantsService.deleteParticipants(participantsId)
      .subscribe(
        data => {
          console.log(data);
          this.reloadData();
        },
        error => console.log(error));
  }

  searchParticipants(teamName: string) {
    this.participantsService.searchParticipants(teamName)
      .subscribe(
        data => {
          console.log(data);
          this.reloadData();
        },
        error => console.log(error));
  }

}
