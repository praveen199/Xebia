import { ParticipantsService } from '../participants.service';
import { Participants } from '../Participants';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-participants',
  templateUrl: './create-participants.component.html',
  styleUrls: ['./create-participants.component.css']
})
export class CreateParticipantsComponent implements OnInit {

  participants: Participants = new Participants();
  submitted = false;

  constructor(private participantsService: ParticipantsService,
    private router: Router) { }

  ngOnInit() {
  }

  newParticipants(): void {
    this.submitted = false;
    this.participants = new Participants();
  }

  save() {
    this.participantsService.createParticipants(this.participants).subscribe(data => {
      console.log(data)
      this.participants = new Participants();
      //this.gotoList();
    }, 
    error => console.log(error));
  }

  onSubmit() {
    this.submitted = true;
    this.save();    
  }

  gotoList() {
    this.router.navigate(['/listOfParticipants']);
  }

}
