import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CreateParticipantsComponent } from './create-participants/create-participants.component';
import { ListParticipantsComponent } from './list-participants/list-participants.component';
import { ListMatchesComponent } from './list-matches/list-matches.component';
import { AddMatchesComponent } from './add-matches/add-matches.component';

const routes: Routes = [
  { path: '', redirectTo: 'participants', pathMatch: 'full' },
  { path: 'addParticipants', component: CreateParticipantsComponent },
  { path: 'listOfParticipants', component: ListParticipantsComponent },
  { path: 'listOfPlayer', component: ListMatchesComponent },
  { path: 'addMatch', component: AddMatchesComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
