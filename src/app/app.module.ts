import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavComponent } from './nav/nav.component';
import { JacksonvilleComponent } from './jacksonville/jacksonville.component';
import { DallasComponent } from './dallas/dallas.component';
import { HomeComponent } from './home/home.component';
import { ReactiveFormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    NavComponent,
    JacksonvilleComponent,
    DallasComponent,
    HomeComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
    HttpClientModule,
    ReactiveFormsModule  // <- Add here
  ],
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
