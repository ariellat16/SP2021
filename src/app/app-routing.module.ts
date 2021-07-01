import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { JacksonvilleComponent } from './jacksonville/jacksonville.component';
import { DallasComponent } from './dallas/dallas.component';

const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'jacksonville', component: JacksonvilleComponent },
  { path: 'dallas', component: DallasComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
