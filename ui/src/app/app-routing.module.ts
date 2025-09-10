// import { NgModule } from '@angular/core';
// import { RouterModule, Routes } from '@angular/router';
// import { CountryLanguagesComponent } from './components/country-languages/country-languages.component';
// import { CountriesComponent } from './components/countries/countries.component';

// const routes: Routes = [
  
//   { path: 'countries/:id/languages', component: CountryLanguagesComponent },
//   { path: 'countries', component: CountriesComponent },
//   { path: '', redirectTo: 'countries', pathMatch: 'full' },
// ];

// @NgModule({
//   imports: [RouterModule.forRoot(routes)], // 👈 configure routes
//   exports: [RouterModule]                  // 👈 export RouterModule so AppModule can use it
// })
// export class AppRoutingModule {}

import { Routes } from '@angular/router';
import { CountriesComponent } from './components/countries/countries.component';
import { CountryLanguagesComponent } from './components/country-languages/country-languages.component';

export const ROUTES: Routes = [
  { path: 'countries/:id/languages', component: CountryLanguagesComponent },
  { path: 'countries', component: CountriesComponent },
  { path: '', redirectTo: 'countries', pathMatch: 'full' },
];