import { Routes } from '@angular/router';
import { CountriesComponent } from './components/countries/countries.component';
import { CountryLanguagesComponent } from './components/country-languages/country-languages.component';

export const ROUTES: Routes = [
  { path: '', redirectTo: 'countries', pathMatch: 'full' },
  { path: 'countries', component: CountriesComponent },
  { path: 'countries/:id/languages', component: CountryLanguagesComponent },
  
];