import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { ListParticipantsComponent } from './list-participants/list-participants.component';
import { CreateParticipantsComponent } from './create-participants/create-participants.component';
import { ListMatchesComponent } from './list-matches/list-matches.component';
import { AddMatchesComponent } from './add-matches/add-matches.component';
@NgModule({
  declarations: [
    AppComponent,
    CreateParticipantsComponent,
    ListParticipantsComponent,
    ListMatchesComponent,
    AddMatchesComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
